package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMCC;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMCG;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HighRiskMCGPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class HighRiskMCGFlows {
	
	@Autowired
	private Navigator navigator;
	
	public void addHighRiskMCG(HighRiskMCG highRiskMCG){
		HighRiskMCGPage page = navigator.navigateToPage(HighRiskMCGPage.class);
		page.addHighRiskMerchantCategoryGroup(highRiskMCG);
	}

}
