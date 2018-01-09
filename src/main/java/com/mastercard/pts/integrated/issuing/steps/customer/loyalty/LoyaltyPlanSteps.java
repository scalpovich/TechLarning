package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component

public class LoyaltyPlanSteps {
@Autowired	
private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;
@When("user adds loyalty Plan")
public void addLoyaltyPlan()
{
	uiVerificationLoyaltyWorkflow.verifyLoyaltyPlanPage();
}
}
