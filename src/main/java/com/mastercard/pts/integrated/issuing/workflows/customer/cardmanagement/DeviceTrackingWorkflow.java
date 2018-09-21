package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceTrackingPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class DeviceTrackingWorkflow {
	
	@Autowired
	private Navigator navigator;

	public void checkForNewFieldsAdded(Device device) {
		DeviceTrackingPage page = navigator.navigateToPage(DeviceTrackingPage.class);
		page.checkForNewFieldsAdded(device);
	}
}
