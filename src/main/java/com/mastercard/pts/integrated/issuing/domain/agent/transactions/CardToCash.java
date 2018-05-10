package com.mastercard.pts.integrated.issuing.domain.agent.transactions;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class CardToCash {
	private static final String TXN_PASSWORD = "TXN_PASSWORD";
	private static final String TRANSACTION_DETAILS = "TRANSACTION_DETAILS";
	private static final String MOBILE_NUMBER = "MOBILE_NUMBER";
	private static final String CURRENT_ADDRESS_LINE_1 = "CURRENT_ADDRESS_LINE_1";
	private static final String POSTAL_CODE = "POSTAL_CODE";
	private static final String CITY = "CITY";
	private static final String REMITTANCE_AMOUNT="REMITTANCE_AMOUNT";
	private int beneficiaryId;
	private String beneficiaryFirstName;
	private String beneficiaryLastName;
	private String beneficiaryAddress1;
	private String city;
	private String zipCode;
	private String mobileNumber;
	private String remittanceAmount;
	private String remittanceCurrency;
	private String remittanceNumber;
	private String txnPassword;
	private String transactionDetails;
	private String remittanceTransactionDetails;
	
	public static CardToCash getProviderData(KeyValueProvider provider) {
		CardToCash ctc = new CardToCash();
		ctc.setTxnPassword(provider.getString(TXN_PASSWORD));
		ctc.setTransactionDetails(provider.getString(TRANSACTION_DETAILS));
		ctc.setRemittanceAmount(provider.getString(REMITTANCE_AMOUNT));
		ctc.setMobileNumber(provider.getString(MOBILE_NUMBER));
		ctc.setBeneficiaryAddress1(provider.getString(CURRENT_ADDRESS_LINE_1));
		ctc.setZipCode(provider.getString(POSTAL_CODE));
		ctc.setCity(provider.getString(CITY));
		return ctc;
	}
	
	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	
	public String getTxnPassword() {
		return txnPassword;
	}

	public void setTxnPassword(String txnPassword) {
		this.txnPassword = txnPassword;
	}

	public String getRemittanceNumber() {
		return remittanceNumber;
	}

	public void setRemittanceNumber(String remittanceNumber) {
		this.remittanceNumber = remittanceNumber;
	}

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryFirstName() {
		return beneficiaryFirstName;
	}

	public void setBeneficiaryFirstName(String beneficiaryFirstName) {
		this.beneficiaryFirstName = beneficiaryFirstName;
	}

	public String getBeneficiaryLastName() {
		return beneficiaryLastName;
	}

	public void setBeneficiaryLastName(String beneficiaryLastName) {
		this.beneficiaryLastName = beneficiaryLastName;
	}

	public String getBeneficiaryAddress1() {
		return beneficiaryAddress1;
	}

	public void setBeneficiaryAddress1(String beneficiaryAddress1) {
		this.beneficiaryAddress1 = beneficiaryAddress1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRemittanceAmount() {
		return remittanceAmount;
	}

	public void setRemittanceAmount(String remittanceAmount) {
		this.remittanceAmount = remittanceAmount;
	}

	public String getRemittanceCurrency() {
		return remittanceCurrency;
	}

	public void setRemittanceCurrency(String remittanceCurrency) {
		this.remittanceCurrency = remittanceCurrency;
	}
	
	
}
