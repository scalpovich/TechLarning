package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_ACTIVITY_APPLICATION,
		CardManagementNav.L3_ACTIVITY_APPLICATION_CREDIT,
		CardManagementNav.L4_APPROVE_REJECT })
public class ApproveRejectPage extends AbstractCardManagementPage {
	
	@Autowired
	TestContext context;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='applicationNumber']")
	private MCWebElement txtApplicationNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/../..")
	private MCWebElement dtPkrFrom;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/../..")
	private MCWebElement dtPkrTo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[8]/span//img")
	private MCWebElement editImg;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='formNumber']")
	private MCWebElement txtFormNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='firstName']")
	private MCWebElement txtFirstName;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='lastName']")
	private MCWebElement txtLastName;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@name='approve']")
	private MCWebElement btnApprove;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@name='pushback']")
	private MCWebElement btnPushback;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Approve/Reject']")
	private MCWebElement approveRejectLink;
    
	private static final String APPROVE_REJECT_FRAME="Edit Application";
	
	public void enterApplicationNumber(){
		Device device=context.get(CreditConstants.APPLICATION);
		WebElementUtils.enterText(txtApplicationNumber, device.getApplicationNumber());	
	}	
	
	public void selectFromAndToDate() {
		WebElementUtils.pickDate(dtPkrFrom, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(dtPkrTo, LocalDate.now());
		clickSearchButton();
	}
	
	
	public void clickEditRecord(){
		waitForPageToLoad(driver());
		clickWhenClickableDoNotWaitForWicket(editImg);	
	}

	public String approveApplication(){
		enterApplicationNumber();
		selectFromAndToDate();
		SimulatorUtilities.wait(5000);
		clickWhenClickable(editImg);		
		SimulatorUtilities.wait(15000);
		
		runWithinPopup("Edit Application", () -> {
			clickWhenClickable(btnApprove);			
		});		
		
		verifyOperationStatus();
		return getCodeFromInfoMessage("Application Number");
	}
	
	public String pushbackApplication() {
		enterApplicationNumber();
		selectFromAndToDate();
		clickEditRecord();
		SimulatorUtilities.wait(5000);

		runWithinPopup("Edit Application", () -> {
			clickWhenClickable(btnPushback);
		});
		verifyOperationStatus();
		return getCodeFromInfoMessage("Application Number");
	}
	
	public void enterFormNumber() {
		String formNumber = context.get(CreditConstants.FORM_NUMBER);
		WebElementUtils.enterText(txtFormNumber, formNumber);
	}
	
	public void approveApplicationFileUpload() {
		Map<String, Object>mapFileUpload=context.get(CreditConstants.FILEUPLOAD_IN_BULK);
		for (Map.Entry<String, Object> entry : mapFileUpload.entrySet()) {
			HelpDeskGeneral helpDeskGeneral=(HelpDeskGeneral) entry.getValue();
			WebElementUtils.enterText(txtFormNumber,helpDeskGeneral.getFormNumber());
			WebElementUtils.enterText(txtFirstName, helpDeskGeneral.getFirstName());
			WebElementUtils.enterText(txtLastName, helpDeskGeneral.getLastName());
			WebElementUtils.pickDate(dtPkrFrom, LocalDate.now().minusDays(1));
			WebElementUtils.pickDate(dtPkrTo, LocalDate.now());
			clickSearchButton();
			waitForPageToLoad(driver());
			clickWhenClickable(editImg);
			switchToIframe(APPROVE_REJECT_FRAME);
			SimulatorUtilities.wait(8000);
			clickWhenClickablewithWicket(btnApprove);
			SimulatorUtilities.wait(10000);
			clickWhenClickable(approveRejectLink);
		}
	}
}