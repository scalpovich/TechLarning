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
public class AgentPortalCorporateUserCreationPage extends AbstractBasePage {
	final Logger logger = LoggerFactory
			.getLogger(AgentPortalCorporateUserCreationPage.class);
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='Admin']")
	private MCWebElement channelManagementLink;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='corporateli']")
	private MCWebElement channelManagemenCorporate;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='corporateuserli']")
	private MCWebElement channelManagementCorporateUser;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@id='createcorporateuserli']/a")
	private MCWebElement channelManagementCorporateUserCreate;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='parentID']")
	private MCWebElement channelManagementCorporateParentIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='roleID']")
	private MCWebElement channelManagementCorporateRoleIDSelect;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userID']")
	private MCWebElement channelManagementCorporateEnterUserID;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='userName']")
	private MCWebElement channelManagementCorporateEnterUserName;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='address1']")
	private MCWebElement channelManagementCorporateEnterAddress;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//select[@id='country']")
	private MCWebElement channelManagementCorporateSelectCountry;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='PINCode']")
	private MCWebElement channelManagementCorporateEnterZipCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='state']")
	private MCWebElement channelManagementCorporateEnterState;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='city']")
	private MCWebElement channelManagementCorporateEnterCity;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='emailId']")
	private MCWebElement channelManagementCorporateEnterEmail;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='preferredLanguage']")
	private MCWebElement channelManagementCorporateSelectLanguage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[@id='isdCode']")
	private MCWebElement channelManagementCorporateSelectISDCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='mobileNo']")
	private MCWebElement channelManagementCorporateEnterMobile;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@id='submitBtn']")
	private MCWebElement channelManagementCorporateClickCreateBtn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='SuccessMessageTxt']")
	private MCWebElement channelManagementCorporateUserCreationMessage;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//td[@class='ResponseTxt']")
	private MCWebElement channelManagementCorporateUserCreationErroMessage;
	@PageElement(findBy = FindBy.ID, valueToFind = "userID")
	private MCWebElement channelManagementCorporateUserSearch;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_activateSuspendCorporate_search")
	private MCWebElement channelManagementCorporateUserSearchBtn;
	@PageElement(findBy = FindBy.ID, valueToFind = "mpts_agentPortal_button_modify")
	private MCWebElement channelManagementCorporateUserModifyBtn;

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

	public void clickOnCorporateLink() {
		waitForElementVisible(channelManagemenCorporate);

		channelManagemenCorporate.click();
	}

	public void clickOnUserLink() {
		waitForElementVisible(channelManagementCorporateUser);
		channelManagementCorporateUser.click();
	}

	public void clickOnCreateLink() {
		waitForElementVisible(channelManagementCorporateUserCreate);

		channelManagementCorporateUserCreate.click();
	}

	public void selectParentID(String parentID) {
		waitForElementVisible(channelManagementCorporateParentIDSelect);
		try {
			channelManagementCorporateParentIDSelect.getSelect()
					.selectByVisibleText(parentID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Parent ID: ", e);
			channelManagementCorporateParentIDSelect.getSelect().selectByIndex(
					1);
		}
	}

	public void selectRoleID(String roleID) {
		waitForElementVisible(channelManagementCorporateRoleIDSelect);
		try {
			channelManagementCorporateRoleIDSelect.getSelect()
					.selectByVisibleText(roleID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Role ID: ", e);
			channelManagementCorporateRoleIDSelect.getSelect().selectByIndex(1);
		}
	}

	public void enterUserID(String userID) {

		if ("UniqueUserID".equalsIgnoreCase(userID)) {

			modifiedUserID = "User" + date.getDateMMDDFormat();
			channelManagementCorporateEnterUserID.sendKeys(modifiedUserID);

		} else if ("PreviousUserID".equalsIgnoreCase(userID)) {

			channelManagementCorporateEnterUserID.sendKeys(modifiedUserID);
		} else {
			channelManagementCorporateEnterUserID.sendKeys(userID);
		}
	}

	public void enterUserName(String userName) {

		channelManagementCorporateEnterUserName.sendKeys(userName);
	}

	public void enterAddress(String address) {

		channelManagementCorporateEnterAddress.sendKeys(address);
	}

	public void selectCountry(String country) {
		waitForElementVisible(channelManagementCorporateSelectCountry);
		channelManagementCorporateSelectCountry.getSelect()
				.selectByVisibleText(country);

	}

	public void enterPostalCode(String postalCode) {
		waitForElementVisible(channelManagementCorporateEnterZipCode);
		channelManagementCorporateEnterZipCode.sendKeys(postalCode);
	}

	public void enterState(String postalCode) {
		waitForElementVisible(channelManagementCorporateEnterState);

		WebElement state = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='stateField']"));
		List<WebElement> values = state.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementCorporateEnterState);
			channelManagementCorporateEnterState.sendKeys("TestState");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementCorporateEnterState.getAttribute("title")
					.contains("Select"))

			{
				waitForElementVisible(channelManagementCorporateEnterZipCode);
				channelManagementCorporateEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				channelManagementCorporateEnterZipCode.sendKeys(postalCode);
				state.sendKeys(Keys.TAB);
			}

		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterCity(String postalCode) {
		waitForElementVisible(channelManagementCorporateEnterCity);

		WebElement city = getFinder().getWebDriver().findElement(
				By.xpath("//div[@id='cityField']"));
		List<WebElement> values = city.findElements(By.xpath(".//*"));
		String tag = values.get(0).getTagName();

		if ("input".equals(tag)) {
			waitForElementVisible(channelManagementCorporateEnterCity);
			channelManagementCorporateEnterCity.sendKeys("TestCity");
		}

		else if ("select".equals(tag))

		{
			if (channelManagementCorporateEnterCity.getAttribute("title")
					.contains("Select"))

			{
				waitForElementVisible(channelManagementCorporateEnterZipCode);
				channelManagementCorporateEnterZipCode.clearField();
				Alert alert = getFinder().getWebDriver().switchTo().alert();
				alert.accept();
				channelManagementCorporateEnterZipCode.sendKeys(postalCode);
				city.sendKeys(Keys.TAB);
			}
		} else {
			logger.info("child tag is not available");
		}
	}

	public void enterEmailID(String emailID) {

		if ("UniqueEmail".equalsIgnoreCase(emailID)) {
			modifiedEmailID = "Auto" + date.getDateMMDDFormat() + "@gmail.com";
			channelManagementCorporateEnterEmail.sendKeys(modifiedEmailID);
		} else if ("PreviousEmail".equalsIgnoreCase(emailID)) {

			channelManagementCorporateEnterEmail.sendKeys(modifiedEmailID);
		} else {
			channelManagementCorporateEnterEmail.sendKeys(emailID);
		}
	}

	public void selectLanguage(String language) {

		channelManagementCorporateSelectLanguage.getSelect().selectByValue(
				language);

	}

	public void selectISDCode(String isdCode) {

		channelManagementCorporateSelectISDCode.getSelect()
				.selectByVisibleText(isdCode);
	}

	public void enterMobile(String mobile) {

		if ("UniqueMobile".equalsIgnoreCase(mobile)) {

			modifiedNumber = date.getDateMMDDFormat();
			channelManagementCorporateEnterMobile.sendKeys(modifiedNumber);
		} else if ("PreviousMobile".equalsIgnoreCase(mobile)) {

			channelManagementCorporateEnterMobile.sendKeys(modifiedNumber);
		} else {
			channelManagementCorporateEnterMobile.sendKeys(mobile);
		}
	}

	public void clickOnCreateButton() {

		channelManagementCorporateClickCreateBtn.click();
	}

	public void verifySuccessMessage(String message) {

		String response = channelManagementCorporateUserCreationMessage
				.getText();
		if (message.equalsIgnoreCase(response)) {

			Assert.assertTrue("Response is matched " + response, true);
		} else {
			Assert.assertTrue("Response does not match: " + response, false);
		}

	}

	public void verifyErrorMessage(String message) {

		String response = channelManagementCorporateUserCreationErroMessage
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
