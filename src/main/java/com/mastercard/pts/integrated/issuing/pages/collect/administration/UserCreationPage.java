package com.mastercard.pts.integrated.issuing.pages.collect.administration;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTARTION, treeMenuItems = { AdministrationNav.L1_SETUP,AdministrationNav.L2_USER_CREATION })
public class UserCreationPage extends AdministrationAbstractPage {

	private static final Logger loggerTemp = LoggerFactory.getLogger(UserCreationPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=usrId]")
	private MCWebElement usrIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=usrName]")
	private MCWebElement usrNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement userGroupDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement userStatusDDwn;

	@Override
	public void verifyUiOperationStatus() {
		loggerTemp.info("User Creation");
		verifySearchButton("Search");
		verifyUiOperation("Add User");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(usrIdTxt), WebElementUtils.elementToBeClickable(usrNameTxt),
				WebElementUtils.elementToBeClickable(userGroupDDwn), WebElementUtils.elementToBeClickable(userStatusDDwn));
	}
}