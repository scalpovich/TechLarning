package com.mastercard.pts.integrated.issuing.workflows.cardholder.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.ActivateDeactivateWalletPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.ActivatePairedDevicePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.BlockDevicePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.ECommActivationPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.InternationalUseActivationPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.ReplaceDevicePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.UnblockDevicePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CardHolderUiVerificationServicesWorkflow {
	@Autowired
	private Navigator navigator;

	String blockDevice = "Blocking the device";
	String unblockDevice = "Unblocking the device";

	public void verifyActivateDeactivateWalletPage() {
		ActivateDeactivateWalletPage page = navigator.navigateToPage(ActivateDeactivateWalletPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyActivatePairedDevicePage() {
		ActivatePairedDevicePage page = navigator.navigateToPage(ActivatePairedDevicePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBlockDevicePage() {
		BlockDevicePage page = navigator.navigateToPage(BlockDevicePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyECommActivationPage() {
		ECommActivationPage page = navigator.navigateToPage(ECommActivationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInternationalUseActivationPage() {
		InternationalUseActivationPage page = navigator.navigateToPage(InternationalUseActivationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyReplaceDevicePage() {
		ReplaceDevicePage page = navigator.navigateToPage(ReplaceDevicePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyUnblockDevicePage() {
		UnblockDevicePage page = navigator.navigateToPage(UnblockDevicePage.class);
		page.verifyUiOperationStatus();
	}

	public void blockDevice() {
		BlockDevicePage page = navigator.navigateToPage(BlockDevicePage.class);
		page.enterCardBlockRemark(blockDevice);
		page.confirmCardBlockRequest();
	}

	public void unblockDevice() {
		UnblockDevicePage page = navigator
				.navigateToPage(UnblockDevicePage.class);
		page.enterCardUnblockRemerk(unblockDevice);
		page.confirmUnblockCardRequestBtn();
	}

}
