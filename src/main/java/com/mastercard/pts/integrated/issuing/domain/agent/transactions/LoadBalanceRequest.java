package com.mastercard.pts.integrated.issuing.domain.agent.transactions;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class LoadBalanceRequest {
	private String transactionDetails;
	private String paymentMode;
	private String documentsVerified;
	private String loadRequestReferenceNumber;
	
	public static LoadBalanceRequest getProviderData(KeyValueProvider provider)
	{
		LoadBalanceRequest lbr=new LoadBalanceRequest();
		lbr.setTransactionDetails(provider.getString("TRANSACTION_DETAILS"));
		lbr.setPaymentMode(provider.getString("PAYMENT_MODE"));
		lbr.setDocumentsVerified(provider.getString("DOCUMENTS_VERIFIED"));
		return lbr;
	}
	
	public String getLoadRequestReferenceNumber() {
		return loadRequestReferenceNumber;
	}

	public void setLoadRequestReferenceNumber(String loadRequestReferenceNumber) {
		this.loadRequestReferenceNumber = loadRequestReferenceNumber;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getDocumentsVerified() {
		return documentsVerified;
	}

	public void setDocumentsVerified(String documentsVerified) {
		this.documentsVerified = documentsVerified;
	}
}
