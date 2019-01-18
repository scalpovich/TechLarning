package com.mastercard.pts.integrated.issuing.workflows.cardholder.pinset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.cardholder.pinset.DevicePinSetPage;
@Component
public class CardHolderPinSetWorkflow extends AbstractBaseFlows {

		
	@Autowired
	Navigator navigation;	
	
	@Autowired
	DevicePinSetPage devicePinSetpage;
	
	public String setPinRequest(Device device){
		DevicePinSetPage page = navigation.navigateToPage(DevicePinSetPage.class);	
		return page.setPinForDevice(device);
	}	
}
