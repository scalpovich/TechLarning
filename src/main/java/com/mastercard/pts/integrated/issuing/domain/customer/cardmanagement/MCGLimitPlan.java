package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class MCGLimitPlan {

	private static final String MCG_CODE = "MCG_CODE";
	private static final String FROM_MONTH_ON_BOOK = "0";
	private static final String TO_MONTH_ON_BOOK = "12";
	private static final String MCG_DAILY_AMOUNT = "MCG_DAILY_AMOUNT";
	private static final String MCG_DAILY_RESPONSE = "MCG_DAILY_RESPONSE";
	private static final String MCG_DAILY_VELOCITY = "MCG_DAILY_VELOCITY";
	private static final String MCG_DAILY_VELOCITY_RESPONSE = "MCG_DAILY_VELOCITY_RESPONSE";
	private static final String MCG_DAILY_AMOUNT_INTERNATIONAL = "DAILY_AMOUNT_INTERNATIONAL";
	public static final String EXCEEDS_AMOUNT_LIMIT_DOMESTIC_DESCRIPTION ="MCC - Transaction amount is greater than daily amount configured at Wallet Plan level (Domestic).";
	public static final String FREQUENCY_EXCEEDED_DOMESTIC_DESCRIPTION ="MCC - Transaction amount is greater than daily velocity configured at Wallet Plan level (Domestic).";
	public static final String EXCEEDS_AMOUNT_LIMIT_INTERNATIONAL_DESCRIPTION ="MCC - Transaction amount is greater than daily amount configured at Wallet Plan level (International).";
	public static final String FREQUENCY_EXCEEDED_INTERNATIONAL_DESCRIPTION ="MCC - Transaction amount is greater than daily velocity configured at Wallet Plan level (International).";
	public static final String EXCEEDS_AMOUNT_LIMIT_PER_TRANS_DOMESTIC_DESCRIPTION ="MCC - Transaction amount is greater than per transaction amount configured at Wallet Plan level (Domestic).";
	public static final String EXCEEDS_AMOUNT_LIMIT_PER_TRANS_INTERNATIONAL_DESCRIPTION ="MCC - Transaction amount is greater than per transaction amount configured at Wallet Plan level (International).";
	public static final String FREQUENCY_EXCEEDED_PERIODIC_DOMESTIC_DESCRIPTION ="MCC - Transaction amount is greater than periodic velocity configured at Wallet Plan level (Domestic).";
	public static final String EXCEEDS_AMOUNT_LIMIT_PERIODIC_DOMESTIC_DESCRIPTION ="MCC - Transaction amount is greater than periodic amount configured at Wallet Plan level (Domestic).";
	public static final String FREQUENCY_EXCEEDED_PERIODIC_INTERNATIONAL_DESCRIPTION ="MCC - Transaction amount is greater than periodic velocity configured at Wallet Plan level (International).";
	public static final String EXCEEDS_AMOUNT_LIMIT_PERIODIC_INTERNATIONAL_DESCRIPTION ="MCC - Transaction amount is greater than periodic amount configured at Wallet Plan level (International).";	
	
	private String mcgLimitPlanCode;
	private String description;
	private String productType;
	private LocalDate effectiveDate;
	private LocalDate endDate;
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
		plan.setMcgLimitPlanCode(random);
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setMcgCode(provider.getString(MCG_CODE));
		plan.setFromMonthOnBook(FROM_MONTH_ON_BOOK);
		plan.setEffectiveDate(LocalDate.now().plusDays(1));
		plan.setEndDate(LocalDate.now().plusDays(100));
		plan.setToMonthOnBook(TO_MONTH_ON_BOOK);
		plan.setDailyAmount(provider.getString(MCG_DAILY_AMOUNT));
		plan.setDailyResponse(provider.getString(MCG_DAILY_RESPONSE));
		plan.setDailyVelocity(provider.getString(MCG_DAILY_VELOCITY));
		plan.setDailyVelocityResponse(provider.getString(MCG_DAILY_VELOCITY_RESPONSE));
		plan.setDailyAmountInternational(provider.getString(MCG_DAILY_AMOUNT_INTERNATIONAL));
		return plan;
	}
	
	public static Map<String,String> getAuthDeclineDescription(){
		HashMap<String,String> description = new HashMap<String, String>();
		description.put("Exceeds Amount Limit Domestic", EXCEEDS_AMOUNT_LIMIT_DOMESTIC_DESCRIPTION);
		description.put("Frequency Exceeded Domestic",FREQUENCY_EXCEEDED_DOMESTIC_DESCRIPTION);
		description.put("Exceeds Amount Limit International", EXCEEDS_AMOUNT_LIMIT_INTERNATIONAL_DESCRIPTION);
		description.put("Frequency Exceeded International",FREQUENCY_EXCEEDED_INTERNATIONAL_DESCRIPTION);
		description.put("Exceeds Amount Limit Per Trans Domestic",EXCEEDS_AMOUNT_LIMIT_PER_TRANS_DOMESTIC_DESCRIPTION);
		description.put("Exceeds Amount Limit Per Trans International",EXCEEDS_AMOUNT_LIMIT_PER_TRANS_INTERNATIONAL_DESCRIPTION);
		description.put("Frequency Exceeded Periodic Domestic",FREQUENCY_EXCEEDED_PERIODIC_DOMESTIC_DESCRIPTION);
		description.put("Exceeds Amount Limit Periodic Domestic",EXCEEDS_AMOUNT_LIMIT_PERIODIC_DOMESTIC_DESCRIPTION);
		description.put("Frequency Exceeded Periodic International",FREQUENCY_EXCEEDED_PERIODIC_INTERNATIONAL_DESCRIPTION);
		description.put("Exceeds Amount Limit Periodic International",EXCEEDS_AMOUNT_LIMIT_PERIODIC_INTERNATIONAL_DESCRIPTION);
		return description;
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
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}

}