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
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_RUPAY,
		CardManagementNav.L3_RUPAY_BIN_RANGE })
public class RuPayBINRangePage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(RuPayBINRangePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=participantId]")
	private MCWebElement participantId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=binLowValue]")
	private MCWebElement binLowValue;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=binHighValue]")
	private MCWebElement binHighValue;
	
	public void verifyUiOperationStatus() {
		logger.info("RuPay BIN Range");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(participantId),
				WebElementUtils.elementToBeClickable(binLowValue),
				WebElementUtils.elementToBeClickable(binHighValue)
				);
	}
}