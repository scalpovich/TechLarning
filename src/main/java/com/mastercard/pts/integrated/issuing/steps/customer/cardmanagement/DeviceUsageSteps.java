package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceUsage;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceUsageWorkflow;

@Component
public class DeviceUsageSteps {

	private static final String FAILED_MESSAGE_INFO = "Invalid ATC counter ";
	private static final String ATC = "ATC" ;
	private static final Logger logger = LoggerFactory.getLogger(DeviceUsageSteps.class);


	@Autowired
	private TestContext context;

	@Autowired
	private DeviceUsageWorkflow deviceUsageWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Then("user searches device on device usage screen and performs assertions on device $tab usage")
	public void whenUserSearchesDeviceOnDeviceUsageScreen(String tab) {
		Device device = context.get(ContextConstants.DEVICE);
		DeviceUsage deviceUsage = DeviceUsage.createWithProvider(provider);
		deviceUsageWorkflow.deviceUsageVerification(device.getDeviceNumber(), tab, deviceUsage);
	}

	@When("verify ATC counter getting updated at device usage screen")
	public void thenUserVerifyATCCounter() {
		Device device = context.get(ContextConstants.DEVICE);		
		String  atc = deviceUsageWorkflow.getApplicationTransactionCounterDeviceUsage(device.getDeviceNumber()).get(0);
		boolean condition = atc.equals(returnATCCounterIncreasedByOne());
		assertTrue(FAILED_MESSAGE_INFO+" - Expected: "+returnATCCounterIncreasedByOne()+" Actual  : "+atc, condition);		
		context.put(ATC, atc);	

	}

	@When("user notes down ATC counter on device usage screen")
	public void thenUserNoteDownATCCounter() {
		Device device = context.get(ContextConstants.DEVICE);
		String  atc = deviceUsageWorkflow.getApplicationTransactionCounterDeviceUsage(device.getDeviceNumber()).get(0);
		boolean condition = atc.equals("1");
		assertTrue(FAILED_MESSAGE_INFO+" - Expected: 1 Actual  : "+atc, condition);		
		context.put(ATC, atc);	

	}

	public String returnATCCounterIncreasedByOne() {
		int atc = Integer.parseInt(context.get(ATC)) + 1;		
		return Integer.toString(atc);
	}


	@Then("user validate device usage for $usageVelocity and $usageAmount")
	public void deviceUsageValidation(String usageVelocity, String usageAmount){
		Device device = context.get(ContextConstants.DEVICE);
		List<Map<String, Double>> lst = deviceUsageWorkflow.getDeviceUsageDetails(device);
		Double velocity = lst.get(0).get(usageVelocity);
		Double amount   = lst.get(0).get(usageAmount);
		//Assert.assertEquals(lst.get(0),lst.get(1));
		assertThat("Verify Device Total and Transaction Usage", lst.get(0), equalTo(lst.get(1)));
		assertThat("Verify Device Velocity ", velocity, equalTo(device.getDeviceVelocity()));
		assertThat("Verify Device Usage Amount", amount, equalTo(device.getDeviceAmountUsage()));
	}
}