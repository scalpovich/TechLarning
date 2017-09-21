package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

public class PlasticCode {

	private String plasticCodeNumber;
	private String description;
	
	public String getPlasticCodeNumber() {
		return plasticCodeNumber;
	}
	public void setPlasticCodeNumber(String plasticCodeNumber) {
		this.plasticCodeNumber = plasticCodeNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static PlasticCode createWithProvider(DataProvider provider)
	{
		return provider.getDataBySimpleClassName(PlasticCode.class);
	}


	public PlasticCode plasticcodeDataprovider() {
		PlasticCode plasticcode = new PlasticCode();
		plasticcode.setDescription("Plastic code");
		return plasticcode;
	}

}
