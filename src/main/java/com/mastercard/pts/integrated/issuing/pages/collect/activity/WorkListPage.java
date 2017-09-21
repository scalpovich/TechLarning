package com.mastercard.pts.integrated.issuing.pages.collect.activity;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_WORK_LIST })
public class WorkListPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(WorkListPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "user:input:dropdowncomponent")
	private MCWebElement userDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=escalationFlag]")
	private MCWebElement escalationFlagChkBox;

	public void verifyUiOperationStatus() {
		logger.info("Work List");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(userDDwn), WebElementUtils.elementToBeClickable(escalationFlagChkBox));
	}
}