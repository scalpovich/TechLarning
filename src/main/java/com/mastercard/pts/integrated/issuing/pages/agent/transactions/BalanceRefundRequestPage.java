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
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS,
	treeMenuItems = { TransactionsNav.L1_BALANCE_REFUND,TransactionsNav.L2_BALANCE_REFUND_REQUEST})
public class BalanceRefundRequestPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(BalanceRefundRequestPage.class);
	
	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;
	
	//main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceNumber")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#walletNumber")
	private MCWebElement walletNumberDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Balance Enquiry");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(deviceNumberTxt),
				WebElementUtils.visibilityOf(walletNumberDDwn));
	}
	
    //methods
    public String getMasterDetailContentTitleText(){
    	logger.info("Balance Refund Request Master Detail Tilte Text: {}");
        return new WebDriverWait(driver(), timeoutInSec)
    		.until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
    }
 }
