package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ManualAlerts;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ManualAlertsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class ManualAlertsFlows {

	@Autowired
	Navigator navigator;

	public void addManualAlerts(ManualAlerts alert) {
		ManualAlertsPage page = navigator.navigateToPage(ManualAlertsPage.class);
		page.clickAddcurrency();
		page.addAlertDetails(alert);
	}


}