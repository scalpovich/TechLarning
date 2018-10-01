package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AuthorizationRequest;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AuthorizationRequestPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class ManualAuthorizationWorkflow {

	@Autowired
	private Navigator navigator;

	AuthorizationRequestPage page;

	public String authorizeDevice(AuthorizationRequest request){
		page = navigator.navigateToPage(AuthorizationRequestPage.class);
		return page.addAuthorizationRequest(request);
	}

	public String getDeclineReasonMessage(String declineReasonCode) {
		return page.getDeclineReasonMessage(declineReasonCode);
	}

}
