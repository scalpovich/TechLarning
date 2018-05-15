package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ThreeDECommerceSecurityParameters;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ThreeDECommerceSecurityParametersFlows;

@Component
public class ThreeDEcommerceSecurityParametersSteps {

	@Autowired
	private ThreeDECommerceSecurityParametersFlows threeDECommerceSecurityParametersFlows;
	
	@Autowired
	KeyValueProvider provider;
	@Autowired
	DataProvider jsonProvider;
	
	@Autowired
	private TestContext context;
	
	@When("user adds 3D ecommerce security parameters for $type")
	public void add3DEcommerceSecurityParameters(String type) {
		ThreeDECommerceSecurityParameters threeDECommerceSecurityParameters=ThreeDECommerceSecurityParameters.getThreeDECommerceSecurityData();
		DeviceRange deviceRange=DeviceRange.createWithProvider(jsonProvider,type);
		threeDECommerceSecurityParameters.setDeviceRangeFrom(deviceRange.getIssuerBinCode(deviceRange.getIssuerBin())+ConstantData.START_RANGE_DIGITS);
		threeDECommerceSecurityParameters.setDeviceRangeTo(deviceRange.getIssuerBinCode(deviceRange.getIssuerBin())+ConstantData.END_RANGE_DIGITS);
		threeDECommerceSecurityParametersFlows.add3DEcommerceSecurityParameters(threeDECommerceSecurityParameters);
	}

}