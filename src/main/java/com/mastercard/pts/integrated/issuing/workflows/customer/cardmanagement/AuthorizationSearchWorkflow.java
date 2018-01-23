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

	public void verifyAuthTransactionSearch(String type, String state, String deviceNumber) {
		String varType = type;
		// state value sent from stroy file is different from what appears on the screen hence setting to the correct value if it is "Rvmt_Receiving"
		if("Rvmt_Receiving".equalsIgnoreCase(varType))
			varType= "RVMT - Receiving";

		authSearchAndVerification(deviceNumber, varType, state, "Code Action", "Description");
	}

	public void verifyTransactionAndBillingCurrency(String transactionCurrency, String billingCurrency, String deviceNumber) {
		authSearchAndVerification(deviceNumber, transactionCurrency, billingCurrency, "Transaction Currency", "Billing Currency");
	}	

	private void authSearchAndVerification(String deviceNumber, String type, String state, String codeColumnName, String descriptionColumnName ) {
		boolean condition;

		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.inputDeviceNumber(deviceNumber);
		page.inputFromDate(LocalDate.now());
		page.inputToDate(LocalDate.now());
		//using waitAndSearchForRecordToAppear instead of page.clickSearchButton(); it iterates for sometime before failing
		page.waitAndSearchForRecordToAppear();

		int rowCount = page.getRowCountFromTable();
		logger.info("Row Count on Authorization Search Page : {} ", rowCount);
		assertTrue("No Rows Found on Authorization Search Page", rowCount > 0);
		String actualCodeAction = page.getCellTextByColumnName(1, codeColumnName);
		String actualDescription = page.getCellTextByColumnName(1, descriptionColumnName);
		logger.info("CodeAction on Authorization Search Page : {} ", actualCodeAction);
		logger.info("Description on Authorization Search Page : {} ", actualDescription);

		logger.info("type on Authorization Search Page : {} ", type);
		logger.info("state on Authorization Search Page : {} ", state);

		if("Code Action".equalsIgnoreCase(codeColumnName))
			// to handle "Code Action", "Description"
			condition = actualCodeAction.contains(state) && actualDescription.contains(type);
		else
			// to handle "Transaction Currency", "Billing Currency"
			condition =actualCodeAction.contains(type) && actualDescription.contains(state);

		assertTrue("Latest (Row) Description and Code Action does not match on Authorization Search Screen", condition);
	}
}