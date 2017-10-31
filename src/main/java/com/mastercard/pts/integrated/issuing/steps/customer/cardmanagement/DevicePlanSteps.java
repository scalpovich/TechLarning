package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	@When("user creates a Device Plan for $interchange for $cardType and $productType card,choose activation $activationMode and delivery mode $deliveryMode")
	public void whenUserCreatesADevicePlanForMastercardForProductPrepaidForDeviceTypeAsMagneticStripe(
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
		devicePlan = deviceplanflows.createDevicePlan(deviceplan);
		Assert.assertNotNull(devicePlan);
		deviceplan.setDevicePlan(devicePlan);

	}

	@When("user save device plan")
	public void whenUserSaveDevicePlan() {

	}

	@Given("fills enter Event base fee plans,Joining Membership plan and transaction plan")
	public void givenFillsEnterEventBaseFeePlansJoiningMembershipPlanAndTransactionPlan() {

	}

	@Then("user should be able to create device plan suucessfully")
	public void thenUserShouldBeAbleToCreateDevicePlanSuucessfully() {

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

	}

	@Given("fills authorization details")
	public void givenFillsAuthorizationDetails() {

	}
}