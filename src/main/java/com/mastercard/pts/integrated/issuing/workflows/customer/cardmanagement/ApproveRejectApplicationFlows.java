package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApproveRejectPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class ApproveRejectApplicationFlows {
	@Autowired
	Navigator navigator;
	
	public String approveRejectCreditApplication()
	{
		ApproveRejectPage approveRejectPage = navigator.navigateToPage(ApproveRejectPage.class);
		approveRejectPage.approveRejectApplication();
		approveRejectPage.approveApplication();
		return approveRejectPage.approveApplication();
	}
}
