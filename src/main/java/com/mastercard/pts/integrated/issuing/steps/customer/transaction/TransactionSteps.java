package com.mastercard.pts.integrated.issuing.steps.customer.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.FinSimSimulator;
import com.mastercard.pts.integrated.issuing.configuration.MasSimulator;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.TransactionTestDataForMAS;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;

@Component
public class TransactionSteps {
	private static final Logger logger = LoggerFactory.getLogger(TransactionSteps.class);

	@Autowired
	private TestContext context;

	@Autowired
	private MasSimulator simulator;

	@Autowired
	private FinSimSimulator finSimConfig;

	@Autowired
	private TransactionWorkflow transactionWorkflow;

	@Autowired
	private KeyValueProvider provider;

	private String athFileName;

	private String arnNumber;

	private String transactionAmount;

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@When("perform an $transaction MAS transaction")
	@Alias("a sample simulator \"$transaction\" is executed")
	@Given("perform an $transaction MAS transaction")
	public void givenTransactionIsExecuted(String transaction){
		Device device = context.get(ContextConstants.DEVICE);
		Transaction transactionData = Transaction.createWithProviderAndGenerateTestData(device, provider);
		String[] deElements = testDataForAuthorizationTransactionOnMas(transactionData);
		Transaction transactionDataForTransaction = setDataForTransaction(transaction, transactionData, deElements);
		transactionWorkflow.performMASTransaction(transactionDataForTransaction);
	}

	@When("perform an $transaction MAS transaction sample")
	@Alias("a sample simulator \"$transaction\" is executed sample")
	@Given("perform an $transaction MAS transaction sample")
	public void givenASampleSimulatorIsExecutedSample(String transaction){

		Transaction transactionData = Transaction.createWithProviderAndGenerateTestData();
		String[] deElements = testDataForAuthorizationTransactionOnMas(transactionData);
		Transaction transactionDataForTransaction = setDataForTransaction(transaction, transactionData, deElements);
		transactionWorkflow.performMASTransaction(transactionDataForTransaction);
	}

	@When("perform an $transaction MAS transaction on the same card")
	@Alias("a sample simulator \"$transaction\" is executed on the same card")
	@Given("perform an $transaction MAS transaction on the same card")
	public void givenTrasactionIsExecutedOnSameCard(String transaction){
		Device device = context.get(ContextConstants.DEVICE);
		Transaction transactionData = Transaction.createWithProviderAndGenerateTestData(device, provider);
		String[] deElements = testDataForAuthorizationTransactionOnMas(transactionData);
		Transaction transactionDataForTransaction = setDataForTransaction(transaction, transactionData, deElements);
		transactionWorkflow.performTransaction(transactionDataForTransaction);
	}

	@When("perform a sample $transaction MAS transaction on the same card")
	@Alias("a sample simulator \"$transaction\" is executed sample on the same card")
	@Given("perform a sample $transaction MAS transaction on the same card")
	public void givenSampleTrasactionIsExecutedOnSameCard(String transaction){

		Transaction transactionData = Transaction.createWithProviderAndGenerateTestData();
		String[] deElements = testDataForAuthorizationTransactionOnMas(transactionData);
		Transaction transactionDataForTransaction = setDataForTransaction(transaction, transactionData, deElements);
		transactionWorkflow.performTransaction(transactionDataForTransaction);
	}


	private Transaction setDataForTransaction(String transaction,	Transaction transactionData, String[] deElements) {
		String [] getTransactionTestData = TransactionTestDataForMAS.getTestCase(transaction).split("\\|");
		transactionData.setTestCaseToSelect(getTransactionTestData[0]);
		transactionData.setCardForTransaction(getTransactionTestData[1]);
		transactionData.setDeKeyValuePair(transactionData.setDataElementValues(deElements));
		return transactionData;
	}

