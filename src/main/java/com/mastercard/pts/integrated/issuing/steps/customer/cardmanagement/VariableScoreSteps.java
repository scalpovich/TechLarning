package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.VariableScoreWorkFlow;

@Component
public class VariableScoreSteps {
	@Autowired
	VariableScoreWorkFlow variableScoreWorkFlow;
	
	@When("User adds Variable Score for fieldName $fieldName on program")
	@Then("User adds Variable Score for fieldName $fieldName on program")
	public void addingVariableScoreOnProgram(String fieldName)
	{
		Boolean variableScore=variableScoreWorkFlow.userAddsNewVariableScore(fieldName);
		Assert.assertTrue("ApprovalScore is not added successfully", variableScore);
	}

}
