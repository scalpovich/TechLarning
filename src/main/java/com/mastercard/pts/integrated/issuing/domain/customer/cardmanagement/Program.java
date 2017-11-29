package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
@Component
public class Program implements HasCodeAndDescription {

	private static final String CASH_LIMIT_RESET = "CASH_LIMIT_RESET";
	private static final String CASH_LIMIT_TYPE = "CASH_LIMIT_TYPE";
	private static final String PROGRAM_TYPE = "PROGRAM_TYPE";
	private static final String INTERCHANGE = "INTERCHANGE";
	private static final String REFUND_IN_CURRENCY = "REFUND_IN_CURRENCY";
	private static final String PGM_INTERCHANGE	 = 	"PGM_INTERCHANGE";
	private static final String PGM_PROGRAM_TYPE	 = 	"PGM_PROGRAM_TYPE";
	private static final String PGM_BASE_CURRENCY	 = 	"PGM_BASE_CURRENCY";
	private static final String PGM_NO_OF_CURRENCY_ALLOWED	 = 	"PGM_NO_OF_CURRENCY_ALLOWED";
	private static final String PGM_CURRENCY_CONVERSION_BY	 = 	"PGM_CURRENCY_CONVERSION_BY";
	private static final String PGM_CALENDER_START_MONTH	 = 	"PGM_CALENDER_START_MONTH";
	private static final String PGM_MOBILE_NUMBER_FORMAT	 = 	"PGM_MOBILE_NUMBER_FORMAT";
	private static final String PGM_WALLET_2_WALLET_TRANSFER_TYPE	 = 	"PGM_WALLET_2_WALLET_TRANSFER_TYPE";
	private static final String PGM_REFERENCE_CURRENCY	 = 	"PGM_REFERENCE_CURRENCY";
	private static final String PGM_KYC_REQUIRED	 = 	"PGM_KYC_REQUIRED";
	private static final String PGM_KYC_LIMITS_MAX_BAL_WO_KYC	 = 	"PGM_KYC_LIMITS_MAX_BAL_WO_KYC";
	private static final String PGM_KYC_LIMITS_MAX_BAL_AFTER_KYC	 = 	"PGM_KYC_LIMITS_MAX_BAL_AFTER_KYC";
	private static final String PGM_KYC_LIMITS_NO_OF_LOADS_ALLOWED_WO_KYC	 = 	"PGM_KYC_LIMITS_NO_OF_LOADS_ALLOWED_WO_KYC";
	private static final String PGM_KYC_LIMITS_NO_OF_LOADS_ALLOWED_AFTER_KYC	 = 	"PGM_KYC_LIMITS_NO_OF_LOADS_ALLOWED_AFTER_KYC";
	private static final String PGM_ALLOW_FUNDS_RECIEVE	 = 	"PGM_ALLOW_FUNDS_RECIEVE";
	private static final String PGM_ALLOW_FUNDS_SEND	 = 	"PGM_ALLOW_FUNDS_SEND";
	private static final String PGM_LOAD_REFUND_TOLERANCE_UNIT_FOR_LOAD	 = 	"PGM_LOAD_REFUND_TOLERANCE_UNIT_FOR_LOAD";
	private static final String PGM_LOAD_REFUND_TOLERANCE_UNIT_FOR_REFUND	 = 	"PGM_LOAD_REFUND_TOLERANCE_UNIT_FOR_REFUND";
	private static final String PGM_LOAD_REFUND_REFUND_IN_CURRENCY	 = 	"PGM_LOAD_REFUND_REFUND_IN_CURRENCY";
	private static final String PGM_TRAVEL_LIMIT_TRAVEL_PLAN	 = 	"PGM_TRAVEL_LIMIT_TRAVEL_PLAN";
	private static final String PGM_CREDIT_LIMITS_MIN_CREDIT_LIMIT	 = 	"PGM_CREDIT_LIMITS_MIN_CREDIT_LIMIT";
	private static final String PGM_CREDIT_LIMITS_MAX_CREDIT_LIMIT	 = 	"PGM_CREDIT_LIMITS_MAX_CREDIT_LIMIT";
	private static final String PGM_CREDIT_LIMITS_CREDIT_LIMIT_VALIDATION	 = 	"PGM_CREDIT_LIMITS_CREDIT_LIMIT_VALIDATION";
	private static final String PGM_CASH_LIMITS_CASH_LIMIT_TYPE	 = 	"PGM_CASH_LIMITS_CASH_LIMIT_TYPE";
	private static final String PGM_CASH_LIMITS_CASH_LIMIT_AMOUNT	 = 	"PGM_CASH_LIMITS_CASH_LIMIT_AMOUNT";
	private static final String PGM_CASH_LIMITS_MIN_CASH_LIMIT	 = 	"PGM_CASH_LIMITS_MIN_CASH_LIMIT";
	private static final String PGM_CASH_LIMITS_MAX_CASH_LIMIT	 = 	"PGM_CASH_LIMITS_MAX_CASH_LIMIT";
	private static final String PGM_CASH_LIMITS_PERCENTAGE_CREDIT_LIMIT	 = 	"PGM_CASH_LIMITS_PERCENTAGE_CREDIT_LIMIT";
	private static final String PGM_RESET_LIMITS_CASH_LIMIT_RESET	 = 	"PGM_RESET_LIMITS_CASH_LIMIT_RESET";
	private static final String PGM_RESET_LIMITS_ADDON_LIMIT_RESET	 = 	"PGM_RESET_LIMITS_ADDON_LIMIT_RESET";
	private static final String PGM_EVENTS_SELECT_ALL	 = 	"PGM_EVENTS_SELECT_ALL";
	
