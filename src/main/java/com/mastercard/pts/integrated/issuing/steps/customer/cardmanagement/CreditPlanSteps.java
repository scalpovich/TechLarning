package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
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
@Then("user search the record added based on filter Values")
public void whenUserVerifiesRecordAddedBasedOnFilter()
{
	creditPlanWorkFlow.verifyRecordsInTableBasedOnFilter();
}
@Then("user verifies edit operation")
public void whenUserVerifiesAndEditCreditPlan()
{
	creditPlanWorkFlow.verifyEditOperationForAddedRecord();
}
@Then("user verifies delete operation")
public void whenUserVerifiesAndDeleteCreditPlan()
{
	creditPlanWorkFlow.verifyDeleteOperationForAddedRecord();
}
}
