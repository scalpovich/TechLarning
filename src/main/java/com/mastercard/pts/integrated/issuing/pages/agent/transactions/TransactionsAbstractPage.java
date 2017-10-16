package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class TransactionsAbstractPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(TransactionsAbstractPage.class);
	
	@Value("${default.wait.timeout_in_sec}")
	protected long timeoutInSec;
	
	//main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	protected MCWebElement masterDetailContentTitle;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceNumber")
	protected MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#cardNumber")
	protected MCWebElement cardNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#walletNumber")
	protected MCWebElement walletNumberDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#referenceNumber")
	protected MCWebElement referenceNumberDDwn;
 

	public void verifyUiOperationStatus() {
		logger.info("Screen");
		verifyButton("Search");
	}
 
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(deviceNumberTxt),
				WebElementUtils.visibilityOf(walletNumberDDwn));
	}
	
    //methods
    public String getMasterDetailContentTitleText(){
    	logger.info("Master Detail Tilte Text: {}");
        return new WebDriverWait(driver(), timeoutInSec)
    		.until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
    }
}
