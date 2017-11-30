package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class SurchargeWailverPlan {
  
	private String surchargeWaiverPlanCodeValid;
	private String surchargeWaiverDescriptionValid;
	private String surchargeWaiverPlanCodeInvalid;
	private String surchargeWaiverDescriptionInvalid;
	private String effectiveDate;
	private String endDate;
	
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

	public void surchargeWaiverFeePlanDataProvider() {
		setSurchargeWaiverPlanCodeValid(CustomUtils.randomAlphaNumeric(5).toUpperCase());
		setSurchargeWaiverDescriptionValid(CustomUtils.randomAlphaNumeric(5));
		setSurchargeWaiverPlanCodeInvalid(CustomUtils.randomAlphaNumeric(5).toLowerCase());
		setSurchargeWaiverDescriptionInvalid(CustomUtils.randomAlphaNumeric(5)+"$");
		setEffectiveDate(MapUtils.fnGetInputDataFromMap("effectiveDate"));
		setEndDate(MapUtils.fnGetInputDataFromMap("endDate"));
		

	}
}
