package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawCountry;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.WithdrawCountryPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class WithdrawCountryWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void withdrawCountry(WithdrawCountry withdrawCountry,DeviceRange deviceRange){
		WithdrawCountryPage page = navigator.navigateToPage(WithdrawCountryPage.class);
		page.withdrawCountry(withdrawCountry, deviceRange);
	}

}
