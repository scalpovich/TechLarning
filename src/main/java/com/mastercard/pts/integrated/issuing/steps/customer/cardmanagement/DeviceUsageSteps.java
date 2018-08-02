package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Optional;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceUsage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCGLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceUsagePage;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceUsageWorkflow;

@Component
public class DeviceUsageSteps {

	private static final String DOMESTIC = "DOMESTIC";

	private static final String INTERNATIONAL = "INTERNATIONAL";

	private static final String FAILED_MESSAGE_INFO = "Invalid ATC counter ";
	private static final String ATC = "ATC" ;
	public static final String DEVICE_USUAGE = "DEVICE_USUAGE";
	
	private static int previousAmountUtilized =0;
	
	@Autowired
	private TestContext context;

	@Autowired
	private DeviceUsageWorkflow deviceUsageWorkflow;

	@Autowired
	KeyValueProvider provider;

	private MCGLimitPlan mcgLimitPlan;

	private DeviceUsage deviceUsage;

	private Device device;

	@Then("user searches device on device usage screen and performs assertions on device $tab usage")
	public void whenUserSearchesDeviceOnDeviceUsageScreen(String tab) {
		device = context.get(ContextConstants.DEVICE);
	    deviceUsage = DeviceUsage.createWithProvider(provider);
		deviceUsageWorkflow.deviceUsageVerification(device.getDeviceNumber(), tab, deviceUsage);
	}
	
	@Then("user searches device on device usage screen and performs assertions on device tool usage and device transaction usage tabs")
	public void whenUserSearchesDeviceOnDeviceUsageScreen() {
	    device = context.get(ContextConstants.DEVICE);
		deviceUsageWorkflow.deviceUsageVerification(device.getDeviceNumber());
	}

	@Then("verify the MCG daily transaction in Device Usage Screen for $type transactions")
	public void userDeviceUsage(String type) {
		mcgLimitPlan = context.get(ContextConstants.MCG_LIMIT_PLAN);
		device = context.get(ContextConstants.DEVICE);
		deviceUsage = DeviceUsage.getDeviceUsageDetails(provider);
		deviceUsage.setDeviceNumber(device.getDeviceNumber());
		Optional<Map<String, String>> data = deviceUsageWorkflow.getWalletMCGUsage(deviceUsage);

		if (data.isPresent()) {
			Assert.assertEquals("Error asserting MCG Code", mcgLimitPlan.getMcgCode(), data.get().get(DeviceUsagePage.MCG_CODE));
			if (type.equalsIgnoreCase(DOMESTIC)) {
				Assert.assertEquals("Error asserting Domestic Transaction Amount", context.get(ConstantData.TRANSACTION_AMOUNT), Integer.toString(Integer.parseInt(data.get().get(DeviceUsagePage.DAILY_AMOUNT_DOMESTIC_UTILIZED))-previousAmountUtilized));
				Assert.assertEquals("Error asserting Domestic Velocity", deviceUsage.getVelocity(), data.get().get(DeviceUsagePage.DAILY_VELOCLITY_DOMESTIC_UTILIZED));
				previousAmountUtilized = Integer.parseInt(data.get().get(DeviceUsagePage.DAILY_AMOUNT_DOMESTIC_UTILIZED));
			} else if (type.equalsIgnoreCase(INTERNATIONAL)) {
				Assert.assertEquals("Error asserting International Transaction Amount", context.get(ConstantData.BILLING_AMOUNT), Integer.toString(Integer.parseInt(data.get().get(DeviceUsagePage.DAILY_AMOUNT_INTERNATIONAL_UTILIZED))-previousAmountUtilized));
				Assert.assertEquals("Error asserting International Velocity", deviceUsage.getVelocity(), data.get().get(DeviceUsagePage.DAILY_VELOCLITY_INTERNATIONAL_UTILIZED));
				previousAmountUtilized = Integer.parseInt(data.get().get(DeviceUsagePage.DAILY_AMOUNT_INTERNATIONAL_UTILIZED));
			} else {
				Assert.fail("Incorrect transaction type in step");
			}
			device.setTransactionAmount(deviceUsage.getNextTransactionAmount());
			context.put(ContextConstants.DEVICE, device);
		} else {
			Assert.fail("No Transaction was recorded under MCG usage");
		}
	}
	
