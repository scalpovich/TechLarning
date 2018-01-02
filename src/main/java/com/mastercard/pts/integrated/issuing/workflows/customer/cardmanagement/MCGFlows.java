package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MCGPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class MCGFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String addMCG() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		MCGPage mcgpage = navigator.navigateToPage(MCGPage.class);
		mcgpage.clickaddMCG();
		String MCG = mcgpage.addMCGDetails();
		mcgpage.verifyNewMCGSuccess();
		return MCG;
	}
	
	public String addNewMCG() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		MCGPage mcgpage = navigator.navigateToPage(MCGPage.class);
		mcgpage.clickaddMCG();		
		return mcgpage.addMCGDetails();
	}

}
