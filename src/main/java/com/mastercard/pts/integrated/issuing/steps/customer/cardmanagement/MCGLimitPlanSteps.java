package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCGLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MCGLimitPlanWorkflows;

@Component
public class MCGLimitPlanSteps {

	@Autowired
	MCGLimitPlanWorkflows mcgLimitPlanWorkflows;
	@Autowired
	KeyValueProvider provider;
	@Autowired
	private TestContext context;
	
	private MCGLimitPlan mcgLimitPlan;

	@When("user creates MCG limit plan with details for $productType")
	public void createSurchargePlan(String productType) {
		mcgLimitPlan = MCGLimitPlan.getMCGLimitPlanData(provider);
		mcgLimitPlan.setProductType(ProductType.fromShortName(productType));
		mcgLimitPlan = mcgLimitPlanWorkflows.createMCGLimitPlanWithDetails(mcgLimitPlan);
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY, mcgLimitPlanWorkflows.getFeedbackText());
		context.put(ContextConstants.MCG_LIMIT_PLAN, mcgLimitPlan);
	}

	@Then("MCG limit plan should get created successfully")
	public void verifySurchargePlan() {
		Assert.assertFalse(mcgLimitPlanWorkflows.isNoRecordsFoundInTableView(mcgLimitPlan));
	}

}
