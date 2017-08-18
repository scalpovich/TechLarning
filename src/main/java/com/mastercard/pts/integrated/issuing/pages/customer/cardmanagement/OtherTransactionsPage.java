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
		CardManagementNav.L2_TRANSACTION_MANAGEMENT,
		CardManagementNav.L3_TRANSACTION,
		CardManagementNav.L4_OTHER_TRANSACTIONS
		})

public class OtherTransactionsPage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory.getLogger(OtherTransactionsPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=remittanceNumber]")
	private MCWebElement remittanceNumber;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=remittanceSequence]")
	private MCWebElement remittanceSequence;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement transactionType;
	
	public void verifyUiOperationStatus() {
		logger.info("Other Transaction");
		verifyUiOperation("Add Other Transaction");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(remittanceNumber),
				WebElementUtils.elementToBeClickable(remittanceSequence),
				WebElementUtils.elementToBeClickable(transactionType)
				);
	}
}