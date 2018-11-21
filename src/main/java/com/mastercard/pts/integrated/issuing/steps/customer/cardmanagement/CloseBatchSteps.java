package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CloseBatchFlows;

@Component
public class CloseBatchSteps extends AbstractBaseSteps {
@Autowired
CloseBatchFlows closeBatchFlows;

@When("user processes close batch for new Application")
public void closeBatchExecutionForNewApplication(){
	closeBatchFlows.closeBatchExecution();
}

@When("user processes close batch for new Application for FileUpload")
public void closeFirstBatchExecutionForNewApplication(){
	closeBatchFlows.closeBatchExecutionForFileUpload();
}

@When("user processesAll close batch for new Application")
@Then("user processesAll close batch for new Application")
public void AllCloseBatchExecutionForNewApplication(){
	closeBatchFlows.closeAllBatchExecution();
}
}
