package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DeviceJoiningAndMemberShipFeePlanDetails {
	
	private LocalDate effectiveDate;
	private LocalDate endDate;
	private String feeType;
	private String postIssuanceFeeOn;
	private String postIssuanceFeeOnForCreditCard;
	private int effectiveDateStartDays;
	private int effectiveDateEndDays;
	
	public static DeviceJoiningAndMemberShipFeePlanDetails createWithProvider(DataProvider provider) {
		DeviceJoiningAndMemberShipFeePlanDetails plan = provider.getDataBySimpleClassName(DeviceJoiningAndMemberShipFeePlanDetails.class);
		plan.setEffectiveDate(LocalDate.now().plusDays(plan.getEffectiveDateStartDays()));
		plan.setEndDate(plan.getEffectiveDate().plusDays(plan.getEffectiveDateEndDays()));
		return plan;
	}
	
	public String getFeeType() {
		return feeType;
	}
	
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	
	public String getPostIssuanceFeeOn() {
		return postIssuanceFeeOn;
	}

	public void setPostIssuanceFeeOn(String postIssuanceFeeOn) {
		this.postIssuanceFeeOn = postIssuanceFeeOn;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}

	public String getPostIssuanceFeeOnForCreditCard() {
		return postIssuanceFeeOnForCreditCard;
	}

	public void setPostIssuanceFeeOnForCreditCard(
			String postIssuanceFeeOnForCreditCard) {
		this.postIssuanceFeeOnForCreditCard = postIssuanceFeeOnForCreditCard;
	}

	public int getEffectiveDateEndDays() {
		return effectiveDateEndDays;
	}

	public void setEffectiveDateEndDays(int effectiveDateEndDays) {
		this.effectiveDateEndDays = effectiveDateEndDays;
	}

	public int getEffectiveDateStartDays() {
		return effectiveDateStartDays;
	}

	public void setEffectiveDateStartDays(int effectiveDateStartDays) {
		this.effectiveDateStartDays = effectiveDateStartDays;
	}
}
