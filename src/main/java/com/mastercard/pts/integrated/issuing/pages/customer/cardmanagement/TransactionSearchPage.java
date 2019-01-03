package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.DeviceEventBasedFee;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearchDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import java.util.ArrayList;
import java.util.List;

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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr//span[contains(.,'FEE(Annual Fees)')]/../preceding-sibling::td[@class='rightalign']")
	private MCWebElement membershipFees;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr//span[contains(.,'FEE(Joining Fees)')]/../preceding-sibling::td[@class='rightalign']")
	private MCWebElement joiningFees;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Transaction Date']/ancestor::a")
	private MCWebElement transactionDateOrderByLink;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Reconciliation Status')]//following-sibling::td[2]/select")
	private MCWebElement reconciliationStatusDDwn;
	
	private final String DUPLICATE_CURRENCY_PRESENTMENT = "Duplicate presentment";
	private final String UNMATCH_PRESENTMENT = "Unmatched Presentment";
	private final String RECONCILIATION_STATUS_OPTIONS = "//*[contains(text(),'Reconciliation Status')]//following-sibling::td[2]/select/option";
	
	private String authorizationStatus;

	List<String> joiningAndMembershipFees = new ArrayList();
	
	private String cardFees = "//table[@class='dataview']/tbody/tr//span[contains(.,'%s')]/../preceding-sibling::td[@class='rightalign']";
	
	private String deviceFee = "";
	
	public void selectFromDate(LocalDate date)
	{
		date = LocalDate.parse(getTextFromPage(institutionDateTxt), DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")).minusDays(4);
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
		//selectFromDate(LocalDate.now());
		WebElementUtils.pickDate(fromDateTxt, LocalDate.now().minusDays(10));
		selectToDate(LocalDate.now());
		//selectFromDate(LocalDate.now());
		if(type.equalsIgnoreCase(DUPLICATE_CURRENCY_PRESENTMENT) || type.equalsIgnoreCase(UNMATCH_PRESENTMENT)){
			String st = Elements(RECONCILIATION_STATUS_OPTIONS).stream().filter(x -> x.getText().contains(type)).findFirst().get().getText();
			selectByText(reconciliationStatusDDwn, st);
		}
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
		String xPath = String.format(".//td/span[contains(text(),'%s')]", "Wallet to Wallet Transfer(Credit))");
		return getFinder().getWebDriver().findElement(By.xpath(xPath)).getText();
	}

	public List<String> searchTransactionWithDeviceAndGetJoiningAndMemberShipFees(Device device, TransactionSearch ts, Boolean membershipFlag) {
		logger.info("Select product {}", device.getProductType());
		WebElementUtils.selectDropDownByVisibleText(productTypeSelect, device.getProductType());
		logger.info("Search transaction for device {}", device.getDeviceNumber());
		WebElementUtils.enterText(searchDeviceTxt, device.getDeviceNumber());
		WebElementUtils.pickDate(fromDateTxt, DateUtils.convertInstitutionDateInLocalDateFormat(getTextFromPage(institutionDateTxt)));
		WebElementUtils.pickDate(toDateTxt, DateUtils.convertInstitutionDateInLocalDateFormat(getTextFromPage(institutionDateTxt)));
		waitForWicket();
		WebElementUtils.elementToBeClickable(tranDateDDwn);
		WebElementUtils.selectDropDownByVisibleText(tranDateDDwn, "Transaction Date [T]");
		waitAndSearchForRecordToAppear();
		
		if (membershipFlag) {
			joiningAndMembershipFees.add(joiningFees.getText());
			joiningAndMembershipFees.add(membershipFees.getText());
		} else {
			joiningAndMembershipFees.add(joiningFees.getText());
		}
		return joiningAndMembershipFees;
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Transaction Search");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(searchARNTxt));
	}
	public TransactionSearchDetails searchTransactionWithDeviceAndGetDetails(Device device, TransactionSearch ts) {
		TransactionSearchDetails transactionDetails= new TransactionSearchDetails();
		int i;
		logger.info("Select product {}", device.getProductType());
		WebElementUtils.selectDropDownByVisibleText(productTypeSelect, device.getProductType());
		logger.info("Search transaction for device {}", device.getDeviceNumber());
		WebElementUtils.enterText(searchDeviceTxt, device.getDeviceNumber());
		selectFromDate(LocalDate.now());
		selectToDate(LocalDate.now());
		waitForWicket();
		WebElementUtils.elementToBeClickable(tranDateDDwn);
		WebElementUtils.selectDropDownByVisibleText(tranDateDDwn, "Transaction Date [T]");
		clickSearchButton();
		SimulatorUtilities.wait(5000);
		clickWhenClickable(transactionDateOrderByLink);	
		SimulatorUtilities.wait(1000);
		clickWhenClickable(transactionDateOrderByLink);	
		SimulatorUtilities.wait(5000);
		for (i = 1; i < 4; i++) {
			if ("1".equals(getCellTextByColumnName(i, "Sequence Number")))
				break;
		}
		
		transactionDetails.setARN(getCellTextByColumnName(i, "ARN"));		
		transactionDetails.setSequenceNumber(getCellTextByColumnName(i, "Sequence Number"));		
		transactionDetails.setDeviceNumber(getCellTextByColumnName(i, "Device Number"));
		transactionDetails.setTransaction(getCellTextByColumnName(i, "Transaction"));
		transactionDetails.setTransactionDate(getCellTextByColumnName(i, "Transaction Date"));
		transactionDetails.setProcessingDate(getCellTextByColumnName(i, "Processing Date"));
		transactionDetails.setDescription(getCellTextByColumnName(i, "Description"));
		transactionDetails.setBillingAmount(getCellTextByColumnName(i, "Billing Amount"));
		transactionDetails.setBillingCurrency(getCellTextByColumnName(i, "Billing Currency"));
		transactionDetails.setDR_CR(getCellTextByColumnName(i, "DR / CR"));
		transactionDetails.setReversal(getCellTextByColumnName(i, "Reversal"));		
		return transactionDetails;			
	}
	
	public void searchTransactionWithDeviceFee(Device device, TransactionSearch ts) {
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
		SimulatorUtilities.wait(6000);
		waitForWicket();
	}
	
	public String getDeviceEventFeeFromTransactionSearch(String reason){
		String [] deviceFeeList = {"Stolen", "First Renewal", "Lost", "Damaged", "Counterfeit", 
				"Emergency Replace", "Erroneous Device", "Device Technology Upgrade",
				"Early Renewal", "Others", "Stoplist Withdrawal"};
		Arrays.asList(deviceFeeList).forEach(option ->{
			if(option.equalsIgnoreCase(reason)){
				deviceFee = Element(String.format(cardFees, DeviceEventBasedFee.fromShortName(reason).replace(reason.toUpperCase()+" ", ""))).getText();
			}
		} );
		return deviceFee;
	}
	
	public String getCardBasedFees(String cardType, 
			DeviceEventBasedFeePlan deviceEventBasedPlan) {
		String deviceEventFee = "";
		switch (cardType) {
		case "Normal":
			deviceEventFee = deviceEventBasedPlan.getNormalCardFees();
			break;
		case "Photo":
			deviceEventFee = deviceEventBasedPlan.getPhotoCardFees();
			break;
		case "Picture":
			deviceEventFee = deviceEventBasedPlan.getPictureCardFees();
			break;
		default:
			logger.info("The mentioned case is not present - ", cardType);
			break;
		}
		return deviceEventFee;
	}
}
