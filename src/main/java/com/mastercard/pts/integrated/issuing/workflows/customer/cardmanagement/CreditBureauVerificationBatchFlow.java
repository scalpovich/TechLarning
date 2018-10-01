package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditBureauVerificationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CreditBureauVerificationBatchFlow {

	@Autowired
	Navigator navigator;
	
	private CreditBureauVerificationPage creditBureauVerificationPage;
	
	public void processCreditBureauVerificationBatch() {
		creditBureauVerificationPage = navigator.navigateToPage(CreditBureauVerificationPage.class);
		creditBureauVerificationPage.creditBureauVerificationBatchProcess();
	}
}
