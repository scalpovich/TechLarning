package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class Payment {
	
	public static final String REMITTANCE_NUMBER = "REMITTANCE_NUMBER";
	public static final String BASE_CURRENCY = "BASE_CURRENCY";
	public static final String DESCRIPTION_NOTE = "DESCRIPTION_NOTE";
	public static final String AUTH_NUMBER = "AUTH_NUMBER";
	public static final String CASH_AMOUNT = "CASH_AMOUNT";
	public static final String BRANCH="BRANCH";
	
	private String remittanceNumber;
	private LocalDate remittanceDate;	
	private LocalDate valueDate;
	private String baseCurrency;
	private String amount;
	private LocalDate transactionDate;
	private String description;
	private String authNumber;
	private String paymentBranchCode;
	private String deviceNumber;
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getPaymentBranchCode() {
		return paymentBranchCode;
	}
	public void setPaymentBranchCode(String paymentBranchCode) {
		this.paymentBranchCode = paymentBranchCode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRemittanceNumber() {
		return remittanceNumber;
	}
	public void setRemittanceNumber(String remittanceNumber) {
		this.remittanceNumber = remittanceNumber;
	}
	public LocalDate getRemittanceDate() {
		return remittanceDate;
	}
	public void setRemittanceDate(LocalDate remittanceDate) {
		this.remittanceDate = remittanceDate;
	}
	public LocalDate getValueDate() {
		return valueDate;
	}
	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public LocalDate i() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthNumber() {
		return authNumber;
	}
	public void setAuthNumber(String authNumber) {
		this.authNumber = authNumber;
	}
	
	public static Payment cashPaymentDataProvider(KeyValueProvider provider) {
		Payment cash = new Payment();
		cash.setRemittanceNumber(CustomUtils.RandomNumbers(99999999));
		cash.setRemittanceDate(LocalDate.now());
		cash.setValueDate(LocalDate.now());
		cash.setBaseCurrency(provider.getString(BASE_CURRENCY));
		cash.setAmount(provider.getString(CASH_AMOUNT));
		cash.setTransactionDate(LocalDate.now());
		cash.setDescription(provider.getString(DESCRIPTION_NOTE));
		cash.setAuthNumber(CustomUtils.RandomNumbers(99999999));
		cash.setPaymentBranchCode(provider.getString(BRANCH));
		return cash;		
	}
	
}
