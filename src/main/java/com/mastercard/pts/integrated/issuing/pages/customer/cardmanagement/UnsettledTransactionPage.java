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
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_TRANSACTION,
		CardManagementNav.L3_UNSETTLED_TRANSACTION})

public class UnsettledTransactionPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(UnsettledTransactionPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement microfilmRefNumberTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumberTxt	;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement branchDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=sequenceNumber]")
	private MCWebElement sequenceNumberTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Unsettled Transaction");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(microfilmRefNumberTxt),
				WebElementUtils.elementToBeClickable(cardNumberTxt),
				WebElementUtils.elementToBeClickable(branchDDwn),
				WebElementUtils.elementToBeClickable(sequenceNumberTxt)
				);
	}
}