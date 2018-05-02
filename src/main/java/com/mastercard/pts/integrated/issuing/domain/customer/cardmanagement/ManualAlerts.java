package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class ManualAlerts {
	
	private String clientCode;
	private String programCodeDdwn;
	private String firstNameTxt;
	private String familyNameTxt;
	private String deviceTypeDdwn;
	private String cbsClientIDTxt;
	private String product;
	private String eventCode;

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getProgramCodeDdwn() {
		return programCodeDdwn;
	}

	public void setProgramCodeDdwn(String programCodeDdwn) {
		this.programCodeDdwn = programCodeDdwn;
	}

	public String getFirstNameTxt() {
		return firstNameTxt;
	}

	public void setFirstNameTxt(String firstNameTxt) {
		this.firstNameTxt = firstNameTxt;
	}

	public String getFamilyNameTxt() {
		return familyNameTxt;
	}

	public void setFamilyNameTxt(String familyNameTxt) {
		this.familyNameTxt = familyNameTxt;
	}

	public String getDeviceTypeDdwn() {
		return deviceTypeDdwn;
	}

	public void setDeviceTypeDdwn(String deviceTypeDdwn) {
		this.deviceTypeDdwn = deviceTypeDdwn;
	}

	public String getCbsClientIDTxt() {
		return cbsClientIDTxt;
	}

	public void setCbsClientIDTxt(String cbsClientIDTxt) {
		this.cbsClientIDTxt = cbsClientIDTxt;
	}

	
	public static ManualAlerts manualAlertsDataProvider() {	
		ManualAlerts alertpage= new ManualAlerts();
		alertpage.setCbsClientIDTxt(MapUtils.fnGetInputDataFromMap("cbsclientIDTxt"));
		alertpage.setClientCode(MapUtils.fnGetInputDataFromMap("clientCode"));
		alertpage.setDeviceTypeDdwn(MapUtils.fnGetInputDataFromMap("deviceTypeDdwn"));
		alertpage.setFamilyNameTxt(MapUtils.fnGetInputDataFromMap("familyNameTxt"));
		alertpage.setFirstNameTxt(MapUtils.fnGetInputDataFromMap("firstNameTxt"));
		alertpage.setProgramCodeDdwn(MapUtils.fnGetInputDataFromMap("programCodeDdwn"));
		
		return new ManualAlerts();
	}
	
	public static List<ManualAlerts> createWithProvider(DataProvider provider)
	{
		return provider.getData(new TypeReference<List<ManualAlerts>>() {}, "ManualAlerts");
	}
}
