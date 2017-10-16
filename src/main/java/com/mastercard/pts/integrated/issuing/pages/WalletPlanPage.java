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
public class WalletPlanPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addWalletPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode:input:inputTextField")
	private MCWebElement WalletPlancode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement Currency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanType:input:dropdowncomponent")
	private MCWebElement ProgrameType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletUsage:input:dropdowncomponent")
	private MCWebElement Usage;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditPlan:input:dropdowncomponent")
	private MCWebElement CreditPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:billingCycleCode:input:dropdowncomponent")
	private MCWebElement BillingCycleCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:dummyAccountNumber:input:inputTextField")
	private MCWebElement DummyAccountNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:minBalanceForTxn:input:inputAmountField")
	private MCWebElement ReservedAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletFeePlanCode:input:dropdowncomponent")
	private MCWebElement WalletFeePlan;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'buttons:next'][@value ='Next >']")
	private MCWebElement Next;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement finish;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "///div[3]/div[4]/div[2]/div[2]/span/div[1]/ul/li/span")
	private MCWebElement msg;

	public void addwalletplan(String currency, String product, String programType, String walletplanUsage,
			String dummyAcctNumber) {
		addWalletPlan.click();
		switchToIframe(Constants.ADD_WALLET_PLAN_FRAME);
		enterText(WalletPlancode, CustomUtils.randomNumbers(5));
		enterText(Description, "wallet plan");
		SelectDropDownByText(Currency, currency);
		SelectDropDownByText(ProductType, product);
		SelectDropDownByText(ProgrameType, programType);
		SelectDropDownByText(Usage, walletplanUsage);
		enterText(DummyAccountNumber, dummyAcctNumber);
		ClickButton(Next);
		addWicketAjaxListeners(getFinder().getWebDriver());
		finish.click();
		SwitchToDefaultFrame();
		// Assert.isTrue(expression);
		// Verify.verify(expression);

	}

	public void addwalletplanprepaid() {
		addWalletPlan.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// WalletPlancode.sendKeys(env.getProperty("is.dinners.walletplan.WalletPlancode"));
		WalletPlancode.sendKeys(CustomUtils.randomNumbers(5));
		CustomUtils.ThreadDotSleep(2000);
		Description.sendKeys(env.getProperty("is.dinners.walletplanpr.Description"));
		Currency.getSelect().selectByVisibleText(env.getProperty("is.dinners.walletplanpr.Currency"));
		CustomUtils.ThreadDotSleep(2000);
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.walletplanpr.ProductType"));
		CustomUtils.ThreadDotSleep(2000);
		ProgrameType.getSelect().selectByVisibleText(env.getProperty("is.dinners.walletplanpr.ProgrameType"));
		CustomUtils.ThreadDotSleep(2000);
		Usage.getSelect().selectByVisibleText(env.getProperty("is.dinners.walletplanpr.Usage"));
		CustomUtils.ThreadDotSleep(2000);

		ReservedAmount.sendKeys(env.getProperty("is.dinners.walletplanpr.ReservedAmount"));
		CustomUtils.ThreadDotSleep(2000);

		// WalletFeePlan.getSelect().selectByVisibleText(env.getProperty("is.dinners.walletplan.WalletFeePlan"));
		/*
		 * WalletFeePlan.getSelect().selectByIndex(1);
		 * CustomUtils.ThreadDotSleep(2000);
		 */

		/*
		 * Next.click(); CustomUtils.ThreadDotSleep(3000);
		 */
		Next.click();
		CustomUtils.ThreadDotSleep(3000);

		finish.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
