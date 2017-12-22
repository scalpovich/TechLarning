package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceWorkflow;

@Component
public class DeviceSteps {
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private DeviceWorkflow deviceWorkflow;
	
	@When("user creates new device of $type type for new client")
	public void whenUserCreatesNewDeviceForNewClient(String type) {
		Device device = Device.createWithProvider(provider);
		
		Program program = context.get(ContextConstants.PROGRAM);
		device.setAppliedForProduct(program.getProduct());
		device.setProgramCode(program.buildDescriptionAndCode());
		
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		device.setDeviceType1(devicePlan.getDeviceType());
		
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE, device);
	
	}
	
	@Then("$type device plan and program are made available for Device Creation")
	public void thenPrepaidDevicePlanAndProgramAreMadeAvailableForDeviceCreation(String type){
		Device device = Device.createWithProvider(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		
		Device deviceTemp = Device.createWithProviderForOtherDetails(provider); 
		device.setOtherInfoDeliveryMode(deviceTemp.getOtherInfoDeliveryMode());
		device.setOtherInfoEmailAlertRequired(deviceTemp.getOtherInfoEmailAlertRequired());
		device.setOtherInfoFaxNo(deviceTemp.getOtherInfoFaxNo());
		device.setOtherInfoPreferredLanguage(deviceTemp.getOtherInfoPreferredLanguage());
		device.setOtherInfoRegisteredEmailAddress(deviceTemp.getOtherInfoRegisteredEmailAddress());
		device.setOtherInfoRegisteredMobileNumber(deviceTemp.getOtherInfoRegisteredMobileNumber());
		device.setOtherInfoRegisterForDncr(deviceTemp.getOtherInfoRegisterForDncr());
		device.setOtherInfoSmsAlertRequired(deviceTemp.getOtherInfoSmsAlertRequired());
		device.setOtherInfoStatementPreference(deviceTemp.getOtherInfoStatementPreference());
		
		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		
		deviceWorkflow.verifyProgramAndDevicePlan(device);
	}
}