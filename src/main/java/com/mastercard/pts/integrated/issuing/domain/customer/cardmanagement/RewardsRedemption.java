package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class RewardsRedemption {

	private String deviceNumber;

	private String loyaltyPlan;

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
}
