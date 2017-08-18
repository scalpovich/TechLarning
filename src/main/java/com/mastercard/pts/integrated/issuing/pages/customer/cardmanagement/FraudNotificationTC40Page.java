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
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_VISA,
		CardManagementNav.L3_FRAUD_NOTIFICATION_TC40 })
public class FraudNotificationTC40Page extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(FraudNotificationTC40Page.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=branchRefNumber]")
	private MCWebElement branchRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement microfilmRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=authorizationNumber]")
	private MCWebElement authorizationNumber;
	
	public void verifyUiOperationStatus() {
		logger.info("Fraud Notification - TC40");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(cardNumber),
				WebElementUtils.elementToBeClickable(branchRefNumber),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(authorizationNumber)
				);
	}
}