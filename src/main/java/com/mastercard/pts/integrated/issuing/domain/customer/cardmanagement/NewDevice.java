package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class NewDevice extends AbstractBasePage {

	public String DeviceNumber;

	public String BatchNum;

	public String getBatchNum() {
		return BatchNum;
	}

	public void setBatchNum(String batchNum) {
		BatchNum = batchNum;
	}

	public String getDeviceNumber() {
		return DeviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		DeviceNumber = deviceNumber;
	}

	public String getApplicationType() {
		return ApplicationType;
	}

	public void setApplicationType(String applicationType) {
		ApplicationType = applicationType;
	}

	public String getApplicationSubType() {
		return ApplicationSubType;
	}

	public void setApplicationSubType(String applicationSubType) {
		ApplicationSubType = applicationSubType;
	}

	public String ApplicationType;

	public String ApplicationSubType;

	public String BatchType;

	public String getBatchType() {
		return BatchType;
	}

	public void setBatchType(String batchType) {
		BatchType = batchType;
	}

	public String CustomerType;

	public String getCustomerType() {
		return CustomerType;
	}

	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}

	public String DeviceType;

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}

	public String Title;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String FirstName;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String LastName;

	public String MiddleName1;

	public String getMiddleName1() {
		return MiddleName1;
	}

	public void setMiddleName1(String middleName1) {
		MiddleName1 = middleName1;
	}

	public String getMiddleName2() {
		return MiddleName2;
	}

	public void setMiddleName2(String middleName2) {
		MiddleName2 = middleName2;
	}

	public String MiddleName2;

	public String Gender;

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String Nationality;

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String YearOfBiirth;

	public String getYearOfBiirth() {
		return YearOfBiirth;
	}

	public void setYearOfBiirth(String yearOfBiirth) {
		YearOfBiirth = yearOfBiirth;
	}

	public String MaritalStatus;

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String AccountType;

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public String PreferedLanguage;

	public String getPreferedLanguage() {
		return PreferedLanguage;
	}

	public void setPreferedLanguage(String preferedLanguage) {
		PreferedLanguage = preferedLanguage;
	}

	public String Email;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return AddressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		AddressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return AddressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		AddressLine4 = addressLine4;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String AddressLine1;

	public String AddressLine2;

	public String AddressLine3;

	public String AddressLine4;

	public String Country;

	public String PostalCode;

	public String MobileNo;

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public NewDevice newdeviceDataProvider() {
		NewDevice newdevice = new NewDevice();
		newdevice.setApplicationType(MapUtils.fnGetInputDataFromMap("ApplicationType"));
		newdevice.setApplicationSubType(MapUtils.fnGetInputDataFromMap("ApplicationSubType"));
		newdevice.setBatchType(MapUtils.fnGetInputDataFromMap("BatchType"));
		newdevice.setCustomerType(MapUtils.fnGetInputDataFromMap("CustomerType"));
		newdevice.setEmail(MapUtils.fnGetInputDataFromMap("email"));
		newdevice.setAddressLine1(MapUtils.fnGetInputDataFromMap("AddressLine1"));
		newdevice.setAddressLine2(MapUtils.fnGetInputDataFromMap("AddressLine2"));
		newdevice.setAddressLine3(MapUtils.fnGetInputDataFromMap("AddressLine3"));
		newdevice.setAddressLine4(MapUtils.fnGetInputDataFromMap("AddressLine4"));
		newdevice.setCountry(MapUtils.fnGetInputDataFromMap("Country"));
		newdevice.setPostalCode(MapUtils.fnGetInputDataFromMap("postalCode"));
		newdevice.setTitle(MapUtils.fnGetInputDataFromMap("Title"));
		newdevice.setFirstName(MapUtils.fnGetInputDataFromMap("FirstName"));
		newdevice.setMiddleName1(MapUtils.fnGetInputDataFromMap("MiddleName1"));
		newdevice.setMiddleName2(MapUtils.fnGetInputDataFromMap("MiddleName2"));
		newdevice.setLastName(MapUtils.fnGetInputDataFromMap("LastName"));
		newdevice.setGender(MapUtils.fnGetInputDataFromMap("Gender"));
		newdevice.setNationality(MapUtils.fnGetInputDataFromMap("Nationality"));
		newdevice.setYearOfBiirth(MapUtils.fnGetInputDataFromMap("YearBirth"));
		newdevice.setMaritalStatus(MapUtils.fnGetInputDataFromMap("MaritalStatus"));
		newdevice.setPreferedLanguage(MapUtils.fnGetInputDataFromMap("PreferredLang"));
		newdevice.setMobileNo(MapUtils.fnGetInputDataFromMap("vendorMobileNo1"));

		return newdevice;

	}
}
