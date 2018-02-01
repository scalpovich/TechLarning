package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCardPackTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.workflows.CardPackIdFlows;

@Component
public class CardPackIdSteps {

	@Autowired
	CardPackIdFlows cardpackidflows;

	@Autowired
	DeviceCardPackTemplate cardpackid;

	@Autowired
	DeviceCreation devicecreation;

	@Then("Pack Id should be generated as per the template configured")
	@When("Pack Id should be generated as per the template configured")
	public void thenPackIdShouldBeGeneratedAsPerTheTemplateConfigured() {
		cardpackid.setCardpackID(cardpackidflows.getCardPackId(devicecreation));
	}

	@When("user retrieves the device number from the query")
	public void deviceNumberFromQuery() {
		devicecreation.setDeviceNumberFromQuery(cardpackidflows.DeviceNumber(devicecreation));

	}

	@When("user verifies the Pre generated flag at device level should be set to $flag once the device created")
	@Then("user verifies the Pre generated flag at device level should be set to $flag once the device created")
	public void checkPreGeneratedFlag(@Named("flag") String flag) {
		devicecreation.setPreGeneratedCardFlag(flag);
		cardpackidflows.verifyPreGeneratedFlag(devicecreation);
		// cardpackidflows.PreGeneratedCard(devicecreation);
	}
}