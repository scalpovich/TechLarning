package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	private MCGLimitPlan mcgLimitPlan;

	@When("user creates MCG limit plan with details for $productType")
	public void createSurchargePlan(String productType) {
		mcgLimitPlan = MCGLimitPlan.getMCGLimitPlanData(provider);
		mcgLimitPlan.setProductType(ProductType.fromShortName(productType));
		mcgLimitPlanWorkflows.createMCGLimitPlanWithDetails(mcgLimitPlan);
	}

	@Then("MCG limit plan should get created successfully")
	public void verifySurchargePlan() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY, mcgLimitPlanWorkflows.getFeedbackText());
		Assert.assertFalse(mcgLimitPlanWorkflows.isNoRecordsFoundInTableView(mcgLimitPlan));
	}

}
