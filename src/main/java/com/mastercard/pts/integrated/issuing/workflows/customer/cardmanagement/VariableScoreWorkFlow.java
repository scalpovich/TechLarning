package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.VariableScorePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class VariableScoreWorkFlow {
	
	@Autowired
	private Navigator navigator;
	
	private VariableScorePage variableScorePage;
	
	public boolean userAddsNewVariableScore(String fieldName)
	{
		variableScorePage=navigator.navigateToPage(VariableScorePage.class);
		variableScorePage.selectProgram();
		variableScorePage.selectFieldName(fieldName);
		variableScorePage.enterRangeStartValue();
		variableScorePage.enterRangeEndValue();
		variableScorePage.enterScore();
		variableScorePage.saveButtonClick();
		return variableScorePage.successMessageDisplay();
	}

}
