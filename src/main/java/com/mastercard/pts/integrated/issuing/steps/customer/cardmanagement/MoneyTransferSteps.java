
package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MoneySend;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaMoneyTransfer;
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

	@When("user raises a money send request from second wallet")
	public void whenUserRaisesAMoneySendRequestFromSecondWallet(){		
		Device sourceDevice = context.get(ContextConstants.DEVICE);
		Device beneficiaryDevice = context.get(ContextConstants.DEVICE2);
		MoneySend moneySend = MoneySend.createWithProvider(provider);
	    moneySend.setBeneficiaryDeviceNumber(beneficiaryDevice.getDeviceNumber());
	    moneySend.setName(beneficiaryDevice.getEncodedName());
	    moneyTransferWorkflow.processMaterCardMoneySendRequestFromSecondWallet(moneySend, sourceDevice); 		
	}

	@When("user raises a \"$type\" request")
	public void whenUserRaisesVisaMoneyTransferRequest(String type){		
		Device sourceDevice = context.get(ContextConstants.DEVICE);
		Device beneficiaryDevice = context.get(ContextConstants.DEVICE2);
		VisaMoneyTransfer visaMoneyTransfer = VisaMoneyTransfer.createWithProvider(provider);
		visaMoneyTransfer.setBeneficiaryDeviceNumber(beneficiaryDevice.getDeviceNumber());
		visaMoneyTransfer.setVmt(type);
	    moneyTransferWorkflow.processVisaMoneyTransferRequest(visaMoneyTransfer, sourceDevice); 		
	}

	@When("user raises a \"$type\" request from second wallet")
	public void whenUserRaisesVisaMoneyTransferRequestFromSecondWallet(String type){		
		Device sourceDevice = context.get(ContextConstants.DEVICE);
		Device beneficiaryDevice = context.get(ContextConstants.DEVICE2);
		VisaMoneyTransfer visaMoneyTransfer = VisaMoneyTransfer.createWithProvider(provider);
		visaMoneyTransfer.setBeneficiaryDeviceNumber(beneficiaryDevice.getDeviceNumber());
		visaMoneyTransfer.setVmt(type);
	    moneyTransferWorkflow.processVisaMoneyTransferRequestFromSecondWallet(visaMoneyTransfer, sourceDevice); 		
	}
}
