package com.mastercard.pts.integrated.issuing.steps.customer.helpdesk;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
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
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
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
	private static final String INCORRECT_BALANCE_OR_CREDIT_LIMIT = "Available balance/Credit limit does not match : ";
	private static final Logger logger = LoggerFactory.getLogger(ProcessBatchesPage.class);
	private String clientID;
	private String loginType = "login";

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
	HelpDeskGeneral helpDeskGetterSetter;

	@Autowired
	DeviceCreation deviceCreation;

	@When("user navigates to General in Helpdesk")
	public void thenUserNavigatesToGeneralInHelpdesk() {
		helpdeskFlows.navigateToGeneralTab();
	}

	@When("user search for device on search screen for product type $debit")
	@Then("user search for device on search screen for product type $debit")
	public void thenUserSearchForDeviceOnSearchScreen(String productType) {
		helpDeskGetterSetter.setProductType(ProductType.fromShortName(productType));
		helpDeskGetterSetter.setDeviceNumber(MapUtils.fnGetInputDataFromMap("Device Number"));
		if (deviceCreation.getDeviceNumberFromQuery() != null) {
			helpDeskGetterSetter.setDeviceNumber(deviceCreation.getDeviceNumberFromQuery());
		} else {
			helpDeskGetterSetter.setDeviceNumber(newDevice.getDeviceNumber());
		}
		helpdeskFlows.searchForDevice(helpDeskGetterSetter);

	}

	@When("user select the service code as $serviceCode")
	@Then("user select the service code as $serviceCode")
	public void thenUserSelectTheServiceCode(String serviceCode) {
		helpDeskGetterSetter.setServiceCode(ServiceCode.fromShortName(serviceCode));
		helpdeskFlows.selectServiceCode(helpDeskGetterSetter);
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
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.activateDeviceHelpDeskFlows(helpDeskGetterSetter);
	}

	/**
	 * Step Definition for verifying that an event is generated on activating a device
	 * <p>
	 * StoryFile usage : Then verify an event is generated on device activation through HelpDesk
	 * <p>
	 */
	@Then("verify an event is generated on device activation through Helpdesk")
	public void verify_event_activate_device() {
		logger.info("Verifying the Account Head is saved successfully in the system");
		helpdeskFlows.verifyActivateAccountEventGenerated();
	}

	@Then("User edit the $iframeName service Code with note $note")
	public void thenUserEditTheService(@Named("iframeName") String iframeName, @Named("note") String noteName) {
		helpDeskGetterSetter.setNotes(noteName);
		helpDeskGetterSetter.setEventsIFrameName(iframeName);
		helpdeskFlows.switchToNoteWindow(helpDeskGetterSetter);
		helpdeskFlows.editServiceCodeForNoteWindow(helpDeskGetterSetter);
		helpdeskFlows.endCallFlow();
	}

	@Then("user stoplist the device   ")
	public void thenUserStoplistTheDevice() {

	}

	@Then("user select the email address indicator to $indicator")
	public void selectemailaddressIndicator(@Named("indicator") String indicatorName) {
		helpDeskGetterSetter.setEmailIndicator(indicatorName);
		helpdeskFlows.selelctEmailAddressIndicatorFlow(helpDeskGetterSetter);
	}

	@Then("User edit the $Mailing Address service Code with email indicator to $Office and note to $Mailing")
	public void editMailingAddressServicesCode(@Named("Mailing Address") String iframeName, @Named("Office") String indicator, @Named("Mailing") String noteName) {

		helpDeskGetterSetter.setNotes(noteName);
		helpDeskGetterSetter.setEventsIFrameName(iframeName);
		helpDeskGetterSetter.setEmailIndicator(indicator);
		helpdeskFlows.switchToNoteWindow(helpDeskGetterSetter);
		helpdeskFlows.selelctEmailAddressIndicatorFlow(helpDeskGetterSetter);
		helpdeskFlows.editServiceCodeForNoteWindow(helpDeskGetterSetter);
		helpdeskFlows.endCallFlow();

	}

	@Then("User edit the $Stop list service Code for $reason with $note")
	public void thenUserEditTheServiceWithReason(@Named("Stop") String iframeName, @Named("note") String noteName, @Named("reason") String reason) {

		helpDeskGetterSetter.setNotes(noteName);
		helpDeskGetterSetter.setEventsIFrameName(iframeName);
		helpDeskGetterSetter.setStopListReason(ServiceRequestDropDownValues.fromShortName(reason));
		helpdeskFlows.switchToNoteWindow(helpDeskGetterSetter);
		helpdeskFlows.addReasonForStopListing(helpDeskGetterSetter);
		helpdeskFlows.editServiceCodeForNoteWindow(helpDeskGetterSetter);
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
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.emailSMSAlertChangeFlows(type, status, helpDeskGetterSetter);
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
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.linkCardQueryHelpDeskFlows(helpDeskGetterSetter);
	}

	@Then("User edit the $International Use service Code of operation $Activate for Activation type $Life Long with note $Activated")
	public void thenUserEditTheServiceWithOperationAndReason(@Named("International") String iframeName, @Named("note") String noteName, @Named("Life") String activationType,
			@Named("Activate") String operation) {

		helpDeskGetterSetter.setNotes(noteName);
		helpDeskGetterSetter.setEventsIFrameName(iframeName);
		helpDeskGetterSetter.setInternationActivationType(ServiceRequestDropDownValues.fromShortName(activationType));
		helpDeskGetterSetter.setInternationalOperation(ServiceRequestDropDownValues.fromShortName(operation));
		helpdeskFlows.switchToNoteWindow(helpDeskGetterSetter);
		helpdeskFlows.addReasonForStopListing(helpDeskGetterSetter);
		helpdeskFlows.editServiceCodeForNoteWindow(helpDeskGetterSetter);
		helpdeskFlows.endCallFlow();
	}

	/**
	 * Step Definition for adding a card to the Do Not Call Register
	 * <p>
	 * StoryFile usage : When user add the card into the Do Not Call Register through HelpDesk
	 * <p>
	 */
	@When("user add the card into the Do Not Call Register through HelpDesk")
	public void add_Card_To_Do_Not_Call_Register() {
		logger.info("Adding the card to the Do Not call register");
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.addCardToDoNotCallRegisterFlows(helpDeskGetterSetter);
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
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.addCallNotesFlows(helpDeskGetterSetter);
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
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
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
	 * StoryFile usage : When user requests for an address change through HelpDesk
	 * <p>
	 */
	@When("user requests for an address change through HelpDesk")
	public void requests_for_an_address_change() {
		logger.info("Changing the Address of the user");
		changeAddressRequest = new ChangeAddressRequest();
		changeAddressRequest.setAddressLine1(MapUtils.fnGetInputDataFromMap("AddressLine1"));
		changeAddressRequest.setCountry(MapUtils.fnGetInputDataFromMap("Country"));
		changeAddressRequest.setZipCode(MapUtils.fnGetInputDataFromMap("ZipCode"));
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		changeAddressRequest.setAddressLine2(MapUtils.fnGetInputDataFromMap("AddressLine2"));
		changeAddressRequest.setState(MapUtils.fnGetInputDataFromMap("State"));
		changeAddressRequest.setCity(MapUtils.fnGetInputDataFromMap("City"));

		helpdeskFlows.changeAddressRequestFlows(changeAddressRequest);
	}

	/**
	 * Step Definition for requesting activating immediately for n hours of E-Commerce
	 * <p>
	 * StoryFile usage : When user requests to activate immediately for n hours of e commerce
	 * <p>
	 */
	@When("user requests to $activate for $nhours for ecommerce")
	public void request_for_ecommerce_active(String status, String type) {
		logger.info("Activating the e-commerce for the user");
		eventAndAlerts.seteCommStatus(status);
		eventAndAlerts.seteCommType(type);
		eventAndAlerts.setErrorMessage(MapUtils.fnGetInputDataFromMap("ErrorMessage"));
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
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
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.deactivateEcommerceFlows(eventAndAlerts);
	}

	@When("user defines the service code as $servicecode and creates $multiwallet wallets for $product card")
	public void createMultiWalletForCard(@Named("servicecode") String servicecode, @Named("multiwallet") String multiwallet, @Named("product") String product) {
		deviceCreation = new DeviceCreation();
		helpDeskGetterSetter.setServiceCode(ServiceCode.fromShortName(servicecode));
		helpDeskGetterSetter.setNoOfWallets(multiwallet);
		helpDeskGetterSetter.setProductType(ProductType.fromShortName(product));
		deviceCreation.setCurrency(MapUtils.fnGetInputDataFromMap("MultiWalletCurrency"));
		helpDeskGetterSetter.setNoteText(MapUtils.fnGetInputDataFromMap("Notes"));
		helpdeskFlows.selectMultiWallet(helpDeskGetterSetter, deviceCreation);
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
	@When("currency setup for $type device is done correctly and updated in wallet details tab")
	public void thenCurrencySetupForDeviceIsDoneCorrectlyAndUpdatedInWalletDetailsTab(String type) {
		Device device = context.get(ContextConstants.DEVICE);
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
		device.setAppliedForProduct(ProductType.fromShortName(type));
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
		String walletinfo [] = beforeLoadBalanceInformation.split(",");	
		walletinfo=walletinfo[0].split(":");		
		logger.info("Wallet Number : "+walletinfo[2]);
		device.setWalletNumber(walletinfo[2]);	
		context.put(ContextConstants.DEVICE,device);
	}

	@When("balance in helpdesk updated correctly for $type device")
	@Then("balance in helpdesk updated correctly for $type device")
	public void thenBalanceInHelpDeskUpdatedCorrectly(String type) {
		Device device = context.get(ContextConstants.DEVICE);
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.setProductType(ProductType.fromShortName(type));
		device.setAppliedForProduct(ProductType.fromShortName(type));		
		assertTrue(helpdeskWorkflow.verifyBalanceUpdatedCorreclty(beforeLoadBalanceInformation, helpdeskGeneral.getTransactionDetails(), helpdeskWorkflow.getWalletBalanceInformation(device)));	
		beforeLoadBalanceInformation = helpdeskWorkflow.getWalletBalanceInformation(device);	
		logger.info("beforeLoadBalanceInformation: "+beforeLoadBalanceInformation.toString());	
		/*It returns the wallet info from helpdesk
		walletinfo[1] contains card-number and currency
		 where walletinfo[2] contains wallet number and amount
		*/	
		logger.info("beforeLoadBalanceInformation : "+beforeLoadBalanceInformation);
		String[] walletinfo = beforeLoadBalanceInformation.split(",");		
		walletinfo=walletinfo[0].split(":");		
		logger.info("Wallet Number : "+walletinfo[2]);
		device.setWalletNumber(walletinfo[2]);	
		context.put(ContextConstants.DEVICE,device);
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
		context.put(ContextConstants.AVAILABLE_BALANCE_OR_CREDIT_LIMIT, currentBalanceAmount);
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
	
	@Then("user activates $limittype credit limit change request")
	@Given("user activates $limittype credit limit change request")
	@When("user activates $limittype credit limit change request")
	public void whenUserActivatesCreditLimitChangeRequestThroughHelpdesk(String limittype) {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskWorkflow.clickCustomerCareEditLink();		
		context.put(ContextConstants.AVAILABLE_BALANCE_OR_CREDIT_LIMIT, helpdeskWorkflow.activateCreditLimitChangeRequest(helpdeskGeneral));
	}
	
	@Given("user notes down available $type limit for card")
	@When("user notes down available $type limit for card")
	@Then("user notes down available $type limit for card")
	public void whenUserNotesDownLimitThroughHelpDesk(String type) {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		context.put(ContextConstants.AVAILABLE_BALANCE_OR_CREDIT_LIMIT, helpdeskWorkflow.noteDownAvailableLimit(type,device));
	}
	
	
	
	@Given("user verify available $type limit for card after transaction")
	@When("user verify available $type limit for card after transaction")
	@Then("user verify available $type limit for card after transaction")
	public void whenUserVerifyLimitThroughHelpDesk(String type) {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);		
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (helpdeskWorkflow.noteDownAvailableLimit(type,device)), equalTo(context.get(ContextConstants.AVAILABLE_BALANCE_OR_CREDIT_LIMIT)));
	}
	
	@Given("user verify $limittype credit limit for $type product")
	@When("user verify $limittype credit limit for $type product")
	@Then("user verify $limittype credit limit for $type product")
	public void whenUserVerifyAvailableBalance(String type,String limittype){
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		helpdeskGeneral.getClientCreditLimit();
		Device device = context.get(ContextConstants.DEVICE);
		LinkedList<BigDecimal> creditLimit = helpdeskWorkflow.noteDownCreditLimit(type, device);
		BigDecimal updatedAvailableBal = context.get(ContextConstants.AVAILABLE_BALANCE_OR_CREDIT_LIMIT);
		BigDecimal transactionAmount= context.get(ConstantData.TRANSACTION_AMOUNT_BD);
		updatedAvailableBal = updatedAvailableBal.subtract(transactionAmount);
		if(ContextConstants.CREDIT_LIMIT_TEMP.equalsIgnoreCase(limittype)){
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(0)), equalTo(updatedAvailableBal));
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(1)), equalTo(updatedAvailableBal));
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(2)), equalTo(updatedAvailableBal));
		}
		else{
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(0)), equalTo(updatedAvailableBal));
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(1)), equalTo(updatedAvailableBal));
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(2)), equalTo(updatedAvailableBal));
		String clientCreditLimit =helpdeskGeneral.getClientCreditLimit()+".00";
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(3)), equalTo(new BigDecimal(clientCreditLimit)));
		String accountCreditLimit=helpdeskGeneral.getAccountCreditLimit()+".00";
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(4)), equalTo(new BigDecimal(accountCreditLimit)));
		String cardCreditLimit=helpdeskGeneral.getNewCreditLimit()+".00";
		assertThat(INCORRECT_BALANCE_OR_CREDIT_LIMIT, (creditLimit.get(5)), equalTo(new BigDecimal(cardCreditLimit)));
		}
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
	 * This method gets the device status using search product type and device number
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
	 * This method gets the device status on the page without search product type and device number
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
		helpDeskGetterSetter.setProductType(ProductType.fromShortName(productType));
		List<String>deviceNumbers=context.get(ContextConstants.ALL_DEVICE_NUMBERS);
		
		for (int i = 0; i < deviceNumbers.size(); i++) {
			String actualStatus = helpdeskFlows.searchForDevicePrepaid(helpDeskGetterSetter, deviceNumbers.get(i));
			if (actualStatus.contains(status)) {
				Assert.assertTrue("status of newly created device is normal ", true);
			} else {
				Assert.assertTrue("status of newly created device is not normal ", false);
			}
		}

	}

	@Then("User search for new device on search screen for $productType and validates the status as $NORMAL")
	@When("User search for new device on search screen for $productType and validates the status as $NORMAL")
	public void thenUserSearchForDeviceOnSearchScreen(String productType, String status) {		
		Device device = context.get(ContextConstants.DEVICE);
		helpDeskGetterSetter.setDeviceNumber(device.getDeviceNumber());	
		helpDeskGetterSetter.setProductType(ProductType.fromShortName(productType));
		
		if (helpdeskFlows.searchForNewDevice(helpDeskGetterSetter).contains(status)) {
			Assert.assertTrue("status of newly created device is normal ", true);
		} else {
			Assert.assertTrue("status of newly created device is not normal ", false);
		}
	}
	
	@Then("User search for new device Supplementary on search screen for $productType and validates the status as $NORMAL")
	@When("User search for new device Supplementary on search screen for $productType and validates the status as $NORMAL")
	public void thenUserSearchForDeviceOnSearchScreenForSupplementary(String productType, String status) {
		helpDeskGetterSetter.setProductType(ProductType.fromShortName(productType));
		List<String>deviceNumbers=context.get(CreditConstants.SUPPLEMENTARY_DEVICE_NUMBER);
		for(String deviceNumber:deviceNumbers)
        {
        	helpDeskGetterSetter.setDeviceNumber(deviceNumber);
        	String actualStatus = helpdeskFlows.searchForNewDevice(helpDeskGetterSetter);
    		if (actualStatus.contains(status)) {
    			Assert.assertTrue("status of newly created device is normal ", true);
    		} else {
    			Assert.assertTrue("status of newly created device is not normal ", false);
    		}    
    	}
	}


	@Then("User search for new application on search screen for $productType and validates the status as $NORMAL")
	@When("User search for new application on search screen for $productType and validates the status as $NORMAL")
	public void thenUserSearchForApplicationOnSearchScreen(String productType, String status) {
		helpDeskGetterSetter.setProductType(ProductType.fromShortName(productType));
		String actualStatus = null;
		
		if(Integer.parseInt(context.get(CreditConstants.QUANTITY_REQUESTED))>1){
			
			List<String> devices = context.get(CreditConstants.DEVICE_NUMBER);
		
			for(String ele : devices){
				helpDeskGetterSetter.setDeviceNumber(ele);
				actualStatus = helpdeskFlows.searchForNewApplication(helpDeskGetterSetter);
			}
			
		}else{
			helpDeskGetterSetter.setDeviceNumber(context.get(CreditConstants.DEVICE_NUMBER));
			actualStatus = helpdeskFlows.searchForNewApplication(helpDeskGetterSetter);
		}
		
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
	public void userCreateServiceRequestForLoginPassword(@Named("datasheet") String datasheet, String passwordType, String cardType) {
		Map<String, String> reqMap = dataLoader.loadData(datasheet).get();
		for (Entry<String, String> entry : reqMap.entrySet()) {
			clientID = entry.getValue();
			helpdeskWorkflow.searchByClientId(clientID, ProductType.fromShortName(cardType));
			helpdeskWorkflow.clickCustomerCareEditLink();

			if (passwordType.equalsIgnoreCase(loginType)) {
				helpdeskWorkflow.resetCardholderLoginPassword(clientID);
			} else {
				helpdeskWorkflow.resetCardholderTranPassword(clientID);
			}
		}
	}
	
	@When("user creates service request to change the registered mobile number")
	public void changeRegisteredMobileNumber() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Optional<String[]> device = helpdeskWorkflow.getDeviceTypeAndNumber(context.get(UserManagementSteps.USER_INSTITUTION_SELECTED));
		if(device.isPresent()){
		helpdeskGeneral.setProductType(ProductType.fromShortName(device.get()[0]));
		helpdeskGeneral.setDeviceNumber(device.get()[1]);
		}
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.changeRegisteredMobileNo(helpdeskGeneral);
	}

	@When("user creates service request to change the registered Email ID")
	public void changeRegisteredEmailID() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Optional<String[]> device = helpdeskWorkflow.getDeviceTypeAndNumber(context.get(UserManagementSteps.USER_INSTITUTION_SELECTED));
		if(device.isPresent()){
		helpdeskGeneral.setProductType(ProductType.fromShortName(device.get()[0]));
		helpdeskGeneral.setDeviceNumber(device.get()[1]);
		}
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.changeRegisteredEmailID(helpdeskGeneral);
	}
	
	@Then("user validates registered mobile number SR screen with the required fields")
	public void registeredMobileNumberUpdateScreenValidation() {
		helpdeskGeneral = HelpdeskGeneral.createWithProvider(provider);
		Optional<String[]> device = helpdeskWorkflow.getDeviceTypeAndNumber(context.get(UserManagementSteps.USER_INSTITUTION_SELECTED));
		if(device.isPresent()){
		helpdeskGeneral.setProductType(ProductType.fromShortName(device.get()[0]));
		helpdeskGeneral.setDeviceNumber(device.get()[1]);
		helpdeskGeneral.setDefaultWalletNumber(device.get()[2]);
		}
		helpdeskWorkflow.searchWithDeviceNumber(helpdeskGeneral);
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.validateRequiredFields(helpdeskGeneral);
	}
	
	@Then("For fileUpload when user search for new application on search screen for $productType and validates the status as $NORMAL")
	@When("For fileUpload when user search for new application on search screen for $productType and validates the status as $NORMAL")
	public void thenUserSearchForApplicationOnSearchScreenforFileUpload(String productType, String status) {
		helpDeskGetterSetter.setProductType(ProductType.fromShortName(productType));
		helpdeskFlows.searchForNewApplicationFileUpload(helpDeskGetterSetter);
	}
<<<<<<< HEAD
}
=======
	
	
	@Then("user creates service request for $serviceCode service")
	@When("user creates service request for $serviceCode service")
	public void whenUserResetPinRetryCounterThroughHelpDesk(String serviceCode) {
		helpdeskGeneral.setServiceCode(serviceCode);			// Service Code e.g : Activate Device [108]
		helpdeskGeneral.setNotes(MiscUtils.generateRandomNumberAsString(6));
		helpdeskWorkflow.clickCustomerCareEditLink();
		helpdeskWorkflow.resetPinCounter(helpdeskGeneral);
	}
}
>>>>>>> d0e30eb5a8a4a2f6032eab20c527465852b84919
