package com.mastercard.pts.integrated.issuing.pages.agent.settlement;

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
@Navigation(tabTitle = SettlementNav.TAB_SETTLEMENT, treeMenuItems = { SettlementNav.L1_REPORTS, SettlementNav.L2_AGENCY_SETTLEMENT })
public class AgencySettlementPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(AgencySettlementPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#agencIdd")
	private MCWebElement agencIddDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#reportValue")
	private MCWebElement reportValueDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Initiate Settlement Reports");
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(agencIddDDwn),
				WebElementUtils.visibilityOf(reportValueDDwn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Agency Settlement MasterDetai content Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}
