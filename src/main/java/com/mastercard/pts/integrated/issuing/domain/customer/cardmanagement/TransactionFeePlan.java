package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class TransactionFeePlan {

	private static final String TRANSACTION_TYPE = "TRANSACITON_TYPE";

	private static final String WALLET_CURRENCY = "CURRENCY";

	private static final String TRANSACTION_SOURCE = "TRANSACITON_SOURCE";

	private static final String TRANSACTION_ORIGIN = "TRANSACITON_ORIGIN";

	private static final String TRANSACTION_FEE_PLAN = "TRANSACTION_FEE_PLAN";

	private static final String TRANSACTION_RATE = "TRANSACTION_RATE";

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

	private String ratetxnfee;

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

	public static TransactionFeePlan allTxnFee(KeyValueProvider provider) {

		TransactionFeePlan txnFee = new TransactionFeePlan();
		txnFee.setRateTxnFee(provider.getString(TRANSACTION_RATE));
		return txnFee;
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
		return ratetxnfee;
	}

	public void setRateTxnFee(String ratetxnfee) {
		this.ratetxnfee = ratetxnfee;

	}
}
