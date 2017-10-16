package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBIN;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceBINFlows;

@Component
public class DeviceBINSteps {
	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	DeviceBIN devicebin;

	@Autowired
	DeviceBINFlows deviceBinFlows;

	@When("user creates Device BIN for $network for product $productType for BinType as $BinType")
	public void whenUserCreatesDeviceBINForMastercard(@Named("network") String network,
			@Named("productType") String productType, @Named("BinType") String BinType) {
		devicebin.devicebinDataProvider();
		devicebin.setInterchange(network);
		devicecreation.setProduct(productType);
		devicebin.setBinType(BinType);
		String IssuerBIN = deviceBinFlows.addDeviceBIN(devicebin, devicecreation);
		devicebin.setIssuerBin(IssuerBIN);
	}
}