package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarkupFeePlan;
import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MarkupFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class MarkUpFeeWorkflow {
	
	@Autowired
	Navigator navigator;
	
	@Autowired
	private PageObjectFactory pageFactory;

	public void addMarkUpPlan(MarkupFeePlan plan) {
		MarkupFeePlanPage page = navigator.navigateToPage(MarkupFeePlanPage.class);
		page.createMarkupFeePlanPage(plan);		
	}
}
