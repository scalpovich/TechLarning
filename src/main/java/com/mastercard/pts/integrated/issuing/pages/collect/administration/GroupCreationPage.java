package com.mastercard.pts.integrated.issuing.pages.collect.administration;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTARTION, treeMenuItems = { AdministrationNav.L1_USER_GROUP, AdministrationNav.L2_GROUP_CREATION })
public class GroupCreationPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(GroupCreationPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=groupcode]")
	private MCWebElement groupcodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=groupname]")
	private MCWebElement groupnameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement statusDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Group Creation");
		verifySearchButton("Search");
		verifyUiOperation("Add Users Group");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(groupcodeTxt), WebElementUtils.elementToBeClickable(groupnameTxt),
				WebElementUtils.elementToBeClickable(statusDDwn));
	}
}