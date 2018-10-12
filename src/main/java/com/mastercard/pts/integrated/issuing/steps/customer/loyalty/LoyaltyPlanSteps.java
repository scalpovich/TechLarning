package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component

public class LoyaltyPlanSteps {
	@Autowired
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;

	@Autowired
	LoyaltyPlan loyaltyplan;

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@When("user adds loyalty Plan")
	public void addLoyaltyPlan() {
		uiVerificationLoyaltyWorkflow.verifyLoyaltyPlanPage();
	}

	@When("user edits the loyalty plan for $field")
	public void editLoyaltyPlan() {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		loyaltyplan.setLoyaltyTransactionPlan(data.getLoyaltyPlan().substring(17).replace("]", ""));
		loyaltyplan.setMaxloyaltypoints(provider.getString("MAX_AMT_EACH_PERIOD"));
		uiVerificationLoyaltyWorkflow.EditLoyaltyPlanPage(loyaltyplan);
	}

}
