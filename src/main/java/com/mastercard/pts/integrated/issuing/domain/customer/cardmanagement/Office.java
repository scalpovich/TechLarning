package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import java.util.List;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

@Component
public class Office {
	public static Office office = new Office();

	private String officeType;
	private String officeCode;
	private String officeName;
	private String addressLine1;
	private String addressLine2;
	private String country;
	private String zip;
	private String controlOffice;
	
	public String getOfficeType() {
		return officeType;
	}
	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String zoneCode) {
		this.officeCode = zoneCode;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String zoneName) {
		this.officeName = zoneName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getControlOffice() {
		return controlOffice;
	}
	public void setControlOffice(String controlOffice) {
		this.controlOffice = controlOffice;
	}
	
	public static List<Office> createWithProvider(DataProvider provider)
	{
		return provider.getData(new TypeReference<List<Office>>() {}, "Office");
	}
	public static Office OfficeDataProvider() {

		office.setAddressLine1(MapUtils.fnGetInputDataFromMap("addressLine1"));
		office.setAddressLine2(MapUtils.fnGetInputDataFromMap("addressLine2"));
		office.setCountry(MapUtils.fnGetInputDataFromMap("country"));
		office.setZip(MapUtils.fnGetInputDataFromMap("postalCode"));
		return office;

	}
}
