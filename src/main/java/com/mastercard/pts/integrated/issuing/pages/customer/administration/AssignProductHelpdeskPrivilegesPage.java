package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskPrivileges;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.AdministrationNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP, AdministrationNav.L2_HELPDESK_PRIVILEGES,
		AdministrationNav.L3_ASSIGN_PRODUCT })
public class AssignProductHelpdeskPrivilegesPage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement userGroupCodeSearchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:buttonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement userGroupCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement prepaidAccessChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement debitAccessChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:4:cols:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement creditAccessChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	public void clickAddBtn() {
		ClickButton(addBtn);
	}

	public void switchToAssignProductFrame() {
		switchToIframe(Constants.ASSIGN_PRODUCT);
	}

	public void selectUserGroupFromDropdown(
			HelpdeskPrivileges HelpdeskPrivileges) {
		selectByVisibleText(userGroupCodeDDwn,
				HelpdeskPrivileges.getGroupName() + "(Group) ["
						+ HelpdeskPrivileges.getUserGroupID() + "]");
	}

	public void selectProductAccesCheckbox() {
		if (prepaidAccessChkBx.isEnabled())
			ClickCheckBox(prepaidAccessChkBx, true);
		if (debitAccessChkBx.isEnabled())
			ClickCheckBox(debitAccessChkBx, true);
		if (creditAccessChkBx.isEnabled())
			ClickCheckBox(creditAccessChkBx, true);
	}

	public void clickOnSaveBtn() {
		ClickButton(saveBtn);
	}

	public void switchToDefaultWindow() {
		getFinder().getWebDriver().switchTo().defaultContent();
	}

}
