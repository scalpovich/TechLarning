package com.mastercard.pts.integrated.issuing.pages.collect.businesssetup;

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
@Navigation(tabTitle = BusinessSetupNav.TAB_BUSINESS_SETUP, treeMenuItems = { BusinessSetupNav.L1_RULES,
		BusinessSetupNav.L2_RULES_ALLOCATION})
public class RulesAllocationPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(RulesAllocationPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=rlid]")
	private MCWebElement rlidTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=dscr]")
	private MCWebElement dscrTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement statusDDwn;

	
	public void verifyUiOperationStatus() {
		logger.info("Allocation");
		verifyUiOperation("Add Rule Master");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(rlidTxt),
				WebElementUtils.elementToBeClickable(dscrTxt),
				WebElementUtils.elementToBeClickable(statusDDwn)
				);
	}
}