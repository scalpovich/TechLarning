package com.mastercard.pts.integrated.issuing.pages.agent.inventory;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Status;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = InventoryNav.TAB_INVENTORY, treeMenuItems = { InventoryNav.L1_ORDER, InventoryNav.L2_STATUS })
public class StatusPage extends InventoryAbstractPage {
	private static final Logger logger = LoggerFactory.getLogger(OrderPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#orderNo")
	private MCWebElement orderNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#status")
	private MCWebElement statusDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#orderFromDate")
	private MCWebElement orderFromDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#orderToDate")
	private MCWebElement orderToDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody//tr/td[5]")
	private MCWebElement statusMessage;

	@Override
	public void verifyUiOperationStatus() {
		logger.info("Status");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(brancIdDDwn), WebElementUtils.visibilityOf(orderNumberTxt),
				WebElementUtils.visibilityOf(statusDDwn), WebElementUtils.visibilityOf(orderFromDateDPkr), WebElementUtils.visibilityOf(orderToDateDPkr));
	}

	public void clickSearchButtonWithOrderNumber() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(searchBtn)).click();
	}
	
	public void selectBranchId(String branchId) {
		WebElementUtils.selectDropDownByVisibleText(brancIdDDwn, branchId);
	}

	public void enterOrderNumber(String orderNumber) {
		WebElementUtils.enterText(orderNumberTxt, orderNumber);
	}

	public String getStatusMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(statusMessage)).getText();
	}

	public void statusInfo(Status details) {
		logger.info("Verify Status: {}", details.getOrderNumber());

		selectBranchId(details.getBranchId());
		enterOrderNumber(details.getOrderNumber());
		clickSearchButton();
	}
}