package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeDupeSDNVerificationWorkflow;

/**
 * @author e084017
 *
 */
@Component
public class DeDupeSDNVerificationSteps {
	
	@Autowired
	DeDupeSDNVerificationWorkflow dedupeSDNVerificationWorkflow;
	
	@When("approves duplicate application caught on dedupeSDN")
	@Then("approves duplicate application caught on dedupeSDN")
	public void whenApplicationCaughtonDedupeSDNThenApprove(){
		Assert.assertTrue("Application Not Approved",dedupeSDNVerificationWorkflow.verifyAndApproveTheApplication());
	}
	
	@When("reject duplicate application caught on dedupeSDN")
	@Then("reject duplicate application caught on dedupeSDN")
	public void whenApplicationCaughtonDedupeSDNThenReject(){
		Assert.assertTrue("Application Not Rejected",dedupeSDNVerificationWorkflow.verifyAndRejectTheApplication());
	}
}
