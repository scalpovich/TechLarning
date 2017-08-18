package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CreditCardTransactionRulePlan implements HasCodeAndDescription {

	private String transactionRulePlanCode;
	private String description;

	public static CreditCardTransactionRulePlan generateDynamicTestData()
	{
		CreditCardTransactionRulePlan testdata = new CreditCardTransactionRulePlan();
		testdata.setTransactionRulePlanCode(MiscUtils.generateRandomNumberBetween2Number(100, 999));
		testdata.setDescription(MiscUtils.generate10CharAlphaNumeric());
		return testdata;
	}
	
	@Override
	public String getCode() {
		return getTransactionRulePlanCode();
	}
	
	public String getTransactionRulePlanCode() {
		return transactionRulePlanCode;
	}

	public void setTransactionRulePlanCode(String transactionRulePlanCode) {
		this.transactionRulePlanCode = transactionRulePlanCode;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CreditCardTransactionRulePlancode [transactionRulePlanCode;=" + transactionRulePlanCode + ", description="
				+ description + "]";
	}
}
