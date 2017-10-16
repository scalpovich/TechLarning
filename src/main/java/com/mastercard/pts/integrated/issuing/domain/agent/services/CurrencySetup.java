package com.mastercard.pts.integrated.issuing.domain.agent.services;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class CurrencySetup {
	private static final String CURRENCY_WITH_PRIORITY = "CURRENCY_WITH_PRIORITY";

	private String currencyWithPriority;
	private String remarks;
	
	public static CurrencySetup createWithProvider(KeyValueProvider provider){
		CurrencySetup details = new CurrencySetup();
		details.setRemarks(ConstantData.GENERIC_DESCRIPTION);
		details.setCurrencyWithPriority(provider.getString(CURRENCY_WITH_PRIORITY));
		return details;
	}

	public String getCurrencyWithPriority() {
		return currencyWithPriority;
	}

	public void setCurrencyWithPriority(String currencyWithPriority) {
		this.currencyWithPriority = currencyWithPriority;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "CurrencySetup [currencyWithPriority=" + currencyWithPriority
				+ ", remarks=" + remarks + "]";
	}
}
