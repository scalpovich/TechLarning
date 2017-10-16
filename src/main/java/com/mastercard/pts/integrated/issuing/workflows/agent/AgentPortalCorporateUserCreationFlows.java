package com.mastercard.pts.integrated.issuing.workflows.agent;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class AgentPortalCorporateUserCreationFlows extends AbstractBaseFlows {

	public void clickChannelManagementMenu() {

		agentPortalCorporateUserCreationPage.clickOnChannelManagementMenu();
	}

	public void clickCorporateUserCreate() {

		agentPortalCorporateUserCreationPage.clickOnCorporateLink();
		agentPortalCorporateUserCreationPage.clickOnUserLink();
		agentPortalCorporateUserCreationPage.clickOnCreateLink();

	}

	public void portalCorporateInfo(String parentID, String roleID,
			String userID, String userName) {

		agentPortalCorporateUserCreationPage.selectParentID(parentID);
		agentPortalCorporateUserCreationPage.selectRoleID(roleID);
		agentPortalCorporateUserCreationPage.enterUserID(userID);
		agentPortalCorporateUserCreationPage.enterUserName(userName);
	}

	public void contactInfo(String address, String country, String postalCode,
			String emailID, String language, String isdCode, String mobile) {
		agentPortalCorporateUserCreationPage.enterAddress(address);
		agentPortalCorporateUserCreationPage.selectCountry(country);
		agentPortalCorporateUserCreationPage.enterPostalCode(postalCode);
		agentPortalCorporateUserCreationPage.enterEmailID(emailID);
		agentPortalCorporateUserCreationPage.selectLanguage(language);
		agentPortalCorporateUserCreationPage.selectISDCode(isdCode);
		agentPortalCorporateUserCreationPage.enterMobile(mobile);
	}

	public void contactInfo(String address, String country, String postalCode,
			String language, String isdCode) {
		agentPortalCorporateUserCreationPage.enterAddress(address);
		agentPortalCorporateUserCreationPage.selectCountry(country);
		agentPortalCorporateUserCreationPage.enterPostalCode(postalCode);
		agentPortalCorporateUserCreationPage.selectLanguage(language);
		agentPortalCorporateUserCreationPage.selectISDCode(isdCode);

	}

	public void validateInfo(String emailID, String mobile) {
		agentPortalCorporateUserCreationPage.enterEmailID(emailID);
		agentPortalCorporateUserCreationPage.enterMobile(mobile);
	}

	public void verifyMessage(String message) {
		agentPortalCorporateUserCreationPage.verifySuccessMessage(message);
	}

	public void verifyErrorMessage(String message) {
		agentPortalCorporateUserCreationPage.verifyErrorMessage(message);
	}

	public void createUser() {
		agentPortalCorporateUserCreationPage.clickOnCreateButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
