package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCG;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MCGPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class MCGFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addMCG(MCG plan) {
		MCGPage mcgpage = navigator.navigateToPage(MCGPage.class);
		mcgpage.addMCGDetails(plan);
		mcgpage.verifyNewMCGSuccess();
	}
	
	public void addNewMCG(MCG plan) {
		MCGPage mcgpage = navigator.navigateToPage(MCGPage.class);
		mcgpage.addMCGDetails(plan);
	}
	
	public void addMCGwithMCC(MCG plan){
		MCGPage mcgpage = navigator.navigateToPage(MCGPage.class);
		mcgpage.addMCGwithMCCDetails(plan);
	}

}
