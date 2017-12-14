package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
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
    @Autowired
    KeyValueProvider provider;
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
	private MCWebElement creditPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileWording:input:inputTextField")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileWordAbrv:input:inputTextField")
	private MCWebElement abbreviation;

	@PageElement(findBy = FindBy.NAME, valueToFind = "basePaymentDate:input:dropdowncomponent")
	private MCWebElement paymentDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayPaymentDate:input:inputTextField")
	private MCWebElement paymentDateDays;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidDate:input:dropdowncomponent")
	private MCWebElement unpaidDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayUnpaidDate:input:inputTextField")
	private MCWebElement unpaidDateDays;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionFeePlan:input:dropdowncomponent")
	private MCWebElement transactionRulePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidPerm:input:inputAmountField")
	private MCWebElement minimumDue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "totalUnpaidPerm:input:inputAmountField")
	private MCWebElement totalDue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "paymentPriorityPlan:input:dropdowncomponent")
	private MCWebElement paymentPriorityPlan;
    @PageElement(findBy = FindBy.NAME, valueToFind = "overdrawnPerm:input:inputTextField")
	private MCWebElement allowedPercentage;
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyddwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addcreditplan() {
		clickWhenClickable(addCreditPlan);
		
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		WebElementUtils.enterText(creditPlanCode, CreditCardCreditPlan.createWithProvider(provider).getCreditPlanCode());
		WebElementUtils.enterText(description, CreditCardCreditPlan.createWithProvider(provider).getDescription());
		WebElementUtils.enterText(abbreviation, CreditCardCreditPlan.createWithProvider(provider).getAbbreviation());
		WebElementUtils.selectDropDownByIndex(paymentDate,1);
		waitForElementEnabled(paymentDateDays);
		WebElementUtils.enterText(paymentDateDays,CreditCardCreditPlan.createWithProvider(provider).getPaymentDueDateDays());
		WebElementUtils.selectDropDownByIndex(unpaidDate,1);
		waitForElementEnabled(unpaidDateDays);
		WebElementUtils.enterText(unpaidDateDays,CreditCardCreditPlan.createWithProvider(provider).getUnpaidDateDays());
		WebElementUtils.selectDropDownByIndex(transactionRulePlan, 1);
		WebElementUtils.selectDropDownByIndex(currencyddwn, 1);
		WebElementUtils.enterText(minimumDue, CreditCardCreditPlan.createWithProvider(provider).getMinimumDue());
		WebElementUtils.enterText(totalDue, CreditCardCreditPlan.createWithProvider(provider).getTotalDue());
		WebElementUtils.selectDropDownByIndex(paymentPriorityPlan, 1);
		WebElementUtils.enterText(allowedPercentage, CreditCardCreditPlan.createWithProvider(provider).getAllowedPercentage());
		clickWhenClickable(save);
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
