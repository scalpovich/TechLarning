package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.pinset.CardHolderPinSetWorkflow;

@Component
public class CardHolderPinSetSteps extends AbstractBaseSteps{
	
	@Autowired
	CardHolderPinSetWorkflow cardHolderPinSetWorkflow;
	
	@Autowired
	private TestContext context;
	
	@Then ("PIN set request for card")
	@When ("PIN set request for card")
	public void requestPinSetForDevice(){
		Device device = context.get(ContextConstants.DEVICE);
		DevicePlan devicePlan = context.get(ContextConstants.DEVICE_PLAN);
		device.setPinNumberForTransaction(ConstantData.DEFAULT_PIN);
		device.setExpirationDate(devicePlan.getValidityOnInitialMonths().replace("-20", ""));
		Assert.assertTrue("Error while creating PIN set request", cardHolderPinSetWorkflow.setPinRequest(device).contains("Your transaction is successful"));
	}
}