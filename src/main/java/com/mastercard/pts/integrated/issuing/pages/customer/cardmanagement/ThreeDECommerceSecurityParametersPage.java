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
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_THREE_D_E_COMMERCE_SECURITY_PARAMETERES })
public class ThreeDECommerceSecurityParametersPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(ThreeDECommerceSecurityParametersPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=minCardRange]")
	private MCWebElement minCardRange;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=maxCardRange]")
	private MCWebElement maxCardRange;

	public void verifyUiOperationStatus() {
		logger.info("3D E-Commerce Security Parameters");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(interchange),
				WebElementUtils.elementToBeClickable(minCardRange),
				WebElementUtils.elementToBeClickable(maxCardRange));
	}
}
