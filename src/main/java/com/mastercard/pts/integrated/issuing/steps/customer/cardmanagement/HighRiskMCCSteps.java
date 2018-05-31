package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMCC;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskMCCFlows;

/**
 * @author E076170
 * 
 *
 */

@Component
public class HighRiskMCCSteps extends AbstractBaseSteps {

    @Autowired
    private HighRiskMCCFlows highRiskMCCFlows;
    
    private HighRiskMCC highRiskMCC;

	@When("user adds high risk mcc")
	public void userAddsHighRiskMCC() {
		highRiskMCC=HighRiskMCC.getHighRiskMCCData();
		highRiskMCCFlows.addHighRiskMCC(highRiskMCC);
	}

}
