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

	public Set<String> getEventAlertJobId() {
		String Query1 = DBQueryConstant.EVENTSALERTS_SMS_QUERY;

		System.out.println(Query1);
		return connutils.getAllValuesOfAColumn(Query1, DBQueryConstant.JOBID_EVENTSALERTS_COLUMN);

	}

	public String getEventsAlertsJobId() {
		Set<String> list = getEventAlertJobId();
		String CARD = "";
		for (String card : list) {

			CARD = card;
		}
		System.out.println(CARD);

		return CARD;

	}

	public void checkEventAlertJobIdCreated(EventsAndAlerts eventsAndAlerts) {
		EventAlertHistoryPage page = navigator.navigateToPage(EventAlertHistoryPage.class);
		page.checkEventGeneratedForSMSEmail(getEventsAlertsJobId(), eventsAndAlerts);
	}
}