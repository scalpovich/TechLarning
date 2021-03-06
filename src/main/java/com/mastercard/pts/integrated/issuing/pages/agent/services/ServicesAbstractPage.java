package com.mastercard.pts.integrated.issuing.pages.agent.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class ServicesAbstractPage  extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(ActivateDeactivateSubAccountPage.class);

	@Value("${default.wait.timeout_in_sec}")
	protected long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	protected MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#cardNumber")
	protected MCWebElement cardNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceNumber")
	protected MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#walletNumber")
	protected MCWebElement walletNumberDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Screen");
		verifyButton("Search");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(deviceNumberTxt));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Activate Deactivate Sub Account Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
