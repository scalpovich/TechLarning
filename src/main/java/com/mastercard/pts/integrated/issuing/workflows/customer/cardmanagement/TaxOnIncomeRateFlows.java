package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TaxOnIncomeRate;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TaxOnIncomePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class TaxOnIncomeRateFlows {
	
	@Autowired
	private Navigator navigator;
	
	public void addTaxOnIncomeRate(TaxOnIncomeRate taxOnIncomeRate){
		TaxOnIncomePage page = navigator.navigateToPage(TaxOnIncomePage.class);
		page.addTaxOnIncomeRate(taxOnIncomeRate);	
	}

}
