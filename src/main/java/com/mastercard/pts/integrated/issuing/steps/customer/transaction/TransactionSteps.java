package com.mastercard.pts.integrated.issuing.steps.customer.transaction;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codoid.products.exception.FilloException;
import com.mastercard.pts.integrated.issuing.configuration.FinSimSimulator;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AssignPrograms;
import com.mastercard.pts.integrated.issuing.domain.agent.transactions.LoadBalanceRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MID_TID_Blocking;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearchDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.AuthorizationTransactionFactory;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ClearingTestCase;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ReversalTransaction;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.domain.provider.ClearingTestCaseProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.TransactionProvider;
import com.mastercard.pts.integrated.issuing.pages.ValidationException;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.ExcelUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.VisaTestCaseNameKeyValuePair;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceUsageWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;

@Component
public class TransactionSteps {
	private static final Logger logger = LoggerFactory.getLogger(TransactionSteps.class);

	private static final String DEVICE_PRODUCTION_FOLDER = "DEVICE_PRODUCTION_FOLDER";
	private static final String PIN_PRODUCTION_FOLDER = "PIN_PRODUCTION_FOLDER";
	private static final String IPM_INCOMING = "IPM_INCOMING";
	private static final String DEVICE_PRODUCTION = "device production";
	private static final String PIN_PRODUCTION = "pin production";
	private static final String IPMINCOMING = "ipm incoming";
	private static Boolean sameCard = false;
	private static final String ATC = "ATC" ;
	private static final int CONVERSION_FACTOR = 100 ;
	public boolean atcCounterFlag = false;

	@Autowired
	private TestContext context;

	@Autowired
	private FinSimSimulator finSimConfig;

	@Autowired
	private TransactionWorkflow transactionWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private AuthorizationTransactionFactory transactionFactory;

	@Autowired
	private TransactionProvider transactionProvider;
	
	@Autowired
	private DeviceUsageWorkflow deviceUsageWorkflow;

	@Autowired
	private ClearingTestCaseProvider clearingTestCaseProvider;

	@Autowired
	private VisaTestCaseNameKeyValuePair visaTestCaseNameKeyValuePair;

	private String authFilePath;

	private String arnNumber;

	private String transactionAmount = "20.00";

	private boolean midTidFlag=false;

	private String midTidCombination="";

	private static String PASS_MESSAGE = "Transaction is succcessful!  - Expected Result : ";

	private static String FAILED = "Transaction failed! ";

	private static String FAIL_MESSAGE = FAILED + " -  Result : ";
	
	private static String INVALID_KEYS = "00999 - Example ETEC1 - 0213";
	
	private boolean declineMerchantRiskBased=false;
	
	public boolean membershipFlag = false;

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@When("perform an $transaction MAS transaction")
	@Aliases(values = { "a sample simulator \"$transaction\" is executed", "user performs an $transaction MAS transaction" })
	@Given("perform an $transaction MAS transaction")
	public void givenTransactionIsExecuted(String transaction) {

		String temp = transaction;
		context.put(ConstantData.TRANSACTION_NAME, transaction);
		if(!Objects.isNull(context.get(ConstantData.IS_PIN_REQUIRED))){
			MiscUtils.reportToConsole("Pin Required value : " + context.get(ConstantData.IS_PIN_REQUIRED));				
		if ("true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString())) {
			// ECOMM are pinless tranasactions
			if (!transaction.toLowerCase().contains("ecom"))
				temp = transaction + "_PIN";
		}
		}
		performOperationOnSamecard(false);
		givenOptimizedTransactionIsExecuted(temp);
		String txnDate=context.get(ContextConstants.INSTITUTION_DATE);
		context.put(ContextConstants.TRANSACTION_DATE,txnDate);
	}

	@When("perform an $transaction MAS transaction on the same card")
	@Aliases(values={"a sample simulator \"$transaction\" is executed on the same card",
	"user performs an \"$transaction\" MAS transaction on the same card"})
	@Given("perform an $transaction MAS transaction on the same card")
	public void givenTransactionIsExecutedOnTheSameCard(String transaction) {
		String temp = transaction;
		// we need to use _PIN Profile from MAS test data template */
		MiscUtils.reportToConsole("Pin Required value : " + context.get(ConstantData.IS_PIN_REQUIRED));
		if ("true".equalsIgnoreCase(context.get(ConstantData.IS_PIN_REQUIRED).toString())) {
			// ECOMM are pinless tranasactions */
			if (!transaction.toLowerCase().contains("ecom"))
				temp = transaction + "_PIN";
		}
		performOperationOnSamecard(true);
		givenOptimizedTransactionIsExecuted(temp);
	}

	private static void performOperationOnSamecard(Boolean val) {
		sameCard = val;
	}

