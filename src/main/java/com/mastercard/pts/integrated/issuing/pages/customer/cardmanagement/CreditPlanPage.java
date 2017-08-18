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
		CardManagementNav.L2_CREDIT_CARD_BILLING,
		CardManagementNav.L3_CREDIT_PLAN})
public class CreditPlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(CreditPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileCode]")
	private MCWebElement profileCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWording]")
	private MCWebElement profileWording;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWordAbrv]")
	private MCWebElement profileWordAbrv;
	
	public void verifyUiOperationStatus() {
		logger.info("Credit Plan");
		verifyUiOperation("Add Credit Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(profileCode),
				WebElementUtils.elementToBeClickable(profileWording),
				WebElementUtils.elementToBeClickable(profileWordAbrv)
				
				);
	}
}
