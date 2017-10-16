package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class Walletplan {

	public String Currency;

	public String WalletPlanUsage;

	public String WalletType;

	public String ProgramType;

	public String WalletPlan;

	public String getWalletPlan() {
		return WalletPlan;
	}

	public void setWalletPlan(String walletPlan) {
		WalletPlan = walletPlan;
	}

	public String getWalletType() {
		return WalletType;
	}

	public void setWalletType(String walletType) {
		WalletType = walletType;
	}

	public String getProgramType() {
		return ProgramType;
	}

	public void setProgramType(String programType) {
		ProgramType = programType;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getWalletPlanUsage() {
		return WalletPlanUsage;
	}

	public void setWalletPlanUsage(String walletPlanUsage) {
		WalletPlanUsage = walletPlanUsage;
	}

	public static Walletplan walletplanDataprovider() {
		Walletplan walletplan = new Walletplan();
		walletplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		walletplan.setWalletPlanUsage(MapUtils.fnGetInputDataFromMap("WalletplanUsage"));
		return walletplan;
	}

}
