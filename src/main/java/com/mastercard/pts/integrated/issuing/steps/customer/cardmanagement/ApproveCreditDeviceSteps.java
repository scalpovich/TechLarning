package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ApproveRejectApplicationFlows;

@Component
public class ApproveCreditDeviceSteps {

	@Autowired
	ApproveRejectApplicationFlows approveRejectApplicationFlows;
	
	@Given("user approves the credit application device")
	@Then("user approves the credit application device")
	@When("user approves the credit application device")
	public void verifyCreditDeviceAfterApplicaionCreation()
	{
		approveRejectApplicationFlows.approveRejectCreditApplication();
	}
}
