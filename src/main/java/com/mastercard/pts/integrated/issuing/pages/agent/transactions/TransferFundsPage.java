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

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_OTHERS, TransactionsNav.L2_OTHERS_TRANSFER_FUNDS })
public class TransferFundsPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(TransferFundsPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=VisaMoneyTransferHome]")
	private MCWebElement visaMoneyTransferHomeRBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=WalletToWalletTransferHome]")
	private MCWebElement walletToWalletTransferHomeRBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=InterBankFundTransferHome]")
	private MCWebElement interBankFundTransferHomeRBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=MasterCardMoneySendHome]")
	private MCWebElement masterCardMoneySendHomeRBtn;

	public void verifyUiOperationStatus() {
		logger.info("Transfer Funds");
		verifyButton("Continue");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(visaMoneyTransferHomeRBtn),
				WebElementUtils.visibilityOf(walletToWalletTransferHomeRBtn), WebElementUtils.visibilityOf(interBankFundTransferHomeRBtn),
				WebElementUtils.visibilityOf(masterCardMoneySendHomeRBtn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Transfer Funds Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
