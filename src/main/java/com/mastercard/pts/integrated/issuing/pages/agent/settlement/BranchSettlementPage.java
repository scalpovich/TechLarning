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

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = SettlementNav.TAB_SETTLEMENT, treeMenuItems = { SettlementNav.L1_REPORTS, SettlementNav.L2_BRANCH_SETTLEMENT })
public class BranchSettlementPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(BranchSettlementPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#brancId")
	private MCWebElement brancIdDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#reportValue")
	private MCWebElement reportValueDwn;

	public void verifyUiOperationStatus() {
		logger.info("Limited Validity Virtual Card Cancellation");
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(brancIdDDwn),
				WebElementUtils.visibilityOf(reportValueDwn));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Branch Settlement Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
}

