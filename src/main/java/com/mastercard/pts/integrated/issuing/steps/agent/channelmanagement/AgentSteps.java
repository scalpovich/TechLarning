package com.mastercard.pts.integrated.issuing.steps.agent.channelmanagement;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Agency;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AgencyUser;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Agent;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.AgentUser;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.Branch;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.BranchUser;
import com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement.CorporateUser;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement.AgentWorkflow;

@Component
public class AgentSteps{
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private DataProvider provider;
	
	@Autowired
	private AgentWorkflow agentWorkflow;
	
	@Given("user creates new agent")
	@When("user creates new agent")
	public void givenUserCreatesNewAgent(){
		Agent ag=Agent.createWithProvider(provider);
		agentWorkflow.createAgent(ag);
	}
	@Given("user creates new branch")
	@When("user creates new branch")
	public void givenUserCreatesNewBranch(){
		Branch br=Branch.createWithProvider(provider);
		agentWorkflow.createBranch(br);
	}
	@Given("user creates new agency")
	@When("user creates new agency")
	public void givenUserCreatesNewAgency(){
		Agency agency=Agency.createWithProvider(provider);
		agentWorkflow.createAgency(agency);
	}
	@Given("user creates new agent user")
	@When("user creates new agent user")
	public void givenUserCreatesNewAgentUser(){
		AgentUser agu=AgentUser.createWithProvider(provider);
		agentWorkflow.createAgentUser(agu);
	}
	@Given("user creates new branch user")
	@When("user creates new branch user")
	public void givenUserCreatesNewBranchUser(){
		BranchUser bu=BranchUser.createWithProvider(provider);
		agentWorkflow.createBranchUser(bu);
	}
	@Given("user creates new agency user")
	@When("user creates new agency user")
	public void givenUserCreatesNewAgencyUser(){
		AgencyUser au=AgencyUser.createWithProvider(provider);
		agentWorkflow.createAgencyUser(au);
	}
	@Given("user creates new corportate user")
	@When("user creates new corportate user")
	public void givenUserCreatesNewCorporateUser(){
		CorporateUser cu=CorporateUser.createWithProvider(provider);
		agentWorkflow.createCorporateUser(cu);
	}
}