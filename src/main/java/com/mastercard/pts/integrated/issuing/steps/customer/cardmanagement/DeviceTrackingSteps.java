package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceDetailsFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceTrackingWorkflow;

@Component
public class DeviceTrackingSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private DeviceDetailsFlows deviceDetailsWorkflow;
	
	@Autowired
	private DeviceTrackingWorkflow deviceTrackingWorkflow;

	@Then("new fields are added in device tracking screen")
	public void thenNewFieldAreAddedInDeviceTrackingScreen(){
		
		Device device = context.get(ContextConstants.DEVICE);
		deviceDetailsWorkflow.findAndPutDeviceApplicationNumberInContext();
		deviceTrackingWorkflow.checkForNewFieldsAdded(device);
	}

}
