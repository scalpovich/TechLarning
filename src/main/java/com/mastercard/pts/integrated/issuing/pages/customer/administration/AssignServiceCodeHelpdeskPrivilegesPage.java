package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
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
		AdministrationNav.L3_ASSIGN_SERVICE_CODE })
public class AssignServiceCodeHelpdeskPrivilegesPage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement userGroupCodeSearchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:buttonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "usercode:input:dropdowncomponent")
	private MCWebElement userGroupCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planPalette:choices")
	private MCWebElement selectServiceCodeMultiSelect;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	public void clickAddBtn() {
		ClickButton(addBtn);
	}

	public void switchToAddServiceCodeFrame() {
		switchToIframe(Constants.ADD_SERVICE_CODE);
	}

	public void selectUsernameFromDropdown(HelpdeskPrivileges helpdeskPrevileges) {
		selectByVisibleText(userGroupCodeDDwn,
				helpdeskPrevileges.getGroupName() + "(Group) ["
						+ helpdeskPrevileges.getUserGroupID() + "]");
	}

	public void selectAllServiceCode() {
		Select s = new Select(getFinder().getWebDriver().findElement(
				By.name("planPalette:choices")));
		int size = s.getOptions().size();
		for (int i = 0; i < size; i++) {
			s.selectByIndex(i);
		}

	}

	public void clickOnSaveBtn() {
		ClickButton(saveBtn);
	}

	public void switchToDefaultWindow() {
		getFinder().getWebDriver().switchTo().defaultContent();
	}

}