	private static final String NO_OF_CURRENCY_ALLOWED = "NO_OF_CURRENCY_ALLOWED";
	
	private static final String WALLET_TO_WALLET_TRANSFER_TYPE = "WALLET_TO_WALLET_TRANSFER_TYPE";
			
	private static final String REFERENCE_CURRENCY = "REFERENCE_CURRENCY";
	
	private String walletToWalletTransferType;
	private String refundInCurrency;
	private String description;
	private String programCode;
	private String interchange;
	private String product;
	private String programType;
	private String baseCurrency;
	private String calendarStartMonth;
	private String currencyConversionBy;
	private String walletPlanPlan1;
	private String devicePlanPlan1;
	private String otherPlanStatementMessagePlan;
	private String otherPlanMarketingMessagePlan;
	private String creditLimit;
	private String maximumCreditLimit;
	private String cashLimitType;
	private String cashLimitAmount;
	private String percentageOfCreditLimit;
	private String cashLimitReset;
	private String addOnLimitReset;
	private String maximumBalanceWithoutKyc;
	private String numberOfLoadsAllowedWithoutKyc;
	private String dedupPlan;
	private String documentChecklistPlan;
	private String mccRulePlan;
	private String prepaidStatementPlan;
	private String noOfCurrencyAllowed;
	private String calenderStartMonth;
	private String mobileNumberFormat;
	private String wallet2WalletTransferType;
	private String referenceCurrency;
	private String kycRequired;

	private String kycLimitsMaxBalWithoutKyc;
	private String kycLimitsMaxBalAfterKyc;
	private String kycLimitsNoOfLoadsAllowedWithoutKyc;
	private String kycLimitsNoOfLoadsAllowedAfterKyc;
	private String allowFundsRecieve;
	private String allowFundsSend;
	private String loadRefundToleranceUnitForLoad;
	private String loadRefundToleranceUnitForRefund;
	private String loadRefundRefundInCurrency;
	private String travelLimitTravelPlan;
	private String creditLimitsMinCreditLimit;
	private String creditLimitsMaxCreditLimit;
	private String creditLimitsCreditLimitValidation;
	private String cashLimitsCashLimitType;
	private String cashLimitsCashLimitAmount;
	private String cashLimitsMinCashLimit;
	private String cashLimitsMaxCashLimit;
	private String cashLimitsPercentageCreditLimit;
	private String resetLimitsCashLimitReset;
	private String resetLimitsAddonLimitReset;
	private String eventsSelectAll;
	public String loadsWithoutKyc;

	public String Currency;
	public String Program;

	public String DevicePlanProgram;

	public String WalletType;

	public String WalletPlan1;

	public String WalletPlan2;

