package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountRangeRoutingPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountRangeRoutingPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Component
public class AccountRangeRoutingFlows{
 
	@Autowired
	Navigator navigator;

	 
	public void addChannelRoutingPlan(AccountRangeRoutingPlan accountrangeroutingplan) {
		AccountRangeRoutingPage page = navigator.navigateToPage(AccountRangeRoutingPage.class);
		page.addRoutingDetails(accountrangeroutingplan);
		
	}

}