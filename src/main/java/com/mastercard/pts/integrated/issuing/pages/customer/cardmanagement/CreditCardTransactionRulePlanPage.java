package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CreditCardPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardTransactionRulePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_CREDIT_CARD,
		CardManagementNav.L3_CREDIT_CARD_TRANSACTION_RULE_PLAN })
public class CreditCardTransactionRulePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(CreditCardPaymentBounceReasonPage.class);
   @Autowired
   TestContext context;
   
   @Autowired
   CreditCardPlan creditCardPlan;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planCode]")
	private MCWebElement transactionRulePlanCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=planName]")
	private MCWebElement descriptionTxt;

	private int counter=0;
	
	public void verifyUiOperationStatus() {
		logger.info("Credit Card Transaction Rule Plan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(transactionRulePlanCodeTxt),
				WebElementUtils.visibilityOf(descriptionTxt));
	}

	public boolean addTransactionRulePlan(
			CreditCardTransactionRulePlan creditCardTransactionRulePlan) {
		logger.info("Add Transaction Rule Plan {}",
				creditCardTransactionRulePlan);

		performSearchOperationOnMainScreen(creditCardTransactionRulePlan);
		// if records are found then we just have to change the Billing Plan
		// Code to make it work hence setting
		waitForPageToLoad(getFinder().getWebDriver());
		checkDuplicacyOfTransactionPlanCode(creditCardTransactionRulePlan);
		clickAddNewButton();

		AtomicBoolean canceled = new AtomicBoolean(false);
		// Add Document Checklist section
		runWithinPopup("Add Transaction Rules Plan",
				() -> {
					SimulatorUtilities.wait(3000);
					WebElementUtils.enterText(transactionRulePlanCodeTxt,
							creditCardTransactionRulePlan
									.getTransactionRulePlanCode());
					WebElementUtils.enterText(descriptionTxt,
							creditCardTransactionRulePlan.getDescription());
					logger.info("TransactionRulePlanCodeAndDescription : {}",creditCardTransactionRulePlan.buildDescriptionAndCode());
					context.put(CreditConstants.TRANSACTION_RULE, creditCardTransactionRulePlan.buildDescriptionAndCode());
					clickAddDetailsButton();
					SimulatorUtilities.wait(4000);
					if (!verifyAlreadyExists()) {
						clickSaveButton();
						creditCardPlan.setErrorStatus(false);
					}
					else
					{
						errorMessagePresence();
						creditCardPlan.setErrorStatus(errorMessagePresence());
						canceled.set(verifyAlreadyExistsAndClickCancel());	
					}
				});
		
		return creditCardPlan.getErrorStatus();
	}

	private void performSearchOperationOnMainScreen(
			CreditCardTransactionRulePlan creditCardTransactionRulePlan) {
		WebElementUtils.enterText(transactionRulePlanCodeTxt,
				creditCardTransactionRulePlan.getTransactionRulePlanCode());
		clickSearchButton();
	}
	
		private void checkDuplicacyOfTransactionPlanCode(CreditCardTransactionRulePlan creditCardTransactionRulePlan) {
			if(!isNoRecordsFoundInTable())
			{
			counter+=1;
			if(counter<2)
			{
				 creditCardTransactionRulePlan.setTransactionRulePlanCode(MiscUtils
						.generateRandomNumberBetween2Number(100, 999));
				 logger.info("transactionRulePlanCode: {}",creditCardTransactionRulePlan.getTransactionRulePlanCode());
				 performSearchOperationOnMainScreen(creditCardTransactionRulePlan);
				 waitForPageToLoad(getFinder().getWebDriver());
				 checkDuplicacyOfTransactionPlanCode(creditCardTransactionRulePlan);
		}
	}
	}

}
