package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.HashMap;
import java.util.Map;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class GenericReport implements HasCodeAndDescription{

	private String authorizationCode;
	private String deviceNumber;
	private String rrnNumber;
	private String username;
	private static Map<String, String> reportFields;
	private static Map<String, String> reportRegEx;
	private String reportName;
	private String reportType;
	private String reportUrl;
	private String password;
	private String clientCode;
	private String deviceType;
	private String loyaltyPlan;
	private String loyaltyPromotionPlan;

	public String getLoyaltyPromotionPlan() {
		return loyaltyPromotionPlan;
	}

	public void setLoyaltyPromotionPlan(String loyaltyPromotionPlan) {
		this.loyaltyPromotionPlan = loyaltyPromotionPlan;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getLoyaltyPlan() {
		return loyaltyPlan;
	}

	public void setLoyaltyPlan(String loyaltyPlan) {
		this.loyaltyPlan = loyaltyPlan;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
		report.setReportRegEx();
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
	
	public void setReportRegEx(){
		reportRegEx = new HashMap<>();
		reportRegEx.put("RAMP", "\\d\\d-\\d\\d-\\d\\d\\d\\d");
		reportRegEx.put("Application Reject Report", "\\d\\d-\\d\\d-\\d\\d\\d\\d");
		reportRegEx.put(ConstantData.DEVICE_ACTIVITY_REPORT_FILE_NAME, "\\D\\d\\d\\d\\d\\D");
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}

	@Override
	public String getCode() {
		return reportName;
	}

	@Override
	public String getDescription() {
		return null;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	
}
