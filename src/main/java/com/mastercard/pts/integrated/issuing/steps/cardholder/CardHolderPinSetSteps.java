package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.pinset.CardHolderPinSetWorkflow;

@Component
public class CardHolderPinSetSteps extends AbstractBaseSteps{
	
	@Autowired
	CardHolderPinSetWorkflow cardHolderPinSetWorkflow;
	
	@When ("PIN set request for card")
	public void requestPinSetForDevice(){
		cardHolderPinSetWorkflow.openPinSetPage();
		cardHolderPinSetWorkflow.selectDeviceFromDeviceLst("DeviceForPinSet");
	}
}
