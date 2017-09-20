package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.TransactionFlows;

@Component
public class TransactionTypesSteps extends AbstractBaseSteps {

	@Autowired
	TransactionFlows transactionflows;

	@When("the admin user fetches the record")
	public void searchTransactionTypes() {
		transactionflows.listTransactiontypes();
	}

	@When("the customer portal user fetches the record")
	public void listTransactionByCustomer() {
		transactionflows.listTransactionCustomer();

	}

	@Then("user should be able to see following transaction set in Transaction Registration Screen at the processor level:$transactionTable")
	public void viewEachTransactionType(ExamplesTable TransactionCode)
			throws InterruptedException {
		transactionflows.viewTransactionDetails(TransactionCode);
	}

	@Then("he should be able to select and enable or disable below transactions at the institution level for the rupay network:$TransactionTable")
	public void checkTransactionChannelEnabled(ExamplesTable Transaction) {
		transactionflows.checkTransactionChannels(Transaction);
	}

	@Then("he should be able to select and see all the transactions supported for rupay network")
	public void selectTransactionCustomer() {
		transactionflows.selectTransaction();
	}
}
