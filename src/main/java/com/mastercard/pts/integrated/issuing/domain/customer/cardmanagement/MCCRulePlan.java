package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class MCCRulePlan implements HasCodeAndDescription {

	private String mccRulePlanCode;
	
	private String description;
	
	private String productType;
	
	// TODO: Add list of MCC
	
	public static MCCRulePlan createWithProvider(KeyValueProvider provider) {
		MCCRulePlan plan = new MCCRulePlan();
		plan.setMccRulePlanCode(MiscUtils.generate8CharAlphaNumeric() + MiscUtils.generateRandomNumberAsString(1));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}

	public String getMccRulePlanCode() {
		return mccRulePlanCode;
	}

	public void setMccRulePlanCode(String mccRulePlanCode) {
		this.mccRulePlanCode = mccRulePlanCode;
	}
	
	@Override
	public String getCode() {
		return getMccRulePlanCode();
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}