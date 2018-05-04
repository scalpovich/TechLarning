package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskPrivileges;
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
			HelpdeskPrivileges helpdeskPreviliges, UserCreation userCreation) {
		switch (subType) {
		case "User Groups":
			addUserToUserGroupFlows(helpdeskPreviliges, userCreation);
			break;

		case "Assign Product":
			assignProductToUserFlows(helpdeskPreviliges);
			break;

		case "Assign Service Code":
			assignServiceCodeToUserFlows(helpdeskPreviliges);
			break;

		default:
			assignProductToUserFlows(helpdeskPreviliges);
			assignServiceCodeToUserFlows(helpdeskPreviliges);
			break;
		}
	}

	public void addUserToUserGroupFlows(HelpdeskPrivileges helpdeskPreviliges,
			UserCreation userCreation) {
		UserGroupHelpdeskPrivilegesPage userGroupHelpdeskPage;
		userGroupHelpdeskPage = navigator
				.navigateToPage(UserGroupHelpdeskPrivilegesPage.class);
		userGroupHelpdeskPage.clickAddBtn();
		userGroupHelpdeskPage.switchToAddUserGroupFrame();
		userGroupHelpdeskPage.enterUserGroupDetails(helpdeskPreviliges);
		userGroupHelpdeskPage.clickOnSaveBtn();
		CustomUtils.ThreadDotSleep(900);
		userGroupHelpdeskPage.switchToDefaultWindow();
		CustomUtils.ThreadDotSleep(900);
		userGroupHelpdeskPage.clickOnEditUserGroup();
		userGroupHelpdeskPage.switchToEditUserGroupFrame();
		userGroupHelpdeskPage.selectUser(userCreation);
		userGroupHelpdeskPage.clickOnAddUserBtn();
		userGroupHelpdeskPage.clickOnSaveBtn();
		userGroupHelpdeskPage.switchToDefaultWindow();
	}

	public void assignProductToUserFlows(HelpdeskPrivileges helpdeskPreviliges) {
		AssignProductHelpdeskPrivilegesPage assignProductPage;
		assignProductPage = navigator
				.navigateToPage(AssignProductHelpdeskPrivilegesPage.class);
		assignProductPage.clickAddBtn();
		assignProductPage.switchToAssignProductFrame();
		assignProductPage.selectUserGroupFromDropdown(helpdeskPreviliges);
		assignProductPage.selectProductAccesCheckbox();
		assignProductPage.clickOnSaveBtn();
		assignProductPage.switchToDefaultWindow();
	}

	public void assignServiceCodeToUserFlows(
			HelpdeskPrivileges helpdeskPreviliges) {
		AssignServiceCodeHelpdeskPrivilegesPage assignServiceCodePage;
		assignServiceCodePage = navigator
				.navigateToPage(AssignServiceCodeHelpdeskPrivilegesPage.class);
		assignServiceCodePage.clickAddBtn();
		assignServiceCodePage.switchToAddServiceCodeFrame();
		assignServiceCodePage.selectUsernameFromDropdown(helpdeskPreviliges);
		assignServiceCodePage.selectAllServiceCode();
		assignServiceCodePage.clickOnSaveBtn();
		assignServiceCodePage.switchToDefaultWindow();
	}
}
