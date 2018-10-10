package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.RiskAnalysisPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Component
public class RiskAnalysisBatchFlow {

	@Autowired
	Navigator navigator;
	
	private RiskAnalysisPage riskAnalysisPage;
	
	public void processAllRiskAnalysisBatch() {
		riskAnalysisPage = navigator.navigateToPage(RiskAnalysisPage.class);
		riskAnalysisPage.riskAnalysisBatchProcess();
		riskAnalysisPage.clickProcessALL();
	}
	
	public void processRiskAnalysisBatch() {
		riskAnalysisPage = navigator.navigateToPage(RiskAnalysisPage.class);
		riskAnalysisPage.allBatchNumberRetrieval();
		SimulatorUtilities.wait(5000);
		riskAnalysisPage.identifyBatchNumberToProcess();
		riskAnalysisPage.processAppropriateBatchForApplication();
	}
}