	private String[] testDataForAuthorizationTransactionOnMas(Transaction transactionData) {

		if(transactionData.getPinForTransaction().length() == 0)
			transactionData.setPinForTransaction("BLANK");

		String [] deElements = new String[5];
		deElements[0] = "DE4=" + transactionData.getTransactionAmount();  //TRANSACTION_AMOUNT
		deElements[1] = "DE37=generateRandomNumber";
		deElements[2] = "DE49=" + transactionData.getCurrency(); //country code  // CURRENCY	INR [356] in DATA TABLE
		deElements[3] = "DE52=" + transactionData.getPinForTransaction(); // Pin Number
		deElements[4] = "DE61_13=" + transactionData.getCurrency(); //country code

		return deElements;
	}

	@When("Auth file is generated from MAS")
	@Given("Auth file is generated")
	public void givenAthFileIsGenerated() throws IOException{
		transactionWorkflow.authFileGeneration();
		String fileName =  "AuthFileName.txt";
		athFileName = transactionWorkflow.getFileData(fileName);	
		assertNotNull("Auth fileName is not null", athFileName);
	}

	@When("Auth file is loaded into MCPS and processed")
	public void loadAuthFileToMCPS(){
		arnNumber = transactionWorkflow.loadAuthFileToMCPS(athFileName);
		logger.info("ARD number is ", arnNumber);
	}

	@Alias("test results are reported")
	@Then("MAS test results are verified")
	public void thenTestResultsAreReported(){
		Boolean testResults = transactionWorkflow.verifyTestResults();
		if(testResults)
		{
			logger.info("Transaction is succcessful!");
		}
		else
		{
			logger.error("Transaction failed!");
		}
	}

	@When("connection to $simulator is established")
	@Then("connection to $simulator is established")
	@Given("connection to $simulator is established")
	public void launchWiniumAndSimulator(String simulator){
		
		MiscUtils.killProcessFromTaskManager("WINIUM");		
		MiscUtils.killProcessFromTaskManager(simulator);
		
		transactionWorkflow.startWiniumDriverWithSimulator(simulator);

		if(simulator.toUpperCase().contains("FINSIM"))
		{
			transactionWorkflow.launchAndConnectToFinSim();
		}
		else if(simulator.toUpperCase().contains("MAS")) 
		{
			transactionWorkflow.selectMASLicenseAndConfigure("Credit - Professional");
		}
		else if(simulator.toUpperCase().contains("MCPS")) 
		{
			transactionWorkflow.launchAndConnectToMCPS();
		}
	}

	@When("PIN is retrieved successfully with data from Pin Offset File")
	@Then("PIN is retrieved successfully with data from Pin Offset File")
	public void thenPINIsRetrievedSuccessfully(){
		Device device = context.get(ContextConstants.DEVICE);
		Transaction transactionData = Transaction.generateFinSimPinTestData(device, finSimConfig);

		String pinNumber = transactionWorkflow.getPinNumber(transactionData);
		MiscUtils.reportToConsole("FINSim PIN Number generated : " + pinNumber );
		device.setPinNumberForTransaction(pinNumber);
	}

	@When("PIN is retrieved successfully with sample data from Pin Offset File")
	@Then("PIN is retrieved successfully with sample data from Pin Offset File")
	public void thenPINIsRetrievedSuccessfullyBasedOnSampleData(){
		Transaction transactionData = Transaction.fetchDataForFinSim(finSimConfig);

		String pinNumber = transactionWorkflow.getPinNumber(transactionData);
		MiscUtils.reportToConsole("FINSim PIN Number generated : " + pinNumber );
	}

	@When("$simulatorName simulator is closed")
	@Then("$simulatorName simulator is closed")
	public void thenclosesimulator(String simulatorName){
		transactionWorkflow.closeSimulator(simulatorName);
	}

	@Given("transaction status is \"$type\"")
	@When("transaction status is \"$type\"")
	@Then("transaction status is \"$type\"")
	public void thenTransactionStatusIsPresentmentMatched(String type){
		assertEquals(type, transactionWorkflow.getAuthorizationStatus(arnNumber));			
	}

	@Then("transaction fee is correctly posted")
	public void thenTransactionFeeIsCorrecltyPosted(){
		assertEquals("20.00", transactionWorkflow.getFeePostingStatus(arnNumber));
	}
}
