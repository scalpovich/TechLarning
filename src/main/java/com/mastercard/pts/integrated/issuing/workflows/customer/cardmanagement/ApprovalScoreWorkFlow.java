package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApprovalScorePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class ApprovalScoreWorkFlow {
	@Autowired
	private Navigator navigator;
	
    private ApprovalScorePage approvalScorePage;
	public boolean userAddsNewApprovalScore()
	{
		approvalScorePage = navigator.navigateToPage(ApprovalScorePage.class);
		approvalScorePage.addApproverScorePlan();
		approvalScorePage.addMandatoryLabelsAndFields();
		approvalScorePage.selectProgram();
		approvalScorePage.selectAction(1);
		approvalScorePage.enterStartRangeValue();
		approvalScorePage.enterEndRangeValue();
		approvalScorePage.settingMandatoryValuesWithLabels();
		approvalScorePage.saveButtonClick();
		return approvalScorePage.successMessageDisplay();
	}
	public void userVerifiesAndEditsNewApprovalScore()
	{
	approvalScorePage.verifyUiOperationStatus();
	}
	
	public boolean userAddsNewApprovalScore(String type) {
		approvalScorePage = navigator.navigateToPage(ApprovalScorePage.class);
		approvalScorePage.addApproverScorePlan();
		approvalScorePage.addMandatoryLabelsAndFields();
		approvalScorePage.selectProgram();

		if (type.equalsIgnoreCase("Refer"))
			approvalScorePage.selectAction(3);
		else if (type.equalsIgnoreCase("Approve"))
			approvalScorePage.selectAction(1);
		else if (type.equalsIgnoreCase("Reject"))
			approvalScorePage.selectAction(2);

		approvalScorePage.enterStartRangeValue();
		approvalScorePage.enterEndRangeValue();
		approvalScorePage.settingMandatoryValuesWithLabels();
		approvalScorePage.saveButtonClick();
		return approvalScorePage.successMessageDisplay();
	}
}