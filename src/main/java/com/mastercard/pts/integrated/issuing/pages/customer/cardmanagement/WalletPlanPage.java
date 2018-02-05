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
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_WALLET_CONFIGURATION, CardManagementNav.L3_WALLET_PLAN })
public class WalletPlanPage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(WalletPlanPage.class);
	private static final int FIRST_OPTION = 1;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addWalletPlanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode:input:inputTextField")
	private MCWebElement walletPlancodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='walletPlanCode']")
	private MCWebElement walletPlancodeSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:txnLimitPlanCode:input:dropdowncomponent")
	private MCWebElement transactionLimitPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:minBalanceForTxn:input:inputAmountField")
	private MCWebElement reservedAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:surchargePlanCode:input:dropdowncomponent")
	private MCWebElement surchargePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:surchargeWaiverPlanCode:input:dropdowncomponent")
	private MCWebElement surchargeWaiverPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletFeePlanCode:input:dropdowncomponent")
	private MCWebElement walletFeePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:whiteListedMcgCode:input:dropdowncomponent")
	private MCWebElement whiteListedMCGPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:whiteListedMidPlan:input:dropdowncomponent")
	private MCWebElement whiteListedMerchantPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:mcgAuthBlockingPlan:input:dropdowncomponent")
	private MCWebElement mcgAuthBlockingPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:mcgLimitPlan:input:dropdowncomponent")
	private MCWebElement mcgLimitPlanDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'buttons:next'][@value ='Next >']")
	private MCWebElement nextBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement finishBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:refundAllowed:checkBoxComponent")
	private MCWebElement allowRefundChkBox;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:inactivityDays:input:inputTextField")
	private MCWebElement daysInactiveAfterTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:inactiveToCloseDays:input:inputTextField")
	private MCWebElement daysCloseWalletAfterTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span.feedbackPanelERROR")
	private MCWebElement panelError;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span.feedbackPanelINFO")
	private MCWebElement panelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "///div[3]/div[4]/div[2]/div[2]/span/div[1]/ul/li/span")
	private MCWebElement msg;

	public void clickaddWalletPLan() {
		clickWhenClickable(addWalletPlanBtn);
		switchToAddWalletPlanFrame();
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(productTypeDDwn, deviceCreation.getProduct());
	}

	public void switchToAddWalletPlanFrame() {
		switchToIframe(Constants.ADD_WALLET_PLAN_FRAME);
	}

	public String enterWalletPlanCode(WalletPlan walletPlan) {
		if (walletPlan.getWalletPlanCode().length() != 0) {
			 logger.info(walletPlan.getWalletPlanCode());
			enterValueinTextBox(walletPlancodeTxt, walletPlan.getWalletPlanCode());
		} else {
			enterValueinTextBox(walletPlancodeTxt, "WP" + CustomUtils.randomNumbers(4));
		}
		return walletPlancodeTxt.getAttribute("value");
	}

	// public void enterWalletPlanCode(WalletPlan plan) {
	// enterValueinTextBox(walletPlancodeTxt, plan.getWalletPlanCode());
	// }

	public String enterWalletPlanDescription(WalletPlan walletPlan) {
		if (walletPlan.getDescription().length() != 0) {
			enterValueinTextBox(descriptionTxt, walletPlan.getDescription());
		} else {
			enterValueinTextBox(descriptionTxt, "wallet plan");
		}
		return descriptionTxt.getAttribute("value");

	}

	public void selectCurrency(WalletPlan walletplan) {
		selectByVisibleText(currencyDDwn, walletplan.getCurrency());
	}

	public void checkAllowRefund() {
		ClickButton(allowRefundChkBox);
	}

	public void selectProduct(WalletPlan plan) {
		selectByVisibleText(productTypeDDwn, plan.getProductType());
	}

	public void selectProductType(WalletPlan plan) {
		selectByVisibleText(productTypeDDwn, plan.getProductType());
	}

	public void selectCreditPlan() {
		if (creditPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(creditPlanDDwn, FIRST_OPTION);
		}
	}

	public void selectBillingCycleCode() {
		if (billingCycleCodeDDwn.isEnabled()) {
			SelectDropDownByIndex(billingCycleCodeDDwn, FIRST_OPTION);
		}
	}

	public void selectTransactionLimitPlan() {
		if (transactionLimitPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(transactionLimitPlanDDwn, FIRST_OPTION);
		}
	}

	public void selectSurchargePlan() {
		if (surchargePlanDDwn.isEnabled()) {
			SelectDropDownByIndex(surchargePlanDDwn, FIRST_OPTION);
		}
	}

	public void selectSurchargeWaiverPlan() {
		if (surchargeWaiverPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(surchargeWaiverPlanDDwn, FIRST_OPTION);
		}
	}

	public String addWalletPlanGeneral(DeviceCreation devicecreation, WalletPlan walletplan) {
		String walletPlancode;
		String WalletPlanDesc;
		walletPlancode = enterWalletPlanCode(walletplan);
		WalletPlanDesc = enterWalletPlanDescription(walletplan);
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
		return buildDescriptionAndCode(WalletPlanDesc, walletPlancode);
	}

	public void selectWalletFeePlan() {
		if (walletFeePlanDDwn.isEnabled()) {
			SelectDropDownByIndex(walletFeePlanDDwn, FIRST_OPTION);
		}
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
			// enterValueinTextBox(reservedAmountTxt, "1" +
			// CustomUtils.randomNumbers(5));
			enterValueinTextBox(reservedAmountTxt, "0");
		}
	}

	public void selectWhiteListedMCGPlan() {
		if (whiteListedMCGPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(whiteListedMCGPlanDDwn, FIRST_OPTION);
		}
	}

	public void selectWhiteListedMerchantPlan() {
		if (whiteListedMerchantPlanDDwn.isEnabled()) {
			SelectDropDownByIndex(whiteListedMerchantPlanDDwn, FIRST_OPTION);
		}
	}

	@Override
	public void clickNextButton() {
		clickWhenClickable(nextBtn);
	}

	public void enterInactiveAfterDays() {
		enterValueinTextBox(daysInactiveAfterTxt, CustomUtils.randomNumbers(1));
	}

	public void enterCloseWalletAfterDays() {
		enterValueinTextBox(daysCloseWalletAfterTxt, (CustomUtils.randomNumbers(1) + 1));
	}

	@Override
	public void clickFinishButton() {
		clickWhenClickable(finishBtn);
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnWalletPlanPagePage() {
		return publishErrorOnPage();
	}

	public String getFeedbackInfo() {
		return panelInfo.getText();
	}

	public void searchByWalletPlanCode(WalletPlan plan) {
		enterValueinTextBox(walletPlancodeSearchTxt, plan.getWalletPlanCode());
	}

	public boolean isTextPresentInTable(String text) {
		return WebElementUtils.isTextAvailableinTable(searchTable, text);
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

	public String addWalletPlanGeneral(WalletPlan walletplan) {
		String walletPlancode;
		String walletPlanDesc;
		walletPlancode = enterWalletPlanCode(walletplan);
		walletPlanDesc = enterWalletPlanDescription(walletplan);
		selectCurrency(walletplan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectProduct(walletplan);
		waitForPageToLoad(getFinder().getWebDriver());
		waitForLoaderToDisappear();
		selectProgramType(walletplan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectWalletUsage(walletplan);
		enterDummyAccountNumber();
		enterReservedAmount();
		return buildDescriptionAndCode(walletPlanDesc, walletPlancode);
	}

	public void enterGeneralDetails(WalletPlan plan) {
		enterWalletPlanCode(plan);
		enterWalletPlanDescription(plan);
		selectCurrency(plan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectProductType(plan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectProgramType(plan);
		waitForPageToLoad(getFinder().getWebDriver());
		selectWalletUsage(plan);
	}

	public void enterCreditConfigDetails() {
		selectCreditPlan();
		selectBillingCycleCode();
	}

	public void enterPlanUsageLimitsFeesDetails() {
		selectTransactionLimitPlan();
		selectSurchargePlan();
		selectSurchargeWaiverPlan();
		selectWalletFeePlan();
	}

	public void enterWalletInactivityRuleDetails() {
		enterInactiveAfterDays();
		enterCloseWalletAfterDays();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