	public String WalletPlan3;

	
	public static Program createWithProvider(DataProvider dataProvider, KeyValueProvider provider){
		Program programObject = dataProvider.getDataBySimpleClassName(Program.class);
		programObject.setProgramCode(MiscUtils.generate6CharAlphaNumeric());
		programObject.setDescription(ConstantData.GENERIC_DESCRIPTION);
		programObject.setProgramType(provider.getString(PROGRAM_TYPE));
		programObject.setInterchange(provider.getString(INTERCHANGE));
		programObject.setMaximumBalanceWithoutKyc(RandomStringUtils.randomNumeric(4));
		programObject.setNumberOfLoadsAllowedWithoutKyc(String.valueOf(RandomUtils.nextInt(1,99)));
		programObject.setCreditLimit(RandomStringUtils.randomNumeric(5));
		programObject.setMaximumCreditLimit(RandomStringUtils.randomNumeric(6));
		programObject.setCashLimitAmount(RandomStringUtils.randomNumeric(5));
		programObject.setPercentageOfCreditLimit(RandomStringUtils.randomNumeric(2));
		programObject.setCashLimitType(provider.getString(CASH_LIMIT_TYPE));
		programObject.setCashLimitReset(provider.getString(CASH_LIMIT_RESET));
		programObject.setAddOnLimitReset(provider.getString(CASH_LIMIT_RESET));
		programObject.setRefundInCurrency(provider.getString(REFUND_IN_CURRENCY));
		programObject.setNoOfCurrencyAllowed(provider.getString(NO_OF_CURRENCY_ALLOWED));
		programObject.setReferenceCurrency(provider.getString(REFERENCE_CURRENCY));
		programObject.setWalletToWalletTransferType(provider.getString(WALLET_TO_WALLET_TRANSFER_TYPE));
		return programObject;
	}
	
	public static Program createWithProvider(KeyValueProvider provider){
		Program programObject = new Program();
		programObject.setProgramCode(MiscUtils.generate6CharAlphaNumeric());
		programObject.setDescription(ConstantData.GENERIC_DESCRIPTION);
		programObject.setInterchange(provider.getString(PGM_INTERCHANGE));
		programObject.setProgramType(provider.getString(PGM_PROGRAM_TYPE));
		programObject.setBaseCurrency(provider.getString(PGM_BASE_CURRENCY));
		programObject.setNoOfCurrencyAllowed(provider.getString(PGM_NO_OF_CURRENCY_ALLOWED));
		programObject.setCurrencyConversionBy(provider.getString(PGM_CURRENCY_CONVERSION_BY));
		programObject.setCalenderStartMonth(provider.getString(PGM_CALENDER_START_MONTH));
		programObject.setMobileNumberFormat(provider.getString(PGM_MOBILE_NUMBER_FORMAT));
		programObject.setWallet2WalletTransferType(provider.getString(PGM_WALLET_2_WALLET_TRANSFER_TYPE));
		programObject.setReferenceCurrency(provider.getString(PGM_REFERENCE_CURRENCY));
		programObject.setKycRequired(provider.getString(PGM_KYC_REQUIRED));
		programObject.setKycLimitsMaxBalWithoutKyc(provider.getString(PGM_KYC_LIMITS_MAX_BAL_WO_KYC));
		programObject.setKycLimitsMaxBalAfterKyc(provider.getString(PGM_KYC_LIMITS_MAX_BAL_AFTER_KYC));
		programObject.setKycLimitsNoOfLoadsAllowedWithoutKyc(provider.getString(PGM_KYC_LIMITS_NO_OF_LOADS_ALLOWED_WO_KYC));
		programObject.setKycLimitsNoOfLoadsAllowedAfterKyc(provider.getString(PGM_KYC_LIMITS_NO_OF_LOADS_ALLOWED_AFTER_KYC));
		programObject.setAllowFundsRecieve(provider.getString(PGM_ALLOW_FUNDS_RECIEVE));
		programObject.setAllowFundsSend(provider.getString(PGM_ALLOW_FUNDS_SEND));
		programObject.setLoadRefundToleranceUnitForLoad(provider.getString(PGM_LOAD_REFUND_TOLERANCE_UNIT_FOR_LOAD));
		programObject.setLoadRefundToleranceUnitForRefund(provider.getString(PGM_LOAD_REFUND_TOLERANCE_UNIT_FOR_REFUND));
		programObject.setLoadRefundRefundInCurrency(provider.getString(PGM_LOAD_REFUND_REFUND_IN_CURRENCY));
		programObject.setTravelLimitTravelPlan(provider.getString(PGM_TRAVEL_LIMIT_TRAVEL_PLAN));
		programObject.setCreditLimitsMinCreditLimit(provider.getString(PGM_CREDIT_LIMITS_MIN_CREDIT_LIMIT));
		programObject.setCreditLimitsMaxCreditLimit(provider.getString(PGM_CREDIT_LIMITS_MAX_CREDIT_LIMIT));
		programObject.setCreditLimitsCreditLimitValidation(provider.getString(PGM_CREDIT_LIMITS_CREDIT_LIMIT_VALIDATION));
		programObject.setCashLimitsCashLimitType(provider.getString(PGM_CASH_LIMITS_CASH_LIMIT_TYPE));
		programObject.setCashLimitsCashLimitAmount(provider.getString(PGM_CASH_LIMITS_CASH_LIMIT_AMOUNT));
		programObject.setCashLimitsMinCashLimit(provider.getString(PGM_CASH_LIMITS_MIN_CASH_LIMIT));
		programObject.setCashLimitsMaxCashLimit(provider.getString(PGM_CASH_LIMITS_MAX_CASH_LIMIT));
		programObject.setCashLimitsPercentageCreditLimit(provider.getString(PGM_CASH_LIMITS_PERCENTAGE_CREDIT_LIMIT));
		programObject.setResetLimitsCashLimitReset(provider.getString(PGM_RESET_LIMITS_CASH_LIMIT_RESET));
		programObject.setResetLimitsAddonLimitReset(provider.getString(PGM_RESET_LIMITS_ADDON_LIMIT_RESET));
		programObject.setEventsSelectAll(provider.getString(PGM_EVENTS_SELECT_ALL));

		return programObject;
	}



