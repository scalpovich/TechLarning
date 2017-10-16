package com.mastercard.pts.integrated.issuing.workflows.agent;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class AgentPortalAgentUserCreationFlows extends AbstractBaseFlows {

	public void clickChannelManagementMenu() {

		agentPortalAgentUserCreationPage.clickOnChannelManagementMenu();
	}

	public void clickAgentnUserCreate() {

		agentPortalAgentUserCreationPage.clickOnAgentLink();
		agentPortalAgentUserCreationPage.clickOnUserLink();
		agentPortalAgentUserCreationPage.clickOnCreateLink();

	}

	public void portalAgentInfo(String parentID, String roleID, String userID,
			String userName, String trnPassword) {
		agentPortalAgentUserCreationPage.selectParentID(parentID);
		agentPortalAgentUserCreationPage.selectRoleID(roleID);
		agentPortalAgentUserCreationPage.enterUserID(userID);
		agentPortalAgentUserCreationPage.enterUserName(userName);
		agentPortalAgentUserCreationPage.enterTransPassword(trnPassword);

	}

	public void contactInfo(String address, String country, String postalCode,
			String emailID, String language, String isdCode, String mobile) {
		agentPortalAgentUserCreationPage.enterAddress(address);
		agentPortalAgentUserCreationPage.selectCountry(country);
		agentPortalAgentUserCreationPage.enterPostalCode(postalCode);
		agentPortalAgentUserCreationPage.enterEmailID(emailID);
		agentPortalAgentUserCreationPage.selectLanguage(language);
		agentPortalAgentUserCreationPage.selectISDCode(isdCode);
		agentPortalAgentUserCreationPage.enterMobile(mobile);
	}

	public void contactInfo(String address, String country, String postalCode,
			String language, String isdCode) {
		agentPortalAgentUserCreationPage.enterAddress(address);
		agentPortalAgentUserCreationPage.selectCountry(country);
		agentPortalAgentUserCreationPage.enterPostalCode(postalCode);
		agentPortalAgentUserCreationPage.selectLanguage(language);
		agentPortalAgentUserCreationPage.selectISDCode(isdCode);

	}

	public void validateInfo(String emailID, String mobile) {
		agentPortalAgentUserCreationPage.enterEmailID(emailID);
		agentPortalAgentUserCreationPage.enterMobile(mobile);
	}

	public void verifyMessage(String message) {
		agentPortalAgentUserCreationPage.verifySuccessMessage(message);
	}

	public void verifyErrorMessage(String message) {
		agentPortalAgentUserCreationPage.verifyErrorMessage(message);
	}

	public void createUser() {
		agentPortalAgentUserCreationPage.clickOnCreateButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
