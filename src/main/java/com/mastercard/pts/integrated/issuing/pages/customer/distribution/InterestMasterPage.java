package com.mastercard.pts.integrated.issuing.pages.customer.distribution;

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
@Navigation(tabTitle = DistributionNav.TAB_DISTRIBUTION, treeMenuItems = {
		DistributionNav.L1_SETUP, DistributionNav.L2_INTEREST_MASTER})

public class InterestMasterPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory
			.getLogger(InterestMasterPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=interestPlanCode]")
	private MCWebElement interestPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Interest Master");
		verifySearchButton("Search");
	}
	
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(interestPlanCodeTxt),
				WebElementUtils.visibilityOf(descriptionTxt)
				);
	}

	
}
