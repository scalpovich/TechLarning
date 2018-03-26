package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceRangeFlows;

@Component
public class DeviceRangeSteps {

	@Autowired
	DeviceRangeFlows devicerangeflows;

	@Autowired
	DeviceCreation devicecreation;
	
	@When("user creates a Device Range for product $product")
	public void whenUserCreatesADeviceRangeForProductPrepaid(@Named("product") String product) {
		devicerangeflows.addDeviceRange(devicecreation);
	}
	
	@When("for application upload scenario user creates a Device Range for product $product")
	public void whenUserCreatesADeviceRangeForProduct(@Named("product") String product) {
		devicerangeflows.addDeviceRangeUpload(devicecreation);
	}
}