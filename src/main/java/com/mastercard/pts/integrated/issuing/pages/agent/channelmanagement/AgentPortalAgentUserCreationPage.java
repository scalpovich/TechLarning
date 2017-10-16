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
public class AgentPortalAgentUserCreationPage extends AbstractBasePage {
	final Logger logger = LoggerFactory
			.getLogger(AgentPortalAgentUserCreationPage.class);
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='admin']")
	private MCWebElement channelManagementLink;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='agentli']")
	private MCWebElement channelManagemenAgent;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='agentuserli']")
	private MCWebElement channelManagementAgentUser;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='createagentuserli']/a")
	private MCWebElement channelManagementAgentUserCreate;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='viewagentuserli']/a")
	private MCWebElement channelManagementAgentUserView;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='parentID']")
	private MCWebElement channelManagementParentParentIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='roleID']")
	private MCWebElement channelManagementAgentRoleIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userID']")
	private MCWebElement channelManagementAgentEnterUserID;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userName']")
	private MCWebElement channelManagementAgentEnterUserName;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='txnPassword']")
	private MCWebElement channelManagementAgentEnterTrnPassword;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='address1']")
	private MCWebElement channelManagementAgentEnterAddress;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='country']")
	private MCWebElement channelManagementAgentSelectCountry;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='PINCode']")
	private MCWebElement channelManagementAgentEnterZipCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='state']")
	private MCWebElement channelManagementAgentEnterState;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='city']")
	private MCWebElement channelManagementAgentEnterCity;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='emailId']")
	private MCWebElement channelManagementAgentEnterEmail;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='preferredLanguage']")
	private MCWebElement channelManagementAgentSelectLanguage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='isdCode']")
	private MCWebElement channelManagementAgentSelectISDCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='mobileNo']")
	private MCWebElement channelManagementAgentEnterMobile;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='submitBtn']")
	private MCWebElement channelManagementAgentClickCreateBtn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='SuccessMessageTxt']")
	private MCWebElement channelManagementAgentUserCreationMessage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='ResponseTxt']")
	private MCWebElement channelManagementAgentUserCreationErroMessage;
	@PageElement(findBy = FindBy.ID, valueToFind = "userID")
	private MCWebElement channelManagementAgentUserSearch;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_activateSuspendBranch_search")
	private MCWebElement channelManagementAgentUserSearchBtn;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_button_modify")
	private MCWebElement channelManagementAgentUserModifyBtn;

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

	public void clickOnAgentLink() {
		waitForElementVisible(channelManagemenAgent);
		channelManagemenAgent.click();
	}

	public void clickOnUserLink() {
		waitForElementVisible(channelManagementAgentUser);
		channelManagementAgentUser.click();
	}

	public void clickOnCreateLink() {
		waitForElementVisible(channelManagementAgentUserCreate);
		channelManagementAgentUserCreate.click();
	}

	public void clickOnViewLink() {
		waitForElementVisible(channelManagementAgentUserView);
		channelManagementAgentUserView.click();
	}

	public void selectParentID(String parentID) {
		try {
			channelManagementParentParentIDSelect.getSelect()
					.selectByVisibleText(parentID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Role ID: ", e);
			channelManagementParentParentIDSelect.getSelect().selectByIndex(1);
		}
	}

	public void selectRoleID(String roleID) {

		try {
			channelManagementAgentRoleIDSelect.getSelect().selectByVisibleText(
					roleID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Role ID: ", e);
			channelManagementAgentRoleIDSelect.getSelect().selectByIndex(1);
		}
	}

	public void enterUserID(String userID) {
		waitForElementVisible(channelManagementAgentEnterUserID);

		if ("UniqueUserID".equalsIgnoreCase(userID)) {

			modifiedUserID = "User" + date.getDateMMDDFormat();
			channelManagementAgentEnterUserID.sendKeys(modifiedUserID);

		} else if ("PreviousUserID".equalsIgnoreCase(userID)) {

			channelManagementAgentEnterUserID.sendKeys(modifiedUserID);
		} else {
			channelManagementAgentEnterUserID.sendKeys(userID);
		}
	}

	public void enterUserName(String userName) {
		waitForElementVisible(channelManagementAgentEnterUserName);
		channelManagementAgentEnterUserName.sendKeys(userName);
	}

	public void enterTransPassword(String trnPassword) {
		waitForElementVisible(channelManagementAgentEnterTrnPassword);
		channelManagementAgentEnterTrnPassword.sendKeys(trnPassword);
	}

	public void enterAddress(String address) {
		waitForElementVisible(channelManagementAgentEnterAddress);
		channelManagementAgentEnterAddress.sendKeys(address);
	}

	public void selectCountry(String country) {

		channelManagementAgentSelectCountry.getSelect().selectByVisibleText(
				country);

	}

	public void enterPostalCode(String postalCode) {
		waitForElementVisible(channelManagementAgentEnterZipCode);
		channelManagementAgentEnterZipCode.sendKeys(postalCode);
	}

	public void enterState(String postalCode) {
		waitForElementVisible(channelManagementAgentEnterState);

		WebElement state = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='stateField']"));
		List<WebElement> values = state.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementAgentEnterState);
			channelManagementAgentEnterState.sendKeys("TestState");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementAgentEnterState.getAttribute("title")
					.contains("Select"))

			{
				waitForElementVisible(channelManagementAgentEnterZipCode);
				channelManagementAgentEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				channelManagementAgentEnterZipCode.sendKeys(postalCode);
				state.sendKeys(Keys.TAB);
			}

		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterCity(String postalCode) {
		waitForElementVisible(channelManagementAgentEnterCity);

		WebElement city = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='cityField']"));
		List<WebElement> values = city.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementAgentEnterCity);
			channelManagementAgentEnterCity.sendKeys("TestCity");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementAgentEnterCity.getAttribute("title").contains(
					"Select"))

			{
				waitForElementVisible(channelManagementAgentEnterZipCode);
				channelManagementAgentEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				channelManagementAgentEnterZipCode.sendKeys(postalCode);
				city.sendKeys(Keys.TAB);
			}
		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterEmailID(String emailID) {
		waitForElementVisible(channelManagementAgentEnterEmail);

		if ("UniqueEmail".equalsIgnoreCase(emailID)) {
			modifiedEmailID = "Auto" + date.getDateMMDDFormat() + "@gmail.com";
			channelManagementAgentEnterEmail.sendKeys(modifiedEmailID);
		} else if ("PreviousEmail".equalsIgnoreCase(emailID)) {

			channelManagementAgentEnterEmail.sendKeys(modifiedEmailID);
		} else {
			channelManagementAgentEnterEmail.sendKeys(emailID);
		}
	}

	public void selectLanguage(String language) {
		waitForElementVisible(channelManagementAgentSelectLanguage);
		channelManagementAgentSelectLanguage.getSelect()
				.selectByValue(language);

	}

	public void selectISDCode(String isdCode) {
		waitForElementVisible(channelManagementAgentSelectISDCode);
		channelManagementAgentSelectISDCode.getSelect().selectByVisibleText(
				isdCode);
	}

	public void enterMobile(String mobile) {
		waitForElementVisible(channelManagementAgentEnterMobile);

		if ("UniqueMobile".equalsIgnoreCase(mobile)) {

			modifiedNumber = date.getDateMMDDFormat();
			channelManagementAgentEnterMobile.sendKeys(modifiedNumber);
		} else if ("PreviousMobile".equalsIgnoreCase(mobile)) {

			channelManagementAgentEnterMobile.sendKeys(modifiedNumber);
		} else {
			channelManagementAgentEnterMobile.sendKeys(mobile);
		}
	}

	public void clickOnCreateButton() {
		waitForElementVisible(channelManagementAgentClickCreateBtn);
		channelManagementAgentClickCreateBtn.click();
	}

	public void verifySuccessMessage(String message) {
		waitForElementVisible(channelManagementAgentUserCreationMessage);

		String response = channelManagementAgentUserCreationMessage.getText();
		if (message.equalsIgnoreCase(response)) {

			Assert.assertTrue("Response is matched " + response, true);
		} else {
			Assert.assertTrue("Response does not match: " + response, false);
		}

	}

	public void verifyErrorMessage(String message) {
		waitForElementVisible(channelManagementAgentUserCreationErroMessage);

		String response = channelManagementAgentUserCreationErroMessage
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
