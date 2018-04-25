package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.EventAlertHistoryWorkflow;

@Component
public class EventAlertHistorySteps {

	@Autowired
	EventAlertHistoryWorkflow eventAlertHistoryWorkflow;

	private String date;

	@Autowired
	EventsAndAlerts eventsAndAlerts;

	@When("user searches for alert on ui")
	public void whenUserSearchesForAlertOnUi() {
		date = eventAlertHistoryWorkflow.verifyEventOnEventAndAlertPage();
	}

	@Then("verify that alert was successfully triggered")
	public void thenVerifyThatAlertWasSuccessfullyTriggered() {
		assertThat("Event Not Triggered Today!", date, is(DateUtils.getLocalDateInYYYYMMDD()));
	}

	@Then("verify the alert is generated succesfully for $3DSecureOTP")
	public void verifyEventGenerated(@Named("3DSecureOTP") String secureOTP) {
		eventsAndAlerts.setEventID(secureOTP);
		eventAlertHistoryWorkflow.checkEventAlertJobIdCreated(eventsAndAlerts);
	}
}
