package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AdjustmentTransaction;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AdjustmentTransactionDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_TRANSACTION_MANAGEMENT,
		CardManagementNav.L3_TRANSACTION,
		CardManagementNav.L4_ADJUSTMENT_TRANSACTION })
public class AdjustmentTransactionPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(AdjustmentTransactionPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement voucherNumberSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement adjustmentTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "remittanceNumber:input:inputTextField")
	private MCWebElement voucherNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardNumber:input:inputTextField")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "crAccountNumber:input:dropdowncomponent")
	private MCWebElement walletNumberDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionAmount:input:inputAmountField")
	private MCWebElement adjustmentAmountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#transactionDate")
	private MCWebElement transactionDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionDate:input:dateTimeField:hours")
	private MCWebElement transactionDateHoursTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionDate:input:dateTimeField:minutes")
	private MCWebElement transactionDateMinutesTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "memo:input:textAreaComponent")
	private MCWebElement memoTxt;

	public void pickTransactionDate(LocalDate transactionDate) {
		WebElementUtils.pickDate(transactionDateTxt, transactionDate);
	}

	public void addAdjustmentTransaction(AdjustmentTransaction transaction) {
		logger.info("Create Adjustment Transaction: {}",
				transaction.getVoucherNumber());
		clickAddNewButton();

		runWithinPopup(
				"Add Adjustment Transaction",
				() -> {
					WebElementUtils.selectDropDownByVisibleText(
							adjustmentTypeDDwn, transaction.getAdjustmentType());
					WebElementUtils.enterText(voucherNumberTxt,
							transaction.getVoucherNumber());
					clickAddDetailsButton();
					transaction.getAdjustmentTransactionDetails().forEach(
							this::addAdjustmentTransactionDetails);
					clickSaveButton();
				});

		verifyOperationStatus();
	}

	public void addAdjustmentTransactionDetails(
			AdjustmentTransactionDetails transactionDetails) {
		logger.info("Add Adjustment Transaction Details: {}",
				transactionDetails.getDeviceNumber());
		SimulatorUtilities.wait(200);
		clickAddNewButton();
		runWithinPopup("Add Adjustment Transaction Details", () -> {
			WebElementUtils.enterText(deviceNumberTxt, transactionDetails.getDeviceNumber());
			WebElementUtils.asWebElement(deviceNumberTxt).sendKeys(Keys.TAB);
			waitForWicket();
			SimulatorUtilities.wait(500);
			logger.info("Wallet Details: {}",transactionDetails.getWalletNumber());
			WebElementUtils.selectDropDownByVisibleText(walletNumberDDwn, transactionDetails.getWalletNumber());
			WebElementUtils.enterText(adjustmentAmountTxt, transactionDetails.getAdjustmentAmount());
			pickTransactionDate(transactionDetails.getTransactionDate());
			WebElementUtils.enterText(transactionDateHoursTxt, transactionDetails.getTransactionDateHours());
			WebElementUtils.enterText(transactionDateMinutesTxt, transactionDetails.getTransactionDateMinutes());
			WebElementUtils.enterText(memoTxt, transactionDetails.getMemo());
			clickSaveButton();
		});

	}
	
	public void verifyUiOperationStatus() {
		logger.info("Adjustment Transaction");
		verifyUiOperationNoEdit("Add Adjustment Transaction");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.elementToBeClickable(voucherNumberSearchTxt));
	}

}
