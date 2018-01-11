package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AuthorizationSearchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AuthorizationSearchWorkflow {

	@Autowired
	private Navigator navigator;

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationSearchPage.class);

	public void verifyAuthTransactionSearch(String expectedDescription, String expectedCodeAction, String deviceNumber) {
		AuthorizationSearchPage page = navigator.navigateToPage(AuthorizationSearchPage.class);
		page.inputDeviceNumber(deviceNumber);
		page.inputFromDate(LocalDate.now());
		page.inputToDate(LocalDate.now());
		page.clickSearchButton();

		int rowCount = page.getRowCountFromTable();
		logger.info("Row Count on Authorization Search Page : {} ", rowCount);
		assertTrue("No Rows Found on Authorization Search Page", rowCount > 0);

		String actualCodeAction = page.getCellTextByColumnName(1, "Code Action");
		String actualDescription = page.getCellTextByColumnName(1, "Description");
		logger.info("CodeAction on Authorization Search Page : {} ", actualCodeAction);
		logger.info("Description on Authorization Search Page : {} ", actualDescription);
		logger.info("Expected CodeAction : {} ", expectedCodeAction);
		logger.info("Expected Description : {} ", expectedDescription);
		boolean condition = actualCodeAction.contains(expectedCodeAction) && actualDescription.equalsIgnoreCase(expectedDescription);
		assertTrue("Latest (Row) 'Description' and 'Code Action' does not match on Authorization Search Screen", condition);
	}
}