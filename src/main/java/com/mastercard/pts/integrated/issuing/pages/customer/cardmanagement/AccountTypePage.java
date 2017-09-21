package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountType;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
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
		waitForElementVisible(addAccountType);
		addAccountType.click();
	}

	public void switchToAddAccountTypeFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe("Add Account Type");
	}

	public void selectAccountType() {
		waitForElementVisible(ISOAccountType);
		selectByVisibleText(ISOAccountType, getAccounttype());
	}

	public void enterAccountHostType() {
		waitForElementVisible(HostAccountType);
		enterText(HostAccountType, CustomUtils.randomNumbers(2));
	}

	public void enterAccountDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AccountDescription, "Saving Account");
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		try {
			if (PanelInfo.isVisible()) {
				Assert.assertEquals(PanelInfo.getText(), Constants.Record_Added_Successfully);
			}
		} catch (Exception e) {
			try {
				if (PanelErrorTxt.isVisible()) {
					System.out.println("inside error pannel");
					CancelBtn.click();
				}
			} catch (Exception e1) {
				System.out.println("error pannel not present");
			}
		}
		SwitchToDefaultFrame();
	}

	public void addaccounttype(String isoAccountType) {
		addAccountType.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe("Add Account Type");
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ISOAccountType);
		SelectDropDownByText(ISOAccountType, isoAccountType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(HostAccountType);
		enterText(HostAccountType, CustomUtils.randomNumbers(2));
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(AccountDescription, "Saving Account");
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		try {
			addWicketAjaxListeners(getFinder().getWebDriver());
			if (PanelErrorTxt.isVisible()) {
				waitForElementVisible(CancelBtn);
				ClickButton(CancelBtn);
			}
		} catch (Exception e) {
			SwitchToDefaultFrame();
			CustomUtils.ThreadDotSleep(1000);
		}
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
