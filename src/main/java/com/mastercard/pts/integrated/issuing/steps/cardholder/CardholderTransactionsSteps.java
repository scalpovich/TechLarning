package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderTransactions;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.CardHolderTransactionsWorkFlows;
import static junit.framework.Assert.assertTrue;

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
	@Then("cardholder book the cash remittance")	
	public void cardholderBookCashRemittance() {		
		cardhlTran = CardHolderTransactions.cardholderCashRemit(provider);
		Device device = context.get(ContextConstants.DEVICE);
		cardhlTran.setTransctionPassword(device.getNewTransPassword());
		assertTrue("Error while processing cash remittance request", transactionFlow.cashRemittanceBooking(cardhlTran).contains("Your transaction is successful"));
	}
	
	@When("cardholder cancel the cash remittance")
	@Then ("cardholder cancel the cash remittance")
	public void cancelCashRemittanceRequest() {
		cardhlTran = CardHolderTransactions.cardholderCashRemit(provider);
		assertTrue("Error while cancelling remittance request", transactionFlow.cancelCashRemittanceBooking(cardhlTran).contains("Your transaction is successful"));
	}

	@When("fund transfer through MasterCard Money Send")
	public void checkChargesForMasterCardMoneySend() {
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.openTransactionPage();
		transactionFlow.selectMasterCardMoneySend();
		transactionFlow.masterCardMoneySendForm(cardhlTran);
	}

	@Then("verify $transferType fund transfer stauts")
	public void verifyFundTransferStatus() {
		assertTrue("Fund transfer transaction is failed", transactionFlow.verifyFundTransferStatusOfTransaction());
	}

	@When("check wallet to wallet transfer")
	public void checkWalletToWalletTransfer() {
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.walletToWalletFundTransfer(cardhlTran);		
	}

	@When("fund transfer through wallet to wallet")
	public void checkIntraBankFundTransfer() {
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.walletToWalletFundTransfer(cardhlTran);
	}

	@When("intera bank money transfer")
	public void walletToWalletTransfer() {
		cardhlTran = CardHolderTransactions.cardHolderTransDataProvider(provider);		
		Device device = context.get(ContextConstants.DEVICE);
		cardhlTran.setWalletToAmountTransfer(device.getNewWalletNumber());
		cardhlTran.setCardNumber(device.getDeviceNumber());
		transactionFlow.interBankMoneyTransfer(cardhlTran);
		context.put(ContextConstants.CARDHOLDER_TRAN, cardhlTran);
	}

}
