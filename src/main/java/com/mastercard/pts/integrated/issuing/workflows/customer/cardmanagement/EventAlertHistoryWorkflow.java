package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.*;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class EventAlertHistoryWorkflow {

	@Autowired
	private Navigator navigator;

	public String verifyEventOnEventAndAlertPage() {
		EventAlertHistoryPage page = navigator.navigateToPage(EventAlertHistoryPage.class);
		page.fillEventAlertHistoryPage();
		return page.verifyEvent();
	}
}