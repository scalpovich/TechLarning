package com.mastercard.pts.integrated.issuing.pages.cardholder.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderTransactions;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS ,treeMenuItems = { TransactionsNav.L1_FUND_TRANSFER})
public class FundTransferPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(FundTransferPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=VisaMoneyTransfer]")
	private MCWebElement visaMoneyTransferRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=CardtoCard]")
	private MCWebElement cardtoCardRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=InterBankFundTransferPopulateDetails]")
	private MCWebElement interBankFundTransferPopulateDetailsRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=MasterCardMoneySend]")
	private MCWebElement masterCardMoneySendRbtn;
	
	@PageElement(findBy =  FindBy.X_PATH, valueToFind="//input[@value='Continue']")
	private MCWebElement continueBtn;
	
	@PageElement(findBy = FindBy.X_PATH , valueToFind="//input[@id='toDeviceNumber']")
	private MCWebElement benificiaryCardNumber;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='transactionAmount']")
	private MCWebElement transferAmount;
	
	@PageElement(findBy =FindBy.X_PATH, valueToFind="//input[@id='beneficiaryContactNumber']")
	private MCWebElement benifContactNumber;
	
	@PageElement(findBy = FindBy.X_PATH , valueToFind="//input[@id='beneficiaryName']")
	private MCWebElement transferName;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='memo']")
	private MCWebElement memoName;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//select[@id='txnCurrency']")
	private MCWebElement currencyOfTransfer;
	
	@PageElement(findBy = FindBy.X_PATH , valueToFind="//input[@id='mpts_cardHolderPortal_button_submit']")
	private MCWebElement submitButtonCurrecnyTranfer;
	
	@PageElement(findBy = FindBy.NAME , valueToFind="TxtTxnPassword")
	private MCWebElement transactionPassword;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="remarks")
	private MCWebElement transactionRemarks;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='mpts_cardHolderPortal_button_confirm']")
	private MCWebElement confirmButton;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//li[@id='CardToCard']")	
	private MCWebElement walletToWalletTransOption;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="toWalletNumber")	
	private MCWebElement beneficiaryWalletNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="toDeviceNumber")	
	private MCWebElement beneficiaryDeviceNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='transactionAmount']")
	private MCWebElement amountToTransfer;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@id='selectedTxnCurrency']")
	private MCWebElement transferCurrencyOption;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='mpts_cardHolderPortal_button_submit']")
	private MCWebElement submitBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@value='InterBankFundTransferPopulateDetails']")
	private MCWebElement interBankTransfer;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//select[@id='toWalletNumber']")
	private MCWebElement beneficiaryWalletNum;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//select[@id='toDeviceNumber']")
	private MCWebElement benificiaryCardNum;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='transactionAmount']")
	private MCWebElement benificiaryTransferAmount;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="")
	private MCWebElement curranyOfIntraBankTransfer;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[@class='ResponseTxt']")
	private MCWebElement transactionStatusMessage;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[@class='SuccessMessageTxt']")
	private MCWebElement walletToWalletTrntConfirmMessage;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//table[@class='modelFormClass']/tbody/tr[5]/td[2]")
	private MCWebElement availBalanceToWallet;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@class='sectionHead']/td/../following-sibling::tr[1]/td")
	private MCWebElement fundTransferTransaction;
	
	
	public boolean verifyFundsTransferSts(){
		return transactionStatusMessage.isVisible();
	}
	
	public boolean verifyFundTransferSatus(){
		return fundTransferTransaction.isVisible();
	}
	
	
	public String availBalaceIntoWallet(){
		return availBalanceToWallet.getText();
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Fund Transfer");
		verifyTitleCardHolderPortal("Fund Transfer");
		verifyButton("Submit");
		verifyButton("Cancel");
	}
	public void selectTransferMastercardThroughOption(){
		ClickButton(masterCardMoneySendRbtn);
	}
	
	public void selectWalletTransferOptRadio(){
		ClickButton(masterCardMoneySendRbtn);
	}
	public void clickOnContinueFundTransferOption(){
		ClickButton(continueBtn);
	}
	
	public void enterBenificiaryCardNumber(String cardNumber){
		benificiaryCardNumber.sendKeys(cardNumber);
	}
	
	public void enterTransferAmount(String transAmount){
		transferAmount.sendKeys(transAmount);
	}
	
	public void selectCurrencyOfTransfer(String currencyName){
		selectByVisibleTexts(currencyOfTransfer, currencyName);
	}
	
	public void enterContactNumber(String contactNumber){
		benifContactNumber.sendKeys(contactNumber);
	}
	
	public void enterName(String transName){
		transferName.sendKeys(transName);
	}
	
	public void enterMemo(String memo){
		memoName.sendKeys(memo);
	}
	
	public void submitMoneyTransferRequest(){
		submitButtonCurrecnyTranfer.click();
	}
	
	public void enterTransactionPassword(String transPasword){
		transactionPassword.sendKeys(transPasword);
	}
	
	public void enterTransactionRemark(String transaRemarks){
		transactionRemarks.sendKeys(transaRemarks);
	}
	
	public void confirmTransaction(){
		confirmButton.click();
	}	
	
	public String checkTransactionStatus(){
		return transactionStatusMessage.getText();
	}
	
	public String checkWalletToWalletTransferStatusMessage(){		
		return walletToWalletTrntConfirmMessage.getText();
	}
	public void selectWalletToWalletTransferOption(){
		clickWhenClickable(walletToWalletTransOption);		
	}
	
	public void selectIntraBankTransferOption(){
		interBankTransfer.click();
		
	}
	
	public void selectTransferCurrency(String currencyOpt){
		selectByVisibleTexts(transferCurrencyOption,currencyOpt);
	}
	
	public void submitWalletTransferRequest(){
		submitBtn.click();
	}
	
	public void enterBeneficiaryWalletNumber(String walletNumber){
		SelectDropDownByValue(beneficiaryWalletNum, walletNumber);
	}
	
	public void enterBeneficiaryCardNumber(String cardNumber){
		SelectDropDownByValue(benificiaryCardNum, cardNumber);
	}
	
	public void enterAmountToTranfer(String amountToTransfer){
		benificiaryTransferAmount.sendKeys(amountToTransfer);
	}
	
	public void selectCurrencyForIntraBankTranfer(String transferCurrancy){
		selectByVisibleTexts(transferCurrencyOption, transferCurrancy);
	}
		
	public void interBankTransfer(CardHolderTransactions  cardhlfTran){
		enterText(beneficiaryWalletNumberTxt,cardhlfTran.getWalletToAmountTransfer());
		enterText(beneficiaryDeviceNumberTxt,cardhlfTran.getCardNumber());
		enterAmountToTranfer(cardhlfTran.getTransferAmount());
		clickWhenClickable(submitBtn);
		waitForLoaderToDisappear();
		enterText(transactionPassword, cardhlfTran.getTransctionPassword());
		enterText(transactionRemarks, cardhlfTran.getTransactionRemark());
		confirmTransaction();
		waitForLoaderToDisappear();
		Assert.assertTrue(checkWalletToWalletTransferStatusMessage().contains("Your transaction is successful"));
	}

	
	public void walletToWalletTransfer(CardHolderTransactions  cardhlfTran){
		enterBeneficiaryWalletNumber(cardhlfTran.getWalletToAmountTransfer());
		enterBeneficiaryCardNumber(cardhlfTran.getCardNumber());
		enterAmountToTranfer(cardhlfTran.getTransferAmount());		
		clickWhenClickable(submitBtn);
		waitForLoaderToDisappear();
		enterTransactionPassword(cardhlfTran.getTransctionPassword());
		enterTransactionRemark(cardhlfTran.getTransactionRemark());
		confirmTransaction();
		waitForLoaderToDisappear();
		Assert.assertTrue(checkWalletToWalletTransferStatusMessage().contains("Your transaction is successful"));
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(visaMoneyTransferRbtn),
				WebElementUtils.visibilityOf(cardtoCardRbtn), WebElementUtils.visibilityOf(interBankFundTransferPopulateDetailsRbtn),
				WebElementUtils.visibilityOf(masterCardMoneySendRbtn));
	}
}