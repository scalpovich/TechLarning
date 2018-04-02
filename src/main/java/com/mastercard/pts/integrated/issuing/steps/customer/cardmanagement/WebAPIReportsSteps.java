package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WebAPIReports;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionReportsWorkflows;

@Component
public class WebAPIReportsSteps {

	@Autowired
	TransactionReportsWorkflows transactionReprtflows;

	@Autowired
	WebAPIReports webapiReport;

	@When("user generates web api details $format report for $Information")
	public void whenUserGeneratesWebApiDetailsReportFor3283DSecureInformation(@Named("Information") String Info,
			@Named("format") String reportFormat) {
		webapiReport.setReportType(Info);
		webapiReport.setReportFormat(reportFormat);
		transactionReprtflows.generateWebAPIDetailReport(webapiReport);
	}

	@Then("report should get generated")
	public void thenReportShouldGetGenerated() {
		transactionReprtflows.verifyWebAPIReportGeneration();
	}
}