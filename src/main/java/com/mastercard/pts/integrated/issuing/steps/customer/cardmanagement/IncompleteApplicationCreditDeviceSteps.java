package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.IncompleteApplicationFlows;

/**
 * @author e084017
 *
 */
@Component
public class IncompleteApplicationCreditDeviceSteps {

	@Autowired
	IncompleteApplicationFlows incompleteApplicationFlows;

	@Given("user checks in Incomplete Application for the credit application device")
	@Then("user checks in Incomplete Application for the credit application device")
	@When("user checks in Incomplete Application for the credit application device")
	public void incompleteApplicationCreditDeviceAfterApplicaionCreation() {
		incompleteApplicationFlows.incompleteCreditApplication();
	}

	@When("user checks in Incomplete Application for the credit application device for fileUpload")
	public void incompleteApplicationCreditDeviceAfterApplicaionCreationFileUpload() {
		incompleteApplicationFlows.incompleteCreditApplicationFileUpload();
	}

}
