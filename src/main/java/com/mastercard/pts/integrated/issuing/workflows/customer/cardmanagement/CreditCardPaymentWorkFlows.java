package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CashPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class CreditCardPaymentWorkFlows {
	
	@Autowired
	private Navigator navigator;
	
	@Autowired
	TestContext context;
	
	CashPage cashPage;
	
	public void makeCashPayment(Payment cashPay){
		cashPage = navigator.navigateToPage(CashPage.class);
		cashPage.performCashPayment(cashPay);
	}
}
