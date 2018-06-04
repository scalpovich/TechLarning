package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyPayoutListPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CurrencyPayoutListPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Workflow
public class CurrencyPayoutListFlows {
	@Autowired
	private Navigator navigator;

	private CurrencyPayoutListPlanPage page;

	public void createCurrencyPayoutListPlanWithDetails(CurrencyPayoutListPlan plan) {
		page = navigator.navigateToPage(CurrencyPayoutListPlanPage.class);
		page.createCurrencyPayoutListPlanWithDetails(plan);
	}

	public String getFeedbackText() {
		page.SwitchToDefaultFrame();
		
		return page.getFeedbackText();
	}
	
	public boolean isNoRecordsFoundInTableView(CurrencyPayoutListPlan plan) {
		page.enterPlanCodeInSearchBox(plan);
		page.clickSearchButton();
		
		return page.isNoRecordsFoundInTableView();
	}
}
