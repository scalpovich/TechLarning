package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceGenerationBatchFlows;

@Component
public class DeviceGenerationBatchSteps {
@Autowired
DeviceGenerationBatchFlows deviceGenerationBatchFlows;

@When("user processes deviceGeneration batch for new Application")
public void closeBatchExecutionForNewApplication()
{
	deviceGenerationBatchFlows.deviceGenerationBatchExecution();
}

@When("user processes deviceGeneration batch for new Application for fileUpload")
public void closeBatchExecutionForNewApplicationForFileUpload()
{
	deviceGenerationBatchFlows.deviceGenerationBatchExecutionForFileUpload();
}
}
