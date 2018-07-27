package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePromotionPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DevicePromotionPlanWorkFlow;

@Component
public class DevicePromotionPlanSteps {
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private KeyValueProvider provider;

	private DevicePromotionPlan devicePromotionPlan;
	
	@Autowired
	private DevicePromotionPlanWorkFlow workflow;
	
	@When("user creates device promotion plan code for $productType product")
	public void addDevicePromotionPlan(String productType) {
		devicePromotionPlan = DevicePromotionPlan.createWithProvider(provider);
		devicePromotionPlan.setProductType(ProductType.fromShortName(productType));
		workflow.addNewDevicePromtionPlan(devicePromotionPlan);
	}
}