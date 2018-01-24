package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertFalse;
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

@Workflow
public class AuthorizationSearchWorkflow {

	@Autowired
	private Navigator navigator;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private ReconciliationWorkFlow reconciliationWorkFlow;

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
		context.put(ConstantData.AUTHORIZATION_CODE,page.getCellTextByColumnName(1, "Auth Code"));
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
	
	public void verifyAuthTransactionSearchReport(Device device)
	{
		//List<String> reportContent = reconciliationWorkFlow.verifyAuthReport(ConstantData.AUTHORIZATION_REPORT_FILE_NAME,"XU4NIZ");
		List<String> reportContent = reconciliationWorkFlow.verifyAuthReport(ConstantData.AUTHORIZATION_REPORT_FILE_NAME,context.get("authCode"));
		//boolean condition = reportContent.contains(context.get("authCode")) && reportContent.contains(device.getDeviceNumber());
		String authFileData="";
		for (int i = 0; i < reportContent.size(); i++) {
			authFileData += reportContent.get(i) + " ";
		}	
		
		//boolean condition = authFileData.contains("XU4NIZ") && authFileData.contains("5887651058800118");
		boolean condition = authFileData.contains(context.get(ConstantData.AUTHORIZATION_CODE)) && authFileData.contains(device.getDeviceNumber());

		assertTrue("Auth Code Doesnot match with Authoraization Report content", condition);
	}
}