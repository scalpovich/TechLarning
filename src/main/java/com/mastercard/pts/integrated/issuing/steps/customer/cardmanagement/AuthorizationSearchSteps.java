package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AuthorizationSearchWorkflow;

@Component
public class AuthorizationSearchSteps {

	@Autowired
	private TestContext context;
	
	@Autowired
	private TransactionFeePlan transactionFeePlan;
	
	@Autowired
	private AuthorizationSearchWorkflow authorizationSearchWorkflow;
	
	@Autowired
	private KeyValueProvider provider;
	
	@Then("search $type authorization and verify $state status")
	public void thenUserSearchDeviceNumerWithTodaysDate(String type, String state) {
		Device device = context.get(ContextConstants.DEVICE);
		authorizationSearchWorkflow.verifyAuthTransactionSearch(type, state, device.getDeviceNumber());
	}

	@Then("verify transaction currency as $tcurrency and billing currency as $bcurrency on auth search")
	public void verifyBillingCurrency(String tcurrency, String bcurrency) {
		Device device = context.get(ContextConstants.DEVICE);
		authorizationSearchWorkflow.verifyTransactionAndBillingCurrency(tcurrency, bcurrency, device.getDeviceNumber());
	}

	@When("verify fixed transaction fee applied on purchase transaction")
	@Then("verify fixed transaction fee applied on purchase transaction")
	public void veriyFixedTransactionFeeonPurchaseTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		transactionFeePlan=context.get(ContextConstants.TRANSACTION_FEE_PLAN);
		assertThat(authorizationSearchWorkflow.checkTransactionFixedFee(device.getDeviceNumber()),Matchers.hasItems(transactionFeePlan.getfixedTxnFees(), transactionFeePlan.getFixedRateFee(), transactionFeePlan.getBillingAmount()));
	}

	@When("verify rate transaction fee applied on purchase transaction")
	@Then("verify rate transaction fee applied on purchase transaction")
	public void veriyRateTransactionFeeonPurchaseTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.allTxnFee(provider);
		transactionFeePlan=context.get(ContextConstants.TRANSACTION_FEE_PLAN);
		assertThat(authorizationSearchWorkflow.checkTransactionRateFee(device.getDeviceNumber(),txnFeePlan), Matchers.hasItems(transactionFeePlan.getRateTxnFee(), transactionFeePlan.getBillingAmountRate()));

	}

	@When("verify maximum transaction fee applied on purchase transaction")
	@Then("verify rate maximum fee applied on purchase transaction")
	public void veriyMaxTransactionFeeonPurchaseTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.allTxnFee(provider);
		assertThat(authorizationSearchWorkflow.checkTransactionMaxFee(device.getDeviceNumber()), Matchers.hasItems(txnFeePlan.getMaxTxnRate(), txnFeePlan.getBillingAmountRate()));

	}

	@When("verify minimum transaction fee applied on purchase transaction")
	@Then("verify minimum fee applied on purchase transaction")
	public void veriyMinTransactionFeeonPurchaseTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.allTxnFee(provider);
		assertThat(authorizationSearchWorkflow.checkTransactionMinFee(device.getDeviceNumber()), Matchers.hasItems(txnFeePlan.getMinTxnRate(), txnFeePlan.getBillingAmountRate()));

	}

	@Then("validate auth report")
	public void validateAuthReport() {
		Device device = context.get(ContextConstants.DEVICE);
		authorizationSearchWorkflow.verifyAuthTransactionSearchReport(device);
	}
}