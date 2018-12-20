package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SearchApplicationDetailsFlows;

@Component
public class SearchApplicationSteps {
	
	@Autowired
	TestContext context;
	
	@Autowired
	SearchApplicationDetailsFlows searchApplicationDetailsFlows;

	@When("user searches for created application")
	@Then("user searches for created application")
	public void searchApplicationDetails(){
		searchApplicationDetailsFlows.searchApplicationDetails();
	}
	
	@When("user searches for created application for fileUpload")
	public void searchApplicationDetailsForFileUpload() {
		searchApplicationDetailsFlows.searchApplicationDetailsForFileUpload();
	}
	
	@Then("application status $appeared as $status on search application screen")
	public void thenApplicationStatusAppearedRejected(String appeared, String status){
		Device device = context.get(CreditConstants.APPLICATION);
		
		if ("rejected".equalsIgnoreCase(status)) {

			if ("appeared".equalsIgnoreCase(appeared)) {
				Assert.assertTrue(
						"Application status not appeared as rejected",
						searchApplicationDetailsFlows.verifyApplicationIsRejected(device));
			} else {
				Assert.assertFalse("Application status appeared as rejected",
						searchApplicationDetailsFlows.verifyApplicationIsRejected(device));
			}
		} else if ("refered".equalsIgnoreCase(status)) {
			Assert.assertTrue("Application status not appeared as rejected", searchApplicationDetailsFlows.verifyApplicationIsRefered(device));
		}
	}
}
