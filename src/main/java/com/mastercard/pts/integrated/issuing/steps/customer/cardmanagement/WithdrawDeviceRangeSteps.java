package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawDeviceRange;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WithdrawDeviceRangeWorkFlow;

/**
 * @author E076170
 * 
 *
 */

@Component
public class WithdrawDeviceRangeSteps extends AbstractBaseSteps {
    @Autowired
    private WithdrawDeviceRangeWorkFlow withdrawDeviceRangeWorkFlow;
    
    @Autowired
    TestContext context;
    
	@Autowired
	private KeyValueProvider keyProvider;

	@When("user withdraws a device range from withdraw device range screen")
	public void userWithdrawDeviceRange() {
		WithdrawDeviceRange withdrawDeviceRange=WithdrawDeviceRange.createWithProvider(keyProvider);
		DeviceRange deviceRange=context.get(ConstantData.DEVICE_RANGE_DATA);
		withdrawDeviceRangeWorkFlow.withdrawDeviceRange(withdrawDeviceRange,deviceRange);
	}

}