	public String getWalletPlan2() {
		return WalletPlan2;
	}

	public void setWalletPlan2(String walletPlan2) {
		WalletPlan2 = walletPlan2;
	}

	public String getWalletPlan3() {
		return WalletPlan3;
	}

	public void setWalletPlan3(String walletPlan3) {
		WalletPlan3 = walletPlan3;
	}

	public String getWalletPlan1() {
		return WalletPlan1;
	}

	public void setWalletPlan1(String walletPlan) {
		WalletPlan1 = walletPlan;
	}

	public String getWalletType() {
		return WalletType;
	}

	public void setWalletType(String walletType) {
		WalletType = walletType;
	}


	public String getProgram() {
		return Program;
	}

	public void setProgram(String program) {
		Program = program;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}


	public String MaxBalanceWithoutKYC;

	public String getMaxBalanceWithoutKYC() {
		return MaxBalanceWithoutKYC;
	}

	public void setMaxBalanceWithoutKYC(String maxBalanceWithoutKYC) {
		MaxBalanceWithoutKYC = maxBalanceWithoutKYC;
	}


	public void ProgramDataProvider() {
		// Program program = new Program();
		setRefundInCurrency("Program");
		setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		setCurrencyConversionBy(MapUtils.fnGetInputDataFromMap("CurrencyConversionBy"));
		setMaxBalanceWithoutKYC(MapUtils.fnGetInputDataFromMap("MaximumBalancewithoutKYC"));
		setLoadsWithoutKyc(MapUtils.fnGetInputDataFromMap("loadsWithoutKyc"));

	}
	public String getCalenderStartMonth() {
		return calenderStartMonth;
	}

	public void setCalenderStartMonth(String calenderStartMonth) {
		this.calenderStartMonth = calenderStartMonth;
	}

	public String getMobileNumberFormat() {
		return mobileNumberFormat;
	}

	public void setMobileNumberFormat(String mobileNumberFormat) {
		this.mobileNumberFormat = mobileNumberFormat;
	}

	public String getWallet2WalletTransferType() {
		return wallet2WalletTransferType;
	}

