package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListCountry;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.StopListCountryWorkFlow;
/**
 * @author E076170
 * 
 *
 */

@Component
public class StopListCountrySteps extends AbstractBaseSteps {
    @Autowired
    private StopListCountryWorkFlow stopListCountryWorkFlow;
    
    @Autowired
    TestContext context;
    
	@Autowired
	private KeyValueProvider keyProvider;

	@When("user stoplists a country from stoplist country screen")
	public void userStopListCountry() {
		StopListCountry stopListCountry=StopListCountry.createWithProvider(keyProvider);
		DeviceRange deviceRange=context.get(ConstantData.DEVICE_RANGE_DATA);
		stopListCountryWorkFlow.addStopListCountry(stopListCountry,deviceRange);
	}

}
