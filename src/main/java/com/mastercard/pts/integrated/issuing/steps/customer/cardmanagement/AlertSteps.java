package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertFalse;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.dispute.DisputeWorkflow;

@Component
public class AlertSteps {

	@Autowired
	private DataProvider provider;

	@Autowired
	private DisputeWorkflow disputeWorkflow;

	private String eventJobId;

	@When("user searches for alert from database")
	public void whenUserSearchesForAlertFromDatabase(){
		eventJobId =disputeWorkflow.getEventTriggerFromDb(Institution.createWithProvider(provider).getCode());
	}
	
	@Then("verify that alert was successfully triggeredold")
	public void thenVerifyThatAlertWasSuccessfullyTriggered(){
		assertFalse("no event tirggers available in database",eventJobId == null);
	}
}
