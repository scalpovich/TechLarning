package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.testing.mtaf.bindings.drivers.MastercardWebDriverProvider;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AgentPortalAdminUserCreationPage extends AbstractBasePage {
	final Logger logger = LoggerFactory
			.getLogger(AgentPortalAdminUserCreationPage.class);
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='admin']")
	private MCWebElement channelManagementLink;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='portaladminli']")
	private MCWebElement channelManagemenAdmin;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='portaladminuserli']")
	private MCWebElement channelManagementAdminUser;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='createportaladminuserli']/a")
	private MCWebElement channelManagementAdminUserCreate;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='viewportaladminuserli']/a")
	private MCWebElement channelManagementAdminUserView;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='roleID']")
	private MCWebElement channelManagementAdminRoleIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userID']")
	private MCWebElement channelManagementAdminEnterUserID;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userName']")
	private MCWebElement channelManagementAdminEnterUserName;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='address1']")
	private MCWebElement channelManagementAdminEnterAddress;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='country']")
	private MCWebElement channelManagementAdminSelectCountry;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='PINCode']")
	private MCWebElement channelManagementAdminEnterZipCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='state']")
	private MCWebElement channelManagementAdminEnterState;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='city']")
	private MCWebElement channelManagementAdminEnterCity;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='emailId']")
	private MCWebElement channelManagementAdminEnterEmail;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='preferredLanguage']")
	private MCWebElement channelManagementAdminSelectLanguage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='isdCode']")
	private MCWebElement channelManagementAdminSelectISDCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='mobileNo']")
	private MCWebElement channelManagementAdminEnterMobile;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='submitBtn']")
	private MCWebElement channelManagementAdminClickCreateBtn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='SuccessMessageTxt']")
	private MCWebElement channelManagementAdminUserCreationMessage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='ResponseTxt']")
	private MCWebElement channelManagementAdminUserCreationErroMessage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@id='dataTable']//tr[@class='odd']")
	private MCWebElement channelManagementAdminUserSearchResult;
	@PageElement(findBy = FindBy.ID, valueToFind = "userID")
	private MCWebElement channelManagementAdminUserSearch;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_activateSuspendBranch_search")
	private MCWebElement channelManagementAdminUserSearchBtn;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_button_modify")
	private MCWebElement channelManagementAdminUserModifyBtn;

	private By mobileNoLocator = By.xpath("//input[@id='mobileNo']");
	private By emailIdLocator = By.xpath("//input[@id='emailId']");

	@Autowired
	protected MastercardWebDriverProvider webFramework;

	@Autowired
	protected DateUtils date;

	String modifiedNumber;
	String modifiedEmailID;
	String modifiedUserID;

	public void clickOnChannelManagementMenu() {

		waitForElementVisible(channelManagementLink);

		channelManagementLink.click();
	}

	public void clickOnAdminLink() {
		waitForElementVisible(channelManagemenAdmin);

		channelManagemenAdmin.click();
	}

	public void clickOnUserLink() {
		waitForElementVisible(channelManagementAdminUser);

		channelManagementAdminUser.click();
	}

	public void clickOnCreateLink() {
		waitForElementVisible(channelManagementAdminUserCreate);

		channelManagementAdminUserCreate.click();
	}

	public void clickOnViewLink() {
		waitForElementVisible(channelManagementAdminUserView);

		channelManagementAdminUserView.click();
	}

	public void selectRoleID(String roleID) {
		waitForElementVisible(channelManagementAdminRoleIDSelect);
		try {
			channelManagementAdminRoleIDSelect.getSelect().selectByVisibleText(
					roleID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Role ID: ", e);
			channelManagementAdminRoleIDSelect.getSelect().selectByIndex(1);
		}
	}

	public void enterUserID(String userID) {

		waitForElementVisible(channelManagementAdminEnterUserID);
		if ("UniqueUserID".equalsIgnoreCase(userID)) {

			modifiedUserID = "User" + date.getDateMMDDFormat();
			channelManagementAdminEnterUserID.sendKeys(modifiedUserID);

		} else if ("PreviousUserID".equalsIgnoreCase(userID)) {

			channelManagementAdminEnterUserID.sendKeys(modifiedUserID);
		} else {
			channelManagementAdminEnterUserID.sendKeys(userID);
		}
	}

	public void enterUserName(String userName) {

		waitForElementVisible(channelManagementAdminEnterUserName);
		channelManagementAdminEnterUserName.sendKeys(userName);
	}

	public void enterAddress(String address) {
		waitForElementVisible(channelManagementAdminEnterAddress);
		channelManagementAdminEnterAddress.sendKeys(address);
	}

	public void selectCountry(String country) {
		waitForElementVisible(channelManagementAdminSelectCountry);
		channelManagementAdminSelectCountry.getSelect().selectByVisibleText(
				country);

	}

	public void enterPostalCode(String postalCode) {
		waitForElementVisible(channelManagementAdminEnterZipCode);
		channelManagementAdminEnterZipCode.sendKeys(postalCode);
		Constants.variable.put("postalCode", postalCode);

	}

	public void enterState(String postalCode) {
		waitForElementVisible(channelManagementAdminEnterState);

		WebElement state = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='stateField']"));
		List<WebElement> values = state.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementAdminEnterState);
			channelManagementAdminEnterState.sendKeys("TestState");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementAdminEnterState.getAttribute("title")
					.contains("Select"))

			{
				waitForElementVisible(channelManagementAdminEnterZipCode);
				channelManagementAdminEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				waitForElementVisible(channelManagementAdminEnterZipCode);
				channelManagementAdminEnterZipCode.sendKeys(postalCode);
				state.sendKeys(Keys.TAB);
			}

		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterCity(String postalCode) {
		waitForElementVisible(channelManagementAdminEnterCity);

		WebElement city = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='cityField']"));
		List<WebElement> values = city.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementAdminEnterCity);
			channelManagementAdminEnterCity.sendKeys("TestCity");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementAdminEnterCity.getAttribute("title").contains(
					"Select"))

			{
				waitForElementVisible(channelManagementAdminEnterZipCode);
				channelManagementAdminEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				waitForElementVisible(channelManagementAdminEnterZipCode);
				channelManagementAdminEnterZipCode.sendKeys(postalCode);
				city.sendKeys(Keys.TAB);
			}
		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterEmailID(String emailID) {
		waitForElementVisible(channelManagementAdminEnterEmail);

		if ("UniqueEmail".equalsIgnoreCase(emailID)) {
			modifiedEmailID = "Auto" + date.getDateMMDDFormat() + "@gmail.com";
			channelManagementAdminEnterEmail.sendKeys(modifiedEmailID);
		} else if ("PreviousEmail".equalsIgnoreCase(emailID)) {

			channelManagementAdminEnterEmail.sendKeys(modifiedEmailID);
		} else {
			channelManagementAdminEnterEmail.sendKeys(emailID);
		}
		CustomUtils.ThreadDotSleep(5000);
	}

	public void selectLanguage(String language) {
		waitForElementVisible(channelManagementAdminSelectLanguage);
		channelManagementAdminSelectLanguage.getSelect()
				.selectByValue(language);

	}

	public void selectISDCode(String isdCode) {
		waitForElementVisible(channelManagementAdminSelectISDCode);
		channelManagementAdminSelectISDCode.getSelect().selectByVisibleText(
				isdCode);
	}

	public void enterMobile(String mobile) {

		waitForElementVisible(channelManagementAdminEnterMobile);
		if ("UniqueMobile".equalsIgnoreCase(mobile)) {

			modifiedNumber = date.getDateMMDDFormat();
			channelManagementAdminEnterMobile.sendKeys(modifiedNumber);
		} else if ("PreviousMobile".equalsIgnoreCase(mobile)) {

			channelManagementAdminEnterMobile.sendKeys(modifiedNumber);
		} else {
			channelManagementAdminEnterMobile.sendKeys(mobile);
		}
		CustomUtils.ThreadDotSleep(5000);
	}

	public void clickOnCreateButton() {
		waitForElementVisible(channelManagementAdminClickCreateBtn);
		channelManagementAdminClickCreateBtn.click();
	}

	public void clickOnSearchButton() {
		waitForElementVisible(channelManagementAdminUserSearchBtn);
		channelManagementAdminUserSearchBtn.click();
	}

	public void clickAdminSearchRsultRecord() {
		waitForElementVisible(channelManagementAdminUserSearchResult);
		channelManagementAdminUserSearchResult.click();
	}

	public void clickModifyButton() {
		waitForElementVisible(channelManagementAdminUserModifyBtn);
		channelManagementAdminUserModifyBtn.click();
	}

	public void verifySuccessMessage(String message) {

		try {
			waitForElementVisible(channelManagementAdminUserCreationMessage);
			String response = channelManagementAdminUserCreationMessage
					.getText();
			if (message.equalsIgnoreCase(response)) {

				Assert.assertTrue("Response is matched " + response, true);
			} else {
				Assert.assertTrue("Response does not match: " + response, false);
			}
		}

		catch (Exception e) {
			waitForElementVisible(channelManagementAdminUserCreationErroMessage);
			Assert.assertTrue("User is not getting created, getting message "
					+ channelManagementAdminUserCreationErroMessage.getText(),
					false);
		}
	}

	public void verifyEmailIdMandatory() {

		String mandetoryMark = getFinder().getWebDriver()
				.findElement(emailIdLocator)
				.getCssValue(Constants.CCSVALUE_MANDATORY_FIELD);

		if (Constants.RBGVALUE_RED.equalsIgnoreCase(mandetoryMark)) {

			Assert.assertTrue("Email ID is Mandatory", true);
		} else {
			Assert.assertTrue("Email ID is not Mandatory", false);
		}

	}

	public void verifyMobileNumberMandatory() {

		String mandetoryMark = getFinder().getWebDriver()
				.findElement(mobileNoLocator)
				.getCssValue(Constants.CCSVALUE_MANDATORY_FIELD);

		if (Constants.RBGVALUE_RED.equalsIgnoreCase(mandetoryMark)) {

			Assert.assertTrue("Mobile Number is Mandatory", true);
		} else {
			Assert.assertTrue("Mobile Number is not Mandatory", false);
		}

	}

	public void verifyErrorMessage(String message) {
		waitForElementVisible(channelManagementAdminUserCreationErroMessage);

		String response = channelManagementAdminUserCreationErroMessage
				.getText();
		if (message.equalsIgnoreCase(response)) {

			Assert.assertTrue("Response is matched " + response, true);
		} else {
			Assert.assertTrue("Response does not match: " + response, false);
		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
