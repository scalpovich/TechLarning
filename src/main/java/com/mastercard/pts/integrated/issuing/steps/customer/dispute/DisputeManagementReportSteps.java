package com.mastercard.pts.integrated.issuing.steps.customer.dispute;

import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.dispute.DisputesManagementReportWorkflow;

@Component
public class DisputeManagementReportSteps {

	@Autowired
	private DisputesManagementReportWorkflow disputeManagementReportWorkflow;

	@Then("verify report for Potential  Chargeback Reports is downloaded")
	public void verifyReportForTransactionsWithProgramBalanceSummaryIsDownloaded() {
		Assert.assertTrue(disputeManagementReportWorkflow.verifyDisputeReportGeneration());
	}
}