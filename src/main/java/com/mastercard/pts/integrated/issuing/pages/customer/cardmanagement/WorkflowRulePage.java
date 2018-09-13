package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WorkFlowRule;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_CREDIT, CardManagementNav.L4_WORKFLOW_RULE })
public class WorkflowRulePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(WorkflowRulePage.class);
    private static final String WORKFLOW_RULE_IFRAME="Add Workflow Rule";
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Append']")
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Record Added Successfully.']")
	private MCWebElement validateSuccessMsgDisplay;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement workFlowTable;
	
	private static final String WORKFLOW_RULE_SCORE_PARAMETER="(CUSTOMER_TYPE = 0 )";
	
	public boolean successMessageDisplay() {
		return validateSuccessMsgDisplay.isVisible();
	}
	
	public void selectFieldName(String fieldName) {
		ifTextAvailableinTableThenDelete(workFlowTable, WORKFLOW_RULE_SCORE_PARAMETER);
		clickAddNewButton();
		switchToIframe(WORKFLOW_RULE_IFRAME);
		selectByVisibleText(fieldNameDdwn, fieldName);
		waitForLoaderToDisappear();
	}
	
	public void selectOperator1() {
		if (operator1Ddwn.isEnabled()) {
			WebElementUtils.selectDropDownByIndex(operator1Ddwn, 1);
			waitForLoaderToDisappear();
		}
	}
	
	public void selectOperator1Value1(String fieldName) {
		if (operator1value1Ddwn.isEnabled()) {
			selectByVisibleText(operator1value1Ddwn, fieldName);
		}
		if(operator1value1Ddwn.getAttribute("value").contains("Select")){
			selectByVisibleText(operator1value1Ddwn, fieldName);
		}
	}
	
	public void enterOperator1Value2(WorkFlowRule rule) {
		if (operator1value2Txt.isEnabled()) {
			WebElementUtils.enterText(operator1value2Txt, rule.getOperator1Value2());
		}
	}
	
	public void selectOperator2(WorkFlowRule rule) {
		if (operator2Ddwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(operator2Ddwn, rule.getOperator2());
		}
	}
	
	public void selectOperator2Value1(WorkFlowRule rule) {
		if (operator2value1Ddwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(operator2value1Ddwn, rule.getOperator2Value1());
		}
	}
	
	public void enterOperator2Value2(WorkFlowRule rule) {
		if (operator2value2Txt.isEnabled()) {
			WebElementUtils.enterText(operator2value2Txt, rule.getOperator2Value2());
		}
	}
	
	public void selectInsert(WorkFlowRule rule) {
		if (insertDdwn.isEnabled()) {
			WebElementUtils.selectDropDownByVisibleText(insertDdwn, rule.getInsert());
		}
	}
	
	public void clickAppendButton() {
		clickWhenClickable(appendBtn);
		waitForLoaderToDisappear();
	}

	public void clickRiskCheckBox(Boolean condition) {
		ClickCheckBox(riskCheckBox, condition);
	}
	
	public void clickScoreCheckBox(Boolean condition) {
		ClickCheckBox(scoreCheckBox, condition);
	}
	
	public void clickCreditBureauCheckBox(Boolean condition) {
		ClickCheckBox(creditBureauCheckBox, condition);
	}
	
	public void enterPriorityText(WorkFlowRule rule) {
		if (priorityTxt.isEnabled()) {
			WebElementUtils.enterText(priorityTxt, rule.getPriority());
		}
	}
	
	public void saveButtonClick() {
		clickSaveButton();
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Workflow Rule");
		verifyUiOperation("Add Workflow Rule");
	}

}