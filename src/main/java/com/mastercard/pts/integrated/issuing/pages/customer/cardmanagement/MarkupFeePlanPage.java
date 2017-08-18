package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT,
treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_MARKUP_FEE_PLAN })

public class MarkupFeePlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(MarkupFeePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=markupFeeCode]")
	private MCWebElement markupFeeCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=markupDescription]")
	private MCWebElement markupDescription;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement status;
	
	public void verifyUiOperationStatus() {
		logger.info("Markup Fee Plan");
		verifyUiOperation("Add Markup Fee Plan");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(markupFeeCode),
				WebElementUtils.elementToBeClickable(markupDescription),
				WebElementUtils.elementToBeClickable(status)
				);
	}
}
