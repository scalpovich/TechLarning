package com.mastercard.pts.integrated.issuing.domain.deviceCreation;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class NewApplication extends AbstractBasePage { 
	
	public String ProductType;
	public String ApplicationType;
	public String SubApplicationType;
	public String createOpenBatch;
	public String CustomerType;
	public String Program;
	public String DeviceType;
	public String DevicePlan; 
	public String DevicephotoIndicator;
	public String Branchcode;
	public String NameTitle;	
	public String FirstName;	
	public String LastName;	
	public String Nationality;	
	public String Gender;
	public String YearBirth;
	public String MaritalStatus;
	public String PreferredLanguage;
	public String PreferredAddress;
	public String AddressLine1;
	public String Country;
	public String postalCode;
	public String NewApplicationName;
	public String CorporateClientCode;
	public String DeviceNumber;
	public String ApplicationNumber;
	
	
	public String getDeviceNumber() {
		return DeviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		DeviceNumber = deviceNumber;
	}
	public String getApplicationNumber() {
		return ApplicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		ApplicationNumber = applicationNumber;
	}
	public String getCorporateClientCode() {
		return CorporateClientCode;
	}
	public void setCorporateClientCode(String corporateClientCode) {
		CorporateClientCode = corporateClientCode;
	}
	public String getNewApplicationName() {
		return NewApplicationName;
	}
	public void setNewApplicationName(String newApplicationName) {
		NewApplicationName = newApplicationName;
	}
	public String MiddleName1;
	public String MiddleName2;
	public String MaidenName;
	public String Birthcountry;
	public String BirthCity;
	public String TravelPurpose;
	public String TravelType;
	public String TravelCountry;
	public String TravelStartDate;
	public String TravelEndDate;
	public String KycStatus;
	public String StmtHardCopyReq;
	public String LanguagePref;
	public String smsAlert;
	public String EmailAlert;
	public String getEmailAlert() {
		return EmailAlert;
	}
	public void setEmailAlert(String emailAlert) {
		EmailAlert = emailAlert;
	}
	public String registeredMobileNo;
	public String registeredEmailID;
	public String RegisterForDncr;
	public String DeliveryMode;
	public String VIPStatus;
	public String Education;
	
	
	
	
	public String getEducation() {
		return Education;
	}
	public void setEducation(String educationDDwn) {
		Education = educationDDwn;
	}
	public String getVIPStatus() {
		return VIPStatus;
	}
	public void setVIPStatus(String vIPStatus) {
		VIPStatus = vIPStatus;
	}
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
	public String getMaidenName() {
		return MaidenName;
	}
	public void setMaidenName(String maidenName) {
		MaidenName = maidenName;
	}
	public String getBirthcountry() {
		return Birthcountry;
	}
	public void setBirthcountry(String birthcountry) {
		Birthcountry = birthcountry;
	}
	public String getBirthCity() {
		return BirthCity;
	}
	public void setBirthCity(String birthCity) {
		BirthCity = birthCity;
	}
	public String getTravelPurpose() {
		return TravelPurpose;
	}
	public void setTravelPurpose(String travelPurpose) {
		TravelPurpose = travelPurpose;
	}
	public String getTravelType() {
		return TravelType;
	}
	public void setTravelType(String travelType) {
		TravelType = travelType;
	}
	public String getTravelCountry() {
		return TravelCountry;
	}
	public void setTravelCountry(String travelCountry) {
		TravelCountry = travelCountry;
	}
	public String getTravelStartDate() {
		return TravelStartDate;
	}
	public void setTravelStartDate(String travelStartDate) {
		TravelStartDate = travelStartDate;
	}
	public String getTravelEndDate() {
		return TravelEndDate;
	}
	public void setTravelEndDate(String travelEndDate) {
		TravelEndDate = travelEndDate;
	}
	public String getKycStatus() {
		return KycStatus;
	}
	public void setKycStatus(String kycStatus) {
		KycStatus = kycStatus;
	}
	public String getStmtHardCopyReq() {
		return StmtHardCopyReq;
	}
	public void setStmtHardCopyReq(String stmtHardCopyReq) {
		StmtHardCopyReq = stmtHardCopyReq;
	}
	public String getLanguagePref() {
		return LanguagePref;
	}
	public void setLanguagePref(String languagePref) {
		LanguagePref = languagePref;
	}
	public String getSmsAlert() {
		return smsAlert;
	}
	public void setSmsAlert(String smsAlert) {
		this.smsAlert = smsAlert;
	}
	public String getRegisteredMobileNo() {
		return registeredMobileNo;
	}
	public void setRegisteredMobileNo(String registeredMobileNo) {
		this.registeredMobileNo = registeredMobileNo;
	}
	public String getRegisteredEmailID() {
		return registeredEmailID;
	}
	public void setRegisteredEmailID(String registeredEmailID) {
		this.registeredEmailID = registeredEmailID;
	}
	public String getRegisterForDncr() {
		return RegisterForDncr;
	}
	public void setRegisterForDncr(String registerForDncr) {
		RegisterForDncr = registerForDncr;
	}
	public String getDeliveryMode() {
		return DeliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		DeliveryMode = deliveryMode;
	}
	
	
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPreferredAddress() {
		return PreferredAddress;
	}
	public void setPreferredAddress(String preferredAddress) {
		PreferredAddress = preferredAddress;
	}
	public String getPreferredLanguage() {
		return PreferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage) {
		PreferredLanguage = preferredLanguage;
	}
	public String getYearBirth() {
		return YearBirth;
	}
	public void setYearBirth(String yearBirth) {
		YearBirth = yearBirth;
	}
	public String getMaritalStatus() {
		return MaritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	public String getCustomerType() {
		return CustomerType;
	}
	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}
	public String getProgram() {
		return Program;
	}
	public void setProgram(String program) {
		Program = program;
	}
	public String getDeviceType() {
		return DeviceType;
	}
	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}
	public String getDevicePlan() {
		return DevicePlan;
	}
	public void setDevicePlan(String devicePlan) {
		DevicePlan = devicePlan;
	}
	public String getDevicephotoIndicator() {
		return DevicephotoIndicator;
	}
	public void setDevicephotoIndicator(String devicephotoIndicator) {
		DevicephotoIndicator = devicephotoIndicator;
	}

	
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	public String getCreateOpenBatch() {
		return createOpenBatch;
	}
	public void setCreateOpenBatch(String createOpenBatch) {
		this.createOpenBatch = createOpenBatch;
	}
	public String getApplicationType() {
		return ApplicationType;
	}
	public void setApplicationType(String applicationType) {
		ApplicationType = applicationType;
	}
	public String getSubApplicationType() {
		return SubApplicationType;
	}
	public void setSubApplicationType(String subApplicationType) {
		SubApplicationType = subApplicationType;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getBranchcode() {
		return Branchcode;
	}
	public void setBranchcode(String branchcode) {
		Branchcode = branchcode;
	}
	public String getNameTitle() {
		return NameTitle;
	}
	public void setNameTitle(String nameTitle) {
		NameTitle = nameTitle;
	}
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
	
	
	public String getNationality() {
		return Nationality;
	}
	public void set(String nationality) {
		Nationality = nationality;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	} 
	
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public void setNewApplicationParameter(){  
		
		setApplicationType(MapUtils.fnGetInputDataFromMap("ApplicationType "));
		setProductType(MapUtils.fnGetInputDataFromMap("ProductType"));
		setSubApplicationType(MapUtils.fnGetInputDataFromMap("ApplicationSubType"));
		setCreateOpenBatch(MapUtils.fnGetInputDataFromMap("BatchType"));
		setCustomerType(MapUtils.fnGetInputDataFromMap("CustomerType"));
		setDevicePlan(MapUtils.fnGetInputDataFromMap("DevicePlan"));
		setDeviceType(MapUtils.fnGetInputDataFromMap("DeviceType"));
		setDevicephotoIndicator(MapUtils.fnGetInputDataFromMap("DevicephotoIndicator"));
		setProgram(MapUtils.fnGetInputDataFromMap("Program")); 
		setNameTitle(MapUtils.fnGetInputDataFromMap("NameTitle"));		
		setFirstName(MapUtils.fnGetInputDataFromMap("FirstName"));		
		setLastName(MapUtils.fnGetInputDataFromMap("LastName"));	
		setNationality(MapUtils.fnGetInputDataFromMap("Nationality"));		
		setGender(MapUtils.fnGetInputDataFromMap("Gender"));
		setYearBirth(MapUtils.fnGetInputDataFromMap("YearBirth"));
		setMaritalStatus(MapUtils.fnGetInputDataFromMap("MaritalStatus"));
		setBranchcode(MapUtils.fnGetInputDataFromMap("Branchcode"));
		setNameTitle(MapUtils.fnGetInputDataFromMap("NameTitle"));
		setPreferredLanguage(MapUtils.fnGetInputDataFromMap("PreferredLang"));
		setPreferredAddress(MapUtils.fnGetInputDataFromMap("PreferredAddress"));
		setAddressLine1(MapUtils.fnGetInputDataFromMap("AddressLine1"));
		setCountry(MapUtils.fnGetInputDataFromMap("Country"));
		setPostalCode(MapUtils.fnGetInputDataFromMap("postalCode"));
		
		
		setMiddleName1(MapUtils.fnGetInputDataFromMap("MiddleName1"));
		setMiddleName2(MapUtils.fnGetInputDataFromMap("MiddleName2"));
		setMaidenName(MapUtils.fnGetInputDataFromMap("MaidenName"));
		setBirthcountry(MapUtils.fnGetInputDataFromMap("Birthcountry"));
		setBirthCity(MapUtils.fnGetInputDataFromMap("BirthCity"));
		setTravelPurpose(MapUtils.fnGetInputDataFromMap("TravelPurpose"));
		setTravelType(MapUtils.fnGetInputDataFromMap("TravelType"));
		setTravelCountry(MapUtils.fnGetInputDataFromMap("TravelCountry"));
		setTravelStartDate(MapUtils.fnGetInputDataFromMap("TravelStartDate"));
		setTravelEndDate(MapUtils.fnGetInputDataFromMap("TravelEndDate"));
		setKycStatus(MapUtils.fnGetInputDataFromMap("KycStatus"));
		setStmtHardCopyReq(MapUtils.fnGetInputDataFromMap("StmtHardCopyReq"));
		setLanguagePref(MapUtils.fnGetInputDataFromMap("LanguagePref"));
		setSmsAlert(MapUtils.fnGetInputDataFromMap("smsAlert"));
		setEmailAlert(MapUtils.fnGetInputDataFromMap("EmailAlert"));
		setRegisteredMobileNo(MapUtils.fnGetInputDataFromMap("registeredMobileNo"));
		setRegisteredEmailID(MapUtils.fnGetInputDataFromMap("registeredEmailID"));
		setRegisterForDncr(MapUtils.fnGetInputDataFromMap("RegisterForDncr"));
		setDeliveryMode(MapUtils.fnGetInputDataFromMap("DeliveryMode"));
		setVIPStatus(MapUtils.fnGetInputDataFromMap("VIPStatus"));
		setEducation(MapUtils.fnGetInputDataFromMap("Education"));
		setCorporateClientCode(MapUtils.fnGetInputDataFromMap("CorporateClientCode"));
		
		
	}
	
	
}
