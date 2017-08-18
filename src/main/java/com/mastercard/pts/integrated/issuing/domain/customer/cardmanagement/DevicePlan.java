package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DevicePlan implements HasCodeAndDescription {

	private static final String ASSOCIATION = "ASSOCIATION";
	private static final String PRODUCT_TYPE = "PRODUCT_TYPE";
	private static final String DEVICE_TYPE = "DEVICE_TYPE";
	private static final String SERVICE_CODE = "SERVICE_CODE";
	private static final String DEVICE_ID_GENERATION_TEMPLATE = "DEVICE_ID_GENERATION_TEMPLATE";
	private static final String CARD_PACKID_GENERATION_TEMPLATE = "CARD_PACKID_GENERATION_TEMPLATE";
	private static final String DELIVERY_MODE = "DELIVERY_MODE";
	private static final String PLASTIC_ID = "PLASTIC_ID";
	private static final String PICTURE_CODE = "PICTURE_CODE";
	private static final String CARD_PRODUCTION = "CARD_PRODUCTION";
	private static final String EMBOSSING_VENDOR = "EMBOSSING_VENDOR";
	private static final String ACTIVATION_CODE = "ACTIVATION_CODE";
	private static final String EXPIRY_FLAG = "EXPIRY_FLAG";
	private static final String VALIDITY_ON_INITIAL_MONTHS = "VALIDITY_ON_INITIAL_MONTHS";
	private static final String TRANSACTION_LIMIT_PLAN = "TRANSACTION_LIMIT_PLAN";
	private static final String CHIP_TYPE = "CHIP_TYPE";
	private static final String PIN_RETRY_LIMIT = "PIN_RETRY_LIMIT";
	private static final String PIN_LENGTH = "PIN_LENGTH";
	private static final String PIN_DATA_TRANSMISSION = "PIN_DATA_TRANSMISSION";
	private static final String PIN_GENERATION_OPTION = "PIN_GENERATION_OPTION";
	private static final String SELECT_ALL_CAVV = "SELECT_ALL_CAVV";
	private static final String SELECT_ALL_PIN_VALIDATION = "SELECT_ALL_PIN_VALIDATION";
	private static final String SELECT_ALL_CVCCVV = "SELECT_ALL_CVCCVV";
	private static final String VALIDITY_ON_RENEWAL_MONTHS = "VALIDITY_ON_RENEWAL_MONTHS";
	private static final String AUTO_RENEWAL_DAYS = "AUTO_RENEWAL_DAYS";
	private static final String ADVANCE_RENEWAL_REPORT = "ADVANCE_RENEWAL_REPORT";
	private static final String RENEWAL_ACTIVATION_MODE = "RENEWAL_ACTIVATION_MODE";
	private static final String REPLACEMENT_NO_OF_DAYS = "REPLACEMENT_NO_OF_DAYS";
	private static final String VALIDITY_ON_REPLACEMENT_MONTHS = "VALIDITY_ON_REPLACEMENT_MONTHS";
	private static final String FILL_RENEWAL_SECTION = "FILL_RENEWAL_SECTION";
	private static final String FILL_REPLACEMENT_SECTION = "FILL_REPLACEMENT_SECTION";
	private static final String EMV_PLAN_RESPONSE = "EMV_PLAN_RESPONSE";
	private static final String EMV_BELOW_ATC_RANGE = "EMV_BELOW_ATC_RANGE";
	private static final String EMV_ABOVE_ATC_RANGE = "EMV_ABOVE_ATC_RANGE";
	private static final String FILL_EMV_PLAN = "FILL_EMV_PLAN";
	private static final String REPLACEMENT_DEVICE_TECHNOLOGY = "REPLACEMENT_DEVICE_TECHNOLOGY";
	
	private String replacementDeviceTechnology;
	private String fillEMVPlan;
	private String emvPlanResponse;
	private String emvBelowATCRange;
	private String emvAboveATCRange;
	private String validityOnRenewalMonths;
	private String autoRenewalDays;
	private String advanceRenewalReport;
	private String renewalActivationMode;
	private String replacementNoOfDays;
	private String validityOnReplacementMonths;
	private String fillRenewalSection;
	private String fillReplacementSection;
	private String selectAllCAVV;
	private String selectAllPinValidation;
	private String selectAllCVCCVV;
	private String pinRetryLimit;
	private String pinLength;
	private String pinDataTransmission;
	private String pinGenerationOption;
	private String devicePlanCode;
	private String associationType;
	private String productType;
	private String deviceType;
	private String serviceCode;
	private String deliveryMode;
	private String deviceIdGenerationTemplate;
	private String cardPackIdGenerationTemplate;
	private String plasticId;
	private String pictureCode;
	private String cardProduction;
	private String embossingVendor;
	private String activationMode;
	private String expiryFlag;
	private String validityOnInitialMonths;
	private String expiryDate;
	private String baseDeviceEventBasedPlan;
	private String baseDeviceJoiningMemberShipPlan;
	private String transactionLimitPlan;
	private String afterKYC;
	private String chipType;
	private String description;
	private boolean ecommerceAllowed;

	public static DevicePlan createWithProvider(KeyValueProvider provider) {
		DevicePlan plan = new DevicePlan();
		plan.setDevicePlanCode(MiscUtils.generate8CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setAssociation(provider.getString(ASSOCIATION));
		plan.setProductType(provider.getString(PRODUCT_TYPE));
		plan.setDeviceType(provider.getString(DEVICE_TYPE));
		plan.setServiceCode(provider.getString(SERVICE_CODE));
		plan.setDeviceIdGenerationTemplate(provider.getString(DEVICE_ID_GENERATION_TEMPLATE));
		plan.setCardPackIdGenerationTemplate(provider.getString(CARD_PACKID_GENERATION_TEMPLATE));
		plan.setDeliveryMode(provider.getString(DELIVERY_MODE));
		plan.setPlasticId(provider.getString(PLASTIC_ID));
		plan.setPictureCode(provider.getString(PICTURE_CODE));
		plan.setCardProduction(provider.getString(CARD_PRODUCTION));
		plan.setEmbossingVendor(provider.getString(EMBOSSING_VENDOR));
		plan.setActivationMode(provider.getString(ACTIVATION_CODE));
		plan.setExpiryFlag(provider.getString(EXPIRY_FLAG));
		plan.setValidityOnInitialMonths(provider.getString(VALIDITY_ON_INITIAL_MONTHS));
		plan.setTransactionLimitPlan(provider.getString(TRANSACTION_LIMIT_PLAN));
		plan.setChipType(provider.getString(CHIP_TYPE));
		plan.setEcommerceAllowed(true);
		plan.setPinRetryLimit(provider.getString(PIN_RETRY_LIMIT));
		plan.setPinLength(provider.getString(PIN_LENGTH));
		plan.setPinGenerationOption(provider.getString(PIN_GENERATION_OPTION));
		plan.setPinDataTransmission(provider.getString(PIN_DATA_TRANSMISSION));
		plan.setSelectAllCAVV(provider.getString(SELECT_ALL_CAVV));
		plan.setSelectAllPinValidation(provider.getString(SELECT_ALL_PIN_VALIDATION));
		plan.setSelectAllCVCCVV(provider.getString(SELECT_ALL_CVCCVV));
		plan.setValidityOnRenewalMonths(provider.getString(VALIDITY_ON_RENEWAL_MONTHS));
		plan.setAutoRenewalDays(provider.getString(AUTO_RENEWAL_DAYS));
		plan.setAdvanceRenewalReport(provider.getString(ADVANCE_RENEWAL_REPORT));
		plan.setRenewalActivationMode(provider.getString(RENEWAL_ACTIVATION_MODE));
		plan.setReplacementNoOfDays(provider.getString(REPLACEMENT_NO_OF_DAYS));
		plan.setValidityOnReplacementMonths(provider.getString(VALIDITY_ON_REPLACEMENT_MONTHS));
		plan.setFillRenewalSection(provider.getString(FILL_RENEWAL_SECTION));
		plan.setFillReplacementSection(provider.getString(FILL_REPLACEMENT_SECTION));
		plan.setEmvPlanResponse(provider.getString(EMV_PLAN_RESPONSE));
		plan.setEmvBelowATCRange(provider.getString(EMV_BELOW_ATC_RANGE));
		plan.setEmvAboveATCRange(provider.getString(EMV_ABOVE_ATC_RANGE));
		plan.setFillEMVPlan(provider.getString(FILL_EMV_PLAN));
		plan.setReplacementDeviceTechnology(provider.getString(REPLACEMENT_DEVICE_TECHNOLOGY));

		return plan;
	}
	
	public String getReplacementDeviceTechnology() {
		return replacementDeviceTechnology;
	}

	public void setReplacementDeviceTechnology(String replacementDeviceTechnology) {
		this.replacementDeviceTechnology = replacementDeviceTechnology;
	}

	public String getFillEMVPlan() {
		return fillEMVPlan;
	}

	public void setFillEMVPlan(String fillEMVPlan) {
		this.fillEMVPlan = fillEMVPlan;
	}

	public String getAssociationType() {
		return associationType;
	}

	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}

	public String getEmvPlanResponse() {
		return emvPlanResponse;
	}

	public void setEmvPlanResponse(String emvPlanResponse) {
		this.emvPlanResponse = emvPlanResponse;
	}

	public String getEmvBelowATCRange() {
		return emvBelowATCRange;
	}

	public void setEmvBelowATCRange(String emvBelowATCRange) {
		this.emvBelowATCRange = emvBelowATCRange;
	}

	public String getEmvAboveATCRange() {
		return emvAboveATCRange;
	}

	public void setEmvAboveATCRange(String emvAboveATCRange) {
		this.emvAboveATCRange = emvAboveATCRange;
	}

	public String getValidityOnRenewalMonths() {
		return validityOnRenewalMonths;
	}

	public void setValidityOnRenewalMonths(String validityOnRenewalMonths) {
		this.validityOnRenewalMonths = validityOnRenewalMonths;
	}

	public String getAutoRenewalDays() {
		return autoRenewalDays;
	}

	public void setAutoRenewalDays(String autoRenewalDays) {
		this.autoRenewalDays = autoRenewalDays;
	}

	public String getAdvanceRenewalReport() {
		return advanceRenewalReport;
	}

	public void setAdvanceRenewalReport(String advanceRenewalReport) {
		this.advanceRenewalReport = advanceRenewalReport;
	}

	public String getRenewalActivationMode() {
		return renewalActivationMode;
	}

	public void setRenewalActivationMode(String renewalActivationMode) {
		this.renewalActivationMode = renewalActivationMode;
	}

	public String getReplacementNoOfDays() {
		return replacementNoOfDays;
	}

	public void setReplacementNoOfDays(String replacementNoOfDays) {
		this.replacementNoOfDays = replacementNoOfDays;
	}

	public String getValidityOnReplacementMonths() {
		return validityOnReplacementMonths;
	}

	public void setValidityOnReplacementMonths(String validityOnReplacementMonths) {
		this.validityOnReplacementMonths = validityOnReplacementMonths;
	}

	public String getFillRenewalSection() {
		return fillRenewalSection;
	}

	public void setFillRenewalSection(String fillRenewalSection) {
		this.fillRenewalSection = fillRenewalSection;
	}

	public String getFillReplacementSection() {
		return fillReplacementSection;
	}

	public void setFillReplacementSection(String fillReplacementSection) {
		this.fillReplacementSection = fillReplacementSection;
	}

	public String getSelectAllCAVV() {
		return selectAllCAVV;
	}

	public void setSelectAllCAVV(String selectAllCAVV) {
		this.selectAllCAVV = selectAllCAVV;
	}

	public String getSelectAllPinValidation() {
		return selectAllPinValidation;
	}

	public void setSelectAllPinValidation(String selectAllPinValidation) {
		this.selectAllPinValidation = selectAllPinValidation;
	}

	public String getSelectAllCVCCVV() {
		return selectAllCVCCVV;
	}

	public void setSelectAllCVCCVV(String selectAllCVCCVV) {
		this.selectAllCVCCVV = selectAllCVCCVV;
	}

	public String getPinRetryLimit() {
		return pinRetryLimit;
	}

	public void setPinRetryLimit(String pinRetryLimit) {
		this.pinRetryLimit = pinRetryLimit;
	}

	public String getPinLength() {
		return pinLength;
	}

	public void setPinLength(String pinLength) {
		this.pinLength = pinLength;
	}

	public String getPinDataTransmission() {
		return pinDataTransmission;
	}

	public void setPinDataTransmission(String pinDataTransmission) {
		this.pinDataTransmission = pinDataTransmission;
	}

	public String getPinGenerationOption() {
		return pinGenerationOption;
	}

	public void setPinGenerationOption(String pinGenerationOption) {
		this.pinGenerationOption = pinGenerationOption;
	}

	public boolean isEcommerceAllowed() {
		return ecommerceAllowed;
	}

	public void setEcommerceAllowed(boolean ecommerceAllowed) {
		this.ecommerceAllowed = ecommerceAllowed;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getCode() {
		return getDevicePlanCode();
	}

	public String getDevicePlanCode() {
		return devicePlanCode;
	}

	public void setDevicePlanCode(String devicePlanCode) {
		this.devicePlanCode = devicePlanCode;
	}

	public String getAssociation() {
		return associationType;
	}

	public void setAssociation(String association) {
		this.associationType = association;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getDeviceIdGenerationTemplate() {
		return deviceIdGenerationTemplate;
	}

	public void setDeviceIdGenerationTemplate(String deviceIdGenerationTemplate) {
		this.deviceIdGenerationTemplate = deviceIdGenerationTemplate;
	}

	public String getCardPackIdGenerationTemplate() {
		return cardPackIdGenerationTemplate;
	}

	public void setCardPackIdGenerationTemplate(String cardPackIdGenerationTemplate) {
		this.cardPackIdGenerationTemplate = cardPackIdGenerationTemplate;
	}

	public String getPlasticId() {
		return plasticId;
	}

	public void setPlasticId(String plasticId) {
		this.plasticId = plasticId;
	}

	public String getPictureCode() {
		return pictureCode;
	}

	public void setPictureCode(String pictureCode) {
		this.pictureCode = pictureCode;
	}

	public String getCardProduction() {
		return cardProduction;
	}

	public void setCardProduction(String cardProduction) {
		this.cardProduction = cardProduction;
	}

	public String getEmbossingVendor() {
		return embossingVendor;
	}

	public void setEmbossingVendor(String embossingVendor) {
		this.embossingVendor = embossingVendor;
	}

	public String getActivationMode() {
		return activationMode;
	}

	public void setActivationMode(String activationMode) {
		this.activationMode = activationMode;
	}

	public String getExpiryFlag() {
		return expiryFlag;
	}

	public void setExpiryFlag(String expiryFlag) {
		this.expiryFlag = expiryFlag;
	}

	public String getValidityOnInitialMonths() {
		return validityOnInitialMonths;
	}

	public void setValidityOnInitialMonths(String validityOnInitialMonths) {
		this.validityOnInitialMonths = validityOnInitialMonths;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBaseDeviceEventBasedPlan() {
		return baseDeviceEventBasedPlan;
	}

	public void setBaseDeviceEventBasedPlan(String baseDeviceEventBasedPlan) {
		this.baseDeviceEventBasedPlan = baseDeviceEventBasedPlan;
	}

	public String getBaseDeviceJoiningMemberShipPlan() {
		return baseDeviceJoiningMemberShipPlan;
	}

	public void setBaseDeviceJoiningMemberShipPlan(String baseDeviceJoiningMemberShipPlan) {
		this.baseDeviceJoiningMemberShipPlan = baseDeviceJoiningMemberShipPlan;
	}

	public String getTransactionLimitPlan() {
		return transactionLimitPlan;
	}

	public void setTransactionLimitPlan(String transactionLimitPlan) {
		this.transactionLimitPlan = transactionLimitPlan;
	}

	public String getAfterKYC() {
		return afterKYC;
	}

	public void setAfterKYC(String afterKYC) {
		this.afterKYC = afterKYC;
	}

	public String getChipType() {
		return chipType;
	}

	public void setChipType(String chipType) {
		this.chipType = chipType;
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
