package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
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
		CardManagementNav.L4_REFER })
public class ReferPage extends AbstractCardManagementPage {
	@Autowired
	TestContext context;
	
	private static final String REFER_FRAME="Edit Application";
	
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
	private MCWebElement referBtn;
    
	public void referApplication() {
		Device device=context.get(CreditConstants.APPLICATION);
		WebElementUtils.enterText(applicationNumberTxt, device.getApplicationNumber());
		WebElementUtils.pickDate(fromDatePicker, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(toDatePicker,LocalDate.now());
		clickSearchButton();
	}

	public String editAndVerifyApplication()
	{
		waitForPageToLoad(driver());
		clickWhenClickable(editImg);
		switchToIframe(REFER_FRAME);
		clickWhenClickable(referBtn);
		SimulatorUtilities.wait(5000);
		verifyOperationStatus();
		SimulatorUtilities.wait(5000);
		String applicationNumber=getCodeFromInfoMessage("Application Number");
		return applicationNumber;
	}
	
	public void clickEditImageForTheRecordDisplayed() {
		waitForPageToLoad(driver());
		clickWhenClickable(editImg);
	}
	
	public void referButtonClick() {
		switchToIframe(REFER_FRAME);
		clickWhenClickable(referBtn);
		verifyOperationStatus();
	}
	
	public String getApplicationNumber() {
		return getCodeFromInfoMessage("Application Number");
	}
	

}