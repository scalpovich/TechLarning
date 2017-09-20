package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AgentPortalAdminUserCreationFlows;

@Component
public class AgentPortalAdminUserCreationSteps extends AbstractBaseSteps {

	@Autowired
	AgentPortalAdminUserCreationFlows agentPortalAdminUserCreationFlows;

	@Given("that user is on channelManagement Page")
	public void thatUserIsOnChannelManagementPage() {
		agentPortalAdminUserCreationFlows.clickChannelManagementMenu();
	}

	@When("user clicks on Admin User Create link")
	public void userClicksOnAdminUserCreatelink() {
		agentPortalAdminUserCreationFlows.clickAdminUserCreate();
	}

	@When("user clicks on Admin User Edit link")
	public void userClicksOnAdminUserEditlink() {
		agentPortalAdminUserCreationFlows.clickAdminUserEdit();
	}

	@When("user enters $userId and click on search button")
	public void userEnterUserIdAndClicksOnSearchButton(
			@Named("UserID") String userID) {

		agentPortalAdminUserCreationFlows
				.enterUserIdAndClickSearchButton(userID);
	}

	@When("user clicks on record and click on modify button")
	public void userClicksOnRecordAndClickOnModifyBtn() {

		agentPortalAdminUserCreationFlows.selectsRecordAndClickOnModifyButton();
	}

	@Then("user checks if EmailId and MobileNumber are mandatory")
	public void userChecksIfEmailIdAndMobileNumberAreMandatory() {
		agentPortalAdminUserCreationFlows
				.verifyEmailIdAndMobileNumberAreMandatory();
	}

	@Then("user provides $RoleID,$UserID,$UserName")
	public void userProvideRoleIDUserIDUserName(@Named("RoleID") String roleID,
			@Named("UserID") String userID, @Named("UserName") String userName) {

		agentPortalAdminUserCreationFlows.portalAdminInfo(roleID, userID,
				userName);
	}

	@Then("user enter the $Address,$Country,$PostalCode,$EmailId,$PreferredLanguage,$ISDCode,$MobileNumber")
	public void userEntersAddressCountryPostalCodeEmailIdPreferredLanguageISDCodeMobileNumber(
			@Named("Address") String address, @Named("Country") String country,
			@Named("PostalCode") String postalCode,
			@Named("EmailId") String emailId,
			@Named("PreferredLanguage") String preferredLanguage,
			@Named("ISDCode") String isdCode,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAdminUserCreationFlows.contactInfo(address, country,
				postalCode, emailId, preferredLanguage, isdCode, mobileNumber);
	}

	@Then("user enters $Address,$Country,$PostalCode,$PreferredLanguage,$ISDCode")
	public void userEntersAddressCountryPostalCodePreferredLanguageISDCode(
			@Named("Address") String address, @Named("Country") String country,
			@Named("PostalCode") String postalCode,
			@Named("PreferredLanguage") String preferredLanguage,
			@Named("ISDCode") String isdCode) {
		agentPortalAdminUserCreationFlows.contactInfo(address, country,
				postalCode, preferredLanguage, isdCode);
	}

	@Then("user enters existing $EmailId and unique $MobileNumber")
	public void userEntersExistingEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAdminUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user enters unique $EmailId and existing $MobileNumber")
	public void userEntersUniqueEmailIdAndExistingMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAdminUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user enters unique $EmailId and unique $MobileNumber")
	public void userEntersUniqueEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAdminUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user clicks on create button")
	public void thenUserClickOnCreateButton() {
		agentPortalAdminUserCreationFlows.createUser();
	}

	@Then("user should get the successful $Message")
	public void userShouldGetSuccessfulMessage(@Named("Message") String message) {
		agentPortalAdminUserCreationFlows.verifyMessage(message);
	}

	@Then("user should get the error $Message")
	public void userShouldGetErrorMessage(@Named("Message") String message) {
		agentPortalAdminUserCreationFlows.verifyErrorMessage(message);
	}

}