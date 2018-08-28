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
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_SEARCH_CLIENT,
		CardManagementNav.L3_CLIENT_PORTFOLIO})

public class ClientPortfolioPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(ClientPortfolioPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement clientCodeTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cbsClientId]")
	private MCWebElement cbsClientIdTxt;
		
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text() = 'Branch Code']/..//select[1]")
	private MCWebElement branchCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=firstName]")
	private MCWebElement firstNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lastName]")
	private MCWebElement lastNameTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text() = 'Status']/..//select[1]")
	private MCWebElement statusDDwn	;

	public void verifyUiOperationStatus() {
		logger.info("Client Portfolio");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(clientCodeTxt),
				WebElementUtils.elementToBeClickable(cbsClientIdTxt),
				WebElementUtils.elementToBeClickable(branchCodeTxt),
				WebElementUtils.elementToBeClickable(firstNameTxt),
				WebElementUtils.elementToBeClickable(lastNameTxt),
				WebElementUtils.elementToBeClickable(statusDDwn)
				);
	}
}