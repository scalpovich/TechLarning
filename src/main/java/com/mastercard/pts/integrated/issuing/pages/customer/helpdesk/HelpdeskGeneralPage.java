package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.DeviceStatus;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
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
	private static final Logger logger = LoggerFactory.getLogger(HelpdeskGeneralPage.class);
	private String activeDeviceNumber;
	private String saleDate;
	private String activationDate;
	private String deliveryDate;
	private String firstRow;
	private String status;
	private String[] values;
	private String walletBalanceInformation;
	
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
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#saleDate")
	private MCWebElement saleDateTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#activationDate")
	private MCWebElement activationDateTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#deliveryDate")
	private MCWebElement deliveryDateTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "memo1:input:textAreaComponent")
	private MCWebElement notesTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value= 'Save']")
	private MCWebElement saveBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".feedbackPanelINFO")
	private MCWebElement activationMessage;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'OK']")
	private MCWebElement okBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody img[alt='Edit Record']")
	private MCWebElement firstRowEditLink;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'End Call']")
	private MCWebElement endCallBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview tbody a img")
	private MCWebElement editDeviceLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value = 'Transactions']")
	private MCWebElement transactionsBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/..")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/..")
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
	
	public void storeSaleDate(){
		saleDate = new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(saleDateTxt)).getText();
	}
	
	public String saleDate() {
		return saleDate;
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
		
	public void clickGoButton(){
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(goBtn))
		.click();
		waitForWicket();
	}
	
	public void clickCustomerCareEditLink(){
		clickFirstRowEditLink();
	}
	
	public void enterNotes(String notes){
		WebElementUtils.enterText(notesTxt, notes);
	}

	public String activationMessage(){
		return new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(activationMessage)).getText();
	}
	
	public void clickOKButtonPopup(){
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(okBtn))
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
		SimulatorUtilities.wait(3000);
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
		logger.info("Fetching information for : {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
		return getFirstRecordCellTextByColumnName(COLUMN_STATUS);
	}
	
	public boolean verifyTransactionOfDevice(Device device){
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
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
	
	public void setupCurrency(String lst) {
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
		editDeviceLink.click();
		clickWalletDetailsTab();
		
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
		editDeviceLink.click();
		clickWalletDetailsTab();
		BigDecimal balanceAmount = new BigDecimal(getFirstRecordCellTextByColumnNameInEmbeddedTab(CURRENT_AVAILABLE_BALANCE));
		clickEndCall();
		return balanceAmount;
	}
	
	public String getWalletNumber(Device device){
		logger.info("Get Wallet Number for Device: {}", device.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeSearchDDwn, device.getAppliedForProduct());
		WebElementUtils.enterText(deviceNumberSearchTxt, device.getDeviceNumber());
		clickSearchButton();
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
		editDeviceLink.click();
		clickWalletDetailsTab();

		int rowCount = driver().findElements(By.xpath("//div[@class='tab_container_privileges']//table[@class='dataview']/tbody/tr")).size();
		for (int j = 1; j <= rowCount; j++)
				{
					if (j == 1)
						walletBalanceInformation = getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency")+":"+getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance")+":"+getCellTextByColumnNameInEmbeddedTab(j, "WALLET_NUMBER");
					else
						walletBalanceInformation = walletBalanceInformation+","+getCellTextByColumnNameInEmbeddedTab(j, "Wallet Currency")+":"+getCellTextByColumnNameInEmbeddedTab(j, "Current Available Balance")+":"+getCellTextByColumnNameInEmbeddedTab(j, "WALLET_NUMBER");
				}
		clickEndCall();
		return walletBalanceInformation;
	}
	
	public boolean verifyBalanceUpdatedCorreclty(String beforeLoadBalanceInformation, String transactionDetailsFromExcel, String afterLoadBalanceInformation){
		logger.info("Verify Wallet Balance Information for Device");

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

}
