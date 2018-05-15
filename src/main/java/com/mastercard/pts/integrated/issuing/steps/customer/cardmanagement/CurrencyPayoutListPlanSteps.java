package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;



import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CurrencyPayoutListPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CurrencyPayoutListFlows;

@Component
public class CurrencyPayoutListPlanSteps {

	@Autowired
	CurrencyPayoutListFlows currencyPayoutListflow;
	@Autowired
	KeyValueProvider provider;

	private CurrencyPayoutListPlan currencyPayoutListPlan;

	@When("user creates currency payout list plan with details")
	public void createCurrencyPayoutListPlan() {
		currencyPayoutListPlan = CurrencyPayoutListPlan
				.getCurrencyPayoutListPlanData(provider);
		currencyPayoutListflow
				.createCurrencyPayoutListPlanWithDetails(currencyPayoutListPlan);
	}

	@Then("currency payout list plan should get created successfully")
	public void verifyCurrencyPayoutListPlan() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY,
				currencyPayoutListflow.getFeedbackText());
		Assert.assertFalse(currencyPayoutListflow
				.isNoRecordsFoundInTableView(currencyPayoutListPlan));
	}
}
