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
	private MCWebElement WalletPlancodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement CurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanType:input:dropdowncomponent")
	private MCWebElement ProgrameTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletUsage:input:dropdowncomponent")
	private MCWebElement UsageDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditPlan:input:dropdowncomponent")
	private MCWebElement CreditPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:billingCycleCode:input:dropdowncomponent")
	private MCWebElement BillingCycleCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:dummyAccountNumber:input:inputTextField")
	private MCWebElement DummyAccountNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:minBalanceForTxn:input:inputAmountField")
	private MCWebElement ReservedAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletFeePlanCode:input:dropdowncomponent")
	private MCWebElement WalletFeePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:whiteListedMcgCode:input:dropdowncomponent")
	private MCWebElement WhiteListedMCGPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:whiteListedMidPlan:input:dropdowncomponent")
	private MCWebElement WhiteListedMerchantPlanDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'buttons:next'][@value ='Next >']")
	private MCWebElement NextBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement finishBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement CancelBtn;

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
			enterValueinTextBox(WalletPlancodeTxt, MapUtils.fnGetInputDataFromMap("WalletPlancode"));
		} else {
			enterValueinTextBox(WalletPlancodeTxt, CustomUtils.randomNumbers(5));
		}
		return WalletPlancodeTxt.getAttribute("value");
	}

	public String enterWalletPlanDescription() {
		if (MapUtils.fnGetInputDataFromMap("WalletPlanDescription") != null) {
			enterValueinTextBox(DescriptionTxt, MapUtils.fnGetInputDataFromMap("WalletPlanDescription"));
		} else {
			enterValueinTextBox(DescriptionTxt, "wallet plan");
		}
		return DescriptionTxt.getAttribute("value");

	}

	public void selectCurrency(WalletPlan walletplan) {
		selectByVisibleText(CurrencyDDwn, walletplan.getCurrency());
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public void selectProgramType(WalletPlan walletplan) {
		selectByVisibleText(ProgrameTypeDDwn, walletplan.getProgramType());
	}

	public void selectWalletUsage(WalletPlan walletplan) {
		if (UsageDDwn.isEnabled()) {
			selectByVisibleText(UsageDDwn, walletplan.getWalletPlanUsage());
		}
	}

	public void enterDummyAccountNumber() {
		if (DummyAccountNumberTxt.isEnabled()) {
			enterValueinTextBox(DummyAccountNumberTxt, CustomUtils.randomNumbers(16));
		}
	}

	public void enterReservedAmount() {
		if (ReservedAmountTxt.isEnabled()) {
			enterValueinTextBox(ReservedAmountTxt, "1" + CustomUtils.randomNumbers(5));
		}
	}

	public void selectWhiteListedMCGPlan() {
		if (WhiteListedMCGPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(WhiteListedMCGPlanDDwn, 1);
		}
	}

	public void selectWhiteListedMerchantPlan() {
		if (WhiteListedMerchantPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(WhiteListedMerchantPlanDDwn, 1);
		}
	}

	public void clickNextButton() {
		clickWhenClickable(NextBtn);
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
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public String addWalletPlanGeneral(DeviceCreation devicecreation, WalletPlan walletplan) {
		String walletPlancode;
		String WalletPlanDesc;
		walletPlancode = enterWalletPlanCode();
		WalletPlanDesc = enterWalletPlanDescription();
		selectCurrency(walletplan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectProduct(devicecreation);
		waitForPageToLoad(getFinder().getWebDriver());
		selectProgramType(walletplan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectWalletUsage(walletplan);
		enterDummyAccountNumber();
		enterReservedAmount();
		return WalletPlanDesc + " " + "[" + walletPlancode + "]";
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
