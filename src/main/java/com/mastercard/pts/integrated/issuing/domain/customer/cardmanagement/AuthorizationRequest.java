package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class AuthorizationRequest {

	private static final String CURRENCY = "CURRENCY";

	private static final String MCC_CODE = "MCC";
	
	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";
	
	private String deviceNumber;
	
	private String transactionCurrency;
	
	private String mcc;

	private String transactionAmount;
	
	private String memo;

	public static AuthorizationRequest createWithProvider(KeyValueProvider provider){
		AuthorizationRequest request = new AuthorizationRequest();
		request.setTransactionCurrency(provider.getString(CURRENCY));
		request.setMcc(provider.getString(MCC_CODE));
		request.setTransactionAmount(provider.getString(TRANSACTION_AMOUNT));
		request.setMemo(ConstantData.GENERIC_DESCRIPTION);
		return request;
	}
	
	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memoString) {
		memo = memoString;
	}

}
