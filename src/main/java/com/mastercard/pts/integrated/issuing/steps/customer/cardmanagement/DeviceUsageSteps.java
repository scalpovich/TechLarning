package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

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

	@When("user searches device on device usage screen")
	public void whenUserSearchesDeviceOnDeviceUsageScreen() {
		Device device = context.get(ContextConstants.DEVICE);
		deviceUsageWorkflow.deviceUsageVerification(device.getDeviceNumber());
		
	}

}
