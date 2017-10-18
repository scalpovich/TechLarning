package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class WalletPlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createWalletPlan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;

	}

	public String createWhitelistedMCGWalletPlan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectWhiteListedMCGPlan();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;
	}

	public String createWhitelistedMerchantWalletPlan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectWhiteListedMerchantPlan();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;
	}

	public String createMutltiWalletPLan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectWhiteListedMCGPlan();
		walletplanpage.selectWhiteListedMerchantPlan();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;
	}
}
