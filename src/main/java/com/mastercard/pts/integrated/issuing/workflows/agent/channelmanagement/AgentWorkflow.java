package com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Agency;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AgencyUser;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Agent;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AgentUser;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Branch;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.BranchUser;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.CorporateUser;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyEntityCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentEntityCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchEntityCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.CorporateUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AgentWorkflow {
	@Autowired
	private Navigator navigator;

	public void createAgency(Agency agency) {
		AgencyEntityCreatePage page=navigator.navigateToPage(AgencyEntityCreatePage.class);
		page.createAgency(agency);
	}

	public void createBranch(Branch branch) {
		BranchEntityCreatePage page=navigator.navigateToPage(BranchEntityCreatePage.class);
		page.createBranch(branch);
	}

	public void createAgent(Agent agent) {
		AgentEntityCreatePage page=navigator.navigateToPage(AgentEntityCreatePage.class);
		page.createAgent(agent);
	}
	
	public void createAgencyUser(AgencyUser agencyUser) {
		AgencyUserCreatePage page=navigator.navigateToPage(AgencyUserCreatePage.class);
		page.createAgencyUser(agencyUser);
	}
	
	public void createBranchUser(BranchUser bu) {
		BranchUserCreatePage page=navigator.navigateToPage(BranchUserCreatePage.class);
		page.createBranchUser(bu);
	}
	
	public void createAgentUser(AgentUser au) {
		AgentUserCreatePage page=navigator.navigateToPage(AgentUserCreatePage.class);
		page.createAgenctUser(au);
	}
	
	public void createCorporateUser(CorporateUser cu) {
		CorporateUserCreatePage page=navigator.navigateToPage(CorporateUserCreatePage.class);
		page.createCorporateUser(cu);
	}
}
