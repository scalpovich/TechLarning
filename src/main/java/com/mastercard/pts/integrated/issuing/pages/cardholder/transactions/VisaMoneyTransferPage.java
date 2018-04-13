package com.mastercard.pts.integrated.issuing.pages.cardholder.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.TransactionsNav;
import com.mastercard.pts.integrated.issuing.domain.cardholder.transactions.VisaMoneyTransfer;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_VISA_MONEY_TRANSFER })
public class VisaMoneyTransferPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(VisaMoneyTransferPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(),'Wallet Number')]/following-sibling::td[1]")
	private MCWebElement walletNumberLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(),'Device Number')]/following-sibling::td[1]")
	private MCWebElement deviceNumberLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(),'Available Balance')]/following-sibling::td[1]")
	private MCWebElement availableBalanceLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=toDeviceNumber]")
	private MCWebElement beneficiaryCardNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=transactionAmount]")
	private MCWebElement transferAmountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name=selectedTxnCurrency]")
	private MCWebElement currencyOfTransferDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=beneficiaryContactNumber]")
	private MCWebElement beneficiaryContactNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=beneficiaryName]")
	private MCWebElement beneficiaryNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=memo]")
	private MCWebElement memoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=txnPassword]")
	private MCWebElement txnPasswordTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=remarks]")
	private MCWebElement remarksTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='SuccessMessageTxt']")
	private MCWebElement responseLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'VISA Fast Fund (Real Time)')]/../input[@type='radio']")
	private MCWebElement visaFastFundRealTimeRadioBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'VISA Money Transfer (Offline)')]/../input[@type='radio']")
	private MCWebElement visaMoneyTransferOfflineRadioBtn;

	public void verifyUiOperationStatus() {
		logger.info("VISA MONEY TRANSFER");
		verifyTitleCardHolderPortal("VISA MONEY TRANSFER");
	}

	public boolean verifyCardAndAmount() {
		return walletNumberLbl.getText().length() > 0 && deviceNumberLbl.getText().length() > 0 && transferAmountTxt.getText().length() > 0;
	}

	public void doTransaction(VisaMoneyTransfer vmt, Device device) {
		WebElementUtils.enterText(beneficiaryCardNumberTxt, device.getDeviceNumber());
		// WebElementUtils.enterText(beneficiaryCardNumberTxt, vmt.getBeneficiaryCardNumber());
		WebElementUtils.enterText(transferAmountTxt, vmt.getTransferAmount());
		WebElementUtils.selectDropDownByVisibleText(currencyOfTransferDDwn, vmt.getCurrencyOfTransfer());
		WebElementUtils.selectRadioIfNotSelected(visaFastFundRealTimeRadioBtn);
		clickSubmitButton();
	}

	public void doOfflineTransaction(VisaMoneyTransfer vmt, Device device) {
		WebElementUtils.enterText(beneficiaryCardNumberTxt, device.getDeviceNumber());
		// WebElementUtils.enterText(beneficiaryCardNumberTxt, vmt.getBeneficiaryCardNumber());
		WebElementUtils.enterText(transferAmountTxt, vmt.getTransferAmount());
		WebElementUtils.selectDropDownByVisibleText(currencyOfTransferDDwn, vmt.getCurrencyOfTransfer());
		WebElementUtils.selectRadioIfNotSelected(visaMoneyTransferOfflineRadioBtn);
		clickSubmitButton();
	}

	public void confirmTransaction(VisaMoneyTransfer vmt) {
		WebElementUtils.enterText(txnPasswordTxt, vmt.getTransactionPassword());
		WebElementUtils.enterText(remarksTxt, vmt.getTransactionRemarks());
		clickConfirmButton();
	}

	public String verifyResponse() {
		waitForElementVisible(responseLbl);
		String msg = responseLbl.getText();
		logger.info("Response Message on UI - {}", msg);
		return msg;
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle));
	}
}
