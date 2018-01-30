package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_CREDIT_CARD,
		CardManagementNav.L3_CREDIT_CARD_CREDIT_PLAN })
public class CreditCardCreditPlanPage extends AbstractBasePage {
    
	@Autowired
	private TestContext context;
	private static final Logger logger = LoggerFactory
			.getLogger(CreditCardCreditPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileCode]")
	private MCWebElement creditPlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWording]")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWordAbrv]")
	private MCWebElement abbreviationTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "basePaymentDate:input:dropdowncomponent")
	private MCWebElement paymentDateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayPaymentDate:input:inputTextField")
	private MCWebElement paymentDueDateDaysTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidDate:input:dropdowncomponent")
	private MCWebElement unpaidDateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayUnpaidDate:input:inputTextField")
	private MCWebElement unpaidDateDaysTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionFeePlan:input:dropdowncomponent")
	private MCWebElement transactionRuleDateDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currenyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidPerm:input:inputAmountField")
	private MCWebElement minimumDueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "totalUnpaidPerm:input:inputAmountField")
	private MCWebElement totalDueTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "paymentPriorityPlan:input:dropdowncomponent")
	private MCWebElement paymentPriorityPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "overdrawnPerm:input:inputTextField")
	private MCWebElement allowedPercentageTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelERROR']")
	private MCWebElement errorMsgTxt;

	public void verifyUiOperationStatus() {
		logger.info("Credit Card Credit Plan Page");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(creditPlanCodeTxt),
				WebElementUtils.visibilityOf(descriptionTxt),
				WebElementUtils.visibilityOf(abbreviationTxt));
	}
  
	public boolean addCreditPlan(CreditCardCreditPlan creditCardCreditPlan) {
		logger.info("Add Credit Plan {}", creditCardCreditPlan);

		performSearchOperationOnMainScreen(creditCardCreditPlan);
		// if records are found then we just have to change the Billing Plan
		// Code to make it work hence setting
		waitForPageToLoad(getFinder().getWebDriver());
		checkDuplicacyOfCreditPlanCode(creditCardCreditPlan);
		
        clickAddNewButton();
		// Add Document Checklist section
		runWithinPopup("Add Credit Plan", () -> {
			WebElementUtils.enterText(creditPlanCodeTxt, creditCardCreditPlan.getCreditPlanCode());
			WebElementUtils.enterText(descriptionTxt, creditCardCreditPlan.getDescription());
			WebElementUtils.enterText(abbreviationTxt, creditCardCreditPlan.getAbbreviation());
			WebElementUtils.selectDropDownByVisibleText(paymentDateDDwn, creditCardCreditPlan.getPaymentDate());
			WebElementUtils.enterTextIfControlIsEnabled(paymentDueDateDaysTxt, creditCardCreditPlan.getPaymentDueDateDays());
			WebElementUtils.selectDropDownByVisibleText(unpaidDateDDwn, creditCardCreditPlan.getUnpaidDate());
			WebElementUtils.enterTextIfControlIsEnabled(unpaidDateDaysTxt, creditCardCreditPlan.getUnpaidDateDays());
			if(context.get(ContextConstants.BILLING_CYCLE_CODE_ERROR_STATUS).equals(true))
			{
				WebElementUtils.selectDropDownByIndex(transactionRuleDateDDwn, 1);
			}
			else
			{
			WebElementUtils.selectDropDownByVisibleText(transactionRuleDateDDwn, creditCardCreditPlan.getTransactionRulePlan());
			}
			WebElementUtils.selectDropDownByVisibleText(currenyDDwn, creditCardCreditPlan.getCurreny());
			WebElementUtils.enterText(minimumDueTxt, creditCardCreditPlan.getMinimumDue());
			WebElementUtils.enterText(totalDueTxt, creditCardCreditPlan.getTotalDue());
			WebElementUtils.selectDropDownByVisibleText(paymentPriorityPlanDDwn, creditCardCreditPlan.getPaymentPriorityPlan());
			WebElementUtils.enterText(allowedPercentageTxt, creditCardCreditPlan.getAllowedPercentage());
			clickSaveButtonWithOutWicket();
			if(errorMessagePresence()){
			clickCancelButton();
			waitForPageToLoad(getFinder().getWebDriver());
			}
		    waitForPageToLoad(getFinder().getWebDriver());
		});
		verifyOperationStatus();
		return errorMessagePresence();
	}

	private void checkDuplicacyOfCreditPlanCode(CreditCardCreditPlan creditCardCreditPlan) {
		if(!isNoRecordsFoundInTable())
		{
			 creditCardCreditPlan.setCreditPlanCode(MiscUtils.generateRandomNumberBetween2Number(100, 999));
			 logger.info("creditPlanCode: {}",creditCardCreditPlan.getCreditPlanCode());
			 performSearchOperationOnMainScreen(creditCardCreditPlan);
			 waitForPageToLoad(getFinder().getWebDriver());
			 checkDuplicacyOfCreditPlanCode(creditCardCreditPlan);
		}
	}

	private void performSearchOperationOnMainScreen(
			CreditCardCreditPlan creditCardCreditPlan) {
		WebElementUtils.enterText(creditPlanCodeTxt,creditCardCreditPlan.getCreditPlanCode());
		clickSearchButton();
	}
}
