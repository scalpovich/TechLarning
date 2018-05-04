package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskCountry;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HolidayConfiguration;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskCountryFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HolidayConfigurationFlows;

/**
 * @author E076170
 * 
 *
 */

@Component
public class HolidayConfigurationSteps extends AbstractBaseSteps {
    @Autowired
    private HolidayConfigurationFlows holidayConfigurationFlows;
    
    private HolidayConfiguration holidayConfiguration;

	@When("user adds holiday configuration")
	public void userAddsHolidayConfiguration() {
		holidayConfiguration=HolidayConfiguration.getHolidayConfigurationData();
		holidayConfigurationFlows.addHolidayConfiguration(holidayConfiguration);
	}

}
