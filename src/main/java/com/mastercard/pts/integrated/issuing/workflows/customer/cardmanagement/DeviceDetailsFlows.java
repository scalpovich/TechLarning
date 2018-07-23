package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class DeviceDetailsFlows {

	@Autowired
	DeviceDetailsPage deviceDetailsPage;

	@Autowired
	Navigator navigator;

	public void verifyLastExecutedScriptStatusFromDeviceDetails(String lastExecutedScriptStatus) {
		deviceDetailsPage = navigator.navigateToPage(DeviceDetailsPage.class);
		String actualLastExecutedScriptStatus = deviceDetailsPage.verifyLastExecutedScriptStatusFromDeviceDetails();
		assertTrue(
				String.format("Last Executed Script Status  does not match. Expecting %s. Actual %s",
						lastExecutedScriptStatus, actualLastExecutedScriptStatus),
				actualLastExecutedScriptStatus.equalsIgnoreCase(lastExecutedScriptStatus));
	}

}