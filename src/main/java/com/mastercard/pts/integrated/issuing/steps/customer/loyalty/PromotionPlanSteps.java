package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component
public class PromotionPlanSteps {
	@Autowired	
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;
	@When("user adds promotion Plan")
	public void addPromotionPlan()
	{
		uiVerificationLoyaltyWorkflow.verifyPromotionPlanPage();
	}
}
