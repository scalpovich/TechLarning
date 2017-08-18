package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

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
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_SETUP, DisputeNav.L2_DISPUTE_REASON_CODE,
		DisputeNav.L3_ARBITRATION_TYPE}
)
public class ArbitrationTypePage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory.getLogger(ArbitrationTypePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	protected MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	protected MCWebElement arbitrationTypeDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Arbitration Type");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchangeDDwn),
				WebElementUtils.elementToBeClickable(arbitrationTypeDDwn));
	}
}
