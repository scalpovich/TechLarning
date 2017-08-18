package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class InstitutionCurrency {

	private String currency;
	private String status;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static InstitutionCurrency createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(InstitutionCurrency.class);
	}
}
