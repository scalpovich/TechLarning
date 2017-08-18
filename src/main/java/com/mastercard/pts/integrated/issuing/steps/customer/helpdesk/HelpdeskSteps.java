package com.mastercard.pts.integrated.issuing.steps.customer.helpdesk;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.MathContext;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.DeviceStatus;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.distribution.Dispatch;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk.HelpdeskWorkflow;

@Component
public class HelpdeskSteps {
	private HelpdeskGeneral helpdeskGeneral;
	private BigDecimal currentBalanceAmount;
	private static final String STATUS_INCORRECT_INFO_MSG = "Device has incorrect status";

	@Autowired
	private TestContext context;

	@Autowired
	private Navigator navigator;

	@Autowired
	private HelpdeskWorkflow helpdeskWorkflow;

	@Autowired
	private KeyValueProvider provider;

	/*
	 * @param registeredType accepts two values "registered" and "notregistered"
	 */
	@Given("user fills General details with product $type and submits the form for $registeredType device")
	@When("user fills General details with product $type and submits the form for $registeredType device")
	public void whenUserFillsGeneralDetailsWithProductTypeAndSubmitsTheForm(String type, String registeredType) {
		Dispatch dispatch = context.get("DISPATCH");
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		helpdeskGeneral.setCardPackId(dispatch.getLastCardPackId());
		helpdeskWorkflow.setActiveDeviceNumberByCardPackId(helpdeskGeneral, registeredType);
		Device device = Device.createWithProvider(provider);
		device.setDeviceNumber(helpdeskGeneral.getDeviceNumber());
		device.setAppliedForProduct(ProductType.fromShortName(type));
		context.put(ContextConstants.DEVICE, device);
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
	}

	@Given("user has wallet number information for $type device")
	@When("user has wallet number information for $type device")
	public void givenUserHasWalletNumberInformation(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		String walletNumber = helpdeskWorkflow.getWalletNumber(device);
		device.setWalletNumber(walletNumber);
		context.put(ContextConstants.DEVICE, device);
	}

	@Given("user has current wallet balance amount information for $type device")
	@When("user has current wallet balance amount information for $type device")
	public void givenUserHasCurrentWalletBalanceAmountInformation(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		currentBalanceAmount = helpdeskWorkflow.getWalletBalance(device);
	}

	@Then("after balance enquiry wallet balance amount for $type device is updated correctly")
	public void thenAfterBEWalletBalanceAmount(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		BigDecimal currentBalanceAmountBET = helpdeskWorkflow.getWalletBalance(device);
		assertEquals(currentBalanceAmount, currentBalanceAmountBET);
	}

	@Then("after transaction wallet balance amount for $type device is updated correctly")
	public void thenCheckCurrentWalletBalanceAmount(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		BigDecimal afterTrnBalanceAmount = helpdeskWorkflow.getWalletBalance(device);
		BigDecimal transactionAmount = new BigDecimal(device.getTransactionAmount());
		MathContext mc = new MathContext(2);
		currentBalanceAmount = currentBalanceAmount.subtract(transactionAmount, mc);
		assertEquals(currentBalanceAmount, afterTrnBalanceAmount);
	}

	@Given("user activates device through helpdesk")
	@When("user activates device through helpdesk")
	public void whenUserActivatesDeviceThroughHelpDesk() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.activateDevice(helpdeskGeneral);
	}

	/*
	 * This method gets the device status using search product type and device
	 * number
	 */
	@When("device has \"$deviceStatus\" status")
	@Then("device has \"$deviceStatus\" status")
	public void thenDeviceHasStatus(String deviceStatus) {
		String expectedStatus = DeviceStatus.fromShortName(deviceStatus);
		Device device = context.get(ContextConstants.DEVICE);
		String actualStatus = helpdeskWorkflow.getDeviceStatus(device);
		assertThat(STATUS_INCORRECT_INFO_MSG, actualStatus, equalTo(expectedStatus));
	}

	/*
	 * This method gets the device status on the page without search product
	 * type and device number
	 */
	@Then("status should be $deviceStatus")
	public void thenStatusShouldBe(String deviceStatus) {
		String expectedStatus = DeviceStatus.fromShortName(deviceStatus);
		assertThat(STATUS_INCORRECT_INFO_MSG, helpdeskWorkflow.getDeviceNumberStatus(), equalTo(expectedStatus));
	}

	@Then("sale date is updated in general details")
	public void thenSaleDateIsUpdatedGeneralDetails() {
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.storeSaleDate();
		helpdeskWorkflow.clickEndCall();
		assertThat("Device has incorrect Sale Date", helpdeskWorkflow.saleDate(), equalTo(DateUtils.currentDateddMMyyyy()));
	}

	@Then("delivery date is updated in general details")
	public void thenDeliveryDateIsUpdatedGeneralDetails() {
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.storeDeliveryDate();
		helpdeskWorkflow.clickEndCall();
		assertThat("Device has incorrect Delivery Date", helpdeskWorkflow.deliveryDate(), equalTo(DateUtils.currentDateddMMyyyy()));
	}

	/*
	 * @param registeredType accepts two values "registered" and "notregistered"
	 */
	@When("activation of $registeredType device $deviceType is successful and activation date is updated")
	@Then("activation of $registeredType device $deviceType is successful and activation date is updated")
	public void thenActivationOfDeviceIsSuccessful(String registeredType, String deviceType) {
		Dispatch dispatch = context.get("DISPATCH");
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(deviceType));
		helpdeskGeneral.setCardPackId(dispatch.getLastCardPackId());
		helpdeskWorkflow.setActiveDeviceNumberByCardPackId(helpdeskGeneral, registeredType);
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.storeActivationDate();
		helpdeskWorkflow.clickEndCall();
		assertThat("Device has incorrect Activation Date", helpdeskWorkflow.activationDate(), equalTo(DateUtils.currentDateddMMyyyy()));
	}
}
