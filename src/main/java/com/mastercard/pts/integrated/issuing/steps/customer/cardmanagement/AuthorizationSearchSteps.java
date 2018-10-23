package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AvailableBalance;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCGLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AuthorizationSearchWorkflow;

@Component
public class AuthorizationSearchSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private AuthorizationSearchWorkflow authorizationSearchWorkflow;

	@Autowired
	private KeyValueProvider provider;
	
	@When("search $type authorization and verify $state status")
	@Then("search $type authorization and verify $state status")
	public void thenUserSearchDeviceNumerWithTodaysDate(String type, String state) {
		Device device = context.get(ContextConstants.DEVICE);
		authorizationSearchWorkflow.verifyAuthTransactionSearch(type, state,device);
	}

	@When("assert $response response with $code AuthDecline Code and $descriptionBrief as description")
	@Then("assert $response response with $code AuthDecline Code and $descriptionBrief as description")
	public void thenAssertStateOnAuthSearchScreen(String response, String code, String descriptionBrief) {
		List<String> authStatus = new ArrayList<>();
		authStatus.add(response);
		authStatus.add(code);
		if(MCGLimitPlan.getAuthDeclineDescription().get(descriptionBrief)==null){
			authStatus.add(descriptionBrief);   
		}else{
			authStatus.add(MCGLimitPlan.getAuthDeclineDescription().get(descriptionBrief));
		}
		Device device = context.get(ContextConstants.DEVICE);
		authorizationSearchWorkflow.verifyStateAuthSearch(device.getDeviceNumber(), authStatus);
	}

	@When("verify transaction currency as $tcurrency and billing currency as $bcurrency on auth search")
	@Then("verify transaction currency as $tcurrency and billing currency as $bcurrency on auth search")
	public void verifyBillingCurrency(String tcurrency, String bcurrency) {
		Device device = context.get(ContextConstants.DEVICE);
		authorizationSearchWorkflow.verifyTransactionAndBillingCurrency(tcurrency, bcurrency, device);
	}
    
	@When("verify fixed transaction fee applied on purchase transaction")
	@Then("verify fixed transaction fee applied on purchase transaction")
	public void veriyFixedTransactionFeeonPurchaseTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.getAllTransactionFee(provider);
		assertThat(authorizationSearchWorkflow.checkTransactionFixedFee(device.getDeviceNumber()),
				Matchers.hasItems(txnFeePlan.getfixedTxnFees(), txnFeePlan.getFixedRateFee(), txnFeePlan.getBillingAmount()));
	}
	
	@Then("verify transaction fee waived off")
	public void veriyTransactionFeeWaivedOff() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.getAllTransactionFee(provider);
		assertThat(authorizationSearchWorkflow.checkTransactionFixedFee(device.getDeviceNumber()),
				Matchers.hasItems(txnFeePlan.getfixedTxnFees(), txnFeePlan.getFixedRateFee(), txnFeePlan.getBillingAmount()));
	}
	
	@Then("verify fixed transaction fee applied on purchase transaction waived off")
	public void veriyFixedTransactionFeePurchaseTransaction(){
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.getAllTransactionFee(provider);
		assertThat(authorizationSearchWorkflow.checkTransactionFixedFee(device.getDeviceNumber()),
				Matchers.hasItems(txnFeePlan.getfixedTxnFees()));
	}

	@Then("verify rate transaction fee applied on purchase transaction")
	public void verifyRateTransactiOnFeeonPurchaseTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.getAllTransactionFee(provider);
		assertThat(authorizationSearchWorkflow.checkTransactionRateFee(device.getDeviceNumber(), txnFeePlan), Matchers.hasItems(txnFeePlan.getRateTxnFee(), txnFeePlan.getBillingAmountRate()));

	}

	@Then("verify rate maximum fee applied on purchase transaction")
	public void verifyMaxTransactionFeeOnPurchaseTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.getAllTransactionFee(provider);
		assertThat(authorizationSearchWorkflow.checkTransactionMaxFee(device.getDeviceNumber()), Matchers.hasItems(txnFeePlan.getMaxTxnRate(), txnFeePlan.getBillingAmountRate()));

	}

	@Then("verify minimum fee applied on purchase transaction")
	public void verifyMinTransactionFeeOnPurchaseTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.getAllTransactionFee(provider);
		assertThat(authorizationSearchWorkflow.checkTransactionMinFee(device.getDeviceNumber()), Matchers.hasItems(txnFeePlan.getMinTxnRate(), txnFeePlan.getBillingAmountRate()));

	}

	@Then("verify markup fee applied on transaction")
	public void veriyMarkupFeeOnTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.getMarkUpFees(provider);
		Double billingAmount = Double.parseDouble(authorizationSearchWorkflow.checkMarkupFee(device.getDeviceNumber()).get(0));
		Double markUpFee = billingAmount * Double.parseDouble(txnFeePlan.getMarkupFee()) / 100;
		String markUpFees = String.valueOf(Math.round(markUpFee * 100.0) / 100.0);
		Double markUpFeeTax = Double.parseDouble(markUpFees) * Double.parseDouble(txnFeePlan.getMarkupFeeTax()) / 100;
		String markUpFeesTax = String.valueOf(Math.round(markUpFeeTax * 100.0) / 100.0);
		assertThat(authorizationSearchWorkflow.checkMarkupFee(device.getDeviceNumber()), Matchers.hasItems(markUpFees, markUpFeesTax));
	}

	@When("verify markup rate fee applied on transaction")
	@Then("verify markup rate fee applied on transaction")
		public void veriyMarkupRateFeeOnTransaction() {
		Device device = context.get(ContextConstants.DEVICE);
		TransactionFeePlan txnFeePlan = TransactionFeePlan.getMarkUpFees(provider);
		Double billingAmount = Double.parseDouble(authorizationSearchWorkflow.checkMarkupFee(device.getDeviceNumber()).get(0));
		Double markUpFee = billingAmount * Double.parseDouble(txnFeePlan.getMarkUpRate()) / 100.0;
		String markUpFees = String.valueOf(Math.round(markUpFee * 100.0) / 100.0);
		Double markUpFeeTax = Double.parseDouble(markUpFees) * Double.parseDouble(txnFeePlan.getMarkupFeeTax()) / 100;
		String markUpFeesTax = String.valueOf(Math.round(markUpFeeTax * 100.0) / 100.0);
		String sourceCurrency = txnFeePlan.getSourceCurrency();
		String billingCurrency = txnFeePlan.getBillingCurrency();
		assertThat(authorizationSearchWorkflow.checkMarkupFee(device.getDeviceNumber()), Matchers.hasItems(markUpFees, markUpFeesTax, sourceCurrency, billingCurrency));
	}

	@Then("validate auth report")
	public void validateAuthReport() {
		if(!System.getProperty("env").equalsIgnoreCase("automation2")){
			Device device = context.get(ContextConstants.DEVICE);
			authorizationSearchWorkflow.verifyAuthTransactionSearchReport(device);
		} 
	}
	
	@When("user verifies available balance after transaction")
	@Then("user verifies available balance after transaction")
	public void validateAvailableBalanceAfterTransaction(){
		BigDecimal availableBalanceBeforeTransaction =context.get(ContextConstants.AVAILABLE_BALANCE_OR_CREDIT_LIMIT);
		AvailableBalance availBal = authorizationSearchWorkflow.getTransactionBillingDetailsAndAvailableBalanceAfterTransaction(availableBalanceBeforeTransaction);
		assertThat("Verify Available Balance", availableBalanceBeforeTransaction.subtract(availBal.getSum()), equalTo(availBal.getAvailableBal()));
		context.put(ContextConstants.AVAILABLE_BALANCE_OR_CREDIT_LIMIT, availBal.getAvailableBal());
	}
}
