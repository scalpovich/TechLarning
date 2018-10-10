package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
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
	
	@When("User Adds Risk Analysis Rule for fieldName1 $fieldName and fieldName2 $field on program")
	@Then("User Adds Risk Analysis Rule for fieldName1 $fieldName and fieldName2 $field on program")
	public void whenUserCreatesACreditPlan(String fieldName,String field){
		Boolean riskAnalysisRule=riskAnalysisRuleWorkFlow.userCreatesAValidRiskAnalysisRulePlan(fieldName,field);
		Assert.assertTrue("RiskAnalysis Rule has not been added successfully", riskAnalysisRule);
	}
}
