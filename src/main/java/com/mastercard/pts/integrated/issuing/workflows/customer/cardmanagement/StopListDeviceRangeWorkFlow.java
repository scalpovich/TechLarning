package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListDeviceRange;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StopListDeviceRangePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class StopListDeviceRangeWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void addStopListDeviceRange(StopListDeviceRange stopListDeviceRange,DeviceRange deviceRange){
		StopListDeviceRangePage page = navigator.navigateToPage(StopListDeviceRangePage.class);
		page.addStopListDeviceRange(stopListDeviceRange, deviceRange);
	}

}
