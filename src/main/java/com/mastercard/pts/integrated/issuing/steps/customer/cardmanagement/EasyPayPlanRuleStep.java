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
	EasyPayPlanRule easyPayPlanRule;
	@Autowired
	EasyPayPlanRuleFlow easyPayPlanFlow;
	
	@When("user creates easy pay plan rule")	
	public void easyPayPlanRuleFlow() {
		easyPayPlanRule=EasyPayPlanRule.createDataProvider();
		easyPayPlanRule.setPlanCode(RandomStringUtils.randomNumeric(4));
		easyPayPlanRule.setPlanDesc(easyPayPlanRule.getRuleCode()+easyPayPlanRule.getPlanCode());
		easyPayPlanFlow.adddetails(easyPayPlanRule);

	}
	
	
	
	
}
