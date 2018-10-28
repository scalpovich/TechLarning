package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditBureauVerificationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class CreditBureauVerificationBatchFlow {

	@Autowired
	Navigator navigator;
	
	private CreditBureauVerificationPage creditBureauVerificationPage;
	
	public void processCreditBureauVerificationBatch() {
		creditBureauVerificationPage = navigator.navigateToPage(CreditBureauVerificationPage.class);
		creditBureauVerificationPage.creditBureauVerificationBatchProcess();
		creditBureauVerificationPage.switchToManualApprovalLink();
	}
}
