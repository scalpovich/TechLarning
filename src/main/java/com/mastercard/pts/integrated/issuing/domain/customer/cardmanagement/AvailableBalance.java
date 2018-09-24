package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.math.BigDecimal;

public class AvailableBalance {
	
	BigDecimal availableBal;
	BigDecimal billingAmount;
	public BigDecimal getAvailableBal() {
		return availableBal;
	}
	public void setAvailableBal(BigDecimal availableBal) {
		this.availableBal = availableBal;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	public BigDecimal getBillingAmount(){
		return billingAmount;
	}
	public void setBillingAmount (BigDecimal billingAmount){
		this.billingAmount = billingAmount;
	}
	BigDecimal sum;
}
