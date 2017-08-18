package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CreditCardPaymentBounceReason {

	private String paymentBouncePlanCode;
	private String description;
	
	public static CreditCardPaymentBounceReason generateDynamicTestData()
	{
		CreditCardPaymentBounceReason testdata = new CreditCardPaymentBounceReason();
		testdata.setDescription(MiscUtils.generate10CharAlphaNumeric());
		testdata.setPaymentBouncePlanCode(MiscUtils.generateRandomNumberBetween2Number(100, 999));
		return testdata;
	}
	
	public String getPaymentBouncePlanCode() {
		return paymentBouncePlanCode;
	}
	public void setPaymentBouncePlanCode(String paymentBouncePlanCode) {
		this.paymentBouncePlanCode = paymentBouncePlanCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "CreditCardPaymentBounceReason [paymentBouncePlanCode;=" + paymentBouncePlanCode + ", description="
				+ description + "]";
	}
}