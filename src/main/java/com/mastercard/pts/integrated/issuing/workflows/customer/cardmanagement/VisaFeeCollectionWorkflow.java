package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaFeeCollection;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.VisaFeeCollectionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
@Workflow
public class VisaFeeCollectionWorkflow {
	@Autowired
	private Navigator navigator;
	public void addVisaFeeCollectionRecord(VisaFeeCollection visafeecollection,String transactionCode) {
		VisaFeeCollectionPage page = navigator.navigateToPage(VisaFeeCollectionPage.class);
		page.addVisaFeeCollection(visafeecollection,transactionCode);
	}
}
