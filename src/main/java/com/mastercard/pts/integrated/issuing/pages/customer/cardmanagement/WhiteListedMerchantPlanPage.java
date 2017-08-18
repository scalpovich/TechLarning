package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_WALLET_CONFIGURATION,
		CardManagementNav.L3_WHITE_LISTED_MERCHANT_PLAN
		})

public class WhiteListedMerchantPlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(WhiteListedMerchantPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=whiteListedMidPlanCode]")
	private MCWebElement whiteListedMidPlanCode;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	public void verifyUiOperationStatus() {
		logger.info("White Listed Merchant Plan");
		verifyUiOperation("Add White Listed Merchant Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(whiteListedMidPlanCode),
				WebElementUtils.elementToBeClickable(description)
				);
	}
}
