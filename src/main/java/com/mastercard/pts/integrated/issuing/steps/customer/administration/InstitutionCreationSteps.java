package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.InstitutionCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.InstitutionCreationFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.UserCreationFlows;

@Component
public class InstitutionCreationSteps {

	@Autowired
	private InstitutionCreationFlows instituteCreationflows;
	
	@Autowired
	private TestContext context;

	@Autowired
	private UserCreationFlows userCreationFlows;
	

	InstitutionCreation instutionCreation;
	
	UserCreation userCreation;

	final Logger logger = LoggerFactory
			.getLogger(InstitutionCreationSteps.class);

	@When("user enter details to create new $institutionType Institution")
	public void createNewInstituion(
			@Named("Institutetype") String institutionType) {		
		logger.info("user should be able to create new Institution");		
		instutionCreation = InstitutionCreation.getInstitutionData();
		instutionCreation.setInstitutionType(institutionType);
		instituteCreationflows.institutionCreation(instutionCreation);
				
	}

	@Then("user should be able to create new institute")
	public void verifyinstitutionCreationSucess() {
		instituteCreationflows
				.checkSuccessfullInstitutionCreation(instutionCreation);
		context.put(ContextConstants.INSTITUTION, instutionCreation);
	}

	@When("user enter details to create new user")
	public void createNewUser() {		
		logger.info("user should be able to create new user");	
		userCreation = UserCreation.getUserCreationData();
		if(context.get(ContextConstants.INSTITUTION)!=null){
		InstitutionCreation institute= context.get(ContextConstants.INSTITUTION);
		userCreation.setInstitutionName(institute.getInstitutionAbbrevation());
		}
		else{
			instutionCreation = InstitutionCreation.getInstitutionData();
			userCreation.setInstitutionName(instutionCreation.getCreatedInstitution());
		}
		userCreationFlows.createUser(userCreation);
	}

	@Then("user should be able to create new user")
	public void verifyUserCreationSuccess() {
		userCreationFlows.userCreationSuccess(userCreation);
	}

	// Composite Step of Institution and User Creation
	@When("user creates $Prepaid institution and a user")
	@Alias("user creates <Prepaid> institution and a user")
	@Composite(steps = {
			"When user enter details to create new <Prepaid> Institution",
			"Then user should be able to create new institute",
			"When user enter details to create new user",
			"Then user should be able to create new user" })
	public void createInstitutionAndUser(@Named("Prepaid") String type) {
		logger.info("Creating a new institution and an user");
	}

	@When("admin selects the newly created institution")
	public void selectInstitution() {
		instituteCreationflows.selectNewlyCreatedInstitutionFlows();
	}

}
