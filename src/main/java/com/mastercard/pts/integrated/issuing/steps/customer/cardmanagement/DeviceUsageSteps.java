package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCGLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceUsageWorkflow;

@Component
public class DeviceUsageSteps {
	
	private static final String DOMESTIC = "DOMESTIC";

	private static final String INTERNATIONAL = "INTERNATIONAL";

	private static final String FAILED_MESSAGE_INFO = "Invalid ATC counter ";
	private static final String ATC = "ATC" ;
	
	private static final String DEVICE_USUAGE = "DEVICE_USUAGE";
	
	private static final Logger logger = LoggerFactory.getLogger(DeviceUsageSteps.class);


	@Autowired
	private TestContext context;

	@Autowired
	private DeviceUsageWorkflow deviceUsageWorkflow;

	@Autowired
	private KeyValueProvider provider;

	private MCGLimitPlan mcgLimitPlan;

	private DeviceUsage deviceUsuage;

	private Device device;

	@Then("user searches device on device usage screen and performs assertions on device $tab usage")
	public void whenUserSearchesDeviceOnDeviceUsageScreen(String tab) {
		device = context.get(ContextConstants.DEVICE);
	    deviceUsuage = DeviceUsage.createWithProvider(provider);
		deviceUsageWorkflow.deviceUsageVerification(device.getDeviceNumber(), tab, deviceUsuage);
	}

	@Then("verify the MCG limit utilization in Device Usage Screen for $type transaction after failed transaction")
	public void verifyDeviceUsageAfterFailedTransaction(String type) {
		DecimalFormat df2 = new DecimalFormat("0.00"); 
		mcgLimitPlan = context.get(ContextConstants.MCG_LIMIT_PLAN);
		device = context.get(ContextConstants.DEVICE);
		deviceUsuage = context.get(DEVICE_USUAGE);
		if(deviceUsuage==null){
			deviceUsuage = DeviceUsage.getDeviceUsageDetails(provider);
		}
		deviceUsuage.setDeviceNumber(device.getDeviceNumber());
		deviceUsuage = deviceUsageWorkflow.getWalletMCGUsage(deviceUsuage);

		if (Objects.nonNull(deviceUsuage) && Objects.nonNull(deviceUsuage.getRecordedMCG())) {
			Assert.assertEquals("Error asserting MCG Code", mcgLimitPlan.getMcgCode(), deviceUsuage.getRecordedMCG());
			if (type.equalsIgnoreCase(DOMESTIC)) {
				Assert.assertEquals("Domestic Daily Transaction Amount is changed even after failed transaction", df2.format(deviceUsuage.getPreviousAmountUtilized()), df2.format(Double.parseDouble(deviceUsuage.getDailyAmountDomesticUtilized())));
				Assert.assertEquals("Domestic Periodic Transaction Amount is changed even after failed transaction", df2.format(deviceUsuage.getPreviousAmountUtilized()), df2.format(Double.parseDouble(deviceUsuage.getPeriodAmountDomesticUtilized())));
				Assert.assertEquals("Domestic Daily Transaction velocity is changed even after failed transaction", deviceUsuage.getPreviousVelocityValue(), deviceUsuage.getDailyVelocityDomesticUtilized());
				Assert.assertEquals("Domestic Periodic Transaction velocity is changed even after failed transaction", deviceUsuage.getPreviousVelocityValue(), deviceUsuage.getPeriodVelocityDomesticUtilized());
			} else if (type.equalsIgnoreCase(INTERNATIONAL)) {
				Assert.assertEquals("Internationl Daily Transaction Amount is changed even after failed transaction", df2.format(deviceUsuage.getPreviousAmountUtilized()), df2.format(Double.parseDouble(deviceUsuage.getDailyAmountInternationalUtilized())));
				Assert.assertEquals("Internationl Periodic Transaction Amount is changed even after failed transaction", df2.format(deviceUsuage.getPreviousAmountUtilized()), df2.format(Double.parseDouble(deviceUsuage.getPeriodAmountInternationalUtilized())));
				Assert.assertEquals("Internationl Daily Transaction Velocity is changed even after failed transaction", deviceUsuage.getPreviousVelocityValue(), deviceUsuage.getDailyVelocityInternationalUtilized());
				Assert.assertEquals("Internationl Periodic Transaction Velocity is changed even after failed transaction", deviceUsuage.getPreviousVelocityValue(), deviceUsuage.getPeriodVelocityInternationalUtilized());
			} else {
				Assert.fail("Incorrect transaction type in step");
			}
		} else if(deviceUsuage==null){
			Assert.fail("No Transaction was recorded under MCG usage");
		}
	}
	
