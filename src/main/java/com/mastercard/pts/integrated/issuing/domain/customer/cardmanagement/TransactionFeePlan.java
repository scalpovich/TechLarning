package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

@Component
public class TransactionFeePlan {

	private static final String TRANSACTION_TYPE = "TRANSACITON_TYPE";

	private static final String WALLET_CURRENCY = "CURRENCY";

	private static final String TRANSACTION_SOURCE = "TRANSACITON_SOURCE";

	private static final String TRANSACTION_ORIGIN = "TRANSACITON_ORIGIN";

	private static final String TRANSACTION_FEE_PLAN = "TRANSACTION_FEE_PLAN";
	private static final String MARKUP_FEE_RATE="MARKUP_FEE_RATE";
	private static final String TRANSACTION_RATE = "TRANSACTION_RATE";

	private static final String MARKUP_FEE = "MARKUP_FEE";
	private static final String MARKUP_FEE_TAX = "MARKUP_FEE_TAX";
	private static final String SOURCE_CURRENCY = "SOURCE_CURRENCY";
	private static final String BILLING_CURRENCY = "BILLING_CURRENCY";
	private static final String BILLING_AMOUNT = "BILLING_AMOUNT";
	private static final String BILLING_AMOUNT_RATE = "BILLING_AMOUNT_RATE";
	private static final String MIN_TXN_RATE = "MIN_TXN_RATE";

	private static final String RATE_TXN_FEE = "RATE_TXN_FEE";
	private static final String MAX_TXN_RATE = "MAX_TXN_RATE";
	private static final String FIXED_RATE_FEE = "FIXED_RATE_FEE";
	private static final String FIXED_TXN_FEE = "FIXED_TXN_FEE";
	private String transactionFeePlanCode;

	private String description;

	private String transactionType;

	private String walletCurrency;

	private String transactionSource;

	private String transactionOrigin;

	private LocalDate effectiveDate;

	private LocalDate endDate;

	private String fromAmount;

	private String toAmount;

	private String fix;

	private String rate;

	private String minimumFeeAmount;

	private String maximumFeeAmount;

	private String rateTxnfee;

	private String fixedTxnFees;

	private String fixedRateFee;

	private String billingAmount;

	private String maxTxnRate;

	private String rateTxnFee;

	private String billingAmountRate;

	private String minTxnRate;

	private String markupfee;

	private String markupfeetax;
	
	private String markuprate;
	
	private String sourcecurrency;
	
	private String billingcurrency;

	public static TransactionFeePlan createWithProvider(KeyValueProvider provider) {
		TransactionFeePlan details = new TransactionFeePlan();
		details.setTransactionFeePlanCode(provider.getString(TRANSACTION_FEE_PLAN));
		details.setDescription(ConstantData.GENERIC_DESCRIPTION);
		details.setTransactionType(provider.getString(TRANSACTION_TYPE));
		details.setWalletCurrency(provider.getString(WALLET_CURRENCY));
		details.setTransactionSource(provider.getString(TRANSACTION_SOURCE));
		details.setTransactionOrigin(provider.getString(TRANSACTION_ORIGIN));
		details.setEffectiveDate(LocalDate.now().plusDays(1));
		details.setEndDate(details.getEffectiveDate().plusDays(5));
		details.setFromAmount("10");
		details.setToAmount("100000");
		details.setFix("10");
		details.setRate("2.5");
		details.setMinimumFeeAmount("15");
		details.setMaximumFeeAmount("20");
		return details;
	}

	public static TransactionFeePlan getAllTransactionFee(KeyValueProvider provider) {

		TransactionFeePlan txnFee = new TransactionFeePlan();
		txnFee.setRateTxnFee(provider.getString(TRANSACTION_RATE));
		txnFee.setBillingAmount(provider.getString(BILLING_AMOUNT));
		txnFee.setBillingAmountRate(provider.getString(BILLING_AMOUNT_RATE));
		txnFee.setMinTxnRate(provider.getString(MIN_TXN_RATE));
		txnFee.setRateTxnFee(provider.getString(RATE_TXN_FEE));
		txnFee.setMaxTxnRate(provider.getString(MAX_TXN_RATE));
		txnFee.setFixedRateFee(provider.getString(FIXED_RATE_FEE));
		txnFee.setFixedTxnFees(provider.getString(FIXED_TXN_FEE));

		return txnFee;
	}

