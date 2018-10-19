package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AdministartivePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

public class AdministrativeFlows {
	
	@Autowired
	Navigator navigator;

	AdministartivePage administartivePage;
	public void updateAdministrativeSetting(String status, String response) {
		administartivePage=navigator.navigateToPage(AdministartivePage.class);
		administartivePage.updateAdministrativeSetting(status,response);
		
	}
}
