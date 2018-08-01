package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListDevice;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StopListDevicePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class StopListDeviceWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void addStoplistDevice(StopListDevice stopListDevice){
		StopListDevicePage page = navigator.navigateToPage(StopListDevicePage.class);
		page.addStoplistDevice(stopListDevice);
	}

}