	public static TransactionFeePlan getMarkUpFees(KeyValueProvider provider) {

		TransactionFeePlan markupfee = new TransactionFeePlan();
		markupfee.setMarkupFee(provider.getString(MARKUP_FEE));
		markupfee.setMarkupFeeTax(provider.getString(MARKUP_FEE_TAX));
		markupfee.setMarkUpRate(provider.getString(MARKUP_FEE_RATE));
		markupfee.setSourceCurrency(provider.getString(SOURCE_CURRENCY));
		markupfee.setBillingCurrency(provider.getString(BILLING_CURRENCY));
		return markupfee;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getWalletCurrency() {
		return walletCurrency;
	}

	public void setWalletCurrency(String walletCurrency) {
		this.walletCurrency = walletCurrency;
	}

	public String getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getTransactionOrigin() {
		return transactionOrigin;
	}

	public void setTransactionOrigin(String transactionOrigin) {
		this.transactionOrigin = transactionOrigin;
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

	public String getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(String fromAmount) {
		this.fromAmount = fromAmount;
	}

	public String getToAmount() {
		return toAmount;
	}

	public void setToAmount(String toAmount) {
		this.toAmount = toAmount;
	}

	public String getFix() {
		return fix;
	}

	public void setFix(String fix) {
		this.fix = fix;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getMinimumFeeAmount() {
		return minimumFeeAmount;
	}

	public void setMinimumFeeAmount(String minimumFeeAmount) {
		this.minimumFeeAmount = minimumFeeAmount;
	}

	public String getMaximumFeeAmount() {
		return maximumFeeAmount;
	}

	public void setMaximumFeeAmount(String maximumFeeAmount) {
		this.maximumFeeAmount = maximumFeeAmount;
	}

	public String getTransactionFeePlanCode() {
		return transactionFeePlanCode;
	}

	public void setTransactionFeePlanCode(String transactionFeePlanCode) {
		this.transactionFeePlanCode = transactionFeePlanCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRateTxnFee() {
		return rateTxnfee;
	}

	public void setRateTxnFee(String rateTxnfee) {
		this.rateTxnfee = rateTxnfee;

	}

	public String getfixedTxnFees() {

		return fixedTxnFees;
	}

	public void setFixedTxnFees(String fixedTxnFees) {
		this.fixedTxnFees = fixedTxnFees;
	}

	public String getFixedRateFee() {
		return fixedRateFee;
	}

	public void setFixedRateFee(String fixedRateFee) {
		this.fixedRateFee = fixedRateFee;
	}

	public String getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(String billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getMaxTxnRate() {
		return maxTxnRate;
	}

	public void setMaxTxnRate(String maxTxnRate) {
		this.maxTxnRate = maxTxnRate;
	}

	public String getBillingAmountRate() {
		return billingAmountRate;
	}

	public void setBillingAmountRate(String billingAmountRate) {
		this.billingAmountRate = billingAmountRate;
	}

	public String getMinTxnRate() {
		return minTxnRate;
	}

	public void setMinTxnRate(String minTxnRate) {
		this.minTxnRate = minTxnRate;
	}

	public String getMarkupFee() {
		return markupfee;
	}

	public void setMarkupFee(String markupfee) {
		this.markupfee = markupfee;
	}

	public String getMarkupFeeTax() {
		return markupfeetax;
	}

	public void setMarkupFeeTax(String markupfeetax) {
		this.markupfeetax = markupfeetax;
	}
	
   public String getMarkUpRate(){
	   return markuprate;
   }
   
   public void setMarkUpRate(String markuprate)
   {
	   this.markuprate=markuprate;
   }
   
   public String getSourceCurrency(){
	   return sourcecurrency;
   }
   
   public void setSourceCurrency(String sourcecurrency)
   {
	   this.sourcecurrency=sourcecurrency;
   }
   
   public String getBillingCurrency(){
	   return billingcurrency;
   }
   
   public void setBillingCurrency(String billingcurrency)
   {
	   this.billingcurrency=billingcurrency;
   }

}
