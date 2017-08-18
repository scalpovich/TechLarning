package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class WalletFeePlanDetails {

	private static final String FEE_TYPE = "FEE_TYPE";

	private static final String MEMBERSHIP_FEE_POSTING = "MEMBERSHIP_FEE_POSTING";
	
	private String feeType;
	
	private LocalDate effectiveDate;
	
	private LocalDate endDate;

	private String membershipFeePosting;
	
	public static WalletFeePlanDetails createWithProvider(KeyValueProvider provider) {
		WalletFeePlanDetails details = new WalletFeePlanDetails();
		details.setFeeType(provider.getString(FEE_TYPE));
		details.setEffectiveDate(LocalDate.now().plusDays(1));
		details.setEndDate(details.getEffectiveDate().plusDays(5));
		details.setMembershipFeePosting(provider.getString(MEMBERSHIP_FEE_POSTING));
		return details;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getMembershipFeePosting() {
		return membershipFeePosting;
	}

	public void setMembershipFeePosting(String membershipFeePosting) {
		this.membershipFeePosting = membershipFeePosting;
	}

}
