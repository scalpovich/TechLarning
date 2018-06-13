package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WalletPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class WalletPlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	private WalletPlanPage page;
	
	public String createOpenWalletPlan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectOpenWalletUsage();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;

	}

	public void createCreditWalletPlanForWhiteListedMCG(WalletPlan plan) {
		page = navigator.navigateToPage(WalletPlanPage.class);
		page.clickaddWalletPLan();
		page.enterGeneralDetails(plan);
		page.enterCreditConfigDetails();
		page.enterPlanUsageLimitsFeesDetails();
		page.selectWhiteListedMCGPlan();
		page.clickNextButton();
		page.checkAllowRefund();
		page.enterWalletInactivityRuleDetails();
		page.clickFinishButton();
	}

	public String createOpenWalletPlan(WalletPlan walletplan) {
		page = navigator.navigateToPage(WalletPlanPage.class);
		page.clickaddWalletPLan();
		String walletPlan = page.addWalletPlanGeneral(walletplan);
		page.selectOpenWalletUsage();
		page.clickNextButton();
		page.clickFinishButton();

		return walletPlan;
	}
	
	public String createClosedWalletPlan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectClosedWalletUsage();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;

	}

	public String createClosedWalletPlan(WalletPlan walletplan) {
		page = navigator.navigateToPage(WalletPlanPage.class);
		page.clickaddWalletPLan();
		String walletPlan = page.addWalletPlanGeneral(walletplan);
		page.selectClosedWalletUsage();
		page.clickNextButton();
		page.clickFinishButton();

		return walletPlan;
	}

	public String createClosedWhitelistedMCGWalletPlan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectClosedWalletUsage();
		walletplanpage.selectWhiteListedMCGPlan();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;
	}
	
	public String createClosedWhitelistedMCGWalletPlan(WalletPlan walletplan) {
		page = navigator.navigateToPage(WalletPlanPage.class);
		page.clickaddWalletPLan();
		String walletPlan = page.addWalletPlanGeneral(walletplan);
		page.selectClosedWalletUsage();
		page.selectWhiteListedMCGPlan();
		page.clickNextButton();
		page.clickFinishButton();

		return walletPlan;
	}
	
	public String createWhitelistedMerchantWalletPlan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectWhiteListedMerchantPlan();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;
	}
	public String createWhitelistedMerchantWalletPlan(WalletPlan walletplan) {
		page = navigator.navigateToPage(WalletPlanPage.class);
		page.clickaddWalletPLan();
		String walletPlan = page.addWalletPlanGeneral(walletplan);
		page.selectWhiteListedMerchantPlan();
		page.clickNextButton();
		page.clickFinishButton();

		return walletPlan;
	}
	public String createMutltiWalletPLan(DeviceCreation deviceCreation, WalletPlan walletplan) {
		WalletPlanPage walletplanpage = navigator.navigateToPage(WalletPlanPage.class);
		walletplanpage.clickaddWalletPLan();
		String walletPlan = walletplanpage.addWalletPlanGeneral(deviceCreation, walletplan);
		walletplanpage.selectWhiteListedMCGPlan();
		walletplanpage.selectWhiteListedMerchantPlan();
		walletplanpage.clickNextButton();
		walletplanpage.clickFinishButton();
		return walletPlan;
	}

	public String createMutltiWalletPLan(WalletPlan walletplan) {
		page = navigator.navigateToPage(WalletPlanPage.class);
		page.clickaddWalletPLan();
		String walletPlan = page.addWalletPlanGeneral(walletplan);
		page.selectWhiteListedMCGPlan();
		page.selectWhiteListedMerchantPlan();
		page.clickNextButton();
		page.clickFinishButton();

		return walletPlan;
	}

	public String getFeedbackText() {
		page.switchToDefaultFrame();

		return page.getFeedbackInfo();
	}

	public boolean isRecordFoundInTable(WalletPlan plan) {
		page.switchToDefaultFrame();
		page.searchByWalletPlanCode(plan);
		page.clickSearchButton();
		
		return page.isTextPresentInTable(plan.getWalletPlanCode());
	}
}
