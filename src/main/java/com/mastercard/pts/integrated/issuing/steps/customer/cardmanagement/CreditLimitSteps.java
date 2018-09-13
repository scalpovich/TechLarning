package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CreditLimitWorkFlow;

@Component
public class CreditLimitSteps {
@Autowired
CreditLimitWorkFlow creditLimitWorkFlow;

@When("User Adds Credit Limit Rule on program for fieldName $fieldName")
@Then("User Adds Credit Limit Rule on program for fieldName $fieldName")

public void creditLimitPlanAdd(String fieldName)
{
	Boolean creditLimitRule=creditLimitWorkFlow.addCreditLimitRule(fieldName);
	Assert.assertTrue("Credit Limit Rule is not added properly", creditLimitRule);
}
}
