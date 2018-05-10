package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class AddInstitutionLoadCurrency {

	private String currency;
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public static AddInstitutionLoadCurrency dataProvider() {
		AddInstitutionLoadCurrency institutionLoadCurrency= new AddInstitutionLoadCurrency();
		institutionLoadCurrency.setCurrency(MapUtils.fnGetInputDataFromMap("InstitutionLoadCurrency"));
		return  institutionLoadCurrency;
	}
}


