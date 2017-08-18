package com.mastercard.pts.integrated.issuing.steps.agent.home;

import org.jbehave.core.annotations.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.agent.home.HomeWorkflow;

@Component
public class HomeSteps {
	
	@Autowired
	private HomeWorkflow homeWorkflow;
	
	@Given("user is on agent portal page")
	public void givenUserIsOnAgentPortalPage(){
		homeWorkflow.onAgentPortal();
	}

}
