package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AuthorizationSearchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AuthorizationSearchWorkflow {

	@Autowired
	private Navigator navigator;

	private static final Logger logger = LoggerFactory.getLogger(AdministrationHomePage.class);

	private String assertStatement = "Latest (Row) Description and Code Action does not match on Authorization Search Screen";
	private String codeActionStatement = "CodeAction on Authorization Search Page : {} ";
	private String descriptionStatement = "Description on Authorization Search Page : {} ";
	private String typeStatement ="type on Authorization Search Page : {} ";
	private String stateStatement ="state on Authorization Search Page : {} ";

	public void verifyAuthTransactionSearch(String type, String state, String deviceNumber) {
		String varState = state;
		// state value sent from stroy file is different from what appears on the screen hence setting to the correct value if it is "Rvmt_Receiving"
		if("Rvmt_Receiving".equalsIgnoreCase(varState))
			varState = "RVMT - Receiving";

		AuthorizationSearchPage page = authSearchAndVerify(deviceNumber);

		String actualCodeAction = page.getCellTextByColumnName(1, "Code Action");
		String actualDescription = page.getCellTextByColumnName(1, "Description");
		logger.info(codeActionStatement, actualCodeAction);
		logger.info(descriptionStatement, actualDescription);

		logger.info(typeStatement, type);
		logger.info(stateStatement, varState);

		boolean condition = actualCodeAction.contains(varState) && actualDescription.contains(type);
		assertTrue(assertStatement, condition);
	}

	public void verifyTransactionAndBillingCurrency(String transactionCurrency, String billingCurrency, String deviceNumber) {
		
		AuthorizationSearchPage page = authSearchAndVerify(deviceNumber);

		String actualTransactionCurrency = page.getCellTextByColumnName(1, "Transaction Currency");
		String actualBillingCurrency = page.getCellTextByColumnName(1, "Billing Currency");
		logger.info(codeActionStatement, actualTransactionCurrency);
		logger.info(descriptionStatement, actualBillingCurrency);

		logger.info(typeStatement, transactionCurrency);
		logger.info(stateStatement, billingCurrency);

		boolean condition = actualTransactionCurrency.contains(transactionCurrency) && actualBillingCurrency.contains(billingCurrency);
		assertTrue(assertStatement, condition);
	}
	
	private AuthorizationSearchPage authSearchAndVerify(String deviceNumber) {
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.inputDeviceNumber(deviceNumber);
		page.inputFromDate(LocalDate.now());
		page.inputToDate(LocalDate.now());
		//using waitAndSearchForRecordToAppear instead of page.clickSearchButton(); it iterates for sometime before failing
		page.waitAndSearchForRecordToAppear();

		int rowCount = page.getRowCountFromTable();
		logger.info("Row Count on Authorization Search Page : {} ", rowCount);
		assertTrue("No Rows Found on Authorization Search Page", rowCount > 0);
		return page;
	}
}