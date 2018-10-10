package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_ACTIVITY_APPLICATION, CardManagementNav.L3_ACTIVITY_APPLICATION_CREDIT, CardManagementNav.L4_REFER })
public class ReferPage extends AbstractCardManagementPage {
	@Autowired
	TestContext context;

	private static final String REFER_FRAME = "Edit Application";
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='applicationNumber']")
	private MCWebElement txtApplicationNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/../..")
	private MCWebElement dtPkrFrom;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/../..")
	private MCWebElement dtPkrTo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[8]/span//img")
	private MCWebElement editImg;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@name='approve']")
	private MCWebElement btnRefer;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='formNumber']")
	private MCWebElement txtFormNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='batchNum']//span[@class='labeltextf']")
	private MCWebElement txtBatchNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[1]/span//span")
	private MCWebElement txtApplicationNumberFileUpload;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Refer']")
	private MCWebElement referLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='firstName']")
	private MCWebElement txtFirstName;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='lastName']")
	private MCWebElement txtLastName;

	public void referapplication() {
		Device device = context.get(CreditConstants.APPLICATION);
		WebElementUtils.enterText(txtApplicationNumber, device.getApplicationNumber());
		WebElementUtils.pickDate(dtPkrFrom, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(dtPkrTo, LocalDate.now());
		clickSearchButton();
	}
	
	public String editAndVerifyApplication()
	{
		waitForPageToLoad(driver());
		clickWhenClickable(editImg);
		switchToIframe(REFER_FRAME);
		clickWhenClickable(btnRefer);
		SimulatorUtilities.wait(5000);
		verifyOperationStatus();
		SimulatorUtilities.wait(5000);
		String applicationNumber=getCodeFromInfoMessage("Application Number");
		return applicationNumber;
	}

	public String editAndReferApplication() {
		referapplication();
		waitForPageToLoad(driver());
		clickWhenClickable(editImg);
		SimulatorUtilities.wait(5000);
		runWithinPopup("Edit Application", () -> {
			clickWhenClickable(btnRefer);
		});
		verifyOperationStatus();
		return getCodeFromInfoMessage("Application Number");
	}
	
	public void clickEditImageForTheRecordDisplayed() {
		waitForPageToLoad(driver());
		clickWhenClickable(editImg);
	}
	
	public void referButtonClick() {
		switchToIframe(REFER_FRAME);
		clickWhenClickable(btnRefer);
		verifyOperationStatus();
	}
	
	public String getApplicationNumber() {
		return getCodeFromInfoMessage("Application Number");
	}

	public void referApplicationFileUpload() {
		Map<String, Object> mapFileUpload = context.get(CreditConstants.FILEUPLOAD_IN_BULK);
		List<String> allBatchNumbers = new LinkedList<>();
		List<String> allApplicationNumbers = new LinkedList<>();
		for (Map.Entry<String, Object> entry : mapFileUpload.entrySet()) {
			HelpDeskGeneral helpDeskGeneral = (HelpDeskGeneral) entry.getValue();
			WebElementUtils.enterText(txtFormNumber, helpDeskGeneral.getFormNumber());
			WebElementUtils.enterText(txtFirstName, helpDeskGeneral.getFirstName());
			WebElementUtils.enterText(txtLastName, helpDeskGeneral.getLastName());
			WebElementUtils.pickDate(dtPkrFrom, LocalDate.now().minusDays(1));
			WebElementUtils.pickDate(dtPkrTo, LocalDate.now());
			clickSearchButton();
			waitForPageToLoad(driver());
			allApplicationNumbers.add(txtApplicationNumberFileUpload.getText());
			clickWhenClickable(editImg);
			switchToIframe(REFER_FRAME);
			SimulatorUtilities.wait(8000);
			allBatchNumbers.add(txtBatchNumber.getText());
			clickWhenClickablewithWicket(btnRefer);
			SimulatorUtilities.wait(10000);
			clickWhenClickable(referLink);
		}
		context.put(CreditConstants.ALL_APPLICATION_NUMBERS, allApplicationNumbers);
		context.put(CreditConstants.ALL_BATCH_NUMBERS, allBatchNumbers);
	}
}