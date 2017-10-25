package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MarketingMessagePlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class MarketingMessagePlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createMarketingMessagePlan(DeviceCreation deviceCreation, MarketingMessagePlan marketingmsg) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		MarketingMessagePlanPage mktMsgPlanpage = navigator.navigateToPage(MarketingMessagePlanPage.class);
		mktMsgPlanpage.clickAddMarketingMessagePlan();
		String marketingmessageplan = mktMsgPlanpage.addmarketingMessagePlanDetails(deviceCreation);
		mktMsgPlanpage.clickSaveButton();
		mktMsgPlanpage.clickAddMarketingMessageDetails();
		mktMsgPlanpage.addmarketingMessagedetails(marketingmsg);
		return marketingmessageplan;
	}

}
