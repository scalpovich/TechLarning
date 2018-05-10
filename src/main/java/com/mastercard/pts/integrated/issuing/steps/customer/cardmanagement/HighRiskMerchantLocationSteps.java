package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMerchantLocation;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskMerchantLocationWorkflow;

@Component
public class HighRiskMerchantLocationSteps {

	@Autowired
	HighRiskMerchantLocationWorkflow highRiskMerchantLocationWorkFlow;
	
	@Autowired
	private HighRiskMerchantLocation highRiskMerchantLocation;
	
	@Autowired
	private KeyValueProvider provider;
	
	private int numberOfErrorFields = 6;

	@When("user creates High Risk Merchant Location with details")
	public void createHighRiskMerchantLocationPlan() {
		highRiskMerchantLocation = HighRiskMerchantLocation.getHighRiskMerchantLocation(provider);
		highRiskMerchantLocationWorkFlow.createhighRiskMerchantLocationWithDetails(highRiskMerchantLocation);
	}

	@Then("High Risk Merchant Location should get created successfully")
	public void verifyHighRiskMerchantLocationPlan() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY, highRiskMerchantLocationWorkFlow.getFeedbackText());
		Assert.assertFalse(highRiskMerchantLocationWorkFlow.isNoRecordsFoundInTableView(highRiskMerchantLocation));
	}
	
	@When("user does not fill mandatory fields in High Risk Merchant Location") 
	public void addDetailKeepingMandatoryFieldsBlank() {
		highRiskMerchantLocationWorkFlow.saveWithoutMandatoryFields();
	}
	
	@Then("appropriate validation should be triggered in High Risk Merchant Location") 
	public void appropriateValidationCheck() {
		Assert.assertEquals(ConstantData.REQUIRED_FIELD_VALIDATION_MESSAGE, highRiskMerchantLocationWorkFlow.validateError().stream().findFirst().get().getText());
		Assert.assertEquals(highRiskMerchantLocationWorkFlow.validateError().size(),numberOfErrorFields);
	}

}
