package com.mastercard.pts.integrated.issuing.steps.agent.transactions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.agent.transactions.CardToCash;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.agent.transactions.TransactionsWorkflow;

@Component
public class TransactionsSteps {
	private static final String FAILED_MESSAGE_INFO = "Page Load Failed";
	private static final String REMITTANCE_TRANSACTION_MESSAGE = "Your transaction is successful. Your Remittance Reference Number is:";
	private static final String REMITTANCE_CANCELLATION_MESSAGE = "Your transaction is successful.";
	private static final String REMITTANCE_PAYOUT_MESSAGE = "Your transaction is successful.";
	
	private CardToCash ctc;
	private Device device;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private TransactionsWorkflow transactionsWorkflow;

	@Autowired
	private KeyValueProvider provider;
	
	@When("user performs remittance card to cash transaction")
	public void whenUserPerformsRemittanceCardToCashTransaction(){
		device = context.get(ContextConstants.DEVICE);
		ctc = CardToCash.getProviderData(provider);
		String[] txnDetails = ctc.getTransactionDetails().trim().split(":");
		ctc.setRemittanceAmount(txnDetails[1].trim());
		ctc.setRemittanceCurrency(txnDetails[2].trim());
		ctc.setBeneficiaryId(MiscUtils.randomNumber(6));
		ctc.setBeneficiaryFirstName("FN"+MiscUtils.randomAlphabet(6).toLowerCase());
		ctc.setBeneficiaryLastName("LN"+MiscUtils.randomAlphabet(6).toLowerCase());
		String remittanceNumber = transactionsWorkflow.performRemittanceCardToCashTransaction(device, ctc);
		ctc.setRemittanceNumber(remittanceNumber);
		context.put(ContextConstants.REMITTANCE, ctc);
	}
	
	@Then("remittance card to cash transaction is successful")
	public void thenRemittanceCardToCashTransactionIsSuccessful(){
		assertThat("Remittance Card to Cash Transaction Failed", transactionsWorkflow.getRemittanceSuccessMessage(), containsString(REMITTANCE_TRANSACTION_MESSAGE));
	}
	
	@When("user performs remittance card to cash lookup")
	public void whenUserPerformsRemittanceCardToCashLookup(){
		ctc = context.get(ContextConstants.REMITTANCE);
		transactionsWorkflow.performRemittanceCardToCashLookup(device, ctc);
	}
	
	@Then("remittance card to cash lookup has transfer amount details")
	public void thenRemittanceCardToCashLookupHasDetails(){
		assertTrue(transactionsWorkflow.validateLookupTableTransferAmount(ctc));
	}
	
	@When("user performs remittance card to cash cancellation")
	public void whenUserPerformsRemittanceCardToCashCancellation(){
		ctc = context.get(ContextConstants.REMITTANCE);
		transactionsWorkflow.performRemittanceCancelCardToCash(device, ctc);
	}
	
	@Then("remittance card to cash cancellation is successful")
	public void thenRemittanceCardToCashCancellationIsSuccessful(){
		assertThat("Remittance Card to Cash Cancellation Failed",  transactionsWorkflow.getRemittanceCancellationSuccessMessage(), containsString(REMITTANCE_CANCELLATION_MESSAGE));
	}
	
	@When("user performs remittance card to cash payout")
	public void whenUserPerformsRemittanceCardToCashPayout(){
		ctc = context.get(ContextConstants.REMITTANCE);
		transactionsWorkflow.performRemittancePayout(device, ctc);
	}
	
	@Then("remittance card to cash payout is successful")
	public void thenRemittanceCardToCashPayoutIsSuccessful(){
		assertThat("Remittance Card to Cash Payout Failed", transactionsWorkflow.getRemittancePayoutSuccessMessage(), containsString(REMITTANCE_PAYOUT_MESSAGE));
	}
	
	@When("user navigates to balance enquiry page")
	public void whenUserNavigatesToBalanceEnquiryPage(){
		transactionsWorkflow.navigateToBalanceEnquiryPage();
	}
	
