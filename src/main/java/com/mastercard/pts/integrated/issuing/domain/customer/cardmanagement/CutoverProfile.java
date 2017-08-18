package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class CutoverProfile {

	private LocalDate businessDate;
	private String cutoverHours;
	private String cutoverMins;
	public LocalDate getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(LocalDate businessDate) {
		this.businessDate = businessDate;
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
	
	public static CutoverProfile createWithProvider(DataProvider provider)
	{
		CutoverProfile cp=provider.getDataBySimpleClassName(CutoverProfile.class);
		cp.setBusinessDate(LocalDate.now());
		return cp;
	}
	
}
