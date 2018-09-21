package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ApplicationType;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.SubApplicationType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceDetailsFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceTrackingWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramFlows;

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
	

	@Autowired
	ProgramFlows programFlows;

	@Autowired
	Program program;

	private static final String CORPORATE_CLIENT_CODE_DEVICE2 = "CORPORATE_CLIENT_CODE_DEVICE2";
	
	@Then("new fields are added in device tracking screen")
	public void thenNewFieldAreAddedInDeviceTrackingScreen(){
		
		Device device = context.get(ContextConstants.DEVICE);
		deviceDetailsWorkflow.findAndPutDeviceApplicationNumberInContext();
		deviceTrackingWorkflow.checkForNewFieldsAdded(device);
	}

}
