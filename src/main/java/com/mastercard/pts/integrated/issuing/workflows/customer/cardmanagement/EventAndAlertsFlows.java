package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EventsAndAlerts;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EventsAndAlertsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;

@Component
public class EventAndAlertsFlows {

	private EventsAndAlertsPage eventAlertPage;

	@Autowired
	private Navigator navigator;

	@Autowired
	private ReadTestDataFromExcel dataReader;

	public void templateMapping() {
		eventAlertPage = navigator.navigateToPage(EventsAndAlertsPage.class);
		eventAlertPage.mapTemplates1(dataReader.dataProvider(
				"EventAlertsTemplateMapping", "Event"));
	}

	public void addEventAndAlertFlows(EventsAndAlerts eventsAndAlerts) {
		eventAlertPage = navigator.navigateToPage(EventsAndAlertsPage.class);
		eventAlertPage.addEventAndAlerts(eventsAndAlerts);
	}
}
