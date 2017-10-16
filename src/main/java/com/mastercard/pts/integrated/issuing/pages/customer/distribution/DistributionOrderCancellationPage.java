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
		DistributionNav.L1_ACTIVITY, DistributionNav.L2_INVENTORY,
		DistributionNav.L3_ORDER_CANCELLATION}
)

public class DistributionOrderCancellationPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory
			.getLogger(DistributionOrderCancellationPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement agencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement branchDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=orderNo]")
	private MCWebElement orderNoTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Order Cancellation");
		verifySearchButton("Search");
	}
	
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(agencyDDwn),
				WebElementUtils.visibilityOf(branchDDwn),
				WebElementUtils.visibilityOf(orderNoTxt)
				);
	}

	
}
