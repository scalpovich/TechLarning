/**
 * @author: e076168
 */
package com.mastercard.pts.integrated.issuing.steps.cardholder;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import junit.framework.Assert;

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
	private static final String REMITTANCE_ERROR_MSG = "Error while processing your request. Please retry. OK";
	private static final String REMITTANCE_SUCCESS_MSG = "Remittance request created";
	private static final int lengthOfWalletNumber = 19;

	@When("cardholder book the cash remittance")
	public void cardholderBookCashRemittance() {
		Device device = context.get(ContextConstants.DEVICE);
		cardhlTran = CardHolderTransactions.cardholderCashRemit(provider);
		cardhlTran.setTransctionPassword(device.getNewTransPassword());
		transactionFlow.openCashRemittanceTransactionPage();
		String actualStatus = transactionFlow.cashRemittanceBooking(cardhlTran);
		Assert.assertTrue(REMITTANCE_ERROR_MSG, actualStatus.contains(REMITTANCE_SUCCESS_MSG));
	}

	@Then("verify cash remittance request")
	@When("verify cash remittance request")
	public void verifyRemittanceRequestEntry() {
		transactionFlow.openCashRemittanceTransactionPage();
	}

	@When("cardholder cancel the cash remittance")
	public void cancelCashRemittanceRequest() {
		cardhlTran = CardHolderTransactions.cardholderCashRemit(provider);
		transactionFlow.openCancelRemittanceTransactionPage();
		transactionFlow.cancelCashRemittanceBooking(cardhlTran);
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
		Assert.assertTrue("Fund transfer transaction is failed", transactionFlow.verifyFundTransferStatusOfTransaction());
	}

	@When("check wallet to wallet transfer")
	public void checkWalletToWalletTransfer() {
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.openTransactionPage();
		transactionFlow.selectWalletToWalletOption();
		if (transactionFlow.verifyAvailBalanceIntoWallet()) {
			transactionFlow.walletToWalletTransfer(cardhlTran);
		} else {
			Assert.fail("Wallet is empty unable to perform wallet to wallet transfer transaction");
		}
	}

	@When("fund transfer through wallet to wallet transfer")
	public void checkIntraBankFundTransfer() {
		cardhlTran = CardHolderTransactions.cardHolderTranscationDataProvider();
		transactionFlow.openTransactionPage();
		transactionFlow.selectWalletToWalletOption();
		transactionFlow.interBankMoneyTransfer(cardhlTran);
	}

	@When("wallet to wallet fund transfer")
	public void walletToWalletTransfer() {
		cardhlTran = CardHolderTransactions.cardHolderTransDataProvider(provider);
		context.put(ContextConstants.CARDHOLDER, cardhlTran);
		Device device = context.get(ContextConstants.DEVICE);
		cardhlTran.setWalletToAmountTransfer(device.getNewWalletNumber().substring(lengthOfWalletNumber));
		cardhlTran.setCardNumber(device.getDeviceNumber());
		transactionFlow.openTransactionPage();
		transactionFlow.selectWalletToWalletOption();
		CardHolderTransactions cardhlTran = context.get(ContextConstants.CARDHOLDER);
		transactionFlow.interBankMoneyTransfer(cardhlTran);
	}

}
