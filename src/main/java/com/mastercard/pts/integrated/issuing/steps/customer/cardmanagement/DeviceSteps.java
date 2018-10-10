package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramFlows;

@Component
public class DeviceSteps {

	private static final Logger logger = LoggerFactory.getLogger(DeviceSteps.class);
	
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

	private static final String CREDIT_LIMIT_GREATER_THEN_MAXIMUM_EXP = "Entered Credit Limit is greater than Primary Card Credit Limit.";

	private static final String CORPORATE_CLIENT_CODE_DEVICE2 = "CORPORATE_CLIENT_CODE_DEVICE2";

	@When("user creates new device of $type type for new client")
	@Then("user creates new device of $type type for new client")
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
		device.setCorporateClientCode(provider.getString(CORPORATE_CLIENT_CODE_DEVICE2));
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE2, device);
		MiscUtils.reportToConsole("Device Number from context - " + device.getDeviceNumber());
	}

	@When("user creates new device of $type type for new client of $customerType customer")
	public void userCreatesNewDeviceForNewClient(String type, String customerType) {
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
	public void thenPrepaidDevicePlanAndProgramAreMadeAvailableForDeviceCreation(String type) {
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());

		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());

		deviceWorkflow.verifyProgramAndDevicePlan(device);
	}

	@Then("$type device is created")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceCreation(String type) {
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setApplicationType(device.getApplicationType());
		context.put(ContextConstants.APPLICATION_TYPE, device.getApplicationType());
		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		sdnUncheckProgram(program.getProgramCode());
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());

		Assert.assertTrue("Application is not created successfully",deviceWorkflow.createDeviceUsingApplication(device));
		context.put(CreditConstants.APPLICATION, device);
	}
	
	@Then("$type device is created for $customerType and $applicationType and $subApplicationType and $deviceType")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceForGivenCustomer(String type,String customerType,String applicationType,String subApplicationType,String deviceType) {
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setCustomerType(customerType);
		device.setApplicationType(applicationType);
		device.setSubApplicationType(subApplicationType);
		device.setDeviceType1(deviceType);

		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		sdnUncheckProgram(program.getProgramCode());
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setDevicePlan1(devicePlan.buildDescriptionAndCode());

		Assert.assertTrue("Application is not created successfully",deviceWorkflow.createDeviceUsingApplication(device));
		context.put(CreditConstants.APPLICATION, device);
	}
	
	@Given("$type device is created using new device screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	@When("$type device is created using new device screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	@Then("$type device is created using new device screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceForGivenCustomerUsingNewDevice(String type,String customerType,String applicationType,String subApplicationType,String deviceType) {
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setCustomerType(customerType);
		device.setApplicationType(applicationType);
		device.setSubApplicationType(subApplicationType);
		device.setDeviceType1(deviceType);

		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		
		if(device.getApplicationType().contains(ApplicationType.SUPPLEMENTARY_DEVICE)||device.getApplicationType().contains(ApplicationType.ADD_ON_DEVICE) /*&& !(device.getSubApplicationType().contains(SubApplicationType.NEW_CLIENT))*/){
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		} else {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		}
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE, device);
	}
	
	@Given("$type device is created with increased limit using new device screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	@When("$type device is created with increased limit using new device screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	@Then("$type device is created with increased limit using new device screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceForGivenCustomerUsingNewDeviceWithLimit(String type,String customerType,String applicationType,String subApplicationType,String deviceType) {
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setCustomerType(customerType);
		device.setApplicationType(applicationType);
		device.setSubApplicationType(subApplicationType);
		device.setDeviceType1(deviceType);

		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		logger.info(program.getCreditLimit());
		program.setCreditLimit(String.valueOf(Integer.parseInt(program.getCreditLimit())+25));
		if(device.getApplicationType().contains(ApplicationType.SUPPLEMENTARY_DEVICE)||device.getApplicationType().contains(ApplicationType.ADD_ON_DEVICE) && !(device.getSubApplicationType().contains(SubApplicationType.NEW_CLIENT))){
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		} else {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		}
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE, device);
		Assert.assertEquals("Still Credit Limit is Greater then Maximum", CREDIT_LIMIT_GREATER_THEN_MAXIMUM_EXP, context.get(CreditConstants.CREDIT_LIMIT_GREATER_THAN_MAXIMUM));
	}
	
	@When("$type device is created using new Application screen for $customerType and \"$applicationType\" and $subApplicationType and $deviceType")
	@Given("$type device is created using new Application screen for $customerType and \"$applicationType\" and $subApplicationType and $deviceType")
	@Then("$type device is created using new Application screen for $customerType and \"$applicationType\" and $subApplicationType and $deviceType")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceForGivenCustomerUsingNewApplication(String type,String customerType,String applicationType,String subApplicationType,String deviceType) {
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setCustomerType(customerType);
		device.setApplicationType(applicationType);
		device.setSubApplicationType(subApplicationType);
		device.setDeviceType1(deviceType);
		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		sdnUncheckProgram(program.getProgramCode());		
		if (device.getApplicationType().contains(ApplicationType.SUPPLEMENTARY_DEVICE) || device.getApplicationType().contains(ApplicationType.ADD_ON_DEVICE)) {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		} else {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		}		

 		Assert.assertTrue("Application is not created successfully",deviceWorkflow.createDeviceUsingApplication(device));
		context.put(CreditConstants.APPLICATION, device);
	}
	
	@When("$type device is created with $existing batch using new Application screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	@Given("$type device is created with $existing batch using new Application screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	@Then("$type device is created with $existing batch using new Application screen for $customerType and $applicationType and $subApplicationType and $deviceType")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceForGivenCustomerUsingNewApplicationWithSameBatch(String type,String existingBatch,String customerType,String applicationType,String subApplicationType,String deviceType) {
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setCustomerType(customerType);
		device.setApplicationType(applicationType);
		device.setSubApplicationType(subApplicationType);
		device.setDeviceType1(deviceType);
		Program program = context.get(ContextConstants.PROGRAM);
		device.setProgramCode(program.buildDescriptionAndCode());
		sdnUncheckProgram(program.getProgramCode());		
		context.put(CreditConstants.EXISTING_BATCH,existingBatch);
		if (device.getApplicationType().contains(ApplicationType.SUPPLEMENTARY_DEVICE) || device.getApplicationType().contains(ApplicationType.ADD_ON_DEVICE)) {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		} else {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		}	

 		Assert.assertTrue("Application is not created successfully",deviceWorkflow.createDeviceUsingApplication(device));
		context.put(CreditConstants.APPLICATION, device);
	}
	
	@Given("$type device is created using new device screen")
	@When("$type device is created using new device screen")
	@Then("$type device is created using new device screen")
	public void thenCreditDevicePlanAndProgramAreMadeAvailableForDeviceCreationUsingNewDevice(String type){
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));
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
	      public void thenCreditDevicePlanAndProgramAreMadeAvailableFroDeviceCreationUsingNewDeviceDataDriven(String type){
		Device device = Device.createWithProviderForOtherDetails(provider);
		device.setAppliedForProduct(ProductType.fromShortName(type));		
		sdnUncheckProgram(program.getProgramCode());
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE, device);
	}
	
	@When("User enters incorrect Expiry Date")
	@Then("User enters incorrect Expiry Date")
	public void expiryDateIsIncorrect() {
		Device device = context.get(ContextConstants.DEVICE);
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		devicePlan.setExpiryDate(ConstantData.WORNG_EXPIRY);
		device.setExpirationDate(ConstantData.WORNG_EXPIRY);
		context.put(ContextConstants.DEVICE, device);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
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
		device.setOtherInfoEmailAlertRequired(deviceTemp.getOtherInfoEmailAlertRequired());
		device.setOtherInfoFaxNo(deviceTemp.getOtherInfoFaxNo());
		device.setOtherInfoPreferredLanguage(deviceTemp.getOtherInfoPreferredLanguage());
		device.setOtherInfoRegisteredEmailAddress(deviceTemp.getOtherInfoRegisteredEmailAddress());
		device.setOtherInfoRegisteredMobileNumber(deviceTemp.getOtherInfoRegisteredMobileNumber());
		device.setOtherInfoRegisterForDncr(deviceTemp.getOtherInfoRegisterForDncr());
		device.setOtherInfoSmsAlertRequired(deviceTemp.getOtherInfoSmsAlertRequired());
		device.setOtherInfoStatementPreference(deviceTemp.getOtherInfoStatementPreference());		
		sdnUncheckProgram(program.getProgramCode());
		deviceWorkflow.createDevice(device);
		context.put(ContextConstants.DEVICE, device);
	}
	
	@Given("\"$type\" is created with \"$application\" as application type with application sub-type as \"$applicationSubType\" and customer of type \"$customerType\" with \"$deviceType\"")
	@When("\"$type\" is created with \"$application\" as application type with application sub-type as \"$applicationSubType\" and customer of type \"$customerType\" with \"$deviceType\"")
	@Then("\"$type\" is created with \"$application\" as application type with application sub-type as \"$applicationSubType\" and customer of type \"$customerType\" with \"$deviceType\"")
	public void createDeviceWithDeviceAndProgramPlan(String type, String application, String applicationSubType, String customerType, String deviceType) {
		Device device = Device.createWithProvider(provider);

		device.setDeviceNumber(context.get(CreditConstants.DEVICE_NUMBER));

		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setApplicationType(application);
		device.setSubApplicationType(applicationSubType);
		device.setCustomerType(customerType);
		device.setDeviceType1(deviceType);

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

		if (device.getApplicationType().contains(ApplicationType.SUPPLEMENTARY_DEVICE) || device.getApplicationType().contains(ApplicationType.ADD_ON_DEVICE) && device.getSubApplicationType().contains(SubApplicationType.EXISTING_CLIENT)) {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		} else {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		}

		Assert.assertTrue("Application is not created successfully", deviceWorkflow.createDeviceUsingApplication(device));
		context.put(CreditConstants.APPLICATION, device);
	}
	
	@Given("\"$type\" is created with \"$application\" as application type with application sub-type as \"$applicationSubType\" and customer of type \"$customerType\" with \"$deviceType\" with $dedupe")
	@When("\"$type\" is created with \"$application\" as application type with application sub-type as \"$applicationSubType\" and customer of type \"$customerType\" with \"$deviceType\" with $dedupe")
	@Then("\"$type\" is created with \"$application\" as application type with application sub-type as \"$applicationSubType\" and customer of type \"$customerType\" with \"$deviceType\" with $dedupe")
	public void createDeviceWithDeviceAndProgramPlanWithDedupe(String type, String application, String applicationSubType, String customerType, String deviceType, String dedupe) {
		Device device = Device.createWithProvider(provider);
		device.setDeviceNumber(context.get(CreditConstants.DEVICE_NUMBER));
		device.setAppliedForProduct(ProductType.fromShortName(type));
		device.setApplicationType(application);
		device.setSubApplicationType(applicationSubType);
		device.setCustomerType(customerType);
		device.setDeviceType1(deviceType);
		device.setDedupe(dedupe);
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
		if (device.getApplicationType().contains(ApplicationType.SUPPLEMENTARY_DEVICE) || device.getApplicationType().contains(ApplicationType.ADD_ON_DEVICE) && device.getSubApplicationType().contains(SubApplicationType.EXISTING_CLIENT)) {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		} else {
			DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
			device.setDevicePlan1(devicePlan.buildDescriptionAndCode());
		}
		Assert.assertTrue("Application is not created successfully", deviceWorkflow.createDeviceUsingApplication(device));
		context.put(CreditConstants.APPLICATION, device);
	}
	
	
	
	@When("user selects secondary card for transaction")
	public void userSelectSecondaryCardForTrasaction(){
		//Code for saving primary device for future use
		DevicePlan primaryDevicePlan = context.get(ContextConstants.DEVICE_PLAN);
		Device primaryDevice = context.get(ContextConstants.DEVICE);
		context.put(ContextConstants.PRIMARY_DEVICE, primaryDevice);
		context.put(ContextConstants.PRIMARY_DEVICE_PLAN, primaryDevicePlan);
		
		//Override device with secondary device
		DevicePlan deviceplan = context.get(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY);
		Device device = context.get(ContextConstants.DEVICE_SUPPLEMENTARY_ADDON_EXISTING);
		context.put(ContextConstants.DEVICE_PLAN, deviceplan);
		context.put(ContextConstants.DEVICE, device);
	}
}
