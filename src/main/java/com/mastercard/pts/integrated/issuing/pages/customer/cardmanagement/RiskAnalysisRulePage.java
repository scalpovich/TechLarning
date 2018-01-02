package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.CreditCardPlans;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_RISK_ANALYSIS_RULE })
public class RiskAnalysisRulePage extends AbstractCreditPage{
	 @Autowired
	 CreditCardCreditPlan creditCardCreditPlan;
	 @Autowired
	 CreditCardPlans creditCardPlans;
    private static final String ADDRISKAANALYSISRULE_FRAME="Add Risk Analysis Rule";
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
	
    public void addRiskAnalysisRuleplan() {
		clickWhenClickable(addBtn);
		switchToIframe(ADDRISKAANALYSISRULE_FRAME);
		clickSaveButton();
		mandatoryLabels();
		mandatoryFields();
		WebElementUtils.selectDropDownByIndex(programDDwn,1);
		WebElementUtils.selectDropDownByIndex(fieldNameDDwn,1);
		WebElementUtils.selectDropDownByIndex(operatorDDwn,1);
		WebElementUtils.selectDropDownByIndex(fieldName2DDwn,1);
		clickWhenClickable(appendBtn);
		CustomUtils.ThreadDotSleep(4000);
		creditCardPlans.setMandatoryValuesWithLabels(mandatoryValuesWithLabels(mandatoryFields(),mandatoryLabels()));
		logger.info("MandatoryLabelswithValues: {}", creditCardPlans.getMandatoryValuesWithLabels());
		clickSaveButton();
		waitForLoaderToDisappear();
		
		}
	
	public void verifyUiOperationStatus() {
		logger.info("Risk Analysis Rule");
		verifyUiOperation("Add Risk Analysis Rule");
	}
   
   
	/*@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(program),
				WebElementUtils.elementToBeClickable(ruleId));
	}*/
}
