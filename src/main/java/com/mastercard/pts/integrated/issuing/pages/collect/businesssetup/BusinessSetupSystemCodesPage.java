package com.mastercard.pts.integrated.issuing.pages.collect.businesssetup;

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
@Navigation(tabTitle = BusinessSetupNav.TAB_BUSINESS_SETUP	, treeMenuItems = {
		BusinessSetupNav.L1_SYSTEM_CODES})
public class BusinessSetupSystemCodesPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(BusinessSetupSystemCodesPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=code]")
	private MCWebElement codeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement typeIdDdwn;

	public void verifyUiOperationStatus() {
		logger.info("System Codes");
		verifyUiOperation("Add System Codes");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(codeTxt),
				WebElementUtils.elementToBeClickable(descriptionTxt),
				WebElementUtils.elementToBeClickable(typeIdDdwn)
				);
	}
}