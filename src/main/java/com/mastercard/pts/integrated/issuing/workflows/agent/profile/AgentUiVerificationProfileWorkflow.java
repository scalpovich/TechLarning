package com.mastercard.pts.integrated.issuing.workflows.agent.profile;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.profile.*;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AgentUiVerificationProfileWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyChangePasswordPage() {
		ChangePasswordPage page = navigator.navigateToPage(ChangePasswordPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyEntityDetailsPage() {
		EntityDetailsPage page = navigator.navigateToPage(EntityDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyViewProfilePage() {
		ViewProfilePage page = navigator.navigateToPage(ViewProfilePage.class);
		page.verifyUiOperationStatus();
	}

}