	public void setWallet2WalletTransferType(String wallet2WalletTransferType) {
		this.wallet2WalletTransferType = wallet2WalletTransferType;
	}

	public String getKycRequired() {
		return kycRequired;
	}

	public void setKycRequired(String kycRequired) {
		this.kycRequired = kycRequired;
	}

	public String getKycLimitsMaxBalWithoutKyc() {
		return kycLimitsMaxBalWithoutKyc;
	}

	public void setKycLimitsMaxBalWithoutKyc(String kycLimitsMaxBalWithoutKyc) {
		this.kycLimitsMaxBalWithoutKyc = kycLimitsMaxBalWithoutKyc;
	}

	public String getKycLimitsMaxBalAfterKyc() {
		return kycLimitsMaxBalAfterKyc;
	}

	public void setKycLimitsMaxBalAfterKyc(String kycLimitsMaxBalAfterKyc) {
		this.kycLimitsMaxBalAfterKyc = kycLimitsMaxBalAfterKyc;
	}

	public String getKycLimitsNoOfLoadsAllowedWithoutKyc() {
		return kycLimitsNoOfLoadsAllowedWithoutKyc;
	}

	public void setKycLimitsNoOfLoadsAllowedWithoutKyc(
			String kycLimitsNoOfLoadsAllowedWithoutKyc) {
		this.kycLimitsNoOfLoadsAllowedWithoutKyc = kycLimitsNoOfLoadsAllowedWithoutKyc;
	}

	public String getKycLimitsNoOfLoadsAllowedAfterKyc() {
		return kycLimitsNoOfLoadsAllowedAfterKyc;
	}

	public void setKycLimitsNoOfLoadsAllowedAfterKyc(
			String kycLimitsNoOfLoadsAllowedAfterKyc) {
		this.kycLimitsNoOfLoadsAllowedAfterKyc = kycLimitsNoOfLoadsAllowedAfterKyc;
	}

	public String getAllowFundsRecieve() {
		return allowFundsRecieve;
	}

	public void setAllowFundsRecieve(String allowFundsRecieve) {
		this.allowFundsRecieve = allowFundsRecieve;
	}

	public String getAllowFundsSend() {
		return allowFundsSend;
	}

	public void setAllowFundsSend(String allowFundsSend) {
		this.allowFundsSend = allowFundsSend;
	}

	public String getLoadRefundToleranceUnitForLoad() {
		return loadRefundToleranceUnitForLoad;
	}

	public void setLoadRefundToleranceUnitForLoad(
			String loadRefundToleranceUnitForLoad) {
		this.loadRefundToleranceUnitForLoad = loadRefundToleranceUnitForLoad;
	}

	public String getLoadRefundToleranceUnitForRefund() {
		return loadRefundToleranceUnitForRefund;
	}

	public void setLoadRefundToleranceUnitForRefund(
			String loadRefundToleranceUnitForRefund) {
		this.loadRefundToleranceUnitForRefund = loadRefundToleranceUnitForRefund;
	}

	public String getLoadRefundRefundInCurrency() {
		return loadRefundRefundInCurrency;
	}

	public void setLoadRefundRefundInCurrency(String loadRefundRefundInCurrency) {
		this.loadRefundRefundInCurrency = loadRefundRefundInCurrency;
	}

	public String getTravelLimitTravelPlan() {
		return travelLimitTravelPlan;
	}

	public void setTravelLimitTravelPlan(String travelLimitTravelPlan) {
		this.travelLimitTravelPlan = travelLimitTravelPlan;
	}

	public String getCreditLimitsMinCreditLimit() {
		return creditLimitsMinCreditLimit;
	}

	public void setCreditLimitsMinCreditLimit(String creditLimitsMinCreditLimit) {
		this.creditLimitsMinCreditLimit = creditLimitsMinCreditLimit;
	}

	public String getCreditLimitsMaxCreditLimit() {
		return creditLimitsMaxCreditLimit;
	}

	public void setCreditLimitsMaxCreditLimit(String creditLimitsMaxCreditLimit) {
		this.creditLimitsMaxCreditLimit = creditLimitsMaxCreditLimit;
	}

