package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class Program {

	public String Currency;

	public String Program;

	public String Interchange;

	public String DevicePlanProgram;

	public String getDevicePlanProgram() {
		return DevicePlanProgram;
	}

	public void setDevicePlanProgram(String devicePlanProgram) {
		DevicePlanProgram = devicePlanProgram;
	}

	public String getInterchange() {
		return Interchange;
	}

	public void setInterchange(String interchange) {
		Interchange = interchange;
	}

	public String getProgram() {
		return Program;
	}

	public void setProgram(String program) {
		Program = program;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String CurrencyConversionBy;

	public String getCurrencyConversionBy() {
		return CurrencyConversionBy;
	}

	public void setCurrencyConversionBy(String currencyConversionBy) {
		CurrencyConversionBy = currencyConversionBy;
	}

	public String MaxBalanceWithoutKYC;

	public String getMaxBalanceWithoutKYC() {
		return MaxBalanceWithoutKYC;
	}

	public void setMaxBalanceWithoutKYC(String maxBalanceWithoutKYC) {
		MaxBalanceWithoutKYC = maxBalanceWithoutKYC;
	}

	public String getLoadsWithoutKYC() {
		return LoadsWithoutKYC;
	}

	public void setLoadsWithoutKYC(String loadsWithoutKYC) {
		LoadsWithoutKYC = loadsWithoutKYC;
	}

	public String LoadsWithoutKYC;

	public String ProgramType;

	public String RefundInCurrency;

	public String getRefundInCurrency() {
		return RefundInCurrency;
	}

	public void setRefundInCurrency(String refundInCurrency) {
		RefundInCurrency = refundInCurrency;
	}

	public String getProgramType() {
		return ProgramType;
	}

	public void setProgramType(String programType) {
		ProgramType = programType;

	}

	public void ProgramDataProvider() {
		// Program program = new Program();
		setRefundInCurrency("Program");
		setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		setCurrencyConversionBy(MapUtils.fnGetInputDataFromMap("CurrencyConversionBy"));
		setMaxBalanceWithoutKYC(MapUtils.fnGetInputDataFromMap("MaximumBalancewithoutKYC"));
		setLoadsWithoutKYC(MapUtils.fnGetInputDataFromMap("LoadsWithoutKYC"));

	}

}
