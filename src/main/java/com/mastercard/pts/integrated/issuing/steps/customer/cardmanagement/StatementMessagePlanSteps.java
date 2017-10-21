package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.StatementMessageFlows;

@Component
public class StatementMessagePlanSteps {

	@Autowired
	StatementMessageFlows stmntmsgflows;

	@Autowired
	DeviceCreation devicecreation;

	public StatementMessagePlan statementmessageplan;

	@When("user creates a Statement Message Plan for $product")
	public void whenUserCreatesAStatementMessagePlanForPrepaid(@Named("product") String product) {
		devicecreation.setProduct(product);
		statementmessageplan = StatementMessagePlan.StatementMessagePlanProvider();
		String statementMessageePlan = stmntmsgflows.createStatementMessagePlan(statementmessageplan, devicecreation);
		statementmessageplan.setStatementMessagePlanCode(statementMessageePlan);
	}
}