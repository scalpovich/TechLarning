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
public class TransactionLimitPlanPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addTransactionLimitPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitPlanCode:input:inputTextField")
	private MCWebElement TransactionLimitPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planType:input:dropdowncomponent")
	private MCWebElement PlanType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnLimitYearStartMonth:input:dropdowncomponent")
	private MCWebElement StartMonthForYearlyLimits;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement TransactionType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionSource:input:dropdowncomponent")
	private MCWebElement TransactionSource;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionChannel:input:dropdowncomponent")
	private MCWebElement TransactionChannel;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement TransactionOrigin;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minAmount:input:inputAmountField")
	private MCWebElement FloorAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "perTxnAmt:input:inputAmountField")
	private MCWebElement CeilingAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "standInTxnOffAmt:input:inputAmountField")
	private MCWebElement StandInAmount;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addtransactionlimitplan(String product, String planType, String flooramount, String ceilingamount,
			String startMonthForYearlyLimits) {
		addTransactionLimitPlan.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
		enterText(TransactionLimitPlanCode, CustomUtils.randomNumbers(5));
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "transaction limit plan");
		SelectDropDownByText(ProductType, product);
		SelectDropDownByText(StartMonthForYearlyLimits, startMonthForYearlyLimits);

		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(PlanType, planType);
		ClickButton(save);
		addTransactionLimitDetails(flooramount, ceilingamount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_PLAN_FRAME);
		ClickButton(save);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
	}

	public void addTransactionLimitDetails(String flooramount, String ceilingamount) {
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_TRANSACTION_LIMIT_DETAIL_PLAN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionType, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionSource, 1);
		SelectDropDownByIndex(TransactionChannel, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(TransactionOrigin, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(FloorAmount, flooramount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(CeilingAmount, ceilingamount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(StandInAmount, ceilingamount);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		SwitchToDefaultFrame();
	}

	public void addtransactionlimitplanprepaid() {
		addTransactionLimitPlan.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// TransactionLimitPlanCode.sendKeys(env.getProperty("is.dinners.transactionlimitplan.TransactionLimitPlanCode"));
		TransactionLimitPlanCode.sendKeys(CustomUtils.randomNumbers(5));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.transactionlimitplanpr.Description"));
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		PlanType.getSelect().selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.PlanType"));
		CustomUtils.ThreadDotSleep(1000);
		StartMonthForYearlyLimits.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.StartMonthForYearlyLimits"));
		CustomUtils.ThreadDotSleep(1000);

		save2.click();
		CustomUtils.ThreadDotSleep(2000);

		addSubDetails.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_16");
		CustomUtils.ThreadDotSleep(2000);

		TransactionType.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.TransactionType"));
		CustomUtils.ThreadDotSleep(1000);
		TransactionSource.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.TransactionSource"));
		CustomUtils.ThreadDotSleep(1000);
		TransactionChannel.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.TransactionChannel"));
		CustomUtils.ThreadDotSleep(1000);
		TransactionOrigin.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.transactionlimitplanpr.TransactionOrigin"));
		CustomUtils.ThreadDotSleep(1000);
		FloorAmount.sendKeys(env.getProperty("is.dinners.transactionlimitplanpr.FloorAmount"));
		CustomUtils.ThreadDotSleep(1000);
		CeilingAmount.sendKeys(env.getProperty("is.dinners.transactionlimitplanpr.CeilingAmount"));
		CustomUtils.ThreadDotSleep(1000);
		// StandInAmount.sendKeys(env.getProperty("is.dinners.transactionlimitplan.StandInAmount"));

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
