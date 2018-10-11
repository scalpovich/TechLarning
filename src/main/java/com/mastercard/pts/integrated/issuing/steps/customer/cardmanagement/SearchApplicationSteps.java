package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
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
	
	@When("user searches for created application for fileUpload")
	public void searchApplicationDetailsForFileUpload() {
		searchApplicationDetailsFlows.searchApplicationDetailsForFileUpload();
	}
	
	@Then("application status appeared as rejected on search application screen")
	public void thenApplicationStatusAppearedRejected(){
		Assert.assertTrue("Application status not appeared as rejected", searchApplicationDetailsFlows.verifyApplicationIsRejected());
	}
	
	@Then("application status appeared as refered on search application screen")
	public void thenApplicationStatusAppearedRefered(){
		Assert.assertTrue("Application status not appeared as rejected", searchApplicationDetailsFlows.verifyApplicationIsRefered());
	}
}
