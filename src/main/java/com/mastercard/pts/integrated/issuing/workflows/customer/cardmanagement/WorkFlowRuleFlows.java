package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WorkFlowRule;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WorkflowRulePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class WorkFlowRuleFlows {

	@Autowired
	private Navigator navigator;
	
	private WorkflowRulePage workFlowRulePage;
	
	public boolean userAddsNewWorkFlowRule(WorkFlowRule rule)
	{
		workFlowRulePage=navigator.navigateToPage(WorkflowRulePage.class);
		workFlowRulePage.selectFieldName(rule);
		workFlowRulePage.selectOperator1(rule);
		workFlowRulePage.selectOperator1Value1(rule);
		workFlowRulePage.enterOperator1Value2(rule);
		workFlowRulePage.selectOperator2(rule);
		workFlowRulePage.selectOperator2Value1(rule);
		workFlowRulePage.enterOperator2Value2(rule);
		workFlowRulePage.selectInsert(rule);
		workFlowRulePage.clickAppendButton();
		workFlowRulePage.clickRiskCheckBox(true);
		workFlowRulePage.clickScoreCheckBox(true);
		workFlowRulePage.clickCreditBureauCheckBox(true);
		workFlowRulePage.enterPriorityText(rule);
		return false;
		
	}
	
	public void fieldNameSelect()
	{
		
	}
}
