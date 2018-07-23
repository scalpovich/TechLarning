package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.transactions.CardToCash;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_CARD_TO_CASH, TransactionsNav.L2_CANCEL_CARD_TO_CASH })
public class CancelCardToCashPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(CancelCardToCashPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#RRN")
	private MCWebElement rrnTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceNumber")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#txnPassword")
	private MCWebElement txnPasswordTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#remarks")
	private MCWebElement remarksTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement cancellationSuccessMessage;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='dataview']//td[2]")
	private MCWebElement tableFirstRecord;

	public void verifyUiOperationStatus() {
		logger.info("Cancel Remittance Booking");
		verifyButton("Submit");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(deviceNumberTxt),
				WebElementUtils.visibilityOf(rrnTxt));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Cancel Card to Cash Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
	
	public void clickTableFirstRecord() {
		SimulatorUtilities.wait(3000);//this to wait till the table gets loaded
		WebElementUtils.retryUntil(tableFirstRecord::click,
				() -> WebElementUtils.hasClass(getFinder().findOne(FindBy.X_PATH, "//*[@class='dataview']/tbody/tr[1]"), "select"));
	}
	
	@Override
	public void clickSubmitButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(submitBtn)).click();
	}
	
	public String getRemittanceCancellationSuccessMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(cancellationSuccessMessage))
				.getText();
	}
	
	public void performRemittanceCancelCardToCash(Device device, CardToCash details) {
		WebElementUtils.enterText(rrnTxt, details.getRemittanceNumber());
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
		clickSubmitButton();
		clickTableFirstRecord();
		clickSubmitButton();
		WebElementUtils.enterText(txnPasswordTxt, details.getTxnPassword());
		WebElementUtils.enterText(remarksTxt, Constants.GENERIC_DESCRIPTION);
		clickSubmitButton();
	}
}
