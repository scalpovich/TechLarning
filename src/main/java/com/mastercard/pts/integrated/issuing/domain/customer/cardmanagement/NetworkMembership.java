package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.List;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class NetworkMembership{

	private String interchange;
	private String cutoverHours;
	private String cutoverMins;
	private String settlementCurrency;
	private String presentmentTimeLimitDays;

	public String SettlementCurrency;
		
	public String getInterchange() {
		return interchange;
	public String PresentmentTimeLimit;

	public String getPresentmentTimeLimit() {
		return PresentmentTimeLimit;
	}
	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}
	public String getCutoverHours() {
		return cutoverHours;
	}
	public void setCutoverHours(String cutoverHours) {
		this.cutoverHours = cutoverHours;
	}
	public String getCutoverMins() {
		return cutoverMins;


	public void setPresentmentTimeLimit(String presentmentTimeLimit) {
		PresentmentTimeLimit = presentmentTimeLimit;
	}

	public String getSettlementCurrency() {
		return SettlementCurrency;
	}

	public void setSettlementCurrency(String settlementCurrency) {
		SettlementCurrency = settlementCurrency;
	}



 	public void setCutoverMins(String cutoverMins) {
		this.cutoverMins = cutoverMins;
	}
	public String getsettlementCurrency() {
		return settlementCurrency;
	}
	public void setsettlementCurrency(String settlementCurrency) {
		this.settlementCurrency = settlementCurrency;
	}
	public String getPresentmentTimeLimitDays() {
		return presentmentTimeLimitDays;
	}
	public void setPresentmentTimeLimitDays(String presentmentTimeLimitDays) {
		this.presentmentTimeLimitDays = presentmentTimeLimitDays;
	}
	
	public static List<NetworkMembership> createWithProvider(DataProvider provider)
	{
		return provider.getData(new TypeReference<List<NetworkMembership>>() {}, "NetworkMembership");
	}
	public NetworkMembership NetworkMembershipDataProvider() {
		NetworkMembership networkmembership = new NetworkMembership();
		networkmembership.setPresentmentTimeLimit(MapUtils.fnGetInputDataFromMap("PresentTimeLimit"));
		networkmembership.setSettlementCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		return networkmembership;
	}

}
