package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.HashMap;
import java.util.Map;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;


public class ReissueTPINDownload {
	
	private String clientCode;
	private String deviceNumber;
	private String program;
	private String activationDate;
	private String title;
	private String firstname;
	private String lastname;
	private String addressLine1;
	private String city;
	private String zipcode;
	private String userDelete;
	private String expiryDate;
	private String email;
	
	private Map<String, String> fileHeaderMap;
	
	public Map<String, String> getFileHeaderMap() {
		return fileHeaderMap;
	}

	public void setFileHeaderMap(Map<String, String> fileHeaderMap) {
		this.fileHeaderMap = fileHeaderMap;
	}

	public static ReissueTPINDownload createWithProvider(KeyValueProvider provider){
		ReissueTPINDownload reissueTPIN = new ReissueTPINDownload();
		Map<String, String> headerMap = new HashMap<>();
		for(int i = 0; i < 23; i++) {
			headerMap.put("field" +i, provider.getString("field" +i)); 
		}
		reissueTPIN.setFileHeaderMap(headerMap);
		return reissueTPIN;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getUserDelete() {
		return userDelete;
	}

	public void setUserDelete(String userDelete) {
		this.userDelete = userDelete;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
