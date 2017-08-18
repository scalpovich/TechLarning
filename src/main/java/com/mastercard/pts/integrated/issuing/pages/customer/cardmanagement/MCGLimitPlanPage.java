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
		CardManagementNav.L3_MCG_LIMIT_PLAN })
public class MCGLimitPlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(MCGLimitPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=mcgLimitPlanCode]")
	private MCWebElement mcgLimitPlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;
	
	public void verifyUiOperationStatus() {
		logger.info("MCG Limit Plan");
		verifyUiOperation("Add MCG Limit Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(mcgLimitPlanCode),
				WebElementUtils.elementToBeClickable(description),
				WebElementUtils.elementToBeClickable(productType)
				);
	}
}
