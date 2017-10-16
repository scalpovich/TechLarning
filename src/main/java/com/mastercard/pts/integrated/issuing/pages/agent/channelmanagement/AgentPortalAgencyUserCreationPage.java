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
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.testing.mtaf.bindings.drivers.MastercardWebDriverProvider;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AgentPortalAgencyUserCreationPage extends AbstractBasePage {
	final Logger logger = LoggerFactory
			.getLogger(AgentPortalAgencyUserCreationPage.class);
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='admin']")
	private MCWebElement channelManagementLink;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='agencyli']")
	private MCWebElement channelManagemenAgency;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='agencyuserli']")
	private MCWebElement channelManagementAgencyUser;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='createagencyuserli']/a")
	private MCWebElement channelManagementAgencyUserCreate;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='viewagencyuserli']/a")
	private MCWebElement channelManagementAgencyUserView;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='parentID']")
	private MCWebElement channelManagementParentParentIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='roleID']")
	private MCWebElement channelManagementAgencyRoleIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userID']")
	private MCWebElement channelManagementAgencyEnterUserID;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userName']")
	private MCWebElement channelManagementAgencyEnterUserName;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='txnPassword']")
	private MCWebElement channelManagementAgencyEnterTrnPassword;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='address1']")
	private MCWebElement channelManagementAgencyEnterAddress;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='country']")
	private MCWebElement channelManagementAgencySelectCountry;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='PINCode']")
	private MCWebElement channelManagementAgencyEnterZipCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='state']")
	private MCWebElement channelManagementAgencyEnterState;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='city']")
	private MCWebElement channelManagementAgencyEnterCity;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='emailId']")
	private MCWebElement channelManagementAgencyEnterEmail;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='preferredLanguage']")
	private MCWebElement channelManagementAgencySelectLanguage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='isdCode']")
	private MCWebElement channelManagementAgencySelectISDCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='mobileNo']")
	private MCWebElement channelManagementAgencyEnterMobile;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='submitBtn']")
	private MCWebElement channelManagementAgencyClickCreateBtn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='SuccessMessageTxt']")
	private MCWebElement channelManagementAgencyUserCreationMessage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='ResponseTxt']")
	private MCWebElement channelManagementAgencyUserCreationErroMessage;
	@PageElement(findBy = FindBy.ID, valueToFind = "userID")
	private MCWebElement channelManagementAgencyUserSearch;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_activateSuspendBranch_search")
	private MCWebElement channelManagementAgencyUserSearchBtn;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_button_modify")
	private MCWebElement channelManagementAgencyUserModifyBtn;

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

	public void clickOnAgencyLink() {
		waitForElementVisible(channelManagemenAgency);

		channelManagemenAgency.click();
	}

	public void clickOnUserLink() {
		waitForElementVisible(channelManagementAgencyUser);
		channelManagementAgencyUser.click();
	}

	public void clickOnCreateLink() {
		waitForElementVisible(channelManagementAgencyUserCreate);
		channelManagementAgencyUserCreate.click();
	}

	public void clickOnViewLink() {
		waitForElementVisible(channelManagementAgencyUserView);
		channelManagementAgencyUserView.click();
	}

	public void selectParentID(String parentID) {
		waitForElementVisible(channelManagementParentParentIDSelect);
		try {
			channelManagementParentParentIDSelect.getSelect()
					.selectByVisibleText(parentID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Parent ID: ", e);
			channelManagementParentParentIDSelect.getSelect().selectByIndex(1);
		}

	}

	public void selectRoleID(String roleID) {
		waitForElementVisible(channelManagementAgencyRoleIDSelect);
		try {
			channelManagementAgencyRoleIDSelect.getSelect()
					.selectByVisibleText(roleID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Role ID: ", e);
			channelManagementAgencyRoleIDSelect.getSelect().selectByIndex(1);
		}

	}

	public void enterUserID(String userID) {

		if ("UniqueUserID".equalsIgnoreCase(userID)) {

			modifiedUserID = "User" + date.getDateMMDDFormat();
			channelManagementAgencyEnterUserID.sendKeys(modifiedUserID);

		} else if ("PreviousUserID".equalsIgnoreCase(userID)) {

			channelManagementAgencyEnterUserID.sendKeys(modifiedUserID);
		} else {
			channelManagementAgencyEnterUserID.sendKeys(userID);
		}
	}

	public void enterUserName(String userName) {

		channelManagementAgencyEnterUserName.sendKeys(userName);
	}

	public void enterAddress(String address) {

		channelManagementAgencyEnterAddress.sendKeys(address);
	}

	public void selectCountry(String country) {
		waitForElementVisible(channelManagementAgencySelectCountry);
		channelManagementAgencySelectCountry.getSelect().selectByVisibleText(
				country);

	}

	public void enterPostalCode(String postalCode) {
		waitForElementVisible(channelManagementAgencyEnterZipCode);
		channelManagementAgencyEnterZipCode.sendKeys(postalCode);
	}

	public void enterState(String postalCode) {
		waitForElementVisible(channelManagementAgencyEnterState);

		WebElement state = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='stateField']"));
		List<WebElement> values = state.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementAgencyEnterState);
			channelManagementAgencyEnterState.sendKeys("TestState");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementAgencyEnterState.getAttribute("title")
					.contains("Select"))

			{
				waitForElementVisible(channelManagementAgencyEnterZipCode);
				channelManagementAgencyEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				channelManagementAgencyEnterZipCode.sendKeys(postalCode);
				state.sendKeys(Keys.TAB);
			}

		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterCity(String postalCode) {
		waitForElementVisible(channelManagementAgencyEnterCity);

		WebElement city = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='cityField']"));
		List<WebElement> values = city.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementAgencyEnterCity);
			channelManagementAgencyEnterCity.sendKeys("TestCity");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementAgencyEnterCity.getAttribute("title")
					.contains("Select"))

			{
				waitForElementVisible(channelManagementAgencyEnterZipCode);
				channelManagementAgencyEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				channelManagementAgencyEnterZipCode.sendKeys(postalCode);
				city.sendKeys(Keys.TAB);
			}
		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterEmailID(String emailID) {

		waitForElementVisible(channelManagementAgencyEnterEmail);
		channelManagementAgencyEnterEmail.click();

		if ("UniqueEmail".equalsIgnoreCase(emailID)) {
			modifiedEmailID = "Auto" + date.getDateMMDDFormat() + "@gmail.com";
			channelManagementAgencyEnterEmail.sendKeys(modifiedEmailID);
		} else if ("PreviousEmail".equalsIgnoreCase(emailID)) {

			channelManagementAgencyEnterEmail.sendKeys(modifiedEmailID);
		} else {
			channelManagementAgencyEnterEmail.sendKeys(emailID);
		}
	}

	public void selectLanguage(String language) {

		channelManagementAgencySelectLanguage.getSelect().selectByValue(
				language);

	}

	public void selectISDCode(String isdCode) {

		channelManagementAgencySelectISDCode.getSelect().selectByVisibleText(
				isdCode);
	}

	public void enterMobile(String mobile) {

		if ("UniqueMobile".equalsIgnoreCase(mobile)) {

			modifiedNumber = date.getDateMMDDFormat();
			channelManagementAgencyEnterMobile.sendKeys(modifiedNumber);
		} else if ("PreviousMobile".equalsIgnoreCase(mobile)) {

			channelManagementAgencyEnterMobile.sendKeys(modifiedNumber);
		} else {
			channelManagementAgencyEnterMobile.sendKeys(mobile);
		}
	}

	public void clickOnCreateButton() {

		channelManagementAgencyClickCreateBtn.click();
	}

	public void verifySuccessMessage(String message) {

		String response = channelManagementAgencyUserCreationMessage.getText();
		if (message.equalsIgnoreCase(response)) {

			Assert.assertTrue("Response is matched " + response, true);
		} else {
			Assert.assertTrue("Response does not match: " + response, false);
		}

	}

	public void verifyErrorMessage(String message) {

		String response = channelManagementAgencyUserCreationErroMessage
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
