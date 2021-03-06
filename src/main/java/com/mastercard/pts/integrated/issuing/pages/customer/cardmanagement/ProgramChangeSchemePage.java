package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_PROGRAM_CHANGE_SCHEME})
public class ProgramChangeSchemePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(ProgramChangeSchemePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=schemeCode]")
	private MCWebElement schemeCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=schemeDesc]")
	private MCWebElement schemeDesc;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement newProgram;
	
	public void verifyUiOperationStatus() {
		logger.info("Add Program Change Scheme");
		verifyUiOperation("Add Program Change Scheme");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(schemeCode),
				WebElementUtils.elementToBeClickable(schemeDesc),
				WebElementUtils.elementToBeClickable(newProgram)
				
				);
	}
}
