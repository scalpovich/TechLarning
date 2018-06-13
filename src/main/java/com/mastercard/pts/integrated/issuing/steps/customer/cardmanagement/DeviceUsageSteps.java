package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.util.Map;
import java.util.Optional;

import org.jbehave.core.annotations.Then;
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
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceUsageWorklow;

@Component
public class DeviceUsageSteps {

	private static final String DOMESTIC = "DOMESTIC";

	private static final String INTERNATIONAL = "INTERNATIONAL";

	@Autowired
	private TestContext context;

	@Autowired
	private DeviceUsageWorklow deviceUsageWorkflow;

	@Autowired
	KeyValueProvider provider;

	private MCGLimitPlan mcgLimitPlan;

	private DeviceUsage deviceUsage;

	private Device device;

	@Then("user searches device on device usage screen and performs assertions on device tool usage and device transaction usage tabs")
	public void whenUserSearchesDeviceOnDeviceUsageScreen() {
		Device device = context.get(ContextConstants.DEVICE);
		deviceUsageWorkflow.deviceUsageVerification(device.getDeviceNumber());
	}

	@Then("verify the MCG Limit in Device Usage Screen for $type transactions")
	public void userDeviceUsage(String type) {
		mcgLimitPlan = context.get(ContextConstants.MCG_LIMIT_PLAN);
		device = context.get(ContextConstants.DEVICE);
		deviceUsage = DeviceUsage.getDeviceUsageDetails(provider);
		deviceUsage.setDeviceNumber(device.getDeviceNumber());
		Optional<Map<String, String>> data = deviceUsageWorkflow.getWalletMCGUsage(deviceUsage);

		if (data.isPresent()) {
			Assert.assertEquals("Error asserting MCG Code", mcgLimitPlan.getMcgCode(), data.get().get(DeviceUsagePage.MCG_CODE));
			if (type.equalsIgnoreCase(DOMESTIC)) {
				Assert.assertEquals("Error asserting Domestic Transaction Amount", device.getTransactionAmount(), data.get().get(DeviceUsagePage.DAILY_AMOUNT_DOMESTIC_UTILIZED));
				Assert.assertEquals("Error asserting Domestic Velocity", deviceUsage.getVelocity(), data.get().get(DeviceUsagePage.DAILY_VELOCLITY_DOMESTIC_UTILIZED));
			} else if (type.equalsIgnoreCase(INTERNATIONAL)) {
				Assert.assertEquals("Error asserting International Transaction Amount", device.getTransactionAmount(), data.get().get(DeviceUsagePage.DAILY_AMOUNT_INTERNATIONAL_UTILIZED));
				Assert.assertEquals("Error asserting International Velocity", deviceUsage.getVelocity(), data.get().get(DeviceUsagePage.DAILY_VELOCLITY_INTERNATIONAL_UTILIZED));
			} else {
				Assert.fail("Incorrect transaction type in step");
			}
		} else {
			Assert.fail("No Transaction was recorded under MCG usage");
		}

		if (device.getTransactionAmount() != deviceUsage.getNextTransactionAmount()) {
			device.setTransactionAmount(deviceUsage.getNextTransactionAmount());
			deviceUsage.setVelocity();
			context.put(ContextConstants.DEVICE, device);
		}
	}
}