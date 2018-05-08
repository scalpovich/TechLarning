package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AggregateLoadLimit;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AggregateLoadLimitPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Component
public class AggregateLoadLimitFlow{
 
	@Autowired
	Navigator navigator;

	 
	public void addAggregateLimitPlan(AggregateLoadLimit aggregatelimit) {
 		AggregateLoadLimitPage page = navigator.navigateToPage(AggregateLoadLimitPage.class);
		page.addAggregateLoadDetails(aggregatelimit);
		
	}

}