package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.LoyaltyPromotionMapping;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.PromotionPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component
public class LoyaltyPromotionMappingSteps {
	@Autowired
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	/*
	 * @Autowired private PromotionPlan promotionPlan;
	 */

	@Autowired
	private LoyaltyPromotionMapping loyaltyPromotionMapping;

	@When("user maps promotion Plan with loyalty Plan")
	public void loyaltyPromotionMappingAdd() {
		PromotionPlan promotionPlan = context.get(ContextConstants.PROMOTION_PLAN);
		// promotionPlan = PromotionPlan.createWithProvider(Provider);
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		loyaltyPromotionMapping.setMappingLoyaltyPlanddwn(data.getLoyaltyPlan());
		loyaltyPromotionMapping.setMappingPromotionPlanddwn(promotionPlan.buildDescriptionAndCode());
		loyaltyPromotionMapping.setPriority(provider.getString("MAPPING_PRIORITY"));
		uiVerificationLoyaltyWorkflow.verifyLoyaltyPlanPromotionMappingPage(loyaltyPromotionMapping);
	}
}
