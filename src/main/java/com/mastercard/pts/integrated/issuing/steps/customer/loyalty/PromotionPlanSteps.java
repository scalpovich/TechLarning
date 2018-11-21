package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;
import org.jbehave.core.annotations.Then;
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

	@When("user adds promotion Plan with MCG")
	public void addPromotionPlanwithMCG() {
		promotionPlan = PromotionPlan.createWithProvider(Provider);
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		promotionPlan.setPromotionloyaltyPlan(data.getLoyaltyPlan());
		context.put(ContextConstants.PROMOTION_PLAN, promotionPlan);
		uiVerificationLoyaltyWorkflow.verifyPromotionPlanwithMCG(promotionPlan);
	}
	
	@Then("user notes down promotion plan details for $plan")
	public void notePromoPlanDetails(String plan) {
		Double amtSpent = Double.parseDouble(uiVerificationLoyaltyWorkflow.getAmtSpentOnPromotionPlan(plan));
		Double ptsEarned = Double.parseDouble(uiVerificationLoyaltyWorkflow.getPointsEarnedOnPromotionPlan(plan));
		context.put(ContextConstants.PROMOTION_PLAN_AMT_SPENT, amtSpent);
		context.put(ContextConstants.PROMOTION_PLAN_POINTS_EARNED, ptsEarned);
	}

	@Then("select promotion rules MCG as $mcg for promotion plan $plan")
	public void selectBlockedMCG(String mcg, String plan) {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		uiVerificationLoyaltyWorkflow.selectPromoRulesMCG(plan, mcg);
	}
}
