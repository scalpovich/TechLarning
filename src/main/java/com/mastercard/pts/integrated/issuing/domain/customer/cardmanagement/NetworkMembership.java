package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class NetworkMembership{

	private String interchange;
	private String cutoverHours;
	private String cutoverMins;
	private String settlementCurrency;
	private String presentmentTimeLimitDays;
		
	public String getInterchange() {
		return interchange;
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
}
