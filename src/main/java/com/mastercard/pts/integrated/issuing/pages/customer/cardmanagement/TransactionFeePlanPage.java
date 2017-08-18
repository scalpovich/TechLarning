package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L3_TRANSACTION_FEE_PLAN
		})

public class TransactionFeePlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(TransactionFeePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=txnFeePlanCode]")
	private MCWebElement txnFeePlanCodeTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement transactionTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement walletCurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement transactionSourceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement transactionOriginDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='txnFeePlanStartDate']/..")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='txnFeePlanEndDate']/..")
	private MCWebElement endDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fromTxnAmount:input:inputAmountField")
	private MCWebElement fromAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "toTxnAmount:input:inputAmountField")
	private MCWebElement toAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fixFee:input:inputAmountField")
	private MCWebElement fixTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rate:input:inputAmountField")
	private MCWebElement rateTxt;

	public void verifyUiOperationStatus() {
		logger.info("Transaction Fee Plan Master");
		verifyUiOperation("Add Transaction Fee Plan Master");
	}

	public void addTransactionFeePlanMasterDetail(TransactionFeePlan plan){
		logger.info("Create transaction Fee Plan Master: {}",
				plan.getTransactionFeePlanCode());
		clickAddNewButton();
		runWithinPopup("Add Transaction Fee Plan Master",() -> {
					WebElementUtils.enterText(txnFeePlanCodeTxt, plan.getTransactionFeePlanCode());
					WebElementUtils.enterText(descriptionTxt, plan.getDescription());
					clickAddDetailsButton();
					addTransactionFeePlanDetails(plan);
					clickSaveButton();
				});
	}

	private void addTransactionFeePlanDetails(TransactionFeePlan plan){
		clickAddNewButton();
		runWithinPopup("Add Transaction Fee Plan Details",() -> {
					WebElementUtils.selectDropDownByVisibleText(transactionTypeDDwn, plan.getTransactionType());
					WebElementUtils.selectDropDownByVisibleText(walletCurrencyDDwn, plan.getWalletCurrency());
					WebElementUtils.selectDropDownByVisibleText(transactionSourceDDwn, plan.getTransactionSource());
					WebElementUtils.selectDropDownByVisibleText(transactionOriginDDwn, plan.getTransactionOrigin());
					WebElementUtils.pickDate(effectiveDateTxt, plan.getEffectiveDate());
					WebElementUtils.pickDate(endDateTxt, plan.getEndDate());
					WebElementUtils.enterText(fromAmountTxt, plan.getFromAmount());
					WebElementUtils.enterText(toAmountTxt, plan.getToAmount());
					WebElementUtils.enterText(fixTxt, plan.getFix());
					WebElementUtils.enterText(rateTxt, plan.getRate());
					clickSaveButton();								
				});
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(txnFeePlanCodeTxt),
				WebElementUtils.elementToBeClickable(descriptionTxt)
				);
	}
}
