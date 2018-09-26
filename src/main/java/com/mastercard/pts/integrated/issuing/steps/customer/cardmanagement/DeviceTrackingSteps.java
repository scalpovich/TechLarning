package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearch;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceTrackingWorkflow;

@Component
public class DeviceTrackingSteps {

	@Autowired
	TestContext context;

	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	DeviceTrackingWorkflow deviceTrackingWorkflow;
	

//	@When("search with device in device tracking screen and status of carrier")
//	@Then("search with device in device tracking screen and status of carrier")
//	public void thenSearchWithDeviceInDeviceTrackingScreenAndStatusOfCarrier() {
//
//		Device device = context.get(ContextConstants.DEVICE);
//		assertEquals(deviceTrackingWorkflow.searchInDeviceTrackingWithDeviceAndCarrierStatus(device), provider.getString("CARRIER_STATUS")); }
	
}
