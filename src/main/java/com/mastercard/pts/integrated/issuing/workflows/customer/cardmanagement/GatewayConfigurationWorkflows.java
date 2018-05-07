package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GatewayConfiguration;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.GatewayConfigurationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Workflow
public class GatewayConfigurationWorkflows {
	@Autowired
	private Navigator navigator;

	private GatewayConfigurationPage page;

	public void createGatewayConfigurationWithDetails(GatewayConfiguration plan) {
		page = navigator.navigateToPage(GatewayConfigurationPage.class);
		if(plan.getEmailProtocol().equals("ESB"))
		page.createGatewayConfigurationwithESB(plan);
		else if(plan.getEmailProtocol().equals("SMTP [SMTP]"))
		page.createGatewayConfigurationwithSMTP(plan);	
	}

	public String getFeedbackText() {
		return page.getFeedbackText();
	}
	
	public boolean isNoRecordsFoundInTableView(GatewayConfiguration plan) {
		//page.enterPlanCodeInSearchBox(plan);
		page.clickSearchButton();
		return page.isNoRecordsFoundInTableView();
	}
}
