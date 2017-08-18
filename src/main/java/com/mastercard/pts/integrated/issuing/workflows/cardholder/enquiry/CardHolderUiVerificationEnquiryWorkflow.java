package com.mastercard.pts.integrated.issuing.workflows.cardholder.enquiry;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry.CashRemittancesPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry.TransactionsPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry.ViewChargesPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CardHolderUiVerificationEnquiryWorkflow {
	@Autowired
	private Navigator navigator;

	 public void verifyTransactionsPage() {
		  TransactionsPage page = navigator.navigateToPage(TransactionsPage.class);
		  page.verifyUiOperationStatus();
		}

		 public void verifyCashRemittancesPage() {
		  CashRemittancesPage page = navigator.navigateToPage(CashRemittancesPage.class);
		  page.verifyUiOperationStatus();
		}

		 public void verifyViewChargesPage() {
		  ViewChargesPage page = navigator.navigateToPage(ViewChargesPage.class);
		  page.verifyUiOperationStatus();
		}



}
