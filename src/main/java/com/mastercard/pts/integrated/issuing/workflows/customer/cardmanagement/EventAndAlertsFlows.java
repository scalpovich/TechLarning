package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EventsAndAlertsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;

@Component
public class EventAndAlertsFlows {

	private EventsAndAlertsPage eventAlert;

	@Autowired
	private Navigator navigator;

	@Autowired
	private ReadTestDataFromExcel dataReader;

	public void templateMapping() {
		eventAlert = navigator.navigateToPage(EventsAndAlertsPage.class);
		eventAlert.mapTemplates1(dataReader.dataProvider(
				"EventAlertsTemplateMapping", "Event"));
	}
}
