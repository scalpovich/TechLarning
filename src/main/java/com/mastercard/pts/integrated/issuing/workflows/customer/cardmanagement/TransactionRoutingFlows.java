package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionRoutingPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionRoutingPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class TransactionRoutingFlows {
	
	@Autowired
	Navigator navigator;

	public void addTransactionRouting(TransactionRoutingPlan transRoutingPlan) {
		TransactionRoutingPage page = navigator.navigateToPage(TransactionRoutingPage.class);
		page.clickAddcurrency();
		page.addRoutingDetails(transRoutingPlan); 
	}


}
