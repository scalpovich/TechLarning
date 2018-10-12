package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.RewardsRedemption;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.loyalty.RewardRedemptionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class RewardsRedemptionFlows {

	@Autowired
	private Navigator navigator;

	public void verifyRewardsRedemptionScreen(Device device, RewardsRedemption rewardsRedemption,
			KeyValueProvider provider) {
		RewardRedemptionPage rewards = navigator.navigateToPage(RewardRedemptionPage.class);
		rewards.searchForRewardsRedemption(device);
		rewards.selectLoyaltyPlan(rewardsRedemption);
		rewards.redeemScreen(rewardsRedemption);
		rewards.verifyLoyaltyPointsRedeemed(provider);
	}

	public void verifyRewardsRedemptionScreenForCumulativeTxn(Device device, RewardsRedemption rewardsRedemption,
			KeyValueProvider provider) {
		RewardRedemptionPage rewards = navigator.navigateToPage(RewardRedemptionPage.class);
		rewards.searchForRewardsRedemption(device);
		rewards.selectLoyaltyPlan(rewardsRedemption);
		rewards.redeemScreen(rewardsRedemption);
		rewards.verifyLoyaltyPointsRedeemedforCumulative(provider, rewardsRedemption);
	}

	public void verifyRewardsPointsNotAvb(Device device, RewardsRedemption rewardsRedemption) {
		RewardRedemptionPage rewards = navigator.navigateToPage(RewardRedemptionPage.class);
		rewards.searchForRewardsRedemption(device);
		rewards.selectLoyaltyPlan(rewardsRedemption);
		rewards.verifyLoyaltyPointsNotRedeemed();
	}
}
