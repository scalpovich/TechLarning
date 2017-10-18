package com.mastercard.pts.integrated.issuing.workflows.agent.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.agent.AgentHomePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class HomeWorkflow {
	
	@Autowired
	private PageObjectFactory pageFactory;
	
	@Autowired
	private Navigator navigator;

	public void onAgentPortal() {
		AgentHomePage page = pageFactory.getPage(AgentHomePage.class);
		page.onAgentPortal();
	}
}
