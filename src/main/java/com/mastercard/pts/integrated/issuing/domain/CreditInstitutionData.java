package com.mastercard.pts.integrated.issuing.domain;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CreditInstitutionData {
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
	private String code;
	private String abbreviation;
	private String corporateClientCode;
	
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

	public String getIssuerBin() {
		return issuerBin;
	}

	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getCorporateClientCode() {
		return corporateClientCode;
	}

	public void setCorporateClientCode(String corporateClientCode) {
		this.corporateClientCode = corporateClientCode;
	}

	public static CreditInstitutionData createWithProvider(DataProvider provider,String key) {
         return  provider.getDataBySimpleClassNameForInstitute(CreditInstitutionData.class, key);
	}
	
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
