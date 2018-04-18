package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramFlows;

@Component
public class DeviceSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private DeviceWorkflow deviceWorkflow;

	@Autowired
	ProgramFlows programFlows;

	@Autowired
	Program program;

	private static final String CORPORATE_CLIENT_CODE_DEVICE2 = "CORPORATE_CLIENT_CODE_DEVICE2";

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

	@When("user creates new device of $type type for non-default institution")
	public void whenUserCreatesNewDeviceForNewBank(String type) {
		Device device = Device.createWithProvider(provider);

		Program program = context.get(ContextConstants.PROGRAM);
		device.setAppliedForProduct(program.getProduct());
		device.setProgramCode(program.buildDescriptionAndCode());

		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		device.setDeviceType1(devicePlan.getDeviceType());
		device.setCorporateClientCode(provider
				.getString(CORPORATE_CLIENT_CODE_DEVICE2));
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE2, device);
		MiscUtils.reportToConsole("Device Number from context - "
				+ device.getDeviceNumber());
	}

	@When("user creates new device of $type type for new client of $customerType customer")
	public void userCreatesNewDeviceForNewClient(String type,
			String customerType) {
		Device device = Device.createWithProvider(provider);
		device.setCustomerType(ProductType.fromShortName(customerType));

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
	public void thenPrepaidDevicePlanAndProgramAreMadeAvailableForDeviceCreation(
			String type) {
		Device device = Device.createWithProvider(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));

		Device deviceTemp = Device.createWithProviderForOtherDetails(provider);
		device.setOtherInfoDeliveryMode(deviceTemp.getOtherInfoDeliveryMode());
		device.setOtherInfoEmailAlertRequired(deviceTemp
				.getOtherInfoEmailAlertRequired());
		device.setOtherInfoFaxNo(deviceTemp.getOtherInfoFaxNo());
		device.setOtherInfoPreferredLanguage(deviceTemp
				.getOtherInfoPreferredLanguage());
		device.setOtherInfoRegisteredEmailAddress(deviceTemp
				.getOtherInfoRegisteredEmailAddress());
		device.setOtherInfoRegisteredMobileNumber(deviceTemp
				.getOtherInfoRegisteredMobileNumber());
		device.setOtherInfoRegisterForDncr(deviceTemp
				.getOtherInfoRegisterForDncr());
		device.setOtherInfoSmsAlertRequired(deviceTemp
				.getOtherInfoSmsAlertRequired());
		device.setOtherInfoStatementPreference(deviceTemp
				.getOtherInfoStatementPreference());

		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());

		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());

		deviceWorkflow.verifyProgramAndDevicePlan(device);
	}

	@Then("$type device is created")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceCreation(String type) {
		Device device = Device.createWithProvider(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setApplicationType(device.getApplicationType());
		context.put(ContextConstants.APPLICATION_TYPE, device.getApplicationType());
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
		sdnUncheckProgram(program.getProgramCode());
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());

		Assert.assertTrue("Application is not created successfully",deviceWorkflow.createDeviceUsingApplication(device));
		context.put(CreditConstants.APPLICATION, device);
	}

	@Then("$device is created with $application as application type and application sub type as $applicationSubType")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceCreation(
			String type, String application, String applicationSubType) {
		Device device = Device.createWithProvider(provider);

		device.setDeviceNumber(context.get(CreditConstants.DEVICE_NUMBER));

		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setApplicationType(application);
		device.setSubApplicationType(applicationSubType);

		Device deviceTemp = Device.createWithProviderForOtherDetails(provider);
		device.setOtherInfoDeliveryMode(deviceTemp.getOtherInfoDeliveryMode());
		device.setOtherInfoEmailAlertRequired(deviceTemp
				.getOtherInfoEmailAlertRequired());
		device.setOtherInfoFaxNo(deviceTemp.getOtherInfoFaxNo());
		device.setOtherInfoPreferredLanguage(deviceTemp
				.getOtherInfoPreferredLanguage());
		device.setOtherInfoRegisteredEmailAddress(deviceTemp
				.getOtherInfoRegisteredEmailAddress());
		device.setOtherInfoRegisteredMobileNumber(deviceTemp
				.getOtherInfoRegisteredMobileNumber());
		device.setOtherInfoRegisterForDncr(deviceTemp
				.getOtherInfoRegisterForDncr());
		device.setOtherInfoSmsAlertRequired(deviceTemp
				.getOtherInfoSmsAlertRequired());
		device.setOtherInfoStatementPreference(deviceTemp
				.getOtherInfoStatementPreference());

		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		sdnUncheckProgram(program.getProgramCode());
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());

		Assert.assertTrue("Application is not created successfully",
				deviceWorkflow.createDeviceUsingApplication(device));
		context.put(CreditConstants.APPLICATION, device);
	}

	@Then("$type device is created using new device screen")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceCreationUsingNewDevice(
			String type) {
		Device device = Device.createWithProvider(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));

		Device deviceTemp = Device.createWithProviderForOtherDetails(provider);
		device.setOtherInfoDeliveryMode(deviceTemp.getOtherInfoDeliveryMode());
		device.setOtherInfoEmailAlertRequired(deviceTemp
				.getOtherInfoEmailAlertRequired());
		device.setOtherInfoFaxNo(deviceTemp.getOtherInfoFaxNo());
		device.setOtherInfoPreferredLanguage(deviceTemp
				.getOtherInfoPreferredLanguage());
		device.setOtherInfoRegisteredEmailAddress(deviceTemp
				.getOtherInfoRegisteredEmailAddress());
		device.setOtherInfoRegisteredMobileNumber(deviceTemp
				.getOtherInfoRegisteredMobileNumber());
		device.setOtherInfoRegisterForDncr(deviceTemp
				.getOtherInfoRegisterForDncr());
		device.setOtherInfoSmsAlertRequired(deviceTemp
				.getOtherInfoSmsAlertRequired());
		device.setOtherInfoStatementPreference(deviceTemp
				.getOtherInfoStatementPreference());

		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		sdnUncheckProgram(program.getProgramCode());
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());

		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE, device);
	}

	public void sdnUncheckProgram(String value) {
		programFlows.programEdit(value);
		program.setProgramCode(value);
	}

	@Then("$type device is created using new device screen by data driven")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableFroDeviceCreationUsingNewDeviceDataDriven(
			String type) {
		Device device = Device.createWithProvider(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		Device deviceTemp = Device.createWithProviderForOtherDetails(provider);
		device.setOtherInfoDeliveryMode(deviceTemp.getOtherInfoDeliveryMode());
		device.setOtherInfoEmailAlertRequired(deviceTemp
				.getOtherInfoEmailAlertRequired());
		device.setOtherInfoFaxNo(deviceTemp.getOtherInfoFaxNo());
		device.setOtherInfoPreferredLanguage(deviceTemp
				.getOtherInfoPreferredLanguage());
		device.setOtherInfoRegisteredEmailAddress(deviceTemp
				.getOtherInfoRegisteredEmailAddress());
		device.setOtherInfoRegisteredMobileNumber(deviceTemp
				.getOtherInfoRegisteredMobileNumber());
		device.setOtherInfoRegisterForDncr(deviceTemp
				.getOtherInfoRegisterForDncr());
		device.setOtherInfoSmsAlertRequired(deviceTemp
				.getOtherInfoSmsAlertRequired());
		device.setOtherInfoStatementPreference(deviceTemp
				.getOtherInfoStatementPreference());
		sdnUncheckProgram(program.getProgramCode());
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE, device);
	}

	@When("$type device is created using new device screen by data driven $pinOption Pin")
	@Then("$type device is created using new device screen by data driven $pinOption Pin")
	public void createWithProviderDataDriven(String type, String pinOption) {
		Device device = Device.createWithProviderDataDriven(provider);

		Constants.DATA_DRIVEN_CARD_BOARDING = "YES";

		if (pinOption.equalsIgnoreCase("with")) {
			context.put(ConstantData.IS_PIN_REQUIRED, "TRUE");
		} else {
			context.put(ConstantData.IS_PIN_REQUIRED, "FALSE");
		}

		device.setAppliedForProduct(ProductType.fromShortName(type));
		Device deviceTemp = Device.createWithProviderForOtherDetails(provider);
		device.setOtherInfoDeliveryMode(deviceTemp.getOtherInfoDeliveryMode());
		device.setOtherInfoEmailAlertRequired(deviceTemp
				.getOtherInfoEmailAlertRequired());
		device.setOtherInfoFaxNo(deviceTemp.getOtherInfoFaxNo());
		device.setOtherInfoPreferredLanguage(deviceTemp
				.getOtherInfoPreferredLanguage());
		device.setOtherInfoRegisteredEmailAddress(deviceTemp
				.getOtherInfoRegisteredEmailAddress());
		device.setOtherInfoRegisteredMobileNumber(deviceTemp
				.getOtherInfoRegisteredMobileNumber());
		device.setOtherInfoRegisterForDncr(deviceTemp
				.getOtherInfoRegisterForDncr());
		device.setOtherInfoSmsAlertRequired(deviceTemp
				.getOtherInfoSmsAlertRequired());
		device.setOtherInfoStatementPreference(deviceTemp
				.getOtherInfoStatementPreference());
		sdnUncheckProgram(program.getProgramCode());
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE, device);
	}
}