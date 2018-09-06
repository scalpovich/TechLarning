package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListDevice;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceStatusPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StopListDevicePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class DeviceStatusWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void changeStatus(String status){
		DeviceStatusPage page = navigator.navigateToPage(DeviceStatusPage.class);
		page.changeDeviceStatus(status);
	}

}
