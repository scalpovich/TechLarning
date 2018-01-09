package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class CreditLimitRule {

	private String creditLimit;
	private String maxCreditLimit;
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
	public String getMaxCreditLimit() {
		return maxCreditLimit;
	}
	public void setMaxCreditLimit(String maxCreditLimit) {
		this.maxCreditLimit = maxCreditLimit;
	}
	
	
}
