package com.mastercard.pts.integrated.issuing.steps.agent;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.agent.AgentPortalAgencyUserCreationFlows;

@Component
public class AgentPortalAgencyUserCreationSteps extends AbstractBaseSteps {

	@Autowired
	AgentPortalAgencyUserCreationFlows agentPortalAgencyUserCreationFlows;

	@When("user clicks on Agency User Create link")
	public void userClicksOnAdminUserCreatelink() {
		agentPortalAgencyUserCreationFlows.clickAgencyUserCreate();
	}

	@Then("user provide Agency $ParentID,$RoleID,$UserID,$UserName")
	public void userProvideRoleIDUserIDUserName(
			@Named("ParentID") String parentID, @Named("RoleID") String roleID,
			@Named("UserID") String userID, @Named("UserName") String userName) {

		agentPortalAgencyUserCreationFlows.portalAgencyInfo(parentID, roleID,
				userID, userName);
	}

	@Then("user enter Agency $Address,$Country,$PostalCode,$PreferredLanguage,$ISDCode")
	public void userEntersAddressCountryPostalCodePreferredLanguageISDCode(
			@Named("Address") String address, @Named("Country") String country,
			@Named("PostalCode") String postalCode,
			@Named("PreferredLanguage") String preferredLanguage,
			@Named("ISDCode") String isdCode) {
		agentPortalAgencyUserCreationFlows.contactInfo(address, country,
				postalCode, preferredLanguage, isdCode);
	}

	@Then("user enters Agency existing $EmailId and unique $MobileNumber")
	public void userEntersExistingEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAgencyUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user enters Agency unique $EmailId and existing $MobileNumber")
	public void userEntersUniqueEmailIdAndExistingMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAgencyUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user enters Agency unique $EmailId and unique $MobileNumber")
	public void userEntersUniqueEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAgencyUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

}