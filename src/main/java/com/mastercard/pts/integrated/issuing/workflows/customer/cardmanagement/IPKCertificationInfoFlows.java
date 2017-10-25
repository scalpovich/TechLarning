package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.IssuerPublicKey;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.IssuerPublicKeyPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class IPKCertificationInfoFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addIPK(IssuerPublicKey ipk) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		IssuerPublicKeyPage IPKpage = navigator.navigateToPage(IssuerPublicKeyPage.class);
		IPKpage.clickaddIPKCertification();
		IPKpage.addIPKDetails(ipk);
		IPKpage.verifyIpkSuccess();
	}
}
