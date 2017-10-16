package com.mastercard.pts.integrated.issuing.pages.collect.report;

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
@Navigation(tabTitle = ReportNav.TAB_REPORT, treeMenuItems = { ReportNav.L1_STAT_CARD })
public class StatCardPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(StatCardPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=acctNo]")
	private MCWebElement acctNoTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement riskClassDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement agencyCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement countryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement cityDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromdpd]")
	private MCWebElement fromdpdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=noOfTralls]")
	private MCWebElement noOfTrallsTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=todpd]")
	private MCWebElement todpdTxt;

	public void verifyUiOperationStatus() {
		logger.info("Stat Card");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(acctNoTxt), WebElementUtils.elementToBeClickable(riskClassDDwn),
				WebElementUtils.elementToBeClickable(agencyCodeDDwn), WebElementUtils.elementToBeClickable(countryDDwn),
				WebElementUtils.elementToBeClickable(cityDDwn), WebElementUtils.elementToBeClickable(fromdpdTxt),
				WebElementUtils.elementToBeClickable(noOfTrallsTxt), WebElementUtils.elementToBeClickable(todpdTxt));
	}
}