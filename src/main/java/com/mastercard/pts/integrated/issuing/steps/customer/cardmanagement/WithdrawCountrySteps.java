package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawCountry;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WithdrawCountryWorkFlow;
/**
 * @author E076170
 * 
 *
 */

@Component
public class WithdrawCountrySteps extends AbstractBaseSteps {
    @Autowired
    private WithdrawCountryWorkFlow withdrawCountryWorkFlow;
    
    @Autowired
    TestContext context;
    
	@Autowired
	private KeyValueProvider keyProvider;

	@When("user withdraws a country from withdraw country screen")
	public void userWithdrawCountry() {
		WithdrawCountry withdrawBin=WithdrawCountry.createWithProvider(keyProvider);
		DeviceRange deviceRange=context.get(ConstantData.DEVICE_RANGE_DATA);
		withdrawCountryWorkFlow.withdrawCountry(withdrawBin,deviceRange);
	}

}
