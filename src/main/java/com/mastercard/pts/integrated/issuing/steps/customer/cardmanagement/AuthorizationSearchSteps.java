package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.jbehave.core.annotations.Then;

import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AuthorizationSearchWorkflow;

@Component
public class AuthorizationSearchSteps {

	@Autowired
	private TestContext context;
	
	@Autowired
	private AuthorizationSearchWorkflow authorizationSearchWorkflow;

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
	
	@Then("verify fixed transaction fee applied on purchase transaction")
	public void veriyFixedTransactionFeeonPurchaseTransaction(String type, String state)
	{
			Device device = context.get(ContextConstants.DEVICE);
			assertThat(authorizationSearchWorkflow.checkTransactionFixedFee(device.getDeviceNumber()), Matchers.hasItems("10.00","0.10","10.00"));
	}
	
	
@Then("validate auth report")
	public void validateAuthReport() {
		Device device = context.get(ContextConstants.DEVICE);
		authorizationSearchWorkflow.verifyAuthTransactionSearchReport(device);
	}
}