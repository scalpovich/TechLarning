package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoyaltyPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.LoyaltyTransactionPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class LoyaltyTransactionFlows {

	@Autowired
	private Navigator navigator;

	public void selectTransactions(LoyaltyPlan loyaltyplan) {
		LoyaltyTransactionPlanPage page = navigator.navigateToPage(LoyaltyTransactionPlanPage.class);
		page.searchLoyaltyTransactionPlan(loyaltyplan);
	}

}
