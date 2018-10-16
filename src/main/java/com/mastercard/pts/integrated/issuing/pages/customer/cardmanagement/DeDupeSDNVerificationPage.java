package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {  CardManagementNav.L1_ACTIVITY,CardManagementNav.L2_DE_DUPE_SDN_VERIFICATION })
public class DeDupeSDNVerificationPage extends AbstractCardManagementPage {

	private static final Logger logger = LoggerFactory
			.getLogger(DeDupeSDNVerificationPage.class);
	
	@Autowired
	TestContext context;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=applicationNumber]")
	private MCWebElement applicationNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/../..")
	private MCWebElement fromDatePicker;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/../..")
	private MCWebElement toDatePicker;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//img[@alt='Edit Record']")
	private MCWebElement editRecord;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Approve']")
	private MCWebElement approveBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Reject']")
	private MCWebElement rejectBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Cancel']")
	private MCWebElement cancelBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[text()='Reject Reason :']/following::td[1]/span/select")
	private MCWebElement rejectReasonDDwn;
	
	private static String REJECTED_REASON = "Rejected in De-Dupe [RDEDUPE]";

	private String inputApplicationNumber;
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(applicationNumber), WebElementUtils.elementToBeClickable(formNumber), WebElementUtils.elementToBeClickable(fromDate), WebElementUtils.elementToBeClickable(toDate));
	}

	public void verifyDuplicateApplication(String inputApplicationNum) {
		WebElementUtils.enterText(applicationNumberTxt, inputApplicationNum);
		WebElementUtils.pickDate(fromDatePicker, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(toDatePicker, LocalDate.now());
		clickSearchButton();
		SimulatorUtilities.wait(1000);
	}

	public Boolean approveApplication() {
		Device device = context.get(CreditConstants.APPLICATION);
		inputApplicationNumber = device.getApplicationNumber();
		logger.info(inputApplicationNumber);
		verifyDuplicateApplication(inputApplicationNumber);
		Boolean value = WebElementUtils.isTextAvailableinTable(searchTable, inputApplicationNumber);
		clickWhenClickable(editRecord);
		SimulatorUtilities.wait(1000);
		runWithinPopup("Edit Application", () ->{					
			clickWhenClickable(approveBtn);
		});	
		verifyOperationStatus();
		return value;
	}
	
	public Boolean rejectApplication() {
		Device device = context.get(CreditConstants.APPLICATION);
		inputApplicationNumber = device.getApplicationNumber();
		logger.info(inputApplicationNumber);
		verifyDuplicateApplication(inputApplicationNumber);
		Boolean value = WebElementUtils.isTextAvailableinTable(searchTable, inputApplicationNumber);
		clickWhenClickable(editRecord);
		SimulatorUtilities.wait(1000);
		runWithinPopup("Edit Application", () ->{
			WebElementUtils.selectDropDownByVisibleText(rejectReasonDDwn, REJECTED_REASON);
			clickWhenClickable(rejectBtn);
		});	
		verifyOperationStatus();
		return value;
	}
	
	public String checkDuplicateApplication(){
		Device device = context.get(CreditConstants.APPLICATION);
		inputApplicationNumber = device.getApplicationNumber();
		logger.info(inputApplicationNumber);
		verifyDuplicateApplication(inputApplicationNumber);
		WebElementUtils.isTextAvailableinTable(searchTable, inputApplicationNumber);
		logger.info(getFirstRecordCellTextByColumnName("Application Number"));
		return getFirstRecordCellTextByColumnName("Application Number");
	}
}