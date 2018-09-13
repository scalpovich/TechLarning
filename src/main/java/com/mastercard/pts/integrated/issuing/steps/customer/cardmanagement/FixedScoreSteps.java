package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.FixedScoreWorkFlow;

@Component
public class FixedScoreSteps {
	@Autowired
	FixedScoreWorkFlow fixedScoreWorkFlow;
	
	@When("User adds Fixed Score for fieldName $fieldName and fieldValue $fieldValue on program")
	@Then("User adds Fixed Score for fieldName $fieldName and fieldValue $fieldValue on program")
	public void addingFixedScoreOnProgram(String fieldName,String fieldValue)
	{
		Boolean fixedScore=fixedScoreWorkFlow.userAddsFixedScore(fieldName,fieldValue);
		Assert.assertTrue("ApprovalScore is not added successfully", fixedScore);	
	}

}
