package com.mastercard.pts.integrated.issuing.workflows.credit;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.RiskAnalysisRulePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class RiskAnalysisRuleWorkFlow {
	@Autowired
	private Navigator navigator;
	@Autowired
	RiskAnalysisRulePage page;
	public void userCreatesAValidRiskAnalysisRulePlan()
	{
	 page = navigator.navigateToPage(RiskAnalysisRulePage.class);
	 page.addRiskAnalysisRuleplan();
	}
   
}
