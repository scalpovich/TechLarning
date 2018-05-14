package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceUsagePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DeviceUsageWorklow extends MenuFlows {

	@Autowired
	private Navigator navigator;

	@Autowired
	private DeviceUsagePage deviceUsagePage;

	final Logger loggers = LoggerFactory.getLogger(this.getClass());

	public void deviceUsageVerification(String cardNumber) {
		deviceUsagePage = navigator.navigateToPage(DeviceUsagePage.class);
		deviceUsagePage.searchDevice(cardNumber);
	}

}