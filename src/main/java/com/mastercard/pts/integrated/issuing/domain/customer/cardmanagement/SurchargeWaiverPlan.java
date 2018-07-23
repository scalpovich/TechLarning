package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

/**
 * @author e076177
 *
 */
@Component
public class SurchargeWaiverPlan {
  
	private String surchargeWaiverPlanCodeValid;
	private String surchargeWaiverDescriptionValid;
	private String surchargeWaiverPlanCodeInvalid;
	private String surchargeWaiverDescriptionInvalid;
	private String effectiveDate;
	private String endDate;
	private String waiverTransactionDescription;
	private String surchargeRate;
	private static final String EFFECTIVE_DATE = "EFFECTIVE_DATE";
    private static final String END_DATE = "END_DATE";
	private static final String WAIVER_TRANSACTION_DESCRIPTION = "WAIVER_TRANSACTION_DESCRIPTION";
	private static final String SURCHARGE_RATE="SURCHARGE_RATE";
	public String getSurchargeRate() {
		return surchargeRate;
	}

	public void setSurchargeRate(String surchargeRate) {
		this.surchargeRate = surchargeRate;
	}

	public String getWaiverTransactionDescription() {
		return waiverTransactionDescription;
	}

	public void setWaiverTransactionDescription(String waiverTransactionDescription) {
		this.waiverTransactionDescription = waiverTransactionDescription;
	}

	public String getSurchargeWaiverPlanCodeValid() {
		return surchargeWaiverPlanCodeValid;
	}

	public void setSurchargeWaiverPlanCodeValid(String surchargeWaiverPlanCodeValid) {
		this.surchargeWaiverPlanCodeValid = surchargeWaiverPlanCodeValid;
	}

	public String getSurchargeWaiverDescriptionValid() {
		return surchargeWaiverDescriptionValid;
	}

	public void setSurchargeWaiverDescriptionValid(
			String surchargeWaiverDescriptionValid) {
		this.surchargeWaiverDescriptionValid = surchargeWaiverDescriptionValid;
	}

	public String getSurchargeWaiverPlanCodeInvalid() {
		return surchargeWaiverPlanCodeInvalid;
	}

	public void setSurchargeWaiverPlanCodeInvalid(
			String surchargeWaiverPlanCodeInvalid) {
		this.surchargeWaiverPlanCodeInvalid = surchargeWaiverPlanCodeInvalid;
	}

	public String getSurchargeWaiverDescriptionInvalid() {
		return surchargeWaiverDescriptionInvalid;
	}

	public void setSurchargeWaiverDescriptionInvalid(
			String surchargeWaiverDescriptionInvalid) {
		this.surchargeWaiverDescriptionInvalid = surchargeWaiverDescriptionInvalid;
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

	public static SurchargeWaiverPlan surchargeWaiverFeePlanDataProvider(KeyValueProvider provider) {
		SurchargeWaiverPlan surchargeWailverPlan=new SurchargeWaiverPlan();
		surchargeWailverPlan.setSurchargeWaiverPlanCodeValid(CustomUtils.randomAlphaNumeric(5).toUpperCase());
		surchargeWailverPlan.setSurchargeWaiverDescriptionValid(CustomUtils.randomAlphaNumeric(5));
		surchargeWailverPlan.setSurchargeWaiverPlanCodeInvalid(CustomUtils.randomAlphaNumeric(5).toLowerCase());
		surchargeWailverPlan.setSurchargeWaiverDescriptionInvalid(CustomUtils.randomAlphaNumeric(5)+"$");
		surchargeWailverPlan.setEffectiveDate(provider.getString(EFFECTIVE_DATE));
		surchargeWailverPlan.setEndDate(provider.getString(END_DATE));
		surchargeWailverPlan.setWaiverTransactionDescription(provider.getString(WAIVER_TRANSACTION_DESCRIPTION));
		surchargeWailverPlan.setSurchargeRate(provider.getString(SURCHARGE_RATE));
		return surchargeWailverPlan;

	}
}
