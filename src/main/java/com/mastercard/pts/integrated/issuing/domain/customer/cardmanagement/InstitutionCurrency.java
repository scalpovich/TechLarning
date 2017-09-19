package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class InstitutionCurrency {

	private String currency;
	public String status;
	public String SettlementCurrency;

	public String getSettlementCurrency() {
		return SettlementCurrency;
	}

	public void setSettlementCurrency(String settlementCurrency) {
		SettlementCurrency = settlementCurrency;
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

	public InstitutionCurrency InstitutionCurrencyDataProvider() {
		InstitutionCurrency institutioncurrency = new InstitutionCurrency();
		institutioncurrency.setSettlementCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		return institutioncurrency;
	}
}
