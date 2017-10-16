package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.InstitutionCurrency;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.InstitutionCurrencyFlows;

@Component
public class InstitutionCurrencySteps {

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	InstitutionCurrencyFlows institutioncurrencyflows;

	public InstitutionCurrency institutioncurrency;

	@When("user creates an Institution Currency with status as $status")
	public void whenUserCreatesAnInstitutionCurrency(@Named("status") String status) {
		institutioncurrency = InstitutionCurrency.InstitutionCurrencyDataProvider();
		institutioncurrency.setSettlementCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		institutioncurrency.setStatus(status);
		institutioncurrencyflows.addInstitutionCurrency(institutioncurrency);

	}
}