package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListDeviceRange;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.StopListDeviceRangeWorkFlow;

/**
 * @author E076170
 * 
 *
 */

@Component
public class StopListDeviceRangeSteps extends AbstractBaseSteps {
    @Autowired
    private StopListDeviceRangeWorkFlow StopListDeviceRangeWorkFlow;
    
    @Autowired
    TestContext context;
    
	@Autowired
	private KeyValueProvider keyProvider;

	@When("user stoplists a device range from stoplist device range screen")
	public void userStoplistsDeviceRange() {
		StopListDeviceRange stopListDeviceRange=StopListDeviceRange.createWithProvider(keyProvider);
		DeviceRange deviceRange=context.get(ConstantData.DEVICE_RANGE_DATA);
		StopListDeviceRangeWorkFlow.addStopListDeviceRange(stopListDeviceRange,deviceRange);
	}

}
