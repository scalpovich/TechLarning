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
	public void userAddsAApprovalScore()
	{
		Boolean approvalScore=approvalScoreWorkFlow.userAddsNewApprovalScore();
		Assert.assertTrue("ApprovalScore is not added", approvalScore);
	}
   @When("user verifies edit and verify Approval Score") 
    public void userVerifiesAndEditsApprovalScore()
    {
    	approvalScoreWorkFlow.userVerifiesAndEditsNewApprovalScore();
    }
   
   @When("User adds Approval Score on program for auto reject")
   @Then("User adds Approval Score on program for auto reject")
	public void userAddsAApprovalScoreForAutoReject()
	{
		Boolean approvalScore=approvalScoreWorkFlow.userAddsNewApprovalScoreForAutoReject();
		Assert.assertTrue("ApprovalScore is not added for auto reject", approvalScore);
	}
   
   @When("User adds Approval Score on program for auto refer")
   @Then("User adds Approval Score on program for auto refer")
	public void userAddsAApprovalScoreForAutoRefer()
	{
		Boolean approvalScore=approvalScoreWorkFlow.userAddsNewApprovalScoreForAutoRefer();
		Assert.assertTrue("ApprovalScore is not added for auto refer", approvalScore);
	}
}
