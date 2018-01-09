package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.RiskAnalysisRulePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

/**
 * @author e076177
 *
 */
@Workflow
public class RiskAnalysisRuleWorkFlow {
	@Autowired
	private Navigator navigator;
	private RiskAnalysisRulePage page;
	
	public void userCreatesAValidRiskAnalysisRulePlan()
	{
	 page = navigator.navigateToPage(RiskAnalysisRulePage.class);
	 page.addButtonToEnterRiskAnalysisRulePlanFrame();
	 page.addMandatoryLabelsAndFields();
	 page.selectProgram();
	 page.selectField();
	 page.selectOperator();
	 page.selectFieldName2();
	 page.appendButtonClick();
	 page.settingMandatoryValuesWithLabels();
	 page.saveButtonClick();
	}
   
}
