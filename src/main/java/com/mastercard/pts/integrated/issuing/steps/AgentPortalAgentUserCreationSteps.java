package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AgentPortalAgentUserCreationFlows;

@Component
public class AgentPortalAgentUserCreationSteps extends AbstractBaseSteps {

	@Autowired
	AgentPortalAgentUserCreationFlows agentPortalAgentUserCreationFlows;

	@When("user clicks on Agent User Create link")
	public void userClicksOnAdminUserCreatelink() {
		agentPortalAgentUserCreationFlows.clickAgentnUserCreate();
	}

	@Then("user provide Agent $ParentID,$RoleID,$UserID,$UserName,$TrnPassword")
	public void userProvideRoleIDUserIDUserName(
			@Named("ParentID") String parentID, @Named("RoleID") String roleID,
			@Named("UserID") String userID, @Named("UserName") String userName,
			@Named("TrnPassword") String trnPassword) {

		agentPortalAgentUserCreationFlows.portalAgentInfo(parentID, roleID,
				userID, userName, trnPassword);
	}

	@Then("user enters $Addres,$Country,$PostalCode,$PreferredLanguage,$ISDCode for Agent users")
	public void userEntersAddressCountryPostalCodePreferredLanguageISDCode(
			@Named("Address") String address, @Named("Country") String country,
			@Named("PostalCode") String postalCode,
			@Named("PreferredLanguage") String preferredLanguage,
			@Named("ISDCode") String isdCode) {
		agentPortalAgentUserCreationFlows.contactInfo(address, country,
				postalCode, preferredLanguage, isdCode);
	}

	@Then("user enters Agent existing $EmailId and unique $MobileNumber")
	public void userEntersExistingEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAgentUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user enters Agent unique $EmailId and existing $MobileNumber")
	public void userEntersUniqueEmailIdAndExistingMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAgentUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

	@Then("user enters Agent unique $EmailId and unique $MobileNumber")
	public void userEntersUniqueEmailIdAndUniqueMobileNumber(
			@Named("EmailId") String emailId,
			@Named("MobileNumber") String mobileNumber) {
		agentPortalAgentUserCreationFlows.validateInfo(emailId, mobileNumber);
	}

}