package com.mastercard.pts.integrated.issuing.workflows.customer.dispute;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ArbitrationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ArbitrationTypePage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ChargeBackCancellationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ChargeBackModifyPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ChargeBackNewPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ChargebackReasonCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ChargeBackReversalPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.DisputeHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.DisputesManagementReportPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.ManualDisputePostingPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.RePresentmentReasonCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.RetrievalRequestReasonCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.RetrivalRequestPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.RetrivalResponsePage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.SecondChargeBackCancellationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.SecondChargeBackModifyPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.SecondChargeBackNewPage;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.SecondChargeBackReversalPage;

@Workflow
public class UiVerifcationDisputeWorkflow {

	@Autowired
	private Navigator navigator;

	public void verifyArbitrationPage() {
		ArbitrationPage page = navigator.navigateToPage(ArbitrationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyArbitrationTypePage() {
		ArbitrationTypePage page = navigator.navigateToPage(ArbitrationTypePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyChargeBackCancellationPage() {
		ChargeBackCancellationPage page = navigator.navigateToPage(ChargeBackCancellationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyChargeBackModifyPage() {
		ChargeBackModifyPage page = navigator.navigateToPage(ChargeBackModifyPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyChargeBackNewPage() {
		ChargeBackNewPage page = navigator.navigateToPage(ChargeBackNewPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyChargebackReasonCodePage() {
		ChargebackReasonCodePage page = navigator.navigateToPage(ChargebackReasonCodePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyChargeBackReversalPage() {
		ChargeBackReversalPage page = navigator.navigateToPage(ChargeBackReversalPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDisputeHistoryPage() {
		DisputeHistoryPage page = navigator.navigateToPage(DisputeHistoryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyManualDisputePostingPage() {
		ManualDisputePostingPage page = navigator.navigateToPage(ManualDisputePostingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRePresentmentReasonCodePage() {
		RePresentmentReasonCodePage page = navigator.navigateToPage(RePresentmentReasonCodePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRetrievalRequestReasonCodePage() {
		RetrievalRequestReasonCodePage page = navigator.navigateToPage(RetrievalRequestReasonCodePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRetrivalRequestPage() {
		RetrivalRequestPage page = navigator.navigateToPage(RetrivalRequestPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyRetrivalResponsePage() {
		RetrivalResponsePage page = navigator.navigateToPage(RetrivalResponsePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySecondChargeBackCancellationPage() {
		SecondChargeBackCancellationPage page = navigator.navigateToPage(SecondChargeBackCancellationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySecondChargeBackModifyPage() {
		SecondChargeBackModifyPage page = navigator.navigateToPage(SecondChargeBackModifyPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySecondChargeBackNewPage() {
		SecondChargeBackNewPage page = navigator.navigateToPage(SecondChargeBackNewPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifySecondChargeBackReversalPage() {
		SecondChargeBackReversalPage page = navigator.navigateToPage(SecondChargeBackReversalPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyDisputesManagementReportPage() {
		DisputesManagementReportPage page = navigator.navigateToPage(DisputesManagementReportPage.class);
		page.verifyUiOperationStatus();
	}

}
