package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.administration.ReportLevelPrivilegesPage;

@Component
public class ReportLevelPrivilegesWorkflow {
	@Autowired
	ReportLevelPrivilegesPage reportLevelPrivilegesPage;

	public void provideReportLevelPrivilegesFlows(String entityType) {
		reportLevelPrivilegesPage.assignReportLevelPrivileges(entityType);
	}
}
