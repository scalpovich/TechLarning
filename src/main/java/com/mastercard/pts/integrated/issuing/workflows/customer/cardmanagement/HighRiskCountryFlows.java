package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HighRiskCountryPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class HighRiskCountryFlows {
	
	@Autowired
	private Navigator navigator;
	public void AddAndVerifyHighRiskCountry(){
		HighRiskCountryPage page = navigator.navigateToPage(HighRiskCountryPage.class);
		page.addAndVerifyHighRiskCountry();	
	}

}
