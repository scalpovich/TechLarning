package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeDupeSDNVerificationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

/**
 * @author e084017
 *
 */
@Component
public class DeDupeSDNVerificationWorkflow {
	
	@Autowired
	private Navigator navigator;
	
	@Autowired
	private DeDupeSDNVerificationPage deDupeSDNVerificationPage;
	
	public Boolean verifyApproveRejectTheApplication(String operation) {
		deDupeSDNVerificationPage = navigator.navigateToPage(DeDupeSDNVerificationPage.class);
		return deDupeSDNVerificationPage.approveRejectApplication(operation);
	}
	
	public String verifyDuplicateApplication() {
		deDupeSDNVerificationPage = navigator.navigateToPage(DeDupeSDNVerificationPage.class);
		return deDupeSDNVerificationPage.checkDuplicateApplication();
	}
}