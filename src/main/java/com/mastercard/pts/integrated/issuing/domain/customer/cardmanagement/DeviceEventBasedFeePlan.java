package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class DeviceEventBasedFeePlan {

	public String Currency;

	public String EffectiveDate;

	public String EndDate;

	public String getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		EffectiveDate = effectiveDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public static DeviceEventBasedFeePlan deviceeventbasedfeeplanDataProvider() {
		DeviceEventBasedFeePlan deviceeventbasedfeeplan = new DeviceEventBasedFeePlan();
		deviceeventbasedfeeplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		deviceeventbasedfeeplan.setEndDate(MapUtils.fnGetInputDataFromMap("EndDate"));
		deviceeventbasedfeeplan.setEffectiveDate(DateUtils.getDateinDDMMYYYY());
		return deviceeventbasedfeeplan;
	}

}