	@When("user performs an optimized $transaction MDFS transaction")
	@Given("user performs an optimized $transaction MDFS transaction")
	public void givenOptimizedTransactionIsExecutedForMdfs(String transaction) {
		givenOptimizedTransactionIsExecuted(transaction);
	}

	@When("user performs an optimized $transaction MAS transaction")
	@Given("user performs an optimized $transaction MAS transaction")
	public void givenOptimizedTransactionIsExecuted(String transaction) {
		transactionWorkflow.browserMinimize(); // minimize browser
		// operation of MAS/MDFS ... Storing transaction name in context to use it at runtime
		context.put(ConstantData.TRANSACTION_NAME, transaction);
		Transaction transactionData = generateMasTestDataForTransaction(transaction);
		transactionWorkflow.performOptimizedMasTransaction(transaction, transactionData, sameCard);
	}
	
	@When("perform an $type MAS transaction with wrong keys")
	public void performTransactionWithWrongKeys(String transaction) {
		String originalValue = TransactionWorkflow.STAGE_KEYS ;
		TransactionWorkflow.STAGE_KEYS = INVALID_KEYS;
		givenTransactionIsExecuted(transaction);
		TransactionWorkflow.STAGE_KEYS = originalValue;
	}

	@When("user performs generate TestData for an optimized $transaction MAS transaction")
	@Given("user performs generate TestData for an optimized $transaction MAS transaction")
	public void givenGenerateTestDataForOptimizedTransactionIsExecuted(String transaction) {
		// Storing transaction name in context to use it at runtime
		context.put(ConstantData.TRANSACTION_NAME, transaction);
		generateMasTestDataForTransaction(transaction);
	}

	@Given("user updates ATC value as $type and value as $ATCValue")
	@Then("user updates ATC value as $type and value as $ATCValue")
	public void userUpdateATCValueAsRequired(String flag, String atcvalue) {
		atcCounterFlag = true;
		Device device = context.get(ContextConstants.DEVICE);
		device.setUpdatedATCValue(atcvalue);
		context.put(ContextConstants.DEVICE, device);
	}

	private Transaction generateMasTestDataForTransaction(String transaction) {
		MiscUtils.reportToConsole("********** start generateMasTestDataForTransaction ********");
		Device device = context.get(ContextConstants.DEVICE);
		DevicePlan devicePlan = null;
		// this line of code reads data from the "AuthorizationTransaction_DataDriven.xls" at \\Isser-automation-epam\src\main\resources\config\Data folder as the
		// "Transaction Templates" sheet has the template information
		Transaction transactionData = transactionProvider.loadTransaction(transaction);

		// when data is dynamically passed when scripts run from end-2-end
		if (device != null) {
			MiscUtils.reportToConsole("********** Fetching data from DeviceContect ********");
			// _____________________FOR PINLESS CARD________________ device plan context is used to get Expiry Date incase of PinLess card
			if (!Constants.DATA_DRIVEN_CARD_BOARDING.equalsIgnoreCase("YES")) {
				devicePlan = context.get(ContextConstants.DEVICE_PLAN);
				device.setServiceCode(devicePlan.getServiceCode());
				if ("YES".equalsIgnoreCase(devicePlan.getIsPinLess())) {
					device.setExpirationDate(devicePlan.getExpiryDate());
					device.setPinNumberForTransaction("PINLESS");
				}
			} else {
				if ("YES".equalsIgnoreCase(device.getIsPinRequired())) {
					device.setExpirationDate(DateUtils.getDateInYYMM(device.getExpirationDate()));
					device.setPinNumberForTransaction("PINLESS");
				}
			}
			// ____________FOR PINLESS CARD__________CURRENCY VAL FROM EXCEL _________ fetching currency value from excel
			Transaction tempData = transactionProvider.createWithProvider(provider);
			// this line of code is temporary as this will only work for Single wallet currency for multi wallet, we may have to set other setter
			// --> setIssuerCountryCode, setIssuerCurrencyCode, setCardHolderBillingCurrency
			device.setCurrency(tempData.getCurrency());

			if (!Constants.DATA_DRIVEN_CARD_BOARDING.equalsIgnoreCase("YES")) {
				if ("Fixed [F]".equalsIgnoreCase(devicePlan.getExpiryFlag())) {
					device.setExpirationDate(devicePlan.getExpiryDate());
				}
			} else {
				if ("Fixed [F]".equalsIgnoreCase(device.getExpiryFlag())) {
					device.setExpirationDate(device.getExpirationDate());
				}
			}

			// __________________CURRENCY VAL FROM EXCEL _________ This is a Single Wallet, Single Currency INDIA card */
			settingValuesDynamicallyFromDeviceContext(device, transactionData);
			// setting values of Card Data Element (Card Profile) which are placed in the "Transaction Templates" sheet
			setCardDataDynamically(device, transactionData, transaction);
			// setting values of Data Element which are placed in the "Transaction Templates" sheet
			setDeElementsDynamically(device, transactionData, transaction);

		}
		// else block for when scripts are running from excel - AuthorizationTransaction_DataDriven alone
		else {
			transactionData.setIssuerCountryCode(transactionWorkflow.getCurrencyToBeUsed(transactionData.getDeKeyValuePair().get("049")));
			transactionData.setIssuerCurrencyCode(transactionWorkflow.getCurrencyToBeUsed(transactionData.getDeKeyValuePair().get("049")));
			transactionData.setCardHolderBillingCurrency(transactionWorkflow.getCurrencyToBeUsed(transactionData.getDeKeyValuePair().get("061.13")));
		}
		// creating & import card profile to temp location ex:C:\Users\e071200\AppData\Local\Temp\20171013_IssuingTests_7323176887769829413
		transactionData.setCardProfile(transactionFactory.createCsvCardProfile(transactionData));
		// creating & import testcase/transaction file to temp location ex: * C:\Users\e071200\AppData\Local\Temp\20171013_IssuingTests_7323176887769829413
		transactionData.setTestCase(transactionFactory.createCsvTesCase(transactionData));
		return transactionData;
	}

