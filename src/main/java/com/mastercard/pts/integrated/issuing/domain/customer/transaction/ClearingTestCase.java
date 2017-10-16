package com.mastercard.pts.integrated.issuing.domain.customer.transaction;

public class ClearingTestCase {

	private String testCaseName;
	
	private String authFilePath;
	
	private String transactionFeeAmount;
	
	private String cardNumber;
	
	private String productType;

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getAuthFilePath() {
		return authFilePath;
	}

	public void setAuthFilePath(String authFilePath) {
		this.authFilePath = authFilePath;
	}

	public String getTransactionFeeAmount() {
		return transactionFeeAmount;
	}

	public void setTransactionFeeAmount(String transactionFeeAmount) {
		this.transactionFeeAmount = transactionFeeAmount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
}
