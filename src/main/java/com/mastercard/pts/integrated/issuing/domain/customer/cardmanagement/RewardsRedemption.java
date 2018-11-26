package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

@Component
public class RewardsRedemption {

	private static final String LOYALTY_PLAN = "LOYALTY_PLAN12";
	private static final String POINTS_TO_REDEEM = "POINTS_TO_REDEEM";

	private String deviceNumber;

	private String loyaltyPlan;

	private String pointsToRedeem;

	public String getPointsToRedeem() {
		return pointsToRedeem;
	}

	public void setPointsToRedeem(String pointsToRedeem) {
		this.pointsToRedeem = pointsToRedeem;
	}

	public String getLoyaltyPlan() {
		return loyaltyPlan;
	}

	public void setLoyaltyPlan(String loyaltyPlan) {
		this.loyaltyPlan = loyaltyPlan;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public static RewardsRedemption createWithProvider(KeyValueProvider provider) {
		RewardsRedemption rewardsRedemption = new RewardsRedemption();
		rewardsRedemption.setLoyaltyPlan(provider.getString(LOYALTY_PLAN));
		rewardsRedemption.setPointsToRedeem(provider.getString(POINTS_TO_REDEEM));
		return rewardsRedemption;
	}

}