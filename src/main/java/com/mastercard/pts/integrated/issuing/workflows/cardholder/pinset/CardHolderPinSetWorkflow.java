package com.mastercard.pts.integrated.issuing.workflows.cardholder.pinset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.cardholder.pinset.DevicePinSetPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class CardHolderPinSetWorkflow extends AbstractBaseFlows {

		
	@Autowired
	Navigator navigation;
	
	
	@Autowired
	DevicePinSetPage devicePinSetpage;
	
	public void openPinSetPage(){
		navigation.navigateToPage(DevicePinSetPage.class);
	}
	
	public void selectDeviceFromDeviceLst(String deviceFrPinSet){
		devicePinSetpage.selectDeviceForPinSet("Device_Number");
	}
	
	
}
