package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargePlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SurchargePlanWorkflows;

import junit.framework.Assert;

@Component
public class SurchargePlanSteps {

	@Autowired
	SurchargePlanWorkflows surchargePlanWorkflows;
	
	private SurchargePlan surchargePlan;
	private static final String SUCCESS_MESSAGE = "Record Added Successfully.";

	@When("user creates surcharge plan with details")
	public void createSurchargePlan() {
		surchargePlan = SurchargePlan.getSurchargePlanData();
		surchargePlanWorkflows.createSurchargePlanWithDetails(surchargePlan);
	}

	@Then("surcharge plan should get created successfully")
	public void verifySurchargePlan() {
		Assert.assertEquals(SUCCESS_MESSAGE, surchargePlanWorkflows.getFeedbackText());
		Assert.assertFalse(surchargePlanWorkflows.isNoRecordsFoundInTableView(surchargePlan));
	}
	
	@When("user does not fill mandatory fields for $desc") 
	public void addDetailKeepingMandatoryFieldsBlank() {
		
	}

}
