

package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawDevice;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WithdrawDeviceWorkFlow;

/**
 * @author E076170
 * 
 *
 */

@Component
public class WithdrawDeviceSteps extends AbstractBaseSteps {
    @Autowired
    private WithdrawDeviceWorkFlow withdrawDeviceWorkFlow;
    
	@Autowired
	private KeyValueProvider keyProvider;

	@When("user withdraws a card from withdraw device screen")
	public void userWithdrawsCard() {
		WithdrawDevice withdrawDevice=WithdrawDevice.createWithProvider(keyProvider);
		withdrawDeviceWorkFlow.withDrawStopListDevice(withdrawDevice);
	}

}
