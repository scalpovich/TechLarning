package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskCountry;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMCC;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMCG;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TaxOnIncomeRate;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskCountryFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskMCCFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.HighRiskMCGFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TaxOnIncomeRateFlows;

/**
 * @author E076170
 * 
 *
 */

@Component
public class HighRiskMCGSteps extends AbstractBaseSteps {

    @Autowired
    HighRiskMCGFlows highRiskMCGFlows;
    
    HighRiskMCG highRiskMCG;

	@When("user adds high risk mcg")
	public void userAddsHighRiskMCG() {
		highRiskMCG=HighRiskMCG.getHighRiskMCGData();
		highRiskMCGFlows.addHighRiskMCG(highRiskMCG);
	}

}
