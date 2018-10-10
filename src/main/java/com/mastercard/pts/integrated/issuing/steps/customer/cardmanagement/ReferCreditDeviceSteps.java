package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReferCreditApplicationFlows;

/**
 * @author e084017
 *
 */
@Component
public class ReferCreditDeviceSteps {

	@Autowired
	ReferCreditApplicationFlows referCreditApplicationFlows;
	
	@Given("user refer the credit application device")
	@Then("user refer the credit application device")
	@When("user refer the credit application device")
	public void referCreditDeviceAfterApplicaionCreation() {
		referCreditApplicationFlows.referCreditApplication();
	}

	@When("user refer the credit application device for fileUpload")
	public void referCreditDeviceAfterApplicaionCreationFileUpload() {
		referCreditApplicationFlows.referCreditApplicationFileUpload();
	}
}
