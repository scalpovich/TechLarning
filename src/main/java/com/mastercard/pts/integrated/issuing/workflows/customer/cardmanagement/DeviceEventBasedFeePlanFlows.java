package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceEventBasedFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceEventBasedFeePlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createDeviceEventBasedFeePlan(DeviceCreation deviceCreation,
			DeviceEventBasedFeePlan deviceEventplan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		DeviceEventBasedFeePlanPage deviceeventbasedfeepage = navigator
				.navigateToPage(DeviceEventBasedFeePlanPage.class);
		deviceeventbasedfeepage.ClickAddDeviceEventBasedFeePlan();
		String deviceEventFeePlanCode = deviceeventbasedfeepage.addDeviceEventBasedFeePlan(deviceCreation,
				deviceEventplan);
		deviceeventbasedfeepage.adddeviceEventBasedFeeDetails(deviceEventplan);
		deviceeventbasedfeepage.clickSaveButton();
		deviceeventbasedfeepage.verifyDeviceEventBasedFeePlanSuccess();
		return deviceEventFeePlanCode;
	}

}
