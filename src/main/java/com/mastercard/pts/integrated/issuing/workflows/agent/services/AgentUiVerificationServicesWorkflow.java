package com.mastercard.pts.integrated.issuing.workflows.agent.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.services.*;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AgentUiVerificationServicesWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyActivateDeactivateSubAccountPage() {
		ActivateDeactivateSubAccountPage page = navigator.navigateToPage(ActivateDeactivateSubAccountPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyApplicationCorrectionPage() {
		ApplicationCorrectionPage page = navigator.navigateToPage(ApplicationCorrectionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyChangeCurrencyPriorityPage() {
		ChangeCurrencyPriorityPage page = navigator.navigateToPage(ChangeCurrencyPriorityPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCheckerPage() {
		CheckerPage page = navigator.navigateToPage(CheckerPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCurrencySetupPage() {
		CurrencySetupPage page = navigator.navigateToPage(CurrencySetupPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDedupeReverificationApprovalPage() {
		DedupeReverificationApprovalPage page = navigator.navigateToPage(DedupeReverificationApprovalPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDeviceSalePage() {
		DeviceSalePage page = navigator.navigateToPage(DeviceSalePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInstantDeviceReplacementPage() {
		InstantDeviceReplacementPage page = navigator.navigateToPage(InstantDeviceReplacementPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyKYCUpdatePage() {
		KYCUpdatePage page = navigator.navigateToPage(KYCUpdatePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLimitedValidityVirtualCardCancellationPage() {
		LimitedValidityVirtualCardCancellationPage page = navigator.navigateToPage(LimitedValidityVirtualCardCancellationPage.class);
		page.verifyUiOperationStatus();
	}

}