	@Then("verify the MCG daily velocity in Device Usage Screen for $type transactions")
	public void userDeviceUsageDailyVelocity(String type) {
		mcgLimitPlan = context.get(ContextConstants.MCG_LIMIT_PLAN);
		device = context.get(ContextConstants.DEVICE);
		if(context.get(DEVICE_USUAGE)==null){
		deviceUsage = DeviceUsage.getDeviceUsageDetails(provider);
		deviceUsage.setDeviceNumber(device.getDeviceNumber());
		}
		Optional<Map<String, String>> data = deviceUsageWorkflow.getWalletMCGUsage(deviceUsage);

		if (data.isPresent()) {
			Assert.assertEquals("Error asserting MCG Code", mcgLimitPlan.getMcgCode(), data.get().get(DeviceUsagePage.MCG_CODE));
			if (type.equalsIgnoreCase(DOMESTIC)) {
				Assert.assertEquals("Error asserting Domestic Transaction Amount", context.get(ConstantData.TRANSACTION_AMOUNT), Integer.toString(Integer.parseInt(data.get().get(DeviceUsagePage.DAILY_AMOUNT_DOMESTIC_UTILIZED))-previousAmountUtilized));
				Assert.assertEquals("Error asserting Domestic Velocity", deviceUsage.getVelocity(), data.get().get(DeviceUsagePage.DAILY_VELOCLITY_DOMESTIC_UTILIZED));
				previousAmountUtilized = Integer.parseInt(data.get().get(DeviceUsagePage.DAILY_AMOUNT_DOMESTIC_UTILIZED));
			} else if (type.equalsIgnoreCase(INTERNATIONAL)) {
				Assert.assertEquals("Error asserting International Transaction Amount", context.get(ConstantData.BILLING_AMOUNT), Integer.toString(Integer.parseInt(data.get().get(DeviceUsagePage.DAILY_AMOUNT_INTERNATIONAL_UTILIZED))-previousAmountUtilized));
				Assert.assertEquals("Error asserting International Velocity", deviceUsage.getVelocity(), data.get().get(DeviceUsagePage.DAILY_VELOCLITY_INTERNATIONAL_UTILIZED));
				previousAmountUtilized = Integer.parseInt(data.get().get(DeviceUsagePage.DAILY_AMOUNT_INTERNATIONAL_UTILIZED));
			} else {
				Assert.fail("Incorrect transaction type in step");
			}
			DeviceUsage.setVelocity();
		} else {
			Assert.fail("No Transaction was recorded under MCG usage");
		}
	}
	
	@When("verify ATC counter getting updated at device usage screen")
	public void thenUserVerifyATCCounter() {
	    device = context.get(ContextConstants.DEVICE);		
		String  atc = deviceUsageWorkflow.getApplicationTransactionCounterDeviceUsage(device.getDeviceNumber()).get(0);
		boolean condition = atc.equals(returnATCCounterIncreasedByOne());
		assertTrue(FAILED_MESSAGE_INFO+" - Expected: "+returnATCCounterIncreasedByOne()+" Actual  : "+atc, condition);		
		context.put(ATC, atc);	

	}
	
	@When("user notes down ATC counter on device usage screen")
	public void thenUserNoteDownATCCounter() {
	    device = context.get(ContextConstants.DEVICE);
		String  atc = deviceUsageWorkflow.getApplicationTransactionCounterDeviceUsage(device.getDeviceNumber()).get(0);
		boolean condition = atc.equals("1");
		assertTrue(FAILED_MESSAGE_INFO+" - Expected: 1 Actual  : "+atc, condition);		
		context.put(ATC, atc);	
		
	}
	
	public String returnATCCounterIncreasedByOne() {
		int atc = Integer.parseInt(context.get(ATC)) + 1;		
		return Integer.toString(atc);
	}
}
