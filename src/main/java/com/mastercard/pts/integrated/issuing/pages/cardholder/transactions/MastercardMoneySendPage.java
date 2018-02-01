package com.mastercard.pts.integrated.issuing.pages.cardholder.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.TransactionsNav;
import com.mastercard.pts.integrated.issuing.domain.cardholder.transactions.MastercardMoneySend;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_MASTER_CARD_MONEY_SEND })
public class MastercardMoneySendPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(MastercardMoneySendPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//tr[2]/td[2]")
	private MCWebElement walletNumberLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//tr[2]/td[4]")
	private MCWebElement deviceNumberLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//tr[3]/td[2]")
	private MCWebElement availableBalanceLbl;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=toDeviceNumber]")
	private MCWebElement beneficiaryCardNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name=transactionAmount]")
	private MCWebElement transactionAmountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name=selectedTxnCurrency] ")
	private MCWebElement selectedTxnCurrencyDDwn;

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='ResponseTxt']")
	private MCWebElement responseLbl;

	public void verifyUiOperationStatus() {
		logger.info("MasterCard Money Send");
		verifyTitleCardHolderPortal("MasterCard Money Send");
	}

	public boolean verifyCardAndAmount() {
		return walletNumberLbl.getText().length() > 0 && deviceNumberLbl.getText().length() > 0 && transactionAmountTxt.getText().length() > 0;
	}

	public void doTransaction(MastercardMoneySend mms, Device device) {
		WebElementUtils.enterText(beneficiaryCardNumberTxt, device.getDeviceNumber());
		WebElementUtils.enterText(transactionAmountTxt, mms.getTransferAmount());
		WebElementUtils.selectDropDownByVisibleText(selectedTxnCurrencyDDwn, mms.getCurrencyOfTransfer());
		WebElementUtils.enterText(beneficiaryContactNumberTxt, mms.getContactNumber());
		WebElementUtils.enterText(beneficiaryNameTxt, mms.getName());
		WebElementUtils.enterText(memoTxt, mms.getMemo());
		clickSubmitButton();
	}

	public void confirmTransaction(MastercardMoneySend mms) {
		WebElementUtils.enterText(txnPasswordTxt, mms.getTransactionPassword());
		WebElementUtils.enterText(remarksTxt, mms.getTransactionRemarks());
		clickConfirmButton();
	}

	public String verifyResponse() {
		waitForElementVisible(responseLbl);
		return responseLbl.getText();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle));
	}
}
