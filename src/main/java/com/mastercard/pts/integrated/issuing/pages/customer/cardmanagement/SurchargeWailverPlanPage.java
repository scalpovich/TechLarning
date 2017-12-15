package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWailverPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_SURCHARGE_WAIVER_PLAN })
public class SurchargeWailverPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(SurchargeWailverPlanPage.class);
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@class='addR']")
	private MCWebElement addButton;

	@PageElement(findBy = FindBy.NAME, valueToFind = "waiverPlanCode:input:inputTextField")
	private MCWebElement surchargeWaiverPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement surchargeWaiverPlandescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Add Details']")
	private MCWebElement addDetailsBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='waiverPlanCode']//li")
	private MCWebElement waiverPlanErrorMsg;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='description']//li")
	private MCWebElement descriptionErrorMsg;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='currencyCode']//li")
	private MCWebElement currencyErrorMsg;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='networkCode']//li")
	private MCWebElement interchangeErrorMsg;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='mcgCode']//li")
	private MCWebElement mcgErrorMsg;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='detailDesc']//li")
	private MCWebElement waiverTransactionDescriptionErrorMsg;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='effectiveDate']//li")
	private MCWebElement effectiveDateErrorMsg;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='endDate']//li")
	private MCWebElement endDateErrorMsg;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='waiverRate']//li")
	private MCWebElement surchargeRateErrorMsg;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgCode:input:dropdowncomponent")
	private MCWebElement mcgDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "detailDesc:input:inputTextField")
	private MCWebElement waiverTransactionDescription;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='yui-calcontainer single withtitle']//following-sibling::img")
	private MCWebElements dateImage;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Save']")
	private MCWebElement saveButton;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Cancel']")
	private MCWebElement cancelButton;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "waiverRate:input:inputTextField")
	private MCWebElement surchargeRateTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Record Added Successfully.']")
	private MCWebElement validateSuccessMsgDisplay;
	
	
	private String effectiveDate="//input[@name='effectiveDate:input:dateTextField']/parent::span/parent::span";
	private String endDate="//input[@name='endDate:input:dateTextField']/parent::span/parent::span";
	
	public boolean successMessageDiplay()
	{
		if(validateSuccessMsgDisplay.isVisible())
		{
			logger.info("successMsg is displayed");
			return true;
		}
		return false;
	}
	public void enterWaiverTransactionDescription(SurchargeWailverPlan surchargeWailverPlan)
	{
		enterValueinTextBox(waiverTransactionDescription,surchargeWailverPlan.getWaiverTransactionDescription());
	}
	public void effectiveDateSelect(DatePicker datePicker,SurchargeWailverPlan surchargeWailverPlan)
	{
		datePicker.setDateCalendar2(surchargeWailverPlan.getEffectiveDate(),effectiveDate);
	
	}
	public void endDateSelect(DatePicker datePicker,SurchargeWailverPlan surchargeWailverPlan)
	{
		datePicker.setDateCalendar2(surchargeWailverPlan.getEndDate(),endDate);
	
	}
	public void enterSurchargeRate(SurchargeWailverPlan surchargeWailverPlan)
	{   enterValueinTextBox(surchargeRateTxt,"");
		enterValueinTextBox(surchargeRateTxt,surchargeWailverPlan.getSurchargeRate());
}
	public void verifyUiOperationStatus() {
		verifyUiOperation("Add Surcharge Waiver Plan");
	}

	public void enterWaiverPlanValid(SurchargeWailverPlan surchargeWailverPlan) {
		logger.info("Surcharge Waiver Plan");
		clickWhenClickable(addButton);
		switchToIframe(Constants.ADD_SURCHARGE_WAIVER_FEE_PLAN);
		enterValueinTextBox(surchargeWaiverPlanCodeTxt, surchargeWailverPlan.getSurchargeWaiverPlanCodeValid());
        clickWhenClickable(addDetailsBtn);
		}
	public void enterWaiverPlanInvalid(SurchargeWailverPlan surchargeWailverPlan) {
		logger.info("Surcharge Waiver Plan");
		clickWhenClickable(addButton);
		switchToIframe(Constants.ADD_SURCHARGE_WAIVER_FEE_PLAN);
		enterValueinTextBox(surchargeWaiverPlanCodeTxt, surchargeWailverPlan.getSurchargeWaiverPlanCodeInvalid());
		 clickWhenClickable(addDetailsBtn);
		}
	
	public void enterWaiverPlanDescriptionValid(SurchargeWailverPlan surchargeWailverPlan) {
		enterValueinTextBox(surchargeWaiverPlandescriptionTxt,surchargeWailverPlan.getSurchargeWaiverDescriptionValid() );
		 clickWhenClickable(addDetailsBtn);
		}
	public void enterWaiverPlanDescriptionInvalid(SurchargeWailverPlan surchargeWailverPlan) {
		enterValueinTextBox(surchargeWaiverPlandescriptionTxt,surchargeWailverPlan.getSurchargeWaiverDescriptionInvalid() );
		 clickWhenClickable(addDetailsBtn);
		}	
	public void currencySelect()
	{
		currencyDDwn.getSelect().selectByIndex(2);
	}
	public void addDetailsButtonClick()
	{
		clickWhenClickable(addDetailsBtn);
	}
	public void addNewButtonClick()
	{
		clickWhenClickable(addButton);
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_SURCHARGE_WAIVER_PLAN_DETAIL);
		
	}
    
	public String waiverPlanCodeErrorMessage()
	{
		return waiverPlanErrorMsg.getText();
		
	}
	public String waiverPlanDescriptionErrorMessage()
	{
		return descriptionErrorMsg.getText();
		
	}
	public void interchangeSelect()
	{
		interchangeDDwn.getSelect().selectByIndex(1);
	}
	public void mcgSelect()
	{
		mcgDDwn.getSelect().selectByIndex(1);
	}
	
	public void saveButtonClick()
	{
	clickWhenClickable(saveButton);
	}
	public void saveButtonClickInner()
	{
    switchToIframe(Constants.ADD_SURCHARGE_WAIVER_FEE_PLAN);
	clickWhenClickable(saveButton);
	}
	public void cancelButtonClick()
	{
		clickWhenClickable(cancelButton);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(surchargeWaiverPlanCodeTxt),
				WebElementUtils.elementToBeClickable(surchargeWaiverPlandescriptionTxt));
	}
}
