package com.mastercard.pts.integrated.issuing.domain.customer.loyalty;

import org.springframework.stereotype.Component;

/**
 * @author e076177
 *
 */
@Component
public class LoyaltyRedemption {

	private String deviceNumber;
	private String loyalPlan;
	private String search;
	private String loyaltyPoints;
	private String redemptionMethodAccount;
	private String redemptionMethodVendor;
	private String redeem;

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getLoyalPlan() {
		return loyalPlan;
	}

	public void setLoyalPlan(String loyalPlan) {
		this.loyalPlan = loyalPlan;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(String loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getRedemptionMethodAccount() {
		return redemptionMethodAccount;
	}

	public void setRedemptionMethodAccount(String redemptionMethodAccount) {
		this.redemptionMethodAccount = redemptionMethodAccount;
	}

	public String getRedemptionMethodVendor() {
		return redemptionMethodVendor;
	}

	public void setRedemptionMethodVendor(String redemptionMethodVendor) {
		this.redemptionMethodVendor = redemptionMethodVendor;
	}

	public String getRedeem() {
		return redeem;
	}

	public void setRedeem(String redeem) {
		this.redeem = redeem;
	}

	public String getPointsRedeemed() {
		return pointsRedeemed;
	}

	public void setPointsRedeemed(String pointsRedeemed) {
		this.pointsRedeemed = pointsRedeemed;
	}

	private String pointsRedeemed;

}
