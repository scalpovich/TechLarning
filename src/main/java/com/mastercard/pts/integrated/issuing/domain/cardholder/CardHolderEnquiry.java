/**
 * @author e076168
 */
package com.mastercard.pts.integrated.issuing.domain.cardholder;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class CardHolderEnquiry {
	
	private String transactionType;
	
	private String transactionCurrency;
	
	private String transactionAmount;
	
	private String transferConversionCharge;
	
	private String noOfTransactionCount;
	
	private String fromDate;
	
	private String toDate;
	
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getNoOfTransactionCount() {
		return noOfTransactionCount;
	}

	public void setNoOfTransactionCount(String noOfTransactionCount) {
		this.noOfTransactionCount = noOfTransactionCount;
	}

	public String getConversionCharge() {
		return transferConversionCharge;
	}

	public void setConversionCharge(String conversionCharge) {
		this.transferConversionCharge = conversionCharge;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public static CardHolderEnquiry cardHolderEnquiryDataProvider(){
		CardHolderEnquiry enquiry = new CardHolderEnquiry();
		enquiry.setTransactionType(MapUtils.fnGetInputDataFromMap("TranSactionType"));
		enquiry.setTransactionCurrency(MapUtils.fnGetInputDataFromMap("TransactionCurrency"));
		enquiry.setTransactionAmount(MapUtils.fnGetInputDataFromMap("TransactionAmount"));		
		enquiry.setConversionCharge(MapUtils.fnGetInputDataFromMap("ConversionRate"));
		enquiry.setNoOfTransactionCount(MapUtils.fnGetInputDataFromMap("NoOfTransactionsCount"));
		enquiry.setFromDate(MapUtils.fnGetInputDataFromMap("FromDate"));
		enquiry.setToDate(MapUtils.fnGetInputDataFromMap("ToDate"));
		return enquiry;
	}
}
