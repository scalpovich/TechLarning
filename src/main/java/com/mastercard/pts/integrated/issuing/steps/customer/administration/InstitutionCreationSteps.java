package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.InstitutionCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
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

	@Autowired
	private KeyValueProvider keyProvider;

	InstitutionCreation instutionCreation;

	UserCreation userCreation;

	private static final String VERIFY_MESSAGE = "Record Updated Successfully.";

	final Logger logger = LoggerFactory.getLogger(InstitutionCreationSteps.class);

	@When("user enters details to create new $institutionType Institution")
	public void createNewInstitution(@Named("Institutetype") String institutionType) {
		logger.info("user should be able to create new Institution");
		instutionCreation = InstitutionCreation.getInstitutionData();
		instutionCreation.setInstitutionType(institutionType);
		instituteCreationflows.institutionCreation(instutionCreation);

	}

	@Then("user should be able to create new institute")
	public void verifyinstitutionCreationSucess() {
		instituteCreationflows.checkSuccessfulInstitutionCreation(instutionCreation);
		context.put(ContextConstants.INSTITUTION, instutionCreation);
	}

	@When("user enter details to create new user")
	public void createNewUser() {
		logger.info("user should be able to create new user");
		userCreation = UserCreation.getUserCreationData();
		InstitutionCreation institute = context
				.get(ContextConstants.INSTITUTION);
		if (!institute.getInstitutionName().isEmpty()) {
			userCreation.setInstitutionName(institute
					.getInstitutionName());
		} else {
			instutionCreation = InstitutionCreation.getInstitutionData();
			userCreation.setInstitutionName(instutionCreation
					.getCreatedInstitution());
		}
		userCreationFlows.createUser(userCreation);
	}

	@Then("user should be able to create new user")
	public void verifyUserCreationSuccess() {
		userCreationFlows.userCreationSuccess(userCreation);
		context.put(ContextConstants.USER, userCreation);
	}

	// Composite Step of Institution and User Creation
	@When("user creates $Prepaid institution and a user")
	@Alias("user creates <Prepaid> institution and a user")
	@Composite(steps = {
			"When user enters details to create new <Prepaid> Institution",
			"Then user should be able to create new institute", "When user enter details to create new user",
			"Then user should be able to create new user" })
	public void createInstitutionAndUser(@Named("Prepaid") String type) {
		logger.info("Creating a new institution and an user");
	}

	@When("admin selects the newly created institution")
	public void selectInstitution() {
		instituteCreationflows.selectNewlyCreatedInstitutionFlows();
	}

	@When("user edits institution to $option two factor authentication with $maskedOption option")
	public void userEditInstitutionAndEnableTwoFactorAuthentication(String option, String maskedOption) {
		InstitutionCreation institutioncreation = InstitutionCreation.getInstitutionData();
		institutioncreation.setAuthenticationFlg(option);
		institutioncreation.setCredentialMasking(maskedOption);
		context.put("institutionData", institutioncreation);
		boolean acsEnable = instituteCreationflows.isAdaptiveAuthenticationEnabledAndUserAbleToSelectACSVendor();
		Assert.assertTrue("Adaptive authentication is not enabled", acsEnable);
	}

	@When("user edits institution to $option two factor authentication")
	public void userEditInstitutionAndEnableTwoFactorAuthentication(String option) {
		InstitutionCreation institutioncreation = InstitutionCreation.getInstitutionData();
		institutioncreation.setAuthenticationFlg(option);
		context.put("institutionData", institutioncreation);
		boolean acsEnable = instituteCreationflows.isAdaptiveAuthenticationEnabledAndUserAbleToSelectACSVendor();
		Assert.assertTrue("Adaptive authentication is not enabled", acsEnable);
	}

	@Then("two factor authentication options are configured")
	public void twoFactorAuthenticationOptionsAreConfigured() {
		boolean RecoredUpdated = context.get("SuccessMessage");
		boolean acsEnable = context.get("authenticationOptionsFlg");
		Assert.assertTrue("Error in configuring two factor authentication options", acsEnable);
		Assert.assertTrue("Error in configuring two factor authentication options", RecoredUpdated);

	}

	@When("user adds the Customer Care International and VIP Number while creating new $institutionType Institute")
	public void addCustomerCareIntlVIPNo(@Named("institutionType") String institutionType) {
		logger.info("user should be able to add the Customer Care International and VIP Number");
		instutionCreation = InstitutionCreation.getInstitutionData();
		instutionCreation.setInstitutionType(institutionType);
		instituteCreationflows.addCustomerCareIntlVIP(instutionCreation);
	}

	@Then("user should be able to add Customer Care International and VIP Number")
	public void validateCustomerCareIntlVIPNo() {
		logger.info("user should be able to add the Customer Care International and VIP Number");
		InstitutionCreation instutionCreation = context.get(ContextConstants.INSTITUTION);
		Assert.assertTrue("Error in adding Customer Care International and VIP Number",
				instituteCreationflows.validateCustomerCareIntlVIP(instutionCreation));
	}

	@When("user updates the Customer Care International and VIP Number while editing Institute")
	public void updateCustomerCareIntlVIPNo() {
		logger.info("user should be able to update the Customer Care International and VIP Number");
		if (context.get(ContextConstants.INSTITUTION) != null) {
			InstitutionCreation institute = context.get(ContextConstants.INSTITUTION);
			instituteCreationflows.updateCustomerCareIntlVIP(institute);
		} else {
			instutionCreation = InstitutionCreation.getInstitutionData();
			instutionCreation.setInstitutionName(instutionCreation.getInstitutionName().substring(0,
					(instutionCreation.getInstitutionName().length() - 2)));
			instituteCreationflows.updateCustomerCareIntlVIP(instutionCreation);
		}
	}

	@Then("Institute should get updated")
	public void VerifyInstitiueUpdate() {
		Assert.assertEquals("Update Verification unsuccessful", instituteCreationflows.verifyInstitiueUpdate(),
				VERIFY_MESSAGE);
	}

}