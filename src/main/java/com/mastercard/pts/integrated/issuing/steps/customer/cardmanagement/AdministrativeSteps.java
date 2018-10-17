package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AdministrativeFlows;

public class AdministrativeSteps {
	@Autowired
	AdministrativeFlows administrativeFlows;
	
	@When("user update $status Administrative as $response")
	public void userUpdateAdministrativeSetting(String status,String response){
		administrativeFlows.updateAdministrativeSetting(status,response);
	}
	
}
