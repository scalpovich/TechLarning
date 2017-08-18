package com.mastercard.pts.integrated.issuing.domain.agent.services;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class DeviceSale {
	private static final String DEVICE_TYPE = "DEVICE_TYPE";
	private static final String TITLE_XL = "TITLE";
	private static final String MARITAL_STATUS = "MARITAL_STATUS";
	private static final String GENDER_XL = "GENDER";
	private static final String LANGUAGE_PREFERENCE = "LANGUAGE_PREFERENCE";
	private static final String PREFERRED_MAILING_ADDRESS = "PREFERRED_MAILING_ADDRESS";
	private static final String CURRENT_ADDRESS_LINE_1 = "CURRENT_ADDRESS_LINE_1";
	private static final String COUNTRY_XL = "COUNTRY";
	private static final String LEGAL_ID = "LEGAL_ID";
	
	private String program;
	private String deviceType;
	private String cardPackId;
	private String mobileNumber;
	private LocalDate effectiveDate;
	private LocalDate endDate;
	private String title;
	private String firstName;
	private String lastName;
	private String maritalStatus;
	private String gender;
	private String nationality;
	private String languagePreference;
	private String preferredMailingAddress;
	private String currentAddressLine1;
	private String country;
	private String kycremarks;
	private String legalId;
	private String primaryDeviceNumber;
	
	public static DeviceSale createWithProvider(KeyValueProvider provider) {
		DeviceSale plan = new DeviceSale();
		plan.setEffectiveDate(LocalDate.now().plusDays(0));
		plan.setEndDate(plan.getEffectiveDate().plusDays(5));
		plan.setDeviceType(provider.getString(DEVICE_TYPE));
		plan.setTitle(provider.getString(TITLE_XL));
		plan.setMaritalStatus(provider.getString(MARITAL_STATUS));
		plan.setGender(provider.getString(GENDER_XL));
		plan.setNationality(provider.getString(COUNTRY_XL));
		plan.setLanguagePreference(provider.getString(LANGUAGE_PREFERENCE));
		plan.setPreferredMailingAddress(provider.getString(PREFERRED_MAILING_ADDRESS));
		plan.setCurrentAddressLine1(provider.getString(CURRENT_ADDRESS_LINE_1));
		plan.setCountry(provider.getString(COUNTRY_XL));
		plan.setKycremarks(ConstantData.GENERIC_DESCRIPTION);
		plan.setLegalId(provider.getString(LEGAL_ID));
		return plan;
	}
	
	public String getPrimaryDeviceNumber() {
		return primaryDeviceNumber;
	}

	public void setPrimaryDeviceNumber(String primaryDeviceNumber) {
		this.primaryDeviceNumber = primaryDeviceNumber;
	}

	public String getLegalId() {
		return legalId;
	}

	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}

	public String getKycremarks() {
		return kycremarks;
	}

	public void setKycremarks(String kycremarks) {
		this.kycremarks = kycremarks;
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	public String getLanguagePreference() {
		return languagePreference;
	}

	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}

	public String getPreferredMailingAddress() {
		return preferredMailingAddress;
	}

	public void setPreferredMailingAddress(String preferredMailingAddress) {
		this.preferredMailingAddress = preferredMailingAddress;
	}

	public String getCurrentAddressLine1() {
		return currentAddressLine1;
	}

	public void setCurrentAddressLine1(String currentAddressLine1) {
		this.currentAddressLine1 = currentAddressLine1;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getProgram() {
		return program;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	
	public String getDeviceType() {
		return deviceType;
	}
	
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	public String getCardPackId() {
		return cardPackId;
	}
	
	public void setCardPackId(String cardPackId) {
		this.cardPackId = cardPackId;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "DeviceSale [program=" + program + ", deviceType=" + deviceType
				+ ", cardPackId=" + cardPackId + ", mobileNumber="
				+ mobileNumber + ", effectiveDate=" + effectiveDate
				+ ", endDate=" + endDate + ", title=" + title + ", firstName="
				+ firstName + ", lastName=" + lastName + ", maritalStatus="
				+ maritalStatus + ", gender=" + gender + ", nationality="
				+ nationality + ", languagePreference=" + languagePreference
				+ ", preferredMailingAddress=" + preferredMailingAddress
				+ ", currentAddressLine1=" + currentAddressLine1 + ", country="
				+ country + ", kycremarks=" + kycremarks + "]";
	}
}
