/**
 * @author: e076168
 */
package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderTransactions;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.CardHolderTransactionsWorkFlows;

@Component
public class CardholderTransactionsSteps extends AbstractBasePage {
	
	final Logger logger = LoggerFactory.getLogger(AbstractBasePage.class);
	
	@Autowired
	private CardHolderTransactionsWorkFlows transactionFlow;
	
	@Autowired
	KeyValueProvider provider;
	
	@Autowired
	private TestContext context;
	
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
	
	@When ("fund transfer through MasterCard Money Send")
	public void checkChargesForMasterCardMoneySend(){		
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.openTransactionPage();
		transactionFlow.selectMasterCardMoneySend();
		transactionFlow.masterCardMoneySendForm(cardhlTran);
	}
	
	@Then ("verify $transferType fund transfer stauts")
	public void verifyFundTransferStatus(){		
		Assert.assertTrue("Fund transfer transaction is failed", transactionFlow.verifyFundTransferStatusOfTransaction());
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
	
	@When ("fund transfer through wallet to wallet transfer")
	public void checkIntraBankFundTransfer(){		
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.openTransactionPage();
		transactionFlow.selectWalletToWalletOption();
		transactionFlow.interBankMoneyTransfer(cardhlTran);
	}
	
	@When ("wallet to wallet fund transfer")
	public void walletToWalletTransfer(){		
		cardhlTran = CardHolderTransactions.cardHolderTransDataProvider(provider);
		context.put(ContextConstants.CARDHOLDER, cardhlTran);
		transactionFlow.openTransactionPage();
		transactionFlow.selectWalletToWalletOption();
		CardHolderTransactions cardhlTran = context.get(ContextConstants.CARDHOLDER);
		transactionFlow.interBankMoneyTransfer(cardhlTran);
	}
	
}
