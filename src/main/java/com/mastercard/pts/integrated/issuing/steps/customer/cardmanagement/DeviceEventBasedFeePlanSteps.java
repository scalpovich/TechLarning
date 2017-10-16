package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceEventBasedFeePlanFlows;

@Component
public class DeviceEventBasedFeePlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	DeviceEventBasedFeePlanFlows deviceEventBasedflows;

	public DeviceEventBasedFeePlan deviceEventBasedPlan;

	@When("user creates Device Event Based Fee Plan for $product")
	public void whenUserCreatesDeviceEventBasedFeePlanForPrepaid(@Named("product") String product) {
		deviceEventBasedPlan = DeviceEventBasedFeePlan.deviceeventbasedfeeplanDataProvider();
		deviceCreation.setProduct(product);
		deviceEventBasedflows.createDeviceEventBasedFeePlan(deviceCreation, deviceEventBasedPlan);
	}
}