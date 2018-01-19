package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CreditLatePaymentFeePlanWorkFlow;

/**
 * @author e076177
 *
 */
@Component
public class LatePaymentFeePlanSteps {
	@Autowired
	CreditLatePaymentFeePlanWorkFlow creditLatePaymentFeePlanWorkFlow;
	
	@When("user adds a new Late Payment Fee Plan")
	public void whenUserCreatesALatePaymentFeePlan()
	{
		Boolean latePaymentFeePlan=creditLatePaymentFeePlanWorkFlow.userCreatesAValidLatePaymentFeePlan();
		Assert.assertTrue("Late Payment Plan has been created successfully", latePaymentFeePlan);
	}
	@Then("user searches the added LatePaymentfee plan based on filter Values")
	public void whenUserVerifiesRecordAddedBasedOnFilter()
	{
		creditLatePaymentFeePlanWorkFlow.verifyRecordsInTableBasedOnFilter();
	}
	@Then("user verifies edit operation of LatePaymentfee plan")
	public void whenUserVerifiesAndEditLatePaymentFeePlan()
	{
		creditLatePaymentFeePlanWorkFlow.verifyEditOperationForAddedRecord();
	}
	@Then("user verifies delete operation of LatePaymentfee plan")
	public void whenUserVerifiesAndDeleteLatePaymentFeePlan()
	{
		creditLatePaymentFeePlanWorkFlow.verifyDeleteOperationForAddedRecord();
	}
}
