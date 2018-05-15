package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class EventsAndAlerts {

	private String productType;
	
	private String eventID;
	
	private String eventName;
	
	private String eventType;

	private String emailRecipients;
	private String smsRecipients;
	private String letterRecipients;
	private String language;
	private String emailSubject;
	private String emailMessageBody;
	private String sMSMessageBody;
	private String templateID;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEmailRecipients() {
		return emailRecipients;
	}

	public void setEmailRecipients(String emailRecipients) {
		this.emailRecipients = emailRecipients;
	}

	public String getsMSRecipients() {
		return smsRecipients;
	}

	public void setsMSRecipients(String sMSRecipients) {
		this.smsRecipients = sMSRecipients;
	}

	public String getLetterRecipients() {
		return letterRecipients;
	}

	public void setLetterRecipients(String letterRecipients) {
		this.letterRecipients = letterRecipients;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailMessageBody() {
		return emailMessageBody;
	}

	public void setEmailMessageBody(String emailMessageBody) {
		this.emailMessageBody = emailMessageBody;
	}

	public String getsMSMessageBody() {
		return sMSMessageBody;
	}

	public void setsMSMessageBody(String sMSMessageBody) {
		this.sMSMessageBody = sMSMessageBody;
	}

	public String getTemplateID() {
		return templateID;
	}

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public static EventsAndAlerts createWithProvider(KeyValueProvider provider) {
		EventsAndAlerts eventAndAlert = new EventsAndAlerts();
		eventAndAlert.setEventID("EventID" + CustomUtils.randomNumbers(2));
		eventAndAlert.setEventName("EventName" + CustomUtils.randomNumbers(2));
		eventAndAlert.setProductType(MapUtils
				.fnGetInputDataFromMap("EventProductType"));
		eventAndAlert.setEmailRecipients(MapUtils
				.fnGetInputDataFromMap("EmailRecipients"));
		eventAndAlert.setsMSRecipients(MapUtils
				.fnGetInputDataFromMap("SMSRecipients"));
		eventAndAlert.setLetterRecipients(MapUtils
				.fnGetInputDataFromMap("LetterRecipients"));
		eventAndAlert.setTemplateID("Template"
				+ CustomUtils.randomNumbers(2));
		eventAndAlert.setLanguage(MapUtils.fnGetInputDataFromMap("Language"));
		eventAndAlert.setEmailMessageBody(MapUtils
				.fnGetInputDataFromMap("EmailMessageBody"));
		eventAndAlert.setEmailSubject(MapUtils
				.fnGetInputDataFromMap("EmailSubjectBody"));
		eventAndAlert.setsMSMessageBody(MapUtils
				.fnGetInputDataFromMap("SMSMessageBody"));
		return eventAndAlert;

	}
}
