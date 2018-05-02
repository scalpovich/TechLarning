package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMerchantLocation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskMerchantLocationWorkflow;

import junit.framework.Assert;

@Component
public class HighRiskMerchantLocationSteps {

	@Autowired
	HighRiskMerchantLocationWorkflow highRiskMerchantLocationWorkFlow;
	
	@Autowired
	private HighRiskMerchantLocation highRiskMerchantLocation;
	
	private int NumberOfErrorFields = 6;

	@When("user creates High Risk Merchant Location with details")
	public void createSurchargePlan() {
		highRiskMerchantLocation.setMerchantLocationId(highRiskMerchantLocationWorkFlow.createhighRiskMerchantLocationWithDetails());;
	}

	@Then("High Risk Merchant Location should get created successfully")
	public void verifySurchargePlan() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY, highRiskMerchantLocationWorkFlow.getFeedbackText());
		Assert.assertFalse(highRiskMerchantLocationWorkFlow.isNoRecordsFoundInTableView(highRiskMerchantLocation));
	}
	
	@When("user does not fill mandatory fields in High Risk Merchant Location") 
	public void addDetailKeepingMandatoryFieldsBlank() {
		highRiskMerchantLocationWorkFlow.saveWithoutMandatoryFields();
	}
	
	@Then("appropriate validation should be triggered in High Risk Merchant Location") 
	public void appropriateValidationCheck() {
		Assert.assertEquals(ConstantData.FIELD_VALIDATION_ERROR, highRiskMerchantLocationWorkFlow.validateError().stream().findFirst().get().getText());
		Assert.assertEquals(highRiskMerchantLocationWorkFlow.validateError().size(),NumberOfErrorFields);
	}

}