	private void setDeElementsDynamically(Device device, Transaction transactionData, String transaction) {
		MiscUtils.reportToConsole("********** Start setDeElementsDynamically ********");
		if (!"pinless".equalsIgnoreCase(device.getPinNumberForTransaction()) && !transactionWorkflow.isContains(transaction, "ECOMM_PURCHASE") && !transactionWorkflow.isContains(transaction, ConstantData.THREE_D_SECURE_TRANSACTION)) // ecomm transactions cannot have a PIN
			transactionData.setDeKeyValuePairDynamic("052", device.getPinNumberForTransaction());
		// data format is 12 digits hence leftpad with 0
		transactionData.setDeKeyValuePairDynamic("004", StringUtils.leftPad(device.getTransactionAmount(), 12, "0"));
		if (transactionWorkflow.isContains(transaction, "BALANCE_INQUIRY") || transactionWorkflow.isContains(transaction, "PIN_CHANGE") || transactionWorkflow.isContains(transaction, "ASI_")) {
			// this value is expected to be 0's for Balance Enquiry
			transactionData.setDeKeyValuePairDynamic("004", "000000000000");
		}

		if (midTidFlag) {
			MID_TID_Blocking midtidBlocking = context.get(ContextConstants.MID_TID_BLOCKING);
			transactionData = transactionWorkflow.setDEElementsForMIDTID(transactionData, midtidBlocking, midTidCombination);
		}

		if (declineMerchantRiskBased) {
			transactionData.setDeKeyValuePairDynamic("048.TLV.42.01.02", ConstantData.DECLINE_MERCHANT_RISK_VALUE);
		}
		// changed ECOMMERCE to ECOM
		if (transactionWorkflow.isContains(transaction, "ECOMM_PURCHASE") || transactionWorkflow.isContains(transaction, "ASI_") || transactionWorkflow.isContains(transaction, "MMSR")
				|| transactionWorkflow.isContains(transaction, ConstantData.THREE_D_SECURE_TRANSACTION) || transactionWorkflow.isContains(transaction, "3D_SECURE_SCENARIO")) {
			// for pinless card, we are not performing CVV validation as we do not know the CVV as this is fetched from embosing file on LInuxbox
			transactionData.setDeKeyValuePairDynamic("048.TLV.92", device.getCvv2Data()); // Transaction currency code
		}
		if(transaction.equalsIgnoreCase("INT_MSR_CASH_ADVANCE")){
			transactionData.setDeKeyValuePairDynamic("048.TLV.92", device.getCvv2Data());
		} 

		// This is a Single Wallet, Single Currency INDIA card
		// transactionData.setDeKeyValuePairDynamic("049", device.getCurrency()); // Transaction currency code
		// transactionData.setDeKeyValuePairDynamic("050", device.getCurrency()); // Settlement currency code
		// transactionData.setDeKeyValuePairDynamic("051", device.getCurrency()); // CardHolder billing currency code
		// transactionData.setDeKeyValuePairDynamic("061.13", device.getCurrency()); // POS country code
	}

	private void settingValuesDynamicallyFromDeviceContext(Device device, Transaction transactionData) {
		MiscUtils.reportToConsole("********** Start settingValuesDynamicallyFromDeviceContext ********");
		transactionData.setCardNumber(device.getDeviceNumber());
		transactionData.setExpirationYear(device.getExpirationDate());
		transactionData.setCardSequenceNumber(device.getSequenceNumber());
		transactionData.setPinForTransaction(device.getPinNumberForTransaction());
		transactionData.setIssuerCountryCode(device.getCurrency());
		transactionData.setIssuerCurrencyCode(device.getCurrency());
		transactionData.setCardHolderBillingCurrency(device.getCurrency());
	}

