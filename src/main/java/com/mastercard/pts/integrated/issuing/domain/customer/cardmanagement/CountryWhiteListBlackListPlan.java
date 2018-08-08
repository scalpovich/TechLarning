package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class CountryWhiteListBlackListPlan {

	private static final String PLAN_TYPE = "PLAN_TYPE";
	private static final String COUNTRY_CODE = "COUNTRY_CODE";

	private String planCode;
	private String description;
	private String planType;
	private String countryCode;

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

	public static CountryWhiteListBlackListPlan createWithProvider(KeyValueProvider provider) {
		CountryWhiteListBlackListPlan plan = new CountryWhiteListBlackListPlan();
		plan.setCountryCode(provider.getString(COUNTRY_CODE));
		plan.setPlanType(provider.getString(PLAN_TYPE));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setPlanCode(MiscUtils.generate10CharAlphaNumeric());
		return plan;
	}
}
