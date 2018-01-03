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
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AssignPrograms;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement.AssignProgramsWorkflow;

@Component
public class AssignProgramsSteps {
	private static final String PROGRAM_ASSIGNED_MESSAGE ="Program/Device type assigned successfully";
	@Autowired
	private TestContext context;
	
	@Autowired
	private AssignProgramsWorkflow assignProgramsWorkflow;

	@Autowired
	private KeyValueProvider provider;
	
	@Given("bulk card generation for prepaid $deviceType is completed for visa interface")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product",
			"When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product",
			"When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product",
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card",
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"User fills Device Range section for prepaid product for visa interface",
			"When user creates a bulk device production request for prepaid",
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid",
			"When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid"})
	public void givenBulkCardGenerationForPrepaidIsCompletedVisaInterface(String deviceType){
		/*
		 * This is a composite step to be executed before assigning a program
		 */
	}
	
	@Given("bulk card generation for prepaid $deviceType is completed")
	@Composite(steps = { "When User fills Statement Message Plan for prepaid product",
			"When User fills Marketing Message Plan for prepaid product",
			"When User fills Prepaid Statement Plan",
			"When User fills MCC Rules for prepaid product",
			"When User fills Dedupe Plan",
			"When User fills Transaction Plan for prepaid product",
			"When User fills Transaction Limit Plan for prepaid product",
			"When User fills Document Checklist Screen for prepaid product",
			"When User fills Device Joining and Membership Fee Plan for prepaid product",
			"When User fills Device Event Based Fee Plan for prepaid product",
			"When User fills Device Plan for \"prepaid\" \"<deviceType>\" card",
			"When User fills Wallet Plan for prepaid product",
			"When User fills Program section for prepaid product",
			"When User fills Business Mandatory Fields Screen for prepaid product",
			"When User fills Device Range section for prepaid product",
			"When user creates a bulk device production request for prepaid",
			"When processes created bulk device generation request for prepaid",
			"When processes pre-production batch for prepaid",
			"When processes device production batch for prepaid",
			"When processes pin generation batch for prepaid"})
	public void givenBulkCardGenerationForPrepaidIsCompleted(String deviceType){
		/*
		 * This is a composite step to be executed before assigning a program
		 */
	}
	
	@Given("user fills information to assign program to agency and submits form")
	@When("user fills information to assign program to agency and submits form")
	public void whenUserFillsInformationToAssignProgramToAgencyAndSubmitsForm(){
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		assignProgramsWorkflow.assignProgramAgency(details);
	}
	
	@Then("program assigned to agency successfully")
	public void thenProgramAssignedToAgencySuccessfully(){
		assertThat("Assigning Program to Agency Failed", assignProgramsWorkflow.getAgencyProgramAssignedMessage(), containsString(PROGRAM_ASSIGNED_MESSAGE));
	}
	
	@Given("user fills information to assign program to branch and submits form")
	@When("user fills information to assign program to branch and submits form")
	public void whenUserFillsInformationToAssignProgramToBranchAndSubmitsForm(){
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		assignProgramsWorkflow.assignProgramBranch(details);
	}
	
	@Then("program assigned to branch successfully")
	public void thenProgramAssignedToBranchSuccessfully(){
		assertThat("Assigning Program to Branch Failed", assignProgramsWorkflow.getBranchProgramAssignedMessage(), containsString(PROGRAM_ASSIGNED_MESSAGE));
	}
	
	@Given("user fills information to assign program to agent and submits form")
	@When("user fills information to assign program to agent and submits form")
	public void whenUserFillsInformationToAssignProgramToAgentAndSubmitsForm(){
		Program program = context.get(ContextConstants.PROGRAM);
		AssignPrograms details = AssignPrograms.createWithProvider(provider);
		details.setProgramCode(program.buildDescriptionAndCode());
		assignProgramsWorkflow.assignProgramAgent(details);
	}
	
	@Then("program assigned to agent successfully")
	public void thenProgramAssignedToAgentSuccessfully(){
		assertThat("Assigning Program to Agent Failed", assignProgramsWorkflow.getAgentProgramAssignedMessage(), containsString(PROGRAM_ASSIGNED_MESSAGE));
	}
	
}
