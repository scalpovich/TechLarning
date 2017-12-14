package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.credit.CreditPlanWorkFlow;
@Component
public class CreditPlanSteps {
@Autowired
CreditPlanWorkFlow creditPlanWorkFlow;
@When("user navigates to Credit Plan Page and add a creditPlan")
public void whenUserCreatesACreditPlan()
{
	creditPlanWorkFlow.userCreatesAValidCreditPlan();
}
@When("user verifies edit and verify creditPlan")
public void whenUserVerifiesAndEditCreditPlan()
{
	creditPlanWorkFlow.verifyViewandEditOperations();
}
}
