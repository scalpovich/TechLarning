package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Address {

	private String addressLine1;
	
	private String addressLine2;
	
	private String addressLine3;
	
	private String addressLine4;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String postalCode;
	
	private String phone1;
	
	private String phone2;
	
	public static Address generateAddress() {
		Address address = new Address();
		address.setCountry("INDIA [356]");
		address.setAddressLine1(RandomStringUtils.randomNumeric(4) + ", Baker street" + RandomStringUtils.randomNumeric(3));
		address.setPostalCode("411006");
		return address;
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

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
