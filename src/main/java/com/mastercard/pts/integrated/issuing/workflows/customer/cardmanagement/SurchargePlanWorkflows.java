package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SurchargePlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Workflow
public class SurchargePlanWorkflows {

	@Autowired
	private Navigator navigator;

	private SurchargePlanPage page;

	public void createSurchargePlanWithDetails(SurchargePlan plan) {
		page = navigator.navigateToPage(SurchargePlanPage.class);
		page.createSurchargePlanWithDetails(plan);
	}

	public String getFeedbackText() {
		page.SwitchToDefaultFrame();
		
		return page.getFeedbackText();
	}
	
	public boolean isNoRecordsFoundInTableView(SurchargePlan plan) {
		page.enterPlanCodeInSearchBox(plan);
		page.clickSearchButton();
		
		return page.isNoRecordsFoundInTableView();
	}

}
