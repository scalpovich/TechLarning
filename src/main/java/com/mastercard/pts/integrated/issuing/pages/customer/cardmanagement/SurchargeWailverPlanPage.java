package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.CreditCardPlans;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWailverPlan;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_SURCHARGE_WAIVER_PLAN })
public class SurchargeWailverPlanPage extends AbstractCreditPage {
@Autowired
CreditCardPlans creditCardPlans;
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
		surchargeWailverPlan.setEffectiveDate(Constants.effectiveDate);
		surchargeWailverPlan.setEndDate(Constants.endDate);
		surchargeWailverPlan.setWaiverTransactionDescription(Constants.waiverTransactionDescription);
		surchargeWailverPlan.setSurchargeRate(Constants.surchargeRate);
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
		saveOrDetailsOrSearchClick();
		mandatoryLabels();
		mandatoryFields();
		surchargeWailverPlan.setSurchargeWaiverPlanCodeValid(CustomUtils.randomAlphaNumeric(5).toUpperCase());
		enterValueinTextBox(surchargeWaiverPlanCodeTxt, surchargeWailverPlan.getSurchargeWaiverPlanCodeValid());
		surchargeWailverPlan.setSurchargeWaiverDescriptionValid(CustomUtils.randomAlphaNumeric(5));
		enterValueinTextBox(surchargeWaiverPlandescriptionTxt,surchargeWailverPlan.getSurchargeWaiverDescriptionValid() );
		currencyDDwn.getSelect().selectByIndex(2);
		creditCardPlans.setMandatoryValuesWithLabels(mandatoryValuesWithLabels(mandatoryFields(),mandatoryLabels()));
		logger.info("MandatoryLabelswithValues: {}", creditCardPlans.getMandatoryValuesWithLabels());
        clickWhenClickable(addDetailsBtn);
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
		SwitchToDefaultFrame();
	    switchToIframe(Constants.ADD_SURCHARGE_WAIVER_FEE_PLAN);
	    CustomUtils.ThreadDotSleep(4000);
	    waitForElementVisible(saveButton);
		clickWhenClickable(saveButton);
	}
	public void cancelButtonClick()
	{
		clickWhenClickable(cancelButton);
	}
	
}
