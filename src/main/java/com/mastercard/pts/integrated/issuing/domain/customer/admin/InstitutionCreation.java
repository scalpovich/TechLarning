package com.mastercard.pts.integrated.issuing.domain.customer.admin;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaFeeCollection;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class InstitutionCreation extends AbstractBasePage {

	private String institutionCode;
	private String institutionName;
	private String institutionAbbrevation;
	private String institutionCurrency;
	private String institutionReferenceCurrency;
	private String finanacialStartMonth;
	private String defaultLanguage;
	private String timeZone;
	private String accountNumberLength;
	private String clientNumberLength;
	private String financialYearStartMonth;
	private String sdnPlan;
	private String adaptiveAuthentication;
	private String mPinEnabled;
	private String smsServiceProvider;
	private String emailID;
	private String contactName;
	private String mobileCountryCode;
	private String mobilenumber;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String country;
	private String postalCode;
	private String phoneNumb;
	private String institutionType;
	private String customerCareContactNumber;
	private String customerCareFax;
	private String collectPortalAdminID;
	private String collectPortalAdminName;
	private String agentPortalAdminID;
	private String agentPortalAdminName;
	private String createdInstitution;
	private String ascVendor;
	private String existingInstitutionCode;
	private String authenticationFlg;
	private String credentialMasking;
	
	public String getCredentialMasking() {
		return credentialMasking;
	}

	public void setCredentialMasking(String credentialMasking) {
		this.credentialMasking = credentialMasking;
	}

	public String getCreatedInstitution() {
		return createdInstitution;
	}

	public void setCreatedInstitution(String createdInstitution) {
		this.createdInstitution = createdInstitution;
	}

	public String getAgentPortalAdminID() {
		return agentPortalAdminID;
	}

	public void setAgentPortalAdminID(String agentPortalAdminID) {
		this.agentPortalAdminID = agentPortalAdminID;
	}

	public String getAgentPortalAdminName() {
		return agentPortalAdminName;
	}

	public void setAgentPortalAdminName(String agentPortalAdminName) {
		this.agentPortalAdminName = agentPortalAdminName;
	}	
	
	public String getCollectPortalAdminID() {
		return collectPortalAdminID;
	}

	public void setCollectPortalAdminID(String collectPortalAdminID) {
		this.collectPortalAdminID = collectPortalAdminID;
	}

	public String getCollectPortalAdminName() {
		return collectPortalAdminName;
	}

	public void setCollectPortalAdminName(String collectPortalAdminName) {
		this.collectPortalAdminName = collectPortalAdminName;
	}

	public String getCustomerCareContactNumber() {
		return customerCareContactNumber;
	}

	public void setCustomerCareContactNumber(String customerCareContactNumber) {
		this.customerCareContactNumber = customerCareContactNumber;
	}

	public String getCustomerCareFax() {
		return customerCareFax;
	}

	public void setCustomerCareFax(String customerCareFax) {
		this.customerCareFax = customerCareFax;
	}

	public String getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

	public String getMobileCountryCode() {
		return mobileCountryCode;
	}

	public void setMobileCountryCode(String mobileCountryCode) {
		this.mobileCountryCode = mobileCountryCode;
	}

	public String getPhoneNumb() {
		return phoneNumb;
	}

	public void setPhoneNumb(String phoneNumb) {
		this.phoneNumb = phoneNumb;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getFinanacialStartMonth() {
		return finanacialStartMonth;
	}

	public void setFinanacialStartMonth(String finanacialStartMonth) {
		this.finanacialStartMonth = finanacialStartMonth;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getInstitutionAbbrevation() {
		return institutionAbbrevation;
	}

	public void setInstitutionAbbrevation(String institutionAbbrevation) {
		this.institutionAbbrevation = institutionAbbrevation;
	}

	public String getInstitutionCurrency() {
		return institutionCurrency;
	}

	public void setInstitutionCurrency(String institutionCurrency) {
		this.institutionCurrency = institutionCurrency;
	}

	public String getInstitutionReferenceCurrency() {
		return institutionReferenceCurrency;
	}

	public void setInstitutionReferenceCurrency(
			String institutionReferenceCurrency) {
		this.institutionReferenceCurrency = institutionReferenceCurrency;
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

	public String getAccountNumberLength() {
		return accountNumberLength;
	}

	public void setAccountNumberLength(String accountNumberLength) {
		this.accountNumberLength = accountNumberLength;
	}

	public String getClientNumberLength() {
		return clientNumberLength;
	}

	public void setClientNumberLength(String clientNumberLength) {
		this.clientNumberLength = clientNumberLength;
	}

	public String getFinancialYearStartMonth() {
		return financialYearStartMonth;
	}

	public void setFinancialYearStartMonth(String financialYearStartMonth) {
		this.financialYearStartMonth = financialYearStartMonth;
	}

	public String getSDNPlan() {
		return sdnPlan;
	}

	public void setSDNPlan(String sDNPlan) {
		this.sdnPlan = sDNPlan;
	}
	
	public String getAdaptiveAuthentication() {
		return adaptiveAuthentication;
	}

	public void setAdaptiveAuthentication(String adaptiveAuthentication) {
		this.adaptiveAuthentication = adaptiveAuthentication;
	}

	public String getmPinEnabled() {
		return mPinEnabled;
	}

	public void setmPinEnabled(String mPinEnabled) {
		this.mPinEnabled = mPinEnabled;
	}

	public String getSmsServiceProvider() {
		return smsServiceProvider;
	}

	public void setSmsServiceProvider(String smsServiceProvider) {
		this.smsServiceProvider = smsServiceProvider;
	}

	public static InstitutionCreation getInstitutionData() {
		InstitutionCreation institute = new InstitutionCreation();
		institute.setInstitutionCode(CustomUtils.RandomNumbers(6));
		institute.setInstitutionName(MapUtils
				.fnGetInputDataFromMap("InstitutionName")
				+ CustomUtils.randomString(2).toUpperCase());
		institute.setInstitutionAbbrevation(institute.getInstitutionName());
		institute.setInstitutionCurrency(MapUtils
				.fnGetInputDataFromMap("Institution Currency"));
		institute.setInstitutionReferenceCurrency(MapUtils
				.fnGetInputDataFromMap("Reference Currency"));
		institute.setDefaultLanguage(MapUtils
				.fnGetInputDataFromMap("Default Language"));
		institute.setTimeZone(MapUtils.fnGetInputDataFromMap("Time Zone"));
		institute.setAccountNumberLength(MapUtils
				.fnGetInputDataFromMap("Account Number Length"));
		institute.setClientNumberLength(MapUtils
				.fnGetInputDataFromMap("Client Number Length"));
		institute.setFinanacialStartMonth(MapUtils
				.fnGetInputDataFromMap("Financial Start Month"));
		institute.setSDNPlan(MapUtils.fnGetInputDataFromMap("SDN Plan"));
		institute.setAdaptiveAuthentication(MapUtils
				.fnGetInputDataFromMap("Adaptive Authentication"));
		institute.setmPinEnabled(MapUtils
				.fnGetInputDataFromMap("MPIN Enabled"));
		institute.setSmsServiceProvider(MapUtils
				.fnGetInputDataFromMap("SMS Service Provider"));
		institute
				.setContactName(MapUtils.fnGetInputDataFromMap("Contact Name"));
		institute.setEmailID(MapUtils.fnGetInputDataFromMap("Email Id"));
		institute.setCustomerCareContactNumber(MapUtils
				.fnGetInputDataFromMap("Customer Care Contact Numbers"));
		institute.setCustomerCareFax(MapUtils
				.fnGetInputDataFromMap("Customer Care Fax"));
		institute.setPhoneNumb(CustomUtils.RandomNumbers(10));
		institute.setMobileCountryCode(MapUtils
				.fnGetInputDataFromMap("Mobile No Country Code"));
		institute.setMobilenumber(MapUtils.fnGetInputDataFromMap("Mobile No"));
		institute.setAddressLine1(MapUtils
				.fnGetInputDataFromMap("Address Line1"));
		institute.setAddressLine2(MapUtils
				.fnGetInputDataFromMap("Address Line2"));
		institute.setAddressLine3(MapUtils
				.fnGetInputDataFromMap("Address Line3"));
		institute.setAddressLine4(MapUtils
				.fnGetInputDataFromMap("Address Line4"));
		institute.setCountry(MapUtils.fnGetInputDataFromMap("Country"));
		institute.setPostalCode(MapUtils.fnGetInputDataFromMap("Postal Code"));
		institute.setCreatedInstitution(MapUtils.fnGetInputDataFromMap("CreatedInstitution"));
		institute.setCollectPortalAdminID(MiscUtils.generateRandomNumberAsString(6));
		institute.setCollectPortalAdminName(MapUtils.fnGetInputDataFromMap("CollectPortalAdminName")+MiscUtils.generateRandomNumberAsString(5));
		institute.setAgentPortalAdminID(MiscUtils.generateRandomNumberAsString(6));
		institute.setAgentPortalAdminName(MapUtils.fnGetInputDataFromMap("AgentPortalAdminName")+MiscUtils.generateRandomNumberAsString(5));					
		institute.setAscVendor(MapUtils.fnGetInputDataFromMap("ASC_Vendor"));
		institute.setExistingInstitutionCode(MapUtils.fnGetInputDataFromMap("ExistingInstitutionCode"));
		return institute;
	}

	public String getAscVendor() {
		return ascVendor;
	}

	public void setAscVendor(String ascVendor) {
		this.ascVendor = ascVendor;
	}

	public String getExistingInstitutionCode() {
		return existingInstitutionCode;
	}

	public void setExistingInstitutionCode(String existingInstitutionCode) {
		this.existingInstitutionCode = existingInstitutionCode;
	}
	public static InstitutionCreation createWithProvider(KeyValueProvider provider) {
		InstitutionCreation institute = new InstitutionCreation();
		institute.setExistingInstitutionCode(provider.getString("ExistingInstitutionCode"));
		institute.setAscVendor(provider.getString("ASC_Vendor"));
		return institute;
	}

	public String getAuthenticationFlg() {
		return authenticationFlg;
	}

	public void setAuthenticationFlg(String authenticationFlg) {
		this.authenticationFlg = authenticationFlg;
	}
	

}
