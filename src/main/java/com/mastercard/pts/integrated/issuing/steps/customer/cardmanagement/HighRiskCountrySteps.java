package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskCountry;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskCountryFlows;

/**
 * @author E076170
 * 
 *
 */

@Component
public class HighRiskCountrySteps extends AbstractBaseSteps {
    @Autowired
    private HighRiskCountryFlows highRiskCountryFlows;
    
    private HighRiskCountry highRiskCountry;

	@When("user adds high risk country")
	public void userAddsHighRiskCountry() {
		highRiskCountry=HighRiskCountry.getHighRiskCountryData();
		highRiskCountryFlows.addHighRiskCountry(highRiskCountry);
	}

}
