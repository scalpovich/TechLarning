/**
 * @author e076168
 */
package com.mastercard.pts.integrated.issuing.domain.cardholder;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class CardHolderEnquiry {
	
	
	private static String TRANSACTION_TYPE = "TRANSACTION_TYPE";	
	private static String CHP_TRANSACTION_CURRENCY = "CHP_TRANSACTION_CURRENCY";	
	private static String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";	
	private static String TRANSACTION_CONVERSION_CHARGE = "TRANSACTION_CONVERSION_CHARGE";	
	private static String TRANSACTION_COUNT = "TRANSACTION_COUNT";	
	private static String ENQ_FROM_DATE = "ENQ_FROM_DATE";	
	private static String ENQ_TO_DATE = "ENQ_TO_DATE";
	private static String TRANSACTION_CHARGE_TYPE = "TRANSACTION_CHARGE_TYPE";
	
	private String transactionType;	
	private String transactionCurrency;	
	private String transactionAmount;	
	private String transferConversionCharge;	
	private String noOfTransactionCount;	
	private String fromDate;	
	private String toDate;
	private String transactionChargeType;
	
	public String getTransactionChargeType() {
		return transactionChargeType;
	}

	public void setTransactionChargeType(String transactionChargeType) {
		this.transactionChargeType = transactionChargeType;
	}

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
	
	public static CardHolderEnquiry cardHolderEnquiryDataProvider(KeyValueProvider provider){
		CardHolderEnquiry enquiry = new CardHolderEnquiry();
		enquiry.setTransactionType(provider.getString(TRANSACTION_TYPE));
		enquiry.setTransactionCurrency(provider.getString(CHP_TRANSACTION_CURRENCY));
		enquiry.setTransactionAmount(provider.getString(TRANSACTION_AMOUNT));		
		enquiry.setConversionCharge(provider.getString(TRANSACTION_CONVERSION_CHARGE));
		enquiry.setNoOfTransactionCount(provider.getString(TRANSACTION_COUNT));
		enquiry.setFromDate(provider.getString(ENQ_FROM_DATE));
		enquiry.setToDate(provider.getString(ENQ_TO_DATE));
		return enquiry;
	}
}
