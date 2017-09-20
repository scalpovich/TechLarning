package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.Collection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.AdministrationNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.Utils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP, AdministrationNav.L2_USER })
public class CustomerPortalUserCreationPage extends AbstractBasePage {
	final Logger logger = LoggerFactory
			.getLogger(CustomerPortalUserCreationPage.class);
	// ------------- Administration > Setup > User

	@Autowired
	CustomerPortalHomePage customerPortalHomePage;
	@Autowired
	protected DateUtils date;
	@Autowired
	DatePicker datePicker;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Administration']")
	private MCWebElement administrationTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[text()='Setup']")
	private MCWebElement administrationSetupMenuButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='User']")
	private MCWebElement administrationUserSubMenuButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='addrecord']/a")
	private MCWebElement administrationAddRecordButton;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrId:input:inputTextField")
	private MCWebElement administrationUserIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrName:input:inputTextField")
	private MCWebElement administrationUserNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rolId:input:dropdowncomponent")
	private MCWebElement administrationSelectRole;

	@PageElement(findBy = FindBy.NAME, valueToFind = "languagePreference:input:dropdowncomponent")
	private MCWebElement administrationSelectLanguagePreference;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tzName:input:dropdowncomponent")
	private MCWebElement administrationSelectTimeZone;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrEmailId1:input:inputTextField")
	private MCWebElement administrationEmailAddress;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileCntryCode:input:dropdowncomponent")
	private MCWebElement administrationSelectMobileNoCountryCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrmobileNo:input:inputTextField")
	private MCWebElement administrationMobileNo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrExpDate:input:dateTextField")
	private MCWebElement administrationDateUserAccountExpiryDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "concurrentLoginAllowed:input:dropdowncomponent")
	private MCWebElement administrationSelectConcurrentLoginAllowed;

	@PageElement(findBy = FindBy.NAME, valueToFind = "maxConcurrentUser:input:inputTextField")
	private MCWebElement administrationTxtMaxConcurrentUser;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userInstitutionContainer:userInstitution:inlineTable:container:dataList:0:colList:colHeaders:3:inputField:checkBoxComponent")
	private MCWebElement administrationClickAssignInstitution;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userInstitutionContainer:userInstitution:inlineTable:container:dataList:0:colList:colHeaders:4:inputField:checkBoxComponent")
	private MCWebElement administrationClickDefaultInstitution;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement administrationBtnSave;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement administrationBtnCancel;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span[class='feedbackPanelINFO']")
	private MCWebElement customerUserCreationMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span[class='feedbackPanelERROR']")
	private MCWebElement customerUserCreationErroMessage;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement administrationSearchUserIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement administrationSearchUserBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr[1]//a/span")
	private MCWebElement administrationSearchUserInTable;

	private String administrationAddUserFrame = "_wicket_window_3";

	private By mobileNoLocator = By
			.xpath("//input[@name='usrmobileNo:input:inputTextField']");
	private By emailIdLocator = By
			.xpath("//input[@name='usrEmailId1:input:inputTextField']");

	String modifiedNumber;
	String modifiedEmailID;
	String modifiedUserID;

	public void verifyHomePage() {
		customerPortalHomePage.verifyHomePage();
	}

	public void clickOnAdministrator() {
		waitForElementVisible(administrationTab);
		administrationTab.click();
	}

	public void clickOnSetUp() {
		waitForElementVisible(administrationSetupMenuButton);
		administrationSetupMenuButton.click();
	}

	public void clickOnUser() {
		waitForElementVisible(administrationUserSubMenuButton);
		administrationUserSubMenuButton.click();
	}

	public void clickOnAddRecordButton() {
		waitForElementVisible(administrationAddRecordButton);
		administrationAddRecordButton.click();
	}

	public void switchToAddUserFrame() {
		fnSwitchFrame(administrationAddUserFrame);
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

	public void enterUserID(String userID) {

		waitForElementVisible(administrationUserIdTxt);
		if ("UniqueUserID".equalsIgnoreCase(userID)) {

			modifiedUserID = "U" + Utils.generateUniqueKey(9);
			administrationUserIdTxt.sendKeys(modifiedUserID);

			Constants.variable.put("UserID", modifiedUserID);

		} else if ("PreviousUserID".equalsIgnoreCase(userID)) {

			administrationUserIdTxt.sendKeys(modifiedUserID);

			Constants.variable.put("UserID", modifiedUserID);
		} else {
			administrationUserIdTxt.sendKeys(userID);

			Constants.variable.put("UserID", userID);
		}
	}

	public void enterUserName(String userName) {
		waitForElementVisible(administrationUserNameTxt);
		administrationUserNameTxt.sendKeys(userName);
	}

	public void selectRoleID(String roleID) {
		waitForElementVisible(administrationSelectRole);

		try {
			administrationSelectRole.getSelect().selectByVisibleText(roleID);
		} catch (Exception e) {
			logger.info("Selecting the first visible Role ID: ", e);
			administrationSelectRole.getSelect().selectByIndex(1);
		}

	}

	public void selectLanguagePreference(String languagePreference) {
		waitForElementVisible(administrationSelectLanguagePreference);
		administrationSelectLanguagePreference.getSelect().selectByVisibleText(
				languagePreference);
	}

	public void selectTimeZone(String timeZone) {
		waitForElementVisible(administrationSelectTimeZone);
		try {
			administrationSelectTimeZone.getSelect().selectByVisibleText(
					timeZone);

		} catch (Exception e) {
			logger.info("Selecting the first visible Time Zone: ", e);
			administrationSelectTimeZone.getSelect().selectByIndex(1);
		}

	}

	public void enterEmailID(String emailID) {

		waitForElementVisible(administrationEmailAddress);
		if ("UniqueEmail".equalsIgnoreCase(emailID)) {
			modifiedEmailID = "Auto" + date.getDateMMDDFormat() + "@gmail.com";
			administrationEmailAddress.sendKeys(modifiedEmailID);
		} else if ("PreviousEmail".equalsIgnoreCase(emailID)) {

			administrationEmailAddress.sendKeys(modifiedEmailID);
		} else {
			administrationEmailAddress.sendKeys(emailID);
		}
	}

	public void selectCountryCode(String countryCode) {
		waitForElementVisible(administrationSelectMobileNoCountryCode);
		administrationSelectMobileNoCountryCode.getSelect()
				.selectByVisibleText(countryCode);
	}

	public void enterMobile(String mobile) {
		waitForElementVisible(administrationMobileNo);
		if ("UniqueMobile".equalsIgnoreCase(mobile)) {

			modifiedNumber = date.getDateMMDDFormat();
			administrationMobileNo.sendKeys(modifiedNumber);
		} else if ("PreviousMobile".equalsIgnoreCase(mobile)) {

			administrationMobileNo.sendKeys(modifiedNumber);
		} else {
			administrationMobileNo.sendKeys(mobile);
		}
	}

	public void enterUserAccountExpiryDate(String userAccountExpiryDate) {

		datePicker.setDate(DateUtils.getDateInCalanderFormat(
				userAccountExpiryDate, 1));
	}

	public void selectConcurrentLoginAllowed(String concurrentLoginAllowed) {
		waitForElementVisible(administrationSelectConcurrentLoginAllowed);
		administrationSelectConcurrentLoginAllowed.getSelect()
				.selectByVisibleText(concurrentLoginAllowed);
	}

	public void enterMaximumConcurrentUser(String maximumConcurrentUser) {
		waitForElementVisible(administrationTxtMaxConcurrentUser);
		administrationTxtMaxConcurrentUser.sendKeys(maximumConcurrentUser);
	}

	public void clickAssignInstitution() {
		waitForElementVisible(administrationClickAssignInstitution);
		administrationClickAssignInstitution.click();
	}

	public void clickDefaultInstitutio() {
		waitForElementVisible(administrationClickDefaultInstitution);
		administrationClickDefaultInstitution.click();
	}

	public void clickOnSaveButton() {
		waitForElementVisible(administrationBtnSave);
		administrationBtnSave.click();

	}

	public void clickOnCancelButton() {
		waitForElementVisible(administrationBtnCancel);
		administrationBtnCancel.click();

	}

	public void verifySuccessMessage(String message) {

		try {
			waitForElementVisible(customerUserCreationMessage);
			String response = customerUserCreationMessage.getText();
			if (message.equalsIgnoreCase(response)) {

				Assert.assertTrue("Response is matched: " + response, true);
			} else {
				Assert.assertTrue("Response does not match: " + response, false);
			}

		} catch (Exception e) {

			switchToAddUserFrame();
			logger.info(customerUserCreationErroMessage.getText());
			clickOnCancelButton();
			frameSwitchingToDefault();
			Assert.assertTrue("User is not getting created: " + e, false);
		}

	}

	public void verifyErrorMessage(String message) {

		waitForElementVisible(customerUserCreationErroMessage);
		String response = customerUserCreationErroMessage.getText();
		if (message.equalsIgnoreCase(response)) {

			Assert.assertTrue("Response is matched " + response, true);
		} else {
			clickOnCancelButton();
			frameSwitchingToDefault();
			Assert.assertTrue("Response does not match: " + response, false);

		}
	}

	public void verifyUser() {

		String userID = Constants.variable.get("UserID");

		waitForElementVisible(administrationSearchUserIDTxt);
		administrationSearchUserIDTxt.sendKeys(userID);

		waitForElementVisible(administrationSearchUserBtn);
		administrationSearchUserBtn.click();

		waitForElementVisible(administrationSearchUserInTable);
		String createdUserID = administrationSearchUserInTable.getText();
		if (userID.equalsIgnoreCase(createdUserID)) {

			Assert.assertTrue("User is created with user id: " + userID, true);
		} else {
			Assert.assertTrue("User is not created with user id  " + userID,
					false);
		}

	}

	public void frameSwitchingToDefault() {

		SwitchToDefaultFrame();
		waitForElementVisible(administrationSearchUserIDTxt);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {

		return null;
	}

}
