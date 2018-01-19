package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CreditPlanWorkFlow;

/**
 * @author e076177
 *
 */
@Component
public class CreditPlanSteps {
@Autowired
KeyValueProvider provider;	
private CreditCardCreditPlan creditCardCreditPlan;
@Autowired
CreditPlanWorkFlow creditPlanWorkFlow;

@When("user creates a valid creditPlan")
public void whenUserCreatesACreditPlan()
{  
	creditCardCreditPlan=CreditCardCreditPlan.createWithProvider(provider);
	Boolean validCreditPlan=creditPlanWorkFlow.userCreatesAValidCreditPlan(creditCardCreditPlan);
	Assert.assertTrue("Valid Credit Plan is created", validCreditPlan);
}
@Then("user searches the record added based on filter Values")
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
