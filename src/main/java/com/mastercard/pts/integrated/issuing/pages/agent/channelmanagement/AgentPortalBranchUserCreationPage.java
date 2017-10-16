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
public class AgentPortalBranchUserCreationPage extends AbstractBasePage {
	final Logger logger = LoggerFactory
			.getLogger(AgentPortalBranchUserCreationPage.class);
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='Admin']")
	private MCWebElement channelManagementLink;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='branchli']")
	private MCWebElement channelManagemenBranch;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='branchuserli']")
	private MCWebElement channelManagementBranchUser;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='createbranchuserli']/a")
	private MCWebElement channelManagementBranchUserCreate;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='parentID']")
	private MCWebElement channelManagementBranchParentIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='roleID']")
	private MCWebElement channelManagementBranchRoleIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userID']")
	private MCWebElement channelManagementBranchEnterUserID;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userName']")
	private MCWebElement channelManagementBranchEnterUserName;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='address1']")
	private MCWebElement channelManagementBranchEnterAddress;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='country']")
	private MCWebElement channelManagementBranchSelectCountry;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='PINCode']")
	private MCWebElement channelManagementBranchEnterZipCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='state']")
	private MCWebElement channelManagementBranchEnterState;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='city']")
	private MCWebElement channelManagementBranchEnterCity;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='emailId']")
	private MCWebElement channelManagementBranchEnterEmail;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='preferredLanguage']")
	private MCWebElement channelManagementBranchSelectLanguage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='isdCode']")
	private MCWebElement channelManagementBranchSelectISDCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='mobileNo']")
	private MCWebElement channelManagementBranchEnterMobile;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='submitBtn']")
	private MCWebElement channelManagementBranchClickCreateBtn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='SuccessMessageTxt']")
	private MCWebElement channelManagementBranchUserCreationMessage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='ResponseTxt']")
	private MCWebElement channelManagementBranchUserCreationErroMessage;
	@PageElement(findBy = FindBy.ID, valueToFind = "userID")
	private MCWebElement channelManagementBranchUserSearch;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_activateSuspendBranch_search")
	private MCWebElement channelManagementBranchUserSearchBtn;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_button_modify")
	private MCWebElement channelManagementBranchUserModifyBtn;

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

	public void clickOnBranchLink() {
		waitForElementVisible(channelManagemenBranch);

		channelManagemenBranch.click();
	}

	public void clickOnUserLink() {
		waitForElementVisible(channelManagementBranchUser);
		channelManagementBranchUser.click();
	}

	public void clickOnCreateLink() {

		waitForElementVisible(channelManagementBranchUserCreate);
		channelManagementBranchUserCreate.click();
	}

	public void selectParentID(String parentID) {
		waitForElementVisible(channelManagementBranchParentIDSelect);
		try {
			channelManagementBranchParentIDSelect.getSelect()
					.selectByVisibleText(parentID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Parent ID: ", e);
			channelManagementBranchParentIDSelect.getSelect().selectByIndex(1);
		}
	}

	public void selectRoleID(String roleID) {
		waitForElementVisible(channelManagementBranchRoleIDSelect);
		try {
			channelManagementBranchRoleIDSelect.getSelect()
					.selectByVisibleText(roleID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Role ID: ", e);
			channelManagementBranchRoleIDSelect.getSelect().selectByIndex(1);
		}
	}

	public void enterUserID(String userID) {

		if ("UniqueUserID".equalsIgnoreCase(userID)) {

			modifiedUserID = "User" + date.getDateMMDDFormat();
			channelManagementBranchEnterUserID.sendKeys(modifiedUserID);

		} else if ("PreviousUserID".equalsIgnoreCase(userID)) {

			channelManagementBranchEnterUserID.sendKeys(modifiedUserID);
		} else {
			channelManagementBranchEnterUserID.sendKeys(userID);
		}
	}

	public void enterUserName(String userName) {

		channelManagementBranchEnterUserName.sendKeys(userName);
	}

	public void enterAddress(String address) {

		channelManagementBranchEnterAddress.sendKeys(address);
	}

	public void selectCountry(String country) {
		waitForElementVisible(channelManagementBranchSelectCountry);
		channelManagementBranchSelectCountry.getSelect().selectByVisibleText(
				country);

	}

	public void enterPostalCode(String postalCode) {
		waitForElementVisible(channelManagementBranchEnterZipCode);
		channelManagementBranchEnterZipCode.sendKeys(postalCode);
	}

	public void enterState(String postalCode) {
		waitForElementVisible(channelManagementBranchEnterState);

		WebElement state = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='stateField']"));
		List<WebElement> values = state.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementBranchEnterState);
			channelManagementBranchEnterState.sendKeys("TestState");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementBranchEnterState.getAttribute("title")
					.contains("Select"))

			{
				waitForElementVisible(channelManagementBranchEnterZipCode);
				channelManagementBranchEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				channelManagementBranchEnterZipCode.sendKeys(postalCode);
				state.sendKeys(Keys.TAB);
			}

		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterCity(String postalCode) {
		waitForElementVisible(channelManagementBranchEnterCity);

		WebElement city = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='cityField']"));
		List<WebElement> values = city.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementBranchEnterCity);
			channelManagementBranchEnterCity.sendKeys("TestCity");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementBranchEnterCity.getAttribute("title")
					.contains("Select"))

			{
				waitForElementVisible(channelManagementBranchEnterZipCode);
				channelManagementBranchEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				channelManagementBranchEnterZipCode.sendKeys(postalCode);
				city.sendKeys(Keys.TAB);
			}
		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterEmailID(String emailID) {

		if ("UniqueEmail".equalsIgnoreCase(emailID)) {
			modifiedEmailID = "Auto" + date.getDateMMDDFormat() + "@gmail.com";
			channelManagementBranchEnterEmail.sendKeys(modifiedEmailID);
		} else if ("PreviousEmail".equalsIgnoreCase(emailID)) {

			channelManagementBranchEnterEmail.sendKeys(modifiedEmailID);
		} else {
			channelManagementBranchEnterEmail.sendKeys(emailID);
		}
	}

	public void selectLanguage(String language) {

		channelManagementBranchSelectLanguage.getSelect().selectByValue(
				language);

	}

	public void selectISDCode(String isdCode) {

		channelManagementBranchSelectISDCode.getSelect().selectByVisibleText(
				isdCode);
	}

	public void enterMobile(String mobile) {

		if ("UniqueMobile".equalsIgnoreCase(mobile)) {

			modifiedNumber = date.getDateMMDDFormat();
			channelManagementBranchEnterMobile.sendKeys(modifiedNumber);
		} else if ("PreviousMobile".equalsIgnoreCase(mobile)) {

			channelManagementBranchEnterMobile.sendKeys(modifiedNumber);
		} else {
			channelManagementBranchEnterMobile.sendKeys(mobile);
		}
	}

	public void clickOnCreateButton() {

		channelManagementBranchClickCreateBtn.click();
	}

	public void verifySuccessMessage(String message) {

		String response = channelManagementBranchUserCreationMessage.getText();
		if (message.equalsIgnoreCase(response)) {

			Assert.assertTrue("Response is matched " + response, true);
		} else {
			Assert.assertTrue("Response does not match: " + response, false);
		}

	}

	public void verifyErrorMessage(String message) {

		String response = channelManagementBranchUserCreationErroMessage
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
