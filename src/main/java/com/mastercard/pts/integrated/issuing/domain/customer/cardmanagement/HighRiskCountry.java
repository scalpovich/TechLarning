package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class HighRiskCountry {

	public String highRiskCountry;
	
	public static HighRiskCountry getHighRiskCountryData()
	{
		HighRiskCountry countryData=new HighRiskCountry();
		countryData.setHighRiskCountry(MapUtils.fnGetInputDataFromMap("HighRiskCountry"));
		return countryData;
		
	}

	public String getHighRiskCountry() {
		return highRiskCountry;
	}

	public void setHighRiskCountry(String highRiskCountry) {
		this.highRiskCountry = highRiskCountry;
	}

}
