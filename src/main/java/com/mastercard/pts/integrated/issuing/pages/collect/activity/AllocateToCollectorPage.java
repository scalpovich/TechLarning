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
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_ALLOCATE_TO_COLLECTOR })
public class AllocateToCollectorPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(AllocateToCollectorPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "agencyId:input:dropdowncomponent")
	private MCWebElement agencyCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "potentialRisk:input:dropdowncomponent")
	private MCWebElement potentialRiskDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "classCode:input:dropdowncomponent")
	private MCWebElement classDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "collector:input:dropdowncomponent")
	private MCWebElement collectorIdDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=zipCodeFrom]")
	private MCWebElement zipCodeFromTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=zipCodeTo]")
	private MCWebElement zipCodeToTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=outstandingFrom]")
	private MCWebElement outstandingFromTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=outstandingTo]")
	private MCWebElement outstandingToTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=dpd]")
	private MCWebElement dpdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=emailID]")
	private MCWebElement emailIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=includeAllocated]")
	private MCWebElement includeAllocatedChkBox;

	public void verifyUiOperationStatus() {
		logger.info("Allocate To Collector");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(agencyCodeDDwn), WebElementUtils.elementToBeClickable(potentialRiskDDwn),
				WebElementUtils.elementToBeClickable(classDDwn), WebElementUtils.elementToBeClickable(countryDDwn),
				WebElementUtils.elementToBeClickable(collectorIdDDwn), WebElementUtils.elementToBeClickable(zipCodeFromTxt),
				WebElementUtils.visibilityOf(zipCodeToTxt), WebElementUtils.elementToBeClickable(outstandingFromTxt),
				WebElementUtils.visibilityOf(outstandingToTxt), WebElementUtils.elementToBeClickable(dpdTxt),
				WebElementUtils.elementToBeClickable(emailIdTxt), WebElementUtils.elementToBeClickable(includeAllocatedChkBox));
	}
}