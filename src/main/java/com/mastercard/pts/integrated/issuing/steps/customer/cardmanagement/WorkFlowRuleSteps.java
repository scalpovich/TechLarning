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
public void addingWorkFlowRuleToProgram(String fieldName,String value)
{
	Boolean workFlowRule=workFlowRuleFlows.userAddsNewWorkFlowRule(fieldName,value);
	Assert.assertTrue("ApprovalScore is not added successfully", workFlowRule);
}
}
