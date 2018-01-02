package com.mastercard.pts.integrated.issuing.workflows.credit;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApprovalScorePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class ApprovalScoreWorkFlow {
	@Autowired
	private Navigator navigator;
	@Autowired
    ApprovalScorePage approvalScorePage;
	public void userAddsNewApprovalScore()
	{
		approvalScorePage = navigator.navigateToPage(ApprovalScorePage.class);
		approvalScorePage.addApprovalScore();
	}
	public void userVerifiesAndEditsNewApprovalScore()
	{
	approvalScorePage.verifyUiOperationStatus();
	}
	
	
}