package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class Program implements HasCodeAndDescription {

	public String Currency;

	public String Program;
	private static final String CASH_LIMIT_RESET = "CASH_LIMIT_RESET";

	private static final String CASH_LIMIT_TYPE = "CASH_LIMIT_TYPE";

	private static final String PROGRAM_TYPE = "PROGRAM_TYPE";
	
	private static final String REFUND_IN_CURRENCY = "REFUND_IN_CURRENCY";
	
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

	public static Program createWithProvider(DataProvider dataProvider, KeyValueProvider provider){
		Program programObject = dataProvider.getDataBySimpleClassName(Program.class);
		programObject.setProgramCode(MiscUtils.generate6CharAlphaNumeric());
		programObject.setDescription(ConstantData.GENERIC_DESCRIPTION);
		programObject.setProgramType(provider.getString(PROGRAM_TYPE));
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
		return programObject;
	}
	
	@Override
	public String getDescription() {
		return description;
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

	public String CurrencyConversionBy;

	public void setCurrencyConversionBy(String currencyConversionBy) {
		this.currencyConversionBy = currencyConversionBy;
	}
	
	public String getWalletPlanPlan1() {
		return walletPlanPlan1;
	}

	public String getCurrencyConversionBy() {
		return CurrencyConversionBy;
	}

	public void setCurrencyConversionBy(String currencyConversionBy) {
		CurrencyConversionBy = currencyConversionBy;
	}

	public String MaxBalanceWithoutKYC;

	public String getMaxBalanceWithoutKYC() {
		return MaxBalanceWithoutKYC;
	}

	public void setMaxBalanceWithoutKYC(String maxBalanceWithoutKYC) {
		MaxBalanceWithoutKYC = maxBalanceWithoutKYC;
	}

	public String getLoadsWithoutKYC() {
		return LoadsWithoutKYC;
	}

	public void setLoadsWithoutKYC(String loadsWithoutKYC) {
		LoadsWithoutKYC = loadsWithoutKYC;
	}

	public String LoadsWithoutKYC;

	public String ProgramType;

	public String RefundInCurrency;

	public String getRefundInCurrency() {
		return RefundInCurrency;
	}

	public void setRefundInCurrency(String refundInCurrency) {
		RefundInCurrency = refundInCurrency;
	}

	public String getProgramType() {
		return ProgramType;
	}

	public void setProgramType(String programType) {
		ProgramType = programType;

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
	public Program ProgramDataProvider() {
		Program program = new Program();
		program.setRefundInCurrency("Program");
		program.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		program.setCurrencyConversionBy(MapUtils.fnGetInputDataFromMap("CurrencyConversionBy"));
		program.setMaxBalanceWithoutKYC(MapUtils.fnGetInputDataFromMap("MaximumBalancewithoutKYC"));
		program.setLoadsWithoutKYC(MapUtils.fnGetInputDataFromMap("LoadsWithoutKYC"));
		return program;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
