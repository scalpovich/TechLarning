package com.mastercard.pts.integrated.issuing.workflows.agent;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class AgentPortalBranchUserCreationFlows extends AbstractBaseFlows {

	public void clickChannelManagementMenu() {

		agentPortalBranchUserCreationPage.clickOnChannelManagementMenu();
	}

	public void clickBranchUserCreate() {

		agentPortalBranchUserCreationPage.clickOnBranchLink();
		agentPortalBranchUserCreationPage.clickOnUserLink();
		agentPortalBranchUserCreationPage.clickOnCreateLink();

	}

	public void portalBranchInfo(String parentID, String roleID, String userID,
			String userName) {

		agentPortalBranchUserCreationPage.selectParentID(parentID);
		agentPortalBranchUserCreationPage.selectRoleID(roleID);
		agentPortalBranchUserCreationPage.enterUserID(userID);
		agentPortalBranchUserCreationPage.enterUserName(userName);
	}

	public void contactInfo(String address, String country, String postalCode,
			String emailID, String language, String isdCode, String mobile) {
		agentPortalBranchUserCreationPage.enterAddress(address);
		agentPortalBranchUserCreationPage.selectCountry(country);
		agentPortalBranchUserCreationPage.enterPostalCode(postalCode);
		agentPortalBranchUserCreationPage.enterEmailID(emailID);
		agentPortalBranchUserCreationPage.selectLanguage(language);
		agentPortalBranchUserCreationPage.selectISDCode(isdCode);
		agentPortalBranchUserCreationPage.enterMobile(mobile);
	}

	public void contactInfo(String address, String country, String postalCode,
			String language, String isdCode) {
		agentPortalBranchUserCreationPage.enterAddress(address);
		agentPortalBranchUserCreationPage.selectCountry(country);
		agentPortalBranchUserCreationPage.enterPostalCode(postalCode);
		agentPortalBranchUserCreationPage.selectLanguage(language);
		agentPortalBranchUserCreationPage.selectISDCode(isdCode);

	}

	public void validateInfo(String emailID, String mobile) {
		agentPortalBranchUserCreationPage.enterEmailID(emailID);
		agentPortalBranchUserCreationPage.enterMobile(mobile);
	}

	public void verifyMessage(String message) {
		agentPortalBranchUserCreationPage.verifySuccessMessage(message);
	}

	public void verifyErrorMessage(String message) {
		agentPortalBranchUserCreationPage.verifyErrorMessage(message);
	}

	public void createUser() {
		agentPortalBranchUserCreationPage.clickOnCreateButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
