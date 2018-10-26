package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component

public class LoyaltyPlanSteps {
	@Autowired
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;
	
	@Autowired
	private TestContext context;

	@When("user adds loyalty Plan")
	public void addLoyaltyPlan() {
		uiVerificationLoyaltyWorkflow.verifyLoyaltyPlanPage();
	}

	@Then("verify available loyalty points should be within loyalty plan limit")
	public void verifyMaxAccruedLoyalty() {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		Double availablePts = 0.0;
		Double maxPts = Double.parseDouble(uiVerificationLoyaltyWorkflow.getMaxLoyaltyPointsPerCycle(data.getLoyaltyPlan()));
		if(!(context.get(Constants.AVAILABLE_LOYALTY_POINTS).equals("-")))
			availablePts = Double.parseDouble(context.get(Constants.AVAILABLE_LOYALTY_POINTS));
		assertTrue(maxPts >= availablePts);
	}
	
	@Then("inactivate loyalty plan")
	public void inactivateLoyaltyPlan() {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		uiVerificationLoyaltyWorkflow.disableLoyaltyPlan(data.getLoyaltyPlan());
	}
	
	@Then("select loyalty plan period unit as Month[M]/Year[Y] - $value")
	public void selectPeriodUnit(String value) {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		uiVerificationLoyaltyWorkflow.selectPeriodUnitByIndex(data.getLoyaltyPlan(), value);
	}
	
}
