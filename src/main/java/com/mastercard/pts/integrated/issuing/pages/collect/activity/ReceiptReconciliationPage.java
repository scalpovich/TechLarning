package com.mastercard.pts.integrated.issuing.pages.collect.activity;

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
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_RECEIPT_BOOK_MAINTENANCE, ActivityNav.L2_RECEIPT_RECONCILIATION })
public class ReceiptReconciliationPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(ReceiptReconciliationPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement agencyDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=bookno]")
	private MCWebElement booknoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement statusDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Receipt Reconciliation");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(agencyDDwn), WebElementUtils.elementToBeClickable(booknoTxt),
				WebElementUtils.elementToBeClickable(statusDDwn));
	}
}