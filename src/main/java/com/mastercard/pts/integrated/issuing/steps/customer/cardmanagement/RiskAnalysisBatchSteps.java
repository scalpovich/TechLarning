package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.RiskAnalysisBatchFlow;

@Component
public class RiskAnalysisBatchSteps {
	
	@Autowired
	RiskAnalysisBatchFlow riskAnalysisBatchFlow;

	@When("user processesAll riskAnalysis batch for new Application")
	public void riskAnalysisBatchExecution() {
		riskAnalysisBatchFlow.processAllRiskAnalysisBatch();
	}
}
