package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceRangePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceRangeFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	DeviceRangePage deviceRangePage;

	public void addDeviceRange(DeviceBin devicebin) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		deviceRangePage = navigator.navigateToPage(DeviceRangePage.class);
		deviceRangePage.clickAddDeviceRange();
		deviceRangePage.addDeviceRange(devicebin);
		deviceRangePage.addDeviceRangeDetails();
		deviceRangePage.selectDebitInerface();
		deviceRangePage.Information();
		deviceRangePage.clickSaveButton();
	}

	public void editDeviceRange(String prog) {
		deviceRangePage = navigator.navigateToPage(DeviceRangePage.class);
		deviceRangePage.searchDeviceRangeAndEdit(prog);
	}

	public void checkAdaptiveAuthenticationEnabled() {
		Assert.assertTrue("Adaptive Authentication Check Box is enabled", deviceRangePage.clickAdaptiveAuthChkBox());
	}

	public void checkAdaptiveAuthenticationDisabled() {
		Assert.assertFalse("Adaptive Authentication Check Box is disabled", deviceRangePage.clickAdaptiveAuthChkBox());
	}
	
	public void addDeviceRangeUpload(DeviceCreation deviceCreation) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		DeviceRangePage devicerangepage = navigator.navigateToPage(DeviceRangePage.class);
		devicerangepage.clickAddDeviceRange();
		//devicerangepage.addDeviceRangeUpload(deviceCreation);
		devicerangepage.addDeviceRangeDetails();
		devicerangepage.selectDebitInerface();
		devicerangepage.Information();
		devicerangepage.clickSaveButton();
	}

}
