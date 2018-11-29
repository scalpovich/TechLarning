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
		Assert.assertTrue("Approval Score is added successfully", approvalScoreWorkFlow.userAddsNewApprovalScore());
	}

	@When("user verifies and edits Approval Score")
	public void userVerifiesAndEditsApprovalScore() {
    	approvalScoreWorkFlow.userVerifiesAndEditsNewApprovalScore();
    }
   
	@When("User adds Approval Score on program As $type")
	@Then("User adds Approval Score on program As $type")
	public void userAddsAApprovalScore(String type) {
		Assert.assertTrue("Approval Score is added successfully", approvalScoreWorkFlow.userAddsNewApprovalScore(type));
	}
   
   @When("User adds Approval Score on program for auto refer")
   @Then("User adds Approval Score on program for auto refer")
	public void userAddsAApprovalScoreForAutoRefer()
	{
		Assert.assertTrue("ApprovalScore is not added for auto refer", approvalScoreWorkFlow.userAddsNewApprovalScoreForAutoRefer());
	}
   
   @When("User adds Approval Score on program for auto reject")
   @Then("User adds Approval Score on program for auto reject")
	public void userAddsAApprovalScoreForAutoReject()
	{
		Assert.assertTrue("ApprovalScore is not added for auto refer", approvalScoreWorkFlow.userAddsNewApprovalScoreForAutoRefer());
	}
   
   
   @When("User adds Approval Score on program with less end range for auto reject")
   @Then("User adds Approval Score on program with less end range for auto reject")
	public void userAddsAApprovalScoreForOutsideRange()
	{
		Assert.assertTrue("ApprovalScore is not added", approvalScoreWorkFlow.userAddsNewApprovalScoreWithLessEndRangeForAutoReject());
	}
}
