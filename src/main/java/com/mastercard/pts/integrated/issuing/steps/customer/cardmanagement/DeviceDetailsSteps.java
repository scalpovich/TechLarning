package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceDetailsFlows;

@Component
public class DeviceDetailsSteps {
	
	@Autowired
	DeviceDetailsFlows detailsFlows;

	
	@Then("assert $lastExecutedScriptStatus status of Last Executed Script Status in Device Details Screen")
	public void thenAssertLastExecutedScriptStatusFromDeviceDetails(String lastExecutedScriptStatus) {
		
		detailsFlows.verifyLastExecutedScriptStatusFromDeviceDetails(lastExecutedScriptStatus);
		
	}

}
