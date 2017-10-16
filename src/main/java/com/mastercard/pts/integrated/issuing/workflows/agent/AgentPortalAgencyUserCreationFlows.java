package com.mastercard.pts.integrated.issuing.workflows.agent;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class AgentPortalAgencyUserCreationFlows extends AbstractBaseFlows {

	public void clickChannelManagementMenu() {

		agentPortalAgencyUserCreationPage.clickOnChannelManagementMenu();
	}

	public void clickAgencyUserCreate() {

		agentPortalAgencyUserCreationPage.clickOnAgencyLink();
		agentPortalAgencyUserCreationPage.clickOnUserLink();
		agentPortalAgencyUserCreationPage.clickOnCreateLink();

	}

	public void portalAgencyInfo(String parentID, String roleID, String userID,
			String userName) {
		agentPortalAgencyUserCreationPage.selectParentID(parentID);
		agentPortalAgencyUserCreationPage.selectRoleID(roleID);
		agentPortalAgencyUserCreationPage.enterUserID(userID);
		agentPortalAgencyUserCreationPage.enterUserName(userName);

	}

	public void contactInfo(String address, String country, String postalCode,
			String emailID, String language, String isdCode, String mobile) {
		agentPortalAgencyUserCreationPage.enterAddress(address);
		agentPortalAgencyUserCreationPage.selectCountry(country);
		agentPortalAgencyUserCreationPage.enterPostalCode(postalCode);
		agentPortalAgencyUserCreationPage.enterEmailID(emailID);
		agentPortalAgencyUserCreationPage.selectLanguage(language);
		agentPortalAgencyUserCreationPage.selectISDCode(isdCode);
		agentPortalAgencyUserCreationPage.enterMobile(mobile);
	}

	public void contactInfo(String address, String country, String postalCode,
			String language, String isdCode) {
		agentPortalAgencyUserCreationPage.enterAddress(address);
		agentPortalAgencyUserCreationPage.selectCountry(country);
		agentPortalAgencyUserCreationPage.enterPostalCode(postalCode);
		agentPortalAgencyUserCreationPage.selectLanguage(language);
		agentPortalAgencyUserCreationPage.selectISDCode(isdCode);

	}

	public void validateInfo(String emailID, String mobile) {
		agentPortalAgencyUserCreationPage.enterEmailID(emailID);
		agentPortalAgencyUserCreationPage.enterMobile(mobile);
	}

	public void verifyMessage(String message) {
		agentPortalAgencyUserCreationPage.verifySuccessMessage(message);
	}

	public void verifyErrorMessage(String message) {
		agentPortalAgencyUserCreationPage.verifyErrorMessage(message);
	}

	public void createUser() {
		agentPortalAgencyUserCreationPage.clickOnCreateButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
