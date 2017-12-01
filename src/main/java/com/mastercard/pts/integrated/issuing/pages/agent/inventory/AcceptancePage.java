package com.mastercard.pts.integrated.issuing.pages.agent.inventory;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Acceptance;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = InventoryNav.TAB_INVENTORY, treeMenuItems = { InventoryNav.L1_ORDER, InventoryNav.L2_ACCEPTANCE })
public class AcceptancePage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(AcceptancePage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#brancId")
	private MCWebElement branchIdDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#orderNo")
	private MCWebElement orderNumberDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#dispatchNo")
	private MCWebElement dispatchNoDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Modify']")
	private MCWebElement modifyBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Ok']")
	private MCWebElement okBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='dataview']//td[2]")
	private MCWebElement tableFirstRecord;

	@PageElement(findBy = FindBy.ID, valueToFind = "quantityReceived")
	private MCWebElement quantityRecievedTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dateCreateDDMMYYYY")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "acceptanceMemo")
	private MCWebElement acceptanceMemoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement acceptanceMessage;

	public void verifyUiOperationStatus() {
		logger.info("Acceptance");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(branchIdDdwn), WebElementUtils.visibilityOf(orderNumberDdwn),
				WebElementUtils.visibilityOf(dispatchNoDdwn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Corporate User View Edit Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

	public void selectBranchId(String branchId) {
		WebElementUtils.selectDropDownByVisibleText(branchIdDdwn, branchId);
	}

	public void selectOrderNumber(String orderNumber) {
		WebElementUtils.selectDropDownByVisibleText(orderNumberDdwn, orderNumber);
	}

	public void clickTableFirstRecord() {
		SimulatorUtilities.wait(3000);//this to wait till the table gets loaded
		WebElementUtils.retryUntil(tableFirstRecord::click,
				() -> WebElementUtils.hasClass(getFinder().findOne(FindBy.X_PATH, "//*[@class='dataview']/tbody/tr[1]"), "select"));
	}

	public void clickModifyButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(modifyBtn)).click();
	}

	public void enterQuantityRecieved(String quantityOrdered) {
		WebElementUtils.enterText(quantityRecievedTxt, quantityOrdered);
	}

	public void enterMemo(String memo) {
		WebElementUtils.enterText(acceptanceMemoTxt, memo);
	}

	public void clickSubmitButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(submitBtn)).click();
	}

	public void clickOKButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(okBtn)).click();
	}

	public void enterCurrentDateddMMyyyy(String date) {
		WebElementUtils.enterText(effectiveDateTxt, date);
	}

	public String getDispatchAcceptanceMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(acceptanceMessage)).getText();
	}

	public int errorElementCount() {
		return getFinder().getWebDriver().findElements(By.cssSelector(".ResponseTxt")).size();
	}
	
	public void acceptDispatch(Acceptance details) {
		logger.info("Order Acceptance: {}", details.getBranchId());

		selectBranchId(details.getBranchId());
		selectOrderNumber(details.getOrderNumber());
		clickSearchButton();
		clickTableFirstRecord();
		clickModifyButton();
		enterQuantityRecieved(details.getQuantityOrdered());
		enterCurrentDateddMMyyyy(DateUtils.currentDateddMMyyyy());
		enterMemo(details.getMemo());
		clickSubmitButton();
	}
}
