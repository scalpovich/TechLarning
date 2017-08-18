package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.cardholder.enquiry.CardHolderUiVerificationEnquiryWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.services.CardHolderUiVerificationServicesWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.transactions.CardHolderUiVerificationTransactionsWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.virtualcard.CardHolderUiVerificationVirtualCardWorkflow;

@Component
public class CardHolderUiVerificationSteps {

	@Autowired
	private CardHolderUiVerificationEnquiryWorkflow cardHolderUiVerificationEnquiryWorkflow;

	@Autowired
	private CardHolderUiVerificationTransactionsWorkflow cardHolderUiVerificationTransactionsWorkflow;

	@Autowired
	private CardHolderUiVerificationServicesWorkflow cardHolderUiVerificationServicesWorkflow;
	
	@Autowired
	private CardHolderUiVerificationVirtualCardWorkflow cardHolderUiVerificationVirtualCardWorkflow;

	@Then("Transactions page of enquiry tab is rendered correctly")
	public void thenTransactionsPageOfEnquiryTabIsRenderedCorrectly() {
		cardHolderUiVerificationEnquiryWorkflow.verifyTransactionsPage();
	}

	@Then("CashRemittances page of enquiry tab is rendered correctly")
	public void thenCashRemittancesPageOfEnquiryTabIsRenderedCorrectly() {
		cardHolderUiVerificationEnquiryWorkflow.verifyCashRemittancesPage();
	}

	@Then("ViewCharges page of enquiry tab is rendered correctly")
	public void thenViewChargesPageOfEnquiryTabIsRenderedCorrectly() {
		cardHolderUiVerificationEnquiryWorkflow.verifyViewChargesPage();
	}

	@Then("CancelRemittanceBooking page of transactions tab is rendered correctly")
	public void thenCancelRemittanceBookingPageOfTransactionsTabIsRenderedCorrectly() {
		cardHolderUiVerificationTransactionsWorkflow.verifyCancelRemittanceBookingPage();
	}

	@Then("CashRemittanceBooking page of transactions tab is rendered correctly")
	public void thenCashRemittanceBookingPageOfTransactionsTabIsRenderedCorrectly() {
		cardHolderUiVerificationTransactionsWorkflow.verifyCashRemittanceBookingPage();
	}

	@Then("FundTransfer page of transactions tab is rendered correctly")
	public void thenFundTransferPageOfTransactionsTabIsRenderedCorrectly() {
		cardHolderUiVerificationTransactionsWorkflow.verifyFundTransferPage();
	}

	@Then("ActivateDeactivateWallet page of services tab is rendered correctly")
	public void thenActivateDeactivateWalletPageOfServicesTabIsRenderedCorrectly() {
		cardHolderUiVerificationServicesWorkflow.verifyActivateDeactivateWalletPage();
	}

	@Then("ActivatePairedDevice page of services tab is rendered correctly")
	public void thenActivatePairedDevicePageOfServicesTabIsRenderedCorrectly() {
		cardHolderUiVerificationServicesWorkflow.verifyActivatePairedDevicePage();
	}

	@Then("BlockDevice page of services tab is rendered correctly")
	public void thenBlockDevicePageOfServicesTabIsRenderedCorrectly() {
		cardHolderUiVerificationServicesWorkflow.verifyBlockDevicePage();
	}

	@Then("ECommActivation page of services tab is rendered correctly")
	public void thenECommActivationPageOfServicesTabIsRenderedCorrectly() {
		cardHolderUiVerificationServicesWorkflow.verifyECommActivationPage();
	}

	@Then("InternationalUseActivation page of services tab is rendered correctly")
	public void thenInternationalUseActivationPageOfServicesTabIsRenderedCorrectly() {
		cardHolderUiVerificationServicesWorkflow.verifyInternationalUseActivationPage();
	}

	@Then("ReplaceDevice page of services tab is rendered correctly")
	public void thenReplaceDevicePageOfServicesTabIsRenderedCorrectly() {
		cardHolderUiVerificationServicesWorkflow.verifyReplaceDevicePage();
	}

	@Then("UnblockDevice page of services tab is rendered correctly")
	public void thenUnblockDevicePageOfServicesTabIsRenderedCorrectly() {
		cardHolderUiVerificationServicesWorkflow.verifyUnblockDevicePage();
	}

	@Then("RequestForLimitedValidityVirtualCard page of virtualcard tab is rendered correctly")
	public void thenRequestForLimitedValidityVirtualCardPageOfVirtualCardTabIsRenderedCorrectly() {
		cardHolderUiVerificationVirtualCardWorkflow.verifyRequestForLimitedValidityVirtualCardPage();
	}

	@Then("VirtualCardDetails page of virtualcard tab is rendered correctly")
	public void thenVirtualCardDetailsPageOfVirtualCardTabIsRenderedCorrectly() {
		cardHolderUiVerificationVirtualCardWorkflow.verifyVirtualCardDetailsPage();
	}

	@Then("VirtualCardLimitedValidityVirtualCardCancellation page of virtualcard tab is rendered correctly")
	public void thenVirtualCardLimitedValidityVirtualCardCancellationPageOfVirtualCardTabIsRenderedCorrectly() {
		cardHolderUiVerificationVirtualCardWorkflow.verifyVirtualCardLimitedValidityVirtualCardCancellationPage();
	}

	@Then("VirtualPrepaidCardRequest page of virtualcard tab is rendered correctly")
	public void thenVirtualPrepaidCardRequestPageOfVirtualCardTabIsRenderedCorrectly() {
		cardHolderUiVerificationVirtualCardWorkflow.verifyVirtualPrepaidCardRequestPage();
	}

}
