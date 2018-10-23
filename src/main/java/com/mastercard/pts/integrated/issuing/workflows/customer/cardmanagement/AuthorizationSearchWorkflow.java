package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AvailableBalance;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionReports;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
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

	@Autowired
	KeyValueProvider provider;

	@Autowired
	AuthorizationSearchPage authorizationSearchPage;

	private static final Logger logger = LoggerFactory.getLogger(AdministrationHomePage.class);

	public static final int BILL_AMOUNT_INDEX_VALUE = 3;

	private static final String USERNAME = "USERNAME";

	public void verifyAuthTransactionSearch(String type, String state, Device device) {
		String varType = type;
		// state value sent from stroy file is different from what appears on
		// the screen hence setting to the correct value if it is
		// "Rvmt_Receiving"
		if ("Rvmt_Receiving".equalsIgnoreCase(varType))
			varType = "RVMT - Receiving";

		authSearchAndVerification(device, varType, state, "Code Action", "Description");
	}

	public void verifyTransactionAndBillingCurrency(String transactionCurrency, String billingCurrency, Device device) {
		authSearchAndVerification(device, transactionCurrency, billingCurrency, "Transaction Currency",
				"Billing Currency");
	}

	private void authSearchAndVerification(Device device, String type, String state, String codeColumnName,
			String descriptionColumnName) {
		boolean condition;
		SimulatorUtilities.wait(5000);
		AuthorizationSearchPage authSearchPage = navigator.navigateToPage(AuthorizationSearchPage.class);
		authSearchPage.inputDeviceNumber(device.getDeviceNumber());
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

		// Device Usage Code
		String billingAmountValue = authSearchPage.getCellTextByColumnName(1, "Billing Amount");
		if (ConstantData.TX_SUCESSFUL_MESSAGE.equalsIgnoreCase(actualCodeAction)
				&& !ConstantData.PRE_AUTH.equalsIgnoreCase(type)) {
			device.setDeviceVelocity();
			device.setDeviceAmountUsage(Double.parseDouble(billingAmountValue));
		}

		assertTrue("Latest (Row) Description and Code Action does not match on Authorization Search Screen", condition);
	}

	public List<String> checkTransactionFixedFee(String deviceNumber) {

		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckTransactionFee(deviceNumber);
		return page.checkFixedTransactionFee();
	}

	public List<String> checkTransactionRateFee(String deviceNumber, TransactionFeePlan txnFeePlan) {

		double txnRateFee;
		int FIXED_TRANSACTION_FEE = Integer.parseInt(txnFeePlan.getfixedTxnFees());
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckTransactionFee(deviceNumber);
		List<String> myList = page.checkFixedTransactionFee();
		double billAmount = Integer.parseInt(myList.get(BILL_AMOUNT_INDEX_VALUE).substring(0, 2));
		double rate = Double.parseDouble(txnFeePlan.getRateTxnFee());
		txnRateFee = billAmount * (rate / 100) + FIXED_TRANSACTION_FEE;
		String txnRateFeeString = Double.toString(txnRateFee);
		myList.add(txnRateFeeString);
		return myList;

	}

	public List<String> checkTransactionMaxFee(String deviceNumber) {

		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckTransactionFee(deviceNumber);
		return page.checkFixedTransactionFee();
	}

	public List<String> checkTransactionMinFee(String deviceNumber) {

		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckTransactionFee(deviceNumber);
		return page.checkFixedTransactionFee();

	}

	public List<String> checkMarkupFee(String deviceNumber) {
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.authCheckMarkUpFee(deviceNumber);
		return page.getMarkUpFeeDetails();

	}

	public void verifyAuthTransactionSearchReport(Device device) {

		TransactionReports transactionReport = new TransactionReports();
		transactionReport.setAuthorizationCode(context.get(ConstantData.AUTHORIZATION_CODE));
		transactionReport.setDeviceNumber(device.getDeviceNumber());
		transactionReport.setRrnNumber(context.get(ConstantData.RRN_NUMBER));
		transactionReport.setUsername(context.get(USERNAME));

		List<String> reportContent = reconciliationWorkFlow
				.verifyAuthReport(ConstantData.AUTHORIZATION_REPORT_FILE_NAME, transactionReport);
		String authFileData = "";
		for (int i = 0; i < reportContent.size(); i++) {
			authFileData += reportContent.get(i) + " ";
		}

		boolean condition = authFileData.contains(context.get(ConstantData.AUTHORIZATION_CODE))
				&& authFileData.contains(device.getDeviceNumber())
				&& authFileData.contains(context.get(ConstantData.TRANSACTION_AMOUNT))
				&& authFileData.contains(context.get(ConstantData.RRN_NUMBER));
		assertTrue("Auth Code Doesnot match with Authoraization Report content", condition);
	}

	public void verifyStateAuthSearch(String deviceNumber, List<String> authStatus) {
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		List<String> actualAuthStatus = page.verifyState(deviceNumber);
		assertTrue(String.format("Response, Auth Code and Auth Description does not match. Expecting %s. Actual %s",
				authStatus, actualAuthStatus), actualAuthStatus.containsAll(authStatus));
	}

	public AvailableBalance getTransactionBillingDetailsAndAvailableBalanceAfterTransaction(
			BigDecimal availableBalance) {
		authorizationSearchPage.viewDeviceDetails();
		AvailableBalance availBal = authorizationSearchPage.getAvailableBalance();
		logger.info("Available balance before transaction amount = {}", availableBalance);
		logger.info("Sum of all applicable fee and amounts = {}", availBal.getSum());
		logger.info("Available balance after transaction amount = {}", availBal.getAvailableBal());
		return availBal;
	}
}