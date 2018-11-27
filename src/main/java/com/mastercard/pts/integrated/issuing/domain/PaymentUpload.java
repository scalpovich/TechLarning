package com.mastercard.pts.integrated.issuing.domain;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;


public class PaymentUpload {
	
	private String paymentMethod;
	
	private String transactionCurrency;

	private String transactionCode;

	private String transactionCurrencyAmount;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getTransactionCurrencyAmount() {
		return transactionCurrencyAmount;
	}

	public void setTransactionCurrencyAmount(String transactionCurrencyAmount) {
		this.transactionCurrencyAmount = transactionCurrencyAmount;
	}

	public static PaymentUpload createWithProviderForPayment(DataProvider provider, String transactionCode) {
		return provider.getDataBySimpleClassNameForInstitute(PaymentUpload.class, transactionCode);
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}

}
