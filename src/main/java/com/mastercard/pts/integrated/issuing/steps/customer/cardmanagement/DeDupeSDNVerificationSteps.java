package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeDupeSDNVerificationWorkflow;

/**
 * @author e084017
 *
 */
@Component
public class DeDupeSDNVerificationSteps {
	
	@Autowired
	DeDupeSDNVerificationWorkflow dedupeSDNVerificationWorkflow;

	@Autowired
	TestContext context;
	
	@When("$approvesReject duplicate application caught on dedupeSDN")
	@Then("$approvesReject duplicate application caught on dedupeSDN")
	public void whenApplicationCaughtonDedupeSDNThenApproveReject(String operation){
		Assert.assertTrue("Application Not Approved/Rejected",dedupeSDNVerificationWorkflow.verifyApproveRejectTheApplication(operation));
	}
	
	@When("verify duplicate application caught on dedupeSDN")
	@Then("verify duplicate application caught on dedupeSDN")
	public void whenDuplicateApplicationCaughtonDedupeSDN(){
		Device device = context.get(ContextConstants.DEVICE);
		String dedupeAppliaction = dedupeSDNVerificationWorkflow.verifyDuplicateApplication();
		Assert.assertTrue("Application Number Not Found",device.getApplicationNumber().equals(dedupeAppliaction));
	}
}
