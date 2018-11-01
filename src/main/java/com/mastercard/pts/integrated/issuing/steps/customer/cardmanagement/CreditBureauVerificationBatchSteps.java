package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CreditBureauVerificationBatchFlow;

@Component
public class CreditBureauVerificationBatchSteps {
	
	@Autowired
	CreditBureauVerificationBatchFlow creditBureauVerificationBatchFlow;

	@When("user processesAll creditBureauVerification batch for new Application")
	@Then("user processesAll creditBureauVerification batch for new Application")
	public void creditBureauVerificationBatchExecution() {
		creditBureauVerificationBatchFlow.processCreditBureauVerificationBatch();
	}
	
	@When("user process batch in credit bureau verification for new Application")
	@Then("user process batch in credit bureau verification for new Application")
	public void processRiskAnalysisBatch() {
		Assert.assertEquals("Record Added Successfully.", creditBureauVerificationBatchFlow.processBatchForCreditBureauVerification());
	}
}
