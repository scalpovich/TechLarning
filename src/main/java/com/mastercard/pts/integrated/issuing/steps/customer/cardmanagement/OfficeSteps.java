package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Office;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.OfficeFlows;

@Component
public class OfficeSteps {

	@Autowired
	OfficeFlows officeflows;

	@Autowired
	Office office;

	@When("user creates a $type Office")
	public void whenUserCreatesAZonalOffice(@Named("type") String type) {
		office = Office.OfficeDataProvider();
		office.setOfficeType(type);
		String controlCode = officeflows.addOffice(office, type);
		office.setControlCode(controlCode);
	}
}