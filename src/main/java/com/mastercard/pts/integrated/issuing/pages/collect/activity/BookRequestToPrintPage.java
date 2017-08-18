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
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_RECEIPT_BOOK_MAINTENANCE, ActivityNav.L2_BOOK_REQUEST_TO_PRINT })
public class BookRequestToPrintPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(BookRequestToPrintPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=reqCode]")
	private MCWebElement reqCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement countryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement stateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement cityDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromDate]")
	private MCWebElement fromDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toDate]")
	private MCWebElement toDateDPkr;

	public void verifyUiOperationStatus() {
		logger.info("Book Request to Print");
		verifySearchButton("Search");
		verifyUiOperation("Add Books");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(reqCodeTxt), WebElementUtils.elementToBeClickable(countryDDwn),
				WebElementUtils.elementToBeClickable(stateDDwn), WebElementUtils.elementToBeClickable(cityDDwn),
				WebElementUtils.elementToBeClickable(fromDateDPkr), WebElementUtils.elementToBeClickable(toDateDPkr));
	}
}