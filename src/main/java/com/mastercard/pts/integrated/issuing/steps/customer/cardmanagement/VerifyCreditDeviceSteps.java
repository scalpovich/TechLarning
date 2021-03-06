package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.VerifyCreditApplicationFlows;

@Component
public class VerifyCreditDeviceSteps {

	@Autowired
	VerifyCreditApplicationFlows verifyCreditApplicationFlows;
	
	@Given("user verifies the credit application device")
	@Then("user verifies the credit application device")
	@When("user verifies the credit application device")
	public void verifyCreditDeviceAfterApplicaionCreation(){
		verifyCreditApplicationFlows.verifyCreditApplication();
	}
	
	@When("user verifies the credit application device for fileUpload")
	public void verifyCreditDeviceAfterApplicaionCreationFileUpload() {
		verifyCreditApplicationFlows.verifyCreditApplicationFileUpload();
	}
}
