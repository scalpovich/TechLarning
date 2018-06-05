package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceUsagePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class DeviceUsageWorkflow {
	
	@Autowired
	private Navigator navigator;

	public List<String> getApplicationTransactionCounterDeviceUsage(String cardNumber) {
		DeviceUsagePage deviceUsage = navigator.navigateToPage(DeviceUsagePage.class);
		return deviceUsage.getApplicationTransactionCounter(cardNumber);		
	}
}
