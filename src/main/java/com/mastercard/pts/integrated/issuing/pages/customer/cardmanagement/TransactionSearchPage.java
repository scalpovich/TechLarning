package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH, CardManagementNav.L2_TRANSACTION, CardManagementNav.L3_TRANSACTION_SEARCH })
public class TransactionSearchPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(TransactionSearchPage.class);

	private static final long FROM_DATE = 89;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=microfilmRefNumber]")
	private MCWebElement searchARNTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=cardNumber]")
	private MCWebElement searchDeviceTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Authorization Status :']]/following-sibling::td[1]/span")
	private MCWebElement authorizationStatusTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/..")
	private MCWebElement fromDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/..")
	private MCWebElement toDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:6:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement dateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='tab_container_privileges']/div/table/tbody/tr[2]/td[4]/span/span")
	private MCWebElement transactionAmout;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:6:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement tranDateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeSelect;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=cardNumber]")
	private MCWebElement cardNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[1]/td/span[contains(text(),'DR')]/../../td[1]/span/a/span")
	private MCWebElement retrieveARNLabel;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span.time>label+label")
	private MCWebElement institutionDateTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Sequence Number')]")
	private MCWebElement sequenceNumberText;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Reconciliation Status')]//following-sibling::td[2]/select")
	private MCWebElement reconciliationStatusDD;
	
	private final String DUPLICATE_PRESENTMENT = "Duplicate presentment";
	private final String UNMATCH_PRESENTMENT = "Unmatched Presentment";
	private final String RECONCILIATION_STATUS_OPTIONS = "//*[contains(text(),'Reconciliation Status')]//following-sibling::td[2]/select/option";
	private final String DESCRIPTION = "Description";
	
	private String authorizationStatus;	
	
	public void selectFromDate(LocalDate date)
	{
		date = LocalDate.parse(getTextFromPage(institutionDateTxt), DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")).minusDays(1);
		WebElementUtils.pickDate(fromDateTxt, date);		
	}
	
	public void selectToDate(LocalDate date)
	{
		date = LocalDate.parse(getTextFromPage(institutionDateTxt), DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		WebElementUtils.pickDate(toDateTxt, date);
	}
	
	public String searchTransactionWithDevice(String deviceNumber, TransactionSearch ts) {
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, ts.getProductType());
		WebElementUtils.enterText(cardNumberTxt, deviceNumber);
		WebElementUtils.selectDropDownByVisibleText(dateDDwn, ts.getDateType());
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now().minusDays(FROM_DATE));
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());
		clickSearchButton();
		waitforElement(retrieveARNLabel);
		String retrieveARN = retrieveARNLabel.getText();
		logger.info("retrievedARN {} ", retrieveARN);
		return retrieveARN;
	}

	public String searchTransactionWithARN(String arnNumber, TransactionSearch ts, String type) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,ts.getProductType());
		WebElementUtils.enterText(searchARNTxt, arnNumber);
		WebElementUtils.selectDropDownByVisibleText(dateDDwn, ts.getDateType());
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now().minusDays(10));
		selectToDate(LocalDate.now());
		
		if(type.equalsIgnoreCase(DUPLICATE_PRESENTMENT) || type.equalsIgnoreCase(UNMATCH_PRESENTMENT)){
			String st = Elements(RECONCILIATION_STATUS_OPTIONS).stream().filter(x -> x.getText().contains(type)).findFirst().get().getText();
			selectByText(reconciliationStatusDD, st);
		}
		selectFromDate(LocalDate.now());
		
		clickSearchButton();
		viewFirstRecord();
		
		runWithinPopup("View Transactions", () -> {
			logger.info("Retrieving authorization status : " + authorizationStatusTxt.getText());
			authorizationStatus = authorizationStatusTxt.getText();
			clickCloseButton();
		});

		return authorizationStatus;
	}

	public String searchTransactionWithArnAndGetFee(String arnNumber, TransactionSearch ts) {
		int i;
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, ts.getProductType());
		WebElementUtils.enterText(searchARNTxt, arnNumber);
		WebElementUtils.selectDropDownByVisibleText(dateDDwn, ts.getDateType());
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now());
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());
		clickSearchButton();
		for (i = 1; i < 4; i++) {
			if ("2".equals(getCellTextByColumnName(i, "Sequence Number")))
				break;
		}
		return getCellTextByColumnName(i, "Transaction");
	}

	public String searchTransactionWithArnAndGetStatus(String arnNumber, TransactionSearch ts) {
		int i;
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, ts.getProductType());
		WebElementUtils.enterText(searchARNTxt, arnNumber);
		WebElementUtils.selectDropDownByVisibleText(dateDDwn, ts.getDateType());
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now());
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());
		clickSearchButton();
		for (i = 1; i < 4; i++) {
			if ("2".equals(getCellTextByColumnName(i, "Sequence Number")))
				break;
		}
		return getCellTextByColumnName(i, "Reversal");
	}

	public String searchTransactionWithDeviceAndGetStatus(Device device, TransactionSearch ts) {
		int i;
		logger.info("Select product {}", device.getProductType());
		WebElementUtils.selectDropDownByVisibleText(productTypeSelect, device.getProductType());
		logger.info("Search transaction for device {}", device.getDeviceNumber());
		WebElementUtils.enterText(searchDeviceTxt, device.getDeviceNumber());
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now());
		WebElementUtils.pickDate(toDateTxt, LocalDate.now());
		waitForWicket();
		WebElementUtils.elementToBeClickable(tranDateDDwn);
		WebElementUtils.selectDropDownByVisibleText(tranDateDDwn, "Transaction Date [T]");
		clickSearchButton();
		waitForWicket();
		for (i = 1; i < 4; i++) {
			if ("2".equals(getCellTextByColumnName(i, "Sequence Number")))
				break;
		}
		return getCellTextByColumnName(i, "Description");
	}

	public void verifyUiOperationStatus() {
		logger.info("Transaction Search");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(searchARNTxt));
	}

}
