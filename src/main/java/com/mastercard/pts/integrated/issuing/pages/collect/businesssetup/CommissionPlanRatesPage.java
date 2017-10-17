package com.mastercard.pts.integrated.issuing.pages.collect.businesssetup;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = BusinessSetupNav.TAB_BUSINESS_SETUP, treeMenuItems = { BusinessSetupNav.L1_BILLING_COMMISSION_PLAN,
		BusinessSetupNav.L2_COMMISSION_PLAN_RATES })
public class CommissionPlanRatesPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(CommissionPlanRatesPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planname]")
	private MCWebElement plannameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement commissionPlanCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement classDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement planTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement rateTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement outstandingGroupDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Commission Plan Rates");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(commissionPlanCodeDDwn), WebElementUtils.elementToBeClickable(plannameTxt),
				WebElementUtils.elementToBeClickable(classDDwn), WebElementUtils.elementToBeClickable(planTypeDDwn),
				WebElementUtils.elementToBeClickable(rateTypeDDwn), WebElementUtils.elementToBeClickable(outstandingGroupDDwn));
	}
}