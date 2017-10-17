package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_CREDIT_CARD_BILLING,
		CardManagementNav.L3_CREDIT_PLAN})
public class CreditPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(CreditPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileCode]")
	private MCWebElement profileCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWording]")
	private MCWebElement profileWording;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWordAbrv]")
	private MCWebElement profileWordAbrv;
@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addCreditPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileCode:input:inputTextField")
	private MCWebElement CreditPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileWording:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileWordAbrv:input:inputTextField")
	private MCWebElement Abbreviation;

	@PageElement(findBy = FindBy.NAME, valueToFind = "basePaymentDate:input:dropdowncomponent")
	private MCWebElement PaymentDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayPaymentDate:input:inputTextField")
	private MCWebElement PaymentDateDays;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidDate:input:dropdowncomponent")
	private MCWebElement UnpaidDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayUnpaidDate:input:inputTextField")
	private MCWebElement UnpaidDateDays;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionFeePlan:input:dropdowncomponent")
	private MCWebElement TransactionRulePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidPerm:input:inputAmountField")
	private MCWebElement MinimumDue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "totalUnpaidPerm:input:inputAmountField")
	private MCWebElement TotalDue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "paymentPriorityPlan:input:dropdowncomponent")
	private MCWebElement PaymentPriorityPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "overdrawnPerm:input:inputTextField")
	private MCWebElement AllowedPercentage;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addcreditplan() {
		addCreditPlan.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// CreditPlanCode.sendKeys(env.getProperty("is.dinners.creditplan.CreditPlanCode"));
		CreditPlanCode.sendKeys(CustomUtils.randomNumbers(3));
		Description.sendKeys(env.getProperty("is.dinners.creditplan.Description"));
		Abbreviation.sendKeys(env.getProperty("is.dinners.creditplan.Abbreviation"));
		CustomUtils.ThreadDotSleep(1000);
		PaymentDate.getSelect().selectByVisibleText(env.getProperty("is.dinners.creditplan.PaymentDate"));
		CustomUtils.ThreadDotSleep(1000);
		PaymentDateDays.sendKeys(env.getProperty("is.dinners.creditplan.PaymentDateDays"));
		CustomUtils.ThreadDotSleep(1000);
		UnpaidDate.getSelect().selectByVisibleText(env.getProperty("is.dinners.creditplan.UnpaidDate"));
		CustomUtils.ThreadDotSleep(1000);
		UnpaidDateDays.sendKeys(env.getProperty("is.dinners.creditplan.UnpaidDateDays"));
		CustomUtils.ThreadDotSleep(1000);
		// TransactionRulePlan.getSelect().selectByVisibleText(env.getProperty("is.dinners.creditplan.TransactionRulePlan"));
		TransactionRulePlan.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		MinimumDue.sendKeys(env.getProperty("is.dinners.creditplan.MinimumDue"));
		CustomUtils.ThreadDotSleep(1000);
		TotalDue.sendKeys(env.getProperty("is.dinners.creditplan.TotalDue"));
		CustomUtils.ThreadDotSleep(1000);
		// PaymentPriorityPlan.getSelect().selectByVisibleText(env.getProperty("is.dinners.creditplan.PaymentPriorityPlan"));
		PaymentPriorityPlan.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		AllowedPercentage.sendKeys(env.getProperty("is.dinners.creditplan.AllowedPercentage"));

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Credit Plan");
		verifyUiOperation("Add Credit Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(profileCode),
				WebElementUtils.elementToBeClickable(profileWording),
				WebElementUtils.elementToBeClickable(profileWordAbrv)
				
				);
	}
}
