package com.mastercard.pts.integrated.issuing.steps.customer.helpdesk;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.DeviceStatus;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.domain.customer.distribution.Dispatch;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ReversalTransaction;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ChangeAddressRequest;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.EventAndAlerts;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ServiceCode;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ServiceRequestDropDownValues;
import com.mastercard.pts.integrated.issuing.domain.provider.DataLoader;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.steps.UserManagementSteps;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk.HelpDeskFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk.HelpdeskWorkflow;

@Component
public class HelpDeskSteps {
	@Autowired
	HelpdeskGeneral helpdeskGeneral;

	@Autowired
	HelpdeskGeneralPage helpdeskPage;
	
	@Autowired
	DataLoader dataLoader;

	private BigDecimal currentBalanceAmount;
	private String beforeLoadBalanceInformation;
	private static final String STATUS_INCORRECT_INFO_MSG = "Device has incorrect status";
	private static final Logger logger = LoggerFactory.getLogger(ProcessBatchesPage.class);
	private String clientID;
	private String loginType="login";
	
	@Autowired
	private TestContext context;

	@Autowired
	private Navigator navigator;

	@Autowired
	private HelpdeskWorkflow helpdeskWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	HelpDeskFlows helpdeskFlows;

	@Autowired
	NewDevice newDevice;

	EventAndAlerts eventAndAlerts = new EventAndAlerts();

	ChangeAddressRequest changeAddressRequest;
	@Autowired
	HelpDeskGeneral helpdeskgettersetter;

	@Autowired
	DeviceCreation deviceCreation;

	@When("user navigates to General in Helpdesk")
	public void thenUserNavigatesToGeneralInHelpdesk() {
		helpdeskFlows.navigateToGeneralTab();
	}

	@When("user search for device on search screen for product type $debit")
	@Then("user search for device on search screen for product type $debit")
	public void thenUserSearchForDeviceOnSearchScreen(String productType) {
		helpdeskgettersetter.setProductType(ProductType.fromShortName(productType));
		helpdeskgettersetter.setDeviceNumber(MapUtils.fnGetInputDataFromMap("Device Number"));
		if (deviceCreation.getDeviceNumberFromQuery() != null) {
			helpdeskgettersetter.setDeviceNumber(deviceCreation.getDeviceNumberFromQuery());
		} else {
			helpdeskgettersetter.setDeviceNumber(newDevice.getDeviceNumber());
		}
		helpdeskFlows.searchForDevice(helpdeskgettersetter);

	}

	@When("user select the service code as $serviceCode")
	@Then("user select the service code as $serviceCode")
	public void thenUserSelectTheServiceCode(String serviceCode) {
		helpdeskgettersetter.setServiceCode(ServiceCode.fromShortName(serviceCode));
		helpdeskFlows.selectServiceCode(helpdeskgettersetter);
	}

	/**
	 * Step Definition for activating a device through HelpDesk
	 * <p>
	 * StoryFile usage : When user activates the device through HelpDesk
	 * <p>
	 */
	@When("user activates the device through HelpDesk")
	public void activate_device_helpdesk() {
		logger.info("Activating the device through HelpDesk");
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.activateDeviceHelpDeskFlows(helpdeskgettersetter);
	}

	/**
	 * Step Definition for verifying that an event is generated on activating a
	 * device
	 * <p>
	 * StoryFile usage : Then verify an event is generated on device activation
	 * through HelpDesk
	 * <p>
	 */
	@Then("verify an event is generated on device activation through Helpdesk")
	public void verify_event_activate_device() {
		logger.info("Verifying the Account Head is saved successfully in the system");
		helpdeskFlows.verifyActivateAccountEventGenerated();
	}

	@Then("User edit the $iframeName service Code with note $note")
	public void thenUserEditTheService(@Named("iframeName") String iframeName, @Named("note") String noteName) {
		helpdeskgettersetter.setNotes(noteName);
		helpdeskgettersetter.setEventsIFrameName(iframeName);
		helpdeskFlows.switchToNoteWindow(helpdeskgettersetter);
		helpdeskFlows.editServiceCodeForNoteWindow(helpdeskgettersetter);
		helpdeskFlows.endCallFlow();
	}

