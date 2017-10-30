package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class WalletPlan implements HasCodeAndDescription {
	private static final String PROGRAM_TYPE = "PROGRAM_TYPE";
	private static final String WP_CURRENCY	 = 	"WP_CURRENCY";
	private static final String WP_PROGRAM_TYPE	 = 	"WP_PROGRAM_TYPE";
	private static final String WP_USAGE	 = 	"WP_USAGE";
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

	private String description;
	private String walletPlanCode;
	private String currency;
	private String productType;
	private String programType;
	private String usage;
	private String dummyAccountNumber;
	private String billingCyleCode;
	private String creditPlan;
	
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
	public String Currency;

	public String WalletPlanUsage;
	public static WalletPlan createWithProvider(DataProvider provider, KeyValueProvider keyValueProvider) {
		WalletPlan plan = provider.getDataBySimpleClassName(WalletPlan.class);
		plan.setWalletPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setProgramType(keyValueProvider.getString(PROGRAM_TYPE));
		plan.setDummyAccountNumber(RandomStringUtils.randomNumeric(6));
		return plan;
	}
	
	public static WalletPlan createWithProvider(KeyValueProvider provider) {
		WalletPlan plan = new WalletPlan();
		plan.setWalletPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
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
	public String WalletType;

	public String ProgramType;
	public String WalletPlan;

	public String getWalletPlan() {
		return WalletPlan;
	}

	public void setWalletPlan(String walletPlan) {
		WalletPlan = walletPlan;
	}

	public String getWalletType() {
		return WalletType;
	}

	public String OpenloopWalletPlan;

	public String ClosedloopWalletPlan;

	public String getClosedloopWalletPlan() {
		return ClosedloopWalletPlan;
	}

	public void setClosedloopWalletPlan(String closedloopWalletPlan) {
		ClosedloopWalletPlan = closedloopWalletPlan;
	}

	public String getUsageType() {
		return usageType;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public String usageType;

	public String getOpenloopWalletPlan() {
		return OpenloopWalletPlan;
	}

	public void setOpenloopWalletPlan(String openloopWalletPlan) {
		OpenloopWalletPlan = openloopWalletPlan;
	}

	public String getWalletType() {
		return WalletType;
	}

	public void setWalletType(String walletType) {
		WalletType = walletType;
	}

	public String getProgramType() {
		return ProgramType;
	}

	public void setProgramType(String programType) {
		ProgramType = programType;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}
	public void setWalletType(String walletType) {
		WalletType = walletType;
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
		WalletPlanUsage = walletPlanUsage;
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
