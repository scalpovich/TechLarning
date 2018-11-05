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
	
	private MCGPage page;

	public void addMCG(MCG plan) {
		page = navigator.navigateToPage(MCGPage.class);
		page.addMCGDetails(plan);
		page.verifyNewMCGSuccess();
	}
	
	public void addNewMCG(MCG plan) {
	    page = navigator.navigateToPage(MCGPage.class);
		page.addMCGDetails(plan);
	}
	
	public void addMCGWithMCC(MCG plan){
		page = navigator.navigateToPage(MCGPage.class);
		page.addMCGWithMCCDetails(plan);
	}
	
	public String getFeedbackText() {
		page.switchToDefaultFrame();
		return page.getMessageFromFeedbackPanel();
	}
}