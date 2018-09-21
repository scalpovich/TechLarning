package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;


import com.mastercard.pts.integrated.issuing.utils.MapUtils;


public class ThreeDECommerceSecurityParameters {
	
	private String eCommerceSecurityInterchange;
	
	private String validateCAVVAAV;
	
	private String deviceRangeFrom;
	
	private String deviceRangeTo;
	
	private String checkStatus;
	
	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String geteCommerceSecurityInterchange() {
		return eCommerceSecurityInterchange;
	}

	public void seteCommerceSecurityInterchange(String eCommerceSecurityInterchange) {
		this.eCommerceSecurityInterchange = eCommerceSecurityInterchange;
	}

	public String getValidateCAVVAAV() {
		return validateCAVVAAV;
	}

	public void setValidateCAVVAAV(String validateCAVVAAV) {
		this.validateCAVVAAV = validateCAVVAAV;
	}

	public String getDeviceRangeFrom() {
		return deviceRangeFrom;
	}

	public void setDeviceRangeFrom(String deviceRangeFrom) {
		this.deviceRangeFrom = deviceRangeFrom;
	}

	public String getDeviceRangeTo() {
		return deviceRangeTo;
	}

	public void setDeviceRangeTo(String deviceRangeTo) {
		this.deviceRangeTo = deviceRangeTo;
	}	
	
	public static ThreeDECommerceSecurityParameters getThreeDECommerceSecurityData() {
		ThreeDECommerceSecurityParameters threeDECommerceSecurity = new ThreeDECommerceSecurityParameters();
		threeDECommerceSecurity.seteCommerceSecurityInterchange(MapUtils.fnGetInputDataFromMap("3D_SECURE_TNX_INTERCHANGE"));
		threeDECommerceSecurity.setValidateCAVVAAV(MapUtils.fnGetInputDataFromMap("VALIDATE_CAVV_AAV"));
		return threeDECommerceSecurity;
	}

}