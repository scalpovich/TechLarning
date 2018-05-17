package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
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
		Map<String, String> deviceUsageDetails = new HashMap<String, String>();
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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(deviceNumber));
	}
}