package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskPrivileges;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.HelpdeskLevelPrivilegesWorkflow;

@Component
public class HelpdeskLevelPrivilegesSteps {
	@Autowired
	HelpdeskLevelPrivilegesWorkflow helpdeskLevelPrivilegesFlows;

	@Autowired
	private KeyValueProvider provider;

	HelpdeskPrivileges helpdeskPreviliges;

	@Autowired
	TestContext context;

	@When("admin provides the helpdesk level privileges - $Assign_Service_Code for the the newly created $user")
	public void provideHelpdeskLevelPrivileges(
			@Named("Assign_Service_Code") String subType,
			@Named("user") String entityType) {
		UserCreation userCreation = context.get(ContextConstants.USER);
		helpdeskPreviliges = HelpdeskPrivileges.createWithProvider(provider);
		helpdeskLevelPrivilegesFlows.provideHelpdeskLevelPrivilegesFlows(
				subType, helpdeskPreviliges, userCreation);
	}
}
