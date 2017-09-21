package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_WALLET,
		CardManagementNav.L3_UPDATE_WALLET_DETAILS })
public class UpdateWalletDetailsPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(UpdateWalletDetailsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=walletNumber]")
	private MCWebElement walletNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceNumber]")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement clientCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=registeredMobileNumber]")
	private MCWebElement registeredMobileNumberTxt;

	public void verifyUiOperationStatus() {
		logger.info("Update Wallet Details");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(walletNumberTxt), WebElementUtils.elementToBeClickable(deviceNumberTxt),
				WebElementUtils.elementToBeClickable(clientCodeTxt), WebElementUtils.elementToBeClickable(registeredMobileNumberTxt));
	}
}
