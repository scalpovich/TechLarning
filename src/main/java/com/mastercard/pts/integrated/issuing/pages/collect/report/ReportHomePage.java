package com.mastercard.pts.integrated.issuing.pages.collect.report;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ReportNav.TAB_REPORT)
public class ReportHomePage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(ReportHomePage.class);

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//h1")
	private MCWebElement heading;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//p")
	private MCWebElement body;

	public void verifyUiOperationStatus() {
		logger.info("Report Home");
		verifyHomePageCollectPortal("Report");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(heading), WebElementUtils.visibilityOf(body));
	}
}