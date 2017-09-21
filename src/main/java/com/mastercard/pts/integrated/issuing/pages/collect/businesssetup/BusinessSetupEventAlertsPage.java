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
@Navigation(tabTitle = BusinessSetupNav.TAB_BUSINESS_SETUP, treeMenuItems = { BusinessSetupNav.L1_DUNNING_MAIL,
		BusinessSetupNav.L2_EVENT_ALERTS})
public class BusinessSetupEventAlertsPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(BusinessSetupEventAlertsPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=code]")
	private MCWebElement codeTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Event Alert");
		verifyUiOperation("Add Event Alert");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(codeTxt)
				);
	}
}