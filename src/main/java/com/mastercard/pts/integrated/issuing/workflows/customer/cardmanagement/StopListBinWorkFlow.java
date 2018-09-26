package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListBin;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StopListBinPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class StopListBinWorkFlow {
	
	@Autowired
	private Navigator navigator;
	public void addStoplistBin(StopListBin stopListBin,DeviceRange deviceRange){
		StopListBinPage page = navigator.navigateToPage(StopListBinPage.class);
		page.stoplistBin(stopListBin, deviceRange);
	}

}
