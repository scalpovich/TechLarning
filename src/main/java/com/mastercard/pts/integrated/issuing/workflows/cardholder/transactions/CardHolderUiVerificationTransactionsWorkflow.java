package com.mastercard.pts.integrated.issuing.workflows.cardholder.transactions;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.CancelRemittanceBookingPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.CashRemittanceBookingPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.FundTransferPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CardHolderUiVerificationTransactionsWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyCancelRemittanceBookingPage() {
		CancelRemittanceBookingPage page = navigator.navigateToPage(CancelRemittanceBookingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCashRemittanceBookingPage() {
		CashRemittanceBookingPage page = navigator.navigateToPage(CashRemittanceBookingPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyFundTransferPage() {
		FundTransferPage page = navigator.navigateToPage(FundTransferPage.class);
		page.verifyUiOperationStatus();
	}

}
