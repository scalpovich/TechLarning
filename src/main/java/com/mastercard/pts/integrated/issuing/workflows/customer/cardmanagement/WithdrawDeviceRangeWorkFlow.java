package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawDeviceRange;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WithdrawDeviceRangePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class WithdrawDeviceRangeWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void withdrawDeviceRange(WithdrawDeviceRange withdrawDeviceRange,DeviceRange deviceRange){
		WithdrawDeviceRangePage page = navigator.navigateToPage(WithdrawDeviceRangePage.class);
		page.withdrawDeviceRange(withdrawDeviceRange, deviceRange);
	}

}
