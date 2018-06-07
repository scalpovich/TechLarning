package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawDevice;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WithdrawDevicePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class WithdrawDeviceWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void withDrawStopListDevice(WithdrawDevice withdrawDevice){
		WithdrawDevicePage page = navigator.navigateToPage(WithdrawDevicePage.class);
		page.withDrawStopListDevice(withdrawDevice);
	}

}
