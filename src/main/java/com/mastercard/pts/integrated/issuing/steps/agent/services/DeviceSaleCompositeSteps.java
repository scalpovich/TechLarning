package com.mastercard.pts.integrated.issuing.steps.agent.services;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

@Component
public class DeviceSaleCompositeSteps {

	@When("user onboard the Device through Agent Portal and Activate through HelpDesk")
	@Then("user onboard the Device through Agent Portal and Activate through HelpDesk")
	@Composite(steps = { "Given user is logged in agent portal as admin user",
			"When user assigns the program to agency and submits form",
			"When user assigns the program to branch and submits form",
			"When user assigns the program to agent and submits form", "Then user sign out from agent portal",
			"Given user is logged in agent portal as agency user",
			"When user enters order details and submits the form", "Then user sign out from agent portal",
			"Given login to portal as existing bank as a Customeruser",
			"When user fills quantity to be dispatched and submits the form", "Then user logouts from customer portal",
			"Given user is logged in agent portal as agency user",
			"When user fills the order acceptance details and submits the form", "Then user sign out from agent portal",
			"Given user is logged in agent portal as agent user", "When user enters program details with registration",
			"When user fills card sale checker details and submits the form", "Then approval is successful",
			"Then user sign out from agent portal" })
	public void deviceOnBoardThroughAgentPortal() {
		System.out.println("Inside the device On boarding through Agnet Portal and Activation through HelpDesk");
	}

	@When("user activates the device through helpdesk")
	@Then("user activates the device through helpdesk")
	@Composite(steps = { "Given user is logged in institution", "When user navigates to General in Helpdesk",
			"And user search for device on search screen for product type prepaid",
			"And user select the service code as Activate Device", "And user activates the device through HelpDesk",
			"Then activation of registered device prepaid is successful and activation date is updated" })
	public void deviceActivationonCSR() {
		System.out.println("Inside the device activation through helpDesk");
	}
}
