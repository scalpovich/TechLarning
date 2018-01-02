package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.credit.RiskAnalysisRuleWorkFlow;
@Component
public class RiskAnalysisSteps {
	@Autowired
	RiskAnalysisRuleWorkFlow riskAnalysisRuleWorkFlow;
	@When("User navigates to Risk Analysis Rule Page and adds a valid Plan by entering valid values")
	public void whenUserCreatesACreditPlan()
	{
		riskAnalysisRuleWorkFlow.userCreatesAValidRiskAnalysisRulePlan();
	}
}
