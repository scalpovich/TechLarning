/**
 * @author: e076168
 */
package com.mastercard.pts.integrated.issuing.workflows.cardholder;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderTransactions;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.CancelRemittanceBookingPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.CashRemittanceBookingPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.FundTransferPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Component
public class CardHolderTransactionsWorkFlows extends AbstractBasePage{
	
	
	@Autowired 
	Navigator navigator;
	
	@Autowired 
	FundTransferPage fundTransfer;
	
	@Autowired
	CashRemittanceBookingPage cashRemittanceBookingPage;
	
	@Autowired
	private TestContext context;

	public void openTransactionPage(){
			navigator.navigateToPage(FundTransferPage.class);
	}
	
	public void openCashRemittanceTransactionPage(){
		navigator.navigateToPage(CashRemittanceBookingPage.class);
	}
	
	public void openCancelRemittanceTransactionPage(){
		navigator.navigateToPage(CancelRemittanceBookingPage.class);
	}
	
	public void selectMasterCardMoneySend(){
		fundTransfer.selectTransferMastercardThroughOption();
		clickContinueOnFundtransferButton();
	}
	
	public void selectWalletToWalletOption(){
		fundTransfer.selectWalletToWalletTransferOption();		
	}
	
	public void selectIntraBankMoneyTransferOption(){
		clickContinueOnFundtransferButton();
	}
	
	public void clickContinueOnFundtransferButton(){
		fundTransfer.clickOnContinueFundTransferOption();
	}
	
	public void masterCardMoneySendForm(CardHolderTransactions cardhlfTran){
		fundTransfer.enterBenificiaryCardNumber(cardhlfTran.getCardNumber());
		fundTransfer.enterTransferAmount(cardhlfTran.getTransferAmount());
		fundTransfer.selectCurrencyOfTransfer(cardhlfTran.getCurrencyName());
		fundTransfer.enterContactNumber(cardhlfTran.getContactNumber());
		fundTransfer.enterName(cardhlfTran.getTransferName());
		fundTransfer.enterMemo(cardhlfTran.getTransferMemo());
		fundTransfer.submitMoneyTransferRequest();
		waitForLoaderToDisappear();
		fundTransfer.enterTransactionPassword(cardhlfTran.getTransctionPassword());
		fundTransfer.enterTransactionRemark(cardhlfTran.getTransactionRemark());
		fundTransfer.confirmTransaction();
		waitForLoaderToDisappear();
	}
	
	public void walletToWalletTransfer(CardHolderTransactions cardhlfTran){
		fundTransfer.selectWalletNumber(cardhlfTran.getWalletFromAmountTransfer());
		fundTransfer.amountToTransfer(cardhlfTran.getWalletTransferAmount());
		//fundTransfer.selectTransferCurrency(cardhlfTran.getWalletTransferCurrency());
		fundTransfer.submitWalletTransferRequest();
		waitForLoaderToDisappear();
		fundTransfer.enterTransactionPassword(cardhlfTran.getTransctionPassword());
		fundTransfer.enterTransactionRemark(cardhlfTran.getTransactionRemark());
		fundTransfer.confirmTransaction();
		waitForLoaderToDisappear();				
		if(fundTransfer.verifyFundsTransferSts()){
				Assert.assertTrue(false);
		}else{
				Assert.assertTrue(fundTransfer.checkWalletToWalletTransferStatusMessage().contains(cardhlfTran.getWalletToWalletTransSucessMsg()));
		}
	}
	
	public boolean verifyFundTransferStatusOfTransaction(){
		if(fundTransfer.verifyFundTransferSatus()){
				return true;
		}else{
				return false;
		}
	}
	
	public void interBankMoneyTransfer(CardHolderTransactions cardhlfTran){		
		fundTransfer.enterBeneficiaryWalletNumber(cardhlfTran.getWalletToAmountTransfer());
		fundTransfer.enterBeneficiaryCardNumber(cardhlfTran.getCardNumber());
		fundTransfer.enterAmountToTranfer(cardhlfTran.getWalletFromAmountTransfer());
		fundTransfer.selectCurrencyForIntraBankTranfer(cardhlfTran.getWalletFromAmountTransfer());
		fundTransfer.submitIntraBankMoneyTranferRequest();
		waitForLoaderToDisappear();
	}
	
	public boolean checkCashRemittanceAllowedOrNot(){
		boolean isPresentElement = false;
		if(cashRemittanceBookingPage.isCashRemittanceAllowedForAccount()){
			isPresentElement = true;
			return isPresentElement;
		}else{
			return isPresentElement;
		}
	}
	
	public void cancelCashRemittanceBooking(){
		
	}
	
	public void cashRemittanceBooking(CardHolderTransactions cardhlTran){
		cashRemittanceBookingPage.enterBeneficiaryId(cardhlTran.getBeneficiaryID());
		cashRemittanceBookingPage.enterBeneficiaryFirstName(cardhlTran.getBeneficiaryFirstName());
		cashRemittanceBookingPage.enterBeneficiaryMiddleName(cardhlTran.getBeneficiaryMiddleName());
		cashRemittanceBookingPage.enterBeneficiaryLastName(cardhlTran.getBeneficiaryLastName());
		cashRemittanceBookingPage.enterBeneficiaryAddress1(cardhlTran.getBeneficiaryAddressLine1());
		cashRemittanceBookingPage.enterBeneficiaryAddress2(cardhlTran.getBeneficiaryAddressLine2());
		cashRemittanceBookingPage.enterBeneficiaryAddress3(cardhlTran.getBeneficiaryAddressLine3());
		cashRemittanceBookingPage.enterBeneficiaryStateName(cardhlTran.getBeneficiaryStateName());
		cashRemittanceBookingPage.enterBeneficiaryCityName(cardhlTran.getBeneficiaryCityName());
		cashRemittanceBookingPage.enterBeneficiaryZipCode(cardhlTran.getBeneficiaryZIPCode());
		cashRemittanceBookingPage.enterBeneficiaryEmailAddress(cardhlTran.getBeneficiaryEmailAddress());
		cashRemittanceBookingPage.enterBeneficiaryMobileNumber(cardhlTran.getBeneficiaryMobileNumber());
		cashRemittanceBookingPage.enterRemittanceAmount(cardhlTran.getBeneficiaryRemittanceAmount());
		cashRemittanceBookingPage.enterRemittanceCurrency(cardhlTran.getBeneficiaryRemittanceCurrency());
		submitCashRemittanceBookingRequest();
	}
	
	public void submitCashRemittanceBookingRequest(){
		cashRemittanceBookingPage.submitRemittanceRequst();
	}
	

	public boolean verifyAvailBalanceIntoWallet(){
		if(fundTransfer.availBalaceIntoWallet()!= null){
			return true;
		}else{
			Assert.fail("Selected Wallet is empty");
			return false;
		}
	}
}


