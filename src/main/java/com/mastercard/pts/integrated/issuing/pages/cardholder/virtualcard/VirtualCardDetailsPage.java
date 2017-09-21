package com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = VirtualCardNav.TAB_VIRTUAL_CARD, treeMenuItems = { VirtualCardNav.L1_VIEW_VIRTUAL_CARD_DETAILS })
public class VirtualCardDetailsPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(VirtualCardDetailsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	public void verifyUiOperationStatus() {
		logger.info("Virtual Card Details");
		verifyTitleCardHolderPortal("Virtual Card Details");
		verifyButton("OK");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle));
	}
}
