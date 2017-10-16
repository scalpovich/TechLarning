package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class WalletFeePlan {

	public String Currency;

	public String FeeAmount;

	public String WaiverPeriod;

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

	public String getFeeAmount() {
		return FeeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		FeeAmount = feeAmount;
	}

	public String getWaiverPeriod() {
		return WaiverPeriod;
	}

	public void setWaiverPeriod(String waiverPeriod) {
		WaiverPeriod = waiverPeriod;
	}

	public String WalletFeePlanType;

	public String getWalletFeePlanType() {
		return WalletFeePlanType;
	}

	public void setWalletFeePlanType(String walletFeePlanType) {
		WalletFeePlanType = walletFeePlanType;
	}

	public static WalletFeePlan walletfeeplanDataProvider() {
		WalletFeePlan walletfeeplan = new WalletFeePlan();
		walletfeeplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		walletfeeplan.setFeeAmount(MapUtils.fnGetInputDataFromMap("Fee"));
		walletfeeplan.setWaiverPeriod(MapUtils.fnGetInputDataFromMap("WaiveCycle"));
		walletfeeplan.setEffectiveDate(DateUtils.getDateinDDMMYYYY() + 1);
		walletfeeplan.setEndDate(MapUtils.fnGetInputDataFromMap("EndDate"));
		return walletfeeplan;
	}

}
