package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListBin;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.StopListBinWorkFlow;
/**
 * @author E076170
 * 
 *
 */

@Component
public class StopListBinSteps extends AbstractBaseSteps {
    @Autowired
    private StopListBinWorkFlow stopListBinWorkFlow;
    
    @Autowired
    TestContext context;
    
	@Autowired
	private KeyValueProvider keyProvider;

	@When("user stoplists a device bin from stoplist device bin screen")
	public void userStoplistBin() {
		StopListBin stopListBin=StopListBin.createWithProvider(keyProvider);
		DeviceRange deviceRange=context.get(ConstantData.DEVICE_RANGE_DATA);
		stopListBinWorkFlow.addStoplistBin(stopListBin,deviceRange);
	}

}
