/**
 * @author: e076168
 */
package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderTransactions;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

@Component
public class CardholderTransactionsSteps extends AbstractBasePage {
	
	final Logger logger = LoggerFactory.getLogger(AbstractBasePage.class);
	
	@Autowired
	private CardHolderTransactionsWorkFlows transactionFlow;
	
	private CardHolderTransactions cardhlTran;
	
	@When("cardholder book the cash remittance")
	public void cardholderBookCashRemittance(){
		
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.openCashRemittanceTransactionPage();
		
		if(!transactionFlow.checkCashRemittanceAllowedOrNot()){
			transactionFlow.cashRemittanceBooking(cardhlTran);			
		}else{			
			logger.info("Selected card do not cash remittance service");
		}
	}
	
	@When ("cardholder cancel the cash remittance")
	public void cancelCashRemittanceRequest(){
		transactionFlow.openCancelRemittanceTransactionPage();
	}
	@When ("check charges for mastercard money send")
	public void checkChargesForMasterCardMoneySend(){		
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.openTransactionPage();
		transactionFlow.selectMasterCardMoneySend();
		transactionFlow.masterCardMoneySendForm(cardhlTran);
		
	}
	
	@When ("check wallet to wallet transfer")
	public void checkWalletToWalletTransfer(){
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.openTransactionPage();
		transactionFlow.selectWalletToWalletOption();
		
		if(transactionFlow.verifyAvailBalanceIntoWallet()){
			transactionFlow.walletToWalletTransfer(cardhlTran);
		}else{
			Assert.fail("Wallet is empty unable to perform wallet to wallet transfer transaction");
		}
	}
	
	@When ("check charges for intra bank fund transfer")
	public void checkIntraBankFundTransfer(){		
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.selectIntraBankMoneyTransferOption();
		transactionFlow.openTransactionPage();
		transactionFlow.interBankMoneyTransfer(cardhlTran);
	}
	
}
