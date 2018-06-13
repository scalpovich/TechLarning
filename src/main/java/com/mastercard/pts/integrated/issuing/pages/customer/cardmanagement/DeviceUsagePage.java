package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceUsage;
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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Daily Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Amount Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement dailyDebitTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Period Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Amount Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement periodDebitTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='sectionHead']//span[text()='Yearly Total']/../../following-sibling::tr[1]/td[@class='displayName']/span[contains(text(),'Debit Transaction Amount Utilized')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement yearlyDebitTransactionAmountUtilizedLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Device Transaction Usage']")
	private MCWebElement devicetransactionUsageTabLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".dataview")
	private MCWebElement dataTable;

	@PageElement(findBy = FindBy.CSS, valueToFind = "ul.tabs li a[href*='tab3']")
	private MCWebElement walletMCGUsageSubMenu;

	private static final String FRAME_VIEW_DEVICE_USAGE = "View Device Usage";
	private static final String FRAME_VIEW_WALLET_USAGE = "View Wallet Usage";
	public static final String MCG_CODE = "MCG Code";
	public static final String DAILY_AMOUNT_DOMESTIC_UTILIZED = "Daily Amount Domestic Utilized";
	public static final String DAILY_VELOCLITY_DOMESTIC_UTILIZED = "Daily Velocity Domestic Utilized";
	public static final String DAILY_AMOUNT_INTERNATIONAL_UTILIZED = "Daily Amount Intenational Utilized";
	public static final String DAILY_VELOCLITY_INTERNATIONAL_UTILIZED = "Daily Velocity Intenational Utilized";

	public void verifyUiOperationStatus() {
		logger.info("Device Usage");
		verifySearchButton("Search");
	}

	public void enterDeviceNumber(DeviceUsage deviceUsage) {
		enterValueinTextBox(deviceNumber, deviceUsage.getDeviceNumber());
	}

	public void navigateToWalletMCGUsage() {
		clickWhenClickable(walletMCGUsageSubMenu);
	}

	public Optional<Map<String, String>> getWalletMCGUsageData() {
		Map<String, String> map = new HashMap<>();
		map.put(MCG_CODE, getCellTextByColumnName(1, MCG_CODE));
		map.put(DAILY_AMOUNT_DOMESTIC_UTILIZED, getCellTextByColumnName(1, DAILY_AMOUNT_DOMESTIC_UTILIZED));
		map.put(DAILY_VELOCLITY_DOMESTIC_UTILIZED, getCellTextByColumnName(1, DAILY_VELOCLITY_DOMESTIC_UTILIZED));
		map.put(DAILY_AMOUNT_INTERNATIONAL_UTILIZED, getCellTextByColumnName(1, DAILY_AMOUNT_INTERNATIONAL_UTILIZED));
		map.put(DAILY_VELOCLITY_INTERNATIONAL_UTILIZED, getCellTextByColumnName(1, DAILY_VELOCLITY_INTERNATIONAL_UTILIZED));

		return Optional.of(map);
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
			// Map<String, String> deviceTransactionUsage = new HashMap<String, String>();
			// List<MCWebElement> allHeaders = dataTable.inputs(By.tagName("th")).getElements();
			// List<MCWebElement> allData = dataTable.inputs(By.tagName("td")).getElements();
			// for (int i = 0; i < allHeaders.size(); i++) {
			// deviceTransactionUsage.put(allHeaders.get(i).getText(), allData.get(i).getText());
			// }

				deviceUsageDetails.add(getCellTextByColumnName(1, "Daily Amount Utilized"));
				deviceUsageDetails.add(getCellTextByColumnName(1, "Periodic Amount Utilized"));
				deviceUsageDetails.add(getCellTextByColumnName(1, "Yearly Amount Utilized"));
				WebElementUtils.scrollDown(driver(), 250, 350);
				clickCloseButton();
			});
		return deviceUsageDetails;
	}

	public Optional<Map<String, String>> getWalletMCGUsage(DeviceUsage deviceUsage) {
		enterDeviceNumber(deviceUsage);
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup(FRAME_VIEW_DEVICE_USAGE, () -> viewFirstRecord());
		switchToIframe(FRAME_VIEW_WALLET_USAGE);
		navigateToWalletMCGUsage();
		return getWalletMCGUsageData();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(deviceNumber));
	}
}