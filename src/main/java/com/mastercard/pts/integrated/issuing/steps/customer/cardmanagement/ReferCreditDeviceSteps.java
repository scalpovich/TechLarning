package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ReferApplicationFlows;

@Component
public class ReferCreditDeviceSteps {

	@Autowired
	ReferApplicationFlows referApplicationFlows;
	
	@When("user refers the credit application device")
	public void referCreditDeviceAfterApplicaionCreation(){
		referApplicationFlows.referCreditApplication();
	}
}
