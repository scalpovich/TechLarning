package com.mastercard.pts.integrated.issuing.workflows;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

@Component
public class CustomerPortalUserCreationFlows extends AbstractBaseFlows {

	public void verifyTitle() {
		customerPortalUserCreationPage.verifyHomePage();
	}

	public void clickOnAdministratorSetUpUser() {

		customerPortalUserCreationPage.clickOnAdministrator();
		customerPortalUserCreationPage.clickOnSetUp();
		customerPortalUserCreationPage.clickOnUser();

	}

	public void clickOnAddRecordButtonAndSwithFrame() {

		customerPortalUserCreationPage.clickOnAddRecordButton();
		customerPortalUserCreationPage.switchToAddUserFrame();

	}

	public void verifyEmailIdAndMobileNumberAreMandatory() {
		customerPortalUserCreationPage.verifyEmailIdMandatory();
		customerPortalUserCreationPage.verifyMobileNumberMandatory();
	}

	public void userInfo(String userID, String userName, String roleID,
			String languagePreference, String timeZone) {
		customerPortalUserCreationPage.enterUserID(userID);
		customerPortalUserCreationPage.enterUserName(userName);
		customerPortalUserCreationPage.selectRoleID(roleID);
		customerPortalUserCreationPage
				.selectLanguagePreference(languagePreference);
		customerPortalUserCreationPage.selectTimeZone(timeZone);
	}

	public void validateInfo(String emailID, String countryCode, String mobile) {
		customerPortalUserCreationPage.enterEmailID(emailID);
		customerPortalUserCreationPage.selectCountryCode(countryCode);
		customerPortalUserCreationPage.enterMobile(mobile);
	}

	public void additionalInfo(String userAccountExpiryDate,
			String concurrentLoginAllowed, String maximumConcurrentUser) {
		customerPortalUserCreationPage
				.enterUserAccountExpiryDate(userAccountExpiryDate);
		customerPortalUserCreationPage
				.selectConcurrentLoginAllowed(concurrentLoginAllowed);
		customerPortalUserCreationPage
				.enterMaximumConcurrentUser(maximumConcurrentUser);

	}

	public void selectTheDesiredInstitution() {
		customerPortalUserCreationPage.clickAssignInstitution();
		customerPortalUserCreationPage.clickDefaultInstitutio();

	}

	public void createUser() {
		customerPortalUserCreationPage.clickOnSaveButton();
	}

	public void verifyMessage(String message) {
		customerPortalUserCreationPage.frameSwitchingToDefault();
		customerPortalUserCreationPage.verifySuccessMessage(message);
	}

	public void verifyErrorMessage(String message) {
		customerPortalUserCreationPage.verifyErrorMessage(message);
		customerPortalUserCreationPage.clickOnCancelButton();
		customerPortalUserCreationPage.frameSwitchingToDefault();
	}

	public void validateUser() {
		customerPortalUserCreationPage.verifyUser();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
