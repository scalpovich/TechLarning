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
	
	private static final String APPROVE_REJECT_FRAME="Edit Application";
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addEmbossingPriorityPass;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planDesc:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='applicationNumber']")
	private MCWebElement applicationNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/../..")
	private MCWebElement fromDatePicker;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/../..")
	private MCWebElement toDatePicker;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[8]/span//img")
	private MCWebElement editImg;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@name='approve']")
	private MCWebElement approveBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='formNumber']")
	private MCWebElement formNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Approve/Reject']")
	private MCWebElement approveRejectLink;
	
    @PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='firstName']")
	private MCWebElement firstNameTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='lastName']")
	private MCWebElement lastNameTxt;
    
	public void enterApplicationNumber()
	{
		Device device=context.get(CreditConstants.APPLICATION);
		WebElementUtils.enterText(applicationNumberTxt, device.getApplicationNumber());	
	}
	
	public void selectFromAndToDate()
	{
		WebElementUtils.pickDate(fromDatePicker, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(toDatePicker, LocalDate.now());
		clickSearchButton();
	}
	
	public void clickEditImageForTheRecordDisplayed()
	{
		waitForPageToLoad(driver());
		clickWhenClickableDoNotWaitForWicket(editImg);	
	}
	
	public void approveButtonClick()
	{
		switchToIframe(APPROVE_REJECT_FRAME);
		clickWhenClickable(approveBtn);
		verifyOperationStatus();
	}
	
	public String getApplicationNumber()
	{
		return getCodeFromInfoMessage("Application Number");
	}
	
	public void enterFormNumber()
	{
		String formNumber=context.get(CreditConstants.FORM_NUMBER);
		WebElementUtils.enterText(formNumberTxt,formNumber);	
	}
	
	public void approveApplicationFileUpload() {
		Map<String, Object>mapFileUpload=context.get(CreditConstants.FILEUPLOAD_IN_BULK);
		for (Map.Entry<String, Object> entry : mapFileUpload.entrySet()) {
			HelpDeskGeneral helpDeskGeneral=(HelpDeskGeneral) entry.getValue();
			WebElementUtils.enterText(formNumberTxt,helpDeskGeneral.getFormNumber());
			WebElementUtils.enterText(firstNameTxt, helpDeskGeneral.getFirstName());
			WebElementUtils.enterText(lastNameTxt, helpDeskGeneral.getLastName());
			WebElementUtils.pickDate(fromDatePicker, LocalDate.now().minusDays(1));
			WebElementUtils.pickDate(toDatePicker, LocalDate.now());
			clickSearchButton();
			waitForPageToLoad(driver());
			clickWhenClickable(editImg);
			switchToIframe(APPROVE_REJECT_FRAME);
			SimulatorUtilities.wait(5000);
			clickWhenClickablewithWicket(approveBtn);
			SimulatorUtilities.wait(5000);
			clickWhenClickable(approveRejectLink);
		}
	}
}