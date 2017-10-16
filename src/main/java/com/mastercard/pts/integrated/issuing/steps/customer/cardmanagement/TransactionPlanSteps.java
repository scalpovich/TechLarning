package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionFlows;

@Component
public class TransactionPlanSteps {

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	TransactionPlan transactionplan;

	@Autowired
	TransactionFlows transactionplanflows;

	@When("user creates Transaction Plan for $product and transaction type $transactionType")
	public void whenUserCreatesTransactionPlanForPrepaid(@Named("product") String product,
			@Named("transactiontype") String transactionType) {
		devicecreation.setProduct(product);
		transactionplan.setTransactionType(transactionType);
		transactionplanflows.addTransactionPlan(devicecreation, transactionplan);

	}
}