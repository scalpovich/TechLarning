package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class TransactionReports {

	private String authrizationCode;
	private String deviceNumber;
	private String rrnNumber;
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthrizationCode() {
		return authrizationCode;
	}

	public void setAuthrizationCode(String authrizationCode) {
		this.authrizationCode = authrizationCode;
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
}
