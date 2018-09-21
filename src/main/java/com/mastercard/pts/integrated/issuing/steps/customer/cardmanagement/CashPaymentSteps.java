package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
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
		if(payment.equalsIgnoreCase("full")){
			cash.setAmount(String.valueOf(Double.valueOf(context.get(ConstantData.TRANSACTION_AMOUNT))
					+ Double.valueOf(context.get("Fee")) + Double.valueOf(context.get("Billed interest"))));
		}
		creditPaymentFlow.makeCashPayment(cash);
		context.put(ContextConstants.PAYMENT, cash);
	}
}
