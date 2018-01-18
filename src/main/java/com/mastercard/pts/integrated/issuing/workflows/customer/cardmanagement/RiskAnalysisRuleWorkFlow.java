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
	
	public boolean userCreatesAValidRiskAnalysisRulePlan()
	{
	 page = navigator.navigateToPage(RiskAnalysisRulePage.class);
	 page.addButtonToEnterRiskAnalysisRulePlanFrame();
	 page.addMandatoryLabelsAndFields();
	 page.selectProgram(1);
	 page.selectField(1);
	 page.selectOperator(1);
	 page.selectFieldName2(1);
	 page.appendButtonClick();
	 page.settingMandatoryValuesWithLabels();
	 page.saveButtonClick();
	 return page.successMessageDiplay();
	}
   
}
