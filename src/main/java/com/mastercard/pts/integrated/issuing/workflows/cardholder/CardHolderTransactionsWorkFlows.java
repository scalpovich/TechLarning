package com.mastercard.pts.integrated.issuing.workflows.cardholder;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderTransactions;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.CancelRemittanceBookingPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.CardToCardTransferPage;
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
	
	public void walletToWalletFundTransfer(CardHolderTransactions  cardhlTran){
		CardToCardTransferPage page = navigator.navigateToPage(CardToCardTransferPage.class);
		page.walletToWalletTransfer(cardhlTran);		
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
	
	public boolean verifyFundTransferStatusOfTransaction(){
		return fundTransfer.verifyFundTransferSatus();
	}
	
	public void interBankMoneyTransfer(CardHolderTransactions cardhlfTran){
		FundTransferPage page = navigator.navigateToPage(FundTransferPage.class);
		page.interBankTransfer(cardhlfTran);
	}
	
	public boolean checkCashRemittanceAllowedOrNot(){
		boolean isPresentElement = false;
		if(cashRemittanceBookingPage.isCashRemittanceAllowedForAccount()){			
			return isPresentElement = true;
		}else{
			return isPresentElement;
		}
	}
	
	public String cancelCashRemittanceBooking(CardHolderTransactions cardhlTran){
		CancelRemittanceBookingPage page = navigator.navigateToPage(CancelRemittanceBookingPage.class);
		return page.cancelRemittanceRequst(cardhlTran);
	}
	
	public String cashRemittanceBooking(CardHolderTransactions cardhlTran){
		CashRemittanceBookingPage page = navigator.navigateToPage(CashRemittanceBookingPage.class);
		return page.bookCashRemittance(cardhlTran);
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