	private void setCardDataDynamically(Device device, Transaction transactionData, String transaction) {
		MiscUtils.reportToConsole("********** Start setCardDataDynamically ********");
		transactionData.setCardDataElementsDynamic("035.01", device.getDeviceNumber());
		transactionData.setCardDataElementsDynamic("035.03", device.getExpirationDate());
		transactionData.setCardDataElementsDynamic("045.02", device.getDeviceNumber());
		transactionData.setCardDataElementsDynamic("045.06", device.getExpirationDate());
		transactionData.setCardDataElementsDynamic("035.04", device.getServiceCode());
		if (atcCounterFlag)
		{
			transactionData.setCardDataElementsDynamic("055.9F36", device.getUpdatedATCValue());
		}
		if (transactionWorkflow.isContains(transaction, "EMV")) {
			transactionData.setCardDataElementsDynamic("035.05", "000" + device.getIcvvData());
		} else if (transactionWorkflow.isContains(transaction, "MSR") || transactionWorkflow.isContains(transaction, "FALLBACK") ) {
			transactionData.setCardDataElementsDynamic("035.05", "000" + device.getCvvData());
		}
		if(transaction.contains(ConstantData.MSR_NFC_PURCHASE)){
			transactionData.setCardDataElementsDynamic("035.05", "*************");
		}
	}

	@Given("Auth file is provided for $iteration")
	public void givenAuthFileIsProvided(String iteration) {
		ClearingTestCase testCase = clearingTestCaseProvider.loadTestCase(iteration);
		authFilePath = testCase.getAuthFilePath();
		transactionAmount = testCase.getTransactionFeeAmount();
	}

	@When("Auth file is generated after transaction")
	@Then("Auth file is generated after transaction")
	@Given("Auth file is generated after transaction")
	public void generateAuthFile() {
		transactionWorkflow.authFileGeneration();
	}

	@When("Auth file is generated")
	@Then("Auth file is generated")
	@Given("Auth file is generated")
	public void givenAthFileIsGenerated() throws IOException {
		String fileName = "AuthFileName.txt";
		String authFileName = transactionWorkflow.getFileData(fileName);
		String[] tempName = authFileName.split(".ath");
		authFileName = tempName[tempName.length - 1] + ".ath";
		assertNotNull("Auth fileName is not null", authFileName);
		authFilePath = transactionWorkflow.getTempDirectoryLocationForSimulatorResults() + "\\" + authFileName;
		logger.info("authFilePath Path is ", authFilePath);
	}

	@When("Auth file is loaded into MCPS and processed")
	public void loadAuthFileToMCPS() {
		logger.info("TXN Date "+context.get("transaction_date"));
		String txnDate=context.get(ContextConstants.TRANSACTION_DATE);
		context.put(ContextConstants.INSTITUTION_DATE,txnDate);
		arnNumber = transactionWorkflow.loadAuthFileToMCPS(authFilePath);
		if (arnNumber.isEmpty()) {
			logger.error("*********ARN number is empty");
		} else {
			logger.info("********** ARN number is ", arnNumber);
		}
	}

	@Given("update IPM file for trasaction reversal")
	@When("update IPM file for trasaction reversal")
	public void addAndmodify0025MessageReversalIndicator() throws AWTException {
		transactionWorkflow.assignUniqueFileId();
		transactionWorkflow.addAndmodify0025MessageReversalIndicator();
		logger.info("updated IPM file for Reversal");
	}

	@Alias("test results are reported")
	@When("$tool test results are verified")
	@Then("$tool test results are verified")
	public void thenTestResultsAreReported(String tool) {
		String testResults;
		if (!"mdfs".contains(tool.toLowerCase())) {
			testResults = transactionWorkflow.verifyTestResults();
		} else {
			testResults = transactionWorkflow.verifyTestResultsOnMdfs();
		}
		transactionWorkflow.browserMaximize(); // restoring browser after

		if (testResults.contains("Validations OK")) {
			logger.info("Expected Result :- ", testResults);
			assertTrue("Transaction is succcessful!  - Expected Result : " + testResults, true);
		} else if (testResults.contains("Validations Not OK")) {
			assertFalse("Transaction failed!  -  Result : " + testResults, false);
			throw new ValidationException("Transaction failed! -  Result : " + testResults);
		} else {
			logger.error("Test Results retrieved from Simulator :- ", testResults);
			assertFalse("Transaction failed! ", false);
			throw new ValidationException("Transaction failed!");
		}
	}

