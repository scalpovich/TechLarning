package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AddInstituionLoadCurrency;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AddInstituionLoadCurrencyFlows;

/**
 * This class provides the step definitions for steps mentioned in the InstituionSetupCredit, InstituionSetupDebit ,InstituionSetupPrepaid story file
 */

/**
 * @author E070234
 *
 */
@Component
public class AddInstituionLoadCurrencySteps {

	@Autowired
	AddInstituionLoadCurrencyFlows addinstituionloadcurrencyflow;
	@Autowired
	AddInstituionLoadCurrency addLoadCurrency;
	
	@When("user creates Allowed Load Currency")
	public void whenUserCreatesAloudLoadCurrency() {
		addLoadCurrency=AddInstituionLoadCurrency.DataProvider();
		addinstituionloadcurrencyflow.addMultipleCurrency(addLoadCurrency);
	}
	
}
