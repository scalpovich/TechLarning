package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
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

	private static final String	DP_ASSOCIATION	 = 	"DP_ASSOCIATION";
	private static final String DP_DEVICE_TYPE	 = 	"DP_DEVICE_TYPE";
	private static final String DP_SERVICE_CODE	 = 	"DP_SERVICE_CODE";
	private static final String DP_DELIVERY_MODE	 = 	"DP_DELIVERY_MODE";
	private static final String DP_DEVICE_ID_GENERATION_TEMPLATE	 = 	"DP_DEVICE_ID_GENERATION_TEMPLATE";
	private static final String DP_CARD_PACKID_GENERATION_TEMPLATE	 = 	"DP_CARD_PACKID_GENERATION_TEMPLATE";
	private static final String DP_PLASTIC_ID	 = 	"DP_PLASTIC_ID";
	private static final String DP_PICTURE_CODE	 = 	"DP_PICTURE_CODE";
	private static final String DP_PERSONALIZATION_CARD_PRODUCTION	 = 	"DP_PERSONALIZATION_CARD_PRODUCTION";
	private static final String DP_PERSONALIZATION_EMBOSSING_VENDOR	 = 	"DP_PERSONALIZATION_EMBOSSING_VENDOR";
	private static final String DP_PERSONALIZATION_ACTIVATION_CODE	 = 	"DP_PERSONALIZATION_ACTIVATION_CODE";
	private static final String DP_PERSONALIZATION_EXPIRY_FLAG	 = 	"DP_PERSONALIZATION_EXPIRY_FLAG";
	private static final String DP_PERSONALIZATION_VALIDITY_ON_INITIAL_MONTHS	 = 	"DP_PERSONALIZATION_VALIDITY_ON_INITIAL_MONTHS";
	private static final String DP_RENEWAL_VALIDITY_ON_RENEWAL_MONTHS	 = 	"DP_RENEWAL_VALIDITY_ON_RENEWAL_MONTHS";
	private static final String DP_REPLACEMENT_VALIDITY_ON_REPLACEMENT_MONTHS	 = 	"DP_REPLACEMENT_VALIDITY_ON_REPLACEMENT_MONTHS";
	private static final String DP_RENEWAL_AUTO_RENEWAL_DAYS	 = 	"DP_RENEWAL_AUTO_RENEWAL_DAYS";
	private static final String DP_RENEWAL_ADVANCE_RENEWAL_REPORT	 = 	"DP_RENEWAL_ADVANCE_RENEWAL_REPORT";
	private static final String DP_RENEWAL_ACTIVATION_MODE	 = 	"DP_RENEWAL_ACTIVATION_MODE";
	private static final String DP_REPLACEMENT_NO_OF_DAYS	 = 	"DP_REPLACEMENT_NO_OF_DAYS";
	private static final String DP_REPLACEMENT_DEVICE_TECHNOLOGY	 = 	"DP_REPLACEMENT_DEVICE_TECHNOLOGY";
	private static final String DP_PIN_GENERATION_PIN_DATA_TRANSMISSION	 = 	"DP_PIN_GENERATION_PIN_DATA_TRANSMISSION";
	private static final String DP_PIN_GENERATION_OPTION	 = 	"DP_PIN_GENERATION_OPTION";
	private static final String DP_PIN_GENERATION_PIN_LENGTH	 = 	"DP_PIN_GENERATION_PIN_LENGTH";
	private static final String DP_PIN_GENERATION_PIN_REQUIRED	 = 	"DP_PIN_GENERATION_PIN_REQUIRED";
	private static final String DP_PIN_GENERATION_PIN_RE_PIN_DAYS	 = 	"DP_PIN_GENERATION_PIN_RE_PIN_DAYS";
	private static final String DP_PIN_GENERATION_PIN_PRODUCTION_VENDOR	 = 	"DP_PIN_GENERATION_PIN_PRODUCTION_VENDOR";
	private static final String DP_DEVICE_NUMBER_GENERATION_CUSTOM_CODE = "DP_DEVICE_NUMBER_GENERATION_CUSTOM_CODE";
	private static final String DP_DEVICE_NUMBER_GENERATION_ISSUE_PAIRED_DEVICE	 = 	"DP_DEVICE_NUMBER_GENERATION_ISSUE_PAIRED_DEVICE";
	private static final String DP_PRIORITY_PASS_INDICATOR	 = 	"DP_PRIORITY_PASS_INDICATOR";
	private static final String DP_PRIORITY_PASS_ID_TEMPLATE	 = 	"DP_PRIORITY_PASS_ID_TEMPLATE";
	private static final String DP_PRIORITY_PASS_EXPIRY	 = 	"DP_PRIORITY_PASS_EXPIRY";
	private static final String DP_PRIORITY_PASS_VENDOR	 = 	"DP_PRIORITY_PASS_VENDOR";
	private static final String DP_PERSONALIZATION_COURIER_TRACKING	 = 	"DP_PERSONALIZATION_COURIER_TRACKING";
	private static final String DP_PERSONALIZATION_MANUFACTURING_TRACKING	 = 	"DP_PERSONALIZATION_MANUFACTURING_TRACKING";
	private static final String DP_PERSONALIZATION_GENERATE_CVVCVC	 = 	"DP_PERSONALIZATION_GENERATE_CVVCVC";
	private static final String DP_PERSONALIZATION_GENERATE_CVV2CVC2	 = 	"DP_PERSONALIZATION_GENERATE_CVV2CVC2";
	private static final String DP_PERSONALIZATION_NO_OF_DAYS	 = 	"DP_PERSONALIZATION_NO_OF_DAYS";
	private static final String DP_PERSONALIZATION_CAF	 = 	"DP_PERSONALIZATION_CAF";
	private static final String DP_PERSONALIZATION_EXPIRY_DATE	 = 	"DP_PERSONALIZATION_EXPIRY_DATE";
	private static final String DP_RENEWAL_ALLOW_RENEWAL	 = 	"DP_RENEWAL_ALLOW_RENEWAL";
	private static final String DP_RENEWAL_RENEWAL_DEVICE_TECHNOLOGY	 = 	"DP_RENEWAL_RENEWAL_DEVICE_TECHNOLOGY";
	private static final String DP_REPLACEMENT_NEW_EXPIRY_FLAG	 = 	"DP_REPLACEMENT_NEW_EXPIRY_FLAG";
	private static final String DP_REPLACEMENT_ALLOW_INSTANT_DEVICE_REPLAY	 = 	"DP_REPLACEMENT_ALLOW_INSTANT_DEVICE_REPLAY";
	
	private static final String	DP_TRANS_SET_PRESENTMENT_TIME_LIMIT	 = 	"DP_TRANS_SET_PRESENTMENT_TIME_LIMIT";
	private static final String DP_PRESCREENING_PIN_RETRY_LIMIT = "DP_PRESCREENING_PIN_RETRY_LIMIT";
	private static final String	DP_PRESCREENING_PIN_CHANGE_TRANSACTION_FIRST	 = 	"DP_PRESCREENING_PIN_CHANGE_TRANSACTION_FIRST";
	private static final String	DP_PRESCREENING_CAVV_CHECK	 = 	"DP_PRESCREENING_CAVV_CHECK";
	private static final String	DP_PRESCREENING_ELECTRONIC_WARNING_BULLETIN_PURGE_DATE	 = 	"DP_PRESCREENING_ELECTRONIC_WARNING_BULLETIN_PURGE_DATE";
	private static final String	DP_PRESCREENING_PIN_VALIDATION	 = 	"DP_PRESCREENING_PIN_VALIDATION";
	private static final String	DP_PRESCREENING_STOPLIST	 = 	"DP_PRESCREENING_STOPLIST";
	private static final String	DP_PRESCREENING_EXPIRY_DATE	 = 	"DP_PRESCREENING_EXPIRY_DATE";
	private static final String	DP_PRESCREENING_CVCCVV_CHECK	 = 	"DP_PRESCREENING_CVCCVV_CHECK";
	private static final String	DP_PRESCREENING_CVC2CVV2	 = 	"DP_PRESCREENING_CVC2CVV2";
	private static final String	DP_PRESCREENING_CV3	 = 	"DP_PRESCREENING_CV3";
	private static final String	DP_PRESCREENING_ALLOW_INTERNATTIONAL_TRANSACTION	 = 	"DP_PRESCREENING_ALLOW_INTERNATTIONAL_TRANSACTION";
	private static final String	DP_PRESCREENING_ECOMMERCE_ALLOWED	 = 	"DP_PRESCREENING_ECOMMERCE_ALLOWED";
	private static final String	DP_CROSS_BORDER_CHECK	 = 	"DP_CROSS_BORDER_CHECK";
	private static final String	DP_CROSS_BORDER_CHECK_TIME_INTERVAL	 = 	"DP_CROSS_BORDER_CHECK_TIME_INTERVAL";
	private static final String	DP_EMV_PLANS_ICVV_OPTION	 = 	"DP_EMV_PLANS_ICVV_OPTION";
	private static final String DP_EMV_PLAN_CHIP_TYPE	 = 	"DP_EMV_PLAN_CHIP_TYPE";
	private static final String	DP_EMV_PLAN_ABOVE_ATC_RANGE	 = 	"DP_EMV_PLAN_ABOVE_ATC_RANGE";
	private static final String	DP_EMV_PLAN_BELOW_ATC_RANGE	 = 	"DP_EMV_PLAN_BELOW_ATC_RANGE";
	private static final String	DP_EMV_PLAN_RESPONSE	 = 	"DP_EMV_PLAN_RESPONSE";
	private static final String	DP_EMV_PLAN_ALLOW_FALLBACK	 = 	"DP_EMV_PLAN_ALLOW_FALLBACK";
	private static final String	DP_EMV_PLAN_ISSUER_SCRIPTING	 = 	"DP_EMV_PLAN_ISSUER_SCRIPTING";
	private static final String	DP_EMV_PLAN_UCOL	 = 	"DP_EMV_PLAN_UCOL";
	private static final String	DP_EMV_PLAN_LCOL	 = 	"DP_EMV_PLAN_LCOL";
	private static final String	DP_EMV_PLAN_UCOTA	 = 	"DP_EMV_PLAN_UCOTA";
	private static final String	DP_EMV_PLAN_LCOTA	 = 	"DP_EMV_PLAN_LCOTA";
	private static final String	DP_EMV_PLAN_APPLICATION_BLOCK	 = 	"DP_EMV_PLAN_APPLICATION_BLOCK";
	private static final String	DP_EMV_PLAN_APPLICATION_UNBLOCK	 = 	"DP_EMV_PLAN_APPLICATION_UNBLOCK";
	private static final String	DP_EMV_PLAN_PUT_DATA	 = 	"DP_EMV_PLAN_PUT_DATA";
	private static final String	DP_EMV_PLAN_PIN_CHANGE	 = 	"DP_EMV_PLAN_PIN_CHANGE";
	private static final String	DP_EMV_PLAN_PIN_UNBLOCK	 = 	"DP_EMV_PLAN_PIN_UNBLOCK";
	public String association;
	public String DeviceType;
	public String ServiceCode;
	public String CustomCode;
	public String ExpiryFlag;
	public String ExpiryDate;
	public String validateonInitialMonths;
	public String DeliveryMode;
	public String TotalTransactionLimit;
	public String PerTransactionLimit;
	public String Validity;
	public String Velocity;
	public String embossiongVendor;
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
	private String beforeKYC;
	private String chipType;
	private String description;
	private boolean ecommerceAllowed;

	private String customCode;
	private String deviceNumberGenerationIssuePairedDevice;
	private String priorityPassIndicator;
	private String priorityPassIdTemplate;
	private String priorityPassExpiry;
	private String priorityPassVendor;
	private String personalizationCourierTracking;
	private String personalizationManufacturingTracking;
	private String personalizationGenerateCVVCVC;
	private String personalizationGenerateCVV2CVC2;
	private String personalizationNoOfDays;
	private String personalizationCAF;
	private String personalizationExpiryDate;
	private String renewalAllowRenewal;
	private String renewalRenewalDeviceTechnology;
	private String replacementNewExpiryFlag;
	private String replacementAllowInstantDeviceReplay;
	private String pinGenerationPinRequired;
	private String pinGenerationPinRePinDays;
	private String pinGenerationPinProductionVendor;
	
	private String transSetPresentmentTimeLimit;
	private String prescreeningPinChangeTransactionFirst;
	private String prescreeningCavvCheck;
	private String prescreeningElectronicWarningBulletinPurgeDate;
	private String prescreeningPinValidation;
	private String prescreeningStoplist;
	private String prescreeningExpiryDate;
	private String prescreeningCvccvvCheck;
	private String prescreeningCvc2Cvv2;
	private String prescreeningCv3;
	private String prescreeningAllowInternattionalTransaction;
	private String prescreeningEcommerceAllowed;
	private String crossBorderCheck;
	private String crossBorderCheckTimeInterval;
	private String emvPlansIcvvOption;
	private String emvPlansChipType;
	private String emvPlanAllowFallback;
	private String emvPlanIssuerScripting;
	private String emvPlanUcol;
	private String emvPlanLcol;
	private String emvPlanUcota;
	private String emvPlanLcota;
	private String emvPlanApplicationBlock;
	private String emvPlanApplicationUnblock;
	private String emvPlanPutData;
	private String emvPlanPinChange;
	private String emvPlanPinUnblock;
	private String isPinLess;

	public static DevicePlan createWithProvider(KeyValueProvider provider) {
		DevicePlan plan = new DevicePlan();
		plan.setDevicePlanCode(MiscUtils.generate8CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setAssociation(provider.getString(ASSOCIATION));
		plan.setProductType(provider.getString(PRODUCT_TYPE));
		plan.setDeviceType(provider.getString(DEVICE_TYPE));
		plan.setServiceCode(provider.getString(SERVICE_CODE));
		plan.setDeliveryMode(provider.getString(DELIVERY_MODE));

		plan.setDeviceIdGenerationTemplate(provider.getString(DEVICE_ID_GENERATION_TEMPLATE));
		plan.setCardPackIdGenerationTemplate(provider.getString(CARD_PACKID_GENERATION_TEMPLATE));
		plan.setPlasticId(provider.getString(PLASTIC_ID));
		plan.setPictureCode(provider.getString(PICTURE_CODE));
		plan.setCardProduction(provider.getString(CARD_PRODUCTION));
		plan.setEmbossingVendor(provider.getString(EMBOSSING_VENDOR));
		plan.setActivationMode(provider.getString(ACTIVATION_CODE));
		plan.setExpiryFlag(provider.getString(EXPIRY_FLAG));
		plan.setPersonalizationValidityOnInitialMonths(provider.getString(VALIDITY_ON_INITIAL_MONTHS));
		plan.setValidityOnRenewalMonths(provider.getString(VALIDITY_ON_RENEWAL_MONTHS));
		plan.setAutoRenewalDays(provider.getString(AUTO_RENEWAL_DAYS));
		plan.setAdvanceRenewalReport(provider.getString(ADVANCE_RENEWAL_REPORT));
		plan.setRenewalActivationMode(provider.getString(RENEWAL_ACTIVATION_MODE));
		plan.setReplacementNoOfDays(provider.getString(REPLACEMENT_NO_OF_DAYS));
		plan.setValidityOnReplacementMonths(provider.getString(VALIDITY_ON_REPLACEMENT_MONTHS));
		plan.setReplacementDeviceTechnology(provider.getString(REPLACEMENT_DEVICE_TECHNOLOGY));

		plan.setFillRenewalSection(provider.getString(FILL_RENEWAL_SECTION));
		plan.setFillReplacementSection(provider.getString(FILL_REPLACEMENT_SECTION));
		plan.setPinRetryLimit(provider.getString(PIN_RETRY_LIMIT));
		plan.setPinLength(provider.getString(PIN_LENGTH));
		plan.setPinGenerationOption(provider.getString(PIN_GENERATION_OPTION));
		plan.setPinDataTransmission(provider.getString(PIN_DATA_TRANSMISSION));

		plan.setTransactionLimitPlan(provider.getString(TRANSACTION_LIMIT_PLAN));
		plan.setChipType(provider.getString(CHIP_TYPE));
		plan.setEcommerceAllowed(true);

		plan.setSelectAllCAVV(provider.getString(SELECT_ALL_CAVV));
		plan.setSelectAllPinValidation(provider.getString(SELECT_ALL_PIN_VALIDATION));
		plan.setSelectAllCVCCVV(provider.getString(SELECT_ALL_CVCCVV));

		plan.setEmvPlanResponse(provider.getString(EMV_PLAN_RESPONSE));
		plan.setEmvBelowATCRange(provider.getString(EMV_BELOW_ATC_RANGE));
		plan.setEmvAboveATCRange(provider.getString(EMV_ABOVE_ATC_RANGE));
		plan.setFillEMVPlan(provider.getString(FILL_EMV_PLAN));


		return plan;
	}

	public static DevicePlan createWithProviderForRegression(KeyValueProvider provider) {
		DevicePlan plan = new DevicePlan();
		plan.setDevicePlanCode(MiscUtils.generate8CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setAssociation(provider.getString(DP_ASSOCIATION));
		plan.setDeviceType(provider.getString(DP_DEVICE_TYPE));
		plan.setServiceCode(provider.getString(DP_SERVICE_CODE));
		plan.setDeliveryMode(provider.getString(DP_DELIVERY_MODE));

		plan.setDeviceIdGenerationTemplate(provider.getString(DP_DEVICE_ID_GENERATION_TEMPLATE));
		plan.setCardPackIdGenerationTemplate(provider.getString(DP_CARD_PACKID_GENERATION_TEMPLATE));
		plan.setCustomCode(provider.getString(DP_DEVICE_NUMBER_GENERATION_CUSTOM_CODE));
		plan.setPlasticId(provider.getString(DP_PLASTIC_ID));
		plan.setPictureCode(provider.getString(DP_PICTURE_CODE));
		plan.setDeviceNumberGenerationIssuePairedDevice(provider.getString(DP_DEVICE_NUMBER_GENERATION_ISSUE_PAIRED_DEVICE));
		
		plan.setPriorityPassIndicator(provider.getString(DP_PRIORITY_PASS_INDICATOR));
		plan.setPriorityPassIdTemplate(provider.getString(DP_PRIORITY_PASS_ID_TEMPLATE));
		plan.setPriorityPassVendor(provider.getString(DP_PRIORITY_PASS_VENDOR));
		plan.setPriorityPassExpiry(provider.getString(DP_PRIORITY_PASS_EXPIRY));
		
		plan.setCardProduction(provider.getString(DP_PERSONALIZATION_CARD_PRODUCTION));
		plan.setPersonalizationCAF(provider.getString(DP_PERSONALIZATION_CAF));
		plan.setPersonalizationCourierTracking(provider.getString(DP_PERSONALIZATION_COURIER_TRACKING));
		plan.setPersonalizationExpiryDate(provider.getString(DP_PERSONALIZATION_EXPIRY_DATE));
		plan.setPersonalizationManufacturingTracking(provider.getString(DP_PERSONALIZATION_MANUFACTURING_TRACKING));
		plan.setPersonalizationGenerateCVV2CVC2(provider.getString(DP_PERSONALIZATION_GENERATE_CVV2CVC2));
		plan.setPersonalizationGenerateCVVCVC(provider.getString(DP_PERSONALIZATION_GENERATE_CVVCVC));
		plan.setPersonalizationNoOfDays(provider.getString(DP_PERSONALIZATION_NO_OF_DAYS));
		plan.setPersonalizationValidityOnInitialMonths(provider.getString(DP_PERSONALIZATION_VALIDITY_ON_INITIAL_MONTHS));
		plan.setEmbossingVendor(provider.getString(DP_PERSONALIZATION_EMBOSSING_VENDOR));
		plan.setActivationMode(provider.getString(DP_PERSONALIZATION_ACTIVATION_CODE));
		plan.setExpiryFlag(provider.getString(DP_PERSONALIZATION_EXPIRY_FLAG));
		
		plan.setRenewalAllowRenewal(provider.getString(DP_RENEWAL_ALLOW_RENEWAL));
		plan.setRenewalRenewalDeviceTechnology(provider.getString(DP_RENEWAL_RENEWAL_DEVICE_TECHNOLOGY));
		plan.setValidityOnRenewalMonths(provider.getString(DP_RENEWAL_VALIDITY_ON_RENEWAL_MONTHS));
		plan.setAutoRenewalDays(provider.getString(DP_RENEWAL_AUTO_RENEWAL_DAYS));
		plan.setAdvanceRenewalReport(provider.getString(DP_RENEWAL_ADVANCE_RENEWAL_REPORT));
		plan.setRenewalActivationMode(provider.getString(DP_RENEWAL_ACTIVATION_MODE));
		
		plan.setReplacementNewExpiryFlag(provider.getString(DP_REPLACEMENT_NEW_EXPIRY_FLAG));
		plan.setReplacementAllowInstantDeviceReplay(provider.getString(DP_REPLACEMENT_ALLOW_INSTANT_DEVICE_REPLAY));
		plan.setReplacementNoOfDays(provider.getString(DP_REPLACEMENT_NO_OF_DAYS));
		plan.setValidityOnReplacementMonths(provider.getString(DP_REPLACEMENT_VALIDITY_ON_REPLACEMENT_MONTHS));
		plan.setReplacementDeviceTechnology(provider.getString(DP_REPLACEMENT_DEVICE_TECHNOLOGY));
		
		plan.setPinGenerationPinRequired(provider.getString(DP_PIN_GENERATION_PIN_REQUIRED));
		plan.setPinGenerationPinRePinDays(provider.getString(DP_PIN_GENERATION_PIN_RE_PIN_DAYS));
		plan.setPinGenerationPinProductionVendor(provider.getString(DP_PIN_GENERATION_PIN_PRODUCTION_VENDOR));
		plan.setPinLength(provider.getString(DP_PIN_GENERATION_PIN_LENGTH));
		plan.setPinGenerationOption(provider.getString(DP_PIN_GENERATION_OPTION));
		plan.setPinDataTransmission(provider.getString(DP_PIN_GENERATION_PIN_DATA_TRANSMISSION));
		
		plan.setTransSetPresentmentTimeLimit(provider.getString(DP_TRANS_SET_PRESENTMENT_TIME_LIMIT));
		plan.setPrescreeningAllowInternattionalTransaction(provider.getString(DP_PRESCREENING_ALLOW_INTERNATTIONAL_TRANSACTION));
		plan.setPrescreeningCavvCheck(provider.getString(DP_PRESCREENING_CAVV_CHECK));
		plan.setPrescreeningCv3(provider.getString(DP_PRESCREENING_CV3));
		plan.setPrescreeningCvc2Cvv2(provider.getString(DP_PRESCREENING_CVC2CVV2));
		plan.setPrescreeningCvccvvCheck(provider.getString(DP_PRESCREENING_CVCCVV_CHECK));
		plan.setPrescreeningEcommerceAllowed(provider.getString(DP_PRESCREENING_ECOMMERCE_ALLOWED));
		plan.setPrescreeningElectronicWarningBulletinPurgeDate(provider.getString(DP_PRESCREENING_ELECTRONIC_WARNING_BULLETIN_PURGE_DATE));
		plan.setPrescreeningExpiryDate(provider.getString(DP_PRESCREENING_EXPIRY_DATE));
		plan.setPrescreeningPinChangeTransactionFirst(provider.getString(DP_PRESCREENING_PIN_CHANGE_TRANSACTION_FIRST));
		plan.setPrescreeningPinValidation(provider.getString(DP_PRESCREENING_PIN_VALIDATION));
		plan.setPrescreeningStoplist(provider.getString(DP_PRESCREENING_STOPLIST));
		plan.setPinRetryLimit(provider.getString(DP_PRESCREENING_PIN_RETRY_LIMIT));
		
		plan.setCrossBorderCheck(provider.getString(DP_CROSS_BORDER_CHECK));
		plan.setCrossBorderCheckTimeInterval(provider.getString(DP_CROSS_BORDER_CHECK_TIME_INTERVAL));
		
		plan.setEmvPlanResponse(provider.getString(DP_EMV_PLAN_RESPONSE));
		plan.setEmvBelowATCRange(provider.getString(DP_EMV_PLAN_BELOW_ATC_RANGE));
		plan.setEmvAboveATCRange(provider.getString(DP_EMV_PLAN_ABOVE_ATC_RANGE));
		plan.setEmvPlanAllowFallback(provider.getString(DP_EMV_PLAN_ALLOW_FALLBACK));
		plan.setEmvPlanApplicationBlock(provider.getString(DP_EMV_PLAN_APPLICATION_BLOCK));
		plan.setEmvPlanApplicationUnblock(provider.getString(DP_EMV_PLAN_APPLICATION_UNBLOCK));
		plan.setEmvPlanIssuerScripting(provider.getString(DP_EMV_PLAN_ISSUER_SCRIPTING));
		plan.setEmvPlanLcol(provider.getString(DP_EMV_PLAN_LCOL));
		plan.setEmvPlanLcota(provider.getString(DP_EMV_PLAN_LCOTA));
		plan.setEmvPlanPinChange(provider.getString(DP_EMV_PLAN_PIN_CHANGE));
		plan.setEmvPlanPinUnblock(provider.getString(DP_EMV_PLAN_PIN_UNBLOCK));
		plan.setEmvPlanPutData(provider.getString(DP_EMV_PLAN_PUT_DATA));
		plan.setEmvPlanResponse(provider.getString(DP_EMV_PLAN_RESPONSE));
		plan.setEmvPlansChipType(provider.getString(DP_EMV_PLAN_CHIP_TYPE));
		plan.setEmvPlansIcvvOption(provider.getString(DP_EMV_PLANS_ICVV_OPTION));
		plan.setEmvPlanUcol(provider.getString(DP_EMV_PLAN_UCOL));
		plan.setEmvPlanUcota(provider.getString(DP_EMV_PLAN_UCOTA));

		return plan;
	}
	public String getTransSetPresentmentTimeLimit() {
		return transSetPresentmentTimeLimit;
	}

	public void setTransSetPresentmentTimeLimit(String transSetPresentmentTimeLimit) {
		this.transSetPresentmentTimeLimit = transSetPresentmentTimeLimit;
	}

	public String getPrescreeningPinChangeTransactionFirst() {
		return prescreeningPinChangeTransactionFirst;
	}

	public void setPrescreeningPinChangeTransactionFirst(
			String prescreeningPinChangeTransactionFirst) {
		this.prescreeningPinChangeTransactionFirst = prescreeningPinChangeTransactionFirst;
	}

	public String getPrescreeningElectronicWarningBulletinPurgeDate() {
		return prescreeningElectronicWarningBulletinPurgeDate;
	}

	public void setPrescreeningElectronicWarningBulletinPurgeDate(
			String prescreeningElectronicWarningBulletinPurgeDate) {
		this.prescreeningElectronicWarningBulletinPurgeDate = prescreeningElectronicWarningBulletinPurgeDate;
	}

	public String getPrescreeningPinValidation() {
		return prescreeningPinValidation;
	}

	public void setPrescreeningPinValidation(String prescreeningPinValidation) {
		this.prescreeningPinValidation = prescreeningPinValidation;
	}

	public String getPrescreeningStoplist() {
		return prescreeningStoplist;
	}

	public void setPrescreeningStoplist(String prescreeningStoplist) {
		this.prescreeningStoplist = prescreeningStoplist;
	}

	public String getPrescreeningExpiryDate() {
		return prescreeningExpiryDate;
	}

	public void setPrescreeningExpiryDate(String prescreeningExpiryDate) {
		this.prescreeningExpiryDate = prescreeningExpiryDate;
	}

	public String getPrescreeningCvccvvCheck() {
		return prescreeningCvccvvCheck;
	}

	public void setPrescreeningCvccvvCheck(String prescreeningCvccvvCheck) {
		this.prescreeningCvccvvCheck = prescreeningCvccvvCheck;
	}

	public String getPrescreeningCvc2Cvv2() {
		return prescreeningCvc2Cvv2;
	}

	public void setPrescreeningCvc2Cvv2(String prescreeningCvc2Cvv2) {
		this.prescreeningCvc2Cvv2 = prescreeningCvc2Cvv2;
	}

	public String getPrescreeningCv3() {
		return prescreeningCv3;
	}

	public void setPrescreeningCv3(String prescreeningCv3) {
		this.prescreeningCv3 = prescreeningCv3;
	}

	public String getPrescreeningAllowInternattionalTransaction() {
		return prescreeningAllowInternattionalTransaction;
	}

	public void setPrescreeningAllowInternattionalTransaction(
			String prescreeningAllowInternattionalTransaction) {
		this.prescreeningAllowInternattionalTransaction = prescreeningAllowInternattionalTransaction;
	}

	public String getPrescreeningEcommerceAllowed() {
		return prescreeningEcommerceAllowed;
	}

	public void setPrescreeningEcommerceAllowed(String prescreeningEcommerceAllowed) {
		this.prescreeningEcommerceAllowed = prescreeningEcommerceAllowed;
	}

	public String getCrossBorderCheck() {
		return crossBorderCheck;
	}

	public void setCrossBorderCheck(String crossBorderCheck) {
		this.crossBorderCheck = crossBorderCheck;
	}

	public String getCrossBorderCheckTimeInterval() {
		return crossBorderCheckTimeInterval;
	}

	public void setCrossBorderCheckTimeInterval(String crossBorderCheckTimeInterval) {
		this.crossBorderCheckTimeInterval = crossBorderCheckTimeInterval;
	}

	public String getEmvPlansIcvvOption() {
		return emvPlansIcvvOption;
	}

	public void setEmvPlansIcvvOption(String emvPlansIcvvOption) {
		this.emvPlansIcvvOption = emvPlansIcvvOption;
	}

	public String getEmvPlansChipType() {
		return emvPlansChipType;
	}

	public void setEmvPlansChipType(String emvPlansChipType) {
		this.emvPlansChipType = emvPlansChipType;
	}

	public String getEmvPlanAllowFallback() {
		return emvPlanAllowFallback;
	}

	public void setEmvPlanAllowFallback(String emvPlanAllowFallback) {
		this.emvPlanAllowFallback = emvPlanAllowFallback;
	}

	public String getEmvPlanIssuerScripting() {
		return emvPlanIssuerScripting;
	}

	public void setEmvPlanIssuerScripting(String emvPlanIssuerScripting) {
		this.emvPlanIssuerScripting = emvPlanIssuerScripting;
	}

	public String getEmvPlanUcol() {
		return emvPlanUcol;
	}

	public void setEmvPlanUcol(String emvPlanUcol) {
		this.emvPlanUcol = emvPlanUcol;
	}

	public String getEmvPlanLcol() {
		return emvPlanLcol;
	}

	public void setEmvPlanLcol(String emvPlanLcol) {
		this.emvPlanLcol = emvPlanLcol;
	}

	public String getEmvPlanUcota() {
		return emvPlanUcota;
	}

	public void setEmvPlanUcota(String emvPlanUcota) {
		this.emvPlanUcota = emvPlanUcota;
	}

	public String getEmvPlanLcota() {
		return emvPlanLcota;
	}

	public void setEmvPlanLcota(String emvPlanLcota) {
		this.emvPlanLcota = emvPlanLcota;
	}
	
	public String getEmvPlanApplicationBlock() {
		return emvPlanApplicationBlock;
	}

	public void setEmvPlanApplicationBlock(String emvPlanApplicationBlock) {
		this.emvPlanApplicationBlock = emvPlanApplicationBlock;
	}

	public String getEmvPlanApplicationUnblock() {
		return emvPlanApplicationUnblock;
	}

	public void setEmvPlanApplicationUnblock(String emvPlanApplicationUnblock) {
		this.emvPlanApplicationUnblock = emvPlanApplicationUnblock;
	}

	public String getEmvPlanPutData() {
		return emvPlanPutData;
	}

	public void setEmvPlanPutData(String emvPlanPutData) {
		this.emvPlanPutData = emvPlanPutData;
	}

	public String getEmvPlanPinChange() {
		return emvPlanPinChange;
	}

	public void setEmvPlanPinChange(String emvPlanPinChange) {
		this.emvPlanPinChange = emvPlanPinChange;
	}

	public String getEmvPlanPinUnblock() {
		return emvPlanPinUnblock;
	}

	public void setEmvPlanPinUnblock(String emvPlanPinUnblock) {
		this.emvPlanPinUnblock = emvPlanPinUnblock;
	}

	public void setValidityOnInitialMonths(String validityOnInitialMonths) {
		this.validityOnInitialMonths = validityOnInitialMonths;
	}


	public String getDeviceNumberGenerationIssuePairedDevice() {
		return deviceNumberGenerationIssuePairedDevice;
	}

	public void setDeviceNumberGenerationIssuePairedDevice(
			String deviceNumberGenerationIssuePairedDevice) {
		this.deviceNumberGenerationIssuePairedDevice = deviceNumberGenerationIssuePairedDevice;
	}

	public String getPriorityPassIndicator() {
		return priorityPassIndicator;
	}

	public void setPriorityPassIndicator(String priorityPassIndicator) {
		this.priorityPassIndicator = priorityPassIndicator;
	}

	public String getPriorityPassIdTemplate() {
		return priorityPassIdTemplate;
	}

	public void setPriorityPassIdTemplate(String priorityPassIdTemplate) {
		this.priorityPassIdTemplate = priorityPassIdTemplate;
	}

	public String getPriorityPassExpiry() {
		return priorityPassExpiry;
	}

	public void setPriorityPassExpiry(String priorityPassExpiry) {
		this.priorityPassExpiry = priorityPassExpiry;
	}

	public String getPriorityPassVendor() {
		return priorityPassVendor;
	}

	public void setPriorityPassVendor(String priorityPassVendor) {
		this.priorityPassVendor = priorityPassVendor;
	}

	public String getPersonalizationCourierTracking() {
		return personalizationCourierTracking;
	}

	public void setPersonalizationCourierTracking(
			String personalizationCourierTracking) {
		this.personalizationCourierTracking = personalizationCourierTracking;
	}

	public String getPersonalizationManufacturingTracking() {
		return personalizationManufacturingTracking;
	}

	public void setPersonalizationManufacturingTracking(
			String personalizationManufacturingTracking) {
		this.personalizationManufacturingTracking = personalizationManufacturingTracking;
	}

	public String getPersonalizationGenerateCVVCVC() {
		return personalizationGenerateCVVCVC;
	}

	public void setPersonalizationGenerateCVVCVC(
			String personalizationGenerateCVVCVC) {
		this.personalizationGenerateCVVCVC = personalizationGenerateCVVCVC;
	}

	public String getPersonalizationGenerateCVV2CVC2() {
		return personalizationGenerateCVV2CVC2;
	}

	public void setPersonalizationGenerateCVV2CVC2(
			String personalizationGenerateCVV2CVC2) {
		this.personalizationGenerateCVV2CVC2 = personalizationGenerateCVV2CVC2;
	}

	public String getPersonalizationNoOfDays() {
		return personalizationNoOfDays;
	}

	public void setPersonalizationNoOfDays(String personalizationNoOfDays) {
		this.personalizationNoOfDays = personalizationNoOfDays;
	}

	public String getPersonalizationCAF() {
		return personalizationCAF;
	}

	public void setPersonalizationCAF(String personalizationCAF) {
		this.personalizationCAF = personalizationCAF;
	}

	public String getPersonalizationExpiryDate() {
		return personalizationExpiryDate;
	}

	public void setPersonalizationExpiryDate(String personalizationExpiryDate) {
		this.personalizationExpiryDate = personalizationExpiryDate;
	}

	public String getRenewalAllowRenewal() {
		return renewalAllowRenewal;
	}

	public void setRenewalAllowRenewal(String renewalAllowRenewal) {
		this.renewalAllowRenewal = renewalAllowRenewal;
	}

	public String getRenewalRenewalDeviceTechnology() {
		return renewalRenewalDeviceTechnology;
	}

	public void setRenewalRenewalDeviceTechnology(
			String renewalRenewalDeviceTechnology) {
		this.renewalRenewalDeviceTechnology = renewalRenewalDeviceTechnology;
	}

	public String getReplacementNewExpiryFlag() {
		return replacementNewExpiryFlag;
	}

	public void setReplacementNewExpiryFlag(String replacementNewExpiryFlag) {
		this.replacementNewExpiryFlag = replacementNewExpiryFlag;
	}

	public String getReplacementAllowInstantDeviceReplay() {
		return replacementAllowInstantDeviceReplay;
	}

	public void setReplacementAllowInstantDeviceReplay(
			String replacementAllowInstantDeviceReplay) {
		this.replacementAllowInstantDeviceReplay = replacementAllowInstantDeviceReplay;
	}

	public String getPinGenerationPinRequired() {
		return pinGenerationPinRequired;
	}

	public void setPinGenerationPinRequired(String pinGenerationPinRequired) {
		this.pinGenerationPinRequired = pinGenerationPinRequired;
	}

	public String getPinGenerationPinRePinDays() {
		return pinGenerationPinRePinDays;
	}

	public void setPinGenerationPinRePinDays(String pinGenerationPinRePinDays) {
		this.pinGenerationPinRePinDays = pinGenerationPinRePinDays;
	}

	public String getPinGenerationPinProductionVendor() {
		return pinGenerationPinProductionVendor;
	}

	public void setPinGenerationPinProductionVendor(
			String pinGenerationPinProductionVendor) {
		this.pinGenerationPinProductionVendor = pinGenerationPinProductionVendor;
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


	public String getValidityOnInitialMonths() {
		return validityOnInitialMonths;
	}

	public void setPersonalizationValidityOnInitialMonths(String validityOnInitialMonths) {
		this.validityOnInitialMonths = validityOnInitialMonths;
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
	
	public void setBeforeKYC(String beforeKYC) {
		this.beforeKYC = beforeKYC;
	}

	public String getBeforeKYC() {
		return beforeKYC;
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

	public String getPrescreeningCavvCheck() {
		return prescreeningCavvCheck;
	}

	public void setPrescreeningCavvCheck(String prescreeningCavvCheck) {
		this.prescreeningCavvCheck = prescreeningCavvCheck;
	}

	public String getIsPinLess() {
		return isPinLess;
	}

	public void setIsPinLess(String isPinLess) {
		this.isPinLess = isPinLess;
	}
public String getActivationMode() {
		return activationMode;
	}

	public void setActivationMode(String activationMode) {
		this.activationMode = activationMode;
	}

	public String getValidateonInitialMonths() {
		return validateonInitialMonths;
	}

	public void setValidateonInitialMonths(String validateonInitialMonths) {
		this.validateonInitialMonths = validateonInitialMonths;
	}

	public String getEmbossiongVendor() {
		return embossiongVendor;
	}

	public void setEmbossiongVendor(String embossiongVendor) {
		this.embossiongVendor = embossiongVendor;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getDevicePlanCode() {
		return devicePlanCode;
	}

	public void setDevicePlanCode(String devicePlanCode) {
		this.devicePlanCode = devicePlanCode;
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}

	public String getServiceCode() {
		return ServiceCode;
	}

	public void setServiceCode(String serviceCode) {
		ServiceCode = serviceCode;
	}

	public String getCustomCode() {
		return CustomCode;
	}

	public void setCustomCode(String customCode) {
		CustomCode = customCode;
	}

	public String getExpiryFlag() {
		return ExpiryFlag;
	}

	public void setExpiryFlag(String expiryFlag) {
		ExpiryFlag = expiryFlag;
	}

	public String getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}

	public String getDeliveryMode() {
		return DeliveryMode;
	}
    public void setDeliveryMode(String deliveryMode) {
		DeliveryMode = deliveryMode;
	}

	public String getValidity() {
		return Validity;
	}

	public void setValidity(String validity) {
		Validity = validity;
	}

	public String getVelocity() {
		return Velocity;
	}

	public void setVelocity(String velocity) {
		Velocity = velocity;
	}

	public String getTotalTransactionLimit() {
		return TotalTransactionLimit;
	}

	public void setTotalTransactionLimit(String totalTransactionLimit) {
		TotalTransactionLimit = totalTransactionLimit;
	}

	public String getPerTransactionLimit() {
		return PerTransactionLimit;
	}

	public void setPerTransactionLimit(String perTransactionLimit) {
		PerTransactionLimit = perTransactionLimit;
	}

	public String DevicePlan;

	public String getDevicePlan() {
		return DevicePlan;
	}

	public void setDevicePlan(String devicePlan) {
		DevicePlan = devicePlan;
	}

	public void devicePlanDataprovider() {
		// DevicePlan deviceplan = new DevicePlan();
		setDevicePlanCode(CustomUtils.randomNumbers(5));
		setValidateonInitialMonths(CustomUtils.randomNumbers(2));
		setDeviceType(MapUtils.fnGetInputDataFromMap("DeviceType"));
		setServiceCode(MapUtils.fnGetInputDataFromMap("ServiceCode"));
		setCustomCode(MapUtils.fnGetInputDataFromMap("CustomCode"));
		setExpiryFlag(MapUtils.fnGetInputDataFromMap("ExpiryFlag"));
		setExpiryDate(MapUtils.fnGetInputDataFromMap("ExpiryDate"));
		setDeliveryMode(MapUtils.fnGetInputDataFromMap("DeliveryMode"));
		setPerTransactionLimit(MapUtils.fnGetInputDataFromMap("PerTransactionLimit"));
		setTotalTransactionLimit(MapUtils.fnGetInputDataFromMap("TotalTransactionLimit"));
		setVelocity(MapUtils.fnGetInputDataFromMap("Velocity"));
		setValidity(MapUtils.fnGetInputDataFromMap("Validity"));

	}

}
