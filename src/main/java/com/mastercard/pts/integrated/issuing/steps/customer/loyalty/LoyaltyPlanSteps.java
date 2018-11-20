package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AuthorizationRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component

public class LoyaltyPlanSteps {
	@Autowired
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private KeyValueProvider provider;

	@When("user adds loyalty Plan")
	public void addLoyaltyPlan() {
		uiVerificationLoyaltyWorkflow.verifyLoyaltyPlanPage();
	}
	
	@Then("user notes down max loyalty points for plan")
	public void noteMaxLoyaltyPoints() {
		Double maxPts = 0.0;
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		if(data.getLoyaltyPlan() != null && !data.getLoyaltyPlan().trim().isEmpty())
			maxPts = Double.parseDouble(uiVerificationLoyaltyWorkflow.getMaxLoyaltyPointsPerCycle(data.getLoyaltyPlan()));
		context.put(Constants.MAX_LOYALTY_POINTS, maxPts);
	}

	@Then("verify available loyalty points should be within loyalty plan limit")
	public void verifyMaxAccruedLoyalty() {
		Double availablePts = 0.0;
		if(!(context.get(Constants.AVAILABLE_LOYALTY_POINTS).equals("-")))
			availablePts = context.get(Constants.AVAILABLE_LOYALTY_POINTS);
		assertTrue((Double)context.get(Constants.MAX_LOYALTY_POINTS) >= availablePts);
	}
	
	@Then("deactivate loyalty plan")
	public void inactivateLoyaltyPlan() {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		uiVerificationLoyaltyWorkflow.disableLoyaltyPlan(data.getLoyaltyPlan());
	}
	
	@Then("select loyalty plan period unit as Month[M]/Year[Y] - $value")
	public void selectPeriodUnit(String value) {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		uiVerificationLoyaltyWorkflow.selectPeriodUnitByIndex(data.getLoyaltyPlan(), value);
	}
	
	@Then("use loyalty plan $plan")
	public void useLoyaltyPlan(String plan) {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		if(plan.equals("none"))
			data.setLoyaltyPlan("");
		else
			data.setLoyaltyPlan(plan);
		context.put(CreditConstants.JSON_VALUES, data);
	}
	
	@Then ("verify loyalty points are credited on issuance for promotion plan code $plan")
	public void verifyLpOnIssuance(String plan) {
		Double pointsEarned;
		String points = uiVerificationLoyaltyWorkflow.getPointsEarnedOnPromotionPlan(plan);
		if(points.trim().equals("-"))
			pointsEarned = 0.0;
		else
			pointsEarned = Double.parseDouble(points);
		assertEquals(context.get(Constants.AVAILABLE_LOYALTY_POINTS), pointsEarned);
	}
	
	@Then ("verify loyalty points are not credited on issuance for promotion plan code $plan")
	public void verifyLPNotCreditedOnIssuance() {
		assertEquals(context.get(Constants.AVAILABLE_LOYALTY_POINTS), (Double)0.0);
	}

	@Then("calculate loyalty points")
	public void calculateLoyaltyPoints() {
		AuthorizationRequest request = AuthorizationRequest.createWithProvider(provider);
		if((provider.getString(Constants.FOR_LOYALTY) != null) && (provider.getString(Constants.FOR_LOYALTY).equalsIgnoreCase("yes"))) {
			Double points = (Double)context.get(Constants.AVAILABLE_LOYALTY_POINTS) + ((Double.parseDouble(request.getTransactionAmount()) * (Double)context.get(ContextConstants.PROMOTION_PLAN_POINTS_EARNED)) / (Double)context.get(ContextConstants.PROMOTION_PLAN_AMT_SPENT));
			Double maxLP = context.get(Constants.MAX_LOYALTY_POINTS);
			if(maxLP != null && points != null) {
				if(points < maxLP)
					context.put(Constants.AVAILABLE_LOYALTY_POINTS, Math.floor(points));
				else
					context.put(Constants.AVAILABLE_LOYALTY_POINTS, maxLP);
			}
		}
	}

	@Then("select blocked MCG for loyalty as $value")
	public void selectBlockedMCG(String value) {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		uiVerificationLoyaltyWorkflow.selectBlockedMCG(data.getLoyaltyPlan(), value);
	}

}
