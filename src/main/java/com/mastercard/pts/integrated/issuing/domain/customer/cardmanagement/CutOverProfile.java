package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class CutOverProfile {

	private LocalDate businessDate;
	private String cutoverHours;
	private String cutoverMins;
	public String cutOverEffectiveDate;
	public LocalDate getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(LocalDate businessDate) {
		this.businessDate = businessDate;
	}

	public String getCutOverEffectiveDate() {
		return cutOverEffectiveDate;
	}

	public void setCutOverEffectiveDate(String cutOverEffectiveDate) {
		this.cutOverEffectiveDate = cutOverEffectiveDate;
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
		cp.setBusinessDate(LocalDate.now().plusDays(1));
		return cp;
	}
	public static CutOverProfile cutoverDatProvider() {
		CutOverProfile cutover = new CutOverProfile();
		cutover.setCutOverEffectiveDate(MapUtils.fnGetInputDataFromMap("CutOverEffectiveDate"));
		return cutover;
	}

	
}
