package com.mastercard.pts.integrated.issuing.workflows.agent.transactions;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.*;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AgentUiVerificationTransactionsWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyBalanceEnquiryPage() {
		BalanceEnquiryPage page = navigator.navigateToPage(BalanceEnquiryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBalanceRefundApprovePage() {
		BalanceRefundApprovePage page = navigator.navigateToPage(BalanceRefundApprovePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyBalanceRefundRequestPage() {
		BalanceRefundRequestPage page = navigator.navigateToPage(BalanceRefundRequestPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCancelCardToCashPage() {
		CancelCardToCashPage page = navigator.navigateToPage(CancelCardToCashPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCardToCashLookupPage() {
		CardToCashLookupPage page = navigator.navigateToPage(CardToCashLookupPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCardToCashTransactionPage() {
		CardToCashTransactionPage page = navigator.navigateToPage(CardToCashTransactionPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyCashRemittancePayoutPage() {
		CashRemittancePayoutPage page = navigator.navigateToPage(CashRemittancePayoutPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoadBalanceApprovePage() {
		LoadBalanceApprovePage page = navigator.navigateToPage(LoadBalanceApprovePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoadBalanceRequestPage() {
		LoadBalanceRequestPage page = navigator.navigateToPage(LoadBalanceRequestPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyLoadBalanceViewPendingRequestsPage() {
		LoadBalanceViewPendingRequestsPage page = navigator.navigateToPage(LoadBalanceViewPendingRequestsPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionHistoryPage() {
		TransactionHistoryPage page = navigator.navigateToPage(TransactionHistoryPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransactionsViewChargesPage() {
		TransactionsViewChargesPage page = navigator.navigateToPage(TransactionsViewChargesPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyTransferFundsPage() {
		TransferFundsPage page = navigator.navigateToPage(TransferFundsPage.class);
		page.verifyUiOperationStatus();
	}

}