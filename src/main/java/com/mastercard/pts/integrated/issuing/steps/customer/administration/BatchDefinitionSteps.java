package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.administration.BatchDefinitionWorkflow;

@Component
public class BatchDefinitionSteps {
	@Autowired
	BatchDefinitionWorkflow batchDefinitionWorkflow;

	/**
	 * Step Definition for setting the batch definition for
	 * upload/download/system file
	 * <p>
	 * Story File usage : When user sets the batch definition for the CER upload
	 * file
	 * <p>
	 */
	@When("user sets the $batchType batch definiton for the $batchName upload file")
	public void setBatchDefinition(@Named("batchType") String batchType,
			@Named("batchName") String batchID) {
		batchDefinitionWorkflow.setBatchDefinitionFlows(batchType, batchID);
	}
}
