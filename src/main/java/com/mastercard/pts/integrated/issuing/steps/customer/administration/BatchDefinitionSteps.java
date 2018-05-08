package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.BatchDefinitionWorkflow;

@Component
public class BatchDefinitionSteps {
	@Autowired
	BatchDefinitionWorkflow batchDefinitionWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	TestContext context;

	/**
	 * Step Definition for setting the batch definition for
	 * upload/download/system file
	 * <p>
	 * Story File usage : When user sets the batch definition for the CER upload
	 * file
	 * <p>
	 */
	@When("user sets the $upload batch definiton for the $CER upload file")
	public void setBatchDefinition(@Named("upload") String batchType,
			@Named("CER") String batchID) {
		batchDefinitionWorkflow.setBatchDefinitionFlows(batchType, batchID);
	}
}
