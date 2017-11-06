package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ReversalTransaction;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.AbstractDisputePage;
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
		CardManagementNav.L4_REVERSAL_TRANSACTION
		})

public class ReversalTransactionPage extends AbstractDisputePage {
	
	private static final Logger logger = LoggerFactory.getLogger(ReversalTransactionPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement microfilmRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromDate]")
	private MCWebElement fromDate;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toDate]")
	private MCWebElement toDate;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=authorizationNumber]")
	private MCWebElement authorizationNumber;

	public void verifyUiOperationStatus() {
	logger.info("Reversal Transaction");
	verifySearchButton("Search");
}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(cardNumber),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate),
				WebElementUtils.elementToBeClickable(authorizationNumber)
				);
	}
	
	public BigDecimal getTransactionReversalAmount(ReversalTransaction rt){
		logger.info("Get Reversal Transaction Amount: {}", rt.getArn());
		WebElementUtils.enterText(microfilmRefNumber, rt.getArn());
		clickSearchButton();
		return new BigDecimal(getFirstRecordCellTextByColumnName("Transaction Amount"));
	}
}