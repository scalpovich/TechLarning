package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class PlasticCode {

	public String Description;

	public String PlasticCode;

	public String getPlasticCode() {
		return PlasticCode;
	}

	public void setPlasticCode(String plasticCode) {
		PlasticCode = plasticCode;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public static PlasticCode plasticcodeDataprovider() {
		PlasticCode plasticcode = new PlasticCode();
		plasticcode.setDescription("Plastic code");
		return plasticcode;
	}

}
