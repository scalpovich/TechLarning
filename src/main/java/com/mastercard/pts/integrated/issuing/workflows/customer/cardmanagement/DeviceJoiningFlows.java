package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningMembershipFeePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceJoiningPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceJoiningFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String addDeviceJoiningFeePlan(DeviceCreation deviceCreation,
			DeviceJoiningMembershipFeePlan devicejoiningplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		DeviceJoiningPage devicejoiningpage = navigator.navigateToPage(DeviceJoiningPage.class);
		devicejoiningpage.clickAddDeviceJoining();
		String deviceJoiningMembershipPlan = devicejoiningpage.addDeviceJoiningMembershipPlan(deviceCreation,
				devicejoiningplan);
		devicejoiningpage.clickSaveButton();
		devicejoiningpage.addDeviceJoiningIssuingPlanDetails(devicejoiningplan);
		devicejoiningpage.clickSaveButton();
		devicejoiningpage.verifyDeviceJoiningMembershipSuccess();
		return deviceJoiningMembershipPlan;

	}

	public String addDeviceMembershipFeePlan(DeviceCreation deviceCreation,
			DeviceJoiningMembershipFeePlan devicejoiningplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		DeviceJoiningPage devicejoiningpage = navigator.navigateToPage(DeviceJoiningPage.class);
		devicejoiningpage.clickAddDeviceJoining();
		String deviceJoiningMembershipPlan = devicejoiningpage.addDeviceJoiningMembershipPlan(deviceCreation,
				devicejoiningplan);
		devicejoiningpage.clickSaveButton();
		devicejoiningpage.addDeviceJoiningMembershipPLanDetails(devicejoiningplan);
		devicejoiningpage.clickSaveButton();
		devicejoiningpage.verifyDeviceJoiningMembershipSuccess();
		return deviceJoiningMembershipPlan;
	}

}
