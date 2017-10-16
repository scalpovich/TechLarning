package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class Office {
	public static Office office = new Office();
	public String AddressLine1;

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String AddressLine2;
	public String Country;
	public String PostalCode;
	public String OfficeType;
	public String ControlCode;

	public String getControlCode() {
		System.out.println("getter:- " + ControlCode);
		return ControlCode;
	}

	public void setControlCode(String controlCode) {
		System.out.println("setter:- " + controlCode);
		ControlCode = controlCode;
	}

	public String getOfficeType() {
		return OfficeType;
	}

	public void setOfficeType(String officeType) {
		OfficeType = officeType;
	}

	public static Office OfficeDataProvider() {

		office.setAddressLine1(MapUtils.fnGetInputDataFromMap("addressLine1"));
		office.setAddressLine2(MapUtils.fnGetInputDataFromMap("addressLine2"));
		office.setCountry(MapUtils.fnGetInputDataFromMap("country"));
		office.setPostalCode(MapUtils.fnGetInputDataFromMap("postalCode"));
		return office;

	}

}
