package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListCountry;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StopListCountryPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class StopListCountryWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void addStopListCountry(StopListCountry stopListCountry,DeviceRange deviceRange){
		StopListCountryPage page = navigator.navigateToPage(StopListCountryPage.class);
		page.stopListCountry(stopListCountry, deviceRange);
	}

}
