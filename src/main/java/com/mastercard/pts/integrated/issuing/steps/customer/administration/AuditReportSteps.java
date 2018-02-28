package com.mastercard.pts.integrated.issuing.steps.customer.administration;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.admin.AuditReport;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.AuditReportWorkflow;

@Component
public class AuditReportSteps {

	@Autowired
	AuditReportWorkflow auditReportWorkflow;
	
	@Autowired
	AuditReport auditreport;
	
	@Then("configuration changes should be audited in audit report")
	public void validateChangesInAuditReport() {
		AuditReport auditreport=AuditReport.getAuditReportData();
		auditReportWorkflow.validateAuditReportForAdaptiveAuthentication(auditreport);
	}
	
}
