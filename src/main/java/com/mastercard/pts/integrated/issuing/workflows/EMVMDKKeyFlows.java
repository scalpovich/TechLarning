package com.mastercard.pts.integrated.issuing.workflows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MasterDerivationKeys;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MasterDerivationKeysPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class EMVMDKKeyFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addMDKKey(MasterDerivationKeys mdkKeys) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		MasterDerivationKeysPage mdkpage = navigator.navigateToPage(MasterDerivationKeysPage.class);
		mdkpage.addMDK();
		mdkpage.switchToAddMDKKey();
		mdkpage.selectInterchange(mdkKeys);
		mdkpage.fillBinLow(mdkKeys);
		mdkpage.fillBinHigh(mdkKeys);
		mdkpage.selectStatus(mdkKeys);
		mdkpage.selectKeyType(mdkKeys);
		mdkpage.fillMDKEncryptedUnderLMK(mdkKeys);
		mdkpage.fillConfirmMDKEncryptedUnderLMK(mdkKeys);
		mdkpage.fillMDKKeyCheckvalue(mdkKeys);
		mdkpage.fillConfirmMDKKeyCheckvalue(mdkKeys);
		if (mdkKeys.getSMIEncryptedUnderLMKTxt() != null) {
			mdkpage.enterSMIDetails(mdkKeys);
		}
		if (mdkKeys.getSMCEncryptedUnderLMKTxt() != null) {
			mdkpage.enterSMCDetails(mdkKeys);
		}
		mdkpage.clickSaveBtn();
	}
}
