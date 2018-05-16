package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;


import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GatewayConfiguration;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.GatewayConfigurationWorkflows;

@Component
public class GatewayConfigurationSteps {

	@Autowired
	GatewayConfigurationWorkflows gatewayConfigurationWorkflows;
	@Autowired
	KeyValueProvider provider;

	private GatewayConfiguration gatewayConfiguration;

	@When("user creates gateway configuration with details")
	public void createGatewayConfigurationPlan() {
		gatewayConfiguration = GatewayConfiguration
				.getGatewayConfigurationData(provider);
		gatewayConfigurationWorkflows
				.createGatewayConfigurationWithDetails(gatewayConfiguration);
	}

	@Then("gateway configuration should get created successfully")
	public void verifyGatewayConfigurationPlan() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY,
				gatewayConfigurationWorkflows.getFeedbackText());
		Assert.assertFalse(gatewayConfigurationWorkflows
				.isNoRecordsFoundInTableView(gatewayConfiguration));
	}
}
