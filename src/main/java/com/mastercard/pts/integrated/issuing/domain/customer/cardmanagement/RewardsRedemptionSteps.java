package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.RewardsRedemptionFlows;

@Component
public class RewardsRedemptionSteps {

	@Autowired
	RewardsRedemptionFlows rewardflows;

	@Autowired
	RewardsRedemption rewardsRedemption;

	@When("user verifies rewards and redemption screen")
	@Then("user verifies rewards and redemption screen")
	public void thenUserVerifiesRewardsAndRedemptionScreen() {
		rewardflows.verifyRewardsRedemptionScreen(rewardsRedemption);
	}
}