package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Office;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.OfficePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class OfficeFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String addOffice(Office office, String type) {
		OfficePage officePage = navigator.navigateToPage(OfficePage.class);
		officePage.clickAddOffice();
		String Office = officePage.addOfficeDetails(type, office);
		waitForPageToLoad(getFinder().getWebDriver());
		officePage.verifyNewOfficeSuccess();
		return Office;

	}
}
