package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListDevice;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.StopListDeviceWorkFlow;

/**
 * @author E076170
 * 
 *
 */

@Component
public class StopListDeviceSteps extends AbstractBaseSteps {
    @Autowired
    private StopListDeviceWorkFlow stopListDeviceWorkFlow;
    
	@Autowired
	private KeyValueProvider keyProvider;

	@When("user stoplists a card from stoplist device screen")
	public void userStoplistsCard() {
		StopListDevice stopListDevice=StopListDevice.createWithProvider(keyProvider);
		stopListDeviceWorkFlow.addStoplistDevice(stopListDevice);
	}

}
