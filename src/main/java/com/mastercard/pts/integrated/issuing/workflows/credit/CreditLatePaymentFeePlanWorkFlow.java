package com.mastercard.pts.integrated.issuing.workflows.credit;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LatePaymentFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CreditLatePaymentFeePlanWorkFlow {
	@Autowired
	private Navigator navigator;
	@Autowired
	LatePaymentFeePlanPage page;
	public void userCreatesAValidLatePaymentFeePlan()
	{
		 page = navigator.navigateToPage(LatePaymentFeePlanPage.class);
		 page.addLatePaymentFeePlan();
	}
}
