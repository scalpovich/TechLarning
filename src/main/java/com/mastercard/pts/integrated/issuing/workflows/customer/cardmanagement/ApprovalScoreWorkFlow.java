package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

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
	public boolean userAddsNewApprovalScore()
	{
		approvalScorePage = navigator.navigateToPage(ApprovalScorePage.class);
		approvalScorePage.addApproverScorePlan();
		approvalScorePage.addMandatoryLabelsAndFields();
		approvalScorePage.selectProgram();
		approvalScorePage.selectAction();
		approvalScorePage.enterStartRangeValue();
		approvalScorePage.enterEndRangeValue();
		approvalScorePage.settingMandatoryValuesWithLabels();
		approvalScorePage.saveButtonClick();
		return approvalScorePage.successMessageDiplay();
	}
	public void userVerifiesAndEditsNewApprovalScore()
	{
	approvalScorePage.verifyUiOperationStatus();
	}
	
	
}