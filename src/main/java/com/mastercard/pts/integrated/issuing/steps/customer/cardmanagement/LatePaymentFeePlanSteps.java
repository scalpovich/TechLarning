package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.credit.CreditLatePaymentFeePlanWorkFlow;

@Component
public class LatePaymentFeePlanSteps {
	@Autowired
	CreditLatePaymentFeePlanWorkFlow creditLatePaymentFeePlanWorkFlow;
	@When("user navigates to Late Payment Fee Plan and adds a new Late Payment Fee Plan")
	public void whenUserCreatesALatePaymentFeePlan()
	{
		creditLatePaymentFeePlanWorkFlow.userCreatesAValidLatePaymentFeePlan();
	}
	
}
