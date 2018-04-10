package com.mastercard.pts.integrated.issuing.steps.cardholder.transactions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.cardholder.transactions.VisaMoneyTransfer;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.transactions.MastercardMoneySendWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.transactions.VisaMoneyTransferWorkflow;

@Component
public class VisaMoneyTransferSteps {

	@Autowired
	private MastercardMoneySendWorkflow mastercardMoneySendWorkflow;

	@Autowired
	private VisaMoneyTransferWorkflow visaMoneyTransferWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private TestContext context;

	private String actualResult = "Transaction not executed!!!";
	private static final String STATUS_MESSAGE = "Success";

	@When("VISA CHP Transaction is performed")
	public void whenVisaChpTransactionIsPerformed() {
		VisaMoneyTransfer vmt = VisaMoneyTransfer.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE2);
		MiscUtils.reportToConsole("Device Number in VTS-CHP Steps - " + device.getDeviceNumber());
		actualResult = visaMoneyTransferWorkflow.doVmtTransaction(vmt, device);
	}

	@When("VISA Offline CHP Transaction is performed")
	public void whenVisaOfflineChpTransactionIsPerformed() {
		VisaMoneyTransfer vmt = VisaMoneyTransfer.createWithProvider(provider);
		Device device = context.get(ContextConstants.DEVICE2);
		MiscUtils.reportToConsole("Device Number in VTS-CHP Steps - " + device.getDeviceNumber());
		actualResult = visaMoneyTransferWorkflow.doVmtOfflineTransaction(vmt, device);
	}
	
	@Then("Validate Response Message on CHP for VMT")
	public void thenvalidateResponseMessageOnChp() {
		assertThat(actualResult, containsString(STATUS_MESSAGE));
	}
}