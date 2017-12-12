package com.mastercard.pts.integrated.issuing.steps.agent.services;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.agent.services.Checker;
import com.mastercard.pts.integrated.issuing.domain.agent.services.CurrencySetup;
import com.mastercard.pts.integrated.issuing.domain.agent.services.DeviceSale;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.distribution.Dispatch;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.agent.services.ServicesWorkflow;

@Component
public class ServicesSteps {
	private static final String APPLICATION_CREATED_MESSAGE = "created for this request.";
	private static final String DEVICE_MULTI_CURRENCY_SETUP_MSG = "Currency added successfully.";
	private static final String APPROVAL_MESSAGE = "Sucessfully completed.";
	private static final String FAILED_MESSAGE_INFO = "Page Load Failed";
	private static final String WITH = "with";
	private static final String WITH_OUT = "without";
		
	private Dispatch dispatch;
	private DeviceSale deviceSale;
	private Device device;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private ServicesWorkflow servicesWorkflow;

	@Autowired
	private KeyValueProvider provider;
	
	@When("user navigates to activate deactivate sub account page")
	public void whenUserNavigatesToActivateDeactiveSubAccountPage(){
		servicesWorkflow.navigateToActivateDeactivateSubAccountPage();
	}
	
	@Then("activate deactivate sub account page is loaded and master detail content title is $expectedTitleText")
	public void thenActivateDeactivateSubAccountPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getActivateDeactivateSubAccountMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to application correction page")
	public void whenUserNavigatesToApplicationCorrectionPage(){
		servicesWorkflow.navigateToApplicationCorrectionPage();
	}
	
	@Then("application correction page is loaded and master detail content title is $expectedTitleText")
	public void thenApplicationCorrectionPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getApplicationCorrectionMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to change currency priority page")
	public void whenUserNavigatesToChangeCurrencyPriorityPage(){
		servicesWorkflow.navigateToChangeCurrencyPriorityPage();
	}
	
	@Then("change currency priority page is loaded and master detail content title is $expectedTitleText")
	public void thenChangeCurrencyPrioriyPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getChangeCurrencyPriorityMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to checker page")
	public void whenUserNavigatesToCheckerPage(){
		servicesWorkflow.navigateToCheckerPage();
	}
	
	@Then("checker page is loaded and master detail content title is $expectedTitleText")
	public void thenCheckerPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getCheckerMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to currency setup page")
	public void whenUserNavigatesToCurrencySetupPage(){
		servicesWorkflow.navigateToCurrencySetupPage();
	}
	
	@Then("currency setup page is loaded and master detail content title is $expectedTitleText")
	public void thenCurrencySetupPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getCurrencySetupMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to dedupe reverification approval page")
	public void whenUserNavigatesToDedupeReverificationApprovalPage(){
		servicesWorkflow.navigateToDedupeReverificationApprovalPage();
	}
	
	@Then("dedupe reverification approval page is loaded and master detail content title is $expectedTitleText")
	public void thenDedupeReverificationApprovalPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getDedupeReverificationApprovalMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to device sale page")
	public void whenUserNavigatesToDeviceSalePage(){
		servicesWorkflow.navigateToDeviceSalePage();
	}
	
	@Then("device sale page is loaded and master detail content title is $expectedTitleText")
	public void thenDeviceSalePageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getDeviceSaleMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to instant device replacement page")
	public void whenUserNavigatesToInstantDeviceReplacementPage(){
		servicesWorkflow.navigateToInstantDeviceReplacementPage();
	}
	
	@Then("instant device replacement page is loaded and master detail content title is $expectedTitleText")
	public void thenInstantDeviceReplacementPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getInstantDeviceReplacementMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to kyc update page")
	public void whenUserNavigatesToKYCUpdatePage(){
		servicesWorkflow.navigateToKYCUpdatePage();
	}
	
	@Then("kyc update page is loaded and master detail content title is $expectedTitleText")
	public void thenKYCUpdatePageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getKYCUpdateMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to limited validity virtual card cancellation page")
	public void whenUserNavigatesToLimitedValidityVirtualCardCancellationPage(){
		servicesWorkflow.navigateToLimitedValidityVirtualCardCancellationPage();
	}
	
