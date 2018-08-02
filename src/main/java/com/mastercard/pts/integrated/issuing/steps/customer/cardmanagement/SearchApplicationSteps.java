package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SearchApplicationDetailsFlows;

@Component
public class SearchApplicationSteps {
	
	@Autowired
	SearchApplicationDetailsFlows searchApplicationDetailsFlows;

	@When("user searches for created application")
	public void searchApplicationDetails(){
		searchApplicationDetailsFlows.searchApplicationDetails();
	}
	
}
