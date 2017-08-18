package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

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
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_ACTIVATE_DEACTIVATE_WALLET})
public class ActivateDeactivateWalletPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory.getLogger(ActivateDeactivateWalletPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.ID, valueToFind = "remarks")
	private MCWebElement remarksTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Wallet Status')]/following-sibling::td[1]")
	private MCWebElement walletStatusLbl;

	public void verifyUiOperationStatus() {
		logger.info("Activate/ Deactivate Wallet");
		verifyTitleCardHolderPortal("Activate/ Deactivate Wallet");
		verifyWalletDetails();
		verifyDeviceDetails();
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(remarksTxt),
				WebElementUtils.visibilityOf(walletStatusLbl));
	}
}
