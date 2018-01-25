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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_CARD_TO_CASH, TransactionsNav.L2_CASH_REMITTANCE_PAYOUT })
public class CashRemittancePayoutPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(CashRemittancePayoutPage.class);

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
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#beneficiaryNationalId")
	private MCWebElement beneficiaryNationalIdTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#txnPassword")
	private MCWebElement txnPasswordTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#remarks")
	private MCWebElement remarksTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement payoutSuccessMessage;

	public void verifyUiOperationStatus() {
		logger.info("Cash Remittance Payout");
		verifyButton("Submit");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(rrnTxt));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Cash Remittance Payout Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
	
	public void clickSubmitButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(submitBtn)).click();
	}
	
	public String getRemittancePayoutSuccessMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(payoutSuccessMessage))
				.getText();
	}
	
	public void performRemittancePayout(Device device, CardToCash details) {
		WebElementUtils.enterText(rrnTxt, details.getRemittanceNumber());
		clickSubmitButton();
		WebElementUtils.enterText(beneficiaryNationalIdTxt, details.getBeneficiaryId());
		WebElementUtils.enterText(txnPasswordTxt, details.getTxnPassword());
		WebElementUtils.enterText(remarksTxt, Constants.GENERIC_DESCRIPTION);
		clickSubmitButton();
	}
}
