package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountType;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_ACCOUNT_TYPE })
public class AccountTypePage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AccountTypePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=bankAccountType]")
	private MCWebElement bankAccountType;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement isoAccountType;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=accountWording]")
	private MCWebElement accountWording;
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
			switchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			switchToDefaultFrame();
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
	public void verifyUiOperationStatus() {
		logger.info("Account Type");
		verifyUiOperation("Add Account Type");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(bankAccountType),
				WebElementUtils.elementToBeClickable(isoAccountType),			
				WebElementUtils.elementToBeClickable(accountWording)
				);
	}
}
