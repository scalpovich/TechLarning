package com.mastercard.pts.integrated.issuing.domain;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class CreditMappingForExcel {
	private static String ASSOCIATION="ASSOCIATION";
	private static String BRANCH="BRANCH";
	private static String CARD_PACKID_GENERATION_TEMPLATE="CARD_PACKID_GENERATION_TEMPLATE";
	private static String DEVICE_ID_GENERATION_TEMPLATE="DEVICE_ID_GENERATION_TEMPLATE";
	private static String DEVICE_CUSTOMER_TYPE="DEVICE_CUSTOMER_TYPE";
	private static String EMBOSSING_VENDOR="EMBOSSING_VENDOR";
	private static String INTERCHANGE="INTERCHANGE";
	private static String ISSUER_BIN="ISSUER_BIN";
	private static String PLASTIC_ID="PLASTIC_ID";
	private static String PICTURE_CODE="PICTURE_CODE";
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
	private String testing;
	
	public CreditMappingForExcel createWithProviderForRegression(KeyValueProvider provider,DataProvider dataprovider,String institution) {
		CreditMappingForExcel creditMappingForExcelFromJson=new CreditMappingForExcel();
		creditMappingForExcelFromJson.setBranch(provider.getString(BRANCH));
		creditMappingForExcelFromJson.setAssociation(provider.getString(ASSOCIATION));
		creditMappingForExcelFromJson.setCardPackIdGenerationTemplate(provider.getString(CARD_PACKID_GENERATION_TEMPLATE));
		creditMappingForExcelFromJson.setDeviceIdGenerationTemplate(provider.getString(DEVICE_ID_GENERATION_TEMPLATE));
		creditMappingForExcelFromJson.setCustomerType(provider.getString(DEVICE_CUSTOMER_TYPE));
		creditMappingForExcelFromJson.setEmbossingVendor(provider.getString(EMBOSSING_VENDOR));
		creditMappingForExcelFromJson.setInterchange(provider.getString(INTERCHANGE));
		creditMappingForExcelFromJson.setIssuerBin(provider.getString(ISSUER_BIN));
		creditMappingForExcelFromJson.setPlasticId(provider.getString(PLASTIC_ID));
		creditMappingForExcelFromJson.setPictureCode(provider.getString(PICTURE_CODE));
		creditMappingForExcelFromJson.setCorporateClientCode(provider.getString(CORPORATE_CLIENT_CODE));
		creditMappingForExcelFromJson.setTesting(CreditInstitutionData.createWithProvider(dataprovider, institution).getTesting());
		return creditMappingForExcelFromJson;
		
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
	

	public String getTesting() {
		return testing;
	}

	public void setTesting(String testing) {
		this.testing = testing;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
