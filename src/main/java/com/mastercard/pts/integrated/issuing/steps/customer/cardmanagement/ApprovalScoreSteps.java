package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ApprovalScoreWorkFlow;

@Component
public class ApprovalScoreSteps {
	
	@Autowired
	ApprovalScoreWorkFlow approvalScoreWorkFlow;
	
    @When("User adds Approval Score on program")
    @Then("User adds Approval Score on program")
	public void userAddsAApprovalScore() {
		Assert.assertTrue("ApprovalScore is added successfully", approvalScoreWorkFlow.userAddsNewApprovalScore());
		}

	@When("user verifies and edits Approval Score")
	public void userVerifiesAndEditsApprovalScore() {
    	approvalScoreWorkFlow.userVerifiesAndEditsNewApprovalScore();
    }
   
	@When("User adds Approval Score on program As $type")
	@Then("User adds Approval Score on program As $type")
	public void userAddsAApprovalScore(String type) {
		Assert.assertTrue("ApprovalScore is added successfully", approvalScoreWorkFlow.userAddsNewApprovalScore(type));
	}
}
