package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_ACTIVITY_APPLICATION,
		CardManagementNav.L3_INCOMPLETE_APPLICATION })
public class IncompleteApplicationPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(IncompleteApplicationPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=applicationNumber]")
	private MCWebElement applicationNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=formNumber]")
	private MCWebElement formNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=firstName]")
	private MCWebElement firstName;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lastName]")
	private MCWebElement lastName;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromDate]")
	private MCWebElement fromDate;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toDate]")
	private MCWebElement toDate;

	public void verifyUiOperationStatus() {
		logger.info("Incomplete Application");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(applicationNumber),
				WebElementUtils.elementToBeClickable(formNumber),
				WebElementUtils.elementToBeClickable(firstName),
				WebElementUtils.elementToBeClickable(lastName),
				WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate));
	}
}
