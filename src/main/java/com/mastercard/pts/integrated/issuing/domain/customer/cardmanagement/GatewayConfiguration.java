package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

public class GatewayConfiguration {

	private static final String CONFIGURATION_FOR = "CONFIGURATION_FOR";
	private static final String ACTIVE = "ACTIVE";
	private static final String EMAIL_PROTOCOL = "EMAIL_PROTOCOL";
	private static final String SMTP_IS_CRYPTO_VAULT = "SMTP_IS_CRYPTO_VAULT";	
	private static final String GLOBAL_OUTPUT_CHECK = "GLOBAL_OUTPUT_CHECK";
	private static final String REPORTING = "REPORTING";
	private static final String COPY_TO_SELF = "COPY_TO_SELF";
	private static final String TCP_PORT = "TCP_PORT";
	private static final String SMTP_IS_DEBUG = "SMTP_IS_DEBUG";
	private static final String SMTP_IS_AUTH = "SMTP_IS_AUTH";
	private static final String SMTP_SSL_REQUIRED = "SMTP_SSL_REQUIRED";
	
	private String description;
	private String siteId;
	private String campaignId;
	private String configurationFor;
	private String emailProtocol;
	private String active;
	private String smtpIsCryptoVault;
	private String registrationUserName;
	private String replacementIdentifier;
	private String globalOutputCheck;
	private String reporting;
	private String clientMessageID;
	private String functionalErrorEmail;
	private String copyToSelf;
	private String contactPersonFirstName;
	private String contactPersonLastName;
	private String contactPersonEmail;
	private String emailSenderEmailId;
	private String contactPersonMobile;
	private String emailSenderName;
	private String replyToEmail;
	private String returnToEmail;
	private String esbEndpointUrlEmail;
	private String consumerId;
	private String shortCode;
	private String esbTcpPort;
	private String esbTcpIp;
	private String esbEndpointUrlSms;
	private String smtpHost;
	private String smtpPort;
	private String smtpIsDebug;
	private String smtpIsAuth;
	private String smtpUserName;
	private String smtpPassword;
	private String smtpSslFactory;
	private String smtpSslRequired;
	private String emailSenderEmailIdSmtp;
	private String emailSenderNameSmtp;

