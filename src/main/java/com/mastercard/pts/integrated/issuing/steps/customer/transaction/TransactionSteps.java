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
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.AuthorizationTransactionFactory;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ClearingTestCase;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.Transaction;
import com.mastercard.pts.integrated.issuing.domain.provider.ClearingTestCaseProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.TransactionProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;

@Component
public class TransactionSteps {
	private static final Logger logger = LoggerFactory.getLogger(TransactionSteps.class);

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
	private ClearingTestCaseProvider clearingTestCaseProvider;

	private String authFilePath;

	private String arnNumber;

	private String transactionAmount = "20.00";

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
		givenOptimizedTransactionIsExecuted(transaction);
	}

	@Then("last entry is deleted")
	@When("last entry is deleted")
	public void deleteLastTransactionEntry()
	{
		transactionWorkflow.removeLastEntry();
	}

	@When("user performs an optimized $transaction MAS transaction")
	@Given("user performs an optimized $transaction MAS transaction")
	public void givenOptimizedTransactionIsExecuted(String transaction)
	{
		Device device = context.get(ContextConstants.DEVICE);

		Transaction transactionData = transactionProvider.loadTransaction(transaction);
		transactionData.setTestCase(transactionFactory.createCsvTesCase(transactionData));
		transactionData.setCardProfile(transactionFactory.createCsvCardProfile(transactionData));

		//when data is dynammically passed when scripts run from end-2-end
		// else block for when scripts are running from excel
		if(device != null)
		{
			//  This is a Single Wallet, Single Currency INDIA card
			transactionData.setIssuerCountryCode(transactionWorkflow.getCurrencyToBeUsed(transactionData.getCurrency())); //"356"; // transactionData.getCurrency(); //356
			transactionData.setIssuerCurrencyCode(transactionWorkflow.getCurrencyToBeUsed(transactionData.getCurrency()));
			transactionData.setCardHolderBillingCurrency(transactionWorkflow.getCurrencyToBeUsed(transactionData.getCurrency()));  //value from DE Element 61_13
		}
		else
		{
			transactionData.setIssuerCountryCode(transactionWorkflow.getCurrencyToBeUsed(transactionData.getDeKeyValuePair().get("049"))); //"356"; // transactionData.getCurrency(); //356
			transactionData.setIssuerCurrencyCode(transactionWorkflow.getCurrencyToBeUsed(transactionData.getDeKeyValuePair().get("049")));  //value from DE Element 49
			transactionData.setCardHolderBillingCurrency(transactionWorkflow.getCurrencyToBeUsed(transactionData.getDeKeyValuePair().get("061.13")));  //value from DE Element 61_13
		}
		transactionWorkflow.performOptimizedMasTransaction(transaction, transactionData);
	}

	@Given("Auth file is provided for $iteration")
	public void givenAuthFileIsProvided(String iteration) {
		ClearingTestCase testCase = clearingTestCaseProvider.loadTestCase(iteration);
		authFilePath = testCase.getAuthFilePath();
		transactionAmount = testCase.getTransactionFeeAmount();
	}

	@When("Auth file is generated from MAS")
	@Given("Auth file is generated")
	public void givenAthFileIsGenerated() throws IOException{
		String fileName = "AuthFileName.txt";
		String authFileName = transactionWorkflow.getFileData(fileName);	
		assertNotNull("Auth fileName is not null", authFileName);
		authFilePath = transactionWorkflow.getTempDirectoryLocationForSimulatorResults() + "\\"
				+ authFileName;
	}

	@When("Auth file is loaded into MCPS and processed")
	public void loadAuthFileToMCPS(){
		arnNumber = transactionWorkflow.loadAuthFileToMCPS(authFilePath);
		logger.info("ARD number is ", arnNumber);
	}

	@Alias("test results are reported")
	@When("MAS test results are verified")
	@Then("MAS test results are verified")
	public void thenTestResultsAreReported(){
		Boolean testResults = transactionWorkflow.verifyTestResults();
		if(testResults)	{
			logger.info("Transaction is succcessful!");
		}
		else	{
			logger.error("Transaction failed!");
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
		Transaction transactionData = Transaction.generateFinSimPinTestData(device, finSimConfig, provider);

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
		assertEquals(transactionAmount, transactionWorkflow.getFeePostingStatus(arnNumber));
	}
}
