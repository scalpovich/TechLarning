package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class LoyaltyPlan implements HasCodeAndDescription {

	private String loyaltyPlanCode;

	private String description;

	private String loyaltyTransactionPlan;

	private String maxloyaltypoints;

	public String getMaxloyaltypoints() {
		return maxloyaltypoints;
	}

	public void setMaxloyaltypoints(String maxloyaltypoints) {
		this.maxloyaltypoints = maxloyaltypoints;
	}

	public String getLoyaltyTransactionPlan() {
		return loyaltyTransactionPlan;
	}

	public void setLoyaltyTransactionPlan(String loyaltyTransactionPlan) {
		this.loyaltyTransactionPlan = loyaltyTransactionPlan;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static LoyaltyPlan createGenericTestData() {
		LoyaltyPlan plan = new LoyaltyPlan();
		plan.setLoyaltyPlanCode(MiscUtils.generate8CharAlphaNumeric() + MiscUtils.generateRandomNumberAsString(1));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}

	public static LoyaltyPlan createWithProvider(KeyValueProvider provider) {
		LoyaltyPlan plan = new LoyaltyPlan();
		plan.setLoyaltyPlanCode(MiscUtils.generate8CharAlphaNumeric() + MiscUtils.generateRandomNumberAsString(1));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}

	public String getLoyaltyPlanCode() {
		return loyaltyPlanCode;
	}

	public void setLoyaltyPlanCode(String loyaltyPlanCode) {
		this.loyaltyPlanCode = loyaltyPlanCode;
	}

	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
