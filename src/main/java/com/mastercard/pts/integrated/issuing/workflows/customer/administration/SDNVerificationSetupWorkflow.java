package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.administration.SDNVerificationSetupPage;

@Component
public class SDNVerificationSetupWorkflow {
	@Autowired
	SDNVerificationSetupPage sdnVerificationSetupPage;

	public void addSDNVerificationSetup() {
		sdnVerificationSetupPage.clickOnAddSDNVerification();
	}
}