	@Then("balance enquiry page is loaded and master detail content title is $expectedTitleText")
	public void thenBalanceEnquiryPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getBalanceEnquiryMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to balance refund approve page")
	public void whenUserNavigatesToBalanceRefundApprovePage(){
		transactionsWorkflow.navigateToBalanceRefundApprovePage();
	}
	
	@Then("balance refund approve page is loaded and master detail content title is $expectedTitleText")
	public void thenBalanceRefundApprovePageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getBalanceRefundApproveMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to balance refund request page")
	public void whenUserNavigatesToBalanceRefundRequestPage(){
		transactionsWorkflow.navigateToBalanceRefundRequestPage();
	}
	
	@Then("balance refund request page is loaded and master detail content title is $expectedTitleText")
	public void thenBalanceRefundRequestPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getBalanceRefundRequestMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to cancel card to cash page")
	public void whenUserNavigatesToCancelCardToCashPage(){
		transactionsWorkflow.navigateToCancelCardToCashPage();
	}
	
	@Then("cancel card to cash page is loaded and master detail content title is $expectedTitleText")
	public void thenCancelCardToCashPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getCancelCardToCashMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to card to cash lookup page")
	public void whenUserNavigatesToCardToCashLookupPage(){
		transactionsWorkflow.navigateToCardToCashLookupPage();
	}
	
	@Then("card to cash lookup page is loaded and master detail content title is $expectedTitleText")
	public void thenCardToCashLookupPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getCardToCashLookupMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to card to cash transaction page")
	public void whenUserNavigatesToCardToCashTransactionPage(){
		transactionsWorkflow.navigateToCardToCashTransactionPage();
	}
	
	@Then("card to cash transaction page is loaded and master detail content title is $expectedTitleText")
	public void thenCardToCashTransactionPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getCardToCashTransactionMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to cash remittance payout page")
	public void whenUserNavigatesToCashRemittancePayoutPage(){
		transactionsWorkflow.navigateToCashRemittancePayoutPage();
	}
	
	@Then("cash remittance payout page is loaded and master detail content title is $expectedTitleText")
	public void thenCashRemittancePayoutPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getCashRemittancePayoutMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to load balance approve page")
	public void whenUserNavigatesToLoadBalanceApprovePage(){
		transactionsWorkflow.navigateToLoadBalanceApprovePage();
	}
	
	@Then("load balance approve page is loaded and master detail content title is $expectedTitleText")
	public void thenLoadBalanceApprovePageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getLoadBalanceApproveMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to load balance request page")
	public void whenUserNavigatesToLoadBalanceRequestPage(){
		transactionsWorkflow.navigateToLoadBalanceRequestPage();
	}
	
	@Then("load balance request page is loaded and master detail content title is $expectedTitleText")
	public void thenLoadBalanceRequestPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getLoadBalanceRequestMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to load balance view pending requests page")
	public void whenUserNavigatesToLoadBalanceViewPendingRequestsPage(){
		transactionsWorkflow.navigateToLoadBalanceViewPendingRequestsPage();
	}
	
	@Then("load balance view pending requests page is loaded and master detail content title is $expectedTitleText")
	public void thenLoadBalanceViewPendingRequestsPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getLoadBalanceViewPendingRequestsMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to transaction history page")
	public void whenUserNavigatesToTransactionHistoryPage(){
		transactionsWorkflow.navigateToTransactionHistoryPage();
	}
	
	@Then("transaction history page is loaded and master detail content title is $expectedTitleText")
	public void thenTransactionHistoryPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getTransactionHistoryMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to transfer funds page")
	public void whenUserNavigatesToTransferFundsPage(){
		transactionsWorkflow.navigateToTransferFundsPage();
	}
	
	@Then("transfer funds page is loaded and master detail content title is $expectedTitleText")
	public void thenTransferFundsPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getTransferFundsMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
	
	@When("user navigates to view charges page")
	public void whenUserNavigatesToViewChargesPage(){
		transactionsWorkflow.navigateToViewChargesPage();
	}
	
	@Then("view charges page is loaded and master detail content title is $expectedTitleText")
	public void thenViewChargesPageLoaded(String expectedTitleText){
		assertThat(FAILED_MESSAGE_INFO, transactionsWorkflow.getViewChargesMasterDetailContentTitleText(), containsString(expectedTitleText));
	}
}	