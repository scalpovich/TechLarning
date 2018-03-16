package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AuthorizationSearchWorkflow;

@Component
public class AuthorizationSearchSteps {

	private static final double markupFee = 3.5;
	private static final double markupFeeTax = 1;

	@Autowired
	private TestContext context;

	@Autowired
	private AuthorizationSearchWorkflow authorizationSearchWorkflow;

	private String fixedTxnFee = "10.00";
	private String fixedRateFee = "0.10";
	private String billingAmount = "10.00";

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
		assertThat(authorizationSearchWorkflow.checkTransactionFixedFee(device.getDeviceNumber()), Matchers.hasItems(fixedTxnFee, fixedRateFee, billingAmount));
	}

	@When("verify markup fee applied on transaction")
	@Then("verify markup fee applied on transaction")
	public void veriyMarkupFeeOnTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		double billingAmt = Double.parseDouble(authorizationSearchWorkflow.getBillingAmount());
		String markUpFee = String.valueOf(billingAmt * markupFee / 100);
		String markUpFeeTax = String.valueOf(billingAmt * markupFee / 100 * markupFeeTax / 100);
		assertThat(authorizationSearchWorkflow.checkMarkupFee(device.getDeviceNumber()), Matchers.hasItems(markUpFee, markUpFeeTax));
	}

	@Then("validate auth report")
	public void validateAuthReport() {
		Device device = context.get(ContextConstants.DEVICE);
		authorizationSearchWorkflow.verifyAuthTransactionSearchReport(device);
	}
}