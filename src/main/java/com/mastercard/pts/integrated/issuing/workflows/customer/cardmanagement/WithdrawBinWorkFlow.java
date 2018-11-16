package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawBin;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WithdrawBinPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class WithdrawBinWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void withdrawDeviceBin(WithdrawBin withdrawBin,DeviceRange deviceRange){
		WithdrawBinPage page = navigator.navigateToPage(WithdrawBinPage.class);
		page.withdrawBin(withdrawBin, deviceRange);
	}

}
