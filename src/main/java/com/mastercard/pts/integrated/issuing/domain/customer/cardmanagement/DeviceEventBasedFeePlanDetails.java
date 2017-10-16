package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class DeviceEventBasedFeePlanDetails {
	
	private static final String  DEBFP_EFFECTIVE_DATE  =  "DEBFP_EFFECTIVE_DATE";
	private static final String  DEBFP_END_DATE  =  "DEBFP_END_DATE";
	private static final String  DEBFP_DEVICE_RENEWAL_NORMAL_CARD_FIRST  =  "DEBFP_DEVICE_RENEWAL_NORMAL_CARD_FIRST";
	private static final String  DEBFP_DEVICE_RENEWAL_NORMAL_CARD_SUBSEQUENT  =  "DEBFP_DEVICE_RENEWAL_NORMAL_CARD_SUBSEQUENT";
	private static final String  DEBFP_DEVICE_RENEWAL_PHOTO_CARD_FIRST  =  "DEBFP_DEVICE_RENEWAL_PHOTO_CARD_FIRST";
	private static final String  DEBFP_DEVICE_RENEWAL_PHOTOE_CARD_SUBSEQUENT  =  "DEBFP_DEVICE_RENEWAL_PICTURE_CARD_SUBSEQUENT";
	private static final String  DEBFP_DEVICE_RENEWAL_PICTURE_CARD_FIRST  =  "DEBFP_DEVICE_RENEWAL_PICTURE_CARD_FIRST";
	private static final String  DEBFP_DEVICE_RENEWAL_PICTURE_CARD_SUBSEQUENT  =  "DEBFP_DEVICE_RENEWAL_PICTURE_CARD_SUBSEQUENT";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_LOST  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_LOST";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_STOLEN  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_STOLEN";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_DAMAGED  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_DAMAGED";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_COUNTERFEIT  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_COUNTERFEIT";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_EMERGENCY  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_EMERGENCY";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_ERRONEOUS  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_ERRONEOUS";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_DEVICE_TECH_UPGRADE  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_DEVICE_TECH_UPGRADE";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_EARLY_RENEWAL  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_EARLY_RENEWAL";
	private static final String  DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_OTHERS  =  "DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_OTHERS";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_LOST  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_LOST";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_STOLEN  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_STOLEN";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_DAMAGED  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_DAMAGED";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_COUNTERFEIT  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_COUNTERFEIT";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_EMERGENCY  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_EMERGENCY";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_ERRONEOUS  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_ERRONEOUS";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_DEVICE_TECH_UPGRADE  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_DEVICE_TECH_UPGRADE";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_EARLY_RENEWAL  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_EARLY_RENEWAL";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_OTHERS  =  "DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_OTHERS";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_LOST  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_LOST";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_STOLEN  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_STOLEN";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_DAMAGED  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_DAMAGED";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_COUNTERFEIT  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_COUNTERFEIT";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_EMERGENCY  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_EMERGENCY";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_ERRONEOUS  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_ERRONEOUS";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_DEVICE_TECH_UPGRADE  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_DEVICE_TECH_UPGRADE";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_EARLY_RENEWAL  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_EARLY_RENEWAL";
	private static final String  DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_OTHERS  =  "DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_OTHERS";
	private static final String  DEBFP_OTHER_FEES_STOPLIST_WITHDRAWAL_FEE  =  "DEBFP_OTHER_FEES_STOPLIST_WITHDRAWAL_FEE";
	private static final String  DEBFP_OTHER_FEES_PIN_REGENERATION_FEE  =  "DEBFP_OTHER_FEES_PIN_REGENERATION_FEE";
	private static final String  DEBFP_OTHER_FEES_PRIORITY_PASS_ISSUE_FEE  =  "DEBFP_OTHER_FEES_PRIORITY_PASS_ISSUE_FEE";
	private static final String  DEBFP_OTHER_FEES_PRIORITY_PASS_REISSUE_FEE  =  "DEBFP_OTHER_FEES_PRIORITY_PASS_REISSUE_FEE";

	private LocalDate effectiveDate;
	private LocalDate endDate;
	
	private String deviceRenewalNormalCardFirst;
	private String deviceRenewalNormalCardSubsequent;
	private String deviceRenewalPhotoCardFirst;
	private String deviceRenewalPhotoCardSubsequent;
	private String deviceRenewalPictureCardFirst;
	private String deviceRenewalPictureCardSubsequent;

	private String deviceReplacementNormalCardLost;
	private String deviceReplacementNormalCardStolen;
	private String deviceReplacementNormalCardDamaged;
	private String deviceReplacementNormalCardCounterfeit;
	private String deviceReplacementNormalCardEmergency;
	private String deviceReplacementNormalCardErroneous;
	private String deviceReplacementNormalCardUpgrade;
	private String deviceReplacementNormalCardEarlyRenewal;
	private String deviceReplacementNormalCardOthers;
	
	private String deviceReplacementPhotoCardLost;
	private String deviceReplacementPhotoCardStolen;
	private String deviceReplacementPhotoCardDamaged;
	private String deviceReplacementPhotoCardCounterfeit;
	private String deviceReplacementPhotoCardEmergency;
	private String deviceReplacementPhotoCardErroneous;
	private String deviceReplacementPhotoCardUpgrade;
	private String deviceReplacementPhotoCardEarlyRenewal;
	private String deviceReplacementPhotoCardOthers;
	
	private String deviceReplacementPictureCardLost;
	private String deviceReplacementPictureCardStolen;
	private String deviceReplacementPictureCardDamaged;
	private String deviceReplacementPictureCardCounterfeit;
	private String deviceReplacementPictureCardEmergency;
	private String deviceReplacementPictureCardErroneous;
	private String deviceReplacementPictureCardUpgrade;
	private String deviceReplacementPictureCardEarlyRenewal;
	private String deviceReplacementPictureCardOthers;

	private String otherFeesStoplistWithdrawalFee;
	private String otherFeesPinRegenerationFee;
	private String otherFeesPriorityPassFee;
	private String otherFeesPriorityPassReIssueFee;

	public static DeviceEventBasedFeePlanDetails generateDynamicTestData(){
		DeviceEventBasedFeePlanDetails plan = new DeviceEventBasedFeePlanDetails();
		plan.setEffectiveDate(LocalDate.now().plusDays(1));
		plan.setEndDate(plan.getEffectiveDate().plusDays(5));
		return plan;
	}
	
	public static DeviceEventBasedFeePlanDetails createWithProvider(KeyValueProvider provider) {
		DeviceEventBasedFeePlanDetails plan = new DeviceEventBasedFeePlanDetails();
		plan.setEffectiveDate(LocalDate.now().plusDays(provider.getInt(DEBFP_EFFECTIVE_DATE)));
		plan.setEndDate(plan.getEffectiveDate().plusDays(provider.getInt(DEBFP_END_DATE)));
		
		plan.setDeviceRenewalNormalCardFirst(provider.getString(DEBFP_DEVICE_RENEWAL_NORMAL_CARD_FIRST));
		plan.setDeviceRenewalNormalCardSubsequent(provider.getString(DEBFP_DEVICE_RENEWAL_NORMAL_CARD_SUBSEQUENT));
		plan.setDeviceRenewalPhotoCardFirst(provider.getString(DEBFP_DEVICE_RENEWAL_PHOTO_CARD_FIRST));
		plan.setDeviceRenewalPhotoCardSubsequent(provider.getString(DEBFP_DEVICE_RENEWAL_PHOTOE_CARD_SUBSEQUENT));
		plan.setDeviceRenewalPictureCardFirst(provider.getString(DEBFP_DEVICE_RENEWAL_PICTURE_CARD_FIRST));
		plan.setDeviceRenewalPictureCardSubsequent(provider.getString(DEBFP_DEVICE_RENEWAL_PICTURE_CARD_SUBSEQUENT));
	
		plan.setDeviceReplacementNormalCardCounterfeit(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_COUNTERFEIT));
		plan.setDeviceReplacementNormalCardDamaged(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_DAMAGED));
		plan.setDeviceReplacementNormalCardEarlyRenewal(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_EARLY_RENEWAL));
		plan.setDeviceReplacementNormalCardErroneous(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_ERRONEOUS));
		plan.setDeviceReplacementNormalCardEmergency(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_EMERGENCY));
		plan.setDeviceReplacementNormalCardLost(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_LOST));
		plan.setDeviceReplacementNormalCardOthers(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_OTHERS));
		plan.setDeviceReplacementNormalCardStolen(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_STOLEN));
		plan.setDeviceReplacementNormalCardUpgrade(provider.getString(DEBFP_DEVICE_REPLACEMENT_NORMAL_CARD_DEVICE_TECH_UPGRADE));
		
		plan.setDeviceReplacementPhotoCardCounterfeit(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_COUNTERFEIT));
		plan.setDeviceReplacementPhotoCardDamaged(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_DAMAGED));
		plan.setDeviceReplacementPhotoCardEarlyRenewal(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_EARLY_RENEWAL));
		plan.setDeviceReplacementPhotoCardErroneous(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_ERRONEOUS));
		plan.setDeviceReplacementPhotoCardEmergency(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_EMERGENCY));
		plan.setDeviceReplacementPhotoCardLost(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_LOST));
		plan.setDeviceReplacementPhotoCardOthers(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_OTHERS));
		plan.setDeviceReplacementPhotoCardStolen(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_STOLEN));
		plan.setDeviceReplacementPhotoCardUpgrade(provider.getString(DEBFP_DEVICE_REPLACEMENT_PHOTO_CARD_DEVICE_TECH_UPGRADE));
		
		plan.setDeviceReplacementPictureCardCounterfeit(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_COUNTERFEIT));
		plan.setDeviceReplacementPictureCardDamaged(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_DAMAGED));
		plan.setDeviceReplacementPictureCardEarlyRenewal(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_EARLY_RENEWAL));
		plan.setDeviceReplacementPictureCardErroneous(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_ERRONEOUS));
		plan.setDeviceReplacementPictureCardEmergency(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_EMERGENCY));
		plan.setDeviceReplacementPictureCardLost(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_LOST));
		plan.setDeviceReplacementPictureCardOthers(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_OTHERS));
		plan.setDeviceReplacementPictureCardStolen(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_STOLEN));
		plan.setDeviceReplacementPictureCardUpgrade(provider.getString(DEBFP_DEVICE_REPLACEMENT_PICTURE_CARD_DEVICE_TECH_UPGRADE));
		
		plan.setOtherFeesStoplistWithdrawalFee(provider.getString(DEBFP_OTHER_FEES_STOPLIST_WITHDRAWAL_FEE));
		plan.setOtherFeesPriorityPassReIssueFee(provider.getString(DEBFP_OTHER_FEES_PRIORITY_PASS_REISSUE_FEE));
		plan.setOtherFeesPriorityPassFee(provider.getString(DEBFP_OTHER_FEES_PRIORITY_PASS_ISSUE_FEE));
		plan.setOtherFeesPinRegenerationFee(provider.getString(DEBFP_OTHER_FEES_PIN_REGENERATION_FEE));
		
		return plan;
	}
	
	public String getDeviceRenewalNormalCardFirst() {
		return deviceRenewalNormalCardFirst;
	}

	public void setDeviceRenewalNormalCardFirst(String deviceRenewalNormalCardFirst) {
		this.deviceRenewalNormalCardFirst = deviceRenewalNormalCardFirst;
	}

	public String getDeviceRenewalNormalCardSubsequent() {
		return deviceRenewalNormalCardSubsequent;
	}

	public void setDeviceRenewalNormalCardSubsequent(
			String deviceRenewalNormalCardSubsequent) {
		this.deviceRenewalNormalCardSubsequent = deviceRenewalNormalCardSubsequent;
	}

	public String getDeviceRenewalPhotoCardFirst() {
		return deviceRenewalPhotoCardFirst;
	}

	public void setDeviceRenewalPhotoCardFirst(String deviceRenewalPhotoCardFirst) {
		this.deviceRenewalPhotoCardFirst = deviceRenewalPhotoCardFirst;
	}

	public String getDeviceRenewalPhotoCardSubsequent() {
		return deviceRenewalPhotoCardSubsequent;
	}

	public void setDeviceRenewalPhotoCardSubsequent(
			String deviceRenewalPhotoCardSubsequent) {
		this.deviceRenewalPhotoCardSubsequent = deviceRenewalPhotoCardSubsequent;
	}

	public String getDeviceRenewalPictureCardFirst() {
		return deviceRenewalPictureCardFirst;
	}

	public void setDeviceRenewalPictureCardFirst(
			String deviceRenewalPictureCardFirst) {
		this.deviceRenewalPictureCardFirst = deviceRenewalPictureCardFirst;
	}

	public String getDeviceRenewalPictureCardSubsequent() {
		return deviceRenewalPictureCardSubsequent;
	}

	public void setDeviceRenewalPictureCardSubsequent(
			String deviceRenewalPictureCardSubsequent) {
		this.deviceRenewalPictureCardSubsequent = deviceRenewalPictureCardSubsequent;
	}

	public String getDeviceReplacementNormalCardLost() {
		return deviceReplacementNormalCardLost;
	}

	public void setDeviceReplacementNormalCardLost(
			String deviceReplacementNormalCardLost) {
		this.deviceReplacementNormalCardLost = deviceReplacementNormalCardLost;
	}

	public String getDeviceReplacementNormalCardStolen() {
		return deviceReplacementNormalCardStolen;
	}

	public void setDeviceReplacementNormalCardStolen(
			String deviceReplacementNormalCardStolen) {
		this.deviceReplacementNormalCardStolen = deviceReplacementNormalCardStolen;
	}

	public String getDeviceReplacementNormalCardDamaged() {
		return deviceReplacementNormalCardDamaged;
	}

	public void setDeviceReplacementNormalCardDamaged(
			String deviceReplacementNormalCardDamaged) {
		this.deviceReplacementNormalCardDamaged = deviceReplacementNormalCardDamaged;
	}

	public String getDeviceReplacementNormalCardCounterfeit() {
		return deviceReplacementNormalCardCounterfeit;
	}

	public void setDeviceReplacementNormalCardCounterfeit(
			String deviceReplacementNormalCardCounterfeit) {
		this.deviceReplacementNormalCardCounterfeit = deviceReplacementNormalCardCounterfeit;
	}

	public String getDeviceReplacementNormalCardEmergency() {
		return deviceReplacementNormalCardEmergency;
	}

	public void setDeviceReplacementNormalCardEmergency(
			String deviceReplacementNormalCardEmergency) {
		this.deviceReplacementNormalCardEmergency = deviceReplacementNormalCardEmergency;
	}

	public String getDeviceReplacementNormalCardErroneous() {
		return deviceReplacementNormalCardErroneous;
	}

	public void setDeviceReplacementNormalCardErroneous(
			String deviceReplacementNormalCardErroneous) {
		this.deviceReplacementNormalCardErroneous = deviceReplacementNormalCardErroneous;
	}

	public String getDeviceReplacementNormalCardUpgrade() {
		return deviceReplacementNormalCardUpgrade;
	}

	public void setDeviceReplacementNormalCardUpgrade(
			String deviceReplacementNormalCardUpgrade) {
		this.deviceReplacementNormalCardUpgrade = deviceReplacementNormalCardUpgrade;
	}

	public String getDeviceReplacementNormalCardEarlyRenewal() {
		return deviceReplacementNormalCardEarlyRenewal;
	}

	public void setDeviceReplacementNormalCardEarlyRenewal(
			String deviceReplacementNormalCardEarlyRenewal) {
		this.deviceReplacementNormalCardEarlyRenewal = deviceReplacementNormalCardEarlyRenewal;
	}

	public String getDeviceReplacementNormalCardOthers() {
		return deviceReplacementNormalCardOthers;
	}

	public void setDeviceReplacementNormalCardOthers(
			String deviceReplacementNormalCardOthers) {
		this.deviceReplacementNormalCardOthers = deviceReplacementNormalCardOthers;
	}

	public String getDeviceReplacementPhotoCardLost() {
		return deviceReplacementPhotoCardLost;
	}

	public void setDeviceReplacementPhotoCardLost(
			String deviceReplacementPhotoCardLost) {
		this.deviceReplacementPhotoCardLost = deviceReplacementPhotoCardLost;
	}

	public String getDeviceReplacementPhotoCardStolen() {
		return deviceReplacementPhotoCardStolen;
	}

	public void setDeviceReplacementPhotoCardStolen(
			String deviceReplacementPhotoCardStolen) {
		this.deviceReplacementPhotoCardStolen = deviceReplacementPhotoCardStolen;
	}

	public String getDeviceReplacementPhotoCardDamaged() {
		return deviceReplacementPhotoCardDamaged;
	}

	public void setDeviceReplacementPhotoCardDamaged(
			String deviceReplacementPhotoCardDamaged) {
		this.deviceReplacementPhotoCardDamaged = deviceReplacementPhotoCardDamaged;
	}

	public String getDeviceReplacementPhotoCardCounterfeit() {
		return deviceReplacementPhotoCardCounterfeit;
	}

	public void setDeviceReplacementPhotoCardCounterfeit(
			String deviceReplacementPhotoCardCounterfeit) {
		this.deviceReplacementPhotoCardCounterfeit = deviceReplacementPhotoCardCounterfeit;
	}

	public String getDeviceReplacementPhotoCardEmergency() {
		return deviceReplacementPhotoCardEmergency;
	}

	public void setDeviceReplacementPhotoCardEmergency(
			String deviceReplacementPhotoCardEmergency) {
		this.deviceReplacementPhotoCardEmergency = deviceReplacementPhotoCardEmergency;
	}

	public String getDeviceReplacementPhotoCardErroneous() {
		return deviceReplacementPhotoCardErroneous;
	}

	public void setDeviceReplacementPhotoCardErroneous(
			String deviceReplacementPhotoCardErroneous) {
		this.deviceReplacementPhotoCardErroneous = deviceReplacementPhotoCardErroneous;
	}

	public String getDeviceReplacementPhotoCardUpgrade() {
		return deviceReplacementPhotoCardUpgrade;
	}

	public void setDeviceReplacementPhotoCardUpgrade(
			String deviceReplacementPhotoCardUpgrade) {
		this.deviceReplacementPhotoCardUpgrade = deviceReplacementPhotoCardUpgrade;
	}

	public String getDeviceReplacementPhotoCardEarlyRenewal() {
		return deviceReplacementPhotoCardEarlyRenewal;
	}

	public void setDeviceReplacementPhotoCardEarlyRenewal(
			String deviceReplacementPhotoCardEarlyRenewal) {
		this.deviceReplacementPhotoCardEarlyRenewal = deviceReplacementPhotoCardEarlyRenewal;
	}

	public String getDeviceReplacementPhotoCardOthers() {
		return deviceReplacementPhotoCardOthers;
	}

	public void setDeviceReplacementPhotoCardOthers(
			String deviceReplacementPhotoCardOthers) {
		this.deviceReplacementPhotoCardOthers = deviceReplacementPhotoCardOthers;
	}

	public String getDeviceReplacementPictureCardLost() {
		return deviceReplacementPictureCardLost;
	}

	public void setDeviceReplacementPictureCardLost(
			String deviceReplacementPictureCardLost) {
		this.deviceReplacementPictureCardLost = deviceReplacementPictureCardLost;
	}

	public String getDeviceReplacementPictureCardStolen() {
		return deviceReplacementPictureCardStolen;
	}

	public void setDeviceReplacementPictureCardStolen(
			String deviceReplacementPictureCardStolen) {
		this.deviceReplacementPictureCardStolen = deviceReplacementPictureCardStolen;
	}

	public String getDeviceReplacementPictureCardDamaged() {
		return deviceReplacementPictureCardDamaged;
	}

	public void setDeviceReplacementPictureCardDamaged(
			String deviceReplacementPictureCardDamaged) {
		this.deviceReplacementPictureCardDamaged = deviceReplacementPictureCardDamaged;
	}

	public String getDeviceReplacementPictureCardCounterfeit() {
		return deviceReplacementPictureCardCounterfeit;
	}

	public void setDeviceReplacementPictureCardCounterfeit(
			String deviceReplacementPictureCardCounterfeit) {
		this.deviceReplacementPictureCardCounterfeit = deviceReplacementPictureCardCounterfeit;
	}

	public String getDeviceReplacementPictureCardEmergency() {
		return deviceReplacementPictureCardEmergency;
	}

	public void setDeviceReplacementPictureCardEmergency(
			String deviceReplacementPictureCardEmergency) {
		this.deviceReplacementPictureCardEmergency = deviceReplacementPictureCardEmergency;
	}

	public String getDeviceReplacementPictureCardErroneous() {
		return deviceReplacementPictureCardErroneous;
	}

	public void setDeviceReplacementPictureCardErroneous(
			String deviceReplacementPictureCardErroneous) {
		this.deviceReplacementPictureCardErroneous = deviceReplacementPictureCardErroneous;
	}

	public String getDeviceReplacementPictureCardUpgrade() {
		return deviceReplacementPictureCardUpgrade;
	}

	public void setDeviceReplacementPictureCardUpgrade(
			String deviceReplacementPictureCardUpgrade) {
		this.deviceReplacementPictureCardUpgrade = deviceReplacementPictureCardUpgrade;
	}

	public String getDeviceReplacementPictureCardEarlyRenewal() {
		return deviceReplacementPictureCardEarlyRenewal;
	}

	public void setDeviceReplacementPictureCardEarlyRenewal(
			String deviceReplacementPictureCardEarlyRenewal) {
		this.deviceReplacementPictureCardEarlyRenewal = deviceReplacementPictureCardEarlyRenewal;
	}

	public String getDeviceReplacementPictureCardOthers() {
		return deviceReplacementPictureCardOthers;
	}

	public void setDeviceReplacementPictureCardOthers(
			String deviceReplacementPictureCardOthers) {
		this.deviceReplacementPictureCardOthers = deviceReplacementPictureCardOthers;
	}

	public String getOtherFeesStoplistWithdrawalFee() {
		return otherFeesStoplistWithdrawalFee;
	}

	public void setOtherFeesStoplistWithdrawalFee(
			String otherFeesStoplistWithdrawalFee) {
		this.otherFeesStoplistWithdrawalFee = otherFeesStoplistWithdrawalFee;
	}

	public String getOtherFeesPinRegenerationFee() {
		return otherFeesPinRegenerationFee;
	}

	public void setOtherFeesPinRegenerationFee(String otherFeesPinRegenerationFee) {
		this.otherFeesPinRegenerationFee = otherFeesPinRegenerationFee;
	}

	public String getOtherFeesPriorityPassFee() {
		return otherFeesPriorityPassFee;
	}

	public void setOtherFeesPriorityPassFee(String otherFeesPriorityPassFee) {
		this.otherFeesPriorityPassFee = otherFeesPriorityPassFee;
	}

	public String getOtherFeesPriorityPassReIssueFee() {
		return otherFeesPriorityPassReIssueFee;
	}

	public void setOtherFeesPriorityPassReIssueFee(
			String otherFeesPriorityPassReIssueFee) {
		this.otherFeesPriorityPassReIssueFee = otherFeesPriorityPassReIssueFee;
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
	

	}