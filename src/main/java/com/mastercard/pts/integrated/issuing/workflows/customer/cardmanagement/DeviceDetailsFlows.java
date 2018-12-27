package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class DeviceDetailsFlows {

	@Autowired
	Navigator navigator;

	public void verifyLastExecutedScriptStatusFromDeviceDetails(String lastExecutedScriptStatus) {
		DeviceDetailsPage deviceDetailsPage = navigator.navigateToPage(DeviceDetailsPage.class);
		Assert.assertTrue(deviceDetailsPage.verifyLastExecutedScriptStatusFromDeviceDetails()
				.equalsIgnoreCase(lastExecutedScriptStatus));
	}
	
	public void findAndPutDeviceApplicationNumberInContext(Device device) {
		DeviceDetailsPage deviceDetailsPage = navigator.navigateToPage(DeviceDetailsPage.class);
		deviceDetailsPage.retriveDeviceApplicationNumber(device);
	}
	
	public void getClientCode() {
		DeviceDetailsPage deviceDetailsPage = navigator.navigateToPage(DeviceDetailsPage.class);
		Assert.assertFalse(deviceDetailsPage.getClientCode().isEmpty());
	}

}