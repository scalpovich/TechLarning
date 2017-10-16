package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionRegistrationFlows;

@Component
public class TransactionRegistrationSteps {

	@Autowired
	TransactionRegistrationFlows transactionregistrationflows;

	@When("user creates a Transaction Registration")
	public void whenUserCreatesATransactionRegistration() {
		transactionregistrationflows.addTransactionRegistrationDetails();
	}
}