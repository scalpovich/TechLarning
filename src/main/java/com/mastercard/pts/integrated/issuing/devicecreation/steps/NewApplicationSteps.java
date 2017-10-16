package com.mastercard.pts.integrated.issuing.devicecreation.steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;  

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.NewApplicationFlows;

// TODO: Auto-generated Javadoc
/**
 * @author E070234 
 */
@Component
public class NewApplicationSteps {

	final Logger logger = LoggerFactory.getLogger(NewApplicationSteps.class);
	@Autowired
	NewApplicationFlows newapplication;

	@When("user navigates to New device in Activity of crad managment tab")
	public void thenUserNavigatesToGeneralInHelpdesk() {
		newapplication.navigateToNewDeviceTab();
	}
	@Then("user creates a new application for Prepaid product type")
	public void thenUsercreatsnewapplication() {
		newapplication.addDetailsOnAddApplicationAcreen();
		newapplication.addDetailsOnBatchAcreen();
		newapplication.addGeneralDetails();
		newapplication.addDeviceInformation();
		newapplication.addProfileInformation();
		newapplication.addAddressInformation();
		newapplication.submitTheForm();
		newapplication.getGeneratedCardDetails();

	}

}
