package com.mastercard.pts.integrated.issuing.pages.customer.administration;

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
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP,
		AdministrationNav.L2_ENABLE_MAKER_CHECKER
		})
public class EnableMakerCheckerPage extends AbstractModelPage{

	private static final Logger logger = LoggerFactory
			.getLogger(EnableMakerCheckerPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "a[href='#tab1']")
	private MCWebElement processingCenterTab;

	public void verifyUiOperationStatus() {
		logger.info("Enable Maker Checker");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(processingCenterTab));
	}
}
