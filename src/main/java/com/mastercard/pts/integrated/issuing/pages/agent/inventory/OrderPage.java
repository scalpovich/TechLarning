package com.mastercard.pts.integrated.issuing.pages.agent.inventory;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Order;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = InventoryNav.TAB_INVENTORY, treeMenuItems = { InventoryNav.L1_ORDER, InventoryNav.L2_ORDER })
public class OrderPage extends InventoryAbstractPage {
	private static final Logger logger = LoggerFactory.getLogger(OrderPage.class);

	@PageElement(findBy = FindBy.ID, valueToFind = "qtyOrdered")
	private MCWebElement quantityOrderedTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "memo")
	private MCWebElement memoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='OK']")
	private MCWebElement okBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement successMessage;

	@Override
	public void verifyUiOperationStatus() {
		logger.info("Order");
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(brancIdDDwn), WebElementUtils.visibilityOf(programCodeDDwn),
				WebElementUtils.visibilityOf(deviceTypeDDwn), WebElementUtils.visibilityOf(quantityOrderedTxt),
				WebElementUtils.visibilityOf(memoTxt));
	}

	public void selectBranchId(String branchId) {
		WebElementUtils.selectDropDownByVisibleText(brancIdDDwn, branchId);
	}

	public void selectProgramCode(String programCode) {
		WebElementUtils.selectDropDownByVisibleText(programCodeDDwn, programCode);
	}

	public void selectDeviceType(String deviceType) {
		WebElementUtils.selectDDByVisibleText(deviceTypeDDwn, deviceType);
	}

	public void enterQuantityOrdered(String quantityOrdered) {
		WebElementUtils.enterText(quantityOrderedTxt, quantityOrdered);
	}

	public void enterMemo(String memo) {
		WebElementUtils.enterText(memoTxt, memo);
	}

	@Override
	public void clickSubmitButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(submitBtn)).click();
	}

	public String getOrderNumber() {
		String message = getOrderCreationMessage();
		return message.substring(message.lastIndexOf(' ') + 1);
	}

	public String getOrderCreationMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(successMessage)).getText();
	}

	public String createOrder(Order details) {
		logger.info("Create new order: {}", details.getBranchId());

		selectBranchId(details.getBranchId());
		selectProgramCode(details.getProgram());
		selectDeviceType(details.getDeviceType());
		enterQuantityOrdered(details.getQuantityOrdered());
		enterMemo(details.getMemo());
		clickSubmitButton();

		return getOrderNumber();
	}
}