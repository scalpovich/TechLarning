package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.workflows.DeviceBINFlows;
import com.mastercard.pts.integrated.issuing.workflows.DeviceCreationFlows;
import com.mastercard.pts.integrated.issuing.workflows.NetworkMembershipFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class RupayBINSteps extends AbstractBaseSteps {

	@Autowired
	DeviceCreationFlows devicecreationflows;

	@Autowired
	DeviceBINFlows devicebinflows;

	@Autowired
	NetworkMembershipFlows networkflows;

	@Autowired
	NetworkMembershipFlows networkmembershipflows;

	@When("user access the device bin screen")
	public void accessDeviceBIN() {
		devicecreationflows.addDeviceBIN();
		devicebinflows.editIssuerBIN();
		devicebinflows.issuerBINValidation();
		devicebinflows.deleteIssuerBIN();

	}

	@Then("the user should be able to configure the bin for the newly added Rupay Network")
	public void addBINRupayNetwork() {
		devicecreationflows.addDeviceBIN();
		networkflows.verifyMessage("Add", Constants.Record_Added_Successfully);

	}

}
