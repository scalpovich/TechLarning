package com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.EventAlertsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class EventAlertsWorkflow {
	private EventAlertsPage page;
	
	@Autowired
	private Navigator navigator;
	
	public void navigateToEventAlertsPage() {
		page = navigator.navigateToPage(EventAlertsPage.class);
	}

	public String getCreateRoleMasterDetailContentTitleText() {
		return page.getMasterDetailContentTitleText();
	}
}
