package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceUsage;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH, CardManagementNav.L2_SEARCH_AUTHORIZATION, CardManagementNav.L3_DEVICE_USAGE })
public class DeviceUsagePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(DeviceUsagePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceNumber]")
	private MCWebElement deviceNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Daily Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Velocity Utilized')]/../following-sibling::td[1]//span[@class='labeltextr']")
	private MCWebElement dailyDebitTransactionVelocityUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Daily Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Amount Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement dailyDebitTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Daily Total']/../../following-sibling::tr[2]/td[@class='displayName']/span[contains(text(),'Credit Transaction Amount Utilized')]/../following-sibling::td[1]//span[@class='labeltextr']")
	private MCWebElement dailyCreditTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Daily Total']/../../following-sibling::tr[2]/td[@class='displayName']/span[contains(text(),'Credit Transaction Velocity Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement dailyCreditTransactionVelocityUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Period Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Velocity Utilized')]/../following-sibling::td[1]//span[@class='labeltextr']")
	private MCWebElement periodDebitTransactionVelocityUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Period Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Amount Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement periodDebitTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Period Total']/../../following-sibling::tr[2]/td[@class='displayName']/span[contains(text(),'Credit Transaction Amount Utilized')]/../following-sibling::td[1]//span[@class='labeltextr']")
	private MCWebElement periodCreditTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Period Total']/../../following-sibling::tr[2]/td[@class='displayName']/span[contains(text(),'Credit Transaction Velocity Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement periodCreditTransactionVelocityUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Yearly Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Velocity Utilized')]/../following-sibling::td[1]//span[@class='labeltextr']")
	private MCWebElement yearlyDebitTransactionVelocityUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Yearly Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Amount Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement yearlyDebitTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Yearly Total']/../../following-sibling::tr[2]/td[@class='displayName']/span[contains(text(),'Credit Transaction Amount Utilized')]/../following-sibling::td[1]//span[@class='labeltextr']")
	private MCWebElement yearlyCreditTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Yearly Total']/../../following-sibling::tr[2]/td[@class='displayName']/span[contains(text(),'Credit Transaction Velocity Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement yearlyCreditTransactionVelocityUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Device Transaction Usage']")
	private MCWebElement devicetransactionUsageTabLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview")
	private MCWebElement dataTable;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Application Transaction Counter :']]/following-sibling::td[1]/span")
	private MCWebElement applicationTransactionCounter;
	
	private final String DEVICE_TRANSACTION_USAGE ="//div[@id='tab2']//table[@class='dataview']//tbody//tr";
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "ul.tabs li a[href*='tab3']")
	private MCWebElement walletMCGUsageSubMenu;
	
	private String closePopUpBtn = "a.w_close";

	private static final String FRAME_VIEW_DEVICE_USAGE = "View Device Usage";
	private static final String FRAME_VIEW_WALLET_USAGE = "View Wallet Usage";
	public static final String MCG_CODE = "MCG Code";
	public static final String DAILY_AMOUNT_DOMESTIC_UTILIZED = "Daily Amount Domestic Utilized";
	public static final String DAILY_VELOCLITY_DOMESTIC_UTILIZED = "Daily Velocity Domestic Utilized";
	public static final String DAILY_AMOUNT_INTERNATIONAL_UTILIZED = "Daily Amount International Utilized";
	public static final String DAILY_VELOCLITY_INTERNATIONAL_UTILIZED = "Daily Velocity International Utilized";
	public static final String PERIOD_AMOUNT_INTERNATIONAL_UTILIZED = "Period Amount International Utilized";
	public static final String PERIOD_AMOUNT_DOMESTIC_UTILIZED = "Period Amount Domestic Utilized";
	public static final String PERIOD_VELOCLITY_DOMESTIC_UTILIZED = "Period Velocity Domestic Utilized";
	public static final String PERIOD_VELOCITY_INTERNATIONAL_UTILIZED = "Period Velocity International Utilized";


	public void verifyUiOperationStatus() {
		logger.info("Device Usage");
		verifySearchButton("Search");
	}

	public List<String> getDeviceTransactionUsage(String cardNumber) {
		WebElementUtils.enterText(deviceNumber, cardNumber);
		searchButtonElement.click();
		List<String> deviceUsageDetails = new ArrayList<>();
		viewFirstRecord();
		runWithinPopup("View Device Usage", () -> {
			devicetransactionUsageTabLink.click();
			deviceUsageDetails.add(getCellTextByColumnName(1, "Daily Amount Utilized"));
			deviceUsageDetails.add(getCellTextByColumnName(1, "Periodic Amount Utilized"));
			deviceUsageDetails.add(getCellTextByColumnName(1, "Yearly Amount Utilized"));
			WebElementUtils.scrollDown(driver(), 250, 350);
			clickCloseButton();
		});
		return deviceUsageDetails;
	}

	public Map<String, String> getDeviceTotalUsage(String cardNumber) {
		WebElementUtils.enterText(deviceNumber, cardNumber);
		searchButtonElement.click();
		Map<String, String> deviceUsageDetails = new HashMap<>();
		viewFirstRecord();
		runWithinPopup("View Device Usage", () -> {
			deviceUsageDetails.put("dailyDebitVelocity", dailyDebitTransactionVelocityUtilizedLbl.getText());
			deviceUsageDetails.put("dailyDebitAmount", dailyDebitTransactionAmountUtilizedLbl.getText());
			deviceUsageDetails.put("dailyCreditAmount", dailyCreditTransactionAmountUtilizedLbl.getText());
			deviceUsageDetails.put("dailyCreditVelocity", dailyCreditTransactionVelocityUtilizedLbl.getText());
			deviceUsageDetails.put("periodicDebitVelocity", periodDebitTransactionVelocityUtilizedLbl.getText());
			deviceUsageDetails.put("periodicDebitAmount", periodDebitTransactionAmountUtilizedLbl.getText());
			deviceUsageDetails.put("periodicCreditAmount", periodCreditTransactionAmountUtilizedLbl.getText());
			deviceUsageDetails.put("periodicCreditVelocity", periodCreditTransactionVelocityUtilizedLbl.getText());
			deviceUsageDetails.put("yearlyDebitVelocity", yearlyDebitTransactionVelocityUtilizedLbl.getText());
			deviceUsageDetails.put("yearlyDebitAmount", yearlyDebitTransactionAmountUtilizedLbl.getText());
			deviceUsageDetails.put("yearlyCreditAmount", yearlyCreditTransactionAmountUtilizedLbl.getText());
			deviceUsageDetails.put("yearlyCreditVelocity", yearlyCreditTransactionVelocityUtilizedLbl.getText());
			WebElementUtils.scrollDown(driver(), 250, 350);
			clickCloseButton();
		});
		return deviceUsageDetails;
	}
	
	public void enterDeviceNumber(DeviceUsage deviceUsage) {
		enterValueinTextBox(deviceNumber, deviceUsage.getDeviceNumber());
	}

	public void navigateToWalletMCGUsage() {
		clickWhenClickable(walletMCGUsageSubMenu);
	}
	
	public void clickXButton(){
		getList(closePopUpBtn).get(1);
		getList(closePopUpBtn).get(0);
	}

	public DeviceUsage getWalletMCGUsageData(DeviceUsage deviceUsage, int rowNumber) {
		try{
		deviceUsage.setRecordedMCG(getCellTextByColumnName(rowNumber, MCG_CODE));
		deviceUsage.setDailyAmountDomesticUtilized(getCellTextByColumnName(rowNumber, DAILY_AMOUNT_DOMESTIC_UTILIZED));
		deviceUsage.setDailyVelocityDomesticUtilized(getCellTextByColumnName(rowNumber, DAILY_VELOCLITY_DOMESTIC_UTILIZED));
		deviceUsage.setDailyAmountInternationalUtilized(getCellTextByColumnName(rowNumber, DAILY_AMOUNT_INTERNATIONAL_UTILIZED));
		deviceUsage.setDailyVelocityInternationalUtilized(getCellTextByColumnName(rowNumber, DAILY_VELOCLITY_INTERNATIONAL_UTILIZED));
        deviceUsage.setPeriodAmountDomesticUtilized(getCellTextByColumnName(rowNumber,PERIOD_AMOUNT_DOMESTIC_UTILIZED));
        deviceUsage.setPeriodVelocityDomesticUtilized(getCellTextByColumnName(rowNumber,PERIOD_VELOCLITY_DOMESTIC_UTILIZED));
        deviceUsage.setPeriodAmountInternationalUtilized(getCellTextByColumnName(rowNumber,PERIOD_AMOUNT_INTERNATIONAL_UTILIZED));
        deviceUsage.setPeriodVelocityInternationalUtilized(getCellTextByColumnName(rowNumber,PERIOD_VELOCITY_INTERNATIONAL_UTILIZED));
		clickCloseButton();
        switchToDefaultFrame();
        switchToIframe(FRAME_VIEW_DEVICE_USAGE);
        clickCloseButton();
        switchToDefaultFrame();

		return deviceUsage;
		}
		catch(WebDriverException | NullPointerException e){
			e.printStackTrace();
			return  null;
		}
	}

	public List<String> getDeviceTotalTransactionUsage(String cardNumber) {
		WebElementUtils.enterText(deviceNumber, cardNumber);
		searchButtonElement.click();
		List<String> deviceUsageDetails = new ArrayList<>();
		viewFirstRecord();
		runWithinPopup("View Device Usage", () -> {
			deviceUsageDetails.add(dailyDebitTransactionAmountUtilizedLbl.getText());
			deviceUsageDetails.add(periodDebitTransactionAmountUtilizedLbl.getText());
			deviceUsageDetails.add(yearlyDebitTransactionAmountUtilizedLbl.getText());
			devicetransactionUsageTabLink.click();
			deviceUsageDetails.add(getCellTextByColumnName(1, "Daily Amount Utilized"));
			deviceUsageDetails.add(getCellTextByColumnName(1, "Periodic Amount Utilized"));
			deviceUsageDetails.add(getCellTextByColumnName(1, "Yearly Amount Utilized"));
			WebElementUtils.scrollDown(driver(), 250, 350);
			clickCloseButton();
		});
		return deviceUsageDetails;
	}

	public DeviceUsage getWalletMCGUsage(DeviceUsage deviceUsage) {
		enterDeviceNumber(deviceUsage);
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup(FRAME_VIEW_DEVICE_USAGE, () -> viewFirstRecord());
		switchToIframe(FRAME_VIEW_WALLET_USAGE);
		navigateToWalletMCGUsage();
		return getWalletMCGUsageData(deviceUsage,1);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(deviceNumber));
	}

	public List<String> getApplicationTransactionCounter (String cardNumber) {
		WebElementUtils.enterText(deviceNumber, cardNumber);
		searchButtonElement.click();
		List<String> atcDetails = new ArrayList<>();
		viewFirstRecord();
		runWithinPopup("View Device Usage", () -> {
			devicetransactionUsageTabLink.click();
			logger.info("Application Transaction Counter : " + applicationTransactionCounter.getText());		
			atcDetails.add(applicationTransactionCounter.getText());
			WebElementUtils.scrollDown(driver(), 250, 350);
			clickCloseButton();
		});
		return atcDetails;
	}
		
	public List<Map<String, Double>> getDeviceUsageDetails(Device device){
		List<Map<String, Double>> deviceDetails = new LinkedList<>();
		WebElementUtils.enterText(deviceNumber, device.getDeviceNumber());
		clickWhenClickable(searchButtonElement);
		String[] transactionAttributes = ConstantData.LIMIT_VALIDATION_PARAMETER.split(";");
		Map<String, Double> deviceTotalDetails = new LinkedHashMap<String, Double>();
		Map<String, Double> deviceTransactionDetails = new LinkedHashMap<String, Double>();
		viewFirstRecord();
		runWithinPopup("View Device Usage", () -> {

			//Values from Total Usage
			deviceTotalDetails.put(transactionAttributes[0], Double.parseDouble(dailyDebitTransactionVelocityUtilizedLbl .getText()));
			deviceTotalDetails.put(transactionAttributes[1], Double.parseDouble(dailyDebitTransactionAmountUtilizedLbl.getText()));
			deviceTotalDetails.put(transactionAttributes[2], Double.parseDouble(periodDebitTransactionVelocityUtilizedLbl.getText()));
			deviceTotalDetails.put(transactionAttributes[3], Double.parseDouble(periodDebitTransactionAmountUtilizedLbl.getText()));
			deviceTotalDetails.put(transactionAttributes[4], Double.parseDouble(yearlyDebitTransactionVelocityUtilizedLbl.getText()));
			deviceTotalDetails.put(transactionAttributes[5], Double.parseDouble(yearlyDebitTransactionAmountUtilizedLbl.getText()));
			
			clickWhenClickable(devicetransactionUsageTabLink);
			SimulatorUtilities.wait(500);
			deviceTransactionDetails.putAll(getDeviceTransactionUsage(deviceTransactionDetails));
			WebElementUtils.scrollDown(driver(), 250, 350);
			clickCloseButton();
		});

		deviceDetails.add(deviceTotalDetails);
		deviceDetails.add(deviceTransactionDetails);
		return deviceDetails;

	}

	private Map<String, Double> getDeviceTransactionUsage(Map<String, Double> deviceTransactionDetails){
		String[] transactionAttributes = ConstantData.LIMIT_VALIDATION_PARAMETER.split(";");
		int size = Elements(DEVICE_TRANSACTION_USAGE).size();
		for(String str : transactionAttributes){
			double sum = 0 ;
			for(int index=1;index<=size;index++){
				sum = sum + Double.parseDouble(getCellTextByColumnName(index, str));
			}
			deviceTransactionDetails.put(str, sum );
		}
		return deviceTransactionDetails;

	}
}