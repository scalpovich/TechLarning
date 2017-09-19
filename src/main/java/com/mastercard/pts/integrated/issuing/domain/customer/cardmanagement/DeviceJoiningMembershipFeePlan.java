package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class DeviceJoiningMembershipFeePlan extends AbstractBasePage {

	public String Currency;

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getWaiverPeriod() {
		return WaiverPeriod;
	}

	public void setWaiverPeriod(String waiverPeriod) {
		WaiverPeriod = waiverPeriod;
	}

	public String WaiverPeriod;

	public String FeeType;

	public String getFeeType() {
		return FeeType;
	}

	public void setFeeType(String feeType) {
		FeeType = feeType;
	}

	public DeviceJoiningMembershipFeePlan devicejoiningmembershipfeeplanDataProvider() {
		DeviceJoiningMembershipFeePlan devicejoiningmembershipfeeplan = new DeviceJoiningMembershipFeePlan();
		devicejoiningmembershipfeeplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		devicejoiningmembershipfeeplan.setWaiverPeriod(MapUtils.fnGetInputDataFromMap("WaiveCycle"));
		return devicejoiningmembershipfeeplan;
	}

}
