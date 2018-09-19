package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
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
	
	private static double previousAmountUtilized =0.00;
	
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

	@Then("verify the MCG limit utilization in Device Usage Screen for $type transaction after failed transaction")
	public void verifyDeviceUsageAfterFailedTransactuon(String type) {
		DecimalFormat df2 = new DecimalFormat("0.00"); 
		mcgLimitPlan = context.get(ContextConstants.MCG_LIMIT_PLAN);
		device = context.get(ContextConstants.DEVICE);
		deviceUsage = context.get(DEVICE_USUAGE);
		if(deviceUsage==null){
		deviceUsage = DeviceUsage.getDeviceUsageDetails(provider);}
		deviceUsage.setDeviceNumber(device.getDeviceNumber());
		deviceUsage = deviceUsageWorkflow.getWalletMCGUsage(deviceUsage);

		if (Objects.nonNull(deviceUsage.getRecordedMCG())&&!deviceUsage.getRecordedMCG().isEmpty()) {
			Assert.assertEquals("Error asserting MCG Code", mcgLimitPlan.getMcgCode(), deviceUsage.getRecordedMCG());
			if (type.equalsIgnoreCase(DOMESTIC)) {
				Assert.assertEquals("Domestic Daily Transaction Amount is changed even after failed transaction", df2.format(deviceUsage.getPreviousTransactionValue()), df2.format(Double.parseDouble(deviceUsage.getDailyAmountDomesticUtilized())));
				Assert.assertEquals("Domestic Periodic Transaction Amount is changed even after failed transaction", df2.format(deviceUsage.getPreviousTransactionValue()), df2.format(Double.parseDouble(deviceUsage.getPeriodAmountDomesticUtilized())));
				Assert.assertEquals("Domestic Daily Transaction velocity is changed even after failed transaction", deviceUsage.getPreviousVelocityValue(), deviceUsage.getDailyVelocityDomesticUtilized());
				Assert.assertEquals("Domestic Periodic Transaction velocity is changed even after failed transaction", deviceUsage.getPreviousVelocityValue(), deviceUsage.getPeriodVelocityDomesticUtilized());
			} else if (type.equalsIgnoreCase(INTERNATIONAL)) {
				Assert.assertEquals("Internationl Daily Transaction Amount is changed even after failed transaction", df2.format(Double.parseDouble(context.get(ConstantData.BILLING_AMOUNT))), df2.format(Double.parseDouble(deviceUsage.getDailyAmountIntenationalUtilized())));
				Assert.assertEquals("Internationl Periodic Transaction Amount is changed even after failed transaction", df2.format(Double.parseDouble(context.get(ConstantData.BILLING_AMOUNT))), df2.format(Double.parseDouble(deviceUsage.getPeriodAmountIntenationalUtilized())));
				Assert.assertEquals("Internationl Daily Transaction Velocity is changed even after failed transaction", deviceUsage.getVelocity(), deviceUsage.getDailyVelocityIntenationalUtilized());
				Assert.assertEquals("Internationl Periodic Transaction Velocity is changed even after failed transaction", deviceUsage.getVelocity(), deviceUsage.getPeriodVelocityIntenationalUtilized());
			} else {
				Assert.fail("Incorrect transaction type in step");
			}
		} else {
			Assert.fail("No Transaction was recorded under MCG usage");
		}
	}
	
	@Then("verify the MCG daily transaction and velocity in Device Usage Screen for $type transactions")
	public void userDeviceUsage(String type) {
		DecimalFormat df2 = new DecimalFormat("0.00"); 
		mcgLimitPlan = context.get(ContextConstants.MCG_LIMIT_PLAN);
		device = context.get(ContextConstants.DEVICE);
		deviceUsage = context.get(DEVICE_USUAGE);
		if(deviceUsage==null){
		deviceUsage = DeviceUsage.getDeviceUsageDetails(provider);}
		deviceUsage.setDeviceNumber(device.getDeviceNumber());
		deviceUsage = deviceUsageWorkflow.getWalletMCGUsage(deviceUsage);

		if (Objects.nonNull(deviceUsage.getRecordedMCG())&&!deviceUsage.getRecordedMCG().isEmpty()) {
			Assert.assertEquals("Error asserting MCG Code", mcgLimitPlan.getMcgCode(), deviceUsage.getRecordedMCG());
			if (type.equalsIgnoreCase(DOMESTIC)) {
				Assert.assertEquals("Error asserting Domestic Daily Transaction Amount", df2.format(Double.parseDouble(context.get(ConstantData.TRANSACTION_AMOUNT))), df2.format(Double.parseDouble(deviceUsage.getDailyAmountDomesticUtilized())-previousAmountUtilized));
				Assert.assertEquals("Error asserting Domestic Periodic Transaction Amount", df2.format(Double.parseDouble(context.get(ConstantData.TRANSACTION_AMOUNT))), df2.format(Double.parseDouble(deviceUsage.getPeriodAmountDomesticUtilized())-previousAmountUtilized));
				Assert.assertEquals("Error asserting Domestic Daily Velocity", deviceUsage.getVelocity(), deviceUsage.getDailyVelocityDomesticUtilized());
				Assert.assertEquals("Error asserting Domestic Periodic Velocity", deviceUsage.getVelocity(), deviceUsage.getPeriodVelocityDomesticUtilized());
				previousAmountUtilized = Double.parseDouble(deviceUsage.getDailyAmountDomesticUtilized());
			} else if (type.equalsIgnoreCase(INTERNATIONAL)) {
				Assert.assertEquals("Error asserting International Daily Transaction Amount", df2.format(Double.parseDouble(context.get(ConstantData.BILLING_AMOUNT))), df2.format(Double.parseDouble(deviceUsage.getDailyAmountIntenationalUtilized())-previousAmountUtilized));
				Assert.assertEquals("Error asserting International Periodic Transaction Amount", df2.format(Double.parseDouble(context.get(ConstantData.BILLING_AMOUNT))), df2.format(Double.parseDouble(deviceUsage.getPeriodAmountIntenationalUtilized())-previousAmountUtilized));
				Assert.assertEquals("Error asserting International Daily Velocity", deviceUsage.getVelocity(), deviceUsage.getDailyVelocityIntenationalUtilized());
				Assert.assertEquals("Error asserting International Periodic Velocity", deviceUsage.getVelocity(), deviceUsage.getPeriodVelocityIntenationalUtilized());
				previousAmountUtilized = Double.parseDouble(deviceUsage.getDailyAmountIntenationalUtilized());
			} else {
				Assert.fail("Incorrect transaction type in step");
			}
			deviceUsage.setPreviousTransactionValue(context.get(ConstantData.TRANSACTION_AMOUNT));
			deviceUsage.setPreviousVelocityValue(deviceUsage.getVelocity());
			deviceUsage.setVelocity();
			context.put(DEVICE_USUAGE,deviceUsage);
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
