package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WorkFlowRule;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_WORKFLOW_RULE })
public class WorkflowRulePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(WorkflowRulePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ruleId]")
	private MCWebElement ruleId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#attributes select")
	private MCWebElement fieldNameDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#operator select")
	private MCWebElement operator1Ddwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "value:input:dropdowncomponent")
	private MCWebElement operator1value1Ddwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "textValue1:input:inputTextField")
	private MCWebElement operator1value2Txt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "operator1:input:dropdowncomponent")
	private MCWebElement operator2Ddwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "value1:input:dropdowncomponent")
	private MCWebElement operator2value1Ddwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "textValue2:input:inputTextField")
	private MCWebElement operator2value2Txt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "operator3:input:dropdowncomponent")
	private MCWebElement insertDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "#appendButton")
	private MCWebElement appendBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "ruleDesc:input:textAreaComponent")
	private MCWebElement ruleNameTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "riskInd:checkBoxComponent")
	private MCWebElement riskCheckBox;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "scoreInd:checkBoxComponent")
	private MCWebElement scoreCheckBox;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cbInd:checkBoxComponent")
	private MCWebElement creditBureauCheckBox;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "priority:input:inputTextField")
	private MCWebElement priorityTxt;
	
	
	public void selectFieldName(WorkFlowRule rule)
	{
		WebElementUtils.selectDropDownByVisibleText(fieldNameDdwn, rule.getFieldName());
		waitForLoaderToDisappear();
	}
	
	public void selectOperator1(WorkFlowRule rule)
	{  
		if (operator1Ddwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(operator1Ddwn,
					rule.getOperator1());
			waitForLoaderToDisappear();
		}
	}
	
	public void selectOperator1Value1(WorkFlowRule rule)
	{   
		if (operator1value1Ddwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(operator1value1Ddwn,
					rule.getOperator1Value1());
		}
	}
	
	public void enterOperator1Value2(WorkFlowRule rule)
	{
		if (operator1value2Txt.isEnabled()) {
			WebElementUtils.enterText(operator1value2Txt,
					rule.getOperator1Value2());
		}
	}
	
	public void selectOperator2(WorkFlowRule rule)
	{
		if (operator2Ddwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(operator2Ddwn,
					rule.getOperator2());
		}
	}
	
	public void selectOperator2Value1(WorkFlowRule rule)
	{
		if (operator2value1Ddwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(operator2value1Ddwn,
					rule.getOperator2Value1());
		}
	}
	
	public void enterOperator2Value2(WorkFlowRule rule)
	{
		if (operator2value2Txt.isEnabled()) {
			WebElementUtils.enterText(operator2value2Txt,
					rule.getOperator2Value2());
		}
	}
	
	public void selectInsert(WorkFlowRule rule)
	{
		if (insertDdwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(insertDdwn,
					rule.getInsert());
		}
	}
	
	public void clickAppendButton()
	{
		clickWhenClickableCHP(appendBtn);
		waitForLoaderToDisappear();
	}
	
	public void clickRiskCheckBox(Boolean condition)
	{
		ClickCheckBox(riskCheckBox, condition);
	}
	
	public void clickScoreCheckBox(Boolean condition)
	{
		ClickCheckBox(scoreCheckBox, condition);
	}
	
	public void clickCreditBureauCheckBox(Boolean condition)
	{
		ClickCheckBox(creditBureauCheckBox, condition);
	}
	
	public void enterPriorityText(WorkFlowRule rule)
	{
		if (priorityTxt.isEnabled()) {
			WebElementUtils.enterText(priorityTxt, rule.getPriority());
		}
	}

	public void verifyUiOperationStatus() {
		logger.info("Workflow Rule");
		verifyUiOperation("Add Workflow Rule");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(ruleId));
	}
}
