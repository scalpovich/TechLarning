package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_TRANSACTION_MANAGEMENT,
		CardManagementNav.L3_TRANSACTION,
		CardManagementNav.L4_PAYMENTS,
		CardManagementNav.L5_OUTSTATION_CHEQUE_COLLECTION
		})

public class OutstationChequeCollectionPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(OutstationChequeCollectionPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=referenceNum]")
	private MCWebElement referenceNum;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=chequeNumber]")
	private MCWebElement chequeNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=chequeDate]")
	private MCWebElement chequeDate;

	
	public void verifyUiOperationStatus() {
		logger.info("Outstation Cheque Collection");
		verifyUiOperation("Add Outstation Cheque Collection");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(referenceNum),
				WebElementUtils.elementToBeClickable(cardNumber),
				WebElementUtils.elementToBeClickable(chequeNumber),
				WebElementUtils.elementToBeClickable(chequeDate)
				);
	}
}