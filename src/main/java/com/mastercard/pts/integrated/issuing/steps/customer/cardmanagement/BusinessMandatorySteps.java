package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BusinessMandatory;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.BusinessMandatoryFlows;

@Component
public class BusinessMandatorySteps {

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	BusinessMandatoryFlows businessmandatflows;

	@Autowired
	BusinessMandatory businessmandat;

	@Autowired
	Program program;

	@When("user creates Business Mandatory Fields for $CustomerType customer type from the file $filename for $product")
	public void whenUserCreatesBusinessMandatoryFields(@Named("CustomerType") String CustomerType,
			@Named("filename") String filename, @Named("product") String product) {
		devicecreation.setProduct(product);
		businessmandat.setCustomerType(CustomerType);
		businessmandatflows.addBusinessMandatoryFields(devicecreation, businessmandat, program);
	}
}
