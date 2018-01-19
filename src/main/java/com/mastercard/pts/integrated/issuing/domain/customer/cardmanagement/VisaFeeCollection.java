package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.RetrievalRequest;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class VisaFeeCollection {


	private static final String COUNTRY = "VISA_FEE_COUNTRY";
	private static final String SOURCE_CURRENCY = "VISA_FEE_SOURCE_CURRENCY";
	private static final String REASON_CODE = "VISA_FEE_REASON_CODE";
	private static final String SOURCE_AMOUNT = "VISA_FEE_SOURCE_AMOUNT";
	
	private String country;
	private String sourceCurrency;
	private String reasonCode;
	private String transactionCode;
	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	private String sourceAmount;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public String getSourceAmount() {
		return sourceAmount;
	}

	public void setSourceAmount(String sourceAmount) {
		this.sourceAmount = sourceAmount;
	}

	public static VisaFeeCollection createWithProvider(KeyValueProvider provider) {
		VisaFeeCollection feecollection = new VisaFeeCollection();
		feecollection.setCountry(provider.getString(COUNTRY));
		feecollection.setSourceCurrency(provider.getString(SOURCE_CURRENCY));
		feecollection.setReasonCode(provider.getString(REASON_CODE));
		feecollection.setSourceAmount(provider.getString(SOURCE_AMOUNT));
		return feecollection;
	}

}
