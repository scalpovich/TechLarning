package com.mastercard.pts.integrated.issuing.steps.agent;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.agent.AgentPortalBranchUserCreationFlows;

@Component
public class AgentPortalBranchUserCreationSteps extends AbstractBaseSteps {

	@Autowired
	AgentPortalBranchUserCreationFlows agentPortalBranchUserCreationFlows;

	@When("user clicks on Branch User Create link")
	public void userClicksOnBranchUserCreatelink() {
		agentPortalBranchUserCreationFlows.clickBranchUserCreate();
	}

	@Then("user provide Branch User's $ParentID,$RoleID,$UserID and $UserName")
	public void userProvideRoleIDUserIDAndUserName(
			@Named("ParentID") String parentID, @Named("RoleID") String roleID,
			@Named("UserID") String userID, @Named("UserName") String userName) {

		agentPortalBranchUserCreationFlows.portalBranchInfo(parentID, roleID,
				userID, userName);
	}

	@Then("user enter the Branch User's $Address,$Country,$PostalCode,$EmailId,$PreferredLanguage,$ISDCode and $MobileNumber")
	public void userEntersAddressCountryPostalCodeEmailIdPreferredLanguageISDCodeAndMobileNumber(
			@Named("Address") String address, @Named("Country") String country,
			@Named("PostalCode") String postalCode,
			@Named("EmailId") String emailId,
			@Named("PreferredLanguage") String preferredLanguage,
			@Named("ISDCode") String isdCode,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalBranchUserCreationFlows.contactInfo(address, country,
				postalCode, emailId, preferredLanguage, isdCode, mobileNumber);
	}

	@Then("user enters Branch User's $Address,$Country,$PostalCode,$PreferredLanguage and $ISDCode")
	public void userEntersAddressCountryPostalCodePreferredLanguageAndISDCode(
			@Named("Address") String address, @Named("Country") String country,
			@Named("PostalCode") String postalCode,
			@Named("PreferredLanguage") String preferredLanguage,
			@Named("ISDCode") String isdCode) {
		agentPortalBranchUserCreationFlows.contactInfo(address, country,
				postalCode, preferredLanguage, isdCode);
	}

	@Then("user enters Branch User's existing $EmailId and unique $MobileNumber")
	public void userEntersExistingEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalBranchUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user enters Branch User's unique $EmailId and existing $MobileNumber")
	public void userEntersUniqueEmailIdAndExistingMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalBranchUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user enters Branch User's unique $EmailId and unique $MobileNumber")
	public void userEntersUniqueEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalBranchUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

}