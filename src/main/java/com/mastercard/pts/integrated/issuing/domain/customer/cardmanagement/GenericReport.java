package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.HashMap;
import java.util.Map;

public class GenericReport {

	private String authorizationCode;
	private String deviceNumber;
	private String rrnNumber;
	private String username;
	private static Map<String, String> reportFields;
	private String regEx;
	
	
	public Map<String, String> setFieldToValidate(String field,String value){
		reportFields.put(field,value);
		return reportFields;
	}
	
	public static GenericReport getGenericReport(){
		GenericReport report = new GenericReport();
		reportFields = new HashMap<String, String>();
		return report;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getRrnNumber() {
		return rrnNumber;
	}

	public void setRrnNumber(String rrnNumber) {
		this.rrnNumber = rrnNumber;
	}
	
	public void setRegEx(String regEx){
		this.regEx = regEx;
	}
	
	public String getRegEx(){
		return regEx;
	}
	
	
}