	@Then("user stoplist the device   ")
	public void thenUserStoplistTheDevice() {

	}

	@Then("user select the email address indicator to $indicator")
	public void selectemailaddressIndicator(@Named("indicator") String indicatorName) {
		helpdeskgettersetter.setEmailIndicator(indicatorName);
		helpdeskFlows.selelctEmailAddressIndicatorFlow(helpdeskgettersetter);
	}

	@Then("User edit the $Mailing Address service Code with email indicator to $Office and note to $Mailing")
	public void editMailingAddressServicesCode(@Named("Mailing Address") String iframeName, @Named("Office") String indicator, @Named("Mailing") String noteName) {

		helpdeskgettersetter.setNotes(noteName);
		helpdeskgettersetter.setEventsIFrameName(iframeName);
		helpdeskgettersetter.setEmailIndicator(indicator);
		helpdeskFlows.switchToNoteWindow(helpdeskgettersetter);
		helpdeskFlows.selelctEmailAddressIndicatorFlow(helpdeskgettersetter);
		helpdeskFlows.editServiceCodeForNoteWindow(helpdeskgettersetter);
		helpdeskFlows.endCallFlow();

	}

	@Then("User edit the $Stop list service Code for $reason with $note")
	public void thenUserEditTheServiceWithReason(@Named("Stop") String iframeName, @Named("note") String noteName, @Named("reason") String reason) {

		helpdeskgettersetter.setNotes(noteName);
		helpdeskgettersetter.setEventsIFrameName(iframeName);
		helpdeskgettersetter.setStopListReason(ServiceRequestDropDownValues.fromShortName(reason));
		helpdeskFlows.switchToNoteWindow(helpdeskgettersetter);
		helpdeskFlows.addReasonForStopListing(helpdeskgettersetter);
		helpdeskFlows.editServiceCodeForNoteWindow(helpdeskgettersetter);
		helpdeskFlows.endCallFlow();
	}

	/**
	 * Step Definition for activating email alerts through Helpdesk
	 * <p>
	 * StoryFile usage : When user activates the email alerts through HelpDesk
	 * <p>
	 */
	@When("user select the $email alerts as $Active")
	public void activate_email_alert_helpdesk(String type, String status) {
		logger.info("Activating the email alerts through helpdesk");
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.emailSMSAlertChangeFlows(type, status, helpdeskgettersetter);
	}

	/**
	 * Step Definition for linking a card query through helpdesk
	 * <p>
	 * StoryFile usage : When user links a card query through HelpDesk
	 * <p>
	 */
	@When("user links a card query through HelpDesk")
	public void link_card_query() {
		logger.info("Linking a card query through helpdesk");
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.linkCardQueryHelpDeskFlows(helpdeskgettersetter);
	}

	@Then("User edit the $International Use service Code of operation $Activate for Activation type $Life Long with note $Activated")
	public void thenUserEditTheServiceWithOperationAndReason(@Named("International") String iframeName, @Named("note") String noteName, @Named("Life") String activationType,
			@Named("Activate") String operation) {

		helpdeskgettersetter.setNotes(noteName);
		helpdeskgettersetter.setEventsIFrameName(iframeName);
		helpdeskgettersetter.setInternationActivationType(ServiceRequestDropDownValues.fromShortName(activationType));
		helpdeskgettersetter.setInternationalOperation(ServiceRequestDropDownValues.fromShortName(operation));
		helpdeskFlows.switchToNoteWindow(helpdeskgettersetter);
		helpdeskFlows.addReasonForStopListing(helpdeskgettersetter);
		helpdeskFlows.editServiceCodeForNoteWindow(helpdeskgettersetter);
		helpdeskFlows.endCallFlow();
	}

	/**
	 * Step Definition for adding a card to the Do Not Call Register
	 * <p>
	 * StoryFile usage : When user add the card into the Do Not Call Register
	 * through HelpDesk
	 * <p>
	 */
	@When("user add the card into the Do Not Call Register through HelpDesk")
	public void add_Card_To_Do_Not_Call_Register() {
		logger.info("Adding the card to the Do Not call register");
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.addCardToDoNotCallRegisterFlows(helpdeskgettersetter);
	}

