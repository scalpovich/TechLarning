package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionRegistrationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class TransactionRegistrationFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addTransactionRegistrationDetails() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		TransactionRegistrationPage transactionRegistrationPage = navigator
				.navigateToPage(TransactionRegistrationPage.class);
		transactionRegistrationPage.addtransactionregistration();
	}
}
