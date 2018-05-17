package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class MCGLimitPlan {

	private static final String MCG_LIMIT_PLAN_CODE = "MCG_LIMIT_PLAN_CODE";
	private static final String PRODUCT_TYPE = "PRODUCT_TYPE";
	private static final String EFFECTIVE_DATE = "EFFECTIVE_DATE";
	private static final String END_DATE = "END_DATE";
	private static final String PERIOD = "PERIOD";
	private static final String PERIOD_NUMBER = "PERIOD_NUMBER";
	private static final String MCG_CODE = "MCG_CODE";
	private static final String FROM_MONTH_ON_BOOK = "FROM_MONTH_ON_BOOK";
	private static final String TO_MONTH_ON_BOOK = "TO_MONTH_ON_BOOK";
	private static final String PER_TRANSACTION_AMOUNT = "PER_TRANSACTION_AMOUNT";
	private static final String PER_TRANSACTION_RESPONSE = "PER_TRANSACTION_RESPONSE";
	private static final String PER_TRANSACTION_PERCENTAGE_OF_CREDIT_LIMIT = "PER_TRANSACTION_PERCENTAGE_OF_CREDIT_LIMIT";
	private static final String DAILY_AMOUNT = "DAILY_AMOUNT";
	private static final String DAILY_RESPONSE = "DAILY_RESPONSE";
	private static final String DAILY_PERCENTAGE_OF_CREDIT_LIMIT = "DAILY_PERCENTAGE_OF_CREDIT_LIMIT";
	private static final String DAILY_VELOCITY = "DAILY_VELOCITY";
	private static final String DAILY_VELOCITY_RESPONSE = "DAILY_VELOCITY_RESPONSE";
	private static final String PERIODIC_AMOUNT = "PERIODIC_AMOUNT";
	private static final String PERIODIC_RESPONSE = "PERIODIC_RESPONSE";
	private static final String PERIODIC_PERCENTAGE_OF_CREDIT_LIMIT = "PERIODIC_PERCENTAGE_OF_CREDIT_LIMIT";
	private static final String PERIODIC_VELOCITY = "PERIODIC_VELOCITY";
	private static final String PERIODIC_VELOCITY_RESPONSE = "PERIODIC_VELOCITY_RESPONSE";
	private static final String PER_TRANSACTION_AMOUNT_INTERNATIONAL = "PER_TRANSACTION_AMOUNT_INTERNATIONAL";
	private static final String PER_TRANSACTION_RESPONSE_INTERNATIONAL = "PER_TRANSACTION_RESPONSE_INTERNATIONAL";
	private static final String PER_TRANSACTION_PERCENTAGE_OF_CREDIT_LIMIT_INTERNATIONAL = "PER_TRANSACTION_PERCENTAGE_OF_CREDIT_LIMIT_INTERNATIONAL";
	private static final String DAILY_AMOUNT_INTERNATIONAL = "DAILY_AMOUNT_INTERNATIONAL";
	private static final String DAILY_RESPONSE_INTERNATIONAL = "DAILY_RESPONSE_INTERNATIONAL";
	private static final String DAILY_PERCENTAGE_OF_CREDIT_LIMIT_INTERNATIONAL = "DAILY_PERCENTAGE_OF_CREDIT_LIMIT_INTERNATIONAL";
	private static final String DAILY_VELOCITY_INTERNATIONAL = "DAILY_VELOCITY_INTERNATIONAL";
	private static final String DAILY_VELOCITY_RESPONSE_INTERNATIONAL = "DAILY_VELOCITY_RESPONSE_INTERNATIONAL";
	private static final String PERIODIC_AMOUNT_INTERNATIONAL = "PERIODIC_AMOUNT_INTERNATIONAL";
	private static final String PERIODIC_RESPONSE_INTERNATIONAL = "PERIODIC_RESPONSE_INTERNATIONAL";
	private static final String PERIODIC_PERCENTAGE_OF_CREDIT_LIMIT_INTERNATIONAL = "PERIODIC_PERCENTAGE_OF_CREDIT_LIMIT_INTERNATIONAL";
	private static final String PERIODIC_VELOCITY_INTERNATIONAL = "PERIODIC_VELOCITY_INTERNATIONAL";
	private static final String PERIODIC_VELOCITY_RESPONSE_INTERNATIONAL = "PERIODIC_VELOCITY_RESPONSE_INTERNATIONAL";


	private String mcgLimitPlanCode;
	private String description;
	private String productType;
	private String effectiveDate;
	private String endDate;
	private String period;
	private String periodNumber;
	private String mcgCode;
	private String fromMonthOnBook;
	private String toMonthOnBook;
	private String perTransactionAmount;
	private String perTransactionResponse;
	private String perTransactionPercentageOfCreditLimit;
	private String dailyAmount;
	private String dailyResponse;
	private String dailyVelocity;
	private String dailyVelocityResponse;
	private String dailyPercentageOfCreditLimit;
	private String periodicAmount;
	private String periodicResponse;
	private String periodicVelocity;
	private String periodicVelocityResponse;
	private String periodicPercentageOfCreditLimit;
	private String perTransactionInternationalAmount;
	private String perTransactionInternationalResponse;
	private String perTransactionPercentageOfCreditLimitInternational;
	private String dailyAmountInternational;
	private String dailyResponseInternational;
	private String dailyVelocityInternational;
	private String dailyVelocityResponseInternational;
	private String dailyPercentageOfCreditLimitInternational;
	private String periodicAmountInternational;
	private String periodicResponseInternational;
	private String periodicVelocityInternational;
	private String periodicVelocityResponseInternational;
	private String periodicPercentageOfCreditLimitInternational;

	public static MCGLimitPlan getMCGLimitPlanData(KeyValueProvider provider) {
		MCGLimitPlan plan = new MCGLimitPlan();
		String random = CustomUtils.randomAlphaNumeric(5).toUpperCase();
		plan.setMcgLimitPlanCode(provider.getString(MCG_LIMIT_PLAN_CODE));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setProductType(provider.getString(PRODUCT_TYPE));
		return plan;
	}

	public String getMcgLimitPlanCode() {
		return mcgLimitPlanCode;
	}

	public void setMcgLimitPlanCode(String mcgLimitPlanCode) {
		this.mcgLimitPlanCode = mcgLimitPlanCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPeriodNumber() {
		return periodNumber;
	}

	public void setPeriodNumber(String periodNumber) {
		this.periodNumber = periodNumber;
	}

	public String getMcgCode() {
		return mcgCode;
	}

	public void setMcgCode(String mcgCode) {
		this.mcgCode = mcgCode;
	}

	public String getFromMonthOnBook() {
		return fromMonthOnBook;
	}

	public void setFromMonthOnBook(String fromMonthOnBook) {
		this.fromMonthOnBook = fromMonthOnBook;
	}

	public String getToMonthOnBook() {
		return toMonthOnBook;
	}

	public void setToMonthOnBook(String toMonthOnBook) {
		this.toMonthOnBook = toMonthOnBook;
	}

	public String getPerTransactionAmount() {
		return perTransactionAmount;
	}

	public void setPerTransactionAmount(String perTransactionAmount) {
		this.perTransactionAmount = perTransactionAmount;
	}

	public String getPerTransactionResponse() {
		return perTransactionResponse;
	}

	public void setPerTransactionResponse(String perTransactionResponse) {
		this.perTransactionResponse = perTransactionResponse;
	}

	public String getPerTransactionPercentageOfCreditLimit() {
		return perTransactionPercentageOfCreditLimit;
	}

	public void setPerTransactionPercentageOfCreditLimit(
			String perTransactionPercentageOfCreditLimit) {
		this.perTransactionPercentageOfCreditLimit = perTransactionPercentageOfCreditLimit;
	}

	public String getDailyAmount() {
		return dailyAmount;
	}

	public void setDailyAmount(String dailyAmount) {
		this.dailyAmount = dailyAmount;
	}

	public String getDailyResponse() {
		return dailyResponse;
	}

	public void setDailyResponse(String dailyResponse) {
		this.dailyResponse = dailyResponse;
	}

	public String getDailyVelocity() {
		return dailyVelocity;
	}

	public void setDailyVelocity(String dailyVelocity) {
		this.dailyVelocity = dailyVelocity;
	}

	public String getDailyVelocityResponse() {
		return dailyVelocityResponse;
	}

	public void setDailyVelocityResponse(String dailyVelocityResponse) {
		this.dailyVelocityResponse = dailyVelocityResponse;
	}

	public String getDailyPercentageOfCreditLimit() {
		return dailyPercentageOfCreditLimit;
	}

	public void setDailyPercentageOfCreditLimit(
			String dailyPercentageOfCreditLimit) {
		this.dailyPercentageOfCreditLimit = dailyPercentageOfCreditLimit;
	}

	public String getPeriodicAmount() {
		return periodicAmount;
	}

	public void setPeriodicAmount(String periodicAmount) {
		this.periodicAmount = periodicAmount;
	}

	public String getPeriodicResponse() {
		return periodicResponse;
	}

	public void setPeriodicResponse(String periodicResponse) {
		this.periodicResponse = periodicResponse;
	}

	public String getPeriodicVelocity() {
		return periodicVelocity;
	}

	public void setPeriodicVelocity(String periodicVelocity) {
		this.periodicVelocity = periodicVelocity;
	}

	public String getPeriodicVelocityResponse() {
		return periodicVelocityResponse;
	}

	public void setPeriodicVelocityResponse(String periodicVelocityResponse) {
		this.periodicVelocityResponse = periodicVelocityResponse;
	}

	public String getPeriodicPercentageOfCreditLimit() {
		return periodicPercentageOfCreditLimit;
	}

	public void setPeriodicPercentageOfCreditLimit(
			String periodicPercentageOfCreditLimit) {
		this.periodicPercentageOfCreditLimit = periodicPercentageOfCreditLimit;
	}

	public String getPerTransactionInternationalAmount() {
		return perTransactionInternationalAmount;
	}

	public void setPerTransactionInternationalAmount(
			String perTransactionInternationalAmount) {
		this.perTransactionInternationalAmount = perTransactionInternationalAmount;
	}

	public String getPerTransactionInternationalResponse() {
		return perTransactionInternationalResponse;
	}

	public void setPerTransactionInternationalResponse(
			String perTransactionInternationalResponse) {
		this.perTransactionInternationalResponse = perTransactionInternationalResponse;
	}

	public String getPerTransactionPercentageOfCreditLimitInternational() {
		return perTransactionPercentageOfCreditLimitInternational;
	}

	public void setPerTransactionPercentageOfCreditLimitInternational(
			String perTransactionPercentageOfCreditLimitInternational) {
		this.perTransactionPercentageOfCreditLimitInternational = perTransactionPercentageOfCreditLimitInternational;
	}

	public String getDailyAmountInternational() {
		return dailyAmountInternational;
	}

	public void setDailyAmountInternational(String dailyAmountInternational) {
		this.dailyAmountInternational = dailyAmountInternational;
	}

	public String getDailyResponseInternational() {
		return dailyResponseInternational;
	}

	public void setDailyResponseInternational(String dailyResponseInternational) {
		this.dailyResponseInternational = dailyResponseInternational;
	}

	public String getDailyVelocityInternational() {
		return dailyVelocityInternational;
	}

	public void setDailyVelocityInternational(String dailyVelocityInternational) {
		this.dailyVelocityInternational = dailyVelocityInternational;
	}

	public String getDailyVelocityResponseInternational() {
		return dailyVelocityResponseInternational;
	}

	public void setDailyVelocityResponseInternational(
			String dailyVelocityResponseInternational) {
		this.dailyVelocityResponseInternational = dailyVelocityResponseInternational;
	}

	public String getDailyPercentageOfCreditLimitInternational() {
		return dailyPercentageOfCreditLimitInternational;
	}

	public void setDailyPercentageOfCreditLimitInternational(
			String dailyPercentageOfCreditLimitInternational) {
		this.dailyPercentageOfCreditLimitInternational = dailyPercentageOfCreditLimitInternational;
	}

	public String getPeriodicAmountInternational() {
		return periodicAmountInternational;
	}

	public void setPeriodicAmountInternational(
			String periodicAmountInternational) {
		this.periodicAmountInternational = periodicAmountInternational;
	}

	public String getPeriodicResponseInternational() {
		return periodicResponseInternational;
	}

	public void setPeriodicResponseInternational(
			String periodicResponseInternational) {
		this.periodicResponseInternational = periodicResponseInternational;
	}

	public String getPeriodicVelocityInternational() {
		return periodicVelocityInternational;
	}

	public void setPeriodicVelocityInternational(
			String periodicVelocityInternational) {
		this.periodicVelocityInternational = periodicVelocityInternational;
	}

	public String getPeriodicVelocityResponseInternational() {
		return periodicVelocityResponseInternational;
	}

	public void setPeriodicVelocityResponseInternational(
			String periodicVelocityResponseInternational) {
		this.periodicVelocityResponseInternational = periodicVelocityResponseInternational;
	}

	public String getPeriodicPercentageOfCreditLimitInternational() {
		return periodicPercentageOfCreditLimitInternational;
	}

	public void setPeriodicPercentageOfCreditLimitInternational(
			String periodicPercentageOfCreditLimitInternational) {
		this.periodicPercentageOfCreditLimitInternational = periodicPercentageOfCreditLimitInternational;
	}

}