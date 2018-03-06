package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HSMNetworkKeys;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HSMNetworkKeysPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class HSMNetworkKeysFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addHSMNetworkKeys(HSMNetworkKeys hsmnetworkKeys) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		HSMNetworkKeysPage hsmnetworkpage = navigator.navigateToPage(HSMNetworkKeysPage.class);
		hsmnetworkpage.addHSMKeys();
		hsmnetworkpage.switchToAddNetworkKeys();
		hsmnetworkpage.selectNetworkInterface(hsmnetworkKeys);
		hsmnetworkpage.selectKeyType(hsmnetworkKeys);
		hsmnetworkpage.fillSubNetworkID(hsmnetworkKeys);
		hsmnetworkpage.fillKeyIndex(hsmnetworkKeys);
		hsmnetworkpage.fillNetworkCryptogram(hsmnetworkKeys);
		hsmnetworkpage.fillConfirmNetworkCryptogram(hsmnetworkKeys);
		hsmnetworkpage.fillNetworkCryptogramCheckValue(hsmnetworkKeys);
		hsmnetworkpage.fillConfirmNetworkCryptogramCheckValue(hsmnetworkKeys);
		hsmnetworkpage.clickSaveBtn();
	}

}