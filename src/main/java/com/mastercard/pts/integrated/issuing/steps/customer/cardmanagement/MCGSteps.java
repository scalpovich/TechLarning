package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.junit.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCG;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MCGFlows;

@Component
public class MCGSteps {

	@Autowired
	MCGFlows mcgFlows;

	@Autowired
	MCG mcg;

	@Autowired
	KeyValueProvider provider;

	@Autowired
	private TestContext context;

	@When("user creates MCG")
	public void whenUserCreatesMCG() {
		mcg = MCG.getMCGDetails(provider);
		mcgFlows.addMCG(mcg);
	}

	@Given("user creates MCG with MCC")
	public void whenUserCreatesMCGwithMCC() {
		mcg = MCG.getMCGDetails(provider);
		mcgFlows.addMCGwithMCC(mcg);
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY, mcgFlows.getFeedbackText());
		context.put(ContextConstants.MCG, mcg.getMCGCode());
	}
}