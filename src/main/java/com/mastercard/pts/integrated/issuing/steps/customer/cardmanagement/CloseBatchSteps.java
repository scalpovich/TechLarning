package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CloseBatchFlows;

@Component
public class CloseBatchSteps {
@Autowired
CloseBatchFlows closeBatchFlows;

@When("user process close batch for new Application")
public void closeBatchExecutionForNewApplication()
{
	closeBatchFlows.closeBatchExecution();
}
}
