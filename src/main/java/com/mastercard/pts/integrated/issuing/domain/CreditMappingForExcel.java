package com.mastercard.pts.integrated.issuing.domain;

import org.springframework.stereotype.Component;

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
	
	private String association;
	private String branch;
	private String card_packid_generation_template;
	private String device_id_generation_template;
	private String device_customer_type;
	private String embossing_vendor;
	private String interchange;
	private String issuer_bin;
	private String plastic_id;
	private String picture_code;
	
	public CreditMappingForExcel createWithProviderForRegression(KeyValueProvider provider) {
		CreditMappingForExcel creditMappingForExcelFromJson=new CreditMappingForExcel();
		creditMappingForExcelFromJson.setBranch(provider.getString(BRANCH));
		creditMappingForExcelFromJson.setAssociation(provider.getString(ASSOCIATION));
		creditMappingForExcelFromJson.setCard_packid_generation_template(provider.getString(CARD_PACKID_GENERATION_TEMPLATE));
		creditMappingForExcelFromJson.setDevice_id_generation_template(provider.getString(DEVICE_ID_GENERATION_TEMPLATE));
		creditMappingForExcelFromJson.setDevice_customer_type(provider.getString(DEVICE_CUSTOMER_TYPE));
		creditMappingForExcelFromJson.setEmbossing_vendor(provider.getString(EMBOSSING_VENDOR));
		creditMappingForExcelFromJson.setInterchange(provider.getString(INTERCHANGE));
		creditMappingForExcelFromJson.setIssuer_bin(provider.getString(ISSUER_BIN));
		creditMappingForExcelFromJson.setPlastic_id(provider.getString(PLASTIC_ID));
		creditMappingForExcelFromJson.setPicture_code(provider.getString(PICTURE_CODE));
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

	public String getCard_packid_generation_template() {
		return card_packid_generation_template;
	}

	public void setCard_packid_generation_template(
			String card_packid_generation_template) {
		this.card_packid_generation_template = card_packid_generation_template;
	}

	public String getDevice_id_generation_template() {
		return device_id_generation_template;
	}

	public void setDevice_id_generation_template(
			String device_id_generation_template) {
		this.device_id_generation_template = device_id_generation_template;
	}
	
	public String getDevice_customer_type() {
		return device_customer_type;
	}

	public void setDevice_customer_type(String device_customer_type) {
		this.device_customer_type = device_customer_type;
	}

	public String getEmbossing_vendor() {
		return embossing_vendor;
	}

	public void setEmbossing_vendor(String embossing_vendor) {
		this.embossing_vendor = embossing_vendor;
	}

	public String getInterchange() {
		return interchange;
	}

	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}

	public String getIssuer_bin() {
		return issuer_bin;
	}

	public void setIssuer_bin(String issuer_bin) {
		this.issuer_bin = issuer_bin;
	}

	public String getPlastic_id() {
		return plastic_id;
	}

	public void setPlastic_id(String plastic_id) {
		this.plastic_id = plastic_id;
	}

	public String getPicture_code() {
		return picture_code;
	}

	public void setPicture_code(String picture_code) {
		this.picture_code = picture_code;
	}

	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
