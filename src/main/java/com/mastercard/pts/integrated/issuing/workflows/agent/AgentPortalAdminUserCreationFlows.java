package com.mastercard.pts.integrated.issuing.workflows.agent;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class AgentPortalAdminUserCreationFlows extends AbstractBaseFlows {

	public void clickChannelManagementMenu() {

		agentPortalAdminUserCreationPage.clickOnChannelManagementMenu();
	}

	public void clickAdminUserCreate() {

		agentPortalAdminUserCreationPage.clickOnAdminLink();
		agentPortalAdminUserCreationPage.clickOnUserLink();
		agentPortalAdminUserCreationPage.clickOnCreateLink();

	}

	public void clickAdminUserEdit() {

		agentPortalAdminUserCreationPage.clickOnAdminLink();
		agentPortalAdminUserCreationPage.clickOnUserLink();
		agentPortalAdminUserCreationPage.clickOnViewLink();

	}

	public void verifyEmailIdAndMobileNumberAreMandatory() {
		agentPortalAdminUserCreationPage.verifyEmailIdMandatory();
		agentPortalAdminUserCreationPage.verifyMobileNumberMandatory();
	}

	public void portalAdminInfo(String roleID, String userID, String userName) {
		agentPortalAdminUserCreationPage.selectRoleID(roleID);
		agentPortalAdminUserCreationPage.enterUserID(userID);
		agentPortalAdminUserCreationPage.enterUserName(userName);
	}

	public void contactInfo(String address, String country, String postalCode,
			String emailID, String language, String isdCode, String mobile) {
		agentPortalAdminUserCreationPage.enterAddress(address);
		agentPortalAdminUserCreationPage.selectCountry(country);
		agentPortalAdminUserCreationPage.enterPostalCode(postalCode);
		agentPortalAdminUserCreationPage.enterEmailID(emailID);
		agentPortalAdminUserCreationPage.selectLanguage(language);
		agentPortalAdminUserCreationPage.selectISDCode(isdCode);
		agentPortalAdminUserCreationPage.enterMobile(mobile);
	}

	public void contactInfo(String address, String country, String postalCode,
			String language, String isdCode) {
		agentPortalAdminUserCreationPage.enterAddress(address);
		agentPortalAdminUserCreationPage.selectCountry(country);
		agentPortalAdminUserCreationPage.enterPostalCode(postalCode);
		agentPortalAdminUserCreationPage.selectLanguage(language);
		agentPortalAdminUserCreationPage.selectISDCode(isdCode);

	}

	public void validateInfo(String emailID, String mobile) {
		agentPortalAdminUserCreationPage.enterEmailID(emailID);
		agentPortalAdminUserCreationPage.enterMobile(mobile);
	}

	public void verifyMessage(String message) {
		agentPortalAdminUserCreationPage.verifySuccessMessage(message);
	}

	public void verifyErrorMessage(String message) {
		agentPortalAdminUserCreationPage.verifyErrorMessage(message);
	}

	public void createUser() {
		agentPortalAdminUserCreationPage.clickOnCreateButton();
	}

	public void enterUserIdAndClickSearchButton(String userID) {
		agentPortalAdminUserCreationPage.enterUserID(userID);
		agentPortalAdminUserCreationPage.clickOnSearchButton();
	}

	public void selectsRecordAndClickOnModifyButton() {
		agentPortalAdminUserCreationPage.clickAdminSearchRsultRecord();
		agentPortalAdminUserCreationPage.clickModifyButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
