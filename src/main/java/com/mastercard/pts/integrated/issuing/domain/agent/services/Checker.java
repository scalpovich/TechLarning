package com.mastercard.pts.integrated.issuing.domain.agent.services;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class Checker {
	private static final String APPLICATION_TYPE = "APPLICATION_TYPE";
	private static final String MOBILE_NUMBER = "MOBILE_NUMBER";
	
	private String applicationNumber;
	private String applicationType;
	private String program;
	private String cardPackId;
	private String mobileNumber;
	private String comment;
	private LocalDate effectiveDate;
	
	public static Checker createWithProvider(KeyValueProvider provider) {
		Checker plan = new Checker();
		plan.setEffectiveDate(LocalDate.now().plusDays(0));
		plan.setApplicationType(provider.getString(APPLICATION_TYPE));
		plan.setMobileNumber(provider.getString(MOBILE_NUMBER));
		plan.setComment(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	public String getApplicationNumber() {
		return applicationNumber;
	}
	
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	
	public String getApplicationType() {
		return applicationType;
	}
	
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	
	public String getProgram() {
		return program;
	}
	
	public void setProgram(String program) {
		this.program = program;
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
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@Override
	public String toString() {
		return "Checker [applicationNumber=" + applicationNumber
				+ ", applicationType=" + applicationType + ", program="
				+ program + ", cardPackId=" + cardPackId + ", mobileNumber="
				+ mobileNumber + ", comment=" + comment + ", effectiveDate="
				+ effectiveDate + "]";
	}
}
