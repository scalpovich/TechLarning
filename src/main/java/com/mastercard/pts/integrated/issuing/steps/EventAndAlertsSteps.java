package com.mastercard.pts.integrated.issuing.steps;

import java.util.Collection;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.EventAndAlertsFlows;

/**
 * @author E074127
 * 
 *
 */

@Component
public class EventAndAlertsSteps extends AbstractBaseFlows {

	final Logger logger = LoggerFactory
			.getLogger(EventAndAlertsSteps.class);


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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}