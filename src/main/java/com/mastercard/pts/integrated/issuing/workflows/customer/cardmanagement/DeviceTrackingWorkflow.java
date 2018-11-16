package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceTrackingPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class DeviceTrackingWorkflow {
	
	@Autowired
	private Navigator navigator;

	public void checkForNewFieldsAdded(Device device) {
		DeviceTrackingPage page = navigator.navigateToPage(DeviceTrackingPage.class);
		page.checkForNewFieldsAdded(device);
	}
}
