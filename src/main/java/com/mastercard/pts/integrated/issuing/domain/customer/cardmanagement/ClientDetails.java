package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class ClientDetails {
	
	private static final String DEDUPE_TITLE = "TITLE";
	private static final String DEDUPE_FIRST_NAME = "DEDUPE_FIRST_NAME";
	private static final String DEDUPE_LAST_NAME = "DEDUPE_LAST_NAME";
	private static final String DEDUPE_EMAIL = "DEDUPE_EMAIL";

	private String title;	
	private String firstName;	
	private String middleName1;	
	private String middleName2;	
	private String lastName;	
	private String gender;	
	private LocalDate birthDate;	
	private String maritialStatus;	
	private String languagePreference;	
	private String emailId;	
	private String nationality;
	private String clientType;
	private LocalDate dedupeBirthDate;
	private String dedupeFirstName;
	private String dedupeLastName;
	private String dedupeEmailId;
	
	public String getDedupeEmailId() {
		return dedupeEmailId;
	}

	public void setDedupeEmailId(String dedupeEmailId) {
		this.dedupeEmailId = dedupeEmailId;
	}

	public String getDedupeFirstName() {
		return dedupeFirstName;
	}

	public void setDedupeFirstName(String dedupeFirstName) {
		this.dedupeFirstName = dedupeFirstName;
	}

	public String getDedupeLastName() {
		return dedupeLastName;
	}

	public void setDedupeLastName(String dedupeLastName) {
		this.dedupeLastName = dedupeLastName;
	}

	public LocalDate getDedupeBirthDate() {
		return dedupeBirthDate;
	}

	public void setDedupeBirthDate(LocalDate dedupeBirthDate) {
		this.dedupeBirthDate = dedupeBirthDate;
	}

	public static ClientDetails generateClient(KeyValueProvider provider) {
		ClientDetails client = new ClientDetails();
		client.setTitle("Mr. [1]");
		client.setBirthDate(LocalDate.now().minusYears(RandomUtils.nextLong(20, 50)));
		client.setDedupeFirstName("John");
		client.setDedupeLastName("Ted");
		client.setDedupeBirthDate(LocalDate.now().minusYears(29));
		client.setDedupeEmailId("amanullah.pathan@mastercard.com");
		client.setNationality("INDIA [356]");
		client.setMaritialStatus("Married [1]");
		client.setLanguagePreference("English [en]");
		client.setFirstName("John" + MiscUtils.randomAlphabet(4));
		client.setMiddleName1(MiscUtils.randomAlphabet(3) + RandomStringUtils.randomNumeric(2));
		client.setLastName("Snow" + MiscUtils.randomAlphabet(3));
		client.setGender("Male [M]");
		client.setEmailId(RandomStringUtils.randomAlphabetic(8) + "@" + MiscUtils.randomAlphabet(6) + ".com");
		return client;
	}
	
	public static ClientDetails getClientDetails(KeyValueProvider provider) {
		ClientDetails client = new ClientDetails();
		client.setClientType(provider.getString("CLIENT_VIP_FLAG"));
		return client;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	public String getLanguagePreference() {
		return languagePreference;
	}

	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
