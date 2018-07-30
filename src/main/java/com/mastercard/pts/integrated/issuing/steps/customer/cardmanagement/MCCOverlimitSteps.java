package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCOverlimit;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MCCOverLimitFlows;

import org.junit.Assert;

@Component
public class MCCOverlimitSteps {

	@Autowired
	MCCOverLimitFlows mccOverLimitFlows;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	KeyValueProvider provider;
	
	private MCCOverlimit mccOverlimit;
	
	@When("User fills MCC Overlimit details")
	public void createMccOverlimit() {
		mccOverlimit = MCCOverlimit.createDataWithProvider(provider);
		mccOverlimit.setWalletPlan(getFormattedWalletPlan());
		mccOverLimitFlows.createMccOverlimit(mccOverlimit);
	}

	@Then("MCC Overlimit should be created successfully")
	public void verifyCreatedMccOverlimit() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY, mccOverLimitFlows.getFeedBackText());
	}
	
	private String getFormattedWalletPlan() {
		WalletPlan wp = context.get(ContextConstants.WALLET);
		String desc = wp.getDescription();
		String code = wp.getWalletPlanCode();
		
		return String.format("%s [%s]", desc, code);
	}

}