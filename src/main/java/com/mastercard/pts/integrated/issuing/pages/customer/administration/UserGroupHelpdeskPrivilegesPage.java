package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskPrivileges;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.AdministrationNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP, AdministrationNav.L2_HELPDESK_PRIVILEGES,
		AdministrationNav.L3_USER_GROUPS })
public class UserGroupHelpdeskPrivilegesPage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement userGroupIDSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement groupNameSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "groupCode:input:inputTextField")
	private MCWebElement userGroupIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement groupNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "activateFlag:checkBoxComponent")
	private MCWebElement activateFlagChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mailId:input:inputTextField")
	private MCWebElement emailIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='even']//img[@alt='Edit Record']")
	private MCWebElement editUserGroupBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "editUserGroupsSection:userListDropDown:input:dropdowncomponent")
	private MCWebElement usersDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "editUserGroupsSection:addUserToGroupBtn")
	private MCWebElement addUsersBtn;

	public void clickAddBtn() {
		ClickButton(addBtn);
	}

	public void switchToAddUserGroupFrame() {
		switchToIframe(Constants.ADD_GROUPS);
	}

	public void switchToEditUserGroupFrame() {
		switchToIframe(Constants.EDIT_GROUPS);
	}

	public void enterUserGroupDetails(HelpdeskPrivileges helpdeskPrivileges) {
		enterText(userGroupIDTxt, helpdeskPrivileges.getUserGroupID());
		enterText(groupNameTxt, helpdeskPrivileges.getGroupName());
		ClickCheckBox(activateFlagChkBx, true);
		enterText(emailIDTxt, helpdeskPrivileges.getEmailID());
	}

	public void clickOnSaveBtn() {
		ClickButton(saveBtn);
	}

	public void switchToDefaultWindow() {
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	// Add user to the the newly created user group
	public void clickOnEditUserGroup() {
		CustomUtils.ThreadDotSleep(500);
		ClickButton(editUserGroupBtn);
		CustomUtils.ThreadDotSleep(500);
	}

	public void selectUser(UserCreation userCreation) {
		selectByVisibleText(usersDDwn, userCreation.getUserID() + " ["
				+ userCreation.getUserID() + "]");
	}

	public void clickOnAddUserBtn() {
		ClickButton(addUsersBtn);
	}

}
