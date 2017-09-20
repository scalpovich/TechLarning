package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentPortalHomePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.workflows.LoginFlows;
import com.mastercard.pts.integrated.issuing.workflows.LogoutFlows;

@Component
public class AgentPortalSignInSteps extends AbstractBaseSteps {
	@Autowired
	LoginFlows loginFlows;

	@Autowired
	LogoutFlows logoutFlows;

	@Autowired
	AgentPortalHomePage agentPortalHomePage;

	final Logger logger = LoggerFactory.getLogger(AgentPortalSignInSteps.class);

	@Given("user login to agent portal with an existing user")
	public void login() {
		loginFlows.loginAsAgentUser();
	}

	@Given("user login to agent portal with $userName and $password")
	public void login(@Named("userName") String userName,
			@Named("password") String password) {
		loginFlows.loginAsAgentUser(userName, password);

	}

	@When("user selects the $language")
	public void selectslanguage(@Named("language") String language) {
		agentPortalHomePage.selectLangDropDown(language);

	}

	@Then("user should be in the home page and check the $institution")
	public void verifyHomepage(@Named("institution") String institution) {
		Constants.variable.put("institute", institution);
		agentPortalHomePage.verifyHomePage();
		agentPortalHomePage.verifyInstitution(institution);
	}

	@Then("user logouts from agent portal")
	public void logout() {
		logoutFlows.logoutAgentUser();
	}

}
