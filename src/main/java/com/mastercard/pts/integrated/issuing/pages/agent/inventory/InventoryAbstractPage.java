package com.mastercard.pts.integrated.issuing.pages.agent.inventory;

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

public class InventoryAbstractPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(InventoryAbstractPage.class);

	@Value("${default.wait.timeout_in_sec}")
	protected long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	protected MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#brancId")
	protected MCWebElement brancIdDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#programCode")
	protected MCWebElement programCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#deviceType")
	protected MCWebElement deviceTypeDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Page");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(brancIdDDwn),
				WebElementUtils.visibilityOf(programCodeDDwn), WebElementUtils.visibilityOf(deviceTypeDDwn));
	}

	public String getMasterDetailContentTitleText() {
		logger.info("Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

}
