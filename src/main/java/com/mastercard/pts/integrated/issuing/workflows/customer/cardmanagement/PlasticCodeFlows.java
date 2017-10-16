package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PlasticCode;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PlasticCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class PlasticCodeFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String addPlasticCode(PlasticCode plasticcode) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		PlasticCodePage plasticcodePage = navigator.navigateToPage(PlasticCodePage.class);
		plasticcodePage.clickaddPlasticCode();
		String PlasticCODE = plasticcodePage.addPLasticCodeDetails(plasticcode);
		plasticcodePage.verifyPlasticSuccess();
		return PlasticCODE;

	}

}