	@Then("$tool test results are verified with code $code Not OK")
	public void thenTestResultsAreVerifiedForCodeNotOK(String tool, String code) {
		String testResults;
		if ("mas".contains(tool.toLowerCase())) {
			testResults = transactionWorkflow.verifyTestResults();
		} else if ("mdfs".contains(tool.toLowerCase())) {
			testResults = transactionWorkflow.verifyTestResultsOnMdfs();
		} else {
			testResults = "Unsupported tool type!";
			throw new ValidationException(testResults);
		}
		transactionWorkflow.browserMaximize(); // restoring browser after
		logger.info("Expected Result :- {}", testResults);
		logger.info("Code :- {}", code);

		if (testResults.contains("Validations OK")) {
			assertFalse("Transaction failed!  -  Result : " + testResults, false);
			throw new ValidationException("Transaction failed! -  Result : " + testResults);
		} else if (testResults.contains("Validations Not OK") && testResults.contains(code)) {
			assertTrue("Transaction is succcessful!  - Expected Result : " + testResults, true);
		} else {
			assertFalse("Transaction failed! Code or status is incorrect!", false);
			throw new ValidationException("Transaction failed! Code or Description does not Match!");
		}
	}

	@When("connection to $simulator is established")
	@Then("connection to $simulator is established")
	@Given("connection to $simulator is established")
	public void launchWiniumAndSimulator(String simulator) {
		transactionWorkflow.launchWiniumAndSimulator(simulator);
	}

	@When("PIN is retrieved successfully with data from Pin Offset File")
	@Then("PIN is retrieved successfully with data from Pin Offset File")
	public void thenPINIsRetrievedSuccessfully(){
		Device device = context.get(ContextConstants.DEVICE);
		if(Objects.isNull(device.getPinNumberForTransaction())){
			Transaction transactionData = Transaction.generateFinSimPinTestData(device, finSimConfig, provider);
			String pinNumber = transactionWorkflow.getPinNumber(transactionData);
			logger.info("FINSim PIN Number generated : {} ", pinNumber);
			Assert.assertTrue("INVALID PIN", !pinNumber.isEmpty());
			ExcelUtils.updateDevicePIN(pinNumber,device.getDeviceNumber());
			device.setPinNumberForTransaction(pinNumber);
		}
	}

