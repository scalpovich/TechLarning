package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_WALLET_CONFIGURATION, CardManagementNav.L3_WALLET_PLAN })
public class WalletPlanPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(WalletPlanPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addWalletPlanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode:input:inputTextField")
	private MCWebElement walletPlancodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanType:input:dropdowncomponent")
	private MCWebElement programeTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletUsage:input:dropdowncomponent")
	private MCWebElement usageDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditPlan:input:dropdowncomponent")
	private MCWebElement creditPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:billingCycleCode:input:dropdowncomponent")
	private MCWebElement billingCycleCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:dummyAccountNumber:input:inputTextField")
	private MCWebElement dummyAccountNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:minBalanceForTxn:input:inputAmountField")
	private MCWebElement reservedAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletFeePlanCode:input:dropdowncomponent")
	private MCWebElement walletFeePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:whiteListedMcgCode:input:dropdowncomponent")
	private MCWebElement whiteListedMCGPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:whiteListedMidPlan:input:dropdowncomponent")
	private MCWebElement whiteListedMerchantPlanDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'buttons:next'][@value ='Next >']")
	private MCWebElement nextBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement finishBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement panelError;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement panelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "///div[3]/div[4]/div[2]/div[2]/span/div[1]/ul/li/span")
	private MCWebElement msg;

	public void clickaddWalletPLan() {
		clickWhenClickable(addWalletPlanBtn);
		switchToAddWalletPlanFrame();
	}

	public void switchToAddWalletPlanFrame() {
		switchToIframe(Constants.ADD_WALLET_PLAN_FRAME);
	}

	public String enterWalletPlanCode() {
		if (MapUtils.fnGetInputDataFromMap("WalletPlancode") != null) {
			enterValueinTextBox(walletPlancodeTxt, MapUtils.fnGetInputDataFromMap("WalletPlancode"));
		} else {
			enterValueinTextBox(walletPlancodeTxt, CustomUtils.randomNumbers(5));
		}
		return walletPlancodeTxt.getAttribute("value");
	}

	public String enterWalletPlanDescription() {
		if (MapUtils.fnGetInputDataFromMap("WalletPlanDescription") != null) {
			enterValueinTextBox(descriptionTxt, MapUtils.fnGetInputDataFromMap("WalletPlanDescription"));
		} else {
			enterValueinTextBox(descriptionTxt, "wallet plan");
		}
		return descriptionTxt.getAttribute("value");

	}

	public void selectCurrency(WalletPlan walletplan) {
		selectByVisibleText(currencyDDwn, walletplan.getCurrency());
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(productTypeDDwn, deviceCreation.getProduct());
	}

	public void selectProgramType(WalletPlan walletplan) {
		selectByVisibleText(programeTypeDDwn, walletplan.getProgramType());
	}

	public void selectOpenWalletUsage() {
		if (usageDDwn.isEnabled()) {
			selectByVisibleText(usageDDwn, "Open Loop");
		}
	}
	public void selectWalletUsage(WalletPlan walletplan) {
		if (usageDDwn.isEnabled()) {
			selectByVisibleText(usageDDwn, walletplan.getWalletPlanUsage());
		}
	}
	public void selectClosedWalletUsage() {
		if (usageDDwn.isEnabled()) {
			selectByVisibleText(usageDDwn, "Closed Loop");
		}
	}

	public void enterDummyAccountNumber() {
		if (dummyAccountNumberTxt.isEnabled()) {
			enterValueinTextBox(dummyAccountNumberTxt, CustomUtils.randomNumbers(16));
		}
	}

	public void enterReservedAmount() {
		if (reservedAmountTxt.isEnabled()) {
			enterValueinTextBox(reservedAmountTxt, "1" + CustomUtils.randomNumbers(5));
		}
	}

	public void selectWhiteListedMCGPlan() {
		if (whiteListedMCGPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(whiteListedMCGPlanDDwn, 1);
		}
	}

	public void selectWhiteListedMerchantPlan() {
		if (whiteListedMerchantPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(whiteListedMerchantPlanDDwn, 1);
		}
	}

	public void clickNextButton() {
		clickWhenClickable(nextBtn);
	}

	public void clickFinishButton() {
		clickWhenClickable(finishBtn);
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnWalletPlanPagePage() {
		return publishErrorOnPage();
	}

	public void verifyWalletPlanSuccess() {
		if (!verifyErrorsOnWalletPlanPagePage()) {
			logger.info("Wallet Plan Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public String addWalletPlanGeneral(DeviceCreation devicecreation, WalletPlan walletplan) {
		String walletPlancode;
		String walletPlanDesc;
		walletPlancode = enterWalletPlanCode();
		walletPlanDesc = enterWalletPlanDescription();
		selectCurrency(walletplan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectProduct(devicecreation);
		waitForPageToLoad(getFinder().getWebDriver());
		waitForLoaderToDisappear();
		selectProgramType(walletplan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectWalletUsage(walletplan);
		enterDummyAccountNumber();
		enterReservedAmount();
		return walletPlanDesc + " " + "[" + walletPlancode + "]";
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
