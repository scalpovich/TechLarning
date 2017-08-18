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
		CardManagementNav.L3_SAFE_UPDATE })
public class SafeUpdatePage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(SafeUpdatePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement recordType;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement microfilmRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=sequenceNumber]")
	private MCWebElement sequenceNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement fraudType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement subFraudType;

	public void verifyUiOperationStatus() {
		logger.info("Safe Update");
		verifyUiOperation("Add Update");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(recordType),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(sequenceNumber),
				WebElementUtils.elementToBeClickable(fraudType),
				WebElementUtils.elementToBeClickable(subFraudType));
	}
}