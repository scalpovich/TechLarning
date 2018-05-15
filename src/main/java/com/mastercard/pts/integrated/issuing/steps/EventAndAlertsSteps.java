package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.EventAndAlertsFlows;

/**
 * @author E074127
 * 
 *
 */

@Component
public class EventAndAlertsSteps extends AbstractBasePage {

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private EventAndAlertsFlows eventAndAlertsFlows;

	private EventsAndAlerts eventsAndAlerts;

	@When("user adds an Event and Alert in the system")
	public void addNewEventAndAlertSteps() {
		eventsAndAlerts = EventsAndAlerts.createWithProvider(provider);
		eventAndAlertsFlows.addEventAndAlertFlows(eventsAndAlerts);
	}

}