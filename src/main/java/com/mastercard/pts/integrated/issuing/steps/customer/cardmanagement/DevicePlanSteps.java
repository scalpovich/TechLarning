package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.DeviceType;
//import com.mastercard.pts.integrated.issuing.domain.CardType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DevicePlanFlows;

@Component
public class DevicePlanSteps {

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	DevicePlanFlows deviceplanflows;

	@Autowired
	Vendor vendor;

	@Autowired
	DevicePlan deviceplan;

	@Autowired
	private TestContext context;

	@When("user creates a Device Plan for $interchange for $cardType and $productType card,choose activation $activationMode and delivery mode $deliveryMode")
	public void whenUserCreatesADevicePlanForMastercardForProductPrepaidForDeviceTypeAsMagneticStripe(
			@Named("interchange") String association, @Named("cardType") String cardType,
			@Named("productType") String productType, @Named("activationMode") String activationMode,
			@Named("deliveryMode") String deliveryMode) {
		deviceplan.devicePlanDataprovider();
		deviceplan.setAssociation(association);
		deviceplan.setProductType(productType);
		deviceplan.setDeviceType(DeviceType.fromShortName(cardType));
		deviceplan.setEmbossiongVendor(vendor.getNewVendor());
		deviceplan.setActivationMode(activationMode);
		String devicePlan = "";
		devicePlan = deviceplanflows.createDevicePlan(deviceplan);
		Assert.assertNotNull(devicePlan);
		deviceplan.setDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, deviceplan);

	}

	@When("user wants to mandatory field validations on add device plan page")
	public void errorValidationStepforaddDevicePlan() {
		deviceplanflows.validateErrormsg();
	}

	@Given("User fills general details for $interchange for $cardType $productType card,choose activation $activationMode and delivery mode $deliveryMode")
	public void givenUserFillsGeneralDetails(@Named("interchange") String association,
			@Named("cardType") String cardType, @Named("productType") String productType,
			@Named("activationMode") String activationMode, @Named("deliveryMode") String deliveryMode) {
		deviceplan.devicePlanDataprovider();
		deviceplan.setAssociation(association);
		deviceplan.setProductType(productType);
		deviceplan.setDeviceType(cardType);
		deviceplan.setActivationMode(activationMode);
		deviceplan.setDeliveryMode(deliveryMode);
		deviceplan.setEmbossiongVendor(vendor.getNewVendor());
		String devicePlan = "";
		devicePlan = deviceplanflows.createDevicePlan(deviceplan);
		Assert.assertNotNull(devicePlan);
		deviceplan.setDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, deviceplan);

	}

	@When("user issues paired devices for $interchange for $cardType and $productType card,choose activation $activationMode and delivery mode $deliveryMode")
	public void whenUserIssuesPairedDevicesForMastercardForProductPrepaidForDeviceTypeAsMagneticStripe(
			@Named("interchange") String association, @Named("cardType") String cardType,
			@Named("productType") String productType, @Named("activationMode") String activationMode,
			@Named("deliveryMode") String deliveryMode) {
		deviceplan.devicePlanDataprovider();
		deviceplan.setAssociation(association);
		deviceplan.setProductType(productType);
		deviceplan.setDeviceType(cardType);
		deviceplan.setEmbossiongVendor(vendor.getNewVendor());
		deviceplan.setActivationMode(activationMode);
		String devicePlan = "";
		devicePlan = deviceplanflows.createDevicePlanforPairedDevices(deviceplan);
		Assert.assertNotNull(devicePlan);
		deviceplan.setDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, deviceplan);

	}

	@Given("fills authorization details")
	public void givenFillsAuthorizationDetails() {

	}
}