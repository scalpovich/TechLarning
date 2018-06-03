package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SurchargePlanWorkflows;

import junit.framework.Assert;

@Component
public class SurchargePlanSteps {

	@Autowired
	SurchargePlanWorkflows surchargePlanWorkflows;
	@Autowired
	KeyValueProvider provider;
	
	private SurchargePlan surchargePlan;

	@When("user creates surcharge plan with details")
	public void createSurchargePlan() {
		surchargePlan = SurchargePlan.getSurchargePlanData(provider);
		surchargePlanWorkflows.createSurchargePlanWithDetails(surchargePlan);
	}

	@Then("surcharge plan should get created successfully")
	public void verifySurchargePlan() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY, surchargePlanWorkflows.getFeedbackText());
		Assert.assertFalse(surchargePlanWorkflows.isNoRecordsFoundInTableView(surchargePlan));
	}
}
