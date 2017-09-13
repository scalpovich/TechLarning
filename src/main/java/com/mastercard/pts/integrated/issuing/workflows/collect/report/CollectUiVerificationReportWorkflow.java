package com.mastercard.pts.integrated.issuing.workflows.collect.report;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.collect.report.ReportHomePage;
import com.mastercard.pts.integrated.issuing.pages.collect.report.ReportsPage;
import com.mastercard.pts.integrated.issuing.pages.collect.report.StatCardPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CollectUiVerificationReportWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyStatCardPage() {
		StatCardPage page = navigator.navigateToPage(StatCardPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyReportsPage() {
		ReportsPage page = navigator.navigateToPage(ReportsPage.class);
		page.verifyUiOperationStatus();
	}
	
	public void verifyReportsHomePage() {
		ReportHomePage page = navigator.navigateToPage(ReportHomePage.class);
		page.verifyUiOperationStatus();
	}
}
