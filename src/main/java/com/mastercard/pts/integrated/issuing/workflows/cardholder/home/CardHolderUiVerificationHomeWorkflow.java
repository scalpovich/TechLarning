package com.mastercard.pts.integrated.issuing.workflows.cardholder.home;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.cardholder.CardholderHomePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow

public class CardHolderUiVerificationHomeWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyHomePage() {
		CardholderHomePage page = navigator.navigateToPage(CardholderHomePage.class);
		page.verifyUiOperationStatus();
	}

}
