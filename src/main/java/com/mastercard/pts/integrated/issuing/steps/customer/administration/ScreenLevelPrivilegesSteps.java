package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.ReportLevelPrivilegesWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.ScreenLevelPrivilegesWorkflow;

@Component
public class ScreenLevelPrivilegesSteps extends AbstractBaseFlows {

	@Autowired
	ScreenLevelPrivilegesWorkflow screenLevelPrivilegesFlows;

	@Autowired
	ReportLevelPrivilegesWorkflow reportLevelPrivilegesFlows;

	@When("admin provides the $screen level privileges for the the newly created $user")
	public void providePrivilegesUser(@Named("screen") String privilegeType,
			@Named("user") String entityType) {
		switch (privilegeType) {
		case "screen":
		case "Screen":
			screenLevelPrivilegesFlows
					.provideScreenLevelPrivilegesFlows(entityType);
			break;
		case "report":
		case "Report":
			reportLevelPrivilegesFlows
					.provideReportLevelPrivilegesFlows(entityType);
			break;
		default:
			screenLevelPrivilegesFlows
					.provideScreenLevelPrivilegesFlows(entityType);
			reportLevelPrivilegesFlows
					.provideReportLevelPrivilegesFlows(entityType);
			break;
		}

	}

}
