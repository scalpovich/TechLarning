package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class NewDevice {

	public String deviceNumber;

	public String batchNum;

	public String applicationType;

	public String applicationSubType;

	public String batchType;

	public String customerType;

	public String deviceType;

	public String title;

	public String firstName;

	public String lastName;

	public String middleName1;

	public String middleName2;

	public String gender;

	public String nationality;

	public String yearOfBiirth;

	public String maritalStatus;

	public String accountType;

	public String preferedLanguage;

	public String email;

	public String addressLine1;

	public String addressLine2;

	public String addressLine3;

	public String addressLine4;

	public String country;

	public String postalCode;

	public String mobileNo;

	public String programForDevice;

	public String product;

	public String devicePlanForDevice;

	public String getDevicePlanForDevice() {
		return devicePlanForDevice;
	}

	public void setDevicePlanForDevice(String devicePlanForDevice) {
		this.devicePlanForDevice = devicePlanForDevice;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProgramForDevice() {
		return programForDevice;
	}

	public void setProgramForDevice(String programForDevice) {
		this.programForDevice = programForDevice;
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

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getApplicationSubType() {
		return applicationSubType;
	}

	public void setApplicationSubType(String applicationSubType) {
		this.applicationSubType = applicationSubType;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName1() {
		return middleName1;
	}

	public void setMiddleName1(String middleName1) {
		this.middleName1 = middleName1;
	}

	public String getMiddleName2() {
		return middleName2;
	}

	public void setMiddleName2(String middleName2) {
		this.middleName2 = middleName2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getYearOfBiirth() {
		return yearOfBiirth;
	}

	public void setYearOfBiirth(String yearOfBiirth) {
		this.yearOfBiirth = yearOfBiirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPreferedLanguage() {
		return preferedLanguage;
	}

	public void setPreferedLanguage(String preferedLanguage) {
		this.preferedLanguage = preferedLanguage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}
