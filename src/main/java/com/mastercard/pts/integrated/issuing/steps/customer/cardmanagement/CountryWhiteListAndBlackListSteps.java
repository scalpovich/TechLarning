package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CountryWhiteListAndBlackListPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CountryWhiteListBlackListWorkflow;

@Component
public class CountryWhiteListAndBlackListSteps {

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private CountryWhiteListBlackListWorkflow countryWhiteListBlackListWorkflow;

	@When("user can add country in black or white list in plan")
	public void thenUserCanAddCountryInBlackOrWhiteListInPlan() {
		CountryWhiteListAndBlackListPlan countryWhiteListBlackListPlan = CountryWhiteListAndBlackListPlan
				.createWithProvider(provider);
		Assert.assertTrue(countryWhiteListBlackListWorkflow.addCountryInBlackOrWhiteListInPlan(countryWhiteListBlackListPlan));
	}

}
