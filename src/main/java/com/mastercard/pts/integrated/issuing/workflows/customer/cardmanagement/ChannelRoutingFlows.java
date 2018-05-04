package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ChannelRoutingPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ChannelRoutingPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Component
public class ChannelRoutingFlows{
 
	@Autowired
	Navigator navigator;

	 
	public void addChannelRoutingPlan(ChannelRoutingPlan channelroutingplan) {
		ChannelRoutingPage page = navigator.navigateToPage(ChannelRoutingPage.class);
		page.addRoutingDetails(channelroutingplan);
		
	}

}