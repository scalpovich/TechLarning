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
		CardManagementNav.L2_HSM_KEY,
		CardManagementNav.L3_NETWORK_KEYS
		})
public class NetworkKeysPage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory.getLogger(NetworkKeysPage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement networkInterface;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=netcrSecNet]")
	private MCWebElement netcrSecNet;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=netcrKeyIndex]")
	private MCWebElement netcrKeyIndex;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement keyType;
	
	public void verifyUiOperationStatus() {
		logger.info("Network Key");
		verifyUiOperation("Add Network Key");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(networkInterface),
				WebElementUtils.elementToBeClickable(netcrSecNet),
				WebElementUtils.elementToBeClickable(netcrKeyIndex),
				WebElementUtils.elementToBeClickable(keyType)
				);
	}
}
