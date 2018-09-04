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
	
	
	public static final String MEMO_MSG = "MEMO";
	public static final String TRANSACTION_CURRENCY = "TRANSACTION_CURRENCY";
	public static final String CHEQUE_NUMBER = "CHEQUE_NUMBER";
	public static final String TRANSACTION_TYPE = "TRANSACTION_TYPE";
	public static final String CHEQUE_AMOUNT = "CHEQUE_AMOUNT";
	public static final String DRAWEE_BANK = "DRAWEE_BANK";
	public static final String DRAWEE_BRANCH = "DRAWEE_BRANCH";
	public static final String REFERENCE_NUMBER = "REFERENCE_NUMBER";	
	public static final String MICR_NUMBER = "MICR_NUMBER";
	
		
	private String remittanceNumber;
	private LocalDate remittanceDate;	
	private LocalDate valueDate;
	private String baseCurrency;
	private String deviceNumber;	
	private String amount;
	private LocalDate transactionDate;
	private String description;
	private String authNumber;
	private String paymentBranch;		
	private LocalDate clearingDate;	
	
	private String memo;
	private String transactionCurrency;		
	private String chequeNumber;
	private LocalDate chequeDate;	
	private String transactionType;	
	private String chequeAmount;	
	private String draweeBank;	
	private String draweeBranch;		
	private String referenceNumber;	
	private String micrNumber;	
	
	
	
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
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
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
	public String getPaymentBranch() {
		return paymentBranch;
	}
	public void setPaymentBranch(String paymentBranch) {
		this.paymentBranch = paymentBranch;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	public LocalDate getClearingDate() {
		return clearingDate;
	}
	public void setClearingDate(LocalDate clearingDate) {
		this.clearingDate = clearingDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTransactionCurrency() {
		return transactionCurrency;
	}
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	
	public String getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	public LocalDate getChequeDate() {
		return chequeDate;
	}
	public void setChequeDate(LocalDate chequeDate) {
		this.chequeDate = chequeDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getChequeAmount() {
		return chequeAmount;
	}
	public void setChequeAmount(String chequeAmount) {
		this.chequeAmount = chequeAmount;
	}
	public String getDraweeBank() {
		return draweeBank;
	}
	public void setDraweeBank(String draweeBank) {
		this.draweeBank = draweeBank;
	}
	public String getDraweeBranch() {
		return draweeBranch;
	}
	public void setDraweeBranch(String draweeBranch) {
		this.draweeBranch = draweeBranch;
	}	
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getMicrNumber() {
		return micrNumber;
	}
	public void setMicrNumber(String micrNumber) {
		this.micrNumber = micrNumber;
	}
	public String getPaymntBranch() {
		return paymentBranch;
	}
	public void setPaymntBranch(String paymentBranch) {
		this.paymentBranch = paymentBranch;
	}
	
	public static Payment localChequeDataProvider(KeyValueProvider provider) {
		Payment localCheque = new Payment();
		localCheque.setClearingDate(LocalDate.now());
		localCheque.setMemo(provider.getString(MEMO_MSG));
		localCheque.setTransactionCurrency(provider.getString(TRANSACTION_CURRENCY));
		localCheque.setChequeNumber(CustomUtils.RandomNumbers(Integer.valueOf(provider.getString(CHEQUE_NUMBER))));
		localCheque.setChequeDate(LocalDate.now());
		localCheque.setTransactionType(provider.getString(TRANSACTION_TYPE));
		localCheque.setChequeAmount(provider.getString(CHEQUE_AMOUNT));
		localCheque.setDraweeBank(provider.getString(DRAWEE_BANK));
		localCheque.setDraweeBranch(provider.getString(DRAWEE_BRANCH));
		localCheque.setReferenceNumber(provider.getString(REFERENCE_NUMBER));		
		localCheque.setMicrNumber(CustomUtils.RandomNumbers(Integer.valueOf(provider.getString(MICR_NUMBER))));
		return localCheque;		
	}
	

	public static Payment cashPaymentDataProvider(KeyValueProvider provider) {
		Payment cash = new Payment();
		cash.setRemittanceNumber(CustomUtils.RandomNumbers(Integer.valueOf(provider.getString(REMITTANCE_NUMBER))));
		cash.setRemittanceDate(LocalDate.now());
		cash.setValueDate(LocalDate.now());
		cash.setBaseCurrency(provider.getString(BASE_CURRENCY));
		cash.setAmount(provider.getString(CASH_AMOUNT));
		cash.setTransactionDate(LocalDate.now());
		cash.setDescription(provider.getString(DESCRIPTION_NOTE));
		cash.setAuthNumber(CustomUtils.RandomNumbers(Integer.valueOf(provider.getString(AUTH_NUMBER))));
		return cash;		
	}
	

	public static Payment outStationChequePaymentDataProvider(KeyValueProvider provider) {
		Payment outStationCheque = new Payment();
		outStationCheque.setDeviceNumber("");
		outStationCheque.setChequeNumber(CustomUtils.RandomNumbers(Integer.valueOf(provider.getString(CHEQUE_NUMBER))));
		outStationCheque.setChequeDate(LocalDate.now());
		outStationCheque.setChequeAmount(provider.getString(CHEQUE_AMOUNT));
		outStationCheque.setTransactionCurrency(provider.getString(TRANSACTION_CURRENCY));
		outStationCheque.setMemo(provider.getString(MEMO_MSG));
		return outStationCheque;		
	}
	

}

