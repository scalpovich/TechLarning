package com.mastercard.pts.integrated.issuing.steps.agent.channelmanagement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CardType;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AssignPrograms;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement.AssignProgramsWorkflow;

@Component
public class AssignProgramsSteps {
	private static final String PROGRAM_ASSIGNED_MESSAGE = "Program/Device type assigned successfully";
	@Autowired
	private TestContext context;

	@Autowired
	private AssignProgramsWorkflow assignProgramsWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	DevicePlan devicePlan;

	@Given("bulk card generation for prepaid $deviceType is completed for an interface")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product",
			"When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product",
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card",
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product for an interface",
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product for an interface",
			"When user creates a bulk device production request for prepaid",
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid", "When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid" })
	public void givenBulkCardGenerationForPrepaidIsCompletedAnInterface(String deviceType) {
		/*
		 * This is a composite step to be executed before assigning a program
		 */
	}

	@Given("bulk card generation for prepaid $deviceType is completed")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product",
			"When User fills Marketing Message Plan for prepaid product", "When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product", "When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product",
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card",
			"When User fills Wallet Plan for prepaid product", "When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product",
			"When user assigns service code to program",
			"When user creates a bulk device production request for prepaid",
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid", "When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid" })
	public void givenBulkCardGenerationForPrepaidIsCompleted(String deviceType) {
		/*
		 * This is a composite step to be executed before assigning a program
		 */
	}

	@Given("user assigns the program to agency and submits form")
	@When("user assigns the program to agency and submits form")
	public void whenUserAssignsProgramToAgencyAndSubmitsForm() {
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		details.setDeviceType(CardType.fromShortName(devicePlan.getDeviceType()));
		// details.setProgramCode("EmvProgram [5274]");
		assignProgramsWorkflow.assignProgramAgency(details);
	}

	@Given("user fills information to assign program to agency and submits form")
	@When("user fills information to assign program to agency and submits form")
	public void whenUserFillsInformationToAssignProgramToAgencyAndSubmitsForm() {
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		assignProgramsWorkflow.assignProgramAgency(details);
	}

	@Given("program assigned to agency successfully")
	@When("program assigned to agency successfully")
	@Then("program assigned to agency successfully")
	public void thenProgramAssignedToAgencySuccessfully() {
		assertThat("Assigning Program to Agency Failed", assignProgramsWorkflow.getAgencyProgramAssignedMessage(),
				containsString(PROGRAM_ASSIGNED_MESSAGE));
	}

	@Given("user assigns the program to branch and submits form")
	@When("user assigns the program to branch and submits form")
	public void whenAssignProgramToBranchAndSubmitsForm() {
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		details.setDeviceType(CardType.fromShortName(devicePlan.getDeviceType()));
		assignProgramsWorkflow.assignProgramBranch(details);
	}

	@Given("user fills information to assign program to branch and submits form")
	@When("user fills information to assign program to branch and submits form")
	public void whenUserFillsInformationToAssignProgramToBranchAndSubmitsForm() {
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		assignProgramsWorkflow.assignProgramBranch(details);
	}

	@When("program assigned to branch successfully")
	@Then("program assigned to branch successfully")
	public void thenProgramAssignedToBranchSuccessfully() {
		assertThat("Assigning Program to Branch Failed", assignProgramsWorkflow.getBranchProgramAssignedMessage(),
				containsString(PROGRAM_ASSIGNED_MESSAGE));
	}

	@Given("user assigns the program to agent and submits form")
	@When("user assigns the program to agent and submits form")
	public void whenUserAssignProgramToAgentAndSubmitsForm() {
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		details.setDeviceType(CardType.fromShortName(devicePlan.getDeviceType()));
		assignProgramsWorkflow.assignProgramAgent(details);
	}

	@Given("user fills information to assign program to agent and submits form")
	@When("user fills information to assign program to agent and submits form")
	public void whenUserFillsInformationToAssignProgramToAgentAndSubmitsForm() {
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		assignProgramsWorkflow.assignProgramAgent(details);
	}
	
	@When("program assigned to agent successfully")
	@Then("program assigned to agent successfully")
	public void thenProgramAssignedToAgentSuccessfully() {
		assertThat("Assigning Program to Agent Failed", assignProgramsWorkflow.getAgentProgramAssignedMessage(),
				containsString(PROGRAM_ASSIGNED_MESSAGE));
	}

}
