package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.math.BigDecimal;

public class AvailableBalance {
	
	BigDecimal availableBal;
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
	BigDecimal sum;
}
