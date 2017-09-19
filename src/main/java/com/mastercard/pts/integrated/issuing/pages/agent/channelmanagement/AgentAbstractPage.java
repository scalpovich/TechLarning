package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

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

public class AgentAbstractPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(AgentAbstractPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	protected MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.NAME, valueToFind = "agentId")
	protected MCWebElement agentIdTxt;

	public void verifyUiOperationStatus() {
		logger.info("Agent Information");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(agentIdTxt));
	}

	public String getMasterDetailContentTitleText() {
		logger.info("Agent Entity Active Suspend Agent Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

}
