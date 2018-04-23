package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AddInstituionLoadCurrencyFlows;

/**
 * This class provides the step definitions for steps mentioned in the InstituionSetupCredit, InstituionSetupDebit ,InstituionSetupPrepaid story file
 */

/**
 * @author E070234
 *
 */
@Component
public class AddInstituionLoadCurrencySteps extends AddInstituionLoadCurrencyFlows {

	@Autowired
	AddInstituionLoadCurrencyFlows addinstituionloadcurrencyflow;
	
	@When("user creates Allowed Load Currency for $INR")
	public void whenUserCreatesAloudLoadCurrency(@Named("CurrencyCode") String currencyCode) {
		addinstituionloadcurrencyflow.addInstituteLoadCurrency(currencyCode);
		
		
		
	}
	
}
