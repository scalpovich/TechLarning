package com.mastercard.pts.integrated.issuing.workflows.collect.home;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.collect.CollectHomePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CollectUiVerificationHomeWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyHomePage() {
		CollectHomePage page = navigator.navigateToPage(CollectHomePage.class);
		page.verifyUiOperationStatus();
	}

}
