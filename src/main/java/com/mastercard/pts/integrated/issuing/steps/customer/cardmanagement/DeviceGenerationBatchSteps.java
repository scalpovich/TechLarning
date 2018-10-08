package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceGenerationBatchFlows;

@Component
public class DeviceGenerationBatchSteps {
	@Autowired
	DeviceGenerationBatchFlows deviceGenerationBatchFlows;

	@When("user processes deviceGeneration batch for new Application")
	public void closeBatchExecutionForNewApplication(){
		deviceGenerationBatchFlows.deviceGenerationBatchExecution();
	}
	
	@When("user processes deviceGeneration batch for new Application for FileUpload")
	public void closeFirstBatchExecutionForNewApplication(){
		deviceGenerationBatchFlows.deviceGenerationFirstBatchExecution();
	}
	
	@When("user processesAll deviceGeneration batch for new Application")
	@Then("user processesAll deviceGeneration batch for new Application")
	public void closetBatchExecutionForNewApplication(){
		deviceGenerationBatchFlows.deviceGenerationAllBatchExecution();
	}
}
