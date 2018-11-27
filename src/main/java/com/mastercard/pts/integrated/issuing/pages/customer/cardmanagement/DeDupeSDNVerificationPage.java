package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.FileCreation;
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
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=formNumber]")
	private MCWebElement formNumberTxt;
	
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
	
	private static final String APPROVES = "approves";
	
	private static final String REJECT = "reject";
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[1]/span//span")
	private MCWebElement applicationNumberFileUploadTxt;
	
	private String inputApplicationNumber;
	
	private String inputFormNumber;
	
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
	
	public void verifyDuplicateFormNumber(String formNumber) {
		WebElementUtils.enterText(formNumberTxt, formNumber);
		WebElementUtils.pickDate(fromDatePicker, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(toDatePicker, LocalDate.now());
		clickSearchButton();
		SimulatorUtilities.wait(1000);
	}

	public Boolean approveRejectApplication(String operation) {
		Device device = context.get(CreditConstants.APPLICATION);
		inputApplicationNumber = device.getApplicationNumber();
		logger.info(inputApplicationNumber);
		verifyDuplicateApplication(inputApplicationNumber);
		Boolean value = WebElementUtils.isTextAvailableinTable(searchTable, inputApplicationNumber);
		clickWhenClickable(editRecord);
		SimulatorUtilities.wait(1000);
		runWithinPopup("Edit Application", () -> {
			if (operation.contains(APPROVES)) {
				clickWhenClickable(approveBtn);
			} else if (operation.contains(REJECT)) {
				WebElementUtils.selectDropDownByVisibleText(rejectReasonDDwn, REJECTED_REASON);
				clickWhenClickable(rejectBtn);
			}
		});
		verifyOperationStatus();
		return value;
	}
	
	public String checkDuplicateApplication(){
		Device device = context.get(CreditConstants.APPLICATION);
		inputApplicationNumber = device.getApplicationNumber();
		logger.info("Application Number : {}",inputApplicationNumber);
		verifyDuplicateApplication(inputApplicationNumber);
		WebElementUtils.isTextAvailableinTable(searchTable, inputApplicationNumber);
		logger.info("Application Number From Table Records :{}",getFirstRecordCellTextByColumnName(ContextConstants.APPLICATION_NUMBER));
		return getFirstRecordCellTextByColumnName(ContextConstants.APPLICATION_NUMBER);
	}
	
	public Boolean approveRejectApplicationForUpload(String operation) throws IOException {
		Map<Integer, Object> map = context.get(CreditConstants.FILEUPLOAD_IN_BULK);
		List<String> allFormNumbers = new LinkedList<>();
		List<String> allApplicationNumbers = new LinkedList<>();
		Boolean value = false;
		for (Map.Entry<Integer, Object> mapPerIteration : map.entrySet()) {
			HelpDeskGeneral helpDesk = (HelpDeskGeneral) mapPerIteration.getValue();
			inputFormNumber = helpDesk.getFormNumber();
			allFormNumbers.add(inputFormNumber);
			logger.info(inputFormNumber);
			verifyDuplicateFormNumber(inputFormNumber);
			value = WebElementUtils.isTextAvailableinTable(searchTable, inputFormNumber);
			clickWhenClickable(editRecord);
			SimulatorUtilities.wait(1000);
			runWithinPopup("Edit Application", () -> {
				allApplicationNumbers.add(applicationNumberFileUploadTxt.getText());
				if (operation.contains(APPROVES)) {
					clickWhenClickable(approveBtn);
				} else if (operation.contains(REJECT)) {
					WebElementUtils.selectDropDownByVisibleText(rejectReasonDDwn, REJECTED_REASON);
					clickWhenClickable(rejectBtn);
				}
			});
			verifyOperationStatus();
			value = true;
		}
		context.put(CreditConstants.ALL_APPLICATION_NUMBERS, allApplicationNumbers);
		context.put(CreditConstants.ALL_FORM_NUMBERS, allFormNumbers);
		return value;
	}
}