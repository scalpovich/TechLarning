package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class NetworkMembership {

	public String PresentmentTimeLimit;

	public String Interchange;

	public String getInterchange() {
		return Interchange;
	}

	public void setInterchange(String interchange) {
		Interchange = interchange;
	}

	public String getPresentmentTimeLimit() {
		return PresentmentTimeLimit;
	}

	public void setPresentmentTimeLimit(String presentmentTimeLimit) {
		PresentmentTimeLimit = presentmentTimeLimit;
	}

	public String getSettlementCurrency() {
		return SettlementCurrency;
	}

	public void setSettlementCurrency(String settlementCurrency) {
		SettlementCurrency = settlementCurrency;
	}

	public String SettlementCurrency;

	public static NetworkMembership NetworkMembershipDataProvider() {
		NetworkMembership networkmembership = new NetworkMembership();
		networkmembership.setPresentmentTimeLimit(MapUtils.fnGetInputDataFromMap("PresentTimeLimit"));
		networkmembership.setSettlementCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		return networkmembership;
	}

}
