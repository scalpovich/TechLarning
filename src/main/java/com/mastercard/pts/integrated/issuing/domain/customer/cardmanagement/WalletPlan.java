package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class WalletPlan implements HasCodeAndDescription {
	private static final String RETAIL_CREDIT_CARD_PART = "Retail Credit Card";
	private static final String PROGRAM_TYPE = "PROGRAM_TYPE";
	private static final String WP_CURRENCY	 = 	"WP_CURRENCY";
	private static final String WP_PRODUCT_TYPE	 = 	"WP_PRODUCT_TYPE";
	private static final String WP_PROGRAM_TYPE	 = 	"WP_PROGRAM_TYPE";
	private static final String WP_USAGE	 = 	"WP_USAGE";
	private static final String WP_CREDIT_PLAN	 = 	"WP_CREDIT_PLAN";
	private static final String WP_BILLING_CYCLE_CODE	 = 	"WP_BILLING_CYCLE_CODE";
	private static final String WP_TRANSACTION_LIMIT_PLAN = "WP_TRANSACTION_LIMIT_PLAN";
	private static final String WP_RESERVED_AMOUNT = "WP_RESERVED_AMOUNT";
	private static final String WP_SURCHARGE_PLAN = "WP_SURCHARGE_PLAN";
	private static final String WP_SURCHARGE_WAIVER_PLAN = "WP_SURCHARGE_WAIVER_PLAN";
	private static final String WP_WALLET_FEE_PLAN = "WP_WALLET_FEE_PLAN";
	private static final String WP_CASHOUT_REMITTANCE_REQUEST_EXPIRY_DAYS	 = 	"WP_CASHOUT_REMITTANCE_REQUEST_EXPIRY_DAYS";
	private static final String WP_CASHOUT_REVERSE_REMITTANCE_FEE_ON_CANCELLATION	 = 	"WP_CASHOUT_REVERSE_REMITTANCE_FEE_ON_CANCELLATION";
	private static final String WP_REFUND_ALLOW_REFUND	 = 	"WP_REFUND_ALLOW_REFUND";
	private static final String WP_REFUND_LOCKING_PERIOD_STARTS_FROM	 = 	"WP_REFUND_LOCKING_PERIOD_STARTS_FROM";
	private static final String WP_REFUND_LOCKING_PERIOD_DAYS	 = 	"WP_REFUND_LOCKING_PERIOD_DAYS";
	private static final String WP_REFUND_CLOSURE_AFTER_LOCKING_PERIOD_DAYS	 = 	"WP_REFUND_CLOSURE_AFTER_LOCKING_PERIOD_DAYS";
	private static final String WP_WALLET_INACTVITY_RULES_MINIMUM_BAL_THRESHOLD	 = 	"WP_WALLET_INACTVITY_RULES_MINIMUM_BAL_THRESHOLD";
	private static final String WP_WALLET_INACTVITY_RULES_INACTIVITY_OPERATION	 = 	"WP_WALLET_INACTVITY_RULES_INACTIVITY_OPERATION";
	private static final String WP_WALLET_INACTVITY_RULES_INACTIVITY_AFTER_DAYS	 = 	"WP_WALLET_INACTVITY_RULES_INACTIVITY_AFTER_DAYS";
	private static final String WP_WALLET_INACTVITY_RULES_CLOSURE_WALLET_AFTER_DAYS	 = 	"WP_WALLET_INACTVITY_RULES_CLOSURE_WALLET_AFTER_DAYS";
	private static final String WP_WALLET_RESERVERD_AMOUNT= "WP_WALLET_RESERVERD_AMOUNT";
	
	private String walletReserveAmount;
	private String description;
	private String walletPlanCode;
	private String currency;
	private String productType;
	private String programType;
	private String product;
	private String usage;
	private String dummyAccountNumber;
	private String billingCyleCode;
	private String creditPlan;	
	private String currencyWalletPlan;
	private String cashoutRemittanceRequestExpiryDays;
	private String cashoutReverseRemittanceFeeOnCancellation;
	private String refundAllowRefund;
	private String refundLockingPeriodStartsFrom;
	private String refundLockingPeriodDays;
	private String refundClosureAfterLockingPeriodDays;
	private String walletInactvityRulesMinimumBalThreshold;
	private String walletInactvityRulesInactivityOperation;
	private String walletInactvityRulesInactivityAfterDays;
	private String walletInactvityRulesClosureWalletAfterDays;
	private String walletType;
	private String usageType;
	private String WalletPlanUsage;
	private String walletPlan;
	private String openloopWalletPlan;
	private String closedloopWalletPlan;
	private String transactionLimitPlan; 
	private String reservedAmount;
	private String surchargePlan;
	private String surchargeWaiverPlan;
	private String walletFeePlan;
	private String firstWallet;
	private String secondWallet;
	
	public String getSecondWallet() {
		return secondWallet;
	}

	public void setSecondWallet(String secondWallet) {
		this.secondWallet = secondWallet;
	}

	public String getFirstWallet() {
		return firstWallet;
	}

	public void setFirstWallet(String firstWallet) {
		this.firstWallet = firstWallet;
	}
	
	public String getWalletReserveAmount() {
		return walletReserveAmount;
	}

	public void setWalletReserveAmount(String walletReserveAmount) {
		this.walletReserveAmount = walletReserveAmount;
	}


	public String getTransactionLimitPlan() {
		return transactionLimitPlan;
	}

	public void setTransactionLimitPlan(String transactionLimitPlan) {
		this.transactionLimitPlan = transactionLimitPlan;
	}

	public String getReservedAmount() {
		return reservedAmount;
	}

	public void setReservedAmount(String reservedAmount) {
		this.reservedAmount = reservedAmount;
	}

	public String getSurchargePlan() {
		return surchargePlan;
	}

	public void setSurchargePlan(String surchargePlan) {
		this.surchargePlan = surchargePlan;
	}

	public String getSurchargeWaiverPlan() {
		return surchargeWaiverPlan;
	}

	public void setSurchargeWaiverPlan(String surchargeWaiverPlan) {
		this.surchargeWaiverPlan = surchargeWaiverPlan;
	}

	public String getWalletFeePlan() {
		return walletFeePlan;
	}

	public void setWalletFeePlan(String walletFeePlan) {
		this.walletFeePlan = walletFeePlan;
	}
	
	private static void setGenericData(WalletPlan plan) {
		plan.setWalletPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
	}
	
	private static void setCreditConfig(WalletPlan plan) {
		plan.setCreditPlan(MapUtils.fnGetInputDataFromMap(WP_CREDIT_PLAN));
		plan.setBillingCyleCode(MapUtils.fnGetInputDataFromMap(WP_BILLING_CYCLE_CODE));
	}
	
	private static void setUsageLimitsFees(WalletPlan plan) {
		plan.setTransactionLimitPlan(MapUtils.fnGetInputDataFromMap(WP_TRANSACTION_LIMIT_PLAN));
		plan.setReservedAmount(MapUtils.fnGetInputDataFromMap(WP_RESERVED_AMOUNT));
		plan.setSurchargePlan(MapUtils.fnGetInputDataFromMap(WP_SURCHARGE_PLAN));
		plan.setSurchargeWaiverPlan(MapUtils.fnGetInputDataFromMap(WP_SURCHARGE_WAIVER_PLAN));
		plan.setWalletFeePlan(MapUtils.fnGetInputDataFromMap(WP_WALLET_FEE_PLAN));
	}
	
	public static WalletPlan getWalletPlanDataFromExcel() {
		WalletPlan plan = new WalletPlan();
		setGenericData(plan);
		plan.setCurrency(MapUtils.fnGetInputDataFromMap(WP_CURRENCY));
		plan.setProductType(MapUtils.fnGetInputDataFromMap(WP_PRODUCT_TYPE));
		plan.setWalletPlanUsage(MapUtils.fnGetInputDataFromMap(WP_USAGE));
		setCreditConfig(plan);
		setUsageLimitsFees(plan);
		
		return plan;
	}
	
	public static WalletPlan createWithProvider(DataProvider provider, KeyValueProvider keyValueProvider) {
		WalletPlan plan = provider.getDataBySimpleClassName(WalletPlan.class);
		setGenericData(plan);
		plan.setProgramType(keyValueProvider.getString(PROGRAM_TYPE));
		plan.setReservedAmount(keyValueProvider.getString(WP_WALLET_RESERVERD_AMOUNT));
		plan.setDummyAccountNumber(RandomStringUtils.randomNumeric(6));
		return plan;
	}
	
	public static WalletPlan createWithProvider(KeyValueProvider provider) {
		WalletPlan plan = new WalletPlan();
		setGenericData(plan);
		plan.setProgramType(provider.getString(WP_PROGRAM_TYPE));
		plan.setCurrency(provider.getString(WP_CURRENCY));
		plan.setUsage(provider.getString(WP_USAGE));
		plan.setDummyAccountNumber(RandomStringUtils.randomNumeric(6));
		plan.setCashoutRemittanceRequestExpiryDays(provider.getString(WP_CASHOUT_REMITTANCE_REQUEST_EXPIRY_DAYS));
		plan.setCashoutReverseRemittanceFeeOnCancellation(provider.getString(WP_CASHOUT_REVERSE_REMITTANCE_FEE_ON_CANCELLATION));
		plan.setRefundAllowRefund(provider.getString(WP_REFUND_ALLOW_REFUND));
		plan.setRefundLockingPeriodStartsFrom(provider.getString(WP_REFUND_LOCKING_PERIOD_STARTS_FROM));
		plan.setRefundLockingPeriodDays(provider.getString(WP_REFUND_LOCKING_PERIOD_DAYS));
		plan.setRefundClosureAfterLockingPeriodDays(provider.getString(WP_REFUND_CLOSURE_AFTER_LOCKING_PERIOD_DAYS));
		plan.setWalletInactvityRulesMinimumBalThreshold(provider.getString(WP_WALLET_INACTVITY_RULES_MINIMUM_BAL_THRESHOLD));
		plan.setWalletInactvityRulesInactivityOperation(provider.getString(WP_WALLET_INACTVITY_RULES_INACTIVITY_OPERATION));
		plan.setWalletInactvityRulesInactivityAfterDays(provider.getString(WP_WALLET_INACTVITY_RULES_INACTIVITY_AFTER_DAYS));
		plan.setWalletInactvityRulesClosureWalletAfterDays(provider.getString(WP_WALLET_INACTVITY_RULES_CLOSURE_WALLET_AFTER_DAYS));
		return plan;
	}
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	public String getCurrencyWalletPlan() {
		return currencyWalletPlan;
	}

	public void setCurrencyWalletPlan(String currencyWalletPlan) {
		this.currencyWalletPlan = currencyWalletPlan;
	}
	public String getCashoutRemittanceRequestExpiryDays() {
		return cashoutRemittanceRequestExpiryDays;
	}

	public void setCashoutRemittanceRequestExpiryDays(
			String cashoutRemittanceRequestExpiryDays) {
		this.cashoutRemittanceRequestExpiryDays = cashoutRemittanceRequestExpiryDays;
	}

	public String getCashoutReverseRemittanceFeeOnCancellation() {
		return cashoutReverseRemittanceFeeOnCancellation;
	}

	public void setCashoutReverseRemittanceFeeOnCancellation(
			String cashoutReverseRemittanceFeeOnCancellation) {
		this.cashoutReverseRemittanceFeeOnCancellation = cashoutReverseRemittanceFeeOnCancellation;
	}

	public String getRefundAllowRefund() {
		return refundAllowRefund;
	}

	public void setRefundAllowRefund(String refundAllowRefund) {
		this.refundAllowRefund = refundAllowRefund;
	}

	public String getRefundLockingPeriodStartsFrom() {
		return refundLockingPeriodStartsFrom;
	}

	public void setRefundLockingPeriodStartsFrom(
			String refundLockingPeriodStartsFrom) {
		this.refundLockingPeriodStartsFrom = refundLockingPeriodStartsFrom;
	}

	public String getRefundLockingPeriodDays() {
		return refundLockingPeriodDays;
	}

	public void setRefundLockingPeriodDays(String refundLockingPeriodDays) {
		this.refundLockingPeriodDays = refundLockingPeriodDays;
	}

	public String getRefundClosureAfterLockingPeriodDays() {
		return refundClosureAfterLockingPeriodDays;
	}

	public void setRefundClosureAfterLockingPeriodDays(
			String refundClosureAfterLockingPeriodDays) {
		this.refundClosureAfterLockingPeriodDays = refundClosureAfterLockingPeriodDays;
	}

	public String getWalletInactvityRulesMinimumBalThreshold() {
		return walletInactvityRulesMinimumBalThreshold;
	}

	public void setWalletInactvityRulesMinimumBalThreshold(
			String walletInactvityRulesMinimumBalThreshold) {
		this.walletInactvityRulesMinimumBalThreshold = walletInactvityRulesMinimumBalThreshold;
	}

	public String getWalletInactvityRulesInactivityOperation() {
		return walletInactvityRulesInactivityOperation;
	}

	public void setWalletInactvityRulesInactivityOperation(
			String walletInactvityRulesInactivityOperation) {
		this.walletInactvityRulesInactivityOperation = walletInactvityRulesInactivityOperation;
	}

	public String getWalletInactvityRulesInactivityAfterDays() {
		return walletInactvityRulesInactivityAfterDays;
	}

	public void setWalletInactvityRulesInactivityAfterDays(
			String walletInactvityRulesInactivityAfterDays) {
		this.walletInactvityRulesInactivityAfterDays = walletInactvityRulesInactivityAfterDays;
	}

	public String getWalletInactvityRulesClosureWalletAfterDays() {
		return walletInactvityRulesClosureWalletAfterDays;
	}

	public void setWalletInactvityRulesClosureWalletAfterDays(
			String walletInactvityRulesClosureWalletAfterDays) {
		this.walletInactvityRulesClosureWalletAfterDays = walletInactvityRulesClosureWalletAfterDays;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getWalletPlan() {
		return walletPlan;
	}

	public void setWalletPlan(String walletPlan) {
		this.walletPlan = walletPlan;
	}

	public String getWalletType() {
		return walletType;
	}

	public String getClosedloopWalletPlan() {
		return closedloopWalletPlan;
	}

	public void setClosedloopWalletPlan(String closedloopWalletPlan) {
		this.closedloopWalletPlan = closedloopWalletPlan;
	}

	public String getUsageType() {
		return usageType;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public String getOpenloopWalletPlan() {
		return openloopWalletPlan;
	}

	public void setOpenloopWalletPlan(String openloopWalletPlan) {
		this.openloopWalletPlan = openloopWalletPlan;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}


	
	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}
	
	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	@Override
	public String getCode() {
		return getWalletPlanCode();
	}
	
	public String getWalletPlanCode() {
		return walletPlanCode;
	}

	public void setWalletPlanCode(String walletPlanCode) {
		this.walletPlanCode = walletPlanCode;
	}

	public String getDummyAccountNumber() {
		return dummyAccountNumber;
	}

	public void setDummyAccountNumber(String dummyAccountNumber) {
		this.dummyAccountNumber = dummyAccountNumber;
	}

	public String getBillingCyleCode() {
		return billingCyleCode;
	}

	public void setBillingCyleCode(String billingCyleCode) {
		this.billingCyleCode = billingCyleCode;
	}

	public String getCreditPlan() {
		return creditPlan;
	}

	public void setCreditPlan(String creditPlan) {
		this.creditPlan = creditPlan;
	}

	public String getWalletPlanUsage() {
		return WalletPlanUsage;
	}

	public void setWalletPlanUsage(String walletPlanUsage) {
		this.WalletPlanUsage = walletPlanUsage;
	}

	public static WalletPlan walletplanDataprovider() {
		WalletPlan walletplan = new WalletPlan();
		walletplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		walletplan.setWalletPlanUsage(MapUtils.fnGetInputDataFromMap("WalletplanUsage"));
		return walletplan;
	}

	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}

}
