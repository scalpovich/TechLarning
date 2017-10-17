package com.mastercard.pts.integrated.issuing.pages.collect;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.collect.administration.AdministrationHomePage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class AbstractCollectPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(AdministrationHomePage.class);

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//h1")
	protected MCWebElement heading;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//p")
	protected MCWebElement body;

	public void verifyUiOperationStatus() {
		verifyUiOperationsStatus("Admin");
	}
	
	public void verifyUiOperationStatus(String screenName) {
		verifyUiOperationsStatus(screenName);
	}
	
	private void verifyUiOperationsStatus(String screenName)
	{
		logger.info(screenName + " Home");
		verifyHomePageCollectPortal(screenName);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(heading), WebElementUtils.visibilityOf(body));
	}
}