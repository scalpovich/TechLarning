package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.RewardsRedemption;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.RewardRedemptionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class RewardsRedemptionFlows {

	@Autowired
	private Navigator navigator;

	public void verifyRewardsRedemptionScreen(RewardsRedemption rewardsRedemption) {
		RewardRedemptionPage rewards = navigator.navigateToPage(RewardRedemptionPage.class);
		rewards.searchForRewardsRedemption(rewardsRedemption);
		rewards.selectLoyaltyPlan(rewardsRedemption);
	}
}
