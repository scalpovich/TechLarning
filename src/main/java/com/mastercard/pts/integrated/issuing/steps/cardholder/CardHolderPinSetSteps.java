package com.mastercard.pts.integrated.issuing.steps.cardholder;

import static junit.framework.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
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
		String[] date = devicePlan.getExpiryDate().split("-");
		String day = date[0];
		String year = String.valueOf(date[1].toCharArray()[2])+String.valueOf(date[1].toCharArray()[3]);
		device.setExpirationDate(day.concat(year));
		assertTrue("Error while creating PIN set request", cardHolderPinSetWorkflow.setPinRequest(device).contains("Your transaction is successful"));
	}
}