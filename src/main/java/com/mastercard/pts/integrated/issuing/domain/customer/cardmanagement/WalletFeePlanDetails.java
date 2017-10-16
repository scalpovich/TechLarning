package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class WalletFeePlanDetails {

	private static final String FEE_TYPE = "FEE_TYPE";
	private static final String MEMBERSHIP_FEE_POSTING = "MEMBERSHIP_FEE_POSTING";
	
	private static final String WFP_DETAILS_FEE_TYPE	 = 	"WFP_DETAILS_FEE_TYPE";
	private static final String WFP_DETAILS_EFFECTIVE_DATE	 = 	"WFP_DETAILS_EFFECTIVE_DATE";
	private static final String WFP_DETAILS_END_DATE	 = 	"WFP_DETAILS_END_DATE";
	private static final String WFP_DETAILS_FEE	 = 	"WFP_DETAILS_FEE";
	private static final String WFP_DETAILS_SIGNUP_FEE_POSTING	 = 	"WFP_DETAILS_SIGNUP_FEE_POSTING";
	private static final String WFP_DETAILS_MEMBERSHIP_FEE_POSTING	 = 	"WFP_DETAILS_MEMBERSHIP_FEE_POSTING";
	private static final String WFP_DETAILS_WAIVE_NO_OF_CYCLES	 = 	"WFP_DETAILS_WAIVE_NO_OF_CYCLES";

	
	private String feeType;
	private LocalDate effectiveDate;
	private LocalDate endDate;
	private String membershipFeePosting;
	private String fee;
	private String signUpFee;
	private String waiveNoOfCycles;

	
	public static WalletFeePlanDetails createWithProvider(KeyValueProvider provider) {
		WalletFeePlanDetails details = new WalletFeePlanDetails();
		details.setFeeType(provider.getString(FEE_TYPE));
		details.setEffectiveDate(LocalDate.now().plusDays(1));
		details.setEndDate(details.getEffectiveDate().plusDays(5));
		details.setMembershipFeePosting(provider.getString(MEMBERSHIP_FEE_POSTING));
		return details;
	}
	
	public static WalletFeePlanDetails createWithProviderForRegression(KeyValueProvider provider) {
		WalletFeePlanDetails details = new WalletFeePlanDetails();
		details.setFeeType(provider.getString(WFP_DETAILS_FEE_TYPE));
		details.setEffectiveDate(LocalDate.now().plusDays(provider.getInt(WFP_DETAILS_EFFECTIVE_DATE)));
		details.setEndDate(LocalDate.now().plusDays(provider.getInt(WFP_DETAILS_END_DATE)));
		details.setFee(provider.getString(WFP_DETAILS_FEE));
		details.setSignUpFee(provider.getString(WFP_DETAILS_SIGNUP_FEE_POSTING));
		details.setMembershipFeePosting(provider.getString(WFP_DETAILS_MEMBERSHIP_FEE_POSTING));
		details.setWaiveNoOfCycles(provider.getString(WFP_DETAILS_WAIVE_NO_OF_CYCLES));
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

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getSignUpFee() {
		return signUpFee;
	}

	public void setSignUpFee(String signUpFee) {
		this.signUpFee = signUpFee;
	}

	public String getWaiveNoOfCycles() {
		return waiveNoOfCycles;
	}

	public void setWaiveNoOfCycles(String waiveNoOfCycles) {
		this.waiveNoOfCycles = waiveNoOfCycles;
	}

}
