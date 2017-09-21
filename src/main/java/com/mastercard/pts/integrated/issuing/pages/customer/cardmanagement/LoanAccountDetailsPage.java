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
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_SEARCH_LOAN,
		CardManagementNav.L3_LOAN_ACCOUNT_DETAILS})
public class LoanAccountDetailsPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(LoanAccountDetailsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=crAccountNbr]")
	private MCWebElement crAccountNbr;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=loanAccountNumber]")
	private MCWebElement loanAccountNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement status;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromDate]")
	private MCWebElement fromDate;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toDate]")
	private MCWebElement toDate;	
	
	public void verifyUiOperationStatus() {
		logger.info("Loan Account Details");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(cardNumber),
				WebElementUtils.elementToBeClickable(crAccountNbr),
				WebElementUtils.elementToBeClickable(loanAccountNumber),
				WebElementUtils.elementToBeClickable(status),
				WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate)
				);
	}
}