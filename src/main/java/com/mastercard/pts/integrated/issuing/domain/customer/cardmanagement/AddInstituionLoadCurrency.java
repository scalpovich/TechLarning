package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class AddInstituionLoadCurrency {

	public String currency;
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public static AddInstituionLoadCurrency DataProvider() {
		AddInstituionLoadCurrency instituionLoadCurrency= new AddInstituionLoadCurrency();
		instituionLoadCurrency.setCurrency(MapUtils.fnGetInputDataFromMap("InstituionLoadCurrency"));
		return  instituionLoadCurrency;
	}
}


