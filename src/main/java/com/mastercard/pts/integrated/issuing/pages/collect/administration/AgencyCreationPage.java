package com.mastercard.pts.integrated.issuing.pages.collect.administration;

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
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTARTION, treeMenuItems = { AdministrationNav.L1_SETUP, AdministrationNav.L2_AGENCY_CREATION})
public class AgencyCreationPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(AgencyCreationPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=agencycode]")
	private MCWebElement agencycodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=agencyname]")
	private MCWebElement agencynameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement agencyTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement countryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement areaCityDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement stateDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Agency Creation");
		verifySearchButton("Search");
		verifyUiOperation("Add Agency");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(agencycodeTxt), WebElementUtils.elementToBeClickable(agencynameTxt),
				WebElementUtils.elementToBeClickable(agencyTypeDDwn), WebElementUtils.elementToBeClickable(countryDDwn),
				WebElementUtils.elementToBeClickable(areaCityDDwn), WebElementUtils.elementToBeClickable(stateDDwn));
	}
}