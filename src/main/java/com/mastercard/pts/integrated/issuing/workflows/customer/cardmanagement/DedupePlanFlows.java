package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DedupePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DedupePlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String addDedupePlan() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		DedupePlanPage dedupePlanpage = navigator.navigateToPage(DedupePlanPage.class);
		dedupePlanpage.clickaddDedupePlan();
		String DedupePlan = dedupePlanpage.addDedupeDetails();
		dedupePlanpage.clickPrimaryApplication();
		dedupePlanpage.clickSaveButton();
		dedupePlanpage.verifyNewDedupePlanSuccess();
		return DedupePlan;
	}

}
