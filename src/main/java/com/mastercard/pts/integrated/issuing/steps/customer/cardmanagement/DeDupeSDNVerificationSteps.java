package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
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
	
	@Given("verify duplicate application caught on dedupeSDN and then approve")
	@When("verify duplicate application caught on dedupeSDN and then approve")
	@Then("verify duplicate application caught on dedupeSDN and then approve")
	public void whenApplicationCaughtonDedupeSDNThenApprove(){
		Boolean approvedSuccess = dedupeSDNVerificationWorkflow.verifyAndApproveTheApplication();
		Assert.assertTrue(approvedSuccess);
	}

}
