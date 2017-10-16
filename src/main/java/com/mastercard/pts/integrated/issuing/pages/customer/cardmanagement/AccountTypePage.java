package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountType;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2ACCOUNT_TYPE })
public class AccountTypePage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(AccountTypePage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addAccountType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement ISOAccountType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement HostAccountType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement AccountDescription;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'cancel']")
	private MCWebElement CancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	public void clickaddAccountType() {
		clickWhenClickable(addAccountType);
		switchToAddAccountTypeFrame();

	}

	public void switchToAddAccountTypeFrame() {
		switchToIframe("Add Account Type");
	}

	public void selectAccountType(AccountType accounttype) {
		selectByVisibleText(ISOAccountType, accounttype.getAccounttype());
	}

	public void enterAccountHostType() {
		enterValueinTextBox(HostAccountType, CustomUtils.randomNumbers(2));
	}

	public void enterAccountDescription() {
		enterValueinTextBox(AccountDescription, Constants.ACCOUNTTYPE_SAVINGS);
	}

	public void clickSaveButton() {
		clickWhenClickable(save);
	}

	public boolean verifyErrorsOnAccountTypePage() {
		return publishErrorOnPage();
	}

	public void verifyNewAccountTypeSuccess() {
		if (!verifyErrorsOnAccountTypePage()) {
			logger.info("Account type Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void addAccountType(AccountType accounttype) {
		selectAccountType(accounttype);
		enterAccountHostType();
		enterAccountDescription();
		clickSaveButton();
		waitForLoaderToDisappear();
		waitForPageToLoad(getFinder().getWebDriver());
	}
}
