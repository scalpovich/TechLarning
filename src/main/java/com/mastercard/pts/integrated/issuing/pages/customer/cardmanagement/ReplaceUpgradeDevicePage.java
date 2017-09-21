package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_DEVICE,
		CardManagementNav.L3_REPLACE_UPGRADE_DEVICE })
public class ReplaceUpgradeDevicePage extends AbstractBasePage {

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardBatch.displayStatusFlag:input:dropdowncomponent")
	private MCWebElement createOpenBatch;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cardBatch.openedBatches:input:dropdowncomponent")
	private MCWebElement openedBatches;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn='cardBatch.memo']")
	private MCWebElement comment;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(createOpenBatch),
				WebElementUtils.elementToBeClickable(openedBatches),
				WebElementUtils.elementToBeClickable(comment));
	}
}
