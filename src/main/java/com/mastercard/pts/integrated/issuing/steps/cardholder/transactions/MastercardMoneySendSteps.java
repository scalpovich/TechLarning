package com.mastercard.pts.integrated.issuing.steps.cardholder.transactions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.cardholder.transactions.MastercardMoneySend;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.transactions.MastercardMoneySendWorkflow;

@Component
public class MastercardMoneySendSteps {

	private static final String STATUS_MESSAGE = "Success";

	@Autowired
	private MastercardMoneySendWorkflow mastercardMoneySendWorkflow;

	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private TestContext context;

	private String actualResult = "Transaction not executed!!!";

	@When("MMS CHP Transaction is performed")
	public void whenMmsChpTransactionIsPerformed() {
		MastercardMoneySend mms = MastercardMoneySend.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE2);
		actualResult = mastercardMoneySendWorkflow.doMmsTransaction(mms, device);

	}

	@Then("Validate Response Message on CHP")
	public void thenvalidateResponseMessageOnChp() {
		assertThat(actualResult, containsString(STATUS_MESSAGE));
	}
}