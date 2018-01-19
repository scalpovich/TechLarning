
package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MoneySend;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MoneyTransferWorkflow;

/**
 * @author E071669
 *
 */

@Component
public class MoneyTransferSteps {
	
	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private MoneyTransferWorkflow moneyTransferWorkflow;
	
	@When("user raises a money send request")
	public void whenUserRaisesAMoneySendRequest(){		
		Device sourceDevice = context.get(ContextConstants.DEVICE);
		Device beneficiaryDevice = context.get(ContextConstants.DEVICE2);
		MoneySend moneySend = MoneySend.createWithProvider(provider);
	    moneySend.setBeneficiaryDeviceNumber(beneficiaryDevice.getDeviceNumber());
	    moneySend.setName(beneficiaryDevice.getEncodedName());
	    moneyTransferWorkflow.processMaterCardMoneySendRequest(moneySend, sourceDevice); 		
	}
}
