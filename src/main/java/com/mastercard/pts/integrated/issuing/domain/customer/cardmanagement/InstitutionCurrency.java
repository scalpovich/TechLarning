package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class InstitutionCurrency {

	public String SettlementCurrency;

	public String getSettlementCurrency() {
		return SettlementCurrency;
	}

	public void setSettlementCurrency(String settlementCurrency) {
		SettlementCurrency = settlementCurrency;
	}

	public String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static InstitutionCurrency InstitutionCurrencyDataProvider() {
		InstitutionCurrency institutioncurrency = new InstitutionCurrency();
		institutioncurrency.setSettlementCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		return institutioncurrency;
	}
}
