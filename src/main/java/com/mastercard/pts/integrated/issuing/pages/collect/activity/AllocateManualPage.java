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
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_ALLOCATE_MANUAL})
public class AllocateManualPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(AllocateManualPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "agencyCode:input:dropdowncomponent")
	private MCWebElement agencyCodeDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=accountNo]")
	private MCWebElement accountNoTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "potentialRisk:input:dropdowncomponent")
	private MCWebElement potentialRiskDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "regioncode:input:dropdowncomponent")
	private MCWebElement stateProvinceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "citycode:input:dropdowncomponent")
	private MCWebElement areaCityDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=nsfCounter]")
	private MCWebElement nsfCounterTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=pinFrom]")
	private MCWebElement pinFromTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=pinTo]")
	private MCWebElement pinToTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "collectionClass:input:dropdowncomponent")
	private MCWebElement classDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=dpd]")
	private MCWebElement dpdTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=outstandingFrom]")
	private MCWebElement outstandingFrom;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=outstandingTo]")
	private MCWebElement outstandingTo;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=includeAllocated]")
	private MCWebElement includeAllocatedChkBox;

	public void verifyUiOperationStatus() {
		logger.info("Allocate Manual");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(agencyCodeDDwn), 
				WebElementUtils.elementToBeClickable(cardNumberTxt), 
				WebElementUtils.elementToBeClickable(accountNoTxt),
				WebElementUtils.elementToBeClickable(potentialRiskDDwn),
				WebElementUtils.elementToBeClickable(countryDDwn), 
				WebElementUtils.elementToBeClickable(stateProvinceDDwn), 
				WebElementUtils.elementToBeClickable(areaCityDDwn), 
				WebElementUtils.elementToBeClickable(stateProvinceDDwn),
				WebElementUtils.elementToBeClickable(nsfCounterTxt), 
				WebElementUtils.elementToBeClickable(pinFromTxt),
				WebElementUtils.visibilityOf(pinToTxt), 
				WebElementUtils.elementToBeClickable(classDDwn),
				WebElementUtils.elementToBeClickable(dpdTxt), 
				WebElementUtils.elementToBeClickable(outstandingFrom),
				WebElementUtils.visibilityOf(outstandingTo), 
				WebElementUtils.elementToBeClickable(includeAllocatedChkBox)
				);
	}
}