package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceEventBasedFeePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceEventBasedFeePlanFlows;

@Component
public class DeviceEventBasedFeePlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	DeviceEventBasedFeePlanFlows deviceEventBasedflows;

	private DeviceEventBasedFeePlan deviceEventBasedPlan;
	
	@Autowired
	private KeyValueProvider provider;

	@When("user creates Device Event Based Fee Plan for $product")
	public void whenUserCreatesDeviceEventBasedFeePlanForPrepaid(@Named("product") String product) {
		deviceEventBasedPlan = DeviceEventBasedFeePlan.deviceeventbasedfeeplanDataProvider();
		deviceCreation.setProduct(product);
		deviceEventBasedflows.createDeviceEventBasedFeePlan(deviceCreation, deviceEventBasedPlan);
	}
	
	@When("user saves the fees applied for $Reason on device based event fee plan for $cardType card")
	public void savesRelacementFees(@Named("Reason") String reason, @Named("cardType") String cardType){
		deviceEventBasedPlan = DeviceEventBasedFeePlan.createWithProvider(provider);
		deviceEventBasedflows.saveFeesForDeviceEvents(deviceEventBasedPlan, reason, cardType);
	}
}