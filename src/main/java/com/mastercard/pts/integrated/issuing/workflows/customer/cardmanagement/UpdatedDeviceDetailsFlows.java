package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.UpdateDeviceDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;

@Component
public class UpdatedDeviceDetailsFlows extends MenuFlows {

	@Autowired
	Navigator navigator;
	
	private UpdateDeviceDetailsPage page;
	
	public void updateDevicePlanForDevice(Device device){
		page = navigator.navigateToPage(UpdateDeviceDetailsPage.class);
		page.updateDevicePlanForDevice(device);
	}

	
}
