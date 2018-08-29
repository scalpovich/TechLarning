package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class CountryWhiteListAndBlackListPlan {

	private static final String PLAN_TYPE = "PLAN_TYPE";
	private static final String COUNTRY_CODE = "COUNTRY_CODE";
	// private static final String EFFECTIVE_DATE = "EFFECTIVE_DATE";
	// private static final String END_DATE = "END_DATE";

	private String planCode;
	private String description;
	private String planType;
	private String countryCode;
	private String effectiveDate;
	private String endDate;

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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

	public static CountryWhiteListAndBlackListPlan createWithProvider(KeyValueProvider provider) {
		CountryWhiteListAndBlackListPlan plan = new CountryWhiteListAndBlackListPlan();
		plan.setCountryCode(provider.getString(COUNTRY_CODE));
		plan.setPlanType(provider.getString(PLAN_TYPE));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setEffectiveDate(DateUtils.getNextDateInDDMMYYYY());
		String endDate = DateUtils.getNextDateInDDMMYYYY().replaceAll(
				DateUtils.getNextDateInDDMMYYYY().substring(8, 10),
				Integer.parseInt(DateUtils.getNextDateInDDMMYYYY().substring(8, 10)) + 7 + "");
		plan.setEndDate(endDate);
		return plan;
	}
}
