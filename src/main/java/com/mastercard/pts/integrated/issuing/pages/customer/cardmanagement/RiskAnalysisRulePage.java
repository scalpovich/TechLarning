package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.CreditCardPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author e076177
 *
 */
@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_RISK_ANALYSIS_RULE })
public class RiskAnalysisRulePage extends AbstractBasePage{
	 @Autowired
	 CreditCardCreditPlan creditCardCreditPlan;
	 @Autowired
	 CreditCardPlan creditCardPlans;
	 
    private static final String ADD_RISK_AANALYSIS_RULE_FRAME="Add Risk Analysis Rule";
	private static final Logger logger = LoggerFactory
			.getLogger(RiskAnalysisRulePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "productCode:input:dropdowncomponent")
	private MCWebElement programDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "attribute1:input:dropdowncomponent")
	private MCWebElement fieldNameDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "operator1:input:dropdowncomponent")
	private MCWebElement operatorDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "attribute2:input:dropdowncomponent")
	private MCWebElement fieldName2DDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "operator2:input:dropdowncomponent")
	private MCWebElement insertDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "appendSectionContainer:appendButton")
	private MCWebElement appendBtn;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Record Added Successfully.']")
	private MCWebElement validateSuccessMsgDisplay;
	
	public boolean successMessageDiplay()
	{
		if(validateSuccessMsgDisplay.isVisible())
		{
			logger.info("successMsg is displayed");
			return true;
		}
		return false;
	}
   public void addButtonToEnterRiskAnalysisRulePlanFrame()
	{
		clickWhenClickable(addBtn);
		switchToIframe(ADD_RISK_AANALYSIS_RULE_FRAME);
	}
	public void addMandatoryLabelsAndFields()
    {
		clickSaveButton();
		mandatoryLabels();
		mandatoryFields();
    }
	public void selectProgram(int index)
	{
		WebElementUtils.selectDropDownByIndex(programDDwn,index);
	}
	public void selectField(int index)
	{
		WebElementUtils.selectDropDownByIndex(fieldNameDDwn,index);
	}
	public void selectOperator(int index)
	{
		WebElementUtils.selectDropDownByIndex(operatorDDwn,index);
	}
	public void selectFieldName2(int index)
	{
		WebElementUtils.selectDropDownByIndex(fieldName2DDwn,index);
	}
	public void appendButtonClick()
	{
		clickWhenClickable(appendBtn);
		waitForPageToLoad(getFinder().getWebDriver());
	}
	 public void settingMandatoryValuesWithLabels()
	 {
	   creditCardPlans.setMandatoryValuesWithLabels(mandatoryValuesWithLabels(mandatoryFields(),mandatoryLabels()));
	   logger.info("MandatoryLabelswithValues: {}", creditCardPlans.getMandatoryValuesWithLabels());
	 }
	 public void saveButtonClick()
	 {
		 clickSaveButton();
		 waitForLoaderToDisappear();
	 }
	public void verifyUiOperationStatus() {
		logger.info("Risk Analysis Rule");
		verifyUiOperation("Add Risk Analysis Rule");
	}
   
}
