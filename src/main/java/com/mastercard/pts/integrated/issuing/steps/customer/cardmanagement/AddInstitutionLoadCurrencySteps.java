package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AddInstitutionLoadCurrency;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.InstitutionLoadCurrencyFlows;

/**
 * This class provides the step definitions for steps mentioned in the InstitutionSetupCredit, InstitutionSetupDebit ,InstitutionSetupPrepaid story file
 */

/**
 * @author E070234
 *
 */
@Component
public class AddInstitutionLoadCurrencySteps {

	@Autowired
	InstitutionLoadCurrencyFlows addInstitutionLoadCurrencyFlow;
	@Autowired
	AddInstitutionLoadCurrency addLoadCurrency;
	
	@When("user creates Allowed Load Currency")
	public void whenUserCreatesLoadCurrency() {
		addLoadCurrency=AddInstitutionLoadCurrency.dataProvider();
		addInstitutionLoadCurrencyFlow.addMultipleCurrencies(addLoadCurrency);
	}
	
}