	@When("PIN is created for Pin Change First Transaction")
	@Then("PIN is created for Pin Change First Transaction")
	public void thenPINIsCreatedForPinChangeFirstTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		device.setPinNumberForTransaction(ConstantData.INVALID_PIN);
		context.put(ContextConstants.DEVICE, device);
	}

	@When("$simulatorName simulator is closed")
	@Then("$simulatorName simulator is closed")
	public void thenclosesimulator(String simulatorName) {
		transactionWorkflow.closeSimulator(simulatorName);
		transactionWorkflow.browserMaximize(); // restoring browser after
	}

	@Given("transaction status is \"$type\"")
	@When("transaction status is \"$type\"")
	@Then("transaction status is \"$type\"")
	public void thenTransactionStatusIsPresentmentMatched(String type) {
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		assertEquals(type, transactionWorkflow.getAuthorizationStatus(arnNumber, ts, type));
	}

	@Then("transaction fee is correctly posted")
	public void thenTransactionFeeIsCorrecltyPosted() {
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		assertEquals(transactionAmount, transactionWorkflow.getFeePostingStatus(arnNumber, ts));
	}

	@Then("search with ARN in transaction screen and balance should be credited")
	public void thenSearchWithARNInTransactionScreenCheckReversalStatusAndBalanceShouldBeCredited() {
		ReversalTransaction rt = ReversalTransaction.getProviderData(provider);
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		rt.setArn(context.get(ConstantData.ARN_NUMBER));
		BigDecimal actualTransactionAmount = new BigDecimal(rt.getAmount());
		assertEquals(new BigDecimal(transactionWorkflow.getFeePostingStatus(rt.getArn(), ts)), actualTransactionAmount);
	}

	@Then("search with ARN in transaction screen and status should be Reversal [R]")
	public void thenSearchWithARNInTransactionScreenCheckReversalStatusAndStatusShouldBeReversal() {
		ReversalTransaction rt = ReversalTransaction.getProviderData(provider);
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		rt.setArn(context.get(ConstantData.ARN_NUMBER));
		assertEquals(transactionWorkflow.searchTransactionWithArnAndGetStatus(rt.getArn(), ts), "Reversal [R]");
	}

	@Then("search with device in transaction screen and status for wallet to wallet transfer transaction")
	public void thenSearchWithDeviceInTransactionScreenCheckReversalStatusAndStatusShouldBeReversal() {
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		Device device = context.get(ContextConstants.DEVICE);
		Assert.assertTrue("successfully completed the wallet to wallet fund transfer",
				transactionWorkflow.searchTransactionWithDeviceAndGetStatus(device, ts).contains("Wallet to Wallet Transfer(Credit))"));
	}
	
	
	@When("search with device in transaction screen and Verify Joining and Membership Fees")
	@Then("search with device in transaction screen and Verify Joining and Membership Fees")
	public void verifyJoiningAndMembershipFeesOnTransactionSearch() {
		
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		Device device = context.get(ContextConstants.DEVICE);
		device.setJoiningFees(provider.getString("JOINING_FEES"));
		device.setMemberShipFees(provider.getString("MEMBERSHIP_FEES"));
		membershipFlag = true;
		assertThat(transactionWorkflow.searchTransactionWithDeviceAndGetFees(device, ts, membershipFlag), Matchers.hasItems(device.getJoiningFees(), device.getMembershipFees()));
	}
	
	@When("search with device in transaction screen and Verify Joining Fee")
	@Then("search with device in transaction screen and Verify Joining Fee")
	public void verifyJoiningFeeOnTransactionSearch() {
		
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		Device device = context.get(ContextConstants.DEVICE);
		device.setJoiningFees(provider.getString("JOINING_FEES"));
		assertThat(transactionWorkflow.searchTransactionWithDeviceAndGetFees(device, ts, membershipFlag), Matchers.hasItems(device.getJoiningFees()));
	}

	@When("user performs load balance request")
	public void whenUserPerformsLoadBalanceRequest() {
		Device device = context.get(ContextConstants.DEVICE);
		LoadBalanceRequest lbr = LoadBalanceRequest.getProviderData(provider);
		String loadRequestReferenceNumber = transactionWorkflow.performLoadBalanceRequestAndGetRequestReferenceNumber(device, lbr);
		lbr.setLoadRequestReferenceNumber(loadRequestReferenceNumber);
		context.put(ContextConstants.LOAD_BALANCE_REQUEST, lbr);
	}
	
	@When("user performs load balance request for Joining and Membership plan")
	public void whenUserPerformsLoadBalanceRequestforJoiningandMemberShipPlan() {
		Device device = context.get(ContextConstants.DEVICE);
		device.setDeviceNumber(context.get(CreditConstants.DEVICE_NUMBER));
		LoadBalanceRequest lbr = LoadBalanceRequest.getProviderData(provider);
		String loadRequestReferenceNumber = transactionWorkflow.performLoadBalanceRequestAndGetRequestReferenceNumber(device, lbr);
		lbr.setLoadRequestReferenceNumber(loadRequestReferenceNumber);
		context.put(ContextConstants.LOAD_BALANCE_REQUEST, lbr);
	}

	@When("load balance request is successful")
	@Then("load balance request is successful")
	public void thenLoadBalanceRequestIsSuccessful() {
		assertThat("Load Balance Request Failed", transactionWorkflow.getLoadBalanceRequestSuccessMessage(), containsString("Load balance request forwarded for approval with request number :"));
	}

	@When("user performs load balance approve")
	public void whenUserPerformsLoadBalanceApprove() {
		Device device = context.get(ContextConstants.DEVICE);
		LoadBalanceRequest lbr = context.get(ContextConstants.LOAD_BALANCE_REQUEST);
		transactionWorkflow.performLoadBalanceApprove(device, lbr);
	}

	@When("load balance approve is successful")
	@Then("load balance approve is successful")
	public void thenLoadBalanceApproveIsSuccessful() {
		assertThat("Load Balance Approve Failed", transactionWorkflow.getLoadBalanceApproveSuccessMessage(), containsString("approved successfully."));
	}

	@When("user initiates settlement for agency")
	public void whenUserInitiatesSettlementForAgency() {
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		transactionWorkflow.initiateSettlementForAgency(details.getBranchId(), details.getProgramCode());
	}

	@Then("settlement is initiated successfully")
	public void thenSettlementIsInitiatedSuccesfully() {
		assertThat("Settlement Initiative Failed", transactionWorkflow.getSettlementInitiativeSuccessMessage(), containsString("Settlement initiated successfully and Settlement Referance No :"));
	}

	@When("perform an $transaction VISA transaction")
	@Given("perform an $transaction VISA transaction")
	public void givenVisaTransactionIsExecuted(String transaction) {
		// Storing transaction name in context to use it at runtime
		context.put(ConstantData.TRANSACTION_NAME, transaction);
		MiscUtils.reportToConsole("Pin Required value : " + context.get(ConstantData.IS_PIN_REQUIRED));
		performOperationOnSamecard(false);
		logMessage("VISA Transaction being performed : ", transaction);
		transactionWorkflow.performVisaTransaction(transaction);
	}

	@When("$tool test results are verified for $transaction")
	@Then("$tool test results are verified for $transaction")
	@Given("$tool test results are verified for $transaction")
	public void thenVisaTestResultsAreReported(String tool, String transaction) {
		verifyVisaTransactionResult(getVisaTestResult(transaction), Optional.empty());
	}
	
	@Then("verify that response code $code is received for $transaction")
	public void verifyVisaResponseCode(String responseCode, String transaction) {
		verifyVisaTransactionResult(getVisaTestResult(transaction), Optional.of(responseCode));
	}
	
	public String getVisaTestResult(String transaction) {
		String transactionName = visaTestCaseNameKeyValuePair.getVisaTestCaseToSelect(transaction);
		logMessage("VISA Transaction Test Case Name : ", transactionName);
		String testResults = transactionWorkflow.verifyVisaOutput(transactionName);
		transactionWorkflow.browserMaximize();
		transactionWorkflow.disconnectAndCloseVts();
		return testResults;
	}

	private void verifyVisaTransactionResult(String testResults, Optional<String> responseCode) {		
		final String VALIDATION_OK = "validations is ok"; 
		final String F39_RESPONSE = "F39 response is : ";
		
		if (!responseCode.isPresent()) {
			assertTrue(FAIL_MESSAGE + testResults, transactionWorkflow.isContains(testResults, VALIDATION_OK));			
		} else {
			assertTrue(FAIL_MESSAGE + testResults, transactionWorkflow.isContains(testResults, F39_RESPONSE + responseCode.get()));
		}		
	}

	private void logMessage(String message1, String message2) {
		logger.info(message1, message2);
		MiscUtils.reportToConsole(message1 + message2);
	}

	@Given("ARN is retrieved from transaction search page")
	@Then("ARN is retrieved from transaction search page")
	public void arnIsRetrievedFromTransactionSearchPage() {
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		Device device = context.get(ContextConstants.DEVICE);
		String deviceNumber = device.getDeviceNumber();
		String arn = transactionWorkflow.getARN(deviceNumber, ts);
		context.put(ConstantData.ARN_NUMBER, arn);
		logger.info("ARN for device transactions = {} ", arn);
	}

	@Given("user update folder permission through WinSCP for $type folder")
	@When("user update folder permission through WinSCP for $type folder")
	public void connectionToApplicationIsEstablished(String type) {
		transactionWorkflow.launchWinSCP();
		transactionWorkflow.loginToWinSCP();
		if (type.equalsIgnoreCase(DEVICE_PRODUCTION))
			transactionWorkflow.setFolderPermisson(provider.getString(DEVICE_PRODUCTION_FOLDER));
		else if (type.equalsIgnoreCase(PIN_PRODUCTION))
			transactionWorkflow.setFolderPermisson(provider.getString(PIN_PRODUCTION_FOLDER));
		else if (type.equalsIgnoreCase(IPMINCOMING))
			transactionWorkflow.setFolderPermisson(provider.getString(IPM_INCOMING));
		transactionWorkflow.closeWinSCP();
	}

	@Then("user sets invalid pin")
	@When("user sets invalid pin")
	public void userSetInvalidPin(){
		Device device = context.get(ContextConstants.DEVICE);
		device.setPinNumberForTransaction(ConstantData.INVALID_PIN);
		context.put(ContextConstants.DEVICE, device);
	}
	
	@Given("set the transaction amount to $amount in program currency")
	public void setTransactionAmountFromStep(String amount){
		Device device = context.get(ContextConstants.DEVICE);
		if(device.getExchangeRate()==null){
			device.setTransactionAmount(Integer.toString((Integer.parseInt(amount)*CONVERSION_FACTOR)));
		}
		else{
			Double moderatedAmount = (Double.parseDouble(amount))/(Double.parseDouble(device.getExchangeRate()));
			device.setTransactionAmount(Long.toString(Math.round(moderatedAmount*100.0)));
		}
		context.put(ContextConstants.DEVICE, device);
	}

	@Given("User set MID_TID flag $type and MID_TID Combination $type")
	@When("User set MID_TID flag $type and MID_TID Combination $type")
	public void userSetMIDTIDFlagAndCaseValue(boolean midTidFlag, String midTidCombination) {
		this.midTidFlag = midTidFlag;
		this.midTidCombination = midTidCombination;
	}
	
	/***
	 * This method is implemented to change transaction amount for transaction
	 * @param amount : Decimal representation for amount
	 * */
	@When("user updates transaction amount to $amount")
	@Given("user updates transaction amount to $amount")
	public void userSetTransactionAmount(Double amount){
		int i = new Double(amount * CONVERSION_FACTOR).intValue(); 
		Device device = context.get(ContextConstants.DEVICE);
		device.setTransactionAmount(Integer.toString(i));
		context.put(ContextConstants.DEVICE, device);
	}
	
	@When("perform an $transaction MAS transaction with amount $amount")
	public void givenGenerateTestDataForOptimizedTransactionWithDifferentAmountIsExecuted(String transaction, String amount) {
		// Storing transaction name in context to use it at runtime
		Device device = context.get(ContextConstants.DEVICE);
		device.setTransactionAmount(amount);
		context.put(ConstantData.TRANSACTION_NAME, transaction);
		performOperationOnSamecard(false);
		givenOptimizedTransactionIsExecuted(transaction);
	}

	@When("search transaction with device number on transaction search screen")
	@Then("search transaction with device number on transaction search screen")
	public void thenSearchWithDeviceInTransactionScreenAndVerify() {
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		Device device = context.get(ContextConstants.DEVICE);
		TransactionSearchDetails transactionSearch = transactionWorkflow.searchTransactionWithDeviceAndGetDetails(device, ts);
		Assert.assertTrue("Successfully transaction search",transactionSearch.getDeviceNumber().equalsIgnoreCase(device.getDeviceNumber()));
		context.put(ContextConstants.TRANSACTION_SEARCH_DETAILS, transactionSearch);
		context.put(ContextConstants.DEVICE, device);
	}
	
	@When("user add transaction reversal with reason $reversalReason")
	@Then("user add transaction reversal with reason $reversalReason")
	public void addTransactionReversal(String reversalReason) {
		Device device = context.get(ContextConstants.DEVICE);
		ReversalTransaction rt = ReversalTransaction.getProviderData(provider);
		assertEquals("Record Added Successfully.", transactionWorkflow.addTransactionReversal(device.getDeviceNumber(), reversalReason, rt.getAmount()));
	
		if((provider.getString(Constants.FOR_LOYALTY) != null) && (provider.getString(Constants.FOR_LOYALTY).equalsIgnoreCase("yes"))) {
			Double availablePoints = 0.0;
			Double availableLP = context.get(Constants.AVAILABLE_LOYALTY_POINTS);
			if(availableLP != 0.0)
				availablePoints = (Double)context.get(Constants.AVAILABLE_LOYALTY_POINTS) - ((Double.parseDouble(rt.getAmount()) * (Double)context.get(ContextConstants.PROMOTION_PLAN_POINTS_EARNED)) / (Double)context.get(ContextConstants.PROMOTION_PLAN_AMT_SPENT));
			context.put(Constants.AVAILABLE_LOYALTY_POINTS, Math.floor(availablePoints));
			context.put(Constants.ACCUMULATED_REVERSED_POINTS, Math.floor((Double.parseDouble(rt.getAmount()) * (Double)context.get(ContextConstants.PROMOTION_PLAN_POINTS_EARNED)) / (Double)context.get(ContextConstants.PROMOTION_PLAN_AMT_SPENT)));
		}
	}

	@When("User updates DE Value for Decline Merchant Risk Based Decision Transaction to $type for $transaction")
	@Given("User updates DE Value for Decline Merchant Risk Based Decision Transaction to $type")
	public void userUpdateDEValueForRiskBasedDecisionTransaction(String value, String transaction) {
		Transaction transactionData = transactionProvider.loadTransaction(transaction);
		transactionData.setDeKeyValuePairDynamic(ConstantData.UNIVERSAL_CARDHOLDER_AUTHENTICATION_FIELD, value);
	}

	@Given("User sets Decline Merchant Risk Based Decisioning Transaction flag $type")
	@When("User sets Decline Merchant Risk Based Decisioning Transaction flag $type")
	public void userSetMIDTIDFlagAndCaseValue(boolean declineMerchantRiskBased) {
		this.declineMerchantRiskBased = declineMerchantRiskBased;
	}

	@Given("user update IPM file to get status $status")
	@When("user update IPM file to get status $status")
	public void userUpdateIPMForDuplicateRecordCheck(String status) {
		Transaction trasactiondata = Transaction.createWithProvider(provider);
		transactionWorkflow.manipulateIPMData(status, trasactiondata);
	}
	
	@Given("user performs reversal transaction of type $type")
	@Then("user performs reversal transaction of type $type")
	public void reverseTransaction(String type){
		String transaction = context.get(ConstantData.TRANSACTION_NAME);
		transactionWorkflow.reverseTransaction(transaction,type);
	}
	
	@Given("user performs partial reversal transaction of type $type with reversal amount $amount")
	@Then("user performs partial reversal transaction of type $type with reversal amount $amount")
	public void partialReverseTransaction(String type, int amount ){
		String transaction = context.get(ConstantData.TRANSACTION_NAME);
		transactionWorkflow.partialReverseTransaction(transaction, type,String.valueOf(amount*CONVERSION_FACTOR));
	}
	
	@When("verify that the device event fees for $reason is levied for $cardType card")
	@Then("verify that the device event fees for $reason is levied for $cardType card")
	public void verifyDeviceEventFeeLevied(@Named("cardType") String cardType, @Named("reason") String reason) {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionSearch ts = TransactionSearch.getProviderData(provider);
		DeviceEventBasedFeePlan deviceEventBasedPlan = context.get(ContextConstants.DEVICE_EVENT_BASED_FEE);
		Assert.assertTrue("The device event fees are not as applied", 
				transactionWorkflow.verifyDeviceEventFeeApplied(device, reason, ts, deviceEventBasedPlan, cardType));
	}
}