	public String getCreditLimitsCreditLimitValidation() {
		return creditLimitsCreditLimitValidation;
	}

	public void setCreditLimitsCreditLimitValidation(
			String creditLimitsCreditLimitValidation) {
		this.creditLimitsCreditLimitValidation = creditLimitsCreditLimitValidation;
	}

	public String getCashLimitsCashLimitType() {
		return cashLimitsCashLimitType;
	}

	public void setCashLimitsCashLimitType(String cashLimitsCashLimitType) {
		this.cashLimitsCashLimitType = cashLimitsCashLimitType;
	}

	public String getCashLimitsCashLimitAmount() {
		return cashLimitsCashLimitAmount;
	}

	public void setCashLimitsCashLimitAmount(String cashLimitsCashLimitAmount) {
		this.cashLimitsCashLimitAmount = cashLimitsCashLimitAmount;
	}

	public String getCashLimitsMinCashLimit() {
		return cashLimitsMinCashLimit;
	}

	public void setCashLimitsMinCashLimit(String cashLimitsMinCashLimit) {
		this.cashLimitsMinCashLimit = cashLimitsMinCashLimit;
	}

	public String getCashLimitsMaxCashLimit() {
		return cashLimitsMaxCashLimit;
	}

	public void setCashLimitsMaxCashLimit(String cashLimitsMaxCashLimit) {
		this.cashLimitsMaxCashLimit = cashLimitsMaxCashLimit;
	}

	public String getCashLimitsPercentageCreditLimit() {
		return cashLimitsPercentageCreditLimit;
	}

	public void setCashLimitsPercentageCreditLimit(
			String cashLimitsPercentageCreditLimit) {
		this.cashLimitsPercentageCreditLimit = cashLimitsPercentageCreditLimit;
	}

	public String getResetLimitsCashLimitReset() {
		return resetLimitsCashLimitReset;
	}

	public void setResetLimitsCashLimitReset(String resetLimitsCashLimitReset) {
		this.resetLimitsCashLimitReset = resetLimitsCashLimitReset;
	}

	public String getResetLimitsAddonLimitReset() {
		return resetLimitsAddonLimitReset;
	}
	
	public String getLoadsWithoutKyc() {
		return loadsWithoutKyc;
	}

	public String getDevicePlanProgram() {
		return DevicePlanProgram;
	}
	public void setDevicePlanProgram(String devicePlanProgram) {
		DevicePlanProgram = devicePlanProgram;
	}
	
	public void setLoadsWithoutKyc(String loadsWithoutKyc) {
		this.loadsWithoutKyc = loadsWithoutKyc;
	}

	public void setResetLimitsAddonLimitReset(String resetLimitsAddonLimitReset) {
		this.resetLimitsAddonLimitReset = resetLimitsAddonLimitReset;
	}

	public String getEventsSelectAll() {
		return eventsSelectAll;
	}

	public void setEventsSelectAll(String eventsSelectAll) {
		this.eventsSelectAll = eventsSelectAll;
	}

