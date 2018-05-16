package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TaxOnIncomeRate;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TaxOnIncomeRateFlows;

/**
 * @author E076170
 * 
 *
 */

@Component
public class TaxOnIncomeRateSteps extends AbstractBaseSteps {

    @Autowired
    private TaxOnIncomeRateFlows taxOnIncomeRateFlows;
    
    private TaxOnIncomeRate taxOnIncomeRate;

	@When("user adds tax on income rate")
	public void userAddsTaxOnIncomeRate() {
		taxOnIncomeRate=TaxOnIncomeRate.getTaxOnIncomeRateData();
		taxOnIncomeRateFlows.addTaxOnIncomeRate(taxOnIncomeRate);
	}

}
