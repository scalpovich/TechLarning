package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ThreeDECommerceSecurityParameters;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ThreeDECommerceSecurityParametersFlows;

@Component
public class ThreeDEcommerceSecurityParametersSteps {

	@Autowired
	private ThreeDECommerceSecurityParametersFlows threeDECommerceSecurityParametersFlows;
	
	@Autowired
	KeyValueProvider provider;
	
	@Autowired
	private TestContext context;
	
	@When("add 3D ecommerce security parameters")
	public void add3DEcommerceSecurityParameters() {
		ThreeDECommerceSecurityParameters threeDECommerceSecurityParameters=ThreeDECommerceSecurityParameters.getThreeDECommerceSecurityData(provider);
		DeviceRange deviceRange=context.get("Device_Range_Data");
		threeDECommerceSecurityParameters.setDeviceRangeFrom(deviceRange.getIssuerBin()+deviceRange.getFromDeviceNumber());
		threeDECommerceSecurityParameters.setDeviceRangeTo(deviceRange.getIssuerBin()+deviceRange.getToDeviceNumber());
		threeDECommerceSecurityParametersFlows.add3DEcommerceSecurityParameters(threeDECommerceSecurityParameters);
	
	}

}