package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceRangeFlows;

@Component
public class DeviceRangeSteps {

	@Autowired
	DeviceRangeFlows devicerangeflows;

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	Program program;

	@Autowired
	DeviceBin devicebin;

	@When("user creates a Device Range for product $product")
	public void whenUserCreatesADeviceRangeForProductPrepaid(@Named("product") String product) {
		devicebin.setProgram(program.getProgram());
		devicebin.setDeviceplan(program.getDevicePlanProgram());
		devicebin.setProductType(program.getProduct());
		devicerangeflows.addDeviceRange(devicebin);
	}

	@When("Device Range Adaptive Authentication CheckBox should be $enabled")
	@Then("Device Range Adaptive Authentication CheckBox should be $enabled")
	public void verifyAdaptiveAuthenticationCheckBox(@Named("enabled") String enabled) {
		if (enabled.equalsIgnoreCase("Enabled")) {
			devicerangeflows.checkAdaptiveAuthenticationEnabled();
		}
		if (enabled.equalsIgnoreCase("Disabled")) {
			devicerangeflows.checkAdaptiveAuthenticationDisabled();
		}
	}

	@When("user edits the device range")
	public void editDeviceRange() {
		devicerangeflows.editDeviceRange(program.getProgramCode());

	}
}