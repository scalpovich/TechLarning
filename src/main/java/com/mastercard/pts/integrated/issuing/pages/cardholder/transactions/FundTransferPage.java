package com.mastercard.pts.integrated.issuing.pages.cardholder.transactions;

import java.util.Arrays;
import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.TransactionsNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_FUND_TRANSFER })
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
	
	@PageElement(findBy = FindBy.X_PATH , valueToFind="//input[@id='Transaction Password']")
	private MCWebElement transactionPassword;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='remarks']")
	private MCWebElement transactionRemarks;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='mpts_cardHolderPortal_button_confirm']")
	private MCWebElement confirmButton;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@value='CardtoCard']")	
	private MCWebElement walletToWalletTransOption;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//Select[@id='toWalletNumber']")	
	private MCWebElement walletNumDropList;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='transactionAmount']")
	private MCWebElement amountToTransfer;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='selectedTxnCurrency']")
	private MCWebElement transferCurrencyOption;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='mpts_cardHolderPortal_button_submit']")
	private MCWebElement walletTranferSubmitButton;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@value='InterBankFundTransferPopulateDetails']")
	private MCWebElement interBankTransfer;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='toWalletNumber']")
	private MCWebElement beneficiaryWalletNum;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='toDeviceNumber']")
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//tr[@class='sectionHead'][4]/td/span")
	private MCWebElement fundTransferTransaction;
	
	
	public boolean verifyFundsTransferSts(){
		if(transactionStatusMessage.isVisible()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean verifyFundTransferSatus(){
		if(fundTransferTransaction.isVisible()){
			return true;
		}else{
			return false;
		}
	}
	
	
	public String availBalaceIntoWallet(){
		return availBalanceToWallet.getText();
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Fund Transfer");
		verifyTitleCardHolderPortal("Fund Transfer");
		verifyButton("Continue");
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
		walletToWalletTransOption.click();
	}
	
	public void selectIntraBankTransferOption(){
		interBankTransfer.click();
		
	}
	
	public void selectWalletNumber(String walletNum){
		SelectDropDownByValue(walletNumDropList, walletNum);
	}
	
	public void amountToTransfer(String amountToTrans){
		amountToTransfer.sendKeys(amountToTrans);
	}
	
	public void selectTransferCurrency(String currencyOpt){
		selectByVisibleTexts(transferCurrencyOption,currencyOpt);
	}
	
	public void submitWalletTransferRequest(){
		walletTranferSubmitButton.click();
	}
	
	public void enterBeneficiaryWalletNumber(String walletNumber){
		beneficiaryWalletNum.sendKeys(walletNumber);
	}
	
	public void enterBeneficiaryCardNumber(String cardNumber){
		benificiaryCardNum.sendKeys(cardNumber);
	}
	
	public void enterAmountToTranfer(String amountToTransfer){
		benificiaryTransferAmount.sendKeys(amountToTransfer);
	}
	
	public void selectCurrencyForIntraBankTranfer(String transferCurrancy){
		selectByVisibleTexts(curranyOfIntraBankTransfer, transferCurrancy);
	}
			
	public void submitIntraBankMoneyTranferRequest(){
			walletTranferSubmitButton.click();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(visaMoneyTransferRbtn),
				WebElementUtils.visibilityOf(cardtoCardRbtn), WebElementUtils.visibilityOf(interBankFundTransferPopulateDetailsRbtn),
				WebElementUtils.visibilityOf(masterCardMoneySendRbtn));
	}
}
