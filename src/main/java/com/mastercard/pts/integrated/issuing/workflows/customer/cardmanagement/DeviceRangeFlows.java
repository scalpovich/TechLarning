package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceRangePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceRangeFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addDeviceRange(DeviceCreation deviceCreation) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		DeviceRangePage devicerangepage = navigator.navigateToPage(DeviceRangePage.class);
		devicerangepage.clickAddDeviceRange();
		devicerangepage.addDeviceRange(deviceCreation);
		devicerangepage.addDeviceRangeDetails();
		devicerangepage.selectDebitInerface();
		devicerangepage.Information();
		devicerangepage.clickSaveButton();
	}
	
	public void addDeviceRangeUpload(DeviceCreation deviceCreation) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		DeviceRangePage devicerangepage = navigator.navigateToPage(DeviceRangePage.class);
		devicerangepage.clickAddDeviceRange();
		devicerangepage.addDeviceRangeUpload(deviceCreation);
		devicerangepage.addDeviceRangeDetails();
		devicerangepage.selectDebitInerface();
		devicerangepage.Information();
		devicerangepage.clickSaveButton();
	}

}
