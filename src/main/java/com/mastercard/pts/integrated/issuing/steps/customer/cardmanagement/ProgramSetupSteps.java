package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.util.Objects;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.DeviceType;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.ProgramType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationBusinessMandatoryFields;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationDocumentChecklist;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardBillingCycle;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardPaymentBounceReason;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardPaymentPriority;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardTransactionRulePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DedupePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningAndMemberShipFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePriorityPassIDAndCardPackIDTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCRulePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCG;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeeWaiverPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MCGFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramSetupWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionFeeWaiverPlanFlows;

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

	@Autowired
	MCGFlows mcgflows;

	@Autowired
	MCG mcg;

	@Autowired
	private TransactionFeeWaiverPlanFlows transactionFeeWaiverPlanFlows;
	
	private DeviceJoiningAndMemberShipFeePlan deviceJoiningAndMemberShipFeePlan;

	private DeviceEventBasedFeePlan deviceEventBasedFeePlan;

	private CreditCardTransactionRulePlan transactionRulePlanTestDataObject;

	private CreditCardPaymentPriority paymentPrioritytestDataObject;

	private StatementMessagePlan statementMessagePlan;

	private TransactionPlan transactionPlan;

	private static final String TRANSACTION_FEE_PLAN = "TRANSACTION_FEE_PLAN";

	private TransactionLimitPlan transactionLimitPlan;

	private WalletPlan walletPlan;

	private MarketingMessagePlan marketingMessagePlan;

	private CreditCardCreditPlan creditCardCreditPlan;

	private CreditCardBillingCycle creditCardBillingCycle;

	private DevicePlan devicePlan;
	
	private DevicePlan devicePlanSupplementary;

	private Program program;

	private DevicePriorityPassIDAndCardPackIDTemplate cardPackIDTemplate;

	private DevicePriorityPassIDAndCardPackIDTemplate deviceTemplate;

	private DedupePlan dedupePlan;

	private ApplicationDocumentChecklist documentCheckListPlan;

	private MCCRulePlan mccRulePlan;

	private PrepaidStatementPlan prepaidStatementPlan;
	
	private TransactionFeeWaiverPlan transactionFeeWaiverPlan;
	
	private static final String TRANSACTION_FEE_WAIVER_PLAN = "TRANSACTION_FEE_WAIVER_PLAN";

	private static final String CARD_PACKID_GENERATION_TEMPLATE_FOR_DEVICE2 = "CARD_PACKID_GENERATION_TEMPLATE_FOR_DEVICE2";

	private static final String DEVICE_ID_GENERATION_TEMPLATE_FOR_DEVICE2 = "DEVICE_ID_GENERATION_TEMPLATE_FOR_DEVICE2";

	private static final String ISSUER_BIN_FOR_DEVICE2 = "ISSUER_BIN_FOR_DEVICE2";

	private static final String INTERCHANGE = "INTERCHANGE";

	private static final String PLASTIC_ID_FOR_DEVICE2 = "PLASTIC_ID_FOR_DEVICE2";

	private static final String PICTURE_CODE_FOR_DEVICE2 = "PICTURE_CODE_FOR_DEVICE2";

	private static final String EMBOSSING_VENDOR_FOR_DEVICE2 = "EMBOSSING_VENDOR_FOR_DEVICE2";

	@When("prepaid $deviceType device is available with balance amount")
	@Given("prepaid $deviceType device is available with balance amount")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product","When user assigns service code to program",
			"When user creates a bulk device production request for prepaid", "When processes created bulk device generation request for prepaid", "When processes pre-production batch for prepaid",
			"When processes device production batch for prepaid", "When processes pin generation batch for prepaid", "When user sign out from customer portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agency and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to branch and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agent and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as agency user", "When user fills order details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills quantity to be dispatched and submits the form", "When user sign out from customer portal", "When user is logged in agent portal as agency user",
			"When user fills the order acceptance details and submits the form", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills program details with registration", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills card sale checker details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device", "When user activates device through helpdesk",
			"When user has wallet number information for prepaid device", "When user performs adjustment transaction" })
	public void givenPrepaidCardIsAvailableWithAmount(String deviceType) {
		/*
		 * This is a composite step to be executed before assigning a program
		 */
	}

	@When("user fills data for prepaid device $deviceType and registers with new program")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", "When processes created bulk device generation request for prepaid", "When processes pre-production batch for prepaid",
			"When processes device production batch for prepaid", "When processes pin generation batch for prepaid", "When user sign out from customer portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agency and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to branch and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agent and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as agency user", "When user fills order details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills quantity to be dispatched and submits the form", "When user sign out from customer portal", "When user is logged in agent portal as agency user",
			"When user fills the order acceptance details and submits the form", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills program details with new program for prepaid product emv device", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills card sale checker details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device", "When user activates device through helpdesk" })
	public void whenUserFillsDataForPrepaidDeviceAndRegistersWithNewProgram(String deviceType) {
		/*
		 * This is a composite step for creating prepaid device and activating it
		 */
	}

	@When("user fills data for prepaid device $deviceType without registration and with customer registration")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", "When processes created bulk device generation request for prepaid", "When processes pre-production batch for prepaid",
			"When processes device production batch for prepaid", "When processes pin generation batch for prepaid", "When user sign out from customer portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agency and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to branch and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agent and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as agency user", "When user fills order details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills quantity to be dispatched and submits the form", "When user sign out from customer portal", "When user is logged in agent portal as agency user",
			"When user fills the order acceptance details and submits the form", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills program details without registration", "When user provides details through customer registration", "When user sign out from agent portal",
			"When user is logged in agent portal as agent user", "When user fills card sale checker details and submits the form", "When user sign out from agent portal",
			"When user is logged in institution", "When user fills General details with product prepaid and submits the form for registered device", "When user activates device through helpdesk" })
	public void whenUserFillsDataForPrepaidDeviceWithOutRegistrationAndWithCustomerRegistration(String deviceType) {
		/*
		 * This is a composite step for creating prepaid device and activating it
		 */
	}

	@When("user fills data for prepaid device $deviceType without registration")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", "When processes created bulk device generation request for prepaid", "When processes pre-production batch for prepaid",
			"When processes device production batch for prepaid", "When processes pin generation batch for prepaid", "When user sign out from customer portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agency and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to branch and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agent and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as agency user", "When user fills order details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills quantity to be dispatched and submits the form", "When user sign out from customer portal", "When user is logged in agent portal as agency user",
			"When user fills the order acceptance details and submits the form", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills program details without registration", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for notregistered device" })
	public void whenUserFillsDataForPrepaidDeviceWithOutRegistration(String deviceType) {
		/*
		 * This is a composite step for creating prepaid device and activating it
		 */
	}

	@When("user fills data for prepaid device $deviceType with registration and activates the device")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", "When processes created bulk device generation request for prepaid", "When processes pre-production batch for prepaid",
			"When processes device production batch for prepaid", "When processes pin generation batch for prepaid", "When user sign out from customer portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agency and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to branch and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as admin user", "When user fills information to assign program to agent and submits form", "When user sign out from agent portal",
			"When user is logged in agent portal as agency user", "When user fills order details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills quantity to be dispatched and submits the form", "When user sign out from customer portal", "When user is logged in agent portal as agency user",
			"When user fills the order acceptance details and submits the form", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills program details with registration", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills card sale checker details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device", "When user activates device through helpdesk" })
	public void whenUserFillsDataForPrepaidDeviceWithRegistrationAndActivatesTheDevice(String deviceType) {
		/*
		 * This is a composite step for creating prepaid device and activating it
		 */
	}

	@Given("prepaid $deviceType device without pin is available with balance amount")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid", "When processes created bulk device generation request for prepaid", "When processes pre-production batch for prepaid",
			"When processes device production batch for prepaid", "When user sign out from customer portal", "When user is logged in agent portal as admin user",
			"When user fills information to assign program to agency and submits form", "When user sign out from agent portal", "When user is logged in agent portal as admin user",
			"When user fills information to assign program to branch and submits form", "When user sign out from agent portal", "When user is logged in agent portal as admin user",
			"When user fills information to assign program to agent and submits form", "When user sign out from agent portal", "When user is logged in agent portal as agency user",
			"When user fills order details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills quantity to be dispatched and submits the form", "When user sign out from customer portal", "When user is logged in agent portal as agency user",
			"When user fills the order acceptance details and submits the form", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills program details with registration", "When user sign out from agent portal", "When user is logged in agent portal as agent user",
			"When user fills card sale checker details and submits the form", "When user sign out from agent portal", "When user is logged in institution",
			"When user fills General details with product prepaid and submits the form for registered device", "When user activates device through helpdesk",
			"When user has wallet number information for prepaid device", "When user performs adjustment transaction" })
	public void givenPrepaidCardIsAvailableWithAmountWithNoPin(String deviceType) {
		/*
		 * This is a composite step to be executed before assigning a program
		 */
	}

	@When("device range for program with device plan for \"debit\" \"$deviceType\" card")
	@Given("device range for program with device plan for \"debit\" \"$deviceType\" card")
	@Composite(steps = { "When User fills Dedupe Plan", "When User fills MCC Rules for debit product", "When User fills Transaction Plan for debit product",
			"When User fills Transaction Limit Plan for debit product", "When User fills Document Checklist Screen for debit product",
			"When User fills Device Joining and Membership Fee Plan for debit product", "When User fills Device Event Based Fee Plan for debit product",
			"When User fills Device Plan for \"debit\" \"<deviceType>\" card", "When User fills Wallet Plan for debit product", "When User fills Program section for debit product",
			"When User fills Business Mandatory Fields Screen for debit product", "When User fills Device Range section for debit product", "When user assigns service code to program" })
	public void givenDeviceRangeForDebitProgramWithDevicePlan(String deviceType) {
		// composite step
	}

	@Given("user updates cvccvv as uncheck on device plan")
	@When("user updates cvccvv as uncheck on device plan")
	@Then("user updates cvccvv as uncheck on device plan")
	public void userUpdateCVCCVVDevicePlan() {
		programSetupWorkflow.uncheckCVCCVVDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	@When("device range for program with device plan for \"debit\" \"$deviceType\" card without pin")
	@Given("device range for program with device plan for \"debit\" \"$deviceType\" card without pin")
	@Composite(steps = { "When User fills Dedupe Plan", "When User fills MCC Rules for debit product", "When User fills Transaction Plan for debit product",
			"When User fills Transaction Limit Plan for debit product", "When User fills Document Checklist Screen for debit product",
			"When User fills Device Joining and Membership Fee Plan for debit product", "When User fills Device Event Based Fee Plan for debit product",
			"When User fills Device Plan for \"debit\" \"<deviceType>\" card with no pin", "When User fills Wallet Plan for debit product", "When User fills Program section for debit product",
			"When User fills Business Mandatory Fields Screen for debit product", "When User fills Device Range section for debit product" , "When user assigns service code to program"})
	public void givenDeviceRangeForDebitProgramWithDevicePlanWithOutPin(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"debit\" \"$deviceType\" card without pin for specific interface")
	@Composite(steps = { "When User fills Dedupe Plan", "When User fills MCC Rules for debit product", "When User fills Transaction Plan for debit product",
			"When User fills Transaction Limit Plan for debit product", "When User fills Document Checklist Screen for debit product",
			"When User fills Device Joining and Membership Fee Plan for debit product", "When User fills Device Event Based Fee Plan for debit product",
			"When User fills Device Plan for \"debit\" \"<deviceType>\" card with no pin for an interface", "When User fills Wallet Plan for debit product",
			"When User fills Program section for debit product for an interface", "When User fills Business Mandatory Fields Screen for debit product",
			"When User fills Device Range section for debit product for an interface" , "When user assigns service code to program"})
	public void givenDeviceRangeForDebitProgramWithDevicePlanWithOutPinForSpecificInterface(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"debit\" \"$deviceType\" card without pin for non-default institution")
	@Composite(steps = { "When User fills Dedupe Plan", "When User fills MCC Rules for debit product", "When User fills Transaction Plan for debit product",
			"When User fills Transaction Limit Plan for debit product", "When User fills Document Checklist Screen for debit product",
			"When User fills Device Joining and Membership Fee Plan for debit product", "When User fills Device Event Based Fee Plan for debit product",
			"When User fills Device Plan for \"debit\" \"<deviceType>\" card with no pin for non-default institution", "When User fills Wallet Plan for debit product",
			"When User fills Program section for debit product", "When User fills Business Mandatory Fields Screen for debit product",
			"When User fills Device Range section for debit product for non-default institution" , "When user assigns service code to program"})
	public void givenDeviceRangeForProgramWithDevicePlanforDebitWithoutPinForNonDefaultInstitution(String deviceType) {
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
	@Composite(steps = { "When embossing file batch was generated in correct format", "When Pin Offset file batch was generated successfully",
			"When PIN is retrieved successfully with data from Pin Offset File", "When FinSim simulator is closed" })
	public void readDatafromEmbossingFileAndPinOffsetFile() {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card without pin")
	@When("device range for program with device plan for \"prepaid\" \"$deviceType\" card without pin")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product" , "When user assigns service code to program"})
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidWithoutPin(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" with limit plan")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			 "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for prepaid emv product transaction limit plan", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product" })
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidLimitPlan(String deviceType) {
		// composite step
	}
	
	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card without pin without dedupe")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Transaction Plan for prepaid product", "When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", "When User fills Device Joining and Membership Fee Plan for prepaid product",
			"When User fills Device Event Based Fee Plan for prepaid product", "When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin",
			"When User fills Wallet Plan for prepaid product", "When User fills Program section using newApplication for prepaid product", "When User fills Device Range section for prepaid product" , "When user assigns service code to program"})
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidWithoutPinWithoutDedupe(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card without pin for non-default institution")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin for non-default institution", "When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product", "When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product for non-default institution" , "When user assigns service code to program"})
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidWithoutPinForNonDefaultInstitution(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card without pin for non-default institution for interface")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin for non-default institution", "When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product for an interface", "When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product for non-default institution" , "When user assigns service code to program"})
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidWithoutPinForNonDefaultInstitutionForInterface(String deviceType) {
		// composite step for interface
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card without pin for an interface")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin", "When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product for an interface", "When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product for an interface" , "When user assigns service code to program"})
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidWithoutPinForAnInterface(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" \"Manual\" activation code for card without pin for an interface")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for  \"prepaid\" \"<deviceType>\" along with \"Manual\" activation mode for card with no pin", "When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product for an interface", "When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product for an interface", "When user assigns service code to program" })
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidAlongWithActivationCodeWithoutPinForAnInterface(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" \"Load\" activation code for card with pin for an interface")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" along with \"Load\" activation mode for card", "When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product for an interface", "When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product for an interface", "When user assigns service code to program" })
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidAlongWithActivationCodeWithPinForAnInterface(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card without pin for specific interface")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card with no pin for an interface", "When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product for an interface", "When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product for an interface", "When user assigns service code to program" })
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidWithoutPinForSpecificInterface(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card for an interface")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", "When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product for an interface", "When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product for an interface" , "When user assigns service code to program"})
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidForAnInterface(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card")
	@When("device range for program with device plan for \"prepaid\" \"$deviceType\" card")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan", "When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product", "When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product", "When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", "When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product", "When User fills Device Range section for prepaid product" , "When user assigns service code to program"})
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaid(String deviceType) {
		// composite step
	}

	@Given("device range for program with device plan for \"prepaid\" \"$deviceType\" card without dedupe")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product", "When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Transaction Plan for prepaid product", "When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product", "When User fills Device Joining and Membership Fee Plan for prepaid product",
			"When User fills Device Event Based Fee Plan for prepaid product", "When User fills Device Plan for \"prepaid\" \"<deviceType>\" card", "When User fills Wallet Plan for prepaid product",
			"When User fills Program section using newApplication for prepaid product", "When User fills Device Range section for prepaid product", "When user assigns service code to program" })
	public void givenDeviceRangeForProgramWithDevicePlanforPrepaidWithoutDedupe(String deviceType) {
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

	@When("user edits MCC rules from $fromMCC to $toMCC uncheck approve $origin transactions")
	public void whenUserEditsMCCRules(String fromMCC,String toMCC,String origin) {
		mccRulePlan.setFromMccCode(fromMCC);
		mccRulePlan.setToMccCode(toMCC);
		mccRulePlan.setOrigin(origin);
		programSetupWorkflow.editMCCRulePlan(mccRulePlan);
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
		devicePlan = DevicePlan.createWithProviderForCredit(provider);		
		devicePlan.setProductType(ProductType.fromShortName(type));
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		/*
		 * Below two line code creates template count in DB, it reaches max count 999 on continuous script execution, fetching existing values through excel This can be used when need arises to
		 * execute script for template creation devicePlan.setCardPackIdGenerationTemplate(cardPackIDTemplate .buildDescriptionAndCode()); devicePlan.setDeviceIdGenerationTemplate(
		 * deviceTemplate.buildDescriptionAndCode());
		 */
		devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlan.setTransactionFeePlan(provider.getString(TRANSACTION_FEE_PLAN));
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}
	
	@When("User fills Device Plan for $type product for $interchange")
	public void whenUserFillsDevicePlanForInterchange(String type,String interchange) {
		devicePlan = DevicePlan.createWithProvider(provider);
		devicePlan.setProductType(ProductType.fromShortName(type));
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		devicePlan.setAssociation(interchange);
		devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());

		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}
	
	@When("for $deviceType User fills Device Plan for $type product for $interchange")
	public void whenUserFillsDevicePlanForInterchangeAndDeviceType(String deviceType,String type,String interchange) {
		devicePlan = DevicePlan.createProviderForCredit(provider);
		InstitutionData data= context.get(CreditConstants.JSON_VALUES);
		devicePlan.setProductType(ProductType.fromShortName(type));
		if (Objects.nonNull(deviceJoiningAndMemberShipFeePlan)) {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		} else {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(data.getDeviceJoiningAndMemberShipFeePlan());
		}
		if (Objects.nonNull(deviceEventBasedFeePlan)) {
			devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		} else {
			devicePlan.setBaseDeviceEventBasedPlan(data.getDeviceEventBasedFeePlan());
		}
		devicePlan.setAssociation(interchange);
		if (Objects.nonNull(transactionLimitPlan)) {
			devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		} else {
			devicePlan.setTransactionLimitPlan(data.getTransactionLimitPlan());
		}
		if (Objects.nonNull(transactionLimitPlan)) {
			devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
			devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		} else {
			setPinRequiredToDefaultState();
			devicePlan.setAfterKYC(data.getTransactionPlan());
			devicePlan.setBeforeKYC(data.getTransactionPlan());
		}
		devicePlan.setDeviceType(deviceType);

		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}
	
	@When("for $deviceType User fills without pin Device Plan for $type product for $interchange")
	public void whenUserFillsDevicePlanForInterchangeAndDeviceTypeWithoutPin(String deviceType,String type,String interchange) {
		setPinRequiredToFalse();
		devicePlan = DevicePlan.createProviderForCredit(provider);
		InstitutionData data= context.get(CreditConstants.JSON_VALUES);
		if ("false".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
			devicePlan.setIsPinLess("YES");
		devicePlan.setProductType(ProductType.fromShortName(type));
		if (Objects.nonNull(deviceJoiningAndMemberShipFeePlan) && Objects.nonNull(deviceEventBasedFeePlan)) {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
			devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		} else {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(data.getDeviceJoiningAndMemberShipFeePlan());
			devicePlan.setBaseDeviceEventBasedPlan(data.getDeviceEventBasedFeePlan());
		}
		devicePlan.setAssociation(interchange);
		if (Objects.nonNull(transactionLimitPlan) && Objects.nonNull(transactionPlan)) {
			devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
			devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
			devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		} else {
			devicePlan.setTransactionLimitPlan(data.getTransactionLimitPlan());
			devicePlan.setAfterKYC(data.getTransactionPlan());
			devicePlan.setBeforeKYC(data.getTransactionPlan());
		}
		devicePlan.setDeviceType(deviceType);
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}
	
	@When("for $deviceType User fills Supplementary Device Plan for $type product for $interchange")
	public void whenUserFillsDevicePlanForInterchangeAndDeviceTypeForSupplementary(String deviceType,String type,String interchange) {
		devicePlanSupplementary = DevicePlan.createProviderForCredit(provider);
		devicePlanSupplementary.setProductType(ProductType.fromShortName(type));
		devicePlanSupplementary.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlanSupplementary.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		devicePlanSupplementary.setAssociation(interchange);
		devicePlanSupplementary.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlanSupplementary.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlanSupplementary.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		devicePlanSupplementary.setDeviceType(deviceType);

		programSetupWorkflow.createDevicePlan(devicePlanSupplementary);
		context.put(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY, devicePlanSupplementary);
	}
	
	@When("for $deviceType User fills without pin Supplementary Device Plan for $type product for $interchange")
	public void whenUserFillsDevicePlanForInterchangeAndDeviceTypeForSupplementaryWithoutPin(String deviceType,String type,String interchange) {
		setPinRequiredToFalse();
		devicePlanSupplementary = DevicePlan.createProviderForCredit(provider);
		devicePlanSupplementary.setProductType(ProductType.fromShortName(type));
		devicePlanSupplementary.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlanSupplementary.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		devicePlanSupplementary.setAssociation(interchange);
		devicePlanSupplementary.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlanSupplementary.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlanSupplementary.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		devicePlanSupplementary.setDeviceType(deviceType);

		programSetupWorkflow.createDevicePlan(devicePlanSupplementary);
		context.put(ContextConstants.DEVICE_PLAN_SUPPLEMENTARY, devicePlanSupplementary);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card with no pin for non-default institution")
	public void whenUserFillsDevicePlanWithNoPinforNonDefaultInstitution(String productType, String deviceType) {
		setPinRequiredToFalse();
		whenUserFillsDevicePlanforNonDefaultInstitution(productType, deviceType, provider);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card for non-default institution")
	public void whenUserFillsDevicePlanforNonDefaultInstitution(String productType, String deviceType, KeyValueProvider provider) {
		devicePlan = DevicePlan.createWithProvider(provider);
		devicePlan.setProductType(ProductType.fromShortName(productType));
		devicePlan.setDeviceType(DeviceType.fromShortName(deviceType));
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		devicePlan.setCardPackIdGenerationTemplate(provider.getString(CARD_PACKID_GENERATION_TEMPLATE_FOR_DEVICE2));
		devicePlan.setDeviceIdGenerationTemplate(provider.getString(DEVICE_ID_GENERATION_TEMPLATE_FOR_DEVICE2));
		devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlan.setPlasticId(provider.getString(PLASTIC_ID_FOR_DEVICE2));
		devicePlan.setPictureCode(provider.getString(PICTURE_CODE_FOR_DEVICE2));
		devicePlan.setEmbossingVendor(provider.getString(EMBOSSING_VENDOR_FOR_DEVICE2));
		devicePlan.setTransactionFeePlan(provider.getString(TRANSACTION_FEE_PLAN));
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" along with \"$activationMode\" activation mode for card")
	public void whenUserFillsDevicePlanAlongWithActivationcodeWithPin(String productType, String deviceType, String activationMode) {
		settingDevicePlanTestData(productType, deviceType); /*
															 * call to re-usable method ; modifiying the activation mode into the devicePlan based on the $activationMode parameter instead of creating
															 * new method. Avoiding Sonar code duplication
															 */
		devicePlan.setActivationMode(activationMode);

		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" along with \"$activationMode\" activation mode for card with no pin")
	public void whenUserFillsDevicePlanAlongWithActivationcodeWithNoPin(String productType, String deviceType, String activationMode) {
		setPinRequiredToFalse();
		settingDevicePlanTestData(productType, deviceType); /*
															 * call to re-usable method ; modifiying the activation mode into the devicePlan based on the $activationMode parameter instead of creating
															 * new method. Avoiding Sonar code duplication
															 */
		devicePlan.setActivationMode(activationMode);

		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card with no pin")
	public void whenUserFillsDevicePlanForCrddWithNoPin(String productType, String deviceType) {
		setPinRequiredToFalse();
		whenUserFillsDevicePlanForCrdd(productType, deviceType);
	}
	
	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card without pin")
	public void whenUserFillsDevicePlanForCrddWithoutPin(String productType, String deviceType) {
		setPinRequiredToFalse();
		// virtual cards are pinless so even if this statement is called by
		// mistake, we are setting Pin to false
		if (deviceType.toLowerCase().contains(ConstantData.VIRTUAL_DEVICE_TYPE)) {
			setPinRequiredToFalse();
		}
		devicePlan = DevicePlan.createWithProvider(provider);
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		devicePlan.setProductType(ProductType.fromShortName(productType));
		devicePlan.setDeviceType(DeviceType.fromShortName(deviceType));
		if (Objects.nonNull(deviceJoiningAndMemberShipFeePlan)) {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
			devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
			devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		} else {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(data.getDeviceJoiningAndMemberShipFeePlan());
			devicePlan.setBaseDeviceEventBasedPlan(data.getDeviceEventBasedFeePlan());
			devicePlan.setTransactionLimitPlan(data.getTransactionLimitPlan());
		}
		if (Objects.nonNull(transactionPlan)) {
			devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
			devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		} else {
			devicePlan.setAfterKYC(data.getTransactionPlan());
			devicePlan.setBeforeKYC(data.getTransactionPlan());
		}

		// setting a flag through setter to figure out if the card is pinless
		// card or not. This is used in TransactionSteps to set ExpiryDate in
		// case of PinLess Card
		if (ConstantData.PIN_REQUIRED_FALSE.equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
			devicePlan.setIsPinLess("YES");
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card for issuer scripting")
	public void whenUserFillsDevicePlanForCrddForIssuerScripting(String productType, String deviceType) {
	setPinRequiredToFalse();
		// virtual cards are pinless so even if this statement is called by
		// mistake, we are setting Pin to false
		if (deviceType.toLowerCase().contains(ConstantData.VIRTUAL_DEVICE_TYPE)) {
			setPinRequiredToFalse();
		}
		devicePlan = DevicePlan.createWithProviderForIssuerScripting(provider);
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		devicePlan.setProductType(ProductType.fromShortName(productType));
		devicePlan.setDeviceType(DeviceType.fromShortName(deviceType));
		if (Objects.nonNull(deviceJoiningAndMemberShipFeePlan)) {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
			devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
			devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		} else {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(data.getDeviceJoiningAndMemberShipFeePlan());
			devicePlan.setBaseDeviceEventBasedPlan(data.getDeviceEventBasedFeePlan());
			devicePlan.setTransactionLimitPlan(data.getTransactionLimitPlan());
		}
		if (Objects.nonNull(transactionPlan)) {
			devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
			devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		} else {
			devicePlan.setAfterKYC(data.getTransactionPlan());
			devicePlan.setBeforeKYC(data.getTransactionPlan());
		}

		// setting a flag through setter to figure out if the card is pinless
		// card or not. This is used in TransactionSteps to set ExpiryDate in
		// case of PinLess Card
		if (ConstantData.PIN_REQUIRED_FALSE.equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
			devicePlan.setIsPinLess("YES");
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}
	
	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card")
	public void whenUserFillsDevicePlanForCrdd(String productType, String deviceType) {
		settingDevicePlanTestData(productType, deviceType); // call to re-usable method
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	@When("User fills Device Plan for $productType $deviceType product transaction limit plan")
	public void whenUserFillsDevicePlanTransactionLimitPlan(String productType, String deviceType) {
		setPinRequiredToFalse();
		devicePlan = DevicePlan.createWithProvider(provider);
		devicePlan.setProductType(ProductType.fromShortName(productType));
		devicePlan.setDeviceType(DeviceType.fromShortName(deviceType));
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		devicePlan.setTransactionLimitPlan(context.get(ContextConstants.TX_LIMIT_PLAN_CODE));
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setTransactionFeePlan(provider.getString(TRANSACTION_FEE_PLAN));
		if ("false".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
			devicePlan.setIsPinLess("YES");
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}

	
	// refactored and created a new method that could be used in Device Plan to read test data from device context and/or testdata
	private void settingDevicePlanTestData(String productType, String deviceType) {
		// virtual cards are pinless so even if this statement is called by mistake, we are setting Pin to false
		if (deviceType.toLowerCase().contains("virtual")) {
			setPinRequiredToFalse();
		}
		devicePlan = DevicePlan.createWithProvider(provider);
		InstitutionData data= context.get(CreditConstants.JSON_VALUES);
		devicePlan.setProductType(ProductType.fromShortName(productType));
		devicePlan.setDeviceType(DeviceType.fromShortName(deviceType));
		if (Objects.nonNull(deviceJoiningAndMemberShipFeePlan)) {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
			devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
			devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		} else {
			devicePlan.setBaseDeviceJoiningMemberShipPlan(data.getDeviceJoiningAndMemberShipFeePlan());
			devicePlan.setBaseDeviceEventBasedPlan(data.getDeviceEventBasedFeePlan());
			devicePlan.setTransactionLimitPlan(data.getTransactionLimitPlan());
			setPinRequiredToDefaultState();
		}
		if (Objects.nonNull(transactionPlan)) {
			devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
			devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		} else {
			devicePlan.setAfterKYC(data.getTransactionPlan());
			devicePlan.setBeforeKYC(data.getTransactionPlan());
		}

		// setting a flag through setter to figure out if the card is pinless card or not. This is used in TransactionSteps to set ExpiryDate in case of PinLess Card
		if ("false".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
			devicePlan.setIsPinLess("YES");
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card with no pin for an interface")
	public void whenUserFillsDevicePlanForCrddWithNoPinForAnInterface(String productType, String deviceType) {
		setPinRequiredToFalse();
		whenUserFillsDevicePlanForCardForanInterface(productType, deviceType);
	}

	@When("User fills Device Plan for \"$productType\" \"$deviceType\" card for an interface")
	public void whenUserFillsDevicePlanForCardForanInterface(String productType, String deviceType) {
		if (deviceType.toLowerCase().contains("virtual")) {
			setPinRequiredToFalse();
		}
		devicePlan = DevicePlan.createWithProvider(provider);
		devicePlan.setProductType(ProductType.fromShortName(productType));
		devicePlan.setDeviceType(DeviceType.fromShortName(deviceType));
		devicePlan.setAssociation(provider.getString(INTERCHANGE));
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());
		devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());
		devicePlan.setTransactionFeePlan(provider.getString(TRANSACTION_FEE_PLAN));

		// setting a flag through setter to figure out if the card is pinless card or not. This is used in TransactionSteps to set ExpiryDate in case of PinLess Card
		if ("false".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString()))
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

	@When("User fills Transaction Fee Plan for $type product")
	public void whenUserFillsTransactionFeePlan(String type) {
		deviceJoiningAndMemberShipFeePlan = DeviceJoiningAndMemberShipFeePlan.createWithProvider(dataProvider);
		deviceJoiningAndMemberShipFeePlan.setProductType(ProductType.fromShortName(type));
		DeviceJoiningAndMemberShipFeePlanDetails details = DeviceJoiningAndMemberShipFeePlanDetails.createWithProvider(dataProvider);
		// for credit card, an additonal value is added in DeviceJoiningAndMembershipFeePlanPage.JSON
		if (ProductType.fromShortName(type).toUpperCase().contains("CREDIT")) {
			details.setPostIssuanceFeeOn(details.getPostIssuanceFeeOnForCreditCard());
		}

		deviceJoiningAndMemberShipFeePlan.getDeviceJoiningAndMemberShipFeePlanDetails().add(details);
		programSetupWorkflow.createDeviceJoiningAndMemberShipFeePlan(deviceJoiningAndMemberShipFeePlan);
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

	@When("User fills Document Checklist Screen for $type product with $customerType customer")
	public void userFillsDocumentChecklistScreen(String type) {
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

	@When("User fills Business Mandatory Fields Screen for $type product with $customerType")
	public void whenUserFillsBusinessMandatoryFieldsScreen(String type, String customeType) {
		ApplicationBusinessMandatoryFields testDataObject = ApplicationBusinessMandatoryFields.createWithProvider(provider);
		testDataObject.setProductType(ProductType.fromShortName(type));
		testDataObject.setCustomerType(ProductType.fromShortName(customeType));
		testDataObject.setProgramCode(program.buildDescriptionAndCode());
		programSetupWorkflow.fillBusinessMandatoryFields(testDataObject);
	}

	@When("User fills Wallet Plan for $type product")
	public void whenUserFillsWalletPlan(String type) {
		walletPlan = WalletPlan.createWithProvider(dataProvider, provider);
		walletPlan.setProductType(ProductType.fromShortName(type));
		if (walletPlan.getProductType().equalsIgnoreCase(ProductType.CREDIT)) {
			walletPlan.setCreditPlan(context.get(CreditConstants.CREDIT_PLAN));
			walletPlan.setBillingCyleCode(context.get(CreditConstants.BILLING_CYCLE));
		}
		programSetupWorkflow.createWalletPlan(walletPlan);
	}

	@When("User fills Wallet Plan for $type product and program $programtype")
	public void userFillsWalletPlan(String type, String programtype) {
		walletPlan = WalletPlan.createWithProvider(dataProvider, provider);
		InstitutionData data= context.get(CreditConstants.JSON_VALUES);
		walletPlan.setProductType(ProductType.fromShortName(type));
		walletPlan.setProgramType(programtype);
		context.put(ContextConstants.WALLET, walletPlan);
		if (walletPlan.getProductType().equalsIgnoreCase(ProductType.CREDIT)) {
			if (Objects.nonNull(context.get(CreditConstants.CREDIT_PLAN))) {
				walletPlan.setCreditPlan(context.get(CreditConstants.CREDIT_PLAN));
				walletPlan.setBillingCyleCode(context.get(CreditConstants.BILLING_CYCLE));
			} else {
				context.put(ConstantData.JSON_DATA_DRIVEN_EXECUTION, true);
				walletPlan.setCreditPlan(data.getCreditPlan());
				walletPlan.setBillingCyleCode(data.getBillingCycle());
			}
		}
		programSetupWorkflow.createWalletPlan(walletPlan);
	}

	@When("fills Wallet Plan for $type product and program $programtype")
	public void FillsWalletPlan(String type, String programtype) {
		walletPlan = WalletPlan.createWithProvider(dataProvider, provider);
		walletPlan.setProductType(ProductType.fromShortName(type));
		walletPlan.setProgramType(programtype);

		if (walletPlan.getProductType().equalsIgnoreCase(ProductType.CREDIT)) {
			walletPlan.setCreditPlan(creditCardCreditPlan.buildAbbreviationAndCode());
			walletPlan.setBillingCyleCode(creditCardBillingCycle.buildDescriptionAndCode());
		}
		programSetupWorkflow.createNewWalletPlan(walletPlan);
	}

	@When("User fills Transaction Plan for $type product")
	public void whenUserFillsTransactionPlan(String type) {
		// setting the context for IS PIN REQUIRED to a default state. This
		// value is reset or set accordingly for Virtual and pinless cards
		setPinRequiredToDefaultState();
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
		//datadriven
		InstitutionData data= context.get(CreditConstants.JSON_VALUES);
		program.setProduct(ProductType.fromShortName(type));
		if (!program.getProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			if (Objects.nonNull(statementMessagePlan) && Objects.nonNull(marketingMessagePlan)) {
				program.setOtherPlanStatementMessagePlan(statementMessagePlan.buildDescriptionAndCode());
				program.setOtherPlanMarketingMessagePlan(marketingMessagePlan.buildDescriptionAndCode());
			} else {
				program.setOtherPlanStatementMessagePlan(data.getStatementMessagePlan());
				program.setOtherPlanMarketingMessagePlan(data.getMarketingMessagePlan());
			}
		}
		program.setFirstWalletPlan(walletPlan.buildDescriptionAndCode());
		program.setDevicePlanPlan1(devicePlan.buildDescriptionAndCode());
		if (Objects.nonNull(dedupePlan) && Objects.nonNull(documentCheckListPlan) && Objects.nonNull(mccRulePlan)) {
			program.setDedupPlan(dedupePlan.buildDescriptionAndCode());
			program.setDocumentChecklistPlan(documentCheckListPlan.buildDescriptionAndCode());
			program.setMccRulePlan(mccRulePlan.buildDescriptionAndCode());
		} else {
			program.setDedupPlan(data.getDeDupePlanCode());
			program.setDocumentChecklistPlan(data.getDocumentCheckListPlan());
			program.setMccRulePlan(data.getMccRulePlan());
		}

		if (program.getProduct().equalsIgnoreCase(ProductType.PREPAID))
			if (Objects.nonNull(prepaidStatementPlan)) {
				program.setPrepaidStatementPlan(prepaidStatementPlan.buildDescriptionAndCode());
			} else {
				program.setPrepaidStatementPlan(data.getPrepaidStatementPlan());
			}

		programSetupWorkflow.createProgram(program, ProductType.fromShortName(type));
		context.put(ContextConstants.PROGRAM, program);
	}
	
	@When("User $applicationType fills $subApplicationType Program $programType section for $type product for $interchange")
	public void whenUserFillsProgramSection(String applicationType,String subApplicationType,String programType,String type,String interchange) {
		program = Program.createWithProvider(dataProvider, provider);
		InstitutionData data= context.get(CreditConstants.JSON_VALUES);
		program.setProduct(ProductType.fromShortName(type));
		program.setInterchange(interchange);
		if (!program.getProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			if (Objects.nonNull(statementMessagePlan) && Objects.nonNull(marketingMessagePlan)) {
				program.setOtherPlanStatementMessagePlan(statementMessagePlan.buildDescriptionAndCode());
				program.setOtherPlanMarketingMessagePlan(marketingMessagePlan.buildDescriptionAndCode());
			} else {
				program.setOtherPlanStatementMessagePlan(data.getStatementMessagePlan());
				program.setOtherPlanMarketingMessagePlan(data.getMarketingMessagePlan());
			}
		}
		if (Objects.nonNull(walletPlan)) {
			program.setFirstWalletPlan(walletPlan.buildDescriptionAndCode());
		} else {
			program.setFirstWalletPlan(data.getWalletPlan());
		}
		program.setDevicePlanPlan1(devicePlan.buildDescriptionAndCode());
		program.setApplicationType(applicationType);
		program.setSubApplicationType(subApplicationType);
		if (program.getApplicationType().contains("Supplementary") || program.getApplicationType().contains("Add-on") && program.getSubApplicationType().contains("Existing")) {
			program.setDevicePlanPlan2(devicePlanSupplementary.buildDescriptionAndCode());
		}
		if (Objects.nonNull(dedupePlan)) {
			program.setDedupPlan(dedupePlan.buildDescriptionAndCode());
		} else {
			program.setDedupPlan(data.getDeDupePlanCode());
		}
		if (Objects.nonNull(documentCheckListPlan)) {
			program.setDocumentChecklistPlan(documentCheckListPlan.buildDescriptionAndCode());
		} else {
			program.setDocumentChecklistPlan(data.getDocumentCheckListPlan());
		}
		if (Objects.nonNull(mccRulePlan)) {
			program.setMccRulePlan(mccRulePlan.buildDescriptionAndCode());
		} else {
			program.setMccRulePlan(data.getMccRulePlan());
		}
		program.setProgramType(programType);

		if (program.getProduct().equalsIgnoreCase(ProductType.PREPAID))
			program.setPrepaidStatementPlan(prepaidStatementPlan.buildDescriptionAndCode());

		programSetupWorkflow.createProgram(program, ProductType.fromShortName(type));
		context.put(ContextConstants.PROGRAM, program);
	}

	@When("User fills Program section for $type product and program $programType")
	public void userFillsProgramSection(String type, String programType) {
		program = Program.createWithProvider(dataProvider, provider);
		program.setProduct(ProductType.fromShortName(type));
		program.setProgramType(programType);
		if (!program.getProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			program.setOtherPlanStatementMessagePlan(statementMessagePlan.buildDescriptionAndCode());
			program.setOtherPlanMarketingMessagePlan(marketingMessagePlan.buildDescriptionAndCode());
		}
		program.setFirstWalletPlan(walletPlan.buildDescriptionAndCode());
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

	@When("User fills Program section for $type product for an interface")
	public void whenUserFillsProgramSectionVisaInterface(String type) {
		program = Program.createDataWithProvider(dataProvider, provider);
		program.setProduct(ProductType.fromShortName(type));
		if (!program.getProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			program.setOtherPlanStatementMessagePlan(statementMessagePlan.buildDescriptionAndCode());
			program.setOtherPlanMarketingMessagePlan(marketingMessagePlan.buildDescriptionAndCode());
		}
		program.setFirstWalletPlan(walletPlan.buildDescriptionAndCode());
		program.setDevicePlanPlan1(devicePlan.buildDescriptionAndCode());

		program.setDedupPlan(dedupePlan.buildDescriptionAndCode());
		program.setDocumentChecklistPlan(documentCheckListPlan.buildDescriptionAndCode());
		program.setMccRulePlan(mccRulePlan.buildDescriptionAndCode());

		if (program.getProduct().equalsIgnoreCase(ProductType.PREPAID))
			program.setPrepaidStatementPlan(prepaidStatementPlan.buildDescriptionAndCode());

		programSetupWorkflow.createProgram(program, ProductType.fromShortName(type));
		context.put(ContextConstants.PROGRAM, program);
	}

	@When("user fills Merchant Category Group")
	public void fillsCreatesMCG() {
		context.put(ContextConstants.MCG, mcg);
		String msg = mcgflows.addNewMCG();
		mcg.setMCG(msg);
	}

	@When("create wallet Plan for \"$type\" product and program \"$programtype\" with usage \"$usageType\"")
	public void addWalletPlan(@Named("type") String type, @Named("programtype") String programtype, @Named("usageType") String usageType) {
		walletPlan = WalletPlan.createWithProvider(dataProvider, provider);
		walletPlan.setProductType(ProductType.fromShortName(type));
		walletPlan.setProgramType(programtype);
		MCG mcgs = context.get(ContextConstants.MCG);
		walletPlan.setWhiteMcgCode(mcgs.getMCG());

		if (ProgramType.OPEN_LOOP.contains(usageType)) {
			walletPlan.setUsage(ProgramType.OPEN_LOOP);
			context.put(ContextConstants.WALLET, walletPlan);
		} else {
			walletPlan.setUsage(ProgramType.CLOSED_LOOP);
		}

		if (walletPlan.getProductType().equalsIgnoreCase(ProductType.CREDIT)) {
			walletPlan.setCreditPlan(creditCardCreditPlan.buildAbbreviationAndCode());
			walletPlan.setBillingCyleCode(creditCardBillingCycle.buildDescriptionAndCode());
		}

		programSetupWorkflow.createNewWalletPlan(walletPlan);

		WalletPlan wallets = context.get(ContextConstants.WALLET);

		if (ProgramType.OPEN_LOOP.contains(usageType)) {
			wallets.setFirstWallet(walletPlan.buildDescriptionAndCode());
		} else {
			wallets.setSecondWallet(walletPlan.buildDescriptionAndCode());

		}
	}

	@When("fills Program section for $type product and program $programType")
	public void fillsProgramSection(String type, String programType) {
		program = Program.createWithProvider(dataProvider, provider);
		program.setProduct(ProductType.fromShortName(type));
		program.setProgramType(programType);

		if (!program.getProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			program.setOtherPlanStatementMessagePlan(statementMessagePlan.buildDescriptionAndCode());
			program.setOtherPlanMarketingMessagePlan(marketingMessagePlan.buildDescriptionAndCode());
		}

		WalletPlan wallets = context.get(ContextConstants.WALLET);
		program.setFirstWalletPlan(wallets.getFirstWallet());
		program.setSecondWalletPlan(wallets.getSecondWallet());

		program.setDevicePlanPlan1(devicePlan.buildDescriptionAndCode());
		program.setDedupPlan(dedupePlan.buildDescriptionAndCode());
		program.setDocumentChecklistPlan(documentCheckListPlan.buildDescriptionAndCode());
		program.setMccRulePlan(mccRulePlan.buildDescriptionAndCode());

		if (program.getProduct().equalsIgnoreCase(ProductType.PREPAID)) {
			program.setPrepaidStatementPlan(prepaidStatementPlan.buildDescriptionAndCode());
		}
		programSetupWorkflow.createAddProgram(program, ProductType.fromShortName(type));
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
		/*
		 * TransactionRulePlan & PaymentPriorityPlan are expected to come from related methods hence fetching data from them and setting them again below into setTransactionRulePlan &
		 * setPaymentPriorityPlan
		 */
		creditCardCreditPlan.setTransactionRulePlan(context.get(CreditConstants.TRANSACTION_RULE));

		creditCardCreditPlan.setPaymentPriorityPlan(context.get(CreditConstants.PAYMENT_PRIORITY));

		programSetupWorkflow.fillCreditCardCreditPlan(creditCardCreditPlan);
	}

	@When("User fills Device Range section for $type product")
	public void whenUserFillsDeviceRangeSection(String type) {
		DeviceRange deviceRange;
		if(ProductType.CREDIT.toUpperCase().contains(type.toUpperCase())) {
			deviceRange = DeviceRange.createWithProvider(dataProvider,provider, type);
		} else {
			deviceRange = DeviceRange.createWithProvider(dataProvider, type);
		}
		deviceRange.setProductType(ProductType.fromShortName(type));
		deviceRange.setProgram(program.buildDescriptionAndCode());
		deviceRange.setDevicePlanCode(devicePlan.buildDescriptionAndCode());

		programSetupWorkflow.createDeviceRange(deviceRange);
	}
	
	@When("for $applicationType and $subApplicationType user fills Device Range section for $type product")
	public void whenUserFillsDeviceRangeSectionforSupplementaryAndAddonExistingClient(String applicationType,String subApplicationType,String type) {
		DeviceRange deviceRange;
			if(ProductType.CREDIT.toUpperCase().contains(type.toUpperCase())) {
			deviceRange = DeviceRange.createWithProvider(dataProvider,provider, type);
			if(applicationType.contains("Supplementary")||applicationType.contains("Add-on")&& subApplicationType.contains("Existing"))
			{
				deviceRange.setProductType(ProductType.fromShortName(type));
				deviceRange.setProgram(program.buildDescriptionAndCode());
				deviceRange.setDevicePlanCode(devicePlanSupplementary.buildDescriptionAndCode());	
			}
			else
			{
				deviceRange.setProductType(ProductType.fromShortName(type));
				deviceRange.setProgram(program.buildDescriptionAndCode());
				deviceRange.setDevicePlanCode(devicePlan.buildDescriptionAndCode());
			}
		} else {
			deviceRange = DeviceRange.createWithProvider(dataProvider, type);
			deviceRange.setProductType(ProductType.fromShortName(type));
			deviceRange.setProgram(program.buildDescriptionAndCode());
			deviceRange.setDevicePlanCode(devicePlan.buildDescriptionAndCode());
		}

		programSetupWorkflow.createDeviceRange(deviceRange);
	}

	@When("User fills Device Range section for $type product for non-default institution")
	public void whenUserFillsDeviceRangeSectionForNonDefaultInstitution(String type) {
		DeviceRange deviceRange = DeviceRange.createWithProvider(dataProvider, type);
		deviceRange.setProductType(ProductType.fromShortName(type));
		deviceRange.setIssuerBin(provider.getString(ISSUER_BIN_FOR_DEVICE2));
		deviceRange.setProgram(program.buildDescriptionAndCode());
		deviceRange.setDevicePlanCode(devicePlan.buildDescriptionAndCode());

		programSetupWorkflow.createDeviceRange(deviceRange);
	}

	@When("User fills Device Range section for $type product for an interface")
	public void whenUserFillsDeviceRangeSectionVisaInterface(String type) {
		DeviceRange deviceRange = DeviceRange.createWithProvider(dataProvider, provider, type);
		deviceRange.setProductType(ProductType.fromShortName(type));
		deviceRange.setProgram(program.buildDescriptionAndCode());
		deviceRange.setDevicePlanCode(devicePlan.buildDescriptionAndCode());

		programSetupWorkflow.createDeviceRange(deviceRange);
	}

	private void setPinRequiredToFalse() {
		context.put(ConstantData.IS_PIN_REQUIRED, "FALSE");
	}

	private void setPinRequiredToDefaultState() {
		context.put(ConstantData.IS_PIN_REQUIRED, "TRUE");
	}

	@When("User fills Program section using newApplication for $type product")
	public void whenUserFillsProgramSectionUsingNewApplication(String type) {
		program = Program.createWithProvider(dataProvider, provider);
		program.setProduct(ProductType.fromShortName(type));
		if (!program.getProduct().equalsIgnoreCase(ProductType.DEBIT)) {
			program.setOtherPlanStatementMessagePlan(statementMessagePlan.buildDescriptionAndCode());
			program.setOtherPlanMarketingMessagePlan(marketingMessagePlan.buildDescriptionAndCode());
		}
		program.setFirstWalletPlan(walletPlan.buildDescriptionAndCode());
		program.setDevicePlanPlan1(devicePlan.buildDescriptionAndCode());

		program.setDocumentChecklistPlan(documentCheckListPlan.buildDescriptionAndCode());
		program.setMccRulePlan(mccRulePlan.buildDescriptionAndCode());

		if (program.getProduct().equalsIgnoreCase(ProductType.PREPAID))
			program.setPrepaidStatementPlan(prepaidStatementPlan.buildDescriptionAndCode());

		programSetupWorkflow.createProgram(program, ProductType.fromShortName(type));
		context.put(ContextConstants.PROGRAM, program);
	}
	
	@When("for \"$deviceType\" User create Device Plan for \"$type\" product for \"$interchange\" and \"$priorityPass\" priority pass")
	public void whenUserFillsDevicePlanForInterchangeAndDeviceType(String deviceType,String type,String interchange,String priorityPass) {
		devicePlan = DevicePlan.createProviderForCredit(provider);
		
		devicePlan.setProductType(ProductType.fromShortName(type));
		devicePlan.setAssociation(interchange);
		devicePlan.setPriorityPassIndicator(priorityPass);
		devicePlan.setDeviceType(deviceType);
		
		devicePlan.setBaseDeviceJoiningMemberShipPlan(deviceJoiningAndMemberShipFeePlan.buildDescriptionAndCode());
		devicePlan.setBaseDeviceEventBasedPlan(deviceEventBasedFeePlan.buildDescriptionAndCode());		
		devicePlan.setTransactionLimitPlan(transactionLimitPlan.buildDescriptionAndCode());
		devicePlan.setAfterKYC(transactionPlan.buildDescriptionAndCode()); 
		devicePlan.setBeforeKYC(transactionPlan.buildDescriptionAndCode());

		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}
	
	@When("User fills Device Plan for $productType $deviceType card with transaction fee waived Off")
	public void whenUserFillsDevicePlaWithTransactionFeeWaivedOff(String productType, String deviceType) {
		settingDevicePlanTestData(productType, deviceType); // call to re-usable method
		devicePlan.setTransactionFeeWaiverPlan(provider.getString(TRANSACTION_FEE_WAIVER_PLAN));
		programSetupWorkflow.createDevicePlan(devicePlan);
		context.put(ContextConstants.DEVICE_PLAN, devicePlan);
	}
}