package com.mastercard.pts.integrated.issuing.workflows.cardholder.virtualcard;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.RequestForLimitedValidityVirtualCardPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.VirtualCardDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.VirtualCardLimitedValidityVirtualCardCancellationPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.VirtualPrepaidCardRequestPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CardHolderUiVerificationVirtualCardWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyRequestForLimitedValidityVirtualCardPage() {
		RequestForLimitedValidityVirtualCardPage page = navigator.navigateToPage(RequestForLimitedValidityVirtualCardPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVirtualCardDetailsPage() {
		VirtualCardDetailsPage page = navigator.navigateToPage(VirtualCardDetailsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVirtualCardLimitedValidityVirtualCardCancellationPage() {
		VirtualCardLimitedValidityVirtualCardCancellationPage page = navigator.navigateToPage(VirtualCardLimitedValidityVirtualCardCancellationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyVirtualPrepaidCardRequestPage() {
		VirtualPrepaidCardRequestPage page = navigator.navigateToPage(VirtualPrepaidCardRequestPage.class);
		page.verifyUiOperationStatus();
	}

}
