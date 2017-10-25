package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.administration.CustomerPortalUserCreationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.CustomerPortalUserCreationFlows;

@Component
public class CustomerPortalUserCreationSteps extends AbstractBaseFlows {

	@Autowired
	Navigator navigator;
	@Autowired
	CustomerPortalUserCreationFlows customerPortalUserCreationFlows;

	final Logger logger = LoggerFactory
			.getLogger(CustomerPortalUserCreationSteps.class);

	@Given("user is logged to Customer Portal")
	public void userIsLoggedToCustomerPortal() {

		customerPortalUserCreationFlows.verifyTitle();
	}

	@When("user navigates to Administration page")
	public void navigateToAdministrationPage() {
		logger.info("user navigates to Administration page");
		CustomerPortalUserCreationPage page = navigator
				.navigateToPage(CustomerPortalUserCreationPage.class);

	}

	@When("user provides $UserID, $UserName, $Role, $LanguagePreference, $TimeZone")
	public void useruserIDuserNameroleIDlanguagePreferencetimeZone(
			@Named("UserID") String userID, @Named("UserName") String userName,
			@Named("Role") String role,
			@Named("LanguagePreference") String languagePreference,
			@Named("TimeZone") String timeZone) {

		customerPortalUserCreationFlows.clickOnAddRecordButtonAndSwithFrame();
		customerPortalUserCreationFlows
				.verifyEmailIdAndMobileNumberAreMandatory();
		customerPortalUserCreationFlows.userInfo(userID, userName, role,
				languagePreference, timeZone);

	}

	@When("user provides existing $EmailId, $CountryCode and unique $MobileNumber")
	public void userEntersExistingEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("CountryCode") String countryCode,
			@Named("MobileNumber") String mobileNumber) {
		customerPortalUserCreationFlows.validateInfo(emailId, countryCode,
				mobileNumber);

	}

	@When("user provides unique $EmailId, $CountryCode and existing $MobileNumber")
	public void userEntersUniqueEmailIdAndExistingMobileNumber(
			@Named("EmailId") String emailId,
			@Named("CountryCode") String countryCode,
			@Named("MobileNumber") String mobileNumber) {
		customerPortalUserCreationFlows.validateInfo(emailId, countryCode,
				mobileNumber);
	}

	@When("user provides unique $EmailId, $CountryCode and unique $MobileNumber")
	public void userEntersUniqueEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("CountryCode") String countryCode,
			@Named("MobileNumber") String mobileNumber) {
		customerPortalUserCreationFlows.validateInfo(emailId, countryCode,
				mobileNumber);
	}

	@When("user also provides $UserAccountExpiryDate, $ConcurrentLoginAllowed, $MaximumConcurrentUser")
	public void userAccountExpiryDateConcurrentLoginAllowedMaximumConcurrentUser(
			@Named("UserAccountExpiryDate") String userAccountExpiryDate,
			@Named("ConcurrentLoginAllowed") String concurrentLoginAllowed,
			@Named("MaximumConcurrentUser") String maximumConcurrentUser) {
		customerPortalUserCreationFlows.additionalInfo(userAccountExpiryDate,
				concurrentLoginAllowed, maximumConcurrentUser);
	}

	@When("user checks the desired institution for newly created user")
	public void userSelectsTheDesiredInstitution() {
		customerPortalUserCreationFlows.selectTheDesiredInstitution();
		customerPortalUserCreationFlows.createUser();
	}

	@Then("user should get created with successful $Message")
	public void userShouldGetSuccessfulMessage(@Named("Message") String message) {
		customerPortalUserCreationFlows.verifyMessage(message);
		customerPortalUserCreationFlows.validateUser();
	}

	@Then("user should be able to see error $Message")
	public void userShouldGetErrorMessage(@Named("Message") String message) {
		customerPortalUserCreationFlows.verifyErrorMessage(message);
	}

}
