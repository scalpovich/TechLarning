package com.mastercard.pts.integrated.issuing.domain.customer.admin;


import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class InstutionCreation extends AbstractBasePage{

	public String institutionCode;
	public String institutionName;
	public String institutionAbbrevation;
	public String institutionCurrency;
	public String institutionReferenceCurrency;
	public String finanacialStartMonth;
	public String defaultLanguage;
	public String timeZone;
	public String accountNumberLength;
	public String clientNumberLength;
	public String financialYearStartMonth;
	public String SDNPlan;
	public String emailID;
	public String ContactName;
	public String PhoneNumb;
	public String mobileCountryCode;
	public String mobilenumber;
	public String addressLine1;
	public String addressLine2;
	public String addressLine3;
	public String addressLine4;
	public String country;
	public String postalCode;
	public String institutionType;
	public String customerCareContactNumber;
	public String customerCareFax;
	
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
		return PhoneNumb;
	}
	public void setPhoneNumb(String phoneNumb) {
		PhoneNumb = phoneNumb;
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
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
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
	public void setInstitutionReferenceCurrency(String institutionReferenceCurrency) {
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
		return SDNPlan;
	}
	public void setSDNPlan(String sDNPlan) {
		SDNPlan = sDNPlan;
	}
	
	public static InstutionCreation getInstitutionData(){		
		InstutionCreation institute = new InstutionCreation();
		institute.setInstitutionCode(CustomUtils.RandomNumbers(6));
		institute.setInstitutionName(MapUtils.fnGetInputDataFromMap("InstitutionName") +CustomUtils.randomString(2).toUpperCase());
		institute.setInstitutionAbbrevation(MapUtils.fnGetInputDataFromMap("InstitutionName"));
		institute.setInstitutionCurrency(MapUtils.fnGetInputDataFromMap("Institution Currency"));
		institute.setInstitutionReferenceCurrency(MapUtils.fnGetInputDataFromMap("Reference Currency"));
		institute.setDefaultLanguage(MapUtils.fnGetInputDataFromMap("Default Language"));
		institute.setTimeZone(MapUtils.fnGetInputDataFromMap("Time Zone"));
		institute.setAccountNumberLength(MapUtils.fnGetInputDataFromMap("Account Number Length"));
		institute.setClientNumberLength(MapUtils.fnGetInputDataFromMap("Client Number Length"));
		institute.setFinanacialStartMonth(MapUtils.fnGetInputDataFromMap("Financial Start Month"));
		institute.setSDNPlan(MapUtils.fnGetInputDataFromMap("SDN Plan"));
		institute.setContactName(MapUtils.fnGetInputDataFromMap("Contact Name"));
		institute.setEmailID(MapUtils.fnGetInputDataFromMap("Email Id"));
		institute.setCustomerCareContactNumber(MapUtils.fnGetInputDataFromMap("Customer Care Contact Numbers"));
		institute.setCustomerCareFax(MapUtils.fnGetInputDataFromMap("Customer Care Fax"));
		institute.setPhoneNumb(CustomUtils.RandomNumbers(10));		
		institute.setMobileCountryCode(MapUtils.fnGetInputDataFromMap("Mobile No Country Code"));
		institute.setMobilenumber(MapUtils.fnGetInputDataFromMap("Mobile No"));
		institute.setAddressLine1(MapUtils.fnGetInputDataFromMap("Address Line1"));
		institute.setAddressLine2(MapUtils.fnGetInputDataFromMap("Address Line2"));
		institute.setAddressLine3(MapUtils.fnGetInputDataFromMap("Address Line3"));
		institute.setAddressLine4(MapUtils.fnGetInputDataFromMap("Address Line4"));
		institute.setCountry(MapUtils.fnGetInputDataFromMap("Country"));
		institute.setPostalCode(MapUtils.fnGetInputDataFromMap("Postal Code"));		
		return institute;
	}
		
}
