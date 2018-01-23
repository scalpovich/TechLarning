package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CreditLimitWorkFlow;

@Component
public class CreditLimitSteps {
@Autowired
CreditLimitWorkFlow creditLimitWorkFlow;
@When("user adds a creditLimit")
public void creditLimitPlanAdd()
{
	creditLimitWorkFlow.addCreditLimit();
}
}
