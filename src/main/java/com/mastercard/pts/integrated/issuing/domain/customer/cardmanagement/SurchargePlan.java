package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class SurchargePlan {

	private static final String SP_DESCRIPTION = "Description";
	private static final String SP_CURRENCY = "Currency";
	private static final String SP_SURCHARGE_SOURCE = "Surcharge Source";
	private static final String SPD_INTERCHANGE = "Interchange";
	private static final String SPD_MCG = "MCG";
	private static final String EFFECTIVE_DATE = "Effective Date";
	private static final String END_DATE = "End Date";
	private static final String SPD_FEE_TRANSAC_DESC = "Fee Transaction Description";
	private static final String SPD_SURCHARGE_RATE = "Surcharge Rate(%)";
	private static final String SPD_FIXED_SURCHARGE_AMT = "Fixed Surcharge Amount";
	private static final String SPD_MIN_SURCHARGE_AMT = "Minimum Surcharge Amount";
	private static final String SPD_MAX_SURCHARGE_AMT = "Maximum Surcharge Amount";

	private String surchargePlanCode;
	private String description;
	private String currency;
	private String surchargeSource;
	private String interchange;
	private String mcg;
	private String effectiveDate;
	private String endDate;
	private String feeTransactionDesc;
	private String surchargeRate;
	private String fixedSurchargeAmt;
	private String minSurchargeAmt;
	private String maxSurchargeAmt;

	public static SurchargePlan getSurchargePlanData(KeyValueProvider provider) {
		SurchargePlan plan = new SurchargePlan();
		plan.setSurchargePlanCode(CustomUtils.randomAlphaNumeric(5).toUpperCase());
		plan.setDescription(provider.getString(SP_DESCRIPTION));
		plan.setCurrency(provider.getString(SP_CURRENCY));
		plan.setSurchargeSource(provider.getString(SP_SURCHARGE_SOURCE));
		plan.setInterchange(provider.getString(SPD_INTERCHANGE));
		plan.setMcg(provider.getString(SPD_MCG));
		plan.setEffectiveDate(provider.getString(EFFECTIVE_DATE));
		plan.setEndDate(provider.getString(END_DATE));
		plan.setFeeTransactionDesc(provider.getString(SPD_FEE_TRANSAC_DESC));
		plan.setSurchargeRate(provider.getString(SPD_SURCHARGE_RATE));
		plan.setFixedSurchargeAmt(provider.getString(SPD_FIXED_SURCHARGE_AMT));
		plan.setMinSurchargeAmt(provider.getString(SPD_MIN_SURCHARGE_AMT));
		plan.setMaxSurchargeAmt(provider.getString(SPD_MAX_SURCHARGE_AMT));
		
		return plan;
	}

	public String getSurchargePlanCode() {
		return surchargePlanCode;
	}

	public void setSurchargePlanCode(String surchargePlanCode) {
		this.surchargePlanCode = surchargePlanCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSurchargeSource() {
		return surchargeSource;
	}

	public void setSurchargeSource(String surchargeSource) {
		this.surchargeSource = surchargeSource;
	}

	public String getInterchange() {
		return interchange;
	}

	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}

	public String getMcg() {
		return mcg;
	}

	public void setMcg(String mcg) {
		this.mcg = mcg;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFeeTransactionDesc() {
		return feeTransactionDesc;
	}

	public void setFeeTransactionDesc(String feeTransactionDesc) {
		this.feeTransactionDesc = feeTransactionDesc;
	}

	public String getSurchargeRate() {
		return surchargeRate;
	}

	public void setSurchargeRate(String surchargeRate) {
		this.surchargeRate = surchargeRate;
	}

	public String getFixedSurchargeAmt() {
		return fixedSurchargeAmt;
	}

	public void setFixedSurchargeAmt(String fixedSurchargeAmt) {
		this.fixedSurchargeAmt = fixedSurchargeAmt;
	}

	public String getMinSurchargeAmt() {
		return minSurchargeAmt;
	}

	public void setMinSurchargeAmt(String minSurchargeAmt) {
		this.minSurchargeAmt = minSurchargeAmt;
	}

	public String getMaxSurchargeAmt() {
		return maxSurchargeAmt;
	}

	public void setMaxSurchargeAmt(String maxSurchargeAmt) {
		this.maxSurchargeAmt = maxSurchargeAmt;
	}

}
