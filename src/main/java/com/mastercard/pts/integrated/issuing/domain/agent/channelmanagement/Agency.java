package com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class Agency {
	
	private String agencyId;
	private String agencyName;
	private String agentType;
	private String agentClassification;
	private String address1;
	private String country;
	private String email;
	private String postalCode;
	public String getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAgentType() {
		return agentType;
	}
	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}
	public String getAgentClassification() {
		return agentClassification;
	}
	public void setAgentClassification(String agentClassification) {
		this.agentClassification = agentClassification;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static Agency createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(Agency.class);
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
