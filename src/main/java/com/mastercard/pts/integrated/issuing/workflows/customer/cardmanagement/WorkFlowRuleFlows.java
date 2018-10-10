package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WorkflowRulePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class WorkFlowRuleFlows {

	@Autowired
	private Navigator navigator;
	
	private WorkflowRulePage workFlowRulePage;
	
	public boolean userAddsNewWorkFlowRule(String fieldName1,String fieldName2)
	{
		workFlowRulePage=navigator.navigateToPage(WorkflowRulePage.class);
		workFlowRulePage.selectFieldName(fieldName1);
		workFlowRulePage.selectOperator1();
		workFlowRulePage.selectOperator1Value1(fieldName2);
		workFlowRulePage.clickAppendButton();
		workFlowRulePage.saveButtonClick();
		return workFlowRulePage.successMessageDisplay();
		
	}
	
	public boolean userAddsNewWorkFlowRuleForApplicationScore(String fieldName1,String fieldName2)
	{
		workFlowRulePage=navigator.navigateToPage(WorkflowRulePage.class);
		workFlowRulePage.selectFieldName(fieldName1);
		workFlowRulePage.selectOperator1();
		workFlowRulePage.selectOperator1Value1(fieldName2);
		workFlowRulePage.clickAppendButton();
		workFlowRulePage.clickRiskCheckBox(true);
		workFlowRulePage.clickCreditBureauCheckBox(true);
		workFlowRulePage.saveButtonClick();
		return workFlowRulePage.successMessageDisplay();
		
	}
	public boolean userAddsNewWorkFlowRuleForApplicationScoreAndRisk(String fieldName1,String fieldName2)
	{
		workFlowRulePage=navigator.navigateToPage(WorkflowRulePage.class);
		workFlowRulePage.selectFieldName(fieldName1);
		workFlowRulePage.selectOperator1();
		workFlowRulePage.selectOperator1Value1(fieldName2);
		workFlowRulePage.clickAppendButton();
		workFlowRulePage.clickCreditBureauCheckBox(true);
		workFlowRulePage.saveButtonClick();
		return workFlowRulePage.successMessageDisplay();
		
	}
}
