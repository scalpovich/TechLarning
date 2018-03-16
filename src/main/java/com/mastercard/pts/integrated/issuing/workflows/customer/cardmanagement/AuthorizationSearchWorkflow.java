package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AuthorizationSearchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Workflow
public class AuthorizationSearchWorkflow {

	@Autowired
	private Navigator navigator;

	@Autowired
	private TestContext context;

	@Autowired
	private ReconciliationWorkFlow reconciliationWorkFlow;

	private String ratetxnfee;
	private int fixedTxnFee = 10;

	private static final Logger logger = LoggerFactory.getLogger(AdministrationHomePage.class);

	public void verifyAuthTransactionSearch(String type, String state, String deviceNumber) {
		String varType = type;
		// state value sent from stroy file is different from what appears on
		// the screen hence setting to the correct value if it is
		// "Rvmt_Receiving"
		if ("Rvmt_Receiving".equalsIgnoreCase(varType))
			varType = "RVMT - Receiving";

		authSearchAndVerification(deviceNumber, varType, state, "Code Action", "Description");
	}

	public void verifyTransactionAndBillingCurrency(String transactionCurrency, String billingCurrency, String deviceNumber) {
		authSearchAndVerification(deviceNumber, transactionCurrency, billingCurrency, "Transaction Currency", "Billing Currency");
	}

	public String getRateTxnFee() {
		return ratetxnfee;
	}

	public void setRateTxnFee(String ratetxnfee) {
		this.ratetxnfee = ratetxnfee;

	}

	private void authSearchAndVerification(String deviceNumber, String type, String state, String codeColumnName, String descriptionColumnName) {
		boolean condition;

		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.inputDeviceNumber(deviceNumber);
		page.inputFromDate(LocalDate.now().minusDays(1));
		page.inputToDate(LocalDate.now());
		// using waitAndSearchForRecordToAppear instead of
		// page.clickSearchButton(); it iterates for sometime before failing
		page.waitAndSearchForRecordToAppear();

		int rowCount = page.getRowCountFromTable();
		logger.info("Row Count on Authorization Search Page : {} ", rowCount);
		assertTrue("No Rows Found on Authorization Search Page", rowCount > 0);
		String actualCodeAction = page.getCellTextByColumnName(1, codeColumnName);
		String actualDescription = page.getCellTextByColumnName(1, descriptionColumnName);
		String authCodeValue = page.getCellTextByColumnName(1, "Auth Code");
		String transactionAmountValue = page.getCellTextByColumnName(1, "Transaction Amount");
		context.put(ConstantData.AUTHORIZATION_CODE, authCodeValue);
		context.put(ConstantData.TRANSACTION_AMOUNT, transactionAmountValue);
		logger.info("CodeAction on Authorization Search Page : {} ", actualCodeAction);
		logger.info("Description on Authorization Search Page : {} ", actualDescription);

		logger.info("type on Authorization Search Page : {} ", type);
		logger.info("state on Authorization Search Page : {} ", state);
		logger.info("auth code on Authorization Search Page : {} ", authCodeValue);
		logger.info("Transaction amount on Authorization Search Page : {} ", transactionAmountValue);

		if ("Code Action".equalsIgnoreCase(codeColumnName))
			// to handle "Code Action", "Description"
			condition = actualCodeAction.contains(state) && actualDescription.contains(type);
		else
			// to handle "Transaction Currency", "Billing Currency"
			condition = actualCodeAction.contains(type) && actualDescription.contains(state);

		assertTrue("Latest (Row) Description and Code Action does not match on Authorization Search Screen", condition);
	}

	public List<String> checkTransactionFixedFee(String deviceNumber) {

		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.inputDeviceNumber(deviceNumber);
		page.inputFromDate(LocalDate.now().minusDays(1));
		page.inputToDate(LocalDate.now());
		page.waitAndSearchForRecordToAppear();
		page.viewDeviceDetails();
		SimulatorUtilities.wait(2000);
		return page.checkFixedTransactionFee();
	}

	public List<String> checkTransactionRateFee(String deviceNumber) {

		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.inputDeviceNumber(deviceNumber);
		page.inputFromDate(LocalDate.now().minusDays(1));
		page.inputToDate(LocalDate.now());
		page.waitAndSearchForRecordToAppear();
		page.viewDeviceDetails();
		SimulatorUtilities.wait(2000);
		List<String> myList= page.checkFixedTransactionFee();
		int billAmount= Integer.parseInt(myList.get(3).substring(0, 2));	
		int rate = Integer.parseInt(ratetxnfee);
		System.out.println(rate);
		int txnRateFee = fixedTxnFee+(billAmount*(rate/100));
		System.out.println(txnRateFee);
		String txnRateFeeString = Integer.toString(txnRateFee);
		myList.add(txnRateFeeString);
		System.out.println(myList);
		return myList;
		
		
		
		
	}

	public void verifyAuthTransactionSearchReport(Device device) {
		List<String> reportContent = reconciliationWorkFlow.verifyAuthReport(ConstantData.AUTHORIZATION_REPORT_FILE_NAME, context.get(ConstantData.AUTHORIZATION_CODE));
		String authFileData = "";
		for (int i = 0; i < reportContent.size(); i++) {
			authFileData += reportContent.get(i) + " ";
		}
		boolean condition = authFileData.contains(context.get(ConstantData.AUTHORIZATION_CODE)) && authFileData.contains(device.getDeviceNumber())
				&& authFileData.contains(context.get(ConstantData.TRANSACTION_AMOUNT));

		assertTrue("Auth Code Doesnot match with Authoraization Report content", condition);
	}

}