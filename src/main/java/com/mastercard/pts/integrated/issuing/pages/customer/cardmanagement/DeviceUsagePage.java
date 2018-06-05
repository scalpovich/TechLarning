package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_SEARCH_AUTHORIZATION,
		CardManagementNav.L3_DEVICE_USAGE})
public class DeviceUsagePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(DeviceUsagePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceNumber]")
	private MCWebElement deviceNumber;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Device Transaction Usage']")
	private MCWebElement devicetransactionUsageTabLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Application Transaction Counter :']]/following-sibling::td[1]/span")
	private MCWebElement applicationTransactionCounter;
	
	public void verifyUiOperationStatus() {
		logger.info("Device Usage");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceNumber)
				);
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
}