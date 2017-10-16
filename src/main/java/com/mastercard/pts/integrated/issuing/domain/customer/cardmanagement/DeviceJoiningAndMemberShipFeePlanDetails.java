package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DeviceJoiningAndMemberShipFeePlanDetails {
	
	private static final String DJMFP_EFFECTIVE_DATE	 = 	"DJMFP_EFFECTIVE_DATE";
	private static final String	DJMFP_END_DATE	 = 	"DJMFP_END_DATE";
	private static final String DJMFP_FEE_TYPE	 = 	"DJMFP_FEE_TYPE";
	private static final String DJMFP_FREQUENCY_PERIOD	 = 	"DJMFP_FREQUENCY_PERIOD";
	private static final String DJMFP_FEES_NORMAL_SVC_CARD	 = 	"DJMFP_FEES_NORMAL_SVC_CARD";
	private static final String DJMFP_FEES_PHOTO_CARD	 = 	"DJMFP_FEES_PHOTO_CARD";
	private static final String DJMFP_FEES_PICTURE_CARD	 = 	"DJMFP_FEES_PICTURE_CARD";
	private static final String DJMFP_FEES_LIMITED_VALIDITY_VIRTUAL_CARD	 = 	"DJMFP_FEES_LIMITED_VALIDITY_VIRTUAL_CARD";
	private static final String DJMFP_OTHERDETAILS_POST_ISSURANCE_FEE_ON	 = 	"DJMFP_OTHERDETAILS_POST_ISSURANCE_FEE_ON";
	private static final String DJMFP_OTHERDETAILS_DEFERREDMENT_OF_DAYS	 = 	"DJMFP_OTHERDETAILS_DEFERREDMENT_OF_DAYS";
	private static final String DJMFP_WAIVEROPTION_NO_OF_WAIVER_PERIOD	 = 	"DJMFP_WAIVEROPTION_NO_OF_WAIVER_PERIOD";
	
	private LocalDate effectiveDate;
	private LocalDate endDate;
	private String feeType;
	private String postIssuanceFeeOn;
	private String postIssuanceFeeOnForCreditCard;
	private int effectiveDateStartDays;
	private int effectiveDateEndDays;
	
	private String periodicFrequency;
	private String feesNormalOrSvcCard;
	private String feesPhotocCard;
	private String feesPictureCard;
	private String feesLimitedValidityVirtualCard;
	private String otherDetailsDeferredmentOfDays;
	private String waiverOptionNoOfWaiverPeriod;
	
	public static DeviceJoiningAndMemberShipFeePlanDetails createWithProvider(DataProvider provider) {
		DeviceJoiningAndMemberShipFeePlanDetails plan = provider.getDataBySimpleClassName(DeviceJoiningAndMemberShipFeePlanDetails.class);
		plan.setEffectiveDate(LocalDate.now().plusDays(plan.getEffectiveDateStartDays()));
		plan.setEndDate(plan.getEffectiveDate().plusDays(plan.getEffectiveDateEndDays()));
		return plan;
	}
	
	public static DeviceJoiningAndMemberShipFeePlanDetails createWithProvider(KeyValueProvider provider) {
		DeviceJoiningAndMemberShipFeePlanDetails plan = new DeviceJoiningAndMemberShipFeePlanDetails();
		plan.setEffectiveDate(LocalDate.now().plusDays(provider.getInt(DJMFP_EFFECTIVE_DATE)));
		plan.setEndDate(plan.getEffectiveDate().plusDays(provider.getInt(DJMFP_END_DATE)));
		plan.setFeeType(provider.getString(DJMFP_FEE_TYPE));
		plan.setPeriodicFrequency(provider.getString(DJMFP_FREQUENCY_PERIOD));
		plan.setFeesNormalOrSvcCard(provider.getString(DJMFP_FEES_NORMAL_SVC_CARD));
		plan.setFeesPhotocCard(provider.getString(DJMFP_FEES_PHOTO_CARD));
		plan.setFeesPictureCard(provider.getString(DJMFP_FEES_PICTURE_CARD));
		plan.setFeesLimitedValidityVirtualCard(provider.getString(DJMFP_FEES_LIMITED_VALIDITY_VIRTUAL_CARD));
		plan.setPostIssuanceFeeOn(provider.getString(DJMFP_OTHERDETAILS_POST_ISSURANCE_FEE_ON));
		plan.setPostIssuanceFeeOnForCreditCard(provider.getString(DJMFP_OTHERDETAILS_POST_ISSURANCE_FEE_ON));
		plan.setOtherDetailsDeferredmentOfDays(provider.getString(DJMFP_OTHERDETAILS_DEFERREDMENT_OF_DAYS));
		plan.setWaiverOptionNoOfWaiverPeriod(provider.getString(DJMFP_WAIVEROPTION_NO_OF_WAIVER_PERIOD));
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

	public String getPeriodicFrequency() {
		return periodicFrequency;
	}

	public void setPeriodicFrequency(String periodicFrequency) {
		this.periodicFrequency = periodicFrequency;
	}

	public String getFeesNormalOrSvcCard() {
		return feesNormalOrSvcCard;
	}

	public void setFeesNormalOrSvcCard(String feesNormalOrSvcCard) {
		this.feesNormalOrSvcCard = feesNormalOrSvcCard;
	}

	public String getFeesPhotocCard() {
		return feesPhotocCard;
	}

	public void setFeesPhotocCard(String feesPhotocCard) {
		this.feesPhotocCard = feesPhotocCard;
	}

	public String getFeesPictureCard() {
		return feesPictureCard;
	}

	public void setFeesPictureCard(String feesPictureCard) {
		this.feesPictureCard = feesPictureCard;
	}

	public String getFeesLimitedValidityVirtualCard() {
		return feesLimitedValidityVirtualCard;
	}

	public void setFeesLimitedValidityVirtualCard(
			String feesLimitedValidityVirtualCard) {
		this.feesLimitedValidityVirtualCard = feesLimitedValidityVirtualCard;
	}

	public String getOtherDetailsDeferredmentOfDays() {
		return otherDetailsDeferredmentOfDays;
	}

	public void setOtherDetailsDeferredmentOfDays(
			String otherDetailsDeferredmentOfDays) {
		this.otherDetailsDeferredmentOfDays = otherDetailsDeferredmentOfDays;
	}

	public String getWaiverOptionNoOfWaiverPeriod() {
		return waiverOptionNoOfWaiverPeriod;
	}

	public void setWaiverOptionNoOfWaiverPeriod(
			String waiverOptionNoOfWaiverPeriod) {
		this.waiverOptionNoOfWaiverPeriod = waiverOptionNoOfWaiverPeriod;
	}
}
