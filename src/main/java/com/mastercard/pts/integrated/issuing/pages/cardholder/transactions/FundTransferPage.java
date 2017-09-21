package com.mastercard.pts.integrated.issuing.pages.cardholder.transactions;

import java.util.Arrays;
import java.util.Collection;

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
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_FUND_TRANSFER })
public class FundTransferPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(FundTransferPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=VisaMoneyTransfer]")
	private MCWebElement visaMoneyTransferRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=CardtoCard]")
	private MCWebElement cardtoCardRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=InterBankFundTransferPopulateDetails]")
	private MCWebElement interBankFundTransferPopulateDetailsRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=MasterCardMoneySend]")
	private MCWebElement masterCardMoneySendRbtn;

	public void verifyUiOperationStatus() {
		logger.info("Fund Transfer");
		verifyTitleCardHolderPortal("Fund Transfer");
		verifyButton("Continue");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(visaMoneyTransferRbtn),
				WebElementUtils.visibilityOf(cardtoCardRbtn), WebElementUtils.visibilityOf(interBankFundTransferPopulateDetailsRbtn),
				WebElementUtils.visibilityOf(masterCardMoneySendRbtn));
	}
}
