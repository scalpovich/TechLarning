package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceRangePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceRangeFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	DeviceRangePage devicerangepage;

	public void addDeviceRange(DeviceCreation deviceCreation) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		devicerangepage = navigator.navigateToPage(DeviceRangePage.class);
		devicerangepage.clickAddDeviceRange();
		devicerangepage.addDeviceRange(deviceCreation);
		devicerangepage.addDeviceRangeDetails();
		devicerangepage.selectDebitInerface();
		devicerangepage.Information();
		devicerangepage.clickSaveButton();
	}

	public void editDeviceRange(String prog) {
		devicerangepage = navigator.navigateToPage(DeviceRangePage.class);
		devicerangepage.searchDeviceRangeAndEdit(prog);
	}

	public void checkAdaptiveAuthenticationEnabled() {
		Assert.assertTrue("Adaptive Authentication Check Box is enabled",
				devicerangepage.adaptiveAuthenticationChkBox());
	}

	public void checkAdaptiveAuthenticationDisabled() {
		Assert.assertFalse("Adaptive Authentication Check Box is disabled",
				devicerangepage.adaptiveAuthenticationChkBox());
	}

}
