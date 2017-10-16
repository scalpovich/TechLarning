package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.administration.HelpdeskLevelPrivilegesWorkflow;

@Component
public class HelpdeskLevelPrivilegesSteps {
	@Autowired
	HelpdeskLevelPrivilegesWorkflow helpdeskLevelPrivilegesFlows;

	@When("admin provides the helpdesk level privileges - $Assign_Service_Code for the the newly created $user")
	public void provideHelpdeskLevelPrivileges(
			@Named("Assign_Service_Code") String subType,
			@Named("user") String entityType) {
		helpdeskLevelPrivilegesFlows.provideHelpdeskLevelPrivilegesFlows(
				subType, entityType);
	}
}
