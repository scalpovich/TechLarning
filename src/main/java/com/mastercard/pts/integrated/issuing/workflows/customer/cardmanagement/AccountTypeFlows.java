package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountType;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AccountTypePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class AccountTypeFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addAccountTypeSavings(AccountType accounttype) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		AccountTypePage accountTypepage = navigator.navigateToPage(AccountTypePage.class);
		accountTypepage.clickaddAccountType();
		accountTypepage.addAccountType(accounttype);
		accountTypepage.verifyNewAccountTypeSuccess();
	}

}
