package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.RiskAnalysisPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class RiskAnalysisBatchFlow {

	@Autowired
	Navigator navigator;
	
	private RiskAnalysisPage riskAnalysisPage;
	
	public void processAllRiskAnalysisBatch() {
		riskAnalysisPage = navigator.navigateToPage(RiskAnalysisPage.class);
		riskAnalysisPage.riskAnalysisBatchProcess();
	}
}
