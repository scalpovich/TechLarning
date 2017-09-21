package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_CLIENT,
		CardManagementNav.L3_CREATE_CORPORATE
		})
public class CreateCorporatePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(CreateCorporatePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement clientCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=applicationRefNumber]")
	private MCWebElement applicationRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=companyName]")
	private MCWebElement companyName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;


	public void verifyUiOperationStatus() {
		logger.info("Corporate");
		verifyUiOperation("Add Corporate");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(clientCode),
				WebElementUtils.elementToBeClickable(applicationRefNumber),
				WebElementUtils.elementToBeClickable(companyName),
				WebElementUtils.elementToBeClickable(productType)
				);
	}
}
