package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertFalse;
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
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.inputDeviceNumber(deviceNumber);
		page.inputFromDate(LocalDate.now().minusDays(1));
		page.inputToDate(LocalDate.now());
		page.clickSearchButton();

		int rowCount = page.getRowCountFromTable();
		logger.info("Row Count on Authorization Search Page : {} ", rowCount);
		assertTrue("No Rows Found on Authorization Search Page", rowCount > 0);

		String actualCodeAction = page.getCellTextByColumnName(1, "Code Action");
		String actualDescription = page.getCellTextByColumnName(1, "Description");
		logger.info("CodeAction on Authorization Search Page : {} ", actualCodeAction);
		logger.info("Description on Authorization Search Page : {} ", actualDescription);
		
		logger.info("type on Authorization Search Page : {} ", type);
		logger.info("state on Authorization Search Page : {} ", state);
		
		boolean condition = actualCodeAction.contains(state) && actualDescription.contains(type);
		assertTrue("Latest (Row) Description and Code Action does not match on Authorization Search Screen", condition);
	}
	
	public void verifyTransactionAndBillingCurrency(String transactionCurrency, String billingCurrency, String deviceNumber) {
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.inputDeviceNumber(deviceNumber);
		page.inputFromDate(LocalDate.now().minusDays(1));
		page.inputToDate(LocalDate.now());
		page.clickSearchButton();
		int rowCount = page.getRowCountFromTable();
		logger.info("Row Count on Authorization Search Page : {} ", rowCount);
		assertTrue("No Rows Found on Authorization Search Page", rowCount > 0);

		String actualTransactionCurrency = page.getCellTextByColumnName(1, "Transaction Currency");
		String actualBillingCurrency = page.getCellTextByColumnName(1, "Billing Currency");
		logger.info("CodeAction on Authorization Search Page : {} ", actualTransactionCurrency);
		logger.info("Description on Authorization Search Page : {} ", actualBillingCurrency);
		
		logger.info("type on Authorization Search Page : {} ", transactionCurrency);
		logger.info("state on Authorization Search Page : {} ", billingCurrency);
		
		boolean condition = actualTransactionCurrency.contains(transactionCurrency) && actualBillingCurrency.contains(billingCurrency);
		assertTrue("Latest (Row) Description and Code Action does not match on Authorization Search Screen", condition);
	}
}