	public static GatewayConfiguration getGatewayConfigurationData(KeyValueProvider provider) {
		GatewayConfiguration plan = new GatewayConfiguration();
		String random =  CustomUtils.randomAlphaNumeric(5).toUpperCase();
		plan.setDescription(provider.getString(ConstantData.GENERIC_DESCRIPTION));
		plan.setConfigurationFor(provider.getString(CONFIGURATION_FOR));
		plan.setActive(provider.getString(ACTIVE));
		plan.setEmailProtocol(provider.getString(EMAIL_PROTOCOL));
		plan.setSiteId(random);
		plan.setCampaignId(random);
		plan.setSMTPIsCryptoVault(provider.getString(SMTP_IS_CRYPTO_VAULT));
		plan.setRegistrationUserName(random);
		plan.setReplacementIdentifier(random);
		plan.setGlobalOutputCheck(provider.getString(GLOBAL_OUTPUT_CHECK));
		plan.setReporting(provider.getString(REPORTING));
		plan.setClientMessageID(random);
		plan.setFunctionalErrorEmail(random);
		plan.setCopyToSelf(provider.getString(COPY_TO_SELF));
		plan.setContactPersonFirstName(random);
		plan.setContactPersonLastName(random);
		plan.setContactPersonEmail(ConstantData.VENDOR_MASTER_EMAIL);
		plan.setContactPersonMobile(ConstantData.VENDOR_MASTER_MOBILE_NUMBER);
		plan.setEmailSenderEmailId(ConstantData.VENDOR_MASTER_EMAIL);
		plan.setEmailSenderName(random);
		plan.setReplyToEmail(ConstantData.VENDOR_MASTER_EMAIL);
		plan.setReturnToEmail(ConstantData.VENDOR_MASTER_EMAIL);
		plan.setEsbEndpointUrlEmail(random);
		plan.setConsumerId(random);
		plan.setShortCode(random);
		plan.setEsbTcpIp(provider.getString(TCP_PORT));
		plan.setEsbTcpPort(provider.getString(CustomUtils.randomNumbers(4)));
		plan.setEsbEndpointUrlSms(random);
        plan.setSmtpHost(random);
        plan.setSmtpPort(CustomUtils.randomNumbers(4));
        plan.setSmtpIsDebug(provider.getString(SMTP_IS_DEBUG));
        plan.setSmtpIsAuth(provider.getString(SMTP_IS_AUTH));
        plan.setSmtpUserName(random);
        plan.setSmtpPassword(random);
        plan.setSmtpSslFactory(random);
        plan.setSmtpSslRequired(provider.getString(SMTP_SSL_REQUIRED));
        plan.setEmailSenderEmailIdSmtp(ConstantData.VENDOR_MASTER_EMAIL);
        plan.setEmailSenderNameSmtp(random);
		return plan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	
	public String getCampaignId() {
		return campaignId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
	public void setRegistrationUserName(String registrationUserName) {
		this.registrationUserName = registrationUserName;
	}
	
	public String getRegistrationUserName() {
		return registrationUserName;
	}

	public String getReplacementIdentifier() {
		return replacementIdentifier;
	}

	public void setReplacementIdentifier(String replacementIdentifier) {
		this.replacementIdentifier = replacementIdentifier;
	}

	public String getConfigurationFor() {
		return configurationFor;
	}

	public void setConfigurationFor(String configurationFor) {
		this.configurationFor = configurationFor;
	}

	public String getCopyToSelf() {
		return copyToSelf;
	}

	public void setCopyToSelf(String copyToSelf) {
		this.copyToSelf = copyToSelf;
	}

	public String getEmailProtocol() {
		return emailProtocol;
	}

	public void setEmailProtocol(String emailProtocol) {
		this.emailProtocol = emailProtocol;
	}
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getSMTPIsCryptoVault() {
		return smtpIsCryptoVault;
	}

	public void setSMTPIsCryptoVault(String sMTPIsCryptoVault) {
		smtpIsCryptoVault = sMTPIsCryptoVault;
	}

	public String getGlobalOutputCheck() {
		return globalOutputCheck;
	}

	public void setGlobalOutputCheck(String globalOutputCheck) {
		this.globalOutputCheck = globalOutputCheck;
	}

	public String getReporting() {
		return reporting;
	}

	public void setReporting(String reporting) {
		this.reporting = reporting;
	}

	public String getClientMessageID() {
		return clientMessageID;
	}

	public void setClientMessageID(String clientMessageID) {
		this.clientMessageID = clientMessageID;
	}

	public String getFunctionalErrorEmail() {
		return functionalErrorEmail;
	}

	public void setFunctionalErrorEmail(String functionalErrorEmail) {
		this.functionalErrorEmail = functionalErrorEmail;
	}

	public String getContactPersonFirstName() {
		return contactPersonFirstName;
	}

	public void setContactPersonFirstName(String contactPersonFirstName) {
		this.contactPersonFirstName = contactPersonFirstName;
	}

	public String getContactPersonLastName() {
		return contactPersonLastName;
	}

	public void setContactPersonLastName(String contactPersonLastName) {
		this.contactPersonLastName = contactPersonLastName;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getEmailSenderEmailId() {
		return emailSenderEmailId;
	}

	public void setEmailSenderEmailId(String emailSenderEmailId) {
		this.emailSenderEmailId = emailSenderEmailId;
	}

	public String getContactPersonMobile() {
		return contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}

	public String getEmailSenderName() {
		return emailSenderName;
	}

	public void setEmailSenderName(String emailSenderName) {
		this.emailSenderName = emailSenderName;
	}

	public String getReplyToEmail() {
		return replyToEmail;
	}

	public void setReplyToEmail(String replyToEmail) {
		this.replyToEmail = replyToEmail;
	}

	public String getReturnToEmail() {
		return returnToEmail;
	}

	public void setReturnToEmail(String returnToEmail) {
		this.returnToEmail = returnToEmail;
	}

	public String getEsbEndpointUrlEmail() {
		return esbEndpointUrlEmail;
	}

	public void setEsbEndpointUrlEmail(String esbEndpointUrlEmail) {
		this.esbEndpointUrlEmail = esbEndpointUrlEmail;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getEsbTcpPort() {
		return esbTcpPort;
	}

	public void setEsbTcpPort(String esbTcpPort) {
		this.esbTcpPort = esbTcpPort;
	}

	public String getEsbTcpIp() {
		return esbTcpIp;
	}

	public void setEsbTcpIp(String esbTcpIp) {
		this.esbTcpIp = esbTcpIp;
	}

	public String getEsbEndpointUrlSms() {
		return esbEndpointUrlSms;
	}

	public void setEsbEndpointUrlSms(String esbEndpointUrlSms) {
		this.esbEndpointUrlSms = esbEndpointUrlSms;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getSmtpIsDebug() {
		return smtpIsDebug;
	}

	public void setSmtpIsDebug(String smtpIsDebug) {
		this.smtpIsDebug = smtpIsDebug;
	}

	public String getSmtpIsAuth() {
		return smtpIsAuth;
	}

	public void setSmtpIsAuth(String smtpIsAuth) {
		this.smtpIsAuth = smtpIsAuth;
	}

	public String getSmtpUserName() {
		return smtpUserName;
	}

	public void setSmtpUserName(String smtpUserName) {
		this.smtpUserName = smtpUserName;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	public String getSmtpSslFactory() {
		return smtpSslFactory;
	}

	public void setSmtpSslFactory(String smtpSslFactory) {
		this.smtpSslFactory = smtpSslFactory;
	}

	public String getSmtpSslRequired() {
		return smtpSslRequired;
	}

	public void setSmtpSslRequired(String smtpSslRequired) {
		this.smtpSslRequired = smtpSslRequired;
	}

	public String getEmailSenderEmailIdSmtp() {
		return emailSenderEmailIdSmtp;
	}

	public void setEmailSenderEmailIdSmtp(String emailSenderEmailIdSmtp) {
		this.emailSenderEmailIdSmtp = emailSenderEmailIdSmtp;
	}

	public String getEmailSenderNameSmtp() {
		return emailSenderNameSmtp;
	}

	public void setEmailSenderNameSmtp(String emailSenderNameSmtp) {
		this.emailSenderNameSmtp = emailSenderNameSmtp;
	}


}
