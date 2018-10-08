package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.util.HashMap;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CreditCardPaymentWorkFlows;

@Component
public class CashPaymentSteps {

	@Autowired
	public KeyValueProvider provider;

	@Autowired
	private TestContext context;

	@Autowired
	private CreditCardPaymentWorkFlows creditPaymentFlow;

	private static final Logger logger = LoggerFactory.getLogger(ProcessBatchesPage.class);
	
	@When("user initiates cash payment")
	@Then("user initiates cash payment")
	public void addLocalChequeClearingDetails() {
		Payment cash = Payment.cashPaymentDataProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		cash.setDeviceNumber(device.getDeviceNumber());
		cash.setPaymentBranch(device.getBranchCode());
		creditPaymentFlow.makeCashPayment(cash);
		context.put(ContextConstants.PAYMENT, cash);
	}
	
	@When("user makes $payment bill payment through cash")
	public void makesBillPaymentThroughCash(String payment){
		Payment cash = Payment.cashPaymentDataProvider(provider);
		Device device = context.get(ContextConstants.DEVICE);
		cash.setDeviceNumber(device.getDeviceNumber());
		cash.setPaymentBranch(device.getBranchCode());
		if (payment.equalsIgnoreCase("full")) {
			logger.info("TRANSACTION_AMOUNT :-" + context.get(ConstantData.TRANSACTION_AMOUNT));
			logger.info("TOTAL_FEE_OF_BILLING :-" + context.get(ConstantData.TOTAL_FEE_OF_BILLING));
			logger.info("BILLED_INTEREST :-" + context.get(ConstantData.BILLED_INTEREST));
			String amount = String.format("%.2f",
					Double.valueOf(context.get(ConstantData.TRANSACTION_AMOUNT))
							+ Double.valueOf(context.get(ConstantData.TOTAL_FEE_OF_BILLING))
							+ Double.valueOf(context.get(ConstantData.BILLED_INTEREST)));
			logger.info("BILLING PAYMENT :-" + amount);
			cash.setAmount(amount);
		} else if (payment.equalsIgnoreCase("MAD")) {
			HashMap<String, String> helpdeskValues = context.get(ContextConstants.HELPDESK_VALUES);
			logger.info("MINIMUM_PAYMENT_DUE" + helpdeskValues.get(ContextConstants.MINIMUM_PAYMENT_DUE));
			cash.setAmount(helpdeskValues.get(ContextConstants.MINIMUM_PAYMENT_DUE));
		}
		creditPaymentFlow.makeCashPayment(cash);
		context.put(ContextConstants.PAYMENT, cash);
	}
}
