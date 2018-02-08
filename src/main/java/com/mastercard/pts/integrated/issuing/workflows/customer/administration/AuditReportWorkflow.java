package com.mastercard.pts.integrated.issuing.workflows.customer.administration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.AuditReport;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.AuditReportPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Workflow
public class AuditReportWorkflow extends AbstractBaseFlows {
	@Autowired
	private Navigator navigator;
	
	public boolean validateAuditReportForAdaptiveAuthentication(AuditReport auditreport)
	{
		AuditReportPage page=navigator.navigateToPage(AuditReportPage.class);
		page.selectReport(auditreport);
		page.clickGoButton();
		page.selectOperation(auditreport);
		page.selectUserId(auditreport);
		page.selectScreenName(auditreport);
		page.selectFileType(auditreport);
		page.selectReportGenerationMode(auditreport);
		page.clickSubmitButton();
		return false;
		
	}
}
