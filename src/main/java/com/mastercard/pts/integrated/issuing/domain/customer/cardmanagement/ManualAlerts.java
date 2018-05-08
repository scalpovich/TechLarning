package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class ManualAlerts {
	
	private String clientCode;
	private String programCode;
	private String firstName;
	private String familyName;
	private String deviceType;
	private String cbsClientID;
	private String product;
	private String eventCode;

	
	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getCbsClientID() {
		return cbsClientID;
	}

	public void setCbsClientID(String cbsClientID) {
		this.cbsClientID = cbsClientID;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public static ManualAlerts manualAlertsDataProvider() {	
		ManualAlerts alert= new ManualAlerts();
		alert.setCbsClientID(MapUtils.fnGetInputDataFromMap("cbsclientIDTxt"));
		alert.setClientCode(MapUtils.fnGetInputDataFromMap("clientCode"));
		alert.setDeviceType(MapUtils.fnGetInputDataFromMap("deviceTypeDdwn"));
		alert.setFamilyName(MapUtils.fnGetInputDataFromMap("familyNameTxt"));
		alert.setFirstName(MapUtils.fnGetInputDataFromMap("firstNameTxt"));
		alert.setProgramCode(MapUtils.fnGetInputDataFromMap("programCodeDdwn"));
		
		return alert;
	}
}