	/**
	 * Step Definition for adding a call note through HelpDesk
	 * <p>
	 * StoryFile usage : When user adds call notes through HelpDesk
	 * <p>
	 */
	@When("user adds call notes through HelpDesk")
	public void adds_call_notes_through_HelpDesk() {
		logger.info("Adding call notes through helpdesk");
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.addCallNotesFlows(helpdeskgettersetter);
	}

	/**
	 * Step Definition for requesting an Add On Card through HelpDesk
	 * <p>
	 * StoryFile usage : When user requests for an Add On Card through HelpDesk
	 * <p>
	 */
	@When("user requests for an Add On Card through HelpDesk")
	public void requests_for_an_Add_On_Card() {
		logger.info("Adding call notes through helpdesk");
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		eventAndAlerts.setTitle(MapUtils.fnGetInputDataFromMap("Title"));
		eventAndAlerts.setFirstName(MapUtils.fnGetInputDataFromMap("FirstName"));
		eventAndAlerts.setEmbossedName(MapUtils.fnGetInputDataFromMap("Embossing Name"));
		eventAndAlerts.setFamilyName(MapUtils.fnGetInputDataFromMap("FamilyName"));
		eventAndAlerts.setRelation(MapUtils.fnGetInputDataFromMap("Relation"));
		helpdeskFlows.addOnCardFlows(eventAndAlerts);
	}

	/**
	 * Step Definition for requesting an Address Change through HelpDesk
	 * <p>
	 * StoryFile usage : When user requests for an address change through
	 * HelpDesk
	 * <p>
	 */
	@When("user requests for an address change through HelpDesk")
	public void requests_for_an_address_change() {
		logger.info("Changing the Address of the user");
		changeAddressRequest = new ChangeAddressRequest();
		changeAddressRequest.setAddressLine1(MapUtils.fnGetInputDataFromMap("AddressLine1"));
		changeAddressRequest.setCountry(MapUtils.fnGetInputDataFromMap("Country"));
		changeAddressRequest.setZipCode(MapUtils.fnGetInputDataFromMap("ZipCode"));
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		changeAddressRequest.setAddressLine2(MapUtils.fnGetInputDataFromMap("AddressLine2"));
		changeAddressRequest.setState(MapUtils.fnGetInputDataFromMap("State"));
		changeAddressRequest.setCity(MapUtils.fnGetInputDataFromMap("City"));

		helpdeskFlows.changeAddressRequestFlows(changeAddressRequest);
	}

	/**
	 * Step Definition for requesting activating immediately for n hours of
	 * E-Commerce
	 * <p>
	 * StoryFile usage : When user requests to activate immediately for n hours
	 * of e commerce
	 * <p>
	 */
	@When("user requests to $activate for $nhours for ecommerce")
	public void request_for_ecommerce_active(String status, String type) {
		logger.info("Activating the e-commerce for the user");
		eventAndAlerts.seteCommStatus(status);
		eventAndAlerts.seteCommType(type);
		eventAndAlerts.setErrorMessage(MapUtils.fnGetInputDataFromMap("ErrorMessage"));
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.activateECommFlows(eventAndAlerts);
	}

	/**
	 * Step Definition for requesting deactivating E-Commerce for the user
	 * <p>
	 * StoryFile usage : When And user requests to deactivates for e commerce
	 * <p>
	 */
	@When("user requests to $deactivates for e commerce")
	public void request_for_ecommerce_deactive(String status) {
		logger.info("Deactivating the immediately for n hours of e commerce");
		eventAndAlerts.seteCommStatus(status);
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.deactivateEcommerceFlows(eventAndAlerts);
	}

	@When("user defines the service code as $servicecode and creates $multiwallet wallets for $product card")
	public void createMultiWalletForCard(@Named("servicecode") String servicecode, @Named("multiwallet") String multiwallet, @Named("product") String product) {
		deviceCreation = new DeviceCreation();
		helpdeskgettersetter.setServiceCode(ServiceCode.fromShortName(servicecode));
		helpdeskgettersetter.setNoOfWallets(multiwallet);
		helpdeskgettersetter.setProductType(ProductType.fromShortName(product));
		deviceCreation.setCurrency(MapUtils.fnGetInputDataFromMap("MultiWalletCurrency"));
		helpdeskgettersetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.selectMultiWallet(helpdeskgettersetter, deviceCreation);
	}

