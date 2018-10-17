package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ApplicationScoringBatchFlow;

@Component
public class ApplicationScoringSteps {
	
	@Autowired
	ApplicationScoringBatchFlow applicationScoringBatchFlow;

	@When("user processesAll applicationScoring batch for new Application")
	public void riskAnalysisBatchExecution(){
		applicationScoringBatchFlow.processApplicationScoringBatch();
	}
}
