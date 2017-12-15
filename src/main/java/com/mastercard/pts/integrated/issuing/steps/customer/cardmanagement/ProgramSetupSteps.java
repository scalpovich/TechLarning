package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.DeviceType;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationBusinessMandatoryFields;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationDocumentChecklist;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardBillingCycle;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardPaymentBounceReason;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardPaymentPriority;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardTransactionRulePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DedupePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePriorityPassIDAndCardPackIDTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCRulePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramSetupWorkflow;

@Component
public class ProgramSetupSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private ProgramSetupWorkflow programSetupWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private DataProvider dataProvider;

	private DeviceJoiningAndMemberShipFeePlan deviceJoiningAndMemberShipFeePlan;

	private DeviceEventBasedFeePlan deviceEventBasedFeePlan;

	private CreditCardTransactionRulePlan transactionRulePlanTestDataObject;

	private CreditCardPaymentPriority paymentPrioritytestDataObject;

	private StatementMessagePlan statementMessagePlan;

	private TransactionPlan transactionPlan;

	private TransactionLimitPlan transactionLimitPlan;

	private WalletPlan walletPlan;

	private MarketingMessagePlan marketingMessagePlan;

	private CreditCardCreditPlan creditCardCreditPlan;

	private CreditCardBillingCycle creditCardBillingCycle;

	private DevicePlan devicePlan;

	private Program program;

	private DevicePriorityPassIDAndCardPackIDTemplate cardPackIDTemplate;

	private DevicePriorityPassIDAndCardPackIDTemplate deviceTemplate;

	private DedupePlan dedupePlan;

	private ApplicationDocumentChecklist documentCheckListPlan;

	private MCCRulePlan mccRulePlan;

	private PrepaidStatementPlan prepaidStatementPlan;
	
	@When("prepaid $deviceType device is available with balance amount")
	@Given("prepaid $deviceType device is available with balance amount")
	@Composite(steps = { 
			"When User fills Statement Message Plan for prepaid product", 
			"When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan", 
			"When User fills MCC Rules for prepaid product", 
			"When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product", 
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", 
			"When User fills Device Joining and Membership Fee Plan for prepaid product", 
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", 
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product", 
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", 
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid", 
			"When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid", 
			"When user sign out from customer portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agency and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as admin user", 
			"When user fills information to assign program to branch and submits form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agent and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as agency user", 
			"When user fills order details and submits the form", 
			"When user sign out from agent portal",
			"When user is logged in institution", 
			"When user fills quantity to be dispatched and submits the form", 
			"When user sign out from customer portal",
			"When user is logged in agent portal as agency user", 
			"When user fills the order acceptance details and submits the form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user", 
			"When user fills program details with registration",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user",
			"When user fills card sale checker details and submits the form", 
			"When user sign out from agent portal", 
			"When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device", 
			"When user activates device through helpdesk",
			"When user has wallet number information for prepaid device",
			"When user performs adjustment transaction" })
	public void givenPrepaidCardIsAvailableWithAmount(String deviceType) {
		/*
		 * This is a composite step to be executed before assigning a program
		 */
	}
	
	@When("user fills data for prepaid device $deviceType and registers with new program")
	@Composite(steps = { 
			"When User fills Statement Message Plan for prepaid product", 
			"When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan", 
			"When User fills MCC Rules for prepaid product", 
			"When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product", 
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", 
			"When User fills Device Joining and Membership Fee Plan for prepaid product", 
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", 
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product", 
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", 
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid", 
			"When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid", 
			"When user sign out from customer portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agency and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as admin user", 
			"When user fills information to assign program to branch and submits form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agent and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as agency user", 
			"When user fills order details and submits the form", 
			"When user sign out from agent portal",
			"When user is logged in institution", 
			"When user fills quantity to be dispatched and submits the form", 
			"When user sign out from customer portal",
			"When user is logged in agent portal as agency user", 
			"When user fills the order acceptance details and submits the form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user", 
			"When user fills program details with new program for prepaid product emv device",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user",
			"When user fills card sale checker details and submits the form", 
			"When user sign out from agent portal", 
			"When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device", 
			"When user activates device through helpdesk"})
	public void whenUserFillsDataForPrepaidDeviceAndRegistersWithNewProgram(String deviceType) {
		/*
		 * This is a composite step for creating prepaid device and activating it
		 */
	}
	
	@When("user fills data for prepaid device $deviceType without registration and with customer registration")
	@Composite(steps = { 
			"When User fills Statement Message Plan for prepaid product", 
			"When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan", 
			"When User fills MCC Rules for prepaid product", 
			"When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product", 
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", 
			"When User fills Device Joining and Membership Fee Plan for prepaid product", 
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", 
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product", 
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", 
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid", 
			"When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid", 
			"When user sign out from customer portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agency and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as admin user", 
			"When user fills information to assign program to branch and submits form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agent and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as agency user", 
			"When user fills order details and submits the form", 
			"When user sign out from agent portal",
			"When user is logged in institution", 
			"When user fills quantity to be dispatched and submits the form", 
			"When user sign out from customer portal",
			"When user is logged in agent portal as agency user", 
			"When user fills the order acceptance details and submits the form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user", 
			"When user fills program details without registration",
			"When user provides details through customer registration",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user",
			"When user fills card sale checker details and submits the form", 
			"When user sign out from agent portal", 
			"When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device", 
			"When user activates device through helpdesk"})
	public void whenUserFillsDataForPrepaidDeviceWithOutRegistrationAndWithCustomerRegistration(String deviceType) {
		/*
		 * This is a composite step for creating prepaid device and activating it
		 */
	}
	
	@When("user fills data for prepaid device $deviceType without registration")
	@Composite(steps = { 
			"When User fills Statement Message Plan for prepaid product", 
			"When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan", 
			"When User fills MCC Rules for prepaid product", 
			"When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product", 
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", 
			"When User fills Device Joining and Membership Fee Plan for prepaid product", 
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", 
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product", 
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", 
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid", 
			"When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid", 
			"When user sign out from customer portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agency and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as admin user", 
			"When user fills information to assign program to branch and submits form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agent and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as agency user", 
			"When user fills order details and submits the form", 
			"When user sign out from agent portal",
			"When user is logged in institution", 
			"When user fills quantity to be dispatched and submits the form", 
			"When user sign out from customer portal",
			"When user is logged in agent portal as agency user", 
			"When user fills the order acceptance details and submits the form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user", 
			"When user fills program details without registration",
			"When user sign out from agent portal", 
			"When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for notregistered device"})
	public void whenUserFillsDataForPrepaidDeviceWithOutRegistration(String deviceType) {
		/*
		 * This is a composite step for creating prepaid device and activating it
		 */
	}
	
	@When("user fills data for prepaid device $deviceType with registration and activates the device")
	@Composite(steps = { 
			"When User fills Statement Message Plan for prepaid product", 
			"When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan", 
			"When User fills MCC Rules for prepaid product", 
			"When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product", 
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", 
			"When User fills Device Joining and Membership Fee Plan for prepaid product", 
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", 
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product", 
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", 
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid", 
			"When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid", 
			"When user sign out from customer portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agency and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as admin user", 
			"When user fills information to assign program to branch and submits form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agent and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as agency user", 
			"When user fills order details and submits the form", 
			"When user sign out from agent portal",
			"When user is logged in institution", 
			"When user fills quantity to be dispatched and submits the form", 
			"When user sign out from customer portal",
			"When user is logged in agent portal as agency user", 
			"When user fills the order acceptance details and submits the form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user", 
			"When user fills program details with registration",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agent user",
			"When user fills card sale checker details and submits the form", 
			"When user sign out from agent portal", 
			"When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device", 
			"When user activates device through helpdesk"})
	public void whenUserFillsDataForPrepaidDeviceWithRegistrationAndActivatesTheDevice(String deviceType) {
		/*
		 * This is a composite step for creating prepaid device and activating it
		 */
	}

	@Given("prepaid $deviceType device without pin is available with balance amount")
	@Composite(steps = { 
			"When User fills Statement Message Plan for prepaid product", 
			"When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan", 
			"When User fills MCC Rules for prepaid product", 
			"When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product", 
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", 
			"When User fills Device Joining and Membership Fee Plan for prepaid product", 
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin",
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product", 
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", 
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid", 
			"When processes device production batch for prepaid",
			"When user sign out from customer portal", 
			"When user is logged in agent portal as admin user", 
			"When user fills information to assign program to agency and submits form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to branch and submits form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as admin user",
			"When user fills information to assign program to agent and submits form",
			"When user sign out from agent portal", 
			"When user is logged in agent portal as agency user",
			"When user fills order details and submits the form",
			"When user sign out from agent portal",
			"When user is logged in institution", 
			"When user fills quantity to be dispatched and submits the form",
			"When user sign out from customer portal",
			"When user is logged in agent portal as agency user",
			"When user fills the order acceptance details and submits the form", 
			"When user sign out from agent portal",
			"When user is logged in agent portal as agent user",
			"When user fills program details with registration",
			"When user sign out from agent portal",
			"When user is logged in agent portal as agent user", 
			"When user fills card sale checker details and submits the form",
			"When user sign out from agent portal",
			"When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device",
			"When user activates device through helpdesk",
			"When user has wallet number information for prepaid device",
			"When user performs adjustment transaction" })
	public void givenPrepaidCardIsAvailableWithAmountWithNoPin(String deviceType) {
		/*
		 * This is a composite step to be executed before assigning a program
		 */
	}

	@When("device range for program with device plan for \"debit\" \"$deviceType\" card")
	@Given("device range for program with device plan for \"debit\" \"$deviceType\" card")
	@Composite(steps = { 
			"When User fills Dedupe Plan", 
			"When User fills MCC Rules for debit product", 
			"When User fills Transaction Plan for debit product",
			"When User fills Transaction Limit Plan for debit product", 
			"When User fills Document Checklist Screen for debit product",
			"When User fills Device Joining and Membership Fee Plan for debit product", 
			"When User fills Device Event Based Fee Plan for debit product",
			"When User fills Device Plan for \"debit\" \"<deviceType>\" card", 
			"When User fills Wallet Plan for debit product",
			"When User fills Program section for debit product", 
			"When User fills Business Mandatory Fields Screen for debit product",
			"When User fills Device Range section for debit product" })
	public void givenDeviceRangeForDebitProgramWithDevicePlan(String deviceType) {
		// composite step
	}

	@When("device range for program with device plan for \"debit\" \"$deviceType\" card without pin")
	@Given("device range for program with device plan for \"debit\" \"$deviceType\" card without pin")
	@Composite(steps = { 
			"When User fills Dedupe Plan", 
			"When User fills MCC Rules for debit product", 
			"When User fills Transaction Plan for debit product",
			"When User fills Transaction Limit Plan for debit product", 
			"When User fills Document Checklist Screen for debit product",
			"When User fills Device Joining and Membership Fee Plan for debit product", 
			"When User fills Device Event Based Fee Plan for debit product",
			"When User fills Device Plan for \"debit\" \"<deviceType>\" card with no pin", 
			"When User fills Wallet Plan for debit product",
			"When User fills Program section for debit product", 
			"When User fills Business Mandatory Fields Screen for debit product",
			"When User fills Device Range section for debit product" })
	public void givenDeviceRangeForDebitProgramWithDevicePlanWithOutPin(String deviceType) {
		// composite step
	}

	@Given("$deviceType card has gone through pre-production, production and pin generation")
	@Composite(steps = { "When user creates new device of $deviceType type for new client", "When processes pre-production batch for $deviceType",
			"When processes device production batch for $deviceType", "When processes pin generation batch for $deviceType" })
	public void givenDeviceGoesThroughPreproductionAndProductionAndPinGeneration(String deviceType) {
		// composite step
	}

	@Given("user performs activate device and adjustment transaction for $type card")
	@Composite(steps = { "When user fills General details with product $type and submits the form", "When user activates device through help desk",
			"When activation of  $type device is successful and activation date is updated", "When user performs adjustment transaction" })
	public void givenDeviceGoesCardActivationAndAdjustmentTranasaction(String type) {
		// composite step
	}

	@When("data in embossing file and pin offset file are generated successfully and PIN is retrieved successfully")
	@Given("data in embossing file and pin offset file are generated successfully and PIN is retrieved successfully")
	@Composite(steps = { 
			"When embossing file batch was generated in correct format", 
			"When Pin Offset file batch was generated successfully",
			"When PIN is retrieved successfully with data from Pin Offset File", 
			"When FinSim simulator is closed" })
	public void readDatafromEmbossingFileAndPinOffsetFile() {
		// composite step
	}
	
	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card without pin")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan", "When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product", "When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", "When User fills Device Joining and Membership Fee Plan for prepaid product",
			"When User fills Device Event Based Fee Plan for prepaid product", "When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin",
			"When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product" })
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidWithoutPin(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan", "When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product", "When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", "When User fills Device Joining and Membership Fee Plan for prepaid product",
			"When User fills Device Event Based Fee Plan for prepaid product", "When User fills Device Plan for \"prepaid\" \"<deviceType>\" card",
			"When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product" })
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaid(String deviceType) {
		// composite step
	}

	@When("User fills Statement Message Plan for $type product")
	public void whenUserFillsStatementMessagePlanForProductType(String type) {
		statementMessagePlan = StatementMessagePlan.generateDynamicTestData();
		statementMessagePlan.setProductType(ProductType.fromShortName(type));

		StatementMessageDetails details = StatementMessageDetails.createWithProvider(provider);
		statementMessagePlan.getStatementMessageDetails().add(details);

		programSetupWorkflow.createStatementMessagePlan(statementMessagePlan);
	}

	@When("User fills Marketing Message Plan for $type product")
	public void whenUserFillsMarketingMessagePlan(String type) {
		marketingMessagePlan = MarketingMessagePlan.generateDynamicTestData();
		marketingMessagePlan.setProductType(ProductType.fromShortName(type));

		MarketingMessageDetails details = MarketingMessageDetails.createWithProvider();
		marketingMessagePlan.getMarketingMessageDetails().add(details);

		programSetupWorkflow.createMarketingMessagePlan(marketingMessagePlan);
	}

	@When("User fills MCC Rules for $type product")
	public void whenUserFillsMCCRules(String type) {
		mccRulePlan = MCCRulePlan.createGenericTestData();
		mccRulePlan.setProductType(ProductType.fromShortName(type));

		programSetupWorkflow.createMCCRulePlan(mccRulePlan);
	}

	@When("User fills Device Plan for $type product with no pin")
	public void whenUserFillsDevicePlanWithNoPin(String type) {
		setPinRequiredToFalse();
		whenUserFillsDevicePlan(type);
	}

	@When("User fills Device Plan for $type product")
	public void whenUserFillsDevicePlan(String type) {
		devicePlan = DevicePlan.createWithProvider(provider);
		devicePlan.setProductType(ProductType.fromShortName(type));
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		/*
		 * Below two line code creates template count in DB, it reaches max
		 * count 999 on continuous script execution, fetching existing values
		 * through excel This can be used when need arises to execute script for
		 * template creation
		 * devicePlan.setCardPackIdGenerationTemplate(cardPackIDTemplate.buildDescriptionAndCode());
		 * devicePlan.setDeviceIdGenerationTemplate(deviceTemplate.buildDescriptionAndCode());
		 */
		devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());

		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card with no pin")
	public void whenUserFillsDevicePlanForCrddWithNoPin(String productType, String deviceType) {
		setPinRequiredToFalse();
		whenUserFillsDevicePlanForCrdd(productType, deviceType);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card")
	public void whenUserFillsDevicePlanForCrdd(String productType, String deviceType) {
		//virtual cards are pinless so even if this statement is called by mistatke, we are setting Pin to false
		if(deviceType.toLowerCase().contains("virtual")) {
			setPinRequiredToFalse();
		}
		setPinRequiredToTrue();
		devicePlan = DevicePlan.createWithProvider(provider);
		devicePlan.setProductType(ProductType.fromShortName(productType));
		devicePlan.setDeviceType(DeviceType.fromShortName(deviceType));
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		
		//setting a flag through setter to figure out if the card is pinless card or not. This is used in TransactionSteps to set ExpiryDate incase of PinLess Card
		if("false".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
			devicePlan.setIsPinLess("YES");
			
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	@When("User fills Prepaid Statement Plan")
	public void whenUserFillsPrepaidStatementPlan() {
		prepaidStatementPlan = PrepaidStatementPlan.createWithProvider(provider);
		PrepaidStatementPlanDetails details = PrepaidStatementPlanDetails.createWithProvider(provider);
		prepaidStatementPlan.getPrepaidStatementPlanDetails().add(details);

		programSetupWorkflow.createPrepaidStatementPlan(prepaidStatementPlan);
	}

	@When("User fills Transaction Fee Plan")
	public void whenUserFillsTransactionFeePlan() {
		TransactionFeePlan plan = TransactionFeePlan.createWithProvider(provider);
		programSetupWorkflow.createTransactionFeePlan(plan);
	}

	@When("User fills Transaction Limit Plan for $type product")
	public void whenUserFillsTransactionLimitPlan(String type) {
		transactionLimitPlan = TransactionLimitPlan.createWithProvider(dataProvider);
		transactionLimitPlan.setIframeproductType(ProductType.fromShortName(type));
		TransactionLimitPlanDetails details = TransactionLimitPlanDetails.createWithProvider(provider);
		transactionLimitPlan.getTransactionLimitPlanDetails().add(details);

		programSetupWorkflow.createTransactionLimitPlan(transactionLimitPlan);
	}

	@When("User fills Device template for $type product")
	public void whenUserFillsDeviceTemplate(String type) {
		deviceTemplate = DevicePriorityPassIDAndCardPackIDTemplate.createWithProviderDeviceTemplate(provider);

		programSetupWorkflow.createDeviceTemplate(deviceTemplate);
	}

	@When("User fills Device Card Pack ID template for $type product")
	public void whenUserFillsDeviceCardPackIDTemplate(String type) {
		cardPackIDTemplate = DevicePriorityPassIDAndCardPackIDTemplate.createWithProviderCardPackIDTemplate(provider);

		programSetupWorkflow.createCardPackIDTemplate(cardPackIDTemplate);
	}

	@When("User fills Device Priority Pass ID template for $type product")
	public void whenUserFillsDevicePriorityPassIDTemplate(String type) {
		DevicePriorityPassIDAndCardPackIDTemplate priorityPassID = DevicePriorityPassIDAndCardPackIDTemplate.createWithProviderDevicePriorityPassID(provider);

		programSetupWorkflow.createPriorityPassID(priorityPassID);
	}

	@When("User fills Document Checklist Screen for $type product")
	public void whenUserFillsDocumentChecklistScreen(String type) {
		documentCheckListPlan = ApplicationDocumentChecklist.generateDynamicTestData();
		documentCheckListPlan.setProductType(ProductType.fromShortName(type));

		programSetupWorkflow.fillDocumentChecklist(documentCheckListPlan);
	}

	@When("User fills Wallet Fee Plan for $type product")
	public void whenUserFillsWalletFeePlan(String type) {

		WalletFeePlan walletFeePlan;
		walletFeePlan = WalletFeePlan.createWithProvider(provider);
		walletFeePlan.setProductType(ProductType.fromShortName(type));
		WalletFeePlanDetails details = WalletFeePlanDetails.createWithProvider(provider);
		walletFeePlan.getWalletFeePlanDetails().add(details);

		programSetupWorkflow.createWalletFeePlan(walletFeePlan, ProductType.fromShortName(type));
	}

	@When("User fills Business Mandatory Fields Screen for $type product")
	public void whenUserFillsBusinessMandatoryFieldsScreen(String type) {
		ApplicationBusinessMandatoryFields testDataObject = ApplicationBusinessMandatoryFields.createWithProvider(provider);
		testDataObject.setProductType(ProductType.fromShortName(type));
		testDataObject.setProgramCode(program.buildDescriptionAndCode());
		programSetupWorkflow.fillBusinessMandatoryFields(testDataObject);

	}

	@When("User fills Wallet Plan for $type product")
	public void whenUserFillsWalletPlan(String type) {
		walletPlan = WalletPlan.createWithProvider(dataProvider, provider);
		walletPlan.setProductType(ProductType.fromShortName(type));
		if (walletPlan.getProductType().equalsIgnoreCase(ProductType.CREDIT)) {
			walletPlan.setCreditPlan(creditCardCreditPlan.buildAbbreviationAndCode());
			walletPlan.setBillingCyleCode(creditCardBillingCycle.buildDescriptionAndCode());
		}
		programSetupWorkflow.createWalletPlan(walletPlan);
	}

	@When("User fills Transaction Plan for $type product")
	public void whenUserFillsTransactionPlan(String type) {
		transactionPlan = TransactionPlan.createWithProvider(dataProvider);
		transactionPlan.setProductType(ProductType.fromShortName(type));

		programSetupWorkflow.createTransactionPlan(transactionPlan);
	}

	@When("User fills Device Joining and Membership Fee Plan for $type product")
	public void whenUserFillsDeviceJoiningAndMembershipFeePlan(String type) {
		deviceJoiningAndMemberShipFeePlan = DeviceJoiningAndMemberShipFeePlan.createWithProvider(dataProvider);
		deviceJoiningAndMemberShipFeePlan.setProductType(ProductType.fromShortName(type));
		DeviceJoiningAndMemberShipFeePlanDetails details = DeviceJoiningAndMemberShipFeePlanDetails.createWithProvider(dataProvider);

		// for credit card, an additonal value is added in
		// DeviceJoiningAndMembershipFeePlanPage.JSON
		if (ProductType.fromShortName(type).toUpperCase().contains("CREDIT")) {
			details.setPostIssuanceFeeOn(details.getPostIssuanceFeeOnForCreditCard());
		}

		deviceJoiningAndMemberShipFeePlan.getDeviceJoiningAndMemberShipFeePlanDetails().add(details);

		programSetupWorkflow.createDeviceJoiningAndMemberShipFeePlan(deviceJoiningAndMemberShipFeePlan);
	}

	@When("User fills Device Event Based Fee Plan for $type product")
	public void whenUserFillsDeviceEventBasedFeePlan(String type) {
		deviceEventBasedFeePlan = DeviceEventBasedFeePlan.createWithProvider(dataProvider);
		deviceEventBasedFeePlan.setProductType(ProductType.fromShortName(type));
		DeviceEventBasedFeePlanDetails details = DeviceEventBasedFeePlanDetails.generateDynamicTestData();
		deviceEventBasedFeePlan.getDeviceEventBasedFeePlanDetails().add(details);

		programSetupWorkflow.createDeviceEventBasedFeePlan(deviceEventBasedFeePlan);
	}

	@When("User fills Program section for $type product")
	public void whenUserFillsProgramSection(String type) {
		program = Program.createWithProvider(dataProvider, provider);
		program.setProduct(ProductType.fromShortName(type));
		if (!program.getProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			program.setOtherPlanStatementMessagePlan(statementMessagePlan.buildDescriptionAndCode());
			program.setOtherPlanMarketingMessagePlan(marketingMessagePlan.buildDescriptionAndCode());
		}
		program.setWalletPlanPlan1(walletPlan.buildDescriptionAndCode());
		program.setDevicePlanPlan1(devicePlan.buildDescriptionAndCode());

		program.setDedupPlan(dedupePlan.buildDescriptionAndCode());
		program.setDocumentChecklistPlan(documentCheckListPlan.buildDescriptionAndCode());
		program.setMccRulePlan(mccRulePlan.buildDescriptionAndCode());

		if (program.getProduct().equalsIgnoreCase(ProductType.PREPAID)) {
			program.setPrepaidStatementPlan(prepaidStatementPlan.buildDescriptionAndCode());
		}

		programSetupWorkflow.createProgram(program, ProductType.fromShortName(type));
		context.put(ContextConstants.PROGRAM, program);
	}

	@When("User fills Dedupe Plan")
	public void whenUserFillsDedupePlan() {
		dedupePlan = DedupePlan.generateDynamicTestData();
		programSetupWorkflow.createDedupePlan(dedupePlan);
	}

	@When("User fills Payment Priority")
	public void whenUserFillsPaymentPriority() {
		paymentPrioritytestDataObject = CreditCardPaymentPriority.generateDynamicTestData();

		programSetupWorkflow.fillCreditCardPaymentPriority(paymentPrioritytestDataObject);
	}

	@When("User fills Billing Cycle")
	public void whenUserFillsBillingCycle() {
		creditCardBillingCycle = CreditCardBillingCycle.generateDynamicTestData();

		programSetupWorkflow.fillCreditCardBillingCycle(creditCardBillingCycle);
	}

	@When("User fills Payment Bounce Reason")
	public void whenUserFillsPaymentBounceReason() {
		CreditCardPaymentBounceReason testDataObject = CreditCardPaymentBounceReason.generateDynamicTestData();

		programSetupWorkflow.fillCreditCardPaymentBounceReason(testDataObject);
	}

	@When("User fills Transaction Rule Plan")
	public void whenUserFillsTransactionRulePlan() {
		transactionRulePlanTestDataObject = CreditCardTransactionRulePlan.generateDynamicTestData();

		programSetupWorkflow.fillCreditCardTransactionRulePlancode(transactionRulePlanTestDataObject);
	}

	@When("User fills Credit Plan")
	public void whenUserFillsCreditPlan() {
		// setting Test Data
		creditCardCreditPlan = CreditCardCreditPlan.createWithProvider(provider);
		// TransactionRulePlan & PaymentPriorityPlan are expected to come from
		// related methods hence fetching data
		// from them and setting them again below into setTransactionRulePlan &
		// setPaymentPriorityPlan
		creditCardCreditPlan.setTransactionRulePlan(transactionRulePlanTestDataObject.buildDescriptionAndCode());

		creditCardCreditPlan.setPaymentPriorityPlan(paymentPrioritytestDataObject.buildDescriptionAndCode());

		programSetupWorkflow.fillCreditCardCreditPlan(creditCardCreditPlan);
	}

	@When("User fills Device Range section for $type product")
	public void whenUserFillsDeviceRangeSection(String type) {
		DeviceRange deviceRange = DeviceRange.createWithProvider(provider, type);
		deviceRange.setProductType(ProductType.fromShortName(type));
		deviceRange.setProgram(program.buildDescriptionAndCode());
		deviceRange.setDevicePlanCode(devicePlan.buildDescriptionAndCode());

		programSetupWorkflow.createDeviceRange(deviceRange);
	}
		
	private  void setPinRequiredToFalse() {
		context.put(ConstantData.IS_PIN_REQUIRED, "FALSE");
	}

	private  void setPinRequiredToTrue() {
		context.put(ConstantData.IS_PIN_REQUIRED, "TRUE");
	}

}
