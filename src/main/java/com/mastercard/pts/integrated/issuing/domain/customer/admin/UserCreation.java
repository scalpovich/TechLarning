package com.mastercard.pts.integrated.issuing.domain.customer.admin;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class UserCreation{

	private String userID;
	private String userName;
	private String role;
	private String languagePreference;
	private String timeZone;
	private String loginAllowedFrom;
	private String loginallowedTill;
	private String emailAdress;
	private String countryCode;
	private String mobileNumber;
	private String userAccountExpiryDate;
	private String concurrentLoginAllowed;
	private String maxConcurrentUser;
	private String institutionName;
	private String savedInstituteInXL;
	
	
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLanguagePreference() {
		return languagePreference;
	}
	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getLoginAllowedFrom() {
		return loginAllowedFrom;
	}
	public void setLoginAllowedFrom(String loginAllowedFrom) {
		this.loginAllowedFrom = loginAllowedFrom;
	}
	public String getLoginallowedTill() {
		return loginallowedTill;
	}
	public void setLoginallowedTill(String loginallowedTill) {
		this.loginallowedTill = loginallowedTill;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserAccountExpiryDate() {
		return userAccountExpiryDate;
	}
	public void setUserAccountExpiryDate(String userAccountExpiryDate) {
		this.userAccountExpiryDate = userAccountExpiryDate;
	}
	public String getConcurrentLoginAllowed() {
		return concurrentLoginAllowed;
	}
	public void setConcurrentLoginAllowed(String concurrentLoginAllowed) {
		this.concurrentLoginAllowed = concurrentLoginAllowed;
	}
	public String getMaxConcurrentUser() {
		return maxConcurrentUser;
	}
	public void setMaxConcurrentUser(String maxConcurrentUser) {
		this.maxConcurrentUser = maxConcurrentUser;
	}	
	public String getSavedInstituteInXL() {
		return savedInstituteInXL;
	}
	public void setSavedInstituteInXL(String savedInstituteInXL) {
		this.savedInstituteInXL = savedInstituteInXL;
	}
		
	public static UserCreation getUserCreationData(){
	UserCreation user= new UserCreation();
	user.setUserID(CustomUtils.randomNumbers(6));
	user.setUserName(MapUtils.fnGetInputDataFromMap("NewUserName")+ CustomUtils.randomString(3).toUpperCase());
	user.setRole(MapUtils.fnGetInputDataFromMap("Role"));
	user.setLanguagePreference(MapUtils.fnGetInputDataFromMap("LanguagePreference"));
	user.setTimeZone(MapUtils.fnGetInputDataFromMap("TimeZone"));
	user.setLoginAllowedFrom(MapUtils.fnGetInputDataFromMap("Login Allowed From"));
	user.setLoginallowedTill(MapUtils.fnGetInputDataFromMap("Login Allowed Till"));
	user.setEmailAdress(user.getUserName()+"@gmail.com");
	user.setCountryCode(MapUtils.fnGetInputDataFromMap("CountryCode"));
	user.setMobileNumber(CustomUtils.randomNumbers(10));
	user.setUserAccountExpiryDate(MapUtils.fnGetInputDataFromMap("UserAccountExpiryDate"));
	user.setConcurrentLoginAllowed(MapUtils.fnGetInputDataFromMap("ConcurrentLoginAllowed"));
	user.setMaxConcurrentUser(MapUtils.fnGetInputDataFromMap("MaximumConcurrentUser"));
	user.setSavedInstituteInXL(MapUtils.fnGetInputDataFromMap("CreatedInstitution"));
	return user;	
	}
	
}
