package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCGLimitPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MCGLimitPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Workflow
public class MCGLimitPlanWorkflows {
	@Autowired
	private Navigator navigator;

	private MCGLimitPlanPage page;

	public MCGLimitPlan createMCGLimitPlanWithDetails(MCGLimitPlan plan) {
		page = navigator.navigateToPage(MCGLimitPlanPage.class);
		return page.createMCGLimitPlanWithDetails(plan);
	}

	public String getFeedbackText() {
		page.switchToDefaultFrame();
		return page.getMessageFromFeedbackPanel();
	}
	
	public boolean isNoRecordsFoundInTableView(MCGLimitPlan plan) {
		page.enterPlanCodeInSearchBox(plan);
		page.clickSearchButton();
		return page.isNoRecordsFoundInTable();
	}
}
