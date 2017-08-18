package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class MarketingMessageDetails {
	
	private LocalDate effectiveDate;
	
	private LocalDate endDate;

	private String messsageLabel;
	
	private String  message; 
	
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

	public String getMesssageLabel() {
		return messsageLabel;
	}

	public void setMesssageLabel(String messsageLabel) {
		this.messsageLabel = messsageLabel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static MarketingMessageDetails createWithProvider() {
		MarketingMessageDetails details = new MarketingMessageDetails();
		details.setEffectiveDate(LocalDate.now().plusDays(1));
		details.setEndDate(details.getEffectiveDate().plusDays(5));
		details.setMessage("ML" + RandomStringUtils.randomAlphabetic(4));
		details.setMesssageLabel(ConstantData.GENERIC_DESCRIPTION);
		return details;
	}
}
