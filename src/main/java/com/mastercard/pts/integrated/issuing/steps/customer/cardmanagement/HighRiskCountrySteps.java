package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskCountryFlows;

/**
 * @author E076170
 * 
 *
 */

@Component
public class HighRiskCountrySteps extends AbstractBaseSteps {
	/*
	 * @Autowired CustomUtils customutils;
	 */

    @Autowired
    HighRiskCountryFlows highRiskCountryFlows;
    
    @Autowired
    TestContext context;

	@When("user Adds $country as High Risk Country")
	public void createEmbossingFileTemplate(String country) {
		context.put(ConstantData.HIGH_RISK_COUNTRY, country);
		highRiskCountryFlows.AddAndVerifyHighRiskCountry();
	}

}
