package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
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
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_WALLET_CONFIGURATION,
		CardManagementNav.L3_WALLET_FEE_PLAN })
public class WalletFeePlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(WalletFeePlanPage.class);
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=walletFeePlanCode]")
	private MCWebElement walletFeePlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement currency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addWalletFeePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "walletFeePlanCode:input:inputTextField")
	private MCWebElement Plancode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement Currency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement walletPlanSubdetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeType:input:dropdowncomponent")
	private MCWebElement feeType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[2]/span/span/span/img")
	private MCWebElement EffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement EffectiveDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[4]//a[contains(text(), 'Next Month')]")
	private MCWebElement EndDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[2]/span/span/span/span/table/tbody/tr[5]/td[4]/a")
	private MCWebElement selectEffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[4]/span/span/span/img")
	private MCWebElement EndDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[2]/td[4]/span/span/span/span/table/tbody/tr[5]/td[4]/a")
	private MCWebElement selectEndDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeAmt:input:inputAmountField")
	private MCWebElement feeAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "membershipPeriod:input:dropdowncomponent")
	private MCWebElement membershipFeePosting;

	@PageElement(findBy = FindBy.NAME, valueToFind = "waiveNumOfCycle:input:inputTextField")
	private MCWebElement waiveNoOfCycle;

	public void clickAddWalletFeePlan() {
		waitForElementVisible(addWalletFeePlan);
		addWalletFeePlan.click();
	}

	public void switchToAddFeeWalletPlanFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_FEE_WALLET_PLAN_FRAME);
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public String enterPlanCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Plancode, CustomUtils.randomNumbers(6));
		return Plancode.getAttribute("value");
	}

	public String enterDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Corporate gift prepaid emv");
		return Description.getAttribute("value");
	}

	public void selectCurrency() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(Currency, walletfeeplanDataProvider().getCurrency());
	}

	public void clickSaveButton() {
		waitForElementVisible(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void clickAddWalletPlanDetails() {
		switchToIframe(Constants.ADD_FEE_WALLET_PLAN_FRAME);
		waitForElementVisible(walletPlanSubdetails);
		walletPlanSubdetails.click();
	}

	public void switchToAddWalletFeePlanDetailsFrame() {
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_WALLET_FEE_PLAN_DETAILS_FRAME);
	}

	public void selectFeeType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(feeType);
		selectByVisibleText(feeType, getWalletFeePlanType());
	}

	public void selectDate() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EffectiveDate);
		EffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EffectiveDateNxtMonth);
		EffectiveDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(selectEffectiveDate);
		selectEffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EndDate);
		EndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDateNxtMonth.click();
		selectEndDate.click();
	}

	public void enterFeeAmount() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(feeAmount, walletfeeplanDataProvider().getFeeAmount());
	}

	public void selectMemberFeePosting() {
		waitForElementVisible(membershipFeePosting);
		SelectDropDownByIndex(membershipFeePosting, 1);
	}

	public void enterWaiverCycle() {
		waitForElementVisible(waiveNoOfCycle);
		enterText(waiveNoOfCycle, walletfeeplanDataProvider().getWaiverPeriod());
	}

	public void addwalletfeeplan(String product, String currency, String fee, String waiveCycle) {
		addWalletFeePlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_FEE_WALLET_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductType, product);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Plancode, CustomUtils.randomNumbers(6));
		enterText(Description, "Corporate gift prepaid emv");
		SelectDropDownByText(ProductType, product);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(Currency, currency);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addWalletFeePlanDetails(fee, waiveCycle);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_FEE_WALLET_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(save);
		CustomUtils.ThreadDotSleep(1000);
		ClickButton(save);
		CustomUtils.ThreadDotSleep(1000);
		waitForElementVisible(addWalletFeePlan);
		SwitchToDefaultFrame();

	}

	public void addWalletFeePlanDetails(String feeamount, String waiveCycle) {

		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(walletPlanSubdetails);
		walletPlanSubdetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_WALLET_FEE_PLAN_DETAILS_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(feeType);
		SelectDropDownByIndex(feeType, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EffectiveDate);
		EffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EffectiveDateNxtMonth);
		EffectiveDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(selectEffectiveDate);
		selectEffectiveDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(EndDate);
		EndDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		EndDateNxtMonth.click();
		selectEndDate.click();
		enterText(feeAmount, feeamount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(membershipFeePosting);
		SelectDropDownByIndex(membershipFeePosting, 1);
		membershipFeePosting.getSelect().selectByIndex(1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(waiveNoOfCycle);
		enterText(waiveNoOfCycle, waiveCycle);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(save);
		ClickButton(save);

	}
	public void verifyUiOperationStatus() {
		logger.info("Wallet Fee Plan");
		verifyUiOperation("Add Wallet Fee Plan");
	}
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(walletFeePlanCode),
				WebElementUtils.elementToBeClickable(description),
				WebElementUtils.elementToBeClickable(currency),
				WebElementUtils.elementToBeClickable(productType));
	}

}
