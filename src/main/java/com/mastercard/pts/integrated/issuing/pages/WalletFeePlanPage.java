package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class WalletFeePlanPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void addWalletFeePlanDetails(String feeamount, String waiveCycle) {

		// Adding child record (Added by Debpriya)
		walletPlanSubdetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_WALLET_FEE_PLAN_DETAILS_FRAME);
		SelectDropDownByIndex(feeType, 1);
		EffectiveDate.click();
		EffectiveDateNxtMonth.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectEffectiveDate.click();
		EndDate.click();
		EndDateNxtMonth.click();
		selectEndDate.click();
		enterText(feeAmount, feeamount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(membershipFeePosting, 1);
		membershipFeePosting.getSelect().selectByIndex(1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(waiveNoOfCycle, waiveCycle);
		ClickButton(save);

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
