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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_VISA,
		CardManagementNav.L3_INITIATE_VISA_MONEY_TRANSFER })
public class InitiateVisaMoneyTransferPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(InitiateVisaMoneyTransferPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=originatorCardNumber]")
	private MCWebElement originatorCardNumber;

	public void verifyUiOperationStatus() {
		logger.info("Initiate Visa Money Transfer");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.elementToBeClickable(originatorCardNumber));
	}
}