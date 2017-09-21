package com.mastercard.pts.integrated.issuing.pages.agent.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_DEVICE_SALE_ISSUANCE, ServicesNav.L2_APPLICATION_CORRECTION })
public class ApplicationCorrectionPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationCorrectionPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#applicationNumber")
	private MCWebElement applicationNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#cardPackID")
	private MCWebElement cardPackIDTxt;

	public void verifyUiOperationStatus() {
		logger.info("Application Correction Details");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(applicationNumberTxt),
				WebElementUtils.visibilityOf(cardPackIDTxt));
	}

	public String getMasterDetailContentTitleText() {
		logger.info("Activate Deactivate Sub Account Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
