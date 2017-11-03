package com.mastercard.pts.integrated.issuing.workflows.customer.dispute;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.DisputesManagementReportPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReconciliationWorkFlow;

@Workflow
public class DisputesManagementReportWorkflow extends ReconciliationWorkFlow {


	@Autowired
	private Navigator navigator;
	
	public boolean verifyDisputeReportGeneration() {
		DisputesManagementReportPage page = navigator.navigateToPage(DisputesManagementReportPage.class);
		int fileCountBeforeReportGeneration = checkDownLoadedFilesCount();
		page.downloadPotentialChargeBackReport();
		int fileCountAfterReportGeneration = waitForReportToDownLoad(fileCountBeforeReportGeneration);
		return (fileCountAfterReportGeneration - fileCountBeforeReportGeneration == 1) ? true : false;
	}
}
