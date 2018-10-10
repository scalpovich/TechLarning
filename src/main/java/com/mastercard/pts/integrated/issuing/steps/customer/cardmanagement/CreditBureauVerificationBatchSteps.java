package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CreditBureauVerificationBatchFlow;

@Component
public class CreditBureauVerificationBatchSteps {
	
	@Autowired
	CreditBureauVerificationBatchFlow creditBureauVerificationBatchFlow;

	@When("user processesAll creditBureauVerification batch for new Application")
	public void creditBureauVerificationBatchExecution() {
		creditBureauVerificationBatchFlow.processCreditBureauVerificationBatch();
	}
}
