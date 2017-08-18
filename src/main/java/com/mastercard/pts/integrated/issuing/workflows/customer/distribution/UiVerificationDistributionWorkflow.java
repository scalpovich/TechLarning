package com.mastercard.pts.integrated.issuing.workflows.customer.distribution;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.distribution.AcceptanceOfReturnedInventoryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.distribution.ActivityReportsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.distribution.CourierMasterPage;
import com.mastercard.pts.integrated.issuing.pages.customer.distribution.DispatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.distribution.DistributionOrderCancellationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.distribution.InterestMasterPage;
import com.mastercard.pts.integrated.issuing.pages.customer.distribution.SettlementConfirmationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class UiVerificationDistributionWorkflow {

	@Autowired
	private Navigator navigator;

	public void verifyAcceptanceOfReturnedInventoryPage() {
		AcceptanceOfReturnedInventoryPage page = navigator
				.navigateToPage(AcceptanceOfReturnedInventoryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyActivityReportsPage() {
		ActivityReportsPage page = navigator
				.navigateToPage(ActivityReportsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCourierMasterPage() {
		CourierMasterPage page = navigator
				.navigateToPage(CourierMasterPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDispatchPage() {
		DispatchPage page = navigator.navigateToPage(DispatchPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDistributionOrderCancellationPage() {
		DistributionOrderCancellationPage page = navigator
				.navigateToPage(DistributionOrderCancellationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInterestMasterPage() {
		InterestMasterPage page = navigator
				.navigateToPage(InterestMasterPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySettlementConfirmationPage() {
		SettlementConfirmationPage page = navigator
				.navigateToPage(SettlementConfirmationPage.class);
		page.verifyUiOperationStatus();
	}

}
