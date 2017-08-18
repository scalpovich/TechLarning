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
@Navigation(tabTitle = BusinessSetupNav.TAB_BUSINESS_SETUP, treeMenuItems = { BusinessSetupNav.L1_BILLING_COMMISSION_PLAN, 
		BusinessSetupNav.L2_COMMISSION_PLAN })
public class CommissionPlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(CommissionPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=plancode]")
	private MCWebElement plancodeTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planname]")
	private MCWebElement plannameTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=effectiveFromDate]")
	private MCWebElement effectiveFromDateDPkr;

	public void verifyUiOperationStatus() {
		logger.info("Commission Plan");
		verifyUiOperation("Add Commission Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(plancodeTxt),
				WebElementUtils.elementToBeClickable(plannameTxt),
				WebElementUtils.elementToBeClickable(effectiveFromDateDPkr)
				);
	}
}