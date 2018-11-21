package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawBin;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WithdrawBinWorkFlow;
/**
 * @author E076170
 * 
 *
 */

@Component
public class WithdrawBinSteps extends AbstractBaseSteps {
    @Autowired
    private WithdrawBinWorkFlow withdrawBinWorkFlow;
    
    @Autowired
    TestContext context;
    
	@Autowired
	private KeyValueProvider keyProvider;

	@When("user withdraws a device Bin from withdraw device Bin screen")
	public void userWithdrawBin() {
		WithdrawBin withdrawBin=WithdrawBin.createWithProvider(keyProvider);
		DeviceRange deviceRange=context.get(ConstantData.DEVICE_RANGE_DATA);
		withdrawBinWorkFlow.withdrawDeviceBin(withdrawBin,deviceRange);
	}

}