	@Then("limited validity virtual card cancellation page is loaded and master detail content title is $expectedTitleText")
	public void thenLimitedValidityVirtualCardCancellationPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, servicesWorkflow.getLimitedValidityVirtualCardCancellationMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
		
	@Given("user fills program details $type registration")
	@When("user fills program details $type registration")
	public void whenUserFillsProgramDetailsToRegister(String type){
		Program program = context.get(ContextConstants.PROGRAM);
		dispatch = context.get(ContextConstants.DISPATCH);
		deviceSale = DeviceSale.createWithProvider(provider);
		deviceSale.setProgram(program.buildDescriptionAndCode());
		deviceSale.setCardPackId(dispatch.getLastCardPackId());
		deviceSale.setFirstName("FN"+MiscUtils.randomAlphabet(6).toLowerCase());
		deviceSale.setLastName("LN"+MiscUtils.randomAlphabet(6).toLowerCase());
		if (WITH.equalsIgnoreCase(type))
			servicesWorkflow.deviceSaleWithRegistration(deviceSale);
		else if (WITH_OUT.equalsIgnoreCase(type))
			servicesWorkflow.deviceSaleWithoutRegistration(deviceSale);
	}
	
	@Given("user fills program details with new program for $productType product $deviceType device")
	@When("user fills program details with new program for $productType product $deviceType device")
	public void whenUserFillsProgramDetailsWithNewProgram(String productType, String deviceType){
		Program program = context.get(ContextConstants.PROGRAM);
		dispatch = context.get(ContextConstants.DISPATCH);
		deviceSale = DeviceSale.createWithProvider(provider);
		deviceSale.setProgram(program.buildDescriptionAndCode());
		deviceSale.setCardPackId(dispatch.getLastCardPackId());
		device = context.get(ContextConstants.DEVICE);
		String activeDeviceNumber = device.getExistingDeviceNumber();
		deviceSale.setPrimaryDeviceNumber(activeDeviceNumber);
		servicesWorkflow.deviceSaleThroughNewProgram(deviceSale);
	}
	
	@Given("user provides details through customer registration")
	@When("user provides details through customer registration")
	public void whenUserProvidesDetailsThroughCustomerRegistration(){
		servicesWorkflow.deviceSaleThroughCustomerRegistration(deviceSale);
	}
	
	
	@Then("registration is successful")
	public void thenRegistrationIsSuccessful(){
		assertThat("Registration Failed", servicesWorkflow.getApplicationCreatedMessage(), containsString(APPLICATION_CREATED_MESSAGE));
	}
	
	@Then("application creation is successful")
	public void thenApplicationCreationIsSuccessful(){
		assertThat("Application Creation Failed", servicesWorkflow.getApplicationCreatedSuccessMessage(), containsString(APPLICATION_CREATED_MESSAGE));
	}
	
	@Given("user fills card sale checker details and submits the form")
	@When("user fills card sale checker details and submits the form")
	public void whenuserFillsCardSaleCheckerDetailsAndSubmitsTheForm(){
		Checker checker = Checker.createWithProvider(provider);
		checker.setCardPackId(dispatch.getLastCardPackId());
		servicesWorkflow.cardSaleChecker(checker);
	}
	
	@Then("approval is successful")
	public void thenApprovalIsSuccessful(){
		assertThat("Approval Failed", servicesWorkflow.getApprovalMessage(), containsString(APPROVAL_MESSAGE));
	}
	
	@When("user setup multiple currency for device through agent portal")
	public void whenUserSetupMultipleCurrencyForDeviceThroughAgentPortal(){
		Device device = context.get(ContextConstants.DEVICE);
		CurrencySetup details = CurrencySetup.createWithProvider(provider);
		servicesWorkflow.setupCurrency(details, device);
	}
	
	@Then("currency setup for the device is successful")
	public void thenCurrencySetupForTheDeviceIsSuccessful(){
		assertThat("Currency Setup Failed", servicesWorkflow.getSuccessMessage(), containsString(DEVICE_MULTI_CURRENCY_SETUP_MSG));
	}
}