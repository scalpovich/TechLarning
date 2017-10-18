package com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AssignPrograms;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AssignProgramsAgencyPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AssignProgramsAgentPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AssignProgramsBranchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AssignProgramsWorkflow {
	private AssignProgramsAgencyPage agencyProgram;
	private AssignProgramsBranchPage branchProgram;
	private AssignProgramsAgentPage agentProgram;
	
	@Autowired
	private Navigator navigator;

	public void assignProgramAgency(AssignPrograms details) {
		agencyProgram = navigator.navigateToPage(AssignProgramsAgencyPage.class);
		agencyProgram.assignProgramAgency(details);
	}
	
	public void assignProgramBranch(AssignPrograms details) {
		branchProgram = navigator.navigateToPage(AssignProgramsBranchPage.class);
		branchProgram.assignProgramBranch(details);
	}
	
	public void assignProgramAgent(AssignPrograms details) {
		agentProgram = navigator.navigateToPage(AssignProgramsAgentPage.class);
		agentProgram.assignProgramAgent(details);
	}
	
	public String getAgencyProgramAssignedMessage() {
		return agencyProgram.getAgencyProgramAssignedMessage();
	}
	
	public String getBranchProgramAssignedMessage() {
		return branchProgram.getBranchProgramAssignedMessage();
	}
	
	public String getAgentProgramAssignedMessage() {
		return agentProgram.getAgentProgramAssignedMessage();
	}
}
