package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.DeviceStatus;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListDevice;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceStatusWorkFlow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.StopListDeviceWorkFlow;

/**
 * @author E076170
 * 
 *
 */

@Component
public class DeviceStatusSteps extends AbstractBaseSteps {
    @Autowired
    private DeviceStatusWorkFlow deviceStatusWorkflow;
    
	@Autowired
	private KeyValueProvider keyProvider;
	
	@Autowired
	private TestContext context;

	@When("User Changes Device Status to $status")
	@Then("User Changes Device Status to $status")
	public void userChangeDeviceStatusToCapture(String status) {
		deviceStatusWorkflow.changeStatus(status);
	}

}
