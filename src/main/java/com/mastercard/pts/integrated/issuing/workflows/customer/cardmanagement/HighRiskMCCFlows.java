package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskCountry;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMCC;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TaxOnIncomeRate;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HighRiskCountryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HighRiskMCCPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TaxOnIncomePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class HighRiskMCCFlows {
	
	@Autowired
	private Navigator navigator;
	
	public void addHighRiskMCC(HighRiskMCC highRiskMCC){
		HighRiskMCCPage page = navigator.navigateToPage(HighRiskMCCPage.class);
		page.addHighRiskMerchantCategoryCode(highRiskMCC);	
	}

}
