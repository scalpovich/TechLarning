package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;


import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CountryWhiteListBlackListPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CountryWhiteListBlackListWorkflow;

@Component
public class CountryWhiteListBlackListSteps {

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private CountryWhiteListBlackListWorkflow countryWhiteListBlackListWorkflow;

	@When("user can add country in black or white list in plan")
	public void thenUserCanAddCountryInBlackOrWhiteListInPlan() {
		CountryWhiteListBlackListPlan countryWhiteListBlackListPlan = CountryWhiteListBlackListPlan
				.createWithProvider(provider);
		Assert.assertTrue(countryWhiteListBlackListPlan.getPlanCode()+"is added successfully",countryWhiteListBlackListWorkflow.addCountryInBlackOrWhiteListInPlan(countryWhiteListBlackListPlan));
	}

}
