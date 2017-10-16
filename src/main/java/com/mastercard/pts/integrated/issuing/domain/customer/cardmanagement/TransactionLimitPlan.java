package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class TransactionLimitPlan implements HasCodeAndDescription {
	
	private static final String TP_PLAN_TYPE = "TP_PLAN_TYPE";
	private static final String TP_START_MONTH_FOR_YEARLY_LIMITS = "TP_START_MONTH_FOR_YEARLY_LIMITS";
	private static final String TP_PERIODICITY = "TP_PERIODICITY";
	private static final String TP_DEBIT_TRANSACTIONS_TOTAL_DAILY_VELOCITY	 = 	"TP_DEBIT_TRANSACTIONS_TOTAL_DAILY_VELOCITY";
	private static final String TP_DEBIT_TRANSACTIONS_TOTAL_PERIODIC_VELOCITY	 = 	"TP_DEBIT_TRANSACTIONS_TOTAL_PERIODIC_VELOCITY";
	private static final String TP_DEBIT_TRANSACTIONS_TOTAL_YEARLY_VELOCITY	 = 	"TP_DEBIT_TRANSACTIONS_TOTAL_YEARLY_VELOCITY";
	private static final String TP_DEBIT_TRANSACTIONS_TOTAL_DAILY_AMOUNT_LIMIT	 = 	"TP_DEBIT_TRANSACTIONS_TOTAL_DAILY_AMOUNT_LIMIT";
	private static final String TP_DEBIT_TRANSACTIONS_TOTAL_PERIODIC_AMOUNT_LIMIT	 = 	"TP_DEBIT_TRANSACTIONS_TOTAL_PERIODIC_AMOUNT_LIMIT";
	private static final String TP_DEBIT_TRANSACTIONS_TOTAL_YEARLY_AMOUNT_LIMIT	 = 	"TP_DEBIT_TRANSACTIONS_TOTAL_YEARLY_AMOUNT_LIMIT";
	private static final String TP_CREDIT_TRANSACTIONS_TOTAL_DAILY_VELOCITY	 = 	"TP_CREDIT_TRANSACTIONS_TOTAL_DAILY_VELOCITY";
	private static final String TP_CREDIT_TRANSACTIONS_TOTAL_PERIODIC_VELOCITY	 = 	"TP_CREDIT_TRANSACTIONS_TOTAL_PERIODIC_VELOCITY";
	private static final String TP_CREDIT_TRANSACTIONS_TOTAL_YEARLY_VELOCITY	 = 	"TP_CREDIT_TRANSACTIONS_TOTAL_YEARLY_VELOCITY";
	private static final String TP_CREDIT_TRANSACTIONS_TOTAL_DAILY_AMOUNT_LIMIT	 = 	"TP_CREDIT_TRANSACTIONS_TOTAL_DAILY_AMOUNT_LIMIT";
	private static final String TP_CREDIT_TRANSACTIONS_TOTAL_PERIODIC_AMOUNT_LIMIT	 = 	"TP_CREDIT_TRANSACTIONS_TOTAL_PERIODIC_AMOUNT_LIMIT";
	private static final String TP_CREDIT_TRANSACTIONS_TOTAL_YEARLY_AMOUNT_LIMIT	 = 	"TP_CREDIT_TRANSACTIONS_TOTAL_YEARLY_AMOUNT_LIMIT";

	private String transactionLimitPlanCode;
	private String description; 
	private String iframeproductType;
	private String iframePlanType;
	private String iframeStartMonthForYearlyLimits;
	public String CeilingAmount;
	public String FloorAmount;
	private String periodicity;
	private String customerInitiatedDebitTransactionLimitsDailyVelocity;
	private String customerInitiatedDebitTransactionLimitsPeriodicVelocity;
	private String customerInitiatedDebitTransactionLimitsYearlyVelocity;
	private String customerInitiatedDebitTransactionLimitsDailyAmountLimit;
	private String customerInitiatedDebitTransactionLimitsPeriodicAmountLimit;
	private String customerInitiatedDebitTransactionLimitsYealyAmountLimit;
	
	private String customerInitiatedCreditTransactionLimitsDailyVelocity;
	private String customerInitiatedCreditTransactionLimitsPeriodicVelocity;
	private String customerInitiatedCreditTransactionLimitsYearlyVelocity;
	private String customerInitiatedCreditTransactionLimitsDailyAmountLimit;
	private String customerInitiatedCreditTransactionLimitsPeriodicAmountLimit;
	private String customerInitiatedCreditTransactionLimitsYealyAmountLimit;
	
	public String getPeriodicity() {
		return periodicity;
	}


	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}
	
	public String getCustomerInitiatedDebitTransactionLimitsDailyVelocity() {
		return customerInitiatedDebitTransactionLimitsDailyVelocity;
	}

	public void setCustomerInitiatedDebitTransactionLimitsDailyVelocity(
			String customerInitiatedDebitTransactionLimitsDailyVelocity) {
		this.customerInitiatedDebitTransactionLimitsDailyVelocity = customerInitiatedDebitTransactionLimitsDailyVelocity;
	}

	public String getCustomerInitiatedDebitTransactionLimitsPeriodicVelocity() {
		return customerInitiatedDebitTransactionLimitsPeriodicVelocity;
	}

	public void setCustomerInitiatedDebitTransactionLimitsPeriodicVelocity(
			String customerInitiatedDebitTransactionLimitsPeriodicVelocity) {
		this.customerInitiatedDebitTransactionLimitsPeriodicVelocity = customerInitiatedDebitTransactionLimitsPeriodicVelocity;
	}

	public String getCustomerInitiatedDebitTransactionLimitsYearlyVelocity() {
		return customerInitiatedDebitTransactionLimitsYearlyVelocity;
	}

	public void setCustomerInitiatedDebitTransactionLimitsYearlyVelocity(
			String customerInitiatedDebitTransactionLimitsYearlyVelocity) {
		this.customerInitiatedDebitTransactionLimitsYearlyVelocity = customerInitiatedDebitTransactionLimitsYearlyVelocity;
	}

	public String getCustomerInitiatedDebitTransactionLimitsDailyAmountLimit() {
		return customerInitiatedDebitTransactionLimitsDailyAmountLimit;
	}

	public void setCustomerInitiatedDebitTransactionLimitsDailyAmountLimit(
			String customerInitiatedDebitTransactionLimitsDailyAmountLimit) {
		this.customerInitiatedDebitTransactionLimitsDailyAmountLimit = customerInitiatedDebitTransactionLimitsDailyAmountLimit;
	}

	public String getCustomerInitiatedDebitTransactionLimitsPeriodicAmountLimit() {
		return customerInitiatedDebitTransactionLimitsPeriodicAmountLimit;
	}

	public void setCustomerInitiatedDebitTransactionLimitsPeriodicAmountLimit(
			String customerInitiatedDebitTransactionLimitsPeriodicAmountLimit) {
		this.customerInitiatedDebitTransactionLimitsPeriodicAmountLimit = customerInitiatedDebitTransactionLimitsPeriodicAmountLimit;
	}

	public String getCustomerInitiatedDebitTransactionLimitsYealyAmountLimit() {
		return customerInitiatedDebitTransactionLimitsYealyAmountLimit;
	}

	public void setCustomerInitiatedDebitTransactionLimitsYealyAmountLimit(
			String customerInitiatedDebitTransactionLimitsYealyAmountLimit) {
		this.customerInitiatedDebitTransactionLimitsYealyAmountLimit = customerInitiatedDebitTransactionLimitsYealyAmountLimit;
	}

	public String getCustomerInitiatedCreditTransactionLimitsDailyVelocity() {
		return customerInitiatedCreditTransactionLimitsDailyVelocity;
	}

	public void setCustomerInitiatedCreditTransactionLimitsDailyVelocity(
			String customerInitiatedCreditTransactionLimitsDailyVelocity) {
		this.customerInitiatedCreditTransactionLimitsDailyVelocity = customerInitiatedCreditTransactionLimitsDailyVelocity;
	}

	public String getCustomerInitiatedCreditTransactionLimitsPeriodicVelocity() {
		return customerInitiatedCreditTransactionLimitsPeriodicVelocity;
	}

	public void setCustomerInitiatedCreditTransactionLimitsPeriodicVelocity(
			String customerInitiatedCreditTransactionLimitsPeriodicVelocity) {
		this.customerInitiatedCreditTransactionLimitsPeriodicVelocity = customerInitiatedCreditTransactionLimitsPeriodicVelocity;
	}

	public String getCustomerInitiatedCreditTransactionLimitsYearlyVelocity() {
		return customerInitiatedCreditTransactionLimitsYearlyVelocity;
	}

	public void setCustomerInitiatedCreditTransactionLimitsYearlyVelocity(
			String customerInitiatedCreditTransactionLimitsYearlyVelocity) {
		this.customerInitiatedCreditTransactionLimitsYearlyVelocity = customerInitiatedCreditTransactionLimitsYearlyVelocity;
	}

	public String getCustomerInitiatedCreditTransactionLimitsDailyAmountLimit() {
		return customerInitiatedCreditTransactionLimitsDailyAmountLimit;
	}

	public void setCustomerInitiatedCreditTransactionLimitsDailyAmountLimit(
			String customerInitiatedCreditTransactionLimitsDailyAmountLimit) {
		this.customerInitiatedCreditTransactionLimitsDailyAmountLimit = customerInitiatedCreditTransactionLimitsDailyAmountLimit;
	}

	public String getCustomerInitiatedCreditTransactionLimitsPeriodicAmountLimit() {
		return customerInitiatedCreditTransactionLimitsPeriodicAmountLimit;
	}

	public void setCustomerInitiatedCreditTransactionLimitsPeriodicAmountLimit(
			String customerInitiatedCreditTransactionLimitsPeriodicAmountLimit) {
		this.customerInitiatedCreditTransactionLimitsPeriodicAmountLimit = customerInitiatedCreditTransactionLimitsPeriodicAmountLimit;
	}

	public String getCustomerInitiatedCreditTransactionLimitsYealyAmountLimit() {
		return customerInitiatedCreditTransactionLimitsYealyAmountLimit;
	}

	public void setCustomerInitiatedCreditTransactionLimitsYealyAmountLimit(
			String customerInitiatedCreditTransactionLimitsYealyAmountLimit) {
		this.customerInitiatedCreditTransactionLimitsYealyAmountLimit = customerInitiatedCreditTransactionLimitsYealyAmountLimit;
	}
	
	private List<TransactionLimitPlanDetails> transactionLimitPlanDetails = new ArrayList<>();
	
	public static TransactionLimitPlan createWithProvider(DataProvider provider) {
		TransactionLimitPlan plan = provider.getDataBySimpleClassName(TransactionLimitPlan.class);
		plan.setTransactionLimitPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	public static TransactionLimitPlan createWithProvider(KeyValueProvider provider) {
		TransactionLimitPlan plan = new TransactionLimitPlan();
		plan.setTransactionLimitPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setIframePlanType(provider.getString(TP_PLAN_TYPE));
		plan.setIframeStartMonthForYearlyLimits(provider.getString(TP_START_MONTH_FOR_YEARLY_LIMITS));
		plan.setPeriodicity(provider.getString(TP_PERIODICITY));
		plan.setCustomerInitiatedCreditTransactionLimitsDailyAmountLimit(provider.getString(TP_CREDIT_TRANSACTIONS_TOTAL_DAILY_AMOUNT_LIMIT));
		plan.setCustomerInitiatedCreditTransactionLimitsDailyVelocity(provider.getString(TP_CREDIT_TRANSACTIONS_TOTAL_DAILY_VELOCITY));
		plan.setCustomerInitiatedCreditTransactionLimitsPeriodicAmountLimit(provider.getString(TP_CREDIT_TRANSACTIONS_TOTAL_PERIODIC_AMOUNT_LIMIT	 ));
		plan.setCustomerInitiatedCreditTransactionLimitsPeriodicVelocity(provider.getString(TP_CREDIT_TRANSACTIONS_TOTAL_PERIODIC_VELOCITY));
		plan.setCustomerInitiatedCreditTransactionLimitsYealyAmountLimit(provider.getString(TP_CREDIT_TRANSACTIONS_TOTAL_YEARLY_AMOUNT_LIMIT	 ));
		plan.setCustomerInitiatedCreditTransactionLimitsYearlyVelocity(provider.getString(TP_CREDIT_TRANSACTIONS_TOTAL_YEARLY_VELOCITY));
		plan.setCustomerInitiatedDebitTransactionLimitsDailyAmountLimit(provider.getString(TP_DEBIT_TRANSACTIONS_TOTAL_DAILY_AMOUNT_LIMIT));
		plan.setCustomerInitiatedDebitTransactionLimitsDailyVelocity(provider.getString(TP_DEBIT_TRANSACTIONS_TOTAL_DAILY_VELOCITY));
		plan.setCustomerInitiatedDebitTransactionLimitsPeriodicAmountLimit(provider.getString(TP_DEBIT_TRANSACTIONS_TOTAL_PERIODIC_AMOUNT_LIMIT));
		plan.setCustomerInitiatedDebitTransactionLimitsPeriodicVelocity(provider.getString(TP_DEBIT_TRANSACTIONS_TOTAL_PERIODIC_VELOCITY));
		plan.setCustomerInitiatedDebitTransactionLimitsYealyAmountLimit(provider.getString(TP_DEBIT_TRANSACTIONS_TOTAL_YEARLY_AMOUNT_LIMIT));
		plan.setCustomerInitiatedDebitTransactionLimitsYearlyVelocity(provider.getString(TP_DEBIT_TRANSACTIONS_TOTAL_YEARLY_VELOCITY));
		return plan;
	}
	
	@Override
	public String getCode() {
		return getTransactionLimitPlanCode();
	}
	
	public String getTransactionLimitPlanCode() {
		return transactionLimitPlanCode;
	}
	
	public void setTransactionLimitPlanCode(
			String transactionLimitPlanCode) {
		this.transactionLimitPlanCode = transactionLimitPlanCode;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getIframeproductType() {
		return iframeproductType;
	}
	public void setIframeproductType(String iframeproductType) {
		this.iframeproductType = iframeproductType;
	}
	public String getIframePlanType() {
		return iframePlanType;
	}
	public void setIframePlanType(String iframePlanType) {
		this.iframePlanType = iframePlanType;
	}
	public String getIframeStartMonthForYearlyLimits() {
		return iframeStartMonthForYearlyLimits;
	}
	public void setIframeStartMonthForYearlyLimits(
			String iframeStartMonthForYearlyLimits) {
		this.iframeStartMonthForYearlyLimits = iframeStartMonthForYearlyLimits;
	}
	
	public List<TransactionLimitPlanDetails> getTransactionLimitPlanDetails() {
		return transactionLimitPlanDetails;
	}

	public void setTransactionLimitPlanDetails(List<TransactionLimitPlanDetails> transactionLimitPlanDetails) {
		this.transactionLimitPlanDetails = transactionLimitPlanDetails;
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
public String getStartMonthForYearlyLimits() {
		return StartMonthForYearlyLimits;
	}

	public void setStartMonthForYearlyLimits(String startMonthForYearlyLimits) {
		StartMonthForYearlyLimits = startMonthForYearlyLimits;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public String getFloorAmount() {
		return FloorAmount;
	}

	public void setFloorAmount(String floorAmount) {
		FloorAmount = floorAmount;
	}

	public String getCeilingAmount() {
		return CeilingAmount;
	}

	public void setCeilingAmount(String ceilingAmount) {
		CeilingAmount = ceilingAmount;
	}

	public static TransactionLimitPlan transactionlimitDataProvider() {
		TransactionLimitPlan transactionlimitplan = new TransactionLimitPlan();
		transactionlimitplan.setStartMonthForYearlyLimits(MapUtils.fnGetInputDataFromMap("StartMonthForYearlyLimits"));
		transactionlimitplan.setTransactionType(MapUtils.fnGetInputDataFromMap("TransactionType"));
		transactionlimitplan.setFloorAmount(MapUtils.fnGetInputDataFromMap("FloorAmount"));
		transactionlimitplan.setCeilingAmount(MapUtils.fnGetInputDataFromMap("CeilingAmount"));
		return transactionlimitplan;
	}

}
