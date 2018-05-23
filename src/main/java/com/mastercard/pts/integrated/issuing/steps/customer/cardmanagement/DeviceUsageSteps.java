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

	@Autowired
	private TestContext context;

	@Autowired
	private DeviceUsageWorklow deviceUsageWorkflow;
	
	@Autowired
	KeyValueProvider provider;
	
	private MCGLimitPlan mcgLimitPlan;
	
    private DeviceUsage deviceUsage;

	@Then("user searches device on device usage screen and performs assertions on device tool usage and device transaction usage tabs")
	public void whenUserSearchesDeviceOnDeviceUsageScreen() {
		Device device = context.get(ContextConstants.DEVICE);
//		deviceUsageWorkflow.deviceUsageVerification("5887651326558415");
		deviceUsageWorkflow.deviceUsageVerification(device.getDeviceNumber());
		}
	@Then("verify the MCG Limit in Device Usage Screen")
	public void userDeviceUsage(){
		mcgLimitPlan = context.get(ContextConstants.MCG_LIMIT_PLAN);
		deviceUsage = DeviceUsage.getDeviceUsageDetails(provider);
		deviceUsage.setVelocity("1");
		Optional<Map<String,String>> data = deviceUsageWorkflow.getWalletMCGUsage();
		if(data.isPresent()){
		Assert.assertEquals(mcgLimitPlan.getMcgCode(),data.get().get(DeviceUsagePage.MCG_CODE));
		Assert.assertEquals(deviceUsage.getTransactionAmount(),data.get().get(DeviceUsagePage.DAILY_AMOUNT_DOMESTIC_UTILIZED));
		Assert.assertEquals(deviceUsage.getVelocity(),data.get().get(DeviceUsagePage.DAILY_VELOCLITY_DOMESTIC_UTILIZED));
		}
		else
			Assert.assertTrue("No Transaction was recored under MCG usuage", data.isPresent());
	}
	
}