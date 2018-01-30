package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaFeeCollection;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.VisaFeeCollectionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
@Workflow
public class VisaFeeCollectionWorkflow {
	@Autowired
	private Navigator navigator;
	@Autowired
	private TestContext context;
	@Autowired
	protected DateUtils date;
	
	public void addVisaFeeCollectionRecord(VisaFeeCollection visafeecollection) {
		VisaFeeCollectionPage page = navigator.navigateToPage(VisaFeeCollectionPage.class);
		page.addVisaFeeCollection(visafeecollection);
		String message=page.getSuccessMessage();
		Assert.assertEquals(message, Constants.Record_Added_Successfully);
	}
}