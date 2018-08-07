package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.CharMatcher;
import com.mastercard.pts.integrated.issuing.domain.DeviceStatus;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = HelpdeskNav.TAB_HELPDESK,treeMenuItems = { 
		HelpdeskNav.L1_ACTIVITY, 
		HelpdeskNav.L2_GENERAL
})
public class HelpdeskGeneralPage extends AbstractBasePage {
	private static final String TABLE_XPATH = "//div[@class='TransScrollY']//table[@class='dataview']//tr";
	private static final String COLUMN_STATUS = "Status";
	private static final String CURRENT_AVAILABLE_BALANCE = "Current Available Balance";
	private static final String WALLET_NUMBER = "Wallet Number";
	private static final String REGISTERED = "registered";
	private static final String NOT_REGISTERED = "notregistered";
	private static final String NOTE_WALLET_FUND_TRANSFER = "Notes for Wallet to Wallet transfer";
	private static final String SERV_CODE_TRANSACTION_PASSWORD = "250";
	private static final String CHANGE_REGISTERED_EMAIL_ID="Change Registered Email Id Request";
	private static final String CHANGE_REGISTERED_MOBILE_NO="Change Registered Mobile Number Request";
	private static final String SERV_CODE_LOGIN_PASSWORD = 	"459";	
	private static final String LABEL_LOGIN_PASSWORD = "459 - Reset Cardholder Login Password";
	private static final String LABEL_TRANSACTION_PASSWORD = "250 - Reset Cardholder Transaction Password";
	private static final String ERROR_MESSAGE_XPATH="//div[@class='ketchup-error-container-alt']//li";
	private static final String CALL_REFERENCE_NUMBER = "Call Reference Number:";
	private static final String SERVICE_DESCRIPTION = "Service Description:";
	private static final String DEVICE_NUMBER = "Device Number:";
	private static final String REQUEST_DATE =  "Request Date:";
	private static final String CLOSURE_DATE = "Closure Date:";
	private static final String LOGGED_BY =  "Logged By:";
	private static final String CLOSED_BY =  "Closed By:";
	private static final String CLOSURE_PERIOD = "Estimated Closure Period(Days:HH:MM):";
	private static final String PRIORITY_REQUEST = "Priority Request:";
	private static final String AVAILABLE_BALANCE = "AVAILABLE_BALANCE";

	private static String ERROR_MESSAGE = "This field is required.";

