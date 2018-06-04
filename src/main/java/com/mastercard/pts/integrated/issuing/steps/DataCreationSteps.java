package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.DataCreationFlows;

@Component
public class DataCreationSteps extends AbstractBaseFlows {

	@Autowired
	DataCreationFlows dataCreationFlows;

	@Autowired
	private PageObjectFactory pageFactory;

	@Autowired
	private Navigator navigator;

	final Logger logger = LoggerFactory.getLogger(DataCreationSteps.class);

	@Then("user should be able to create new Institution")
	public void createNewInstitution() {
		logger.info("user should be able to create new Institution");
		dataCreationFlows.createInstitution();

	}

	@Then("user selects created bank")
	public void giveUserPrivileges() {
		logger.info("user selects created bank");
		dataCreationFlows.defineUserPrivileges();

	}

}
