package com.mastercard.pts.integrated.issuing.domain.helpdesk;

import org.springframework.stereotype.Component;

//TODO: Auto-generated Javadoc
/**
 * @author E070234, E074127 The Class HelpDeskGeneral.
 */
@Component
public class HelpDeskGeneral {
	public String serviceCode;
	public String productType;
	public String deviceNumber;
	public String noteText;
	public String emailIndicator;
	private String cardPackId;
	private String notes;
	private String eventsIFrameName;
	private String stopListReason;
	private String internationalOperation;
	private String internationActivationType;
	private String noOfWallets;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String formNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getNoOfWallets() {
		return noOfWallets;
	}

	public void setNoOfWallets(String noOfWallets) {
		this.noOfWallets = noOfWallets;
	}

	public String getEmailIndicator() {
		return emailIndicator;
	}

	public void setEmailIndicator(String emailIndicator) {
		this.emailIndicator = emailIndicator;
	}

	public String getCardPackId() {
		return cardPackId;
	}

	public void setCardPackId(String cardPackId) {
		this.cardPackId = cardPackId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getInternationalOperation() {
		return internationalOperation;
	}

	public void setInternationalOperation(String internationalOperation) {
		this.internationalOperation = internationalOperation;
	}

	public String getInternationActivationType() {
		return internationActivationType;
	}

	public void setInternationActivationType(String internationActivationType) {
		this.internationActivationType = internationActivationType;
	}

	public String getStopListReason() {
		return stopListReason;
	}

	public void setStopListReason(String stopListReason) {
		this.stopListReason = stopListReason;
	}

	public String getEventsIFrameName() {
		return eventsIFrameName;
	}

	public void setEventsIFrameName(String eventsIFrameName) {
		this.eventsIFrameName = eventsIFrameName;
	}

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getFormNumber() {
		return formNumber;
	}

	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}
}
