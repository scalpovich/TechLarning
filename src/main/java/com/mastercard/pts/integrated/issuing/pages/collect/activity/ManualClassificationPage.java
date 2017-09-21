package com.mastercard.pts.integrated.issuing.pages.collect.activity;

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
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_MANUAL_CLASSIFICATION })
public class ManualClassificationPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(ManualClassificationPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "regioncode:input:dropdowncomponent")
	private MCWebElement stateProvinceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "citycode:input:dropdowncomponent")
	private MCWebElement areaCityDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "potentialRisk:input:dropdowncomponent")
	private MCWebElement potentialRiskDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=caseidFrom]")
	private MCWebElement caseidFromTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=caseidTo]")
	private MCWebElement caseidToTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=outstandingFrom]")
	private MCWebElement outstandingFromTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=outstandingTo]")
	private MCWebElement outstandingToTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=dpdFrom]")
	private MCWebElement dpdFromTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=dpdTo]")
	private MCWebElement dpdToTxt;

	public void verifyUiOperationStatus() {
		logger.info("Manual Classification");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(countryDDwn), WebElementUtils.elementToBeClickable(stateProvinceDDwn),
				WebElementUtils.elementToBeClickable(areaCityDDwn), WebElementUtils.elementToBeClickable(potentialRiskDDwn),
				WebElementUtils.elementToBeClickable(caseidFromTxt), WebElementUtils.visibilityOf(caseidToTxt),
				WebElementUtils.elementToBeClickable(outstandingFromTxt), WebElementUtils.visibilityOf(outstandingToTxt),
				WebElementUtils.elementToBeClickable(dpdFromTxt), WebElementUtils.visibilityOf(dpdToTxt));
	}
}