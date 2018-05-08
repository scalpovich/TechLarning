package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EasyPayPlanRule;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.EasyPayPlanRuleFlow;

@Component
public class EasyPayPlanRuleStep  {
	
	
	@Autowired
	EasyPayPlanRule easypayplanrule;
	@Autowired
	EasyPayPlanRuleFlow easypayplanflow;
	
	@When("user creates easy pay plan rule")	
	public void easyPayPlanRuleFlow() {
		easypayplanrule=EasyPayPlanRule.createDataProvider();
		easypayplanrule.setPlanCode(RandomStringUtils.randomNumeric(4));
		easypayplanrule.setPlanDesc(easypayplanrule.getRuleCode()+easypayplanrule.getPlanCode());
		easypayplanflow.adddetails(easypayplanrule);

	}
	
	
	
	
}
