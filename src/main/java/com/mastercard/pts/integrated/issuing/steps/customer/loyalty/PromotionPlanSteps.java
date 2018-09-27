package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.PromotionPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component
public class PromotionPlanSteps {
	@Autowired
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider Provider;

	@Autowired
	private PromotionPlan promotionPlan;

	@When("user adds promotion Plan")
	public void addPromotionPlan() {
		promotionPlan = PromotionPlan.createWithProvider(Provider);
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		promotionPlan.setPromotionloyaltyPlan(data.getLoyaltyPlan());
		context.put(ContextConstants.PROMOTION_PLAN, promotionPlan);
		uiVerificationLoyaltyWorkflow.verifyPromotionPlanPage(promotionPlan);
	}
}
