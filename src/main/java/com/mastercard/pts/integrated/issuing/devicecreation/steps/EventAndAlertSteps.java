package com.mastercard.pts.integrated.issuing.devicecreation.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.EventAndAlertsFlows;

@Component
public class EventAndAlertSteps {
	
	@Autowired
	public EventsAndAlerts eventAlerts;	
	
	@Autowired
	private EventAndAlertsFlows eventAlertflow;

	@When("user map different prepaid events with event templates for $prepaid product")
	public void mapTemplates(@Named("product") String productType) {
		eventAlerts.setProductType(ProductType.fromShortName(productType));				
	}

	@Then("all events gets configured for all issuing events")
	public void verifyEventsWithTempletes() {
		eventAlertflow.templateMapping();
	}
}
