package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceCreateApplicationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceCreateDevicePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class DeviceWorkflow {
	
	@Autowired
	private Navigator navigator;

	public void verifyProgramAndDevicePlan(Device device) {
		DeviceCreateDevicePage page = navigator.navigateToPage(DeviceCreateDevicePage.class);
		page.verifyProgramAndDevicePlan(device);
		}

	public void createDevice(Device device) {
		DeviceCreateDevicePage page = navigator.navigateToPage(DeviceCreateDevicePage.class);
		page.createDevice(device);
	}
	public void createDeviceUsingApplication(Device device) {
		DeviceCreateApplicationPage page = navigator.navigateToPage(DeviceCreateApplicationPage.class);
		page.createDevice_NewApplication(device);
	}
}
