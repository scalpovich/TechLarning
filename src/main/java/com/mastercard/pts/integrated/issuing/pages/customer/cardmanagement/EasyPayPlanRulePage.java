package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EasyPayPlanRule;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_LOAN_CONFIGURATION,
		CardManagementNav.L3_EASY_PAY_PLAN_RULE
		})

public class EasyPayPlanRulePage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(EasyPayPlanRulePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planCode]")
	private MCWebElement planCode;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planDesc]")
	private MCWebElement planDesc;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addplanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planCode:input:inputTextField")
	private MCWebElement planCodeTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "planDesc:input:inputTextField")
	private MCWebElement planDescTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "ruleCode:input:dropdowncomponent")
	private MCWebElement ruleCodeDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "comparisonOperator:input:dropdowncomponent")
	private MCWebElement comparisonOperatorDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "ruleValue:input:dropdowncomponent")
	private MCWebElement ruleValueDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "ruleValue:input:inputTextField")
	private MCWebElement ruleValueTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	
	public void verifyUiOperationStatus() {
		logger.info("Easy Pay Plan Rule");
		verifyUiOperation("Add Easy Pay Plan Rule");
	}
	
	public void clickAddDetails(){
		clickWhenClickable(addplanBtn);
		switchToIframe(Constants.ADD_EASY_PAY_PLAN_RULE);
	}
	public void addDetails(EasyPayPlanRule easyplanrule){
		clickAddDetails();
	
		enterText(planCodeTxt, easyplanrule.getPlanCode());
		enterText(planDescTxt ,easyplanrule.getPlanDesc());
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();	
		clickWhenClickable(addplanBtn);
		switchToDefaultFrame();
		switchToIframe(Constants.ADD_RULE);
		selectByVisibleText(ruleCodeDdwn,easyplanrule.getRuleCode());
		selectByVisibleText(comparisonOperatorDdwn,easyplanrule.getComparisonOperator());
		if(isElementPresent(ruleValueDdwn))
			selectByVisibleText(ruleValueDdwn,easyplanrule.getRuleValue());
		else
			enterText(ruleValueTxt ,easyplanrule.getRuleValue());
		
		clickWhenClickable(saveBtn);
		switchToIframe(Constants.ADD_EASY_PAY_PLAN_RULE);
		waitForLoaderToDisappear();	
		clickWhenClickable(saveBtn);
		verifySuccessMessage();
		
	}
	
	public void verifySuccessMessage() {
		if (!publishErrorOnPage()) {
			logger.info("Record Added Successfully.");
			switchToDefaultFrame();
		} else {
			logger.info("Error in record Addition");
			clickWhenClickable(cancelBtn);
			switchToDefaultFrame();
		}
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(planCode),
				WebElementUtils.elementToBeClickable(planDesc)
				);
	}
}