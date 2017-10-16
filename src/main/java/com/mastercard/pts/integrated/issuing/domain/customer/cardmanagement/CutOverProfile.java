package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class CutOverProfile {

	public String CutoverHours;
	public String CutoverMins;
	public String cutOverEffectiveDate;

	public String getCutOverEffectiveDate() {
		return cutOverEffectiveDate;
	}

	public void setCutOverEffectiveDate(String cutOverEffectiveDate) {
		this.cutOverEffectiveDate = cutOverEffectiveDate;
	}

	public String getCutoverHours() {
		return CutoverHours;
	}

	public void setCutoverHours(String cutoverHours) {
		CutoverHours = cutoverHours;
	}

	public String getCutoverMins() {
		return CutoverMins;
	}

	public void setCutoverMins(String cutoverMins) {
		CutoverMins = cutoverMins;
	}

	public static CutOverProfile cutoverDatProvider() {
		CutOverProfile cutover = new CutOverProfile();
		cutover.setCutOverEffectiveDate(MapUtils.fnGetInputDataFromMap("CutOverEffectiveDate"));
		return cutover;
	}
}
