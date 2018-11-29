package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WorkFlowRuleFlows;

@Component
public class WorkFlowRuleSteps {
@Autowired
WorkFlowRuleFlows workFlowRuleFlows;

@When("User Adds WorkFlow Rule for fieldName1 $fieldName and fieldName2 $value on program")
@Then("User Adds WorkFlow Rule for fieldName1 $fieldName and fieldName2 $value on program")
	public void addingWorkFlowRuleToProgram(String fieldName, String value) {
		Assert.assertTrue("Approval Score is not added successfully", workFlowRuleFlows.userAddsNewWorkFlowRule(fieldName, value));
}

	@When("User Adds WorkFlow Rule with Credit Bureau for $fieldName and $value on program")
	@Then("User Adds WorkFlow Rule with Credit Bureau for $fieldName and $value on program")
	public void addingWorkFlowRuleToProgramWithCreditBureau(String fieldName, String value) {
		Assert.assertTrue("Credit Bureau is not added successfully", workFlowRuleFlows.userAddsWorkFlowRuleOnlyForCreditBureau(fieldName, value));
	}
	
	@When("User Adds WorkFlow Rule with Application Scoring for $fieldName and $value on program")
	@Then("User Adds WorkFlow Rule with Application Scoring for $fieldName and $value on program")
	public void addingWorkFlowRuleToProgramWithApplicationScoring(String fieldName, String value) {
		Assert.assertTrue("Application Scoring is not added successfully", workFlowRuleFlows.userAddsWorkFlowRuleOnlyForApplicationScoring(fieldName, value));
	}
	
	@When("User Adds WorkFlow Rule with Application Scoring,Credit Bureau for $fieldName and $value on program")
	@Then("User Adds WorkFlow Rule with Application Scoring,Credit Bureau for $fieldName and $value on program")
	public void addingWorkFlowRuleToProgramWithApplicationScoringCreditBureau(String fieldName, String value) {
		Assert.assertTrue("Application Scoring & Credit Bureau is not added successfully", workFlowRuleFlows.userAddsWorkFlowRuleForApplicationScoringCreditBureau(fieldName, value));
	}
@When("User Adds WorkFlow Rule for fieldName1 $fieldName and fieldName2 $value on program for application score")
@Then("User Adds WorkFlow Rule for fieldName1 $fieldName and fieldName2 $value on program for application score")
public void addingWorkFlowRuleToProgramForApplicationScore(String fieldName,String value)
{
	Boolean workFlowRule=workFlowRuleFlows.userAddsNewWorkFlowRuleForApplicationScore(fieldName,value);
	Assert.assertTrue("ApprovalScore is not added successfully", workFlowRule);
}
@When("User Adds WorkFlow Rule for fieldName1 $fieldName and fieldName2 $value on program for application score and risk")
@Then("User Adds WorkFlow Rule for fieldName1 $fieldName and fieldName2 $value on program for application score and risk")
public void addingWorkFlowRuleToProgramForApplicationScoreAndRisk(String fieldName,String value)
{
	Boolean workFlowRule=workFlowRuleFlows.userAddsNewWorkFlowRuleForApplicationScoreAndRisk(fieldName,value);
	Assert.assertTrue("ApprovalScore is not added successfully", workFlowRule);
}
}

