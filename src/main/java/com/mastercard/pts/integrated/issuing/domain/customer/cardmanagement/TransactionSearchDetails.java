package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class TransactionSearchDetails {
	private String ARN;
	private String sequenceNumber;
	private String deviceNumber;
	private String transaction;
	private String transactionDate;
	private String processingDate;
	private String description;
	private String billingAmount;
	private String billingCurrency;
	private String DR_CR;
	private String Reversal;
	
	public String getARN() {
		return ARN;
	}
	public void setARN(String aRN) {
		ARN = aRN;
	}
	public String getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getProcessingDate() {
		return processingDate;
	}
	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBillingAmount() {
		return billingAmount;
	}
	public void setBillingAmount(String billingAmount) {
		this.billingAmount = billingAmount;
	}
	public String getBillingCurrency() {
		return billingCurrency;
	}
	public void setBillingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
	}
	public String getDR_CR() {
		return DR_CR;
	}
	public void setDR_CR(String dR_CR) {
		DR_CR = dR_CR;
	}
	public String getReversal() {
		return Reversal;
	}
	public void setReversal(String reversal) {
		Reversal = reversal;
	}
	

}
