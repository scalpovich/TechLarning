package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardBillingCycle;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_CREDIT_CARD,
		CardManagementNav.L3_CREDIT_CARD_BILLING_CYCLE })
public class CreditCardBillingCyclePage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(CreditCardBillingCyclePage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cycleCode]")
	private MCWebElement billingPlanCodeOnMainScreenTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cycleWording]")
	private MCWebElement descriptionOnMainScreenTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cycleCode:input:inputTextField")
	private MCWebElement billingPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cycleWording:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "accClosDay:input:inputTextField")
	private MCWebElement billingCycleDayTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "recProcCount:input:inputTextField")
	private MCWebElement recordsPerBatchForProcessingTxt;

	public void verifyUiOperationStatus() {
		logger.info("Credit Card Billing Cycle");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(billingPlanCodeOnMainScreenTxt),
				WebElementUtils.visibilityOf(descriptionOnMainScreenTxt));
	}

	public void addBillingCycle(CreditCardBillingCycle creditCardBillingCycle) {
		logger.info("Add Credit Card Billing: {}", creditCardBillingCycle);

		performSearchOperationOnMainScreen(creditCardBillingCycle);
		// if records are found then we just have to change the Billing Plan
		// Code to make it work hence setting
		if (!isNoRecordsFoundInTable()) {
			creditCardBillingCycle.setBillingPlanCode(MiscUtils
					.generateRandomNumberBetween2Number(100, 999));
		}

		clickAddNewButton();

		AtomicBoolean canceled = new AtomicBoolean(false);
		// Add Document Checklist section
		runWithinPopup("Add Billing Cycle", () -> {
			WebElementUtils.enterText(billingPlanCodeTxt,
					creditCardBillingCycle.getBillingPlanCode());
			WebElementUtils.enterText(descriptionTxt,
					creditCardBillingCycle.getDescription());
			WebElementUtils.enterText(billingCycleDayTxt,
					creditCardBillingCycle.getBillingCycleDay());
			WebElementUtils.enterText(recordsPerBatchForProcessingTxt,
					creditCardBillingCycle.getRecordsPerBatchForProcessing());
			clickSaveButton();

			canceled.set(verifyAlreadyExistsAndClickCancel());
		});
		// dont vereify status of Operation when duplicate exists
		if (!canceled.get()) {
			verifyOperationStatus();
		} else {
			creditCardBillingCycle.setBillingPlanCode("");
			performSearchOperationOnMainScreen(creditCardBillingCycle);
			creditCardBillingCycle
					.setBillingPlanCode(getFirstColumnValueFromTable());
		}
	}

	private void performSearchOperationOnMainScreen(
			CreditCardBillingCycle creditCardBillingCycle) {
		WebElementUtils.enterText(billingPlanCodeOnMainScreenTxt,
				creditCardBillingCycle.getBillingPlanCode());
		WebElementUtils.enterText(descriptionOnMainScreenTxt,
				creditCardBillingCycle.getDescription());
		clickSearchButton();
	}

}
