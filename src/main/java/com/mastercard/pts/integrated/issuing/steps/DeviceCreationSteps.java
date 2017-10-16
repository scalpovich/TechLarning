package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.DeviceCreationFlows;
import com.mastercard.pts.integrated.issuing.workflows.PrepaidDeviceFileEmbossingFlows;

@Component
public class DeviceCreationSteps {

	@Autowired
	DeviceCreationFlows deviceCreationFlows;

	@Autowired
	PrepaidDeviceFileEmbossingFlows prepaiddeviceFileEmbossingFlows;
	//
	// @Autowired
	// CustomUtils customutils;

	@When("user creates a new $device with the required configuration")
	public void createNewDevice(@Named("device") String deviceType) throws InterruptedException {

		if (deviceType.equalsIgnoreCase("Debitdevice")) {
			prepaiddeviceFileEmbossingFlows.createNewDevice();
		}
		if (deviceType.equalsIgnoreCase("Prepaiddevice")) {
			deviceCreationFlows.createNewPrepaidDevice();
		}

		// prepaiddeviceFileEmbossingFlows.createNewDevice();
		deviceCreationFlows.addNewDevice();

	}

	@Then("device should get generated with the device number")
	public void generateDeviceNumber() {

	}

}
