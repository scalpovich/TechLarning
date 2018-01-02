package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.credit.ApprovalScoreWorkFlow;

@Component
public class ApprovalScoreSteps {
	@Autowired
	ApprovalScoreWorkFlow approvalScoreWorkFlow;
    @When("user navigates to Approval Score Page and add a approvalScore")
	public void userAddsAApprovalScore()
	{
		approvalScoreWorkFlow.userAddsNewApprovalScore();
		//approvalScoreWorkFlow.verifyIsRecordAddedinTable();
	}
   @When("user verifies edit and verify Approval Score") 
    public void userVerifiesAndEditsApprovalScore()
    {
    	approvalScoreWorkFlow.userVerifiesAndEditsNewApprovalScore();
    }
}
