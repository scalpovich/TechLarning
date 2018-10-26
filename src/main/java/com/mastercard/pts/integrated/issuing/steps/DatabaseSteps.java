package com.mastercard.pts.integrated.issuing.steps;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DatabaseFlows;

@Component
public class DatabaseSteps {


	@Autowired
	DatabaseFlows dbFlow;
	
	@Autowired
	private TestContext context;
	
	@When("update institution date to first of next month")
	public void updateInstituteDate(){
			dbFlow.updateInstituteDateToFirstOfNextMonth(context.get(ContextConstants.INSTITUTION_DATE));
	}
	
	@When("loyalty plan expiry date is updated to $expiryDate")
	public void updateLoyaltyExpiryDateTo(String expiryDate) {
		Device device = context.get(ContextConstants.DEVICE);
		dbFlow.updateLoyaltyExpiryDate(expiryDate, device.getDeviceNumber());
	}
}
