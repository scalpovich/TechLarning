package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AuthorizationSearchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Workflow
public class AuthorizationSearchWorkflow {

	@Autowired
	private Navigator navigator;

	@Autowired
	private TestContext context;

	@Autowired
	private ReconciliationWorkFlow reconciliationWorkFlow;

	@Autowired
	KeyValueProvider provider;

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

	private void authSearchAndVerification(String deviceNumber, String type, String state, String codeColumnName, String descriptionColumnName) {
		boolean condition;

		AuthorizationSearchPage authSearchPage = navigator.navigateToPage(AuthorizationSearchPage.class);
		authSearchPage.inputDeviceNumber(deviceNumber);
		authSearchPage.inputFromDate(LocalDate.now().minusDays(1));
		authSearchPage.inputToDate(LocalDate.now());
		// using waitAndSearchForRecordToAppear instead of
		// page.clickSearchButton(); it iterates for sometime before failing
		authSearchPage.waitAndSearchForRecordToAppear();

		int rowCount = authSearchPage.getRowCountFromTable();
		logger.info("Row Count on Authorization Search Page : {} ", rowCount);
		assertTrue("No Rows Found on Authorization Search Page", rowCount > 0);
		String actualCodeAction = authSearchPage.getCellTextByColumnName(1, codeColumnName);
		String actualDescription = authSearchPage.getCellTextByColumnName(1, descriptionColumnName);
		String authCodeValue = authSearchPage.getCellTextByColumnName(1, "Auth Code");
		String transactionAmountValue = authSearchPage.getCellTextByColumnName(1, "Transaction Amount");
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

		TransactionFeePlan txnFeePlan = TransactionFeePlan.allTxnFee(provider);
		context.put(ContextConstants.TRANSACTION_FEE_PLAN, txnFeePlan);
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckTransactionFee(page, deviceNumber);
		return page.checkFixedTransactionFee();
	}

	public List<String> checkTransactionRateFee(String deviceNumber, TransactionFeePlan txnFeePlan) {

		double txnRateFee;
		context.put(ContextConstants.TRANSACTION_FEE_PLAN, txnFeePlan);
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckTransactionFee(deviceNumber);
		List<String> myList = page.checkFixedTransactionFee();
		double billAmount = Integer.parseInt(myList.get(3).substring(0, 2));
		double rate = Double.parseDouble(txnFeePlan.getRateTxnFee());
		txnRateFee = billAmount * (rate / 100) + Constants.fixedTxnFee;
		String txnRateFeeString = Double.toString(txnRateFee);
		myList.add(txnRateFeeString);
		return myList;

	}

	public List<String> checkTransactionMaxFee(String deviceNumber) {
		
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckTransactionFee(page, deviceNumber);
		return page.checkFixedTransactionFee();
	}

	public List<String> checkTransactionMinFee(String deviceNumber) {
		TransactionFeePlan txnFeePlan = TransactionFeePlan.allTxnFee(provider);
		context.put(ContextConstants.TRANSACTION_FEE_PLAN, txnFeePlan);
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckTransactionFee(page, deviceNumber);
		return page.checkFixedTransactionFee();

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