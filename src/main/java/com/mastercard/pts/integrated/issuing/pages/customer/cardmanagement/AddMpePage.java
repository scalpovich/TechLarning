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
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_MASTERCARD,
		CardManagementNav.L3_ADD_MPE})
public class AddMpePage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(AddMpePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=binHigh]")
	private MCWebElement binHigh;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=binLow]")
	private MCWebElement binLow;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ica]")
	private MCWebElement ica;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=productIdentifier]")
	private MCWebElement productIdentifier;

	public void verifyUiOperationStatus() {
		logger.info("Add Mpe");
		verifyUiOperation("Add Add Mpe");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(binHigh),
				WebElementUtils.elementToBeClickable(binLow),
				WebElementUtils.elementToBeClickable(ica),
				WebElementUtils.elementToBeClickable(productIdentifier));
	}
}