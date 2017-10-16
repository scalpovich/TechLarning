package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class MarketingMessageDetails {
	
	private static final String MMD_EFFECTIVE_DATE = "MMD_EFFECTIVE_DATE";
	
	private static final String MMD_END_DATE = "MMD_END_DATE";
	
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
	
	public static MarketingMessageDetails createWithProviderForDates(KeyValueProvider provider) {
		MarketingMessageDetails details = new MarketingMessageDetails();
		details.setEffectiveDate(LocalDate.now().plusDays(Integer.valueOf(provider.getString(MMD_EFFECTIVE_DATE))));
		details.setEndDate(details.getEffectiveDate().plusDays(Integer.valueOf(provider.getString(MMD_END_DATE))));
		return details;
	}
}