	public String getMccRulePlan() {
		return mccRulePlan;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	public String getWalletToWalletTransferType() {
		return walletToWalletTransferType;
	}

	public void setWalletToWalletTransferType(String walletToWalletTransferType) {
		this.walletToWalletTransferType = walletToWalletTransferType;
	}

	public String getReferenceCurrency() {
		return referenceCurrency;
	}

	public void setReferenceCurrency(String referenceCurrency) {
		this.referenceCurrency = referenceCurrency;
	}

	public String getNoOfCurrencyAllowed() {
		return noOfCurrencyAllowed;
	}

	public void setNoOfCurrencyAllowed(String noOfCurrencyAllowed) {
		this.noOfCurrencyAllowed = noOfCurrencyAllowed;
	}

	public String getRefundInCurrency() {
		return refundInCurrency;
	}

	public void setRefundInCurrency(String refundInCurrency) {
		this.refundInCurrency = refundInCurrency;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInterchange() {
		return interchange;
	}

	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProgramType() {
		return programType;
	}
	
	@Override
	public String getCode() {
		return getProgramCode();
	}
	
	public String getProgramCode() {
		return programCode;
	}
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getCalendarStartMonth() {
		return calendarStartMonth;
	}

	public void setCalendarStartMonth(String calendarStartMonth) {
		this.calendarStartMonth = calendarStartMonth;
	}

	public String getCurrencyConversionBy() {
		return currencyConversionBy;
	}

	public void setCurrencyConversionBy(String currencyConversionBy) {
		this.currencyConversionBy = currencyConversionBy;
	}
	
	public String getWalletPlanPlan1() {
		return walletPlanPlan1;
	}

	public void setWalletPlanPlan1(String walletPlanPlan1) {
		this.walletPlanPlan1 = walletPlanPlan1;
	}

	public String getDevicePlanPlan1() {
		return devicePlanPlan1;
	}

	public void setDevicePlanPlan1(String devicePlanPlan1) {
		this.devicePlanPlan1 = devicePlanPlan1;
	}

	public String getOtherPlanStatementMessagePlan() {
		return otherPlanStatementMessagePlan;
	}

	public void setOtherPlanStatementMessagePlan(
			String otherPlanStatementMessagePlan) {
		this.otherPlanStatementMessagePlan = otherPlanStatementMessagePlan;
	}

	public String getOtherPlanMarketingMessagePlan() {
		return otherPlanMarketingMessagePlan;
	}

	public void setOtherPlanMarketingMessagePlan(
			String otherPlanMarketingMessagePlan) {
		this.otherPlanMarketingMessagePlan = otherPlanMarketingMessagePlan;
	}
	
	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getMaximumCreditLimit() {
		return maximumCreditLimit;
	}

	public void setMaximumCreditLimit(String maximumCreditLimit) {
		this.maximumCreditLimit = maximumCreditLimit;
	}

	public void setCashLimitType(String cashLimitType) {
		this.cashLimitType = cashLimitType;
	}

	public String getCashLimitAmount() {
		return cashLimitAmount;
	}

	public void setCashLimitAmount(String cashLimitAmount) {
		this.cashLimitAmount = cashLimitAmount;
	}

	public String getPercentageOfCreditLimit() {
		return percentageOfCreditLimit;
	}

	public void setPercentageOfCreditLimit(String percentageOfCreditLimit) {
		this.percentageOfCreditLimit = percentageOfCreditLimit;
	}

	public String getCashLimitReset() {
		return cashLimitReset;
	}

	public void setCashLimitReset(String cashLimitReset) {
		this.cashLimitReset = cashLimitReset;
	}

	public String getAddOnLimitReset() {
		return addOnLimitReset;
	}

	public void setAddOnLimitReset(String addOnLimitReset) {
		this.addOnLimitReset = addOnLimitReset;
	}

	public String getCashLimitType() {
		return cashLimitType;
	}

	public String getMaximumBalanceWithoutKyc() {
		return maximumBalanceWithoutKyc;
	}

	public void setMaximumBalanceWithoutKyc(String maximumBalanceWithoutKyc) {
		this.maximumBalanceWithoutKyc = maximumBalanceWithoutKyc;
	}

	public String getNumberOfLoadsAllowedWithoutKyc() {
		return numberOfLoadsAllowedWithoutKyc;
	}

	public void setNumberOfLoadsAllowedWithoutKyc(
			String numberOfLoadsAllowedWithoutKyc) {
		this.numberOfLoadsAllowedWithoutKyc = numberOfLoadsAllowedWithoutKyc;
	}

	public String getDedupPlan() {
		return dedupPlan;
	}

	public void setDedupPlan(String dedupPlan) {
		this.dedupPlan = dedupPlan;
	}

	public String getDocumentChecklistPlan() {
		return documentChecklistPlan;
	}

	public void setDocumentChecklistPlan(String documentChecklistPlan) {
		this.documentChecklistPlan = documentChecklistPlan;
	}

	public String getMmcRulePlan() {
		return mccRulePlan;
	}

	public void setMccRulePlan(String mccRulePlan) {
		this.mccRulePlan = mccRulePlan;
	}

	public String getPrepaidStatementPlan() {
		return prepaidStatementPlan;
	}

	public void setPrepaidStatementPlan(String prepaidStatementPlan) {
		this.prepaidStatementPlan = prepaidStatementPlan;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
