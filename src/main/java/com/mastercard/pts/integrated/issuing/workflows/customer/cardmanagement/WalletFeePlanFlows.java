package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class WalletFeePlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createWalletFeePlan(DeviceCreation deviceCreation, WalletFeePlan walletfeeplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletFeePlanPage walletfeeplanpage = navigator.navigateToPage(WalletFeePlanPage.class);
		walletfeeplanpage.clickAddWalletFeePlan();
		String walletFeeplan = walletfeeplanpage.addWalletFeePlan(deviceCreation, walletfeeplan);
		if(!deviceCreation.getProduct().equalsIgnoreCase("Credit")){
			walletfeeplanpage.addWalletFeePlanDetails(deviceCreation, walletfeeplan);
			walletfeeplanpage.switchToAddFeeWalletPlanFrame();
			walletfeeplanpage.clickSaveButton();
		}
		return walletFeeplan;

	}

}
