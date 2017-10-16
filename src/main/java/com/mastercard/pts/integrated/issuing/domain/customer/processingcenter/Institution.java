package com.mastercard.pts.integrated.issuing.domain.customer.processingcenter;

import java.util.Map;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class Institution {
	private String name;
	private String code;
	private String abbreviation;
	private boolean debit;
	private boolean credit;
	private boolean prepaid;
	private boolean agentPortalSupport;
	private boolean collectPortalSupport;
	private String defaultLanguage;
	private String timeZone;
	private String ccNumber;
	private String ccEmail;
	private String contactName;
	private String phone;
	private String mobileNum;
	private String mobileCountryCode;
	private String email;
	private String address1;
	private String address2;
	private String country;
	private String state;
	private String city;
	private Map<String,String> postalCode;
	private String agentPortalStatus;
	private String portalAdminName;
	private String collectPortalStatus;
	private String institutionCurrency;
	private String portalAdminId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public boolean isDebit() {
		return debit;
	}
	public void setDebit(boolean debit) {
		this.debit = debit;
	}
	public boolean isCredit() {
		return credit;
	}
	public void setCredit(boolean credit) {
		this.credit = credit;
	}
	public boolean isPrepaid() {
		return prepaid;
	}
	public void setPrepaid(boolean prepaid) {
		this.prepaid = prepaid;
	}
	public String getDefaultLanguage() {
		return defaultLanguage;
	}
	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getCcEmail() {
		return ccEmail;
	}
	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getMobileCountryCode() {
		return mobileCountryCode;
	}
	public void setMobileCountryCode(String mobileCountryCode) {
		this.mobileCountryCode = mobileCountryCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Map<String, String> getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Map<String, String> postalCode) {
		this.postalCode = postalCode;
	}
	public String getAgentPortalStatus() {
		return agentPortalStatus;
	}
	public void setAgentPortalStatus(String agentPortalStatus) {
		this.agentPortalStatus = agentPortalStatus;
	}
	public String getPortalAdminName() {
		return portalAdminName;
	}
	public void setPortalAdminName(String portalAdminName) {
		this.portalAdminName = portalAdminName;
	}
	public String getCollectPortalStatus() {
		return collectPortalStatus;
	}
	public void setCollectPortalStatus(String collectPortalStatus) {
		this.collectPortalStatus = collectPortalStatus;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInstitutionCurrency() {
		return institutionCurrency;
	}
	public void setInstitutionCurrency(String institutionCurrency) {
		this.institutionCurrency = institutionCurrency;
	}
	public boolean isAgentPortalSupport() {
		return agentPortalSupport;
	}
	public void setAgentPortalSupport(boolean agentPortalSupport) {
		this.agentPortalSupport = agentPortalSupport;
	}
	public boolean isCollectPortalSupport() {
		return collectPortalSupport;
	}
	public void setCollectPortalSupport(boolean collectPortalSupport) {
		this.collectPortalSupport = collectPortalSupport;
	}
	
	public String getPortalAdminId() {
		return portalAdminId;
	}
	public void setPortalAdminId(String portalAdminId) {
		this.portalAdminId = portalAdminId;
	}
	public static Institution createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(Institution.class);
	}
	
	public String buildAbbreviationAndCode() {
		return String.format("%s [%s]", getAbbreviation(), getCode());
	}
		
	public static Institution getInstitution()
	{
		Institution inst=new Institution();
		inst.setAbbreviation("xyz");
		return inst;
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