	@Then("verify the MCG daily transaction and velocity in Device Usage Screen for $type transactions")
	public void userDeviceUsage(String type) {
		DecimalFormat df2 = new DecimalFormat("0.00"); 
		mcgLimitPlan = context.get(ContextConstants.MCG_LIMIT_PLAN);
		device = context.get(ContextConstants.DEVICE);
		deviceUsuage = context.get(DEVICE_USUAGE);
		if(deviceUsuage==null){
			deviceUsuage = DeviceUsage.getDeviceUsageDetails(provider);
		}
		deviceUsuage.setDeviceNumber(device.getDeviceNumber());
		deviceUsuage = deviceUsageWorkflow.getWalletMCGUsage(deviceUsuage);

		if (Objects.nonNull(deviceUsuage.getRecordedMCG())&&!deviceUsuage.getRecordedMCG().isEmpty()) {
			Assert.assertEquals("Error asserting MCG Code", mcgLimitPlan.getMcgCode(), deviceUsuage.getRecordedMCG());
			if (type.equalsIgnoreCase(DOMESTIC)) {
				Assert.assertEquals("Error asserting Domestic Daily Transaction Amount", df2.format(Double.parseDouble(context.get(ConstantData.TRANSACTION_AMOUNT))), df2.format(Double.parseDouble(deviceUsuage.getDailyAmountDomesticUtilized())-deviceUsuage.getPreviousAmountUtilized()));
				Assert.assertEquals("Error asserting Domestic Periodic Transaction Amount", df2.format(Double.parseDouble(context.get(ConstantData.TRANSACTION_AMOUNT))), df2.format(Double.parseDouble(deviceUsuage.getPeriodAmountDomesticUtilized())-deviceUsuage.getPreviousAmountUtilized()));
				Assert.assertEquals("Error asserting Domestic Daily Velocity", deviceUsuage.getVelocity(), deviceUsuage.getDailyVelocityDomesticUtilized());
				Assert.assertEquals("Error asserting Domestic Periodic Velocity", deviceUsuage.getVelocity(), deviceUsuage.getPeriodVelocityDomesticUtilized());
				deviceUsuage.setPreviousAmountUtilized(Double.parseDouble(deviceUsuage.getDailyAmountDomesticUtilized()));
			} else if (type.equalsIgnoreCase(INTERNATIONAL)) {
				Assert.assertEquals("Error asserting International Daily Transaction Amount", df2.format(Double.parseDouble(context.get(ConstantData.BILLING_AMOUNT))), df2.format(Double.parseDouble(deviceUsuage.getDailyAmountInternationalUtilized())-deviceUsuage.getPreviousAmountUtilized()));
				Assert.assertEquals("Error asserting International Periodic Transaction Amount", df2.format(Double.parseDouble(context.get(ConstantData.BILLING_AMOUNT))), df2.format(Double.parseDouble(deviceUsuage.getPeriodAmountInternationalUtilized())-deviceUsuage.getPreviousAmountUtilized()));
				Assert.assertEquals("Error asserting International Daily Velocity", deviceUsuage.getVelocity(), deviceUsuage.getDailyVelocityInternationalUtilized());
				Assert.assertEquals("Error asserting International Periodic Velocity", deviceUsuage.getVelocity(), deviceUsuage.getPeriodVelocityInternationalUtilized());
				deviceUsuage.setPreviousAmountUtilized(Double.parseDouble(deviceUsuage.getDailyAmountInternationalUtilized()));
			} else {
				Assert.fail("Incorrect transaction type in step");
			}
			deviceUsuage.setPreviousVelocityValue(deviceUsuage.getVelocity());
			deviceUsuage.setVelocity();
			context.put(DEVICE_USUAGE,deviceUsuage);
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


	@Then("user validates device usage for $usageVelocity and $usageAmount")
	public void deviceUsageValidation(String usageVelocity, String usageAmount){
		Device device = context.get(ContextConstants.DEVICE);
		List<Map<String, Double>> lst = deviceUsageWorkflow.getDeviceUsageDetails(device);
		Double velocity = lst.get(0).get(usageVelocity);
		Double amount   = lst.get(0).get(usageAmount);
		assertThat("Verify Device Total and Transaction Usage", lst.get(0), equalTo(lst.get(1)));
		assertThat("Verify Device Velocity ", velocity, equalTo(device.getDeviceVelocity()));
		assertThat("Verify Device Usage Amount", amount, equalTo(device.getDeviceAmountUsage()));
	}
}
