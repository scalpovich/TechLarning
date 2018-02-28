package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceBINFlows;

@Component
public class DeviceBINSteps {
	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	DeviceBin devicebin;

	@Autowired
	DeviceBINFlows deviceBinFlows;

	@Autowired
	TestContext context;

	@When("user creates Device BIN for $network for product $productType for BinType as $BinType")
	public void whenUserCreatesDeviceBINForMastercard(@Named("network") String network, @Named("productType") String productType, @Named("BinType") String BinType) {

		devicebin.devicebinDataProvider();
		devicebin.setInterchange(network);
		devicecreation.setProduct(productType);
		devicebin.setBinType(BinType);
		String IssuerBIN = deviceBinFlows.addDeviceBIN(devicebin, devicecreation);
		context.put(ContextConstants.DEVICE_BIN, IssuerBIN);
		context.put(CreditConstants.DEVICE_BIN, IssuerBIN);
		devicebin.setIssuerBin(IssuerBIN);
	}
}