	@Then("the prepaid card should be a multiwallet card")
	public void checkNoOfWalletsAdded() {
		logger.info("Multiwallet multicurrency card");
	}

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
		device.setExistingDeviceNumber(helpdeskGeneral.getDeviceNumber());
		device.setAppliedForProduct(ProductType.fromShortName(type));
		context.put(ContextConstants.DEVICE, device);
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
	}

	@Then("currency setup for $type device is done correctly and updated in wallet details tab")
	public void thenCurrencySetupForDeviceIsDoneCorrectlyAndUpdatedInWalletDetailsTab(String type) {
		Device device = new Device();
		device.setDeviceNumber(context.get(ContextConstants.DEVICE_NUMBER));
		device.setAppliedForProduct(ProductType.fromShortName(type));
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		assertTrue(helpdeskWorkflow.verifyCurrencySetupDoneCorrectly(helpdeskGeneral, device));
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

	@Given("user has wallet number information for $type device which is exsiting")
	@When("user has wallet number information for $type device which is exsiting")
	public void givenUserHasWalletNumberInformationForExsisting(String type) {
		Device device = Device.createWithProvider(provider);
		ReversalTransaction rt = ReversalTransaction.getProviderData(provider);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		device.setDeviceNumber(rt.getExistingDevice());
		device.setAppliedForProduct(ProductType.fromShortName(type));
		String walletNumber = helpdeskWorkflow.getWalletNumber(device);
		device.setWalletNumber(walletNumber);
		context.put(ContextConstants.DEVICE, device);
	}

	@Given("user has wallet balance information for $type device")
	@When("user has wallet balance information for $type device")
	public void givenUserHasWalletBalanceInformation(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		device.setAppliedForProduct(ProductType.fromShortName(type));
		beforeLoadBalanceInformation = helpdeskWorkflow.getWalletBalanceInformation(device);
	}

	@When("balance in helpdesk updated correctly for $type device")
	@Then("balance in helpdesk updated correctly for $type device")
	public void thenBalanceInHelpDeskUpdatedCorrectly(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		device.setAppliedForProduct(ProductType.fromShortName(type));
		assertTrue(helpdeskWorkflow.verifyBalanceUpdatedCorreclty(beforeLoadBalanceInformation, helpdeskGeneral.getTransactionDetails(), helpdeskWorkflow.getWalletBalanceInformation(device)));
	}

	@When("balance in helpdesk deducted correctly for $type device")
	@Then("balance in helpdesk deducted correctly for $type device")
	public void thenBalanceInHelpDeskDeductedCorrectly(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		device.setAppliedForProduct(ProductType.fromShortName(type));
		assertTrue(helpdeskWorkflow.verifyBalanceDeductedCorreclty(beforeLoadBalanceInformation, helpdeskGeneral.getTransactionDetails(), helpdeskWorkflow.getWalletBalanceInformation(device)));
	}

	@When("balance in helpdesk not changed for $type device")
	@Then("balance in helpdesk not changed for $type device")
	public void thenBalanceInHelpDeskNotChanged(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		device.setAppliedForProduct(ProductType.fromShortName(type));
		assertTrue(helpdeskWorkflow.verifyBalanceNotChanged(beforeLoadBalanceInformation, helpdeskWorkflow.getWalletBalanceInformation(device)));
	}

	@When("initial load balance in helpdesk updated correctly for $type device")
	@Then("initial load balance in helpdesk updated correctly for $type device")
	public void thenInitialLoadBalanceInHelpDeskUpdatedCorrectly(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		device.setAppliedForProduct(ProductType.fromShortName(type));
		assertTrue(helpdeskWorkflow.verifyInitialLoadBalanceUpdatedCorreclty(helpdeskGeneral.getInitialLoadTxnDetails(), helpdeskWorkflow.getWalletBalanceInformation(device)));
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

	@When("after transaction wallet balance amount for $type device is updated correctly")
	@Then("after transaction wallet balance amount for $type device is updated correctly")
	public void thenCheckCurrentWalletBalanceAmount(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		BigDecimal afterTrnBalanceAmount = helpdeskWorkflow.getWalletBalance(device);
		BigDecimal transactionAmount = new BigDecimal(device.getTransactionAmount());
		currentBalanceAmount = currentBalanceAmount.subtract(transactionAmount);
		assertEquals(currentBalanceAmount, afterTrnBalanceAmount);
	}

	@When("after transaction reversal wallet balance amount for $type device is updated correctly")
	@Then("after transaction reversal wallet balance amount for $type device is updated correctly")
	public void thenAfterTransactionReversalWalletBalanceAmount(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		BigDecimal afterTrnBalanceAmount = helpdeskWorkflow.getWalletBalance(device);
		assertEquals(currentBalanceAmount, afterTrnBalanceAmount);
	}

	@Then("user activates device through helpdesk")
	@Given("user activates device through helpdesk")
	@When("user activates device through helpdesk")
	public void whenUserActivatesDeviceThroughHelpDesk() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.activateDevice(helpdeskGeneral);
	}

	@Given("user setup device currency through helpdesk")
	@When("user setup device currency through helpdesk")
	public void whenUserSetupDeviceCurrencyThroughHelpDesk() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskWorkflow.getDeviceStatus(device);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.setupDeviceCurrency(helpdeskGeneral);
	}

	@Given("user sets up device currency through helpdesk for FileUpload")
	@When("user sets up device currency through helpdesk for FileUpload")
	public void whenUserSetupDeviceCurrencyThroughHelpDeskForFileUpload() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.setupDeviceCurrency(helpdeskGeneral);
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

	@Then("device has \"$deviceStatus\" status for non-default institution")
	public void thenDeviceHasNormalStatus(String deviceStatus) {
		String expectedStatus = DeviceStatus.fromShortName(deviceStatus);
		Device device = context.get(ContextConstants.DEVICE2);
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

	@Then("device activated and activation date is updated in general details")
	public void thenActivationDateIsUpdatedGeneralDetails() {
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.storeActivationDate();
		helpdeskWorkflow.clickEndCall();
		assertThat("Device has incorrect Activation Date", helpdeskWorkflow.activationDate(), equalTo(DateUtils.currentDateddMMyyyy()));
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

	@When("User search for device on search screen for product type $prepaid and validates the status as $NORMAL")
	public void thenUserSearchForDeviceOnSearchScreenPrepaid(String productType, String status) {
		helpdeskgettersetter.setProductType(ProductType.fromShortName(productType));

		String actualStatus = helpdeskFlows.searchForDevicePrepaid(helpdeskgettersetter);
		if (actualStatus.contains(status)) {
			Assert.assertTrue("status of newly created device is normal ", true);
		} else {
			Assert.assertTrue("status of newly created device is not normal ", false);
		}

	}

	@Then("User search for new device on search screen for $productType and validates the status as $NORMAL")
	@When("User search for new device on search screen for $productType and validates the status as $NORMAL")
	public void thenUserSearchForDeviceOnSearchScreen(String productType, String status) {
		helpdeskgettersetter.setProductType(ProductType.fromShortName(productType));

		String actualStatus = helpdeskFlows.searchForNewDevice(helpdeskgettersetter);
		if (actualStatus.contains(status)) {
			Assert.assertTrue("status of newly created device is normal ", true);
		} else {
			Assert.assertTrue("status of newly created device is not normal ", false);
		}

	}

	@Then("User search for new application on search screen for $productType and validates the status as $NORMAL")
	@When("User search for new application on search screen for $productType and validates the status as $NORMAL")
	public void thenUserSearchForApplicationOnSearchScreen(String productType, String status) {
		helpdeskgettersetter.setProductType(ProductType.fromShortName(productType));

		String actualStatus = helpdeskFlows.searchForNewApplication(helpdeskgettersetter);
		if (actualStatus.contains(status)) {
			Assert.assertTrue("status of newly created device is normal ", true);
		} else {
			Assert.assertTrue("status of newly created device is not normal ", false);
		}

	}

	@Then("currency setup for device")
	public void searchDevice() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		thenUserNavigatesToGeneralInHelpdesk();
		helpdeskWorkflow.searchByDeviceNumber(device);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.setupDeviceCurrency(helpdeskGeneral);
		device.setNewWalletNumber(helpdeskGeneral.getNewWalletNumber());
	}

	@Then("Expiry date should be calculated as per the flag configured at device plan")
	@When("User calculates the expiry date as oer the date configured at device plan")
	public void userCalculatesdate() {
		helpdeskFlows.verifyExpiryDate();
	}

	@Then("pair devices should be generated for each of the processed Device and the paired device should be inactive state")
	public void checkPaireddevice() {
		helpdeskFlows.VerifyPairedDeviceStatus();
	}

	@When("wallet to wallet transfer selected account")
	public void walletToWalletTransfer() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		thenUserNavigatesToGeneralInHelpdesk();
		helpdeskWorkflow.searchByDeviceNumber(device);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.walletToWalletTransfer(device);
	}

	@When("wallet to wallet transfer for general purpose account")
	public void walletToWalletFundTransfer() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		thenUserNavigatesToGeneralInHelpdesk();
		helpdeskWorkflow.searchByDeviceNumber(device);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.walletToWalletTransfer(device);
	}
	
	@When("user creates service request to reset cardholder $passwordType password for $cardType user")
	public void userCreateServiceRequestForLoginPassword(@Named("datasheet") String datasheet, String passwordType,String cardType ) {
		Map<String, String> reqMap = dataLoader.loadData(datasheet).get();
		for(Entry<String, String> entry: reqMap.entrySet()){
			clientID = entry.getValue();
			helpdeskWorkflow.searchByClientId(clientID,ProductType.fromShortName(cardType));
			helpdeskWorkflow.clickCustomerCareEditLink();
			
			if(passwordType.equalsIgnoreCase(loginType)){
				helpdeskWorkflow.resetCardholderLoginPassword(clientID);
			}else{
				helpdeskWorkflow.resetCardholderTranPassword(clientID);	
			}
		}
	}
	
	@When("user creates service request to change the registered mobile number [$serviceCode]")
	public void ServiceRequestForChangeRegisteredMobileNumber(String serviceCode) {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		String[] device = helpdeskWorkflow.getDeviceTypeAndNumber(context.get(UserManagementSteps.USER_INSTITUTION_SELECTED));
		helpdeskGeneral.setProductType(ProductType.fromShortName(device[0]));
		helpdeskGeneral.setDeviceNumber(device[1]);
		helpdeskGeneral.setServiceCode(serviceCode);
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.changeRegisteredMobileNo(helpdeskGeneral);
	}
	
	@When("user creates service request to change the registered Email ID [$serviceCode]")
	public void ServiceRequestForChangeRegisteredEmailID(String serviceCode) {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		String[] device = helpdeskWorkflow.getDeviceTypeAndNumber(context.get(UserManagementSteps.USER_INSTITUTION_SELECTED));
		helpdeskGeneral.setProductType(ProductType.fromShortName(device[0]));
		helpdeskGeneral.setDeviceNumber(device[1]);
		helpdeskGeneral.setServiceCode(serviceCode);
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.changeRegisteredEmailID(helpdeskGeneral);
	}
	
	@Then("user validates registered mobile number SR [$serviceCode] update screen with the required fields")
	public void registeredMobileNumberUpdateScreenValidation(String serviceCode) {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		String[] device = helpdeskWorkflow.getDeviceTypeAndNumber(context.get(UserManagementSteps.USER_INSTITUTION_SELECTED));
		helpdeskGeneral.setProductType(ProductType.fromShortName(device[0]));
		helpdeskGeneral.setDeviceNumber(device[1]);
		helpdeskGeneral.setDefaultWalletNumber(device[2]);
		helpdeskGeneral.setServiceCode(serviceCode);
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.validateRequiredFields(helpdeskGeneral);
	}
}
