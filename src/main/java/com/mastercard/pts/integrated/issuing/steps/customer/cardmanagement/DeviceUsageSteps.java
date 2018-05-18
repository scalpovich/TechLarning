package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceUsageWorklow;

@Component
public class DeviceUsageSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private DeviceUsageWorklow deviceUsageWorkflow;

	@Then("user searches device on device usage screen and performs assertions on device tool usage and device transaction usage tabs")
	public void whenUserSearchesDeviceOnDeviceUsageScreen() {
		Device device = context.get(ContextConstants.DEVICE);
//		deviceUsageWorkflow.deviceUsageVerification("5887651326558415");
		deviceUsageWorkflow.deviceUsageVerification(device.getDeviceNumber());
		}
	@When("Device Usage")
	public void userDeviceUsage(){
		deviceUsageWorkflow.getWalletMCGUsage();
	}
	
}