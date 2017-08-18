package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

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
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = {
		LoyaltyNav.L1_LOYALTY_SETUP,
		LoyaltyNav.L2_LOYALTY_PLAN
		})
public class LoyaltyPlanPage extends AbstractModelPage{

			private static final Logger logger = LoggerFactory
					.getLogger(LoyaltyPlanPage.class);

			@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
			private MCWebElement loyaltyPlanCodeTxt;

			public void verifyUiOperationStatus() {
				logger.info("Loyalty Plan");
				verifyUiOperation("Add Loyalty Plan");
			}

			@Override
			protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
				return Arrays.asList(WebElementUtils.elementToBeClickable(loyaltyPlanCodeTxt));
			}
}
