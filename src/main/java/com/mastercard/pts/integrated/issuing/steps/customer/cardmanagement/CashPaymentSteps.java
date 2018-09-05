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
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CreditCardPaymentWorkFlows;

@Component
public class CashPaymentSteps {
	
	@Autowired
	public KeyValueProvider provider;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private CreditCardPaymentWorkFlows creditPaymentFlow;
	
	Payment cash;	
	
	@When("user initiates cash payment")
	@Then("user initiates cash payment")
	public void addLocalChequeClearingDetails(){
		cash = Payment.cashPaymentDataProvider(provider);
		Device device = new Device();
		device.setDeviceNumber("5742539370867516");
		device.setBranchCode("OfficeBranch [184]");
		cash.setDeviceNumber(device.getDeviceNumber());
		cash.setPaymentBranchCode(device.getBranchCode());
		creditPaymentFlow.makeCashPayment(cash);	
		context.put(ContextConstants.PAYMENT, cash);		
	}
}

