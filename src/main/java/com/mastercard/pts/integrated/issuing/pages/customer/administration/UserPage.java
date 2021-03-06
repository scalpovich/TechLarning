package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.AdministrationNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP,
		AdministrationNav.L2_USER
		})
public class UserPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory
			.getLogger(UserPage.class);

	@Autowired
	public DatePicker date;


	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement srchUserIdTxt;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addUser;

	// Objects of Add User frame
	@PageElement(findBy = FindBy.NAME, valueToFind = "usrId:input:inputTextField")
	private MCWebElement userIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrName:input:inputTextField")
	private MCWebElement userNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rolId:input:dropdowncomponent")
	private MCWebElement userRole;

	@PageElement(findBy = FindBy.NAME, valueToFind = "languagePreference:input:dropdowncomponent")
	private MCWebElement languagePreference;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tzName:input:dropdowncomponent")
	private MCWebElement timeZone;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrAllowFromtime:input:dateTextField")
	private MCWebElement loginAllowedFrom;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrAllowTotime:input:dateTextField")
	private MCWebElement loginAllowedTill;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrEmailId1:input:inputTextField")
	private MCWebElement emailAddress;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mobileCntryCode:input:dropdowncomponent")
	private MCWebElement mobileNoCountryCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrmobileNo:input:inputTextField")
	private MCWebElement mobileNo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usrExpDate:input:dateTextField")
	private MCWebElement dateUserAccountExpiryDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "concurrentLoginAllowed:input:dropdowncomponent")
	private MCWebElement concurrentLoginAllowed;

	@PageElement(findBy = FindBy.NAME, valueToFind = "maxConcurrentUser:input:inputTextField")
	private MCWebElement maxConcurrentUser;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userInstitutionContainer:userInstitution:inlineTable:container:dataList:0:colList:colHeaders:3:inputField:checkBoxComponent")
	private MCWebElement administrationClickAssignInstitution;

	@PageElement(findBy = FindBy.NAME, valueToFind = "userInstitutionContainer:userInstitution:inlineTable:container:dataList:0:colList:colHeaders:4:inputField:checkBoxComponent")
	private MCWebElement administrationClickDefaultInstitution;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement administrationBtnCancel;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span[class='feedbackPanelINFO']")
	private MCWebElement customerUserCreationMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span[class='feedbackPanelERROR']")
	private MCWebElement customerUserCreationErroMessage;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement searchUserNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchUserBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr")
	private MCWebElements searchUserInTable;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".feedbackPanelINFO span")
	private MCWebElement customerUserUpdationMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span.feedbackPanelERROR")
	private MCWebElement userCreationErrorMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='cancel']")
	private MCWebElement closeButton;

	private String institutionAssignedToUser = "//span[contains(.,'%s')]/following::input[1][@type='checkbox']";

	private String defaultinstitution = "//span[contains(.,'%s')]/following::input[2][@type='checkbox']";

	public void enterUserID(UserCreation userCreation) {
		enterValueinTextBox(userIdTxt, userCreation.getUserID());
	}

	public void enterUserName(UserCreation userCreation) {
		enterValueinTextBox(userNameTxt, userCreation.getUserName());
		MapUtils.fnSetInputDataToInputMap("UserIDCreated",
				userCreation.getUserName() + " [" + userCreation.getUserID()
						+ "]");
		MapUtils.fnSetInputDataToInputMap("User", userCreation.getUserID());
		MapUtils.fnSetInputDataToInputMap("UserName",
				userCreation.getUserName());
	}	

	public void selectUserRole(UserCreation userCreation) {
		selectValueFromDropDown(userRole, userCreation.getRole());
	}

	public void selectLanguagePref(UserCreation userCreation) {
		selectValueFromDropDown(languagePreference,
				userCreation.getLanguagePreference());
	}

	public void selectTimeZone(UserCreation userCreation) {
		selectValueFromDropDown(timeZone, userCreation.getTimeZone());
	}

	public void enterLoginAllowedFrom(UserCreation userCreation) {
		enterValueinTextBox(loginAllowedFrom,
				userCreation.getLoginAllowedFrom());
	}

	public void enterLoginAllowedTill(UserCreation userCreation) {
		enterValueinTextBox(loginAllowedTill,
				userCreation.getLoginallowedTill());
	}

	public void enterEmailAddress(UserCreation userCreation) {
		enterValueinTextBox(emailAddress, userCreation.getEmailAdress());

	}

	public void enterUserAccountExpiryDate(UserCreation userCreation) {
		date.setDate(userCreation.getUserAccountExpiryDate());
		waitForLoaderToDisappear();
	}

	public void selectMobileCountryCode(UserCreation userCreation) {
		selectValueFromDropDown(mobileNoCountryCode,
				userCreation.getCountryCode());
	}

	public void enterMobileNumber(UserCreation userCreation) {
		enterValueinTextBox(mobileNo, userCreation.getMobileNumber());
	}

	public void selectConcurentLoginAllowed(UserCreation userCreation) {		
		selectValueFromDropDown(concurrentLoginAllowed,
				userCreation.getConcurrentLoginAllowed());
		if(userCreation.getConcurrentLoginAllowed().contains("Yes")){
			Assert.assertTrue("Max Concurrent user textbox is enabled ",maxConcurrentUser.isEnabled());
			enterMaximumConcurrentUser(userCreation);
		}
	}

	public void enterMaximumConcurrentUser(UserCreation userCreation) {
		enterValueinTextBox(maxConcurrentUser,
				userCreation.getMaxConcurrentUser());
	}

	public void assignInstituteToUser(UserCreation user) {
		if(!user.getInstitutionName().isEmpty()){
		Scrolldown(Element(institutionAssignedToUser.replace("%s",
				user.getInstitutionName())));
		clickWhenClickable(Element(institutionAssignedToUser.replace("%s",
				user.getInstitutionName())));
		}
		else{
			Scrolldown(Element(institutionAssignedToUser.replace("%s",
					user.getSavedInstituteInXL())));
			clickWhenClickable(Element(institutionAssignedToUser.replace("%s",
					user.getSavedInstituteInXL())));
		}
	}

	public void assignDefaultInstituteToUser(UserCreation user) {
		if(!user.getInstitutionName().isEmpty()){
		clickWhenClickable(Element(defaultinstitution.replace("%s",
				user.getInstitutionName())));
	}
		else{
			clickWhenClickable(Element(defaultinstitution.replace("%s",
					user.getSavedInstituteInXL())));
			}
		}

	public void enterNewCreatedUser(UserCreation userCreation) {
		enterValueinTextBox(searchUserNameTxt, userCreation.getUserName());
	}

	public void searchNewUser() {
		clickWhenClickable(searchUserBtn);			
	}

	public void save() {
		clickWhenClickable(save);
		SimulatorUtilities.wait(2000);
		waitForLoaderToDisappear();
	}
	
	public void verifyNewUserCreationSuccess(UserCreation userCreation) {
		if (!publishErrorOnPage()) {
			switchToDefaultFrame();
			enterNewCreatedUser(userCreation);
			searchNewUser();			
			for (int l = 0; l < 21; l++) {
				if (!waitForRow())
					clickSearchButton();
				else {
					break;
				}
			}
			for (MCWebElement element : searchUserInTable.getElements()) {
				Assert.assertTrue(element.getText().contains(
						userCreation.getUserName()));
				Assert.assertTrue(element.getText().contains(
						userCreation.getEmailAdress().toUpperCase()));							
			}
			logger.info("User has been created successfully : {}"
					+ userCreation.getUserName() + " "
					+ userCreation.getUserID());
		} else {
			logger.error("Error in new user creation");
		}
	}

	public void addNewuser() {
		try {
			clickWhenClickable(addUser);
			switchToIframe(Constants.ADD_USER);
		} catch (Exception e) {
			logger.error("Error in swtiching frame for user creation" + e);
		}
	}

	public void provideUserDetails(UserCreation userCreation) {
		try {
			enterUserID(userCreation);
			enterUserName(userCreation);
			selectUserRole(userCreation);
			selectLanguagePref(userCreation);
			selectTimeZone(userCreation);
			enterLoginAllowedFrom(userCreation);
			enterLoginAllowedTill(userCreation);
			enterEmailAddress(userCreation);
			selectMobileCountryCode(userCreation);
			enterMobileNumber(userCreation);
			enterUserAccountExpiryDate(userCreation);		
			selectConcurentLoginAllowed(userCreation);
			
		} catch (Exception e) {
			logger.error("Error in providing details for user creation" + e);
		}
	}

	public void mapInstituteToUser(UserCreation user) {
		try {
			assignInstituteToUser(user);
			assignDefaultInstituteToUser(user);
		} catch (Exception e) {
			logger.error("Error in assigning institution to user" + e);
		}
	}
	
	public void verifyUiOperationStatus() {
		logger.info("User");
		verifyUiOperation("Add User");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(srchUserIdTxt));
	}
}
