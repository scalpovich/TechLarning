package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EventAlertHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConnectionUtils;
import com.mastercard.pts.integrated.issuing.utils.DBQueryConstant;

@Workflow
public class EventAlertHistoryWorkflow {

	@Autowired
	private Navigator navigator;

	@Autowired
	ConnectionUtils connutils;

	public String verifyEventOnEventAndAlertPage() {
		EventAlertHistoryPage page = navigator.navigateToPage(EventAlertHistoryPage.class);
		page.fillEventAlertHistoryPage();
		return page.verifyEvent();
	}

	public Set<String> getEventAlertJobId(EventsAndAlerts eventsAndAlerts) {
		String Query1 = null;
		if (eventsAndAlerts.getEventID().contains("SMS")) {
			Query1 = DBQueryConstant.EVENTSALERTS_SMS_QUERY;
		}
		if (eventsAndAlerts.getEventID().contains("Email")) {
			Query1 = DBQueryConstant.EVENTSALERTS_EMAIL_QUERY;
		}

		return connutils.getAllValuesOfAColumn(Query1, DBQueryConstant.JOBID_EVENTSALERTS_COLUMN);

	}

	public String getEventsAlertsJobId(EventsAndAlerts eventsAndAlerts) {
		Set<String> list = getEventAlertJobId(eventsAndAlerts);
		String eventJobid = "";
		for (String card : list) {
			eventJobid = card;
		}
		return eventJobid;

	}

	public void checkEventAlertJobIdCreated(EventsAndAlerts eventsAndAlerts) {
		EventAlertHistoryPage page = navigator.navigateToPage(EventAlertHistoryPage.class);
		page.checkEventGeneratedForSMSEmail(getEventsAlertsJobId(eventsAndAlerts), eventsAndAlerts);
	}
}