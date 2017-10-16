package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountType;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AccountTypeFlows;

@Component
public class AccountTypeSteps {

	@Autowired
	AccountTypeFlows accounttypeflows;

	@Autowired
	AccountType accounttype;

	@When("user creates $account account type")
	public void whenUserCreatesSavingsAccountType(@Named("account") String account) {
		accounttype.setAccounttype(account);
		accounttypeflows.addAccountTypeSavings(accounttype);
	}
}