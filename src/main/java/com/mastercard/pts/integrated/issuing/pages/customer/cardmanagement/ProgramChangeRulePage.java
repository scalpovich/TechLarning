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
		CardManagementNav.L2_PROGRAM_CHANGE_RULE})
public class ProgramChangeRulePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(ProgramChangeRulePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planCode]")
	private MCWebElement planCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planDesc]")
	private MCWebElement planDesc;
	
	public void verifyUiOperationStatus() {
		logger.info("Program Change Rule");
		verifyUiOperation("Add Program Change Rule");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(planCode),
				WebElementUtils.elementToBeClickable(planDesc)
				
				);
	}
}
