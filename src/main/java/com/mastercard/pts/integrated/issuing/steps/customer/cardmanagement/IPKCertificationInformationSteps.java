package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.IssuerPublicKey;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.IPKCertificationInfoFlows;

@Component
public class IPKCertificationInformationSteps {

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	IssuerPublicKey ipk;

	@Autowired
	DeviceBin devicebin;

	@Autowired
	IPKCertificationInfoFlows ipkflows;

	@When("user creates IPKCertificationInformation for interchange $Interchange")
	public void whenUserCreatesIPKCertificationInformation(@Named("Interchange") String Interchange) {
		ipk.ipkDatProvider();
		ipk.setInterchange(Interchange);
		ipk.setDeviceBin(devicebin.getIssuerBin());
		ipkflows.addIPK(ipk);
	}
}