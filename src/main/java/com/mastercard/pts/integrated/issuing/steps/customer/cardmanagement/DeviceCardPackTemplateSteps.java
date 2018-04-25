package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCardPackTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceCardPackTemplateFlows;

@Component
public class DeviceCardPackTemplateSteps {

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	DeviceCardPackTemplateFlows devicecardpacktemplflows;

	public String DEVICE_TEMPLATE = "Device Template";

	public String CARD_PACK_TEMPLATE = "Card Pack ID Template";

	public DeviceCardPackTemplate devicecardtemplate;

	@When("user creates Template of type $Templatetype and of length $Templatelength")
	public void whenUserCreatesTemplateOfTypeTypeAndOfLengthLength(@Named("Templatetype") String Templatetype,
			@Named("Templatelength") String Templatelength) {
		devicecardtemplate = DeviceCardPackTemplate.deviceCardPackTemplateDataProvider();
		devicecreation.setTemplateType(Templatetype);
		devicecreation.setLength(Templatelength);
		if (Templatetype.contains(DEVICE_TEMPLATE)) {
			devicecardpacktemplflows.createDeviceTemplateCardPack(devicecreation, devicecardtemplate);
		}
		if (Templatetype.contains(CARD_PACK_TEMPLATE)) {
			devicecardpacktemplflows.createCardPackTemplate(devicecreation, devicecardtemplate);
		}
	}
}