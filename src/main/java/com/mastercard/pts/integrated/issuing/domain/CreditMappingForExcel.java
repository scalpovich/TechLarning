package com.mastercard.pts.integrated.issuing.domain;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class CreditMappingForExcel {
	private static String ASSOCIATION = "ASSOCIATION";
	private static String BRANCH = "BRANCH";
	private static String CARD_PACKID_GENERATION_TEMPLATE = "CARD_PACKID_GENERATION_TEMPLATE";
	private static String DEVICE_ID_GENERATION_TEMPLATE = "DEVICE_ID_GENERATION_TEMPLATE";
	private static String DEVICE_CUSTOMER_TYPE = "DEVICE_CUSTOMER_TYPE";
	private static String EMBOSSING_VENDOR = "EMBOSSING_VENDOR";
	private static String INTERCHANGE = "INTERCHANGE";
	private static String ISSUER_BIN = "ISSUER_BIN";
	private static String PLASTIC_ID = "PLASTIC_ID";
	private static String PICTURE_CODE = "PICTURE_CODE";
	private static String CORPORATE_CLIENT_CODE = "CORPORATE_CLIENT_CODE";

	private String association;
	private String branch;
	private String cardPackIdGenerationTemplate;
	private String deviceIdGenerationTemplate;
	private String customerType;
	private String embossingVendor;
	private String interchange;
	private String issuerBin;
	private String plasticId;
	private String pictureCode;
	private String corporateClientCode;
	private String mastercardPrepaidIssuerBin;
	private String mastercardDebitIssuerBin;
	private String mastercardCreditIssuerBin;
	private String visaPrepaidIssuerBin;
	private String visaDebitIssuerBin;
	private String visaCreditIssuerBin;

	public CreditMappingForExcel createWithProviderCSV(KeyValueProvider provider) {
		CreditMappingForExcel creditMappingCsv = new CreditMappingForExcel();
		/*
		 * creditMappingCsv.setBranch(provider.getString(BRANCH));
		 * creditMappingCsv.setAssociation(provider.getString(ASSOCIATION));
		 * creditMappingCsv.setCardPackIdGenerationTemplate(provider.getString(
		 * CARD_PACKID_GENERATION_TEMPLATE));
		 * creditMappingCsv.setDeviceIdGenerationTemplate(provider.getString(
		 * DEVICE_ID_GENERATION_TEMPLATE));
		 * creditMappingCsv.setCustomerType(provider.getString(
		 * DEVICE_CUSTOMER_TYPE));
		 * creditMappingCsv.setEmbossingVendor(provider.getString(
		 * EMBOSSING_VENDOR));
		 * creditMappingCsv.setInterchange(provider.getString(INTERCHANGE));
		 * creditMappingCsv.setIssuerBin(provider.getString(ISSUER_BIN));
		 * creditMappingCsv.setPlasticId(provider.getString(PLASTIC_ID));
		 * creditMappingCsv.setPictureCode(provider.getString(PICTURE_CODE));
		 * creditMappingCsv.setCorporateClientCode(provider.getString(
		 * CORPORATE_CLIENT_CODE));
		 * creditMappingCsv.setMastercardPrepaidIssuerBin("");
		 * creditMappingCsv.setMastercardDebitIssuerBin("");
		 * creditMappingCsv.setMastercardCreditIssuerBin("");
		 * creditMappingCsv.setVisaPrepaidIssuerBin("");
		 * creditMappingCsv.setVisaDebitIssuerBin("");
		 * creditMappingCsv.setVisaCreditIssuerBin("");
		 */
		return creditMappingCsv;

	}

	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getInterchange() {
		return interchange;
	}

	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}

	public String getIssuerBin() {
		return issuerBin;
	}

	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}

	public String getCardPackIdGenerationTemplate() {
		return cardPackIdGenerationTemplate;
	}

	public void setCardPackIdGenerationTemplate(String cardPackIdGenerationTemplate) {
		this.cardPackIdGenerationTemplate = cardPackIdGenerationTemplate;
	}

	public String getDeviceIdGenerationTemplate() {
		return deviceIdGenerationTemplate;
	}

	public void setDeviceIdGenerationTemplate(String deviceIdGenerationTemplate) {
		this.deviceIdGenerationTemplate = deviceIdGenerationTemplate;
	}

	public String getEmbossingVendor() {
		return embossingVendor;
	}

	public void setEmbossingVendor(String embossingVendor) {
		this.embossingVendor = embossingVendor;
	}

	public String getPlasticId() {
		return plasticId;
	}

	public void setPlasticId(String plasticId) {
		this.plasticId = plasticId;
	}

	public String getPictureCode() {
		return pictureCode;
	}

	public void setPictureCode(String pictureCode) {
		this.pictureCode = pictureCode;
	}

	public String getCorporateClientCode() {
		return corporateClientCode;
	}

	public void setCorporateClientCode(String corporateClientCode) {
		this.corporateClientCode = corporateClientCode;
	}

	public String getMastercardPrepaidIssuerBin() {
		return mastercardPrepaidIssuerBin;
	}

	public void setMastercardPrepaidIssuerBin(String mastercardPrepaidIssuerBin) {
		this.mastercardPrepaidIssuerBin = mastercardPrepaidIssuerBin;
	}

	public String getMastercardDebitIssuerBin() {
		return mastercardDebitIssuerBin;
	}

	public void setMastercardDebitIssuerBin(String mastercardDebitIssuerBin) {
		this.mastercardDebitIssuerBin = mastercardDebitIssuerBin;
	}

	public String getMastercardCreditIssuerBin() {
		return mastercardCreditIssuerBin;
	}

	public void setMastercardCreditIssuerBin(String mastercardCreditIssuerBin) {
		this.mastercardCreditIssuerBin = mastercardCreditIssuerBin;
	}

	public String getVisaPrepaidIssuerBin() {
		return visaPrepaidIssuerBin;
	}

	public void setVisaPrepaidIssuerBin(String visaPrepaidIssuerBin) {
		this.visaPrepaidIssuerBin = visaPrepaidIssuerBin;
	}

	public String getVisaDebitIssuerBin() {
		return visaDebitIssuerBin;
	}

	public void setVisaDebitIssuerBin(String visaDebitIssuerBin) {
		this.visaDebitIssuerBin = visaDebitIssuerBin;
	}

	public String getVisaCreditIssuerBin() {
		return visaCreditIssuerBin;
	}

	public void setVisaCreditIssuerBin(String visaCreditIssuerBin) {
		this.visaCreditIssuerBin = visaCreditIssuerBin;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
