package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePromotionPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DevicePromotionPlanWorkFlow;

@Component
public class DevicePromotionPlanSteps {
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private DevicePromotionPlanWorkFlow workflow;
	
	private DevicePromotionPlan devicePromotionPlan;
	
	private Device device;
	
	@When("user creates device promotion plan code for $productType product")
	public void addDevicePromotionPlan(String productType) {
		devicePromotionPlan = DevicePromotionPlan.createWithProvider(provider);
		devicePromotionPlan.setProductType(ProductType.fromShortName(productType));
		workflow.addNewDevicePromtionPlan(devicePromotionPlan);
		context.put(ContextConstants.DEVICE_PROMOTION, devicePromotionPlan);
	}
	
	@Given("update $type device with promotion plan")
	@When("update $type device with promotion plan")
	@Then("update $type device with promotion plan")
	public void updateDeviceWithPromotionPlan(String type){
		device = context.get(ContextConstants.DEVICE);
		devicePromotionPlan = context.get(ContextConstants.DEVICE_PROMOTION);
		workflow.updateDeviceWithPromotionPlan(device,devicePromotionPlan);
	}
}