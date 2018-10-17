package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.RewardsRedemptionFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk.HelpdeskWorkflow;

import junit.framework.Assert;

@Component
public class RewardsRedemptionSteps {

	@Autowired
	RewardsRedemptionFlows rewardflows;

	@Autowired
	RewardsRedemption rewardsRedemption;

	@Autowired
	HelpdeskGeneral helpdeskGeneral;

	@Autowired
	private HelpdeskWorkflow helpdeskWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private TestContext context;

	// private String currentBalanceAmount;

	@When("user verifies rewards and redemption screen")
	@Then("user verifies rewards and redemption screen")
	public void thenUserVerifiesRewardsAndRedemptionScreen() {
		Device device = context.get(ContextConstants.DEVICE);
		rewardsRedemption = RewardsRedemption.createWithProvider(provider);
		// rewardsRedemption.setDeviceNumber(device);
		rewardflows.verifyRewardsRedemptionScreen(device, rewardsRedemption, provider);
	}

	@When("user verifies cumulative transaction points for rewards and redemption screen")
	@Then("user verifies cumulative transaction points for rewards and redemption screen")
	public void thenUserVerifiesRewardsAndRedemptionScreenCumulativeTxn() {
		Device device = context.get(ContextConstants.DEVICE);
		rewardsRedemption = RewardsRedemption.createWithProvider(provider);
		rewardsRedemption.setpointsToRedeem(provider.getString("MAX_AMT_EACH_PERIOD"));
		rewardflows.verifyRewardsRedemptionScreenForCumulativeTxn(device, rewardsRedemption, provider);
	}

	@When("user verifies loyalty points not available for redemption")
	@Then("user verifies loyalty points not available for redemption")
	public void thenUserVerifiesLytPtsNotAvailable() {
		Device device = context.get(ContextConstants.DEVICE);
		rewardsRedemption = RewardsRedemption.createWithProvider(provider);
		// rewardsRedemption.setDeviceNumber(device);
		rewardflows.verifyRewardsPointsNotAvb(device, rewardsRedemption);
	}

	@Given("user verifies current wallet balance amount information after loyalty redemption $type device")
	@When("user verifies current wallet balance amount information after loyalty redemption $type device")
	@Then("user verifies current wallet balance amount information after loyalty redemption $type device")
	public void givenUserHasCurrentWalletBalanceAmountInformation(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		String currentBalanceAmount = helpdeskWorkflow.getWalletBalanceAfterLoyaltyRedemption(device);
		context.put(ContextConstants.AVAILABLE_BALANCE_AFTER_LOYALTY_REDEMPTION, currentBalanceAmount);
		Double balanceAfterLoyalty = Double.parseDouble(context.get("AVAILABLE_BALANCE_OR_CREDIT_LIMIT").toString())
				+ Double.parseDouble(rewardsRedemption.getpointsToRedeem());
		Assert.assertEquals(balanceAfterLoyalty, currentBalanceAmount);
	}

}