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
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_SETTLEMENT_HISTORY })
public class SettlementHistoryPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(SettlementHistoryPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=yyyymm]")
	private MCWebElement yyyymmTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=caseidSearchCriteria]")
	private MCWebElement caseidSearchCriteriaTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromDate]")
	private MCWebElement fromDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toDate]")
	private MCWebElement toDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromApprovedDate]")
	private MCWebElement fromApprovedDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toApprovedDate]")
	private MCWebElement toApprovedDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=accountNo]")
	private MCWebElement accountNoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=accHldrname]")
	private MCWebElement accHldrnameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:5:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement settlementStatusDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Settlement History");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(yyyymmTxt), WebElementUtils.elementToBeClickable(caseidSearchCriteriaTxt),
				WebElementUtils.elementToBeClickable(fromDateDPkr), WebElementUtils.elementToBeClickable(toDateDPkr),
				WebElementUtils.elementToBeClickable(fromApprovedDateDPkr), WebElementUtils.elementToBeClickable(toApprovedDateDPkr),
				WebElementUtils.elementToBeClickable(accountNoTxt), WebElementUtils.elementToBeClickable(accHldrnameTxt),
				WebElementUtils.elementToBeClickable(settlementStatusDDwn));
	}
}