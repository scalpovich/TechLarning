package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CashPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LocalChequePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.OutstationChequeCollectionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.OutstationChequeProcessingPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class CreditCardPaymentWorkFlows {

	@Autowired
	private Navigator navigator;

	LocalChequePage localChqPage;
	CashPage cashPage;
	OutstationChequeCollectionPage outstationChequeCollectionPage;
	OutstationChequeProcessingPage outstationChequeProcessingPage;

	public void makeCashPayment(Payment cashPay) {
		cashPage = navigator.navigateToPage(CashPage.class);
		cashPage.performCashPayment(cashPay);
	}
}
