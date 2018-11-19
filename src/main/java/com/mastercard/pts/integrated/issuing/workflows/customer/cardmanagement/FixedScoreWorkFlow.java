package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.FixedScorePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class FixedScoreWorkFlow {
	@Autowired
	private Navigator navigator;
	private FixedScorePage fixedScorePage;
	
	public boolean userAddsFixedScore(String fieldName,String fieldValue)
	{
		fixedScorePage=navigator.navigateToPage(FixedScorePage.class);
		fixedScorePage.selectProgram();
		fixedScorePage.selectFieldName(fieldName);
		fixedScorePage.selectFieldValue(fieldValue);
		fixedScorePage.enterScore();
		return fixedScorePage.successMessageDisplay();
		
	}
}