	private static final Logger logger = LoggerFactory.getLogger(HelpdeskGeneralPage.class);
	private String activeDeviceNumber;
	private String saleDate;
	private String activationDate;
	private String deliveryDate;
	private String firstRow;
	private String status;
	private String[] values;
	private String walletBalanceInformation;
	public  boolean serviceStatus = false;
	public String availablebalance;

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Product Type']/following-sibling::td[2]/select")
	private MCWebElement productTypeSearchDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='device.deviceNumber']")
	private MCWebElement deviceNumberSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='device.cardPackId']")
	private MCWebElement cardPackIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "helpdeskDetailContainer:serviceCode:input:dropdowncomponent")
	private MCWebElement serviceCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "helpdeskDetailContainer:go")
	private MCWebElement goBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Current Status and Limits']")
	private MCWebElement currentStatusAndLimitTab;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#saleDate")
	private MCWebElement saleDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#activationDate")
	private MCWebElement activationDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#deliveryDate")
	private MCWebElement deliveryDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "memo1:input:textAreaComponent")
	private MCWebElement notesTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf6:input:dropdowncomponent")
	private MCWebElement selectLimitType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf29:input:inputAmountField")
	private MCWebElement clientCreditLimitTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value= 'Save']")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".feedbackPanelINFO")
	private MCWebElement activationMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'OK']")
	private MCWebElement okBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'Cancel']")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody img[alt='Edit Record']")
	private MCWebElement firstRowEditLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'End Call']")
	private MCWebElement endCallBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody a img")
	private MCWebElement editDeviceLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'Transactions']")
	private MCWebElement transactionsBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='date1']/..")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf29:input:inputAmountField")
	private MCWebElement creditClientLimit;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf19:input:inputAmountField")
	private MCWebElement creditAccountLimit;

	@PageElement(findBy = FindBy.NAME, valueToFind = "childPanels:1:childdataPanel:inlineTable:container:dataList:0:colList:colHeaders:3:inputField:input:inputAmountField")
	private MCWebElement newCreditLimit;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='date2']/..")
	private MCWebElement endDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[2]//div[@class='radioInput']/input[1]")
	private MCWebElement activateRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[2]//div[@class='radioInput']/input[2]")
	private MCWebElement deactivateRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[4]//div[@class='radioInput']/input[1]")
	private MCWebElement lifeLongActivationRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[4]//div[@class='radioInput']/input[2]")
	private MCWebElement immediateActivationForNHoursRBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[2]//td[4]//div[@class='radioInput']/input[3]")
	private MCWebElement activationInPeriodRBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf24:input:inputTextField")
	private MCWebElement timeInHoursTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".yui-skin-sam")
	private MCWebElement fromDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".yui-skin-sam")
	private MCWebElement toDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()[contains(.,'Wallet Details')]]")
	private MCWebElement walletDetailsLnk;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()[contains(.,'Device Details')]]")
	private MCWebElement deviceDetailsLnk;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='tab4']/table//tr//span[contains(text(),'Avail Card')]/../../following-sibling::td[1]/span/span")
	private MCWebElement availableBalanceTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind="udf9:input:inputAmountField")
	private MCWebElement debitAmtInpt;

	@PageElement(findBy = FindBy.NAME, valueToFind="memo1:input:textAreaComponent")
	private MCWebElement transactionNotesInpt;

	@PageElement(findBy = FindBy.NAME, valueToFind="udf20:input:dropdowncomponent")
	private MCWebElement toDeviceDropDn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//span[@class='feedbackPanelINFO']")
	private MCWebElement walletToWalletConfirMsg;

	@PageElement(findBy = FindBy.NAME, valueToFind="searchDiv:rows:3:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement clientIDInpt;

	@PageElement(findBy = FindBy.NAME, valueToFind="udf21:input:inputTextField")
	private MCWebElement emailIDInptTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind="udf24:input:inputTextField")
	private MCWebElement mobileInptTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind="udf23:input:dropdowncomponent")
	private MCWebElement isdCodeDdwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//ul[@class='feedbackPanel']/.//span")
	private MCWebElement responseMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#callReferenceNumber>span")
	private MCWebElement callReferenceNumberLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#serviceCode>span")
	private MCWebElement serviceDescriptionLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#cardNumberID>span")
	private MCWebElement deviceNumberLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#requestDate>span>span")
	private MCWebElement requestDateLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#crAccountNbr>span")
	private MCWebElement walletNumberLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#userCreate>span")
	private MCWebElement loggedByLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#actualClosureDate>span>span")
	private MCWebElement closureDateLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#closedBy>span")
	private MCWebElement closedByLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#estimatedClosurePeriod>span")
	private MCWebElement closurePeriodLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind="span#priorityRequest>input")
	private MCWebElement priorityRequestChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind="//li/a[text()='Current Status and Limits']")
	private MCWebElement tabCurrentStatusAndLimits;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Avail Card :']/../../following-sibling::td[1]/span/span")
	private MCWebElement creditLimitLable;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Avail Account :']/../../following-sibling::td[1]/span/span")
	private MCWebElement creditLimitLableAccount;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Avail Client :']/../../following-sibling::td[1]/span/span")
	private MCWebElement creditLimitLableClient;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Client :']/../../following-sibling::td[1]/span/span")
	private MCWebElement creditLimitClient;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Account :']/../../following-sibling::td[1]/span/span")
	private MCWebElement creditLimitAccount;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Card :']/../../following-sibling::td[1]/span/span")
	private MCWebElement creditLimitCard;



	private static final By INFO_WALLET_NUMBER = By.xpath("//li[@class='feedbackPanelINFO'][2]/span");

	protected String getWalletNumber() {
		WebElement walletNumber = new WebDriverWait(driver(), timeoutInSec).until(ExpectedConditions.visibilityOfElementLocated(INFO_WALLET_NUMBER));
		logger.info(WALLET_NUMBER, CharMatcher.DIGIT.retainFrom(walletNumber.getText()));		
		return CharMatcher.DIGIT.retainFrom(walletNumber.getText());
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(productTypeSearchDDwn),
				WebElementUtils.visibilityOf(deviceNumberSearchTxt));
	}

	public void clickFirstRowEditLink() {
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(firstRowEditLink))
		.click();
	}

	public void clickWalletDetailsTab() {
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(walletDetailsLnk)).click();
	}

	public void clickDeviceDetailsTab() {
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(deviceDetailsLnk)).click();
	}

	public void clickCurrentStatusAndLimitsTab(){
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(currentStatusAndLimitTab)).click();
	}

	public void clickActivateRadioButton() {
		activateRBtn.click();
	}

	public void clickDeActivateRadioButton() {
		deactivateRBtn.click();
	}

	public void clickLifeLongActivationRadioButton() {
		lifeLongActivationRBtn.click();
	}

	public void clickImmediateActivationForNHoursRadioButton() {
		immediateActivationForNHoursRBtn.click();
	}

	public void clickActivationInPeriodRadioButton() {
		activationInPeriodRBtn.click();
	}

	public void enterTimeInHours(String timeInHours) {
		WebElementUtils.enterText(timeInHoursTxt, timeInHours);
	}

	public String getDeviceNumberStatus(){
		return getFirstRecordCellTextByColumnName(COLUMN_STATUS);
	}

	public void selectServiceCode(String serviceCode){
		WebElementUtils.selectDropDownByVisibleText(serviceCodeDdwn, serviceCode);
	}

	public void selectCreditLimitType(String limittype){
		WebElementUtils.selectDropDownByVisibleText(selectLimitType, limittype);
	}

	public void storeSaleDate(){
		saleDate = new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(saleDateTxt)).getText();
	}

	public String saleDate() {
		return saleDate;
	}

	public void selectServiceCodeByValue(String serviceCode){
		WebElementUtils.selectDropDownByValue(serviceCodeDdwn, serviceCode);
	}

	public void selectServiceCodeByText(String serviceText){
		selectByVisibleText(serviceCodeDdwn, serviceText);
	}
	public void storeActivationDate(){
		activationDate = new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(activationDateTxt)).getText();
	}

	public String activationDate() {
		return activationDate;
	}

	public void storeDeliveryDate(){
		deliveryDate = new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(deliveryDateTxt)).getText();
	}

	public String deliveryDate() {
		return deliveryDate;
	}

	public String getAvailablebalance() {
		return availablebalance;
	}

	public void setAvailablebalance(String availablebalance) {
		this.availablebalance = availablebalance;
	}

	public void clickGoButton() {
		clickWhenClickableDoNotWaitForWicket(goBtn);
	}

	public void clickCustomerCareEditLink(){
		clickFirstRowEditLink();
	}

	public void enterNotes(String notes){
		WebElementUtils.enterText(notesTxt, notes);
	}

	public void enterClientCreditLimit(String clientcreditlimit){
		WebElementUtils.enterText(creditClientLimit, clientcreditlimit);
	}

	public void enterAccountCreditLimit(String accountcreditlimit){
		WebElementUtils.enterText(creditAccountLimit, accountcreditlimit);
	}

	public void enterNewCreditLimit(String newcreditlimit){
		WebElementUtils.enterText(newCreditLimit, newcreditlimit);
	}

	public void selectLimitType(String type){
		WebElementUtils.selectDropDownByVisibleText(selectLimitType, type);
	}

	public void enterEmailID(HelpdeskGeneral general){
		enterValueinTextBox(emailIDInptTxt,general.getNewEmailID());
	}

	public void enterMobileNo(HelpdeskGeneral general){
		SelectDropDownByValue(isdCodeDdwn,general.getNewMobileISD());
		enterValueinTextBox(mobileInptTxt,general.getNewMobileNo());
	}

	public boolean validateMandatoryFields(int mandatoryFields){
		clickSaveButton();
		clickSaveButton();
		if(errorMessage().size()== mandatoryFields && errorMessage().get(mandatoryFields-1).equalsIgnoreCase(ERROR_MESSAGE))
			return true;
		else
			return false;
	}

	public String activationMessage(){
		return new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(activationMessage)).getText();
	}

	public void clickOKButtonPopup(){
		SimulatorUtilities.wait(5000);
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(okBtn))
		.click();
	}

	public void clickCancelButtonPopup(){
		SimulatorUtilities.wait(5000);
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(cancelBtn))
		.click();
	}

	public void clickEndCall() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(endCallBtn))
		.click();
	}

	public void setActiveDeviceNumberByCardPackId(HelpdeskGeneral helpdeskGeneral, String registeredType){
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, helpdeskGeneral.getProductType());
		WebElementUtils.enterText(cardPackIdTxt, helpdeskGeneral.getCardPackId());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		if(REGISTERED.equalsIgnoreCase(registeredType))
			status = DeviceStatus.NORMAL;
		else if(NOT_REGISTERED.equalsIgnoreCase(registeredType))
			status = DeviceStatus.READY_FOR_SALE;
		for (int i=1; i <= getRowCountFromTable(); i++)
		{
			if (getCellTextByColumnName(i,COLUMN_STATUS).equalsIgnoreCase(status))
			{
				activeDeviceNumber = getCellTextByColumnName(i,"Device Number");
				break;
			}
		}
		logger.info("Active Device Number is: {}",activeDeviceNumber);
		helpdeskGeneral.setDeviceNumber(activeDeviceNumber);
	}

	public String getDeviceStatus(Device device) {
		logger.info("Fetching information for : {}",device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt,device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		return getFirstRecordCellTextByColumnName(COLUMN_STATUS);
	}

	public boolean verifyTransactionOfDevice(Device device){
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		editDeviceLink.click();
		pageScrollDown();
		transactionsBtn.click();
		runWithinPopup("Transaction", () ->{
			WebElementUtils.pickDate(effectiveDateTxt, LocalDate.now());
			WebElementUtils.pickDate(endDateTxt, LocalDate.now());
			clickSearchButton();
			firstRow = getFirstColumnValueFromTable();
			clickCloseButton();
		});
		clickEndCall();
		return firstRow.isEmpty();
	}

	public void activateDevice(HelpdeskGeneral helpdeskGeneral) {
		logger.info("activate device: {}", helpdeskGeneral.getCardPackId());
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup("108 - Activate Device ", () -> {
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();			
		});
		//There is a delay in page rendering
		SimulatorUtilities.wait(5000);
		clickEndCall();
	}

	public BigDecimal activateCreditLimitChangeRequest(HelpdeskGeneral helpdeskGeneral){
		logger.info("227 - Credit limit Change Commercial Cards: {}",helpdeskGeneral.getCardPackId());
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup("227 - Credit limit Change Commercial Cards", ()->{
			//			if(helpdeskGeneral.getLimittypestatus().equalsIgnoreCase("true")){
			//				selectLimitType(helpdeskGeneral.getLimitType());
			//				WebElementUtils.pickDate(effectiveDateTxt, LocalDate.now());
			//				WebElementUtils.pickDate(endDateTxt, LocalDate.now());
			//			}
			selectLimitType(helpdeskGeneral.getLimitType());
			//			enterClientCreditLimit(helpdeskGeneral.getClientCreditLimit());
			//			enterAccountCreditLimit(helpdeskGeneral.getAccountCreditLimit());
			//			enterNewCreditLimit(helpdeskGeneral.getNewCreditLimit());
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();
		});
		SimulatorUtilities.wait(5000);
		clickCurrentStatusAndLimitsTab();
		clickEndCall();
		return new BigDecimal(helpdeskGeneral.getNewCreditLimit()+".00");
	}

	public void setupCurrency(String lst) {
		SimulatorUtilities.wait(1000);
		int rowCount = driver().findElements(By.xpath(TABLE_XPATH)).size();
		values = lst.trim().split(",");
		for (int i = 0; i < values.length ; i++)
		{
			for (int j = 2; j <= rowCount; j++)
			{
				String[] data = values[i].trim().split(":");
				String currencyName = data[0].trim();
				String priority = data[1].trim();
				if (driver().findElement(By.xpath(TABLE_XPATH+"["+j+"]/td[1]")).getText().equalsIgnoreCase(currencyName))
				{
					WebElement element = driver().findElement(By.xpath(TABLE_XPATH+"["+j+"]/td[2]//select"));
					WebElementUtils.retryUntilNoErrors(() -> new Select(element).selectByVisibleText(priority));
					break;
				}

			}
		}
	}

	public void setupDeviceCurrency(HelpdeskGeneral helpdeskGeneral) {
		logger.info("Setup Device Currency: {}", "helpdeskGeneral.getCardPackId()");
		selectServiceCode(helpdeskGeneral.getCurrencySetupServiceCode());
		clickGoButton();
		runWithinPopup("312 - Currency Setup", () -> {
			setupCurrency(helpdeskGeneral.getCurrencyWithPriority());
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			helpdeskGeneral.setNewWalletNumber(getWalletNumber());
			clickOKButtonPopup();			
		});
		//There is a delay in page rendering
		SimulatorUtilities.wait(5000);
		clickEndCall();
	}

	public boolean verifyCurrencySetupDoneCorrectly(HelpdeskGeneral helpdeskGeneral, Device device){
		logger.info("verify added currecy for device number: {}", device.getDeviceNumber());
		int count = 0;
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		editDeviceLink.click();
		clickWalletDetailsTab();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		int rowCount = driver().findElements(By.xpath("//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr")).size();
		values = helpdeskGeneral.getCurrencyWithPriority().trim().split(",");
		for (int i = 0; i < values.length ; i++)
		{
			for (int j = 1; j <= rowCount; j++)
			{
				String[] data = values[i].trim().split(":");
				String currencyName = data[0].trim();
				if (getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency").equalsIgnoreCase(currencyName))
				{
					device.setWalletNumber2(getCellTextByColumnNameInEmbeddedTab(j, "Wallet Number"));
					count++;
					break;
				}
			}
		}
		clickEndCall();
		return (count == values.length) ? true : false;
	}

	public void searchWithDeviceNumber(HelpdeskGeneral helpdeskGeneral) {
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, helpdeskGeneral.getProductType());
		WebElementUtils.enterText(deviceNumberSearchTxt, helpdeskGeneral.getDeviceNumber());
		clickSearchButton();
	}

	public void searchByDeviceNumber(Device device){
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
	}

	public void activateDeviceForEcommerce(HelpdeskGeneral helpdeskGeneral) {
		logger.info("activate device for ecommerce: {}", helpdeskGeneral.getDeviceNumber());
		selectServiceCode(helpdeskGeneral.getServiceCode());
		clickGoButton();
		runWithinPopup("304 - E-commerce Activation/Deactivation", () -> {
			clickActivateRadioButton();
			clickLifeLongActivationRadioButton();
			enterNotes(helpdeskGeneral.getNotes());
			clickSaveButton();
			verifyOperationStatus();
			clickOKButtonPopup();			
		});
		clickEndCall();
	}

	public BigDecimal getWalletBalance(Device device){
		logger.info("Get Wallet Balance for device number: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		editDeviceLink.click();
		clickWalletDetailsTab();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		BigDecimal balanceAmount = new BigDecimal(getFirstRecordCellTextByColumnNameInEmbeddedTab(CURRENT_AVAILABLE_BALANCE));
		clickEndCall();
		return balanceAmount;
	}

	public void searchByClientID(String clientID, String cardType){
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn,cardType);
		WebElementUtils.enterText(clientIDInpt,clientID);
		clickSearchButton();
	}

	public String getWalletNumber(Device device){
		logger.info("Get Wallet Number for Device: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		editDeviceLink.click();
		clickWalletDetailsTab();
		String walletNumber = getFirstRecordCellTextByColumnNameInEmbeddedTab(WALLET_NUMBER);
		clickEndCall();
		return walletNumber;
	}

	public String getWalletBalanceInformation(Device device){
		logger.info("Get Wallet Balance Information for Device: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		editDeviceLink.click();
		clickWalletDetailsTab();
		SimulatorUtilities.wait(5000);//this to wait till the table gets loaded
		int rowCount = driver().findElements(By.xpath("//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr")).size();
		DecimalFormat dec = new DecimalFormat("#0.00");
		for (int j = 1; j <= rowCount; j++)
		{
			if (j == 1)
			{
				logger.info("Current Available Balance {} Settled Debit {} ",getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"),getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));
				Double balance= Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance")) + Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));			
				logger.info("Current Available Balance + Settled Debit : "+dec.format(balance));
				walletBalanceInformation = getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency")+":"+dec.format(balance)+":"+getCellTextByColumnNameInEmbeddedTab(j, "WALLET_NUMBER");

			}else
			{	
				logger.info("Current Available Balance {} Settled Debit {} ",getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance"),getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));
				Double balance= Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance")) + Double.parseDouble(getCellTextByColumnNameInEmbeddedTab(j, "Settled Debit"));
				logger.info("Current Available Balance + Settled Debit : "+dec.format(balance));
				walletBalanceInformation = walletBalanceInformation+","+getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency")+":"+dec.format(balance)+":"+getCellTextByColumnNameInEmbeddedTab(j, "WALLET_NUMBER");				
			}
		}
		clickEndCall();
		return walletBalanceInformation;
	}

	public boolean verifyBalanceUpdatedCorreclty(String beforeLoadBalanceInformation, String transactionDetailsFromExcel, String afterLoadBalanceInformation){
		logger.info("Verify Wallet Balance Information for Device is added correctly");

		String[] beforeLoadBalanceData = beforeLoadBalanceInformation.trim().split(",");
		String[] transactionData = transactionDetailsFromExcel.trim().split(",");
		String[] afterLoadBalanceData = afterLoadBalanceInformation.trim().split(",");

		int count = 0;
		for (int i = 0; i < transactionData.length; i++)
		{
			String[] transactionDataValues = transactionData[i].trim().split(":");
			String currencyName = transactionDataValues[0];
			for (int j = 0 ; j < afterLoadBalanceData.length; j++)
			{
				String[] beforeLoadBalanceDataValues = beforeLoadBalanceData[j].trim().split(":");
				String[] afterLoadBalanceDataValues = afterLoadBalanceData[j].trim().split(":");
				if (currencyName.equalsIgnoreCase(beforeLoadBalanceDataValues[0]))
				{
					BigDecimal calculatedBalance = new BigDecimal(beforeLoadBalanceDataValues[1]).add(new BigDecimal(transactionDataValues[1]));
					if (calculatedBalance.equals(new BigDecimal(afterLoadBalanceDataValues[1])))
					{
						count++;
						break;
					}
				}
			}
		}
		return (count == transactionData.length) ? true : false;
	}

	public boolean verifyBalanceDeductedCorreclty(String beforeLoadBalanceInformation, String transactionDetailsFromExcel, String afterLoadBalanceInformation){
		logger.info("Verify Wallet Balance Information for Device after Transaction Deduction");

		String[] beforeLoadBalanceData = beforeLoadBalanceInformation.trim().split(",");
		String[] transactionData = transactionDetailsFromExcel.trim().split(",");
		String[] afterLoadBalanceData = afterLoadBalanceInformation.trim().split(",");

		int count = 0;
		for (int i = 0; i < transactionData.length; i++)
		{
			String[] transactionDataValues = transactionData[i].trim().split(":");
			String currencyName = transactionDataValues[0];
			for (int j = 0 ; j < afterLoadBalanceData.length; j++)
			{
				String[] beforeLoadBalanceDataValues = beforeLoadBalanceData[j].trim().split(":");
				String[] afterLoadBalanceDataValues = afterLoadBalanceData[j].trim().split(":");
				if (currencyName.equalsIgnoreCase(beforeLoadBalanceDataValues[0]))
				{
					BigDecimal calculatedBalance = new BigDecimal(beforeLoadBalanceDataValues[1]).subtract(new BigDecimal(transactionDataValues[1]));
					if (calculatedBalance.equals(new BigDecimal(afterLoadBalanceDataValues[1])))
					{
						count++;
						break;
					}
				}
			}
		}
		return (count == transactionData.length) ? true : false;
	}

	public boolean verifyBalanceNotChanged(String beforeLoadBalanceInformation, String afterLoadBalanceInformation){
		logger.info("Verify Wallet Balance Information for Device Not Changed");

		String[] beforeLoadBalanceData = beforeLoadBalanceInformation.trim().split(",");
		String[] afterLoadBalanceData = afterLoadBalanceInformation.trim().split(",");

		int count = 0;
		for (int i = 0; i < beforeLoadBalanceData.length; i++)
		{
			String[] beforeLoadDataValues = beforeLoadBalanceData[i].trim().split(":");
			String currencyName = beforeLoadDataValues[0];
			for (int j = 0 ; j < afterLoadBalanceData.length; j++)
			{
				String[] beforeLoadBalanceDataValues = beforeLoadBalanceData[j].trim().split(":");
				String[] afterLoadBalanceDataValues = afterLoadBalanceData[j].trim().split(":");
				if (currencyName.equalsIgnoreCase(beforeLoadBalanceDataValues[0]))
				{
					if ( new BigDecimal(beforeLoadBalanceDataValues[1]).equals(new BigDecimal(afterLoadBalanceDataValues[1])))
					{
						count++;
						break;
					}
				}
			}
		}
		return (count == beforeLoadBalanceData.length) ? true : false;
	}

	public boolean verifyInitialLoadBalanceUpdatedCorreclty(String transactionDetailsFromExcel, String afterLoadBalanceInformation){
		logger.info("Verify Initial Load Wallet Balance Information for Device");

		String[] transactionData = transactionDetailsFromExcel.trim().split(",");
		String[] afterLoadBalanceData = afterLoadBalanceInformation.trim().split(",");

		int count = 0;
		for (int i = 0; i < transactionData.length; i++)
		{
			String[] transactionDataValues = transactionData[i].trim().split(":");
			String currencyName = transactionDataValues[0];
			for (int j = 0 ; j < afterLoadBalanceData.length; j++)
			{
				String[] afterLoadBalanceDataValues = afterLoadBalanceData[j].trim().split(":");
				if (currencyName.equalsIgnoreCase(afterLoadBalanceDataValues[0]))
				{
					if (new BigDecimal(transactionDataValues[1]).equals(new BigDecimal(afterLoadBalanceDataValues[1])))
					{
						count++;
						break;
					}
				}
			}
		}
		return (count == transactionData.length) ? true : false;
	}

	public void verifyUiOperationStatus() {
		logger.info("General");
		verifySearchButton("Search");
	}

	public void selectWalleFromTransfer(String walletNumber){
		waitForElementVisible(Element("//td[@id='fromCurrencyDataTable']"));
		waitForWicket();
		clickWhenClickable(Element("//td[@id='fromCurrencyDataTable']//./td/span[text()='"+walletNumber+"']//..//..//td//input"));
	}

	public void selectWalleToTransfer(String walletNumber){
		waitForElementVisible(Element("//td[@id='toCurrencyDataTable']"));
		waitForWicket();
		clickWhenClickable(Element("//td[@id='toCurrencyDataTable']//./td/span[text()='"+walletNumber+"']//..//..//td//input"));
	}

	public void clickSaveButtonPopup(){
		clickWhenClickable(saveBtn);
	}

	public void selectDeviceToTransferFunds(String deviceToTransfer){
		WebElementUtils.waitForWicket(driver());
		WebElementUtils.elementToBeClickable(toDeviceDropDn);
		WebElementUtils.selectDropDownByValue(toDeviceDropDn, deviceToTransfer);
	}

	public void enterAmountToDebit(String amountToTransfer){
		WebElementUtils.enterText(debitAmtInpt, amountToTransfer);
	}

	public void enterNoteForTransaction(String transactionNote){
		WebElementUtils.enterText(transactionNotesInpt, transactionNote);
	}

	public String verifyTheWalletToWalletTransactionStatus(){
		return getTextFromPage(walletToWalletConfirMsg);
	}

	public void walletToWalletTransfer(Device device) {
		selectServiceCode("Wallet To Wallet Transfer [465]");
		clickGoButton();		
		runWithinPopup("465 - Wallet To Wallet Transfer", () -> {			
			selectWalleFromTransfer(device.getWalletNumber());
			logger.info("Wallet from transfer the fund: {}", device.getWalletNumber());
			selectDeviceToTransferFunds(device.getDeviceNumber());			
			logger.info("Wallet to transfer the fund: {}", device.getNewWalletNumber());
			selectWalleToTransfer(device.getNewWalletNumber());
			enterAmountToDebit(device.getTransactionAmount());
			enterNoteForTransaction(NOTE_WALLET_FUND_TRANSFER);
			clickSaveButtonPopup();
			clickOKButtonPopup();
		});
		clickEndCall();
	}

	public boolean serviceRequestCardholderLoginPassword(String clientID) {
		logger.info("Reset Cardholder Login Password [459] for {}", clientID );
		selectServiceCodeByValue(SERV_CODE_LOGIN_PASSWORD);
		clickGoButton();
		runWithinPopup(LABEL_LOGIN_PASSWORD, () -> {
			enterNotes("Servic_Request for " + clientID);
			clickSaveButton();

			if(verifyServiceRequestStatus().contains(ConstantData.RECORD_PROCESSED_SUCCESSFULLY)){
				logger.info("Reset Login password service request is completed for {}", clientID);
				clickOKButtonPopup();
				serviceStatus = true;
			}else{
				logger.info("Reset Login password service request is not completed for {}", clientID);
				clickCancelButtonPopup();
			}			
		});
		SimulatorUtilities.wait(5000);
		clickEndCall();
		return serviceStatus;
	}

	public boolean serviceRequestCardholderTransactionPassword(String clientID) {
		logger.info("Reset Cardholder Transaction Password [250] for {}", clientID);

		selectServiceCodeByValue(SERV_CODE_TRANSACTION_PASSWORD);
		clickGoButton();
		runWithinPopup(LABEL_TRANSACTION_PASSWORD, () -> {			
			enterNotes("Servic_Request for " + clientID);
			clickSaveButton();

			if(verifyServiceRequestStatus().contains(ConstantData.RECORD_PROCESSED_SUCCESSFULLY)){
				logger.info("Reset Transaction password service request is completed for {}", clientID);
				clickOKButtonPopup();
				serviceStatus = true;
			}else{
				logger.info("Reset Transaction password service request is not completed for {}", clientID);
				clickCancelButtonPopup();
			}
		});
		SimulatorUtilities.wait(5000);
		clickEndCall();
		return serviceStatus;
	}

	public String verifyServiceRequestStatus(){		
		return getTextFromPage(responseMessage);
	}

	public List<String> errorMessage(){		
		return getListOfElements(ERROR_MESSAGE_XPATH);
	}

	public boolean verifyFieldPresence(String field){
		try{
			Element(String.format(".//form[@id='id1a4']//table[@class='modelFormClass'][1]//*[text() [contains(.,'%s:')]]",field));
			return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}

	public boolean verifyCallReferenceNo(){
		return verifyFieldPresence(CALL_REFERENCE_NUMBER)&&StringUtils.isNumeric(getTextFromPage(callReferenceNumberLbl));

	}

	public boolean verifyServiceDescription(HelpdeskGeneral helpdeskGeneral){
		return verifyFieldPresence(SERVICE_DESCRIPTION)&&getTextFromPage(serviceDescriptionLbl).equalsIgnoreCase(String.format(helpdeskGeneral.getServiceDescription()+" [%s]",helpdeskGeneral.getServiceCode()));
	}

	public boolean verifyDeviceNumber(HelpdeskGeneral helpdeskGeneral){
		return verifyFieldPresence(DEVICE_NUMBER)&&getTextFromPage(deviceNumberLbl).equalsIgnoreCase(helpdeskGeneral.getDeviceNumber());
	}


	public boolean verifyRequestDate() {
		if (verifyFieldPresence(REQUEST_DATE)) {
			try {
				LocalDate.parse(getTextFromPage(requestDateLbl),
						DateTimeFormatter.ofPattern("dd/MM/uuuu kk:mm:ss"));
				return true;
			} catch (DateTimeParseException e) {
				return false;
			}
		} else
			return false;
	}

	public boolean verifyLoggedBy(){
		return verifyFieldPresence(LOGGED_BY); 
	}

	public boolean verifyWalletNumber(HelpdeskGeneral general){
		return verifyFieldPresence(WALLET_NUMBER)&&getTextFromPage(walletNumberLbl).equalsIgnoreCase(general.getDefaultWalletNumber());
	}

	public boolean verifyClosureDate(){
		if(verifyFieldPresence(CLOSURE_DATE)){
			try{
				LocalDate.parse(getTextFromPage(closureDateLbl), DateTimeFormatter.ofPattern("dd/MM/uuuu kk:mm:ss"));
				return true;
			}
			catch(DateTimeParseException e){
				return false;
			}
		}
		else
			return false;
	}

	public boolean verifyClosedBy(){
		return verifyFieldPresence(LOGGED_BY);
	}

	public  boolean verifyEstimatedClosurePeriod(){
		return verifyFieldPresence(CLOSURE_PERIOD);
	}

	public boolean verifyPriorityRequest(){
		if (verifyFieldPresence(PRIORITY_REQUEST)){
			ClickCheckBox(priorityRequestChkBx,true);
			return true;
		}
		else
			return false;		
	}

	public boolean changeRegisteredEmailID(HelpdeskGeneral general) {
		logger.info("change Registered Email ID");

		selectServiceCodeByText(CHANGE_REGISTERED_EMAIL_ID);
		clickGoButton();
		runWithinPopup(CHANGE_REGISTERED_EMAIL_ID, () -> {			
			enterEmailID(general);
			enterNotes("Servic_Request for registered email ID" );
			clickSaveButton();

			if(verifyServiceRequestStatus().contains(ConstantData.RECORD_PROCESSED_SUCCESSFULLY)){
				logger.info("Registered Email ID service request processed successfully");
				clickOKButtonPopup();
				serviceStatus = true;
			}else{
				logger.info("Registered Email ID service request rejected");
				clickCancelButtonPopup();
			}
		});
		clickEndCall();
		return serviceStatus;
	}

	public boolean changeRegisteredMobileNo(HelpdeskGeneral general) { 
		logger.info("change Registered Mobile No");

		selectServiceCodeByText(CHANGE_REGISTERED_MOBILE_NO);
		clickGoButton();
		runWithinPopup(CHANGE_REGISTERED_MOBILE_NO,
				() -> {
					enterMobileNo(general);
					enterNotes("Servic_Request for registered Mobile No");
					clickSaveButton();

					if (verifyServiceRequestStatus().contains(
							ConstantData.RECORD_PROCESSED_SUCCESSFULLY)) {
						logger.info("Registered Mobile No service request processed successfully");
						clickOKButtonPopup();
						serviceStatus = true;
					} else {
						logger.info("Registered Mobile No service request rejected");
						clickCancelButtonPopup();
					}
				});
		clickEndCall();
		return serviceStatus;
	}

	public boolean validateRequiredFields(HelpdeskGeneral general){
		logger.info("Validate required fields in change Registered Email ID Screen");

		selectServiceCodeByText(CHANGE_REGISTERED_EMAIL_ID);
		clickGoButton();
		runWithinPopup(CHANGE_REGISTERED_EMAIL_ID, () -> {	
			verifyCallReferenceNo();
			verifyServiceDescription(general);
			verifyDeviceNumber(general);
			verifyRequestDate();
			verifyLoggedBy();
			verifyWalletNumber(general);
			verifyClosureDate();
			verifyClosedBy();
			verifyEstimatedClosurePeriod();
			verifyPriorityRequest();
		});
		return true;
	}

	public BigDecimal noteDownAvailableLimit(String type){	
		BigDecimal creditLimit;
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);			
		creditLimit = new BigDecimal(creditLimitLable.getText());
		logger.info("Credit limit noted down : {} ",creditLimit);
		clickEndCall();
		return creditLimit;				

	}

	public LinkedList<BigDecimal> noteDownCreditLimit(String type){	
		LinkedList<BigDecimal> creditLimit=new LinkedList<BigDecimal>();
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);		
		creditLimit.add(new BigDecimal(creditLimitLable.getText()));
		creditLimit.add(new BigDecimal(creditLimitLableAccount.getText()));	
		creditLimit.add(new BigDecimal(creditLimitLableClient.getText()));
		creditLimit.add(new BigDecimal(creditLimitClient.getText()));
		creditLimit.add(new BigDecimal(creditLimitAccount.getText()));
		creditLimit.add(new BigDecimal(creditLimitCard.getText()));
		logger.info("Credit limit noted down : {} ",creditLimitAccount);
		clickEndCall();
		return creditLimit;				

	}

	public BigDecimal noteDownAvailableClient(String type){	
		BigDecimal creditLimitClient;
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);			
		creditLimitClient = new BigDecimal(creditLimitLableClient.getText());		
		logger.info("Credit limit noted down : {} ",creditLimitClient);
		clickEndCall();
		return creditLimitClient;				

	}

	public BigDecimal noteDownClient(String type){	
		BigDecimal creditClient;
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);			
		creditClient = new BigDecimal(creditLimitClient.getText());		
		logger.info("Credit limit noted down : {} ",creditClient);
		clickEndCall();
		return creditClient;				

	}

	public BigDecimal noteDownAccount(String type){	
		BigDecimal creditAccount;
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);			
		creditAccount = new BigDecimal(creditLimitAccount.getText());		
		logger.info("Credit limit noted down : {} ",creditAccount);
		clickEndCall();
		return creditAccount;				

	}

	public BigDecimal noteDownCard(String type){	
		BigDecimal creditCard;
		WebElementUtils.elementToBeClickable(currentStatusAndLimitTab);
		clickWhenClickable(currentStatusAndLimitTab);			
		creditCard = new BigDecimal(creditLimitCard.getText());		
		logger.info("Credit limit noted down : {} ",creditCard);
		clickEndCall();
		return creditCard;				

	}
}
