package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCOverlimit;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MCCOverlimitPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class MCCOverLimitFlows {

	@Autowired
	private Navigator navigator;

	private MCCOverlimitPage page;

	public void createMccOverlimit(MCCOverlimit mccOverlimit) {
		page = navigator.navigateToPage(MCCOverlimitPage.class);
		page.addMccOverlimit(mccOverlimit);
	}

	public String getFeedBackText() {
		return page.getFeedbackMessage();
	}

}
