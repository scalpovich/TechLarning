package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoyaltyPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoyaltyTransactionFlows;

@Component
public class LoyaltyTransactionPlanSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private LoyaltyTransactionFlows loyaltyTransflows;

	@Autowired
	LoyaltyPlan loyaltyplan;

	@When("user selects all the transactions for loyalty transaction plan")
	public void selectAllTransactions() {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		// loyaltyplan.setLoyaltyTransactionPlan(context.get(ContextConstants.TRANSACTION_PLAN));
		String a = data.getTransactionPlan().substring(12);
		loyaltyplan.setLoyaltyTransactionPlan(a);
		loyaltyTransflows.selectTransactions(loyaltyplan);
	}

}
