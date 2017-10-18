package com.mastercard.pts.integrated.issuing.workflows.agent.transactions;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.BalanceEnquiryPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.BalanceRefundApprovePage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.BalanceRefundRequestPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.CancelCardToCashPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.CardToCashLookupPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.CardToCashTransactionPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.CashRemittancePayoutPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.LoadBalanceApprovePage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.LoadBalanceRequestPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.LoadBalanceViewPendingRequestsPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.TransactionHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.TransferFundsPage;
import com.mastercard.pts.integrated.issuing.pages.agent.transactions.TransactionsViewChargesPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class TransactionsWorkflow {
	private BalanceEnquiryPage bepage;
	private BalanceRefundApprovePage brapage;
	private BalanceRefundRequestPage brrpage;
	private CancelCardToCashPage cccpage;
	private CardToCashLookupPage cclpage;
	private CardToCashTransactionPage cctpage;
	private CashRemittancePayoutPage crppage;
	private LoadBalanceApprovePage lbapage;
	private LoadBalanceRequestPage lbrpage;
	private LoadBalanceViewPendingRequestsPage lbvprpage;
	private TransactionHistoryPage thpage;
	private TransferFundsPage tfpage;
	private TransactionsViewChargesPage vcpage;

	
	@Autowired
	private Navigator navigator;
	
	public void navigateToBalanceEnquiryPage() {
		bepage = navigator.navigateToPage(BalanceEnquiryPage.class);
	}

	public String getBalanceEnquiryMasterDetailContentTitleText() {
		return bepage.getMasterDetailContentTitleText();
	}
	
	public void navigateToBalanceRefundApprovePage() {
		brapage = navigator.navigateToPage(BalanceRefundApprovePage.class);
	}

	public String getBalanceRefundApproveMasterDetailContentTitleText() {
		return brapage.getMasterDetailContentTitleText();
	}
	
	public void navigateToBalanceRefundRequestPage() {
		brrpage = navigator.navigateToPage(BalanceRefundRequestPage.class);
	}

	public String getBalanceRefundRequestMasterDetailContentTitleText() {
		return brrpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCancelCardToCashPage() {
		cccpage = navigator.navigateToPage(CancelCardToCashPage.class);
	}

	public String getCancelCardToCashMasterDetailContentTitleText() {
		return cccpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCardToCashLookupPage() {
		cclpage = navigator.navigateToPage(CardToCashLookupPage.class);
	}

	public String getCardToCashLookupMasterDetailContentTitleText() {
		return cclpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCardToCashTransactionPage() {
		cctpage = navigator.navigateToPage(CardToCashTransactionPage.class);
	}

	public String getCardToCashTransactionMasterDetailContentTitleText() {
		return cctpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCashRemittancePayoutPage() {
		crppage = navigator.navigateToPage(CashRemittancePayoutPage.class);
	}

	public String getCashRemittancePayoutMasterDetailContentTitleText() {
		return crppage.getMasterDetailContentTitleText();
	}
	
	public void navigateToLoadBalanceApprovePage() {
		lbapage = navigator.navigateToPage(LoadBalanceApprovePage.class);
	}

	public String getLoadBalanceApproveMasterDetailContentTitleText() {
		return lbapage.getMasterDetailContentTitleText();
	}
	
	public void navigateToLoadBalanceRequestPage() {
		lbrpage = navigator.navigateToPage(LoadBalanceRequestPage.class);
	}

	public String getLoadBalanceRequestMasterDetailContentTitleText() {
		return lbrpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToLoadBalanceViewPendingRequestsPage() {
		lbvprpage = navigator.navigateToPage(LoadBalanceViewPendingRequestsPage.class);
	}

	public String getLoadBalanceViewPendingRequestsMasterDetailContentTitleText() {
		return lbvprpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToTransactionHistoryPage() {
		thpage = navigator.navigateToPage(TransactionHistoryPage.class);
	}

	public String getTransactionHistoryMasterDetailContentTitleText() {
		return thpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToTransferFundsPage() {
		tfpage = navigator.navigateToPage(TransferFundsPage.class);
	}

	public String getTransferFundsMasterDetailContentTitleText() {
		return tfpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToViewChargesPage() {
		vcpage = navigator.navigateToPage(TransactionsViewChargesPage.class);
	}

	public String getViewChargesMasterDetailContentTitleText() {
		return vcpage.getMasterDetailContentTitleText();
	}
}
