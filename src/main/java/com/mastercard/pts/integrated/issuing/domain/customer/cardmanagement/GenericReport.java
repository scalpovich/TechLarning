package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.HashMap;
import java.util.Map;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class GenericReport {

	private String authorizationCode;
	private String deviceNumber;
	private String rrnNumber;
	private String username;
	private static Map<String, String> reportFields;
	private static Map<String, String> reportRegEx;
	private String reportName;
	private String reportType;
	private String reportUrl;
	
	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public void setFieldToValidate(String field,String value){
		reportFields.put(field,value);
	}
	
	public Map<String, String> getFieldToValidate(){
		return reportFields;
	}
	
	public static GenericReport createWithProvider(KeyValueProvider provider){
		GenericReport report = new GenericReport();
		reportFields = new HashMap<>();
		reportRegEx = new HashMap<>();
		reportRegEx.put("RAMP", "\\d\\d-\\d\\d-\\d\\d\\d\\d");
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
	
	public String getReportRegEx(){
		return reportRegEx.get(reportName);
	}
	
	
}
