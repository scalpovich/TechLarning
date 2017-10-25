package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.administration.AssignProductHelpdeskPrivilegesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.AssignServiceCodeHelpdeskPrivilegesPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.UserGroupHelpdeskPrivilegesPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

@Component
public class HelpdeskLevelPrivilegesWorkflow {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Navigator navigator;

	public void provideHelpdeskLevelPrivilegesFlows(String subType,
			String entityType) {
		switch (subType) {
		case "User Groups":
			addUserToUserGroupFlows();
			break;

		case "Assign Product":
			assignProductToUserFlows();
			break;

		case "Assign Service Code":
			assignServiceCodeToUserFlows();
			break;

		default:
			assignProductToUserFlows();
			assignServiceCodeToUserFlows();
			break;
		}
	}

	public void addUserToUserGroupFlows() {
		UserGroupHelpdeskPrivilegesPage userGroupHelpdeskPage;
		userGroupHelpdeskPage = navigator
				.navigateToPage(UserGroupHelpdeskPrivilegesPage.class);
		userGroupHelpdeskPage.clickAddBtn();
		userGroupHelpdeskPage.switchToAddUserGroupFrame();
		userGroupHelpdeskPage.enterUserGroupDetails();
		userGroupHelpdeskPage.clickOnSaveBtn();
		CustomUtils.ThreadDotSleep(900);
		userGroupHelpdeskPage.switchToDefaultWindow();
		CustomUtils.ThreadDotSleep(900);
		userGroupHelpdeskPage.clickOnEditUserGroup();
		userGroupHelpdeskPage.switchToEditUserGroupFrame();
		userGroupHelpdeskPage.selectUser();
		userGroupHelpdeskPage.clickOnAddUserBtn();
		userGroupHelpdeskPage.clickOnSaveBtn();
		userGroupHelpdeskPage.switchToDefaultWindow();
	}

	public void assignProductToUserFlows() {
		AssignProductHelpdeskPrivilegesPage assignProductPage;
		assignProductPage = navigator
				.navigateToPage(AssignProductHelpdeskPrivilegesPage.class);
		assignProductPage.clickAddBtn();
		assignProductPage.switchToAssignProductFrame();
		assignProductPage.selectUserFromDropdown();
		assignProductPage.selectProductAccesCheckbox();
		assignProductPage.clickOnSaveBtn();
		assignProductPage.switchToDefaultWindow();
	}

	public void assignServiceCodeToUserFlows() {
		AssignServiceCodeHelpdeskPrivilegesPage assignServiceCodePage;
		assignServiceCodePage = navigator
				.navigateToPage(AssignServiceCodeHelpdeskPrivilegesPage.class);
		assignServiceCodePage.clickAddBtn();
		assignServiceCodePage.switchToAddServiceCodeFrame();
		assignServiceCodePage.selectUsernameFromDropdown();
		assignServiceCodePage.selectAllServiceCode();
		assignServiceCodePage.clickOnSaveBtn();
		assignServiceCodePage.switchToDefaultWindow();
	}
}
