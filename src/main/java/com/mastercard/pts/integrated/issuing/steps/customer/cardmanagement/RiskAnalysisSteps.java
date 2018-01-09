package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.RiskAnalysisRuleWorkFlow;

/**
 * @author e076177
 *
 */
@Component
public class RiskAnalysisSteps {
	@Autowired
	RiskAnalysisRuleWorkFlow riskAnalysisRuleWorkFlow;
	@When("User adds a Risk Analysis Rule Plan by entering valid values")
	public void whenUserCreatesACreditPlan()
	{
		riskAnalysisRuleWorkFlow.userCreatesAValidRiskAnalysisRulePlan();
	}
}
