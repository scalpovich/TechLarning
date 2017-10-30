package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Walletplan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class WalletPlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createOpenWalletPlan(DeviceCreation deviceCreation, Walletplan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectOpenWalletUsage();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;

	}

	public String createClosedWalletPlan(DeviceCreation deviceCreation, Walletplan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectClosedWalletUsage();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;

	}

	public String createClosedWhitelistedMCGWalletPlan(DeviceCreation deviceCreation, Walletplan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectClosedWalletUsage();
		walletplanpage.selectWhiteListedMCGPlan();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;
	}

	public String createWhitelistedMerchantWalletPlan(DeviceCreation deviceCreation, Walletplan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectWhiteListedMerchantPlan();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;
	}

	public String createMutltiWalletPLan(DeviceCreation deviceCreation, Walletplan walletplan